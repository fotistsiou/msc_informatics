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
    public partial class DoctorsInfo : Form
    {
        String connStr = "Data source=doctorAnyStyle.db;Version=3";
        SQLiteConnection conn;

        public DoctorsInfo()
        {
            InitializeComponent();

            // Background Form
            this.BackColor = ColorTranslator.FromHtml("#A62349");
            // Labels
            label1.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            label2.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            // Button 1
            button1.BackColor = ColorTranslator.FromHtml("#00235B");
            button1.ForeColor = ColorTranslator.FromHtml("#D8D8D8");
            button1.FlatStyle = FlatStyle.Flat;
            button1.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#D8D8D8");
            button1.FlatAppearance.BorderSize = 1;
            // DataGridView1
            dataGridView1.BackgroundColor = ColorTranslator.FromHtml("#A62349");
        }

        private void DoctorsInfo_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
            conn.Open();
            String selectSQL1 = "SELECT *" +
                                "FROM Doctor;";

            SQLiteCommand cmd1 = new SQLiteCommand(selectSQL1, conn);
            SQLiteDataReader reader1 = cmd1.ExecuteReader();
            while (reader1.Read())
            {
                dataGridView1.Rows.Add(new object[]
                {
                    reader1.GetValue(reader1.GetOrdinal("name")),
                    reader1.GetValue(reader1.GetOrdinal("specialty")),
                    reader1.GetValue(reader1.GetOrdinal("tel")),
                    reader1.GetValue(reader1.GetOrdinal("email")),
                    reader1.GetValue(reader1.GetOrdinal("address")),
                    reader1.GetValue(reader1.GetOrdinal("region"))
                });
            }
            conn.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            new ConnectUser1().Show();
            this.Hide();
        }

        private void DoctorsInfo_FormClosed(object sender, FormClosedEventArgs e)
        {
            new ConnectUser1().Show();
        }
    }
}
