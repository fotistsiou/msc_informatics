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

    public partial class ConnectUser2 : Form
    {
        // Create connection string

        String connStr = "Data source=doctorAnyStyle.db;Version=3";

        // Declare and Initialize variables
        SQLiteConnection conn;
        public ConnectUser2()
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

        private void ConnectUser2_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            ConnectUser1 c1 = new ConnectUser1();
            c1.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String amka = textBox1.Text.Trim();
            String password = textBox2.Text.Trim();
            String name = textBox3.Text.Trim();
            String tel = textBox4.Text.Trim();
            String email = textBox5.Text.Trim();
            if (amka != null && password != null && name != null && tel != null && email != null &&
                amka != "" && password != "" && name != "" && tel != "" && email != "")
            {
                conn.Open();
                String insertSql = "INSERT INTO Patient(amka,password,name,tel,email) " +
                                   "VALUES('" + amka + "','" + password + "','" + name + "','" + tel + "','" + email + "')";
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
    }
}
