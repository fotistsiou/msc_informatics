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
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ProgressBar;

namespace DoctorAnyStyle
{
    public partial class Homepage : Form
    {
        // Create connection string
        String connStr = "Data source=doctorAnyStyle.db;Version=3";

        // Initialize variables
        SQLiteConnection conn;
        String speciality;
        String region;

        private void Homepage_Load(object sender, EventArgs e)
        {
            // Check user type & enable/desable buttons
            if (Program.userType == "doctor")
            {
                button3.Visible = false;
            }
            else if (Program.userType == "patient")
            {
                button4.Visible = false;
            }
        }

        public Homepage()
        {
            InitializeComponent();

            // Background Form
            this.BackColor = ColorTranslator.FromHtml("#A62349");
            // Labels
            label1.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
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
            // Button 3
            button3.BackColor = ColorTranslator.FromHtml("#00235B");
            button3.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            button3.FlatStyle = FlatStyle.Flat;
            button3.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#D8D8D8");
            button3.FlatAppearance.BorderSize = 1;
            // Button 4
            button4.BackColor = ColorTranslator.FromHtml("#00235B");
            button4.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            button4.FlatStyle = FlatStyle.Flat;
            button4.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#D8D8D8");
            button4.FlatAppearance.BorderSize = 1;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            new AccountInfo().Show();
            this.Hide();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            new ViewAppointments().Show();
            this.Hide();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            // Connect with DB & run query
            conn = new SQLiteConnection(connStr);
            conn.Open();
            String selectSQL1 = "SELECT DISTINCT Doctor.specialty " +
                                "FROM Doctor " +
                                "JOIN Appointments " +
                                "ON Doctor.ama = Appointments.doctor " +
                                "WHERE Appointments.status = 1 ;";

            SQLiteCommand cmd1 = new SQLiteCommand(selectSQL1, conn);
            SQLiteDataReader reader1 = cmd1.ExecuteReader();
            while (reader1.Read())
            {
                speciality = reader1.GetString(0);
            }
            String selectSQL2 = "SELECT DISTINCT Doctor.region " +
                                "FROM Doctor " +
                                "JOIN Appointments " +
                                "ON Doctor.ama = Appointments.doctor " +
                                "WHERE Appointments.status = 1 ;";
            SQLiteCommand cmd2 = new SQLiteCommand(selectSQL2, conn);
            SQLiteDataReader reader2 = cmd2.ExecuteReader();
            while (reader2.Read())
            {
                region = reader2.GetString(0);
            }
            conn.Close();

            // Check variables value for redirection
            if (speciality != null && region != null)
            {
                new BookAppointment().Show();
                this.Hide();
            } 
            else
            {
                MessageBox.Show("Δεν υπάρχουν διαθέσιμα ραντεβού");
            }
            
        }

        private void button4_Click(object sender, EventArgs e)
        {
            new CreateAppointment().Show();
            this.Hide();
        }
    }
}
