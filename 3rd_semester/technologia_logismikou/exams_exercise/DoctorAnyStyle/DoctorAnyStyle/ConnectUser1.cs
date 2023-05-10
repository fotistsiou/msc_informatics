using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SQLite;
using System.Drawing;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DoctorAnyStyle
{
    public partial class ConnectUser1 : Form
    {
        // Create connection string

        String connStr = "Data source=doctorAnyStyle.db;Version=3";

        // Declare and Initialize variables
        SQLiteConnection conn;

        private void ConnectUser1_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
        }

        public ConnectUser1()
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
            // Link Labels
            linkLabel1.LinkColor = ColorTranslator.FromHtml("#00235B");
            linkLabel1.ActiveLinkColor = ColorTranslator.FromHtml("#00235B");
            linkLabel2.LinkColor = ColorTranslator.FromHtml("#00235B");
            linkLabel2.ActiveLinkColor = ColorTranslator.FromHtml("#00235B");
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
            String amka = textBox1.Text.Trim();
            String password = textBox2.Text.Trim();

            if (amka != null && password != null && amka != "" && password != "")

            {
                conn.Open();
                String selectSQL = "Select * from Patient where " + "amka=@amka and password=@password";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                cmd.Parameters.AddWithValue("@amka", amka);
                cmd.Parameters.AddWithValue("@password", password);
                SQLiteDataReader reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    Program.userId = amka;
                    Program.userType = "patient";
                    MessageBox.Show("Έχετε συνδεθεί επιτυχώς.");
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
            this.Hide();
            ConnectUser2 connectUser2 = new ConnectUser2();
            connectUser2.Show();
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            this.Hide();
            ConnectUser3 connectUser3 = new ConnectUser3();
            connectUser3.Show();
        }

        private void linkLabel2_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            this.Hide();
            DoctorsInfo dinfo = new DoctorsInfo();
            dinfo.Show();
        }
    }
}
