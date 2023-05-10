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
using static System.Windows.Forms.VisualStyles.VisualStyleElement.TaskbarClock;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ToolBar;

namespace DoctorAnyStyle
{
    public partial class CreateAppointment : Form
    {
        // Create connection string
        String connStr = "Data source=doctorAnyStyle.db;Version=3";

        // Declare and Initialize variables
        SQLiteConnection conn;
        String date;
        String doctor = Program.userId;
        int status = 1;
        int flag = 0;

        private void CreateAppointment_Load(object sender, EventArgs e)
        {
            // Connect with DB
            conn = new SQLiteConnection(connStr);
        }

        public CreateAppointment()
        {
            InitializeComponent();

            // Background Form
            this.BackColor = ColorTranslator.FromHtml("#A62349");
            // Labels
            label1.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label2.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label3.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            // Button 1
            button1.BackColor = ColorTranslator.FromHtml("#00235B");
            button1.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            button1.FlatStyle = FlatStyle.Flat;
            button1.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#D8D8D8");
            button1.FlatAppearance.BorderSize = 1;
        }

        private void monthCalendar1_DateSelected(object sender, DateRangeEventArgs e)
        {
            // Initialize variables
            date = monthCalendar1.SelectionRange.Start.ToString("dd/MM/yyyy");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Initialize variables
            String hour = comboBox1.Text;

            // Check the contents of variables & fill comboBoxes
            if (date != null && hour != null && hour != "") {
                conn.Open();
                String selectSQL1 = "SELECT date, hour " +
                                    "FROM Appointments " +
                                    "WHERE doctor ='" + doctor + "' " +
                                    "AND date = '" + date + "' " +
                                    "AND hour = '" + hour + "';";

                SQLiteCommand cmd1 = new SQLiteCommand(selectSQL1, conn);
                SQLiteDataReader reader1 = cmd1.ExecuteReader();
                while (reader1.Read()) {
                    flag = 1;
                }
                conn.Close();
                if (flag == 0) {
                    conn.Open();
                    String insertSQL = "Insert into Appointments(doctor,date,hour,status) " +
                                   "values('" + doctor + "','" + date + "','" + hour + "','" + status + "')";
                    SQLiteCommand cmd = new SQLiteCommand(insertSQL, conn);
                    int count = cmd.ExecuteNonQuery();
                    if (count > 0)
                    {
                        MessageBox.Show("Το νέο σου ραντεβού κατωχηρώθηκε!");
                        new Homepage().Show();
                        this.Hide();
                    }
                    conn.Close();
                } else {
                    MessageBox.Show("Το συγκεκριμένο ραντεβού υπάρχει ήδη.");                  
                    flag = 0;
                }                
            } else {
                MessageBox.Show("Πρέπει να συμπλρωθούν όλα τα πεδία.");
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
