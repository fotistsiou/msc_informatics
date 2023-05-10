using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SQLite;
using System.Text.RegularExpressions;

namespace DoctorAnyStyle
{
    public partial class AccountInfo : Form
    {
        String connStr = "Data source=doctorAnyStyle.db;Version=3";
        SQLiteConnection conn;

        private void AccountInfo_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
            conn.Open();
            if (Program.userType == "doctor")
            {
                String selectSQL1 = "SELECT * " +
                                    "FROM Doctor " +
                                    "WHERE Doctor.ama = '" + Program.userId + "' ;";
                SQLiteCommand cmd1 = new SQLiteCommand(selectSQL1, conn);
                SQLiteDataReader reader1 = cmd1.ExecuteReader();
                while (reader1.Read())
                {
                    textBox1.Text = reader1.GetValue(reader1.GetOrdinal("name")).ToString();
                    textBox2.Text = reader1.GetValue(reader1.GetOrdinal("ama")).ToString();
                    textBox3.Text = reader1.GetValue(reader1.GetOrdinal("password")).ToString();
                    textBox4.Text = reader1.GetValue(reader1.GetOrdinal("tel")).ToString();
                    textBox5.Text = reader1.GetValue(reader1.GetOrdinal("email")).ToString();
                    textBox6.Text = reader1.GetValue(reader1.GetOrdinal("address")).ToString();
                    textBox7.Text = reader1.GetValue(reader1.GetOrdinal("zip")).ToString();
                    textBox8.Text = reader1.GetValue(reader1.GetOrdinal("region")).ToString();
                    textBox9.Text = reader1.GetValue(reader1.GetOrdinal("specialty")).ToString();
                }
                bookAppointmentToolStripMenuItem.Visible = false;
                panel2.Visible = false;
            }
            else
            {
                String selectSQL1 = "SELECT * " +
                                    "FROM Patient " +
                                    "WHERE Patient.amka = '" + Program.userId + "' ;";

                SQLiteCommand cmd1 = new SQLiteCommand(selectSQL1, conn);
                SQLiteDataReader reader1 = cmd1.ExecuteReader();
                while (reader1.Read())
                {
                    textBox10.Text = reader1.GetValue(reader1.GetOrdinal("name")).ToString();
                    textBox13.Text = reader1.GetValue(reader1.GetOrdinal("amka")).ToString();
                    textBox12.Text = reader1.GetValue(reader1.GetOrdinal("password")).ToString();
                    textBox11.Text = reader1.GetValue(reader1.GetOrdinal("tel")).ToString();
                    textBox18.Text = reader1.GetValue(reader1.GetOrdinal("email")).ToString();
                }
                createAppointmentToolStripMenuItem.Visible = false;
                panel1.Visible = false;
            }
            conn.Close();
        }

        public AccountInfo()
        {
            InitializeComponent();

            // Background From
            this.BackColor = ColorTranslator.FromHtml("#A62349");
            // Labels
            label1.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label2.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label3.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label4.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            // Button 1
            button1.BackColor = ColorTranslator.FromHtml("#00235B");
            button1.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            button1.FlatStyle = FlatStyle.Flat;
            button1.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#D8D8D8");
            button1.FlatAppearance.BorderSize = 1;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String d_name = textBox1.Text.Trim();
            String d_ama = textBox2.Text.Trim();
            String d_password = textBox3.Text.Trim();
            String d_tel = textBox4.Text.Trim();
            String d_email = textBox5.Text.Trim();
            String d_address = textBox6.Text.Trim();
            String d_zip = textBox7.Text.Trim();
            String d_region = textBox8.Text.Trim();
            String d_specialty = textBox9.Text.Trim();
            String p_name = textBox10.Text.Trim();
            String p_tel = textBox11.Text.Trim();
            String p_amka = textBox13.Text.Trim();
            String p_pass = textBox12.Text.Trim();
            String p_email = textBox18.Text.Trim();

            SQLiteCommand save = conn.CreateCommand();
            conn.Open();
            if (Program.userType == "doctor" && d_name != null && d_ama != null && d_password != null && d_tel != null && d_email != null &&
            d_address != null && d_zip != null && d_region != null && d_specialty != null && d_name != "" && d_ama != "" && d_password != "" && d_tel != "" && d_email != "" &&
            d_address != "" && d_zip != "" && d_region != "" && d_specialty != "")
            {
                save.CommandText = "UPDATE Doctor " +
                                    "SET name = :named " +
                                    ", ama = :ama " +
                                    ", password = :pass " +
                                    ", tel = :tele " +
                                    ", email = :mail " +
                                    ", address = :address " +
                                    ", zip = :zip " +
                                    ", region = :region " +
                                    ", specialty = :specialty " +
                                    "WHERE ama = :userid";
                save.Parameters.Add("named", DbType.String).Value = d_name;
                save.Parameters.Add("ama", DbType.String).Value = d_ama;
                save.Parameters.Add("pass", DbType.String).Value = d_password;
                save.Parameters.Add("tele", DbType.String).Value = d_tel;
                save.Parameters.Add("mail", DbType.String).Value = d_email;
                save.Parameters.Add("address", DbType.String).Value = d_address;
                save.Parameters.Add("zip", DbType.VarNumeric).Value = d_zip;
                save.Parameters.Add("region", DbType.String).Value = d_region;
                save.Parameters.Add("specialty", DbType.String).Value = d_specialty;
                save.Parameters.Add("userid", DbType.String).Value = Program.userId;
                save.ExecuteNonQuery();
                MessageBox.Show("Τα στοιχεία σου ανανεώθηκαν.");
            }
            else if (Program.userType == "patient" && p_name != null && p_tel != null && p_amka != null && p_pass != null && p_email != null &&
                p_name != "" && p_tel != "" && p_amka != "" && p_pass != "" && p_email != "")
            {
                save.CommandText = "UPDATE Patient " +
                                    "SET name = :named " +
                                    ", amka = :amka " +
                                    ", password = :pass " +
                                    ", tel = :tele " +
                                    ", email = :mail " +
                                    "WHERE amka = :userid";
                save.Parameters.Add("named", DbType.String).Value = p_name;
                save.Parameters.Add("amka", DbType.String).Value = p_amka;
                save.Parameters.Add("pass", DbType.String).Value = p_pass;
                save.Parameters.Add("tele", DbType.String).Value = p_tel;
                save.Parameters.Add("mail", DbType.String).Value = p_email;
                save.Parameters.Add("userid", DbType.String).Value = Program.userId;
                save.ExecuteNonQuery();
                MessageBox.Show("Τα στοιχεία σου ανανεώθηκαν.");
            }
            else
            {
                MessageBox.Show("Παρακαλώ συμπληρώστε όλα τα πεδία.");
            }              
            conn.Close();          
            new Homepage().Show();
            this.Hide();                       
        }
        private void homepageToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Homepage().Show();
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

        private void createAppointmentToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new CreateAppointment().Show();
            this.Hide();
        }

        private void AccountInfo_FormClosed(object sender, FormClosedEventArgs e)
        {
            new Homepage().Show();
        }
    }
}
