using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SQLite;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DoctorAnyStyle
{
    public partial class ConnectUser3 : Form
    {
        // Create connection string

        String connStr = "Data source=doctorAnyStyle.db;Version=3";

        // Declare and Initialize variables
        SQLiteConnection conn;

        private void ConnectUser3_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
        }

        public ConnectUser3()
        {
            InitializeComponent();

            // Background Form
            this.BackColor = ColorTranslator.FromHtml("#A62349");
            // Labels
            label1.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label2.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label3.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label4.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label5.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label6.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label7.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label8.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label9.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label11.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label12.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label13.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label14.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            // Link Labels
            linkLabel1.LinkColor = ColorTranslator.FromHtml("#00235B");
            linkLabel1.ActiveLinkColor = ColorTranslator.FromHtml("#00235B");
            // Button 1
            button1.BackColor = ColorTranslator.FromHtml("#00235B");
            button1.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            button1.FlatStyle = FlatStyle.Flat;
            button1.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#D8D8D8");
            button1.FlatAppearance.BorderSize = 1;
            // Button 2
            button2.BackColor = ColorTranslator.FromHtml("#00235B");
            button2.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            button2.FlatStyle = FlatStyle.Flat;
            button2.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#D8D8D8");
            button2.FlatAppearance.BorderSize = 1;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String ama = textBox1.Text.Trim();
            String password = textBox2.Text.Trim();
            if (ama != null && password != null && ama != "" && password != "")
            {
                conn.Open();
                String selectSQL = "Select * from Doctor where " + "ama=@ama and password=@password";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                cmd.Parameters.AddWithValue("@ama", ama);
                cmd.Parameters.AddWithValue("@password", password);
                SQLiteDataReader reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    Program.userId = ama;
                    Program.userType = "doctor";
                    MessageBox.Show("Έχετε συνδεθεί επιτυχώς!");
                    new Homepage().Show();
                    this.Hide();
                }
                else
                {
                    MessageBox.Show("Λάθος email ή/και κωδικός πρόσβασης.");
                }
                conn.Close();
            }
            else
            {
                MessageBox.Show("Πρέπει να συμπληρώσετε όλα τα πεδία για να συνεχίσετε.");
            }
        }

        

        private void button2_Click(object sender, EventArgs e)
        {
            String ama = textBox3.Text.Trim();
            String password = textBox4.Text.Trim();
            String name = textBox5.Text.Trim();
            String specialty = textBox6.Text.Trim();
            String tel = textBox7.Text.Trim();
            String email = textBox8.Text.Trim();
            String address = textBox9.Text.Trim();
            String zip = textBox10.Text.Trim();
            String region = textBox11.Text.Trim();

            if (ama != null && password != null && name != null && specialty != null && tel != null && email != null && address != null && zip != null && region != null
                && ama != "" && password != "" && name != "" && specialty != "" && tel != "" && email != "" && address != "" && zip != "" && region != "")
            {
                conn.Open();
                String insertSql = "Insert into Doctor(ama,password,name,specialty,tel,email,address,zip,region) values('" + ama + "','" + password + "','" + name + "','" + specialty + "','" + tel + "','" + email + "','" + address + "','" + zip + "','" + region + "')";
                SQLiteCommand cmd = new SQLiteCommand(insertSql, conn);
                int count = cmd.ExecuteNonQuery();
                if (count > 0)
                {
                    MessageBox.Show("Συγχαρητήρια, ο λογαριασμός σας δημιουργήθηκε με επιτυχία.");
                }    
                conn.Close();
            }
            else
            {
                MessageBox.Show("Πρέπει να συμπληρώσετε όλα τα πεδία για να συνεχίσετε.");
            }
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            new ConnectUser1().Show();
            this.Hide();
        }
    }
}
