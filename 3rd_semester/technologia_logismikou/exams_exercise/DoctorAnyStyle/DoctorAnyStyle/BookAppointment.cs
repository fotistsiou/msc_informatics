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
using static System.Data.Entity.Infrastructure.Design.Executor;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace DoctorAnyStyle
{
    public partial class BookAppointment : Form
    {
        // Create connection string
        String connStr = "Data source=doctorAnyStyle.db;Version=3";

        // Declare variables
        SQLiteConnection conn;
        String speciality;
        String region;
        String name;
        String date;
        String hour;
        String symptoms;
        int id;

        private void BookAppointment_Load(object sender, EventArgs e)
        {
            // Connect with DB & run queries
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
                comboBox1.Items.Add(reader1.GetString(0));
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
                comboBox2.Items.Add(reader2.GetString(0));
            }
            conn.Close();

            // Enable/Desable panels
            panel1.Enabled = true;
            panel2.Enabled = false;
            panel3.Enabled = false;
            panel4.Enabled = false;
        }

        public BookAppointment()
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
            // Initialize variables
            speciality = comboBox1.Text.Trim();
            region = comboBox2.Text.Trim();

            // Check the contents of variables & run query
            if (speciality != null && speciality != "" && region != null && region != "")
            {            
                conn.Open();
                String selectSQL = "SELECT DISTINCT Doctor.name " +
                                    "FROM Doctor " +
                                    "JOIN Appointments " +
                                    "ON Doctor.ama = Appointments.doctor " +
                                    "WHERE Doctor.specialty = '" + speciality + "' " +
                                    "AND Doctor.region = '" + region + "' " +
                                    "AND Appointments.status = 1 ;";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    comboBox3.Items.Add(reader.GetString(0));
                }
                conn.Close();

                // Enable/Desable panels
                panel1.Enabled = false;
                panel2.Enabled = true;
            }
            else
            {
                MessageBox.Show("Συμπληρώστε όλα τα πεδία.");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            // Initialize variables
            name = comboBox3.Text.Trim();

            // Check the contents of variables & run query
            if (name != null && name != "")
            {
                conn.Open();
                String selectSQL1 = "SELECT DISTINCT Appointments.date " +
                                   "FROM Appointments " +
                                   "JOIN Doctor " +
                                   "ON Appointments.doctor = Doctor.ama " +
                                   "WHERE Doctor.specialty = '" + speciality + "' " +
                                   "AND Doctor.region = '" + region + "' " +
                                   "AND Doctor.name = '" + name + "' " +
                                   "AND Appointments.status = 1 ;";
                SQLiteCommand cmd1 = new SQLiteCommand(selectSQL1, conn);
                SQLiteDataReader reader1 = cmd1.ExecuteReader();
                while (reader1.Read())
                {
                    comboBox4.Items.Add(reader1.GetString(0));
                }
                String selectSQL2 = "SELECT DISTINCT Appointments.hour " +
                                   "FROM Appointments " +
                                   "JOIN Doctor " +
                                   "ON Appointments.doctor = Doctor.ama " +
                                   "WHERE Doctor.specialty = '" + speciality + "' " +
                                   "AND Doctor.region = '" + region + "' " +
                                   "AND Doctor.name = '" + name + "' " +
                                   "AND Appointments.status = 1 ;";
                SQLiteCommand cmd2 = new SQLiteCommand(selectSQL2, conn);
                SQLiteDataReader reader2 = cmd2.ExecuteReader();
                while (reader2.Read())
                {
                    comboBox5.Items.Add(reader2.GetString(0));
                }
                conn.Close();

                // Enable/Desable panels
                panel2.Enabled = false;
                panel3.Enabled = true;
            }
            else
            {
                MessageBox.Show("Συμπληρώστε όλα τα πεδία.");
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            // Initialize variables
            date = comboBox4.Text.Trim();
            hour = comboBox5.Text.Trim();

            // Check the contents of variables & run query
            if (date != null && date != "" && hour != null && hour != "")
            {
                conn.Open();
                String selectSQL = "SELECT Appointments.ID " +
                                   "FROM Appointments " +
                                   "JOIN Doctor " +
                                   "ON Appointments.doctor = Doctor.ama " +
                                   "WHERE Doctor.specialty = '" + speciality + "' " +
                                   "AND Doctor.region = '" + region + "' " +
                                   "AND Doctor.name = '" + name + "' " +
                                   "AND Appointments.date = '" + date + "' " +
                                   "AND Appointments.hour = '" + hour + "' " +
                                   "AND Appointments.status = 1 ;";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    id = reader.GetInt32(0);
                }
                conn.Close();

                // Enable/Desable panels
                panel3.Enabled = false;
                panel4.Enabled = true;
            }
            else
            {
                MessageBox.Show("Συμπληρώστε όλα τα πεδία.");
            }         
        }

        private void button4_Click(object sender, EventArgs e)
        {
            // Initialize variables
            String test = richTextBox1.Text.Trim();

            // Check the contents of variables & run query
            if (test.Length != 0)
            {
                symptoms = richTextBox1.Text;
                conn.Open();
                String updateSQL = "UPDATE Appointments " +
                                   "SET patient = '" + Program.userId + "' " +
                                   ", symptoms = '" + symptoms + "' " +
                                   ", status = 0 " +
                                   "WHERE ID = '" + id + "' ;";
                SQLiteCommand cmd = new SQLiteCommand(updateSQL, conn);
                int count = cmd.ExecuteNonQuery();
                if (count > 0)
                {
                    MessageBox.Show("Έκλεισε το ραντεβού σου!");
                    new Homepage().Show();
                    this.Hide();
                }
                conn.Close();
            } else
            {
                MessageBox.Show("Πρέπει να συμπληρώσεις την αιτία επίσκεψης.");
            }                   
        }

        private void homepageToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Homepage().Show();
            this.Hide();
        }

        private void accountToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new AccountInfo().Show();
            this.Hide();
        }

        private void viewAppointmentsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new ViewAppointments().Show();
            this.Hide();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
