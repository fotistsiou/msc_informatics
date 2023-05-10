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

namespace DoctorAnyStyle
{
    public partial class ViewAppointments : Form
    {
        String connStr = "Data source=doctorAnyStyle.db;Version=3";
        SQLiteConnection conn;
        

        private void ViewAppointments_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
            conn.Open();
            if (Program.userType == "doctor")
            {
                String selectSQL1 = "SELECT * " +
                                    "FROM Appointments " +
                                    "WHERE doctor = '" + Program.userId + "' ;";

                SQLiteCommand cmd1 = new SQLiteCommand(selectSQL1, conn);
                SQLiteDataReader reader1 = cmd1.ExecuteReader();
                while (reader1.Read())
                {
                    dataGridView1.Rows.Add(new object[]
                    {
                        reader1.GetValue(reader1.GetOrdinal("ID")),
                        reader1.GetValue(reader1.GetOrdinal("doctor")),
                        reader1.GetValue(reader1.GetOrdinal("patient")),
                        reader1.GetValue(reader1.GetOrdinal("date")),
                        reader1.GetValue(reader1.GetOrdinal("hour"))
                    });
                }
                dataGridView1.Columns["Column3"].DefaultCellStyle.NullValue = "Διαθέσιμο";
                bookAppointmentToolStripMenuItem.Visible = false;
                label2.Visible = false;
            }
            else
            {
                String selectSQL1 = "SELECT * " +
                                    "FROM Appointments " +
                                    "WHERE patient = '" + Program.userId + "' ;";

                SQLiteCommand cmd1 = new SQLiteCommand(selectSQL1, conn);
                SQLiteDataReader reader1 = cmd1.ExecuteReader();
                while (reader1.Read())
                {
                    dataGridView1.Rows.Add(new object[]
                    {
                        reader1.GetValue(reader1.GetOrdinal("ID")),
                        reader1.GetValue(reader1.GetOrdinal("doctor")),
                        reader1.GetValue(reader1.GetOrdinal("patient")),
                        reader1.GetValue(reader1.GetOrdinal("date")),
                        reader1.GetValue(reader1.GetOrdinal("hour"))
                    });
                }
                button1.Text = "Cancel";
                createAppointmentToolStripMenuItem.Visible = false;
                label3.Visible = false;
            }
            conn.Close();
        }
        
        public ViewAppointments()
        {
            InitializeComponent();

            // Background From
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
            // DataGridView1
            dataGridView1.BackgroundColor = ColorTranslator.FromHtml("#A62349");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (Program.userType == "doctor")
            {
                conn.Open();
                String deleteSQL = "DELETE FROM Appointments " +
                                   "WHERE ID = '" + dataGridView1.CurrentRow.Cells[0].Value + "' ;";
                SQLiteCommand cmd = new SQLiteCommand(deleteSQL, conn);
                int count = cmd.ExecuteNonQuery();
                if (count > 0)
                {
                    MessageBox.Show("Το ραντεβού σου διαγράφτηκε.");
                    new Homepage().Show();
                    this.Hide();
                }
                conn.Close();
            }
            else
            {
                conn.Open();
                String updateSQL = "UPDATE Appointments " +
                                   "SET patient = '" + null + "' " +
                                   ", symptoms = '" + null + "' " +
                                   ", status = 1 " +
                                   "WHERE ID = '" + dataGridView1.CurrentRow.Cells[0].Value + "' ;";
                SQLiteCommand cmd = new SQLiteCommand(updateSQL, conn);
                int count = cmd.ExecuteNonQuery();
                if (count > 0)
                {
                    MessageBox.Show("Το ραντεβού σου ακυρώθηκε.");
                    new Homepage().Show();
                    this.Hide();
                }
                conn.Close();
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

        private void createAppointmentToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new CreateAppointment().Show();
            this.Hide();
        }

        private void bookAppointmentToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new BookAppointment().Show();
            this.Hide();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void ViewAppointments_FormClosed(object sender, FormClosedEventArgs e)
        {
            new Homepage().Show();
        }
    }

}
