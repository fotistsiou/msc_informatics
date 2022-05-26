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

namespace WindowsFormsApp4
{
    public partial class Form2 : Form
    {

        String connStr = "Data source=rad2022_4.db;Version=3";
        SQLiteConnection conn;

        private void Form2_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);

        }

        public Form2()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            conn.Open();

            String email = textBox1.Text;
            String password = textBox2.Text;

            String selectSQL = "Select * from User where email=@email and password=@password";

            SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);

            cmd.Parameters.AddWithValue("@email", email);
            cmd.Parameters.AddWithValue("@password", password);

            SQLiteDataReader reader = cmd.ExecuteReader();
            if (reader.Read())
            {
                MessageBox.Show("Login Success!");
                new Form1().Show();
            }
            else
            {
                MessageBox.Show("Wrong email and/or password...");
            }
            reader.Close();
            conn.Close();
        }

        
    }
}
