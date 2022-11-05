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

namespace UNIPI_GUIDE
{
    public partial class Form1 : Form
    {
        String connStr = "Data source=UNIPI_DUIDE_DB.db;Version=3";
        SQLiteConnection conn;

        private void Form1_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
        }

        public Form1()
        {
            InitializeComponent();

            this.BackColor = ColorTranslator.FromHtml("#a22631");

            label1.ForeColor = Color.White;
            label2.ForeColor = Color.White;
            label3.ForeColor = Color.White;

            button1.BackColor = ColorTranslator.FromHtml("#222c54");
            button2.BackColor = ColorTranslator.FromHtml("#222c54");
            button1.ForeColor = Color.White;
            button2.ForeColor = Color.White;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            conn.Open();

            String username = textBox1.Text;
            String password = textBox2.Text;

            String selectSQL = "Select * from User where username=@username and password=@password";

            SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);

            //cmd.Parameters.AddWithValue("@username", username);
            //cmd.Parameters.AddWithValue("@password", password);

            SQLiteDataReader reader = cmd.ExecuteReader();
            if (reader.Read())
            {
                Program.log_user = 1;
                Program.log_username = username;
                new Form2().Show();
            }
            else
            {
                MessageBox.Show("Wrong email and/or password...");
            }
            reader.Close();
            conn.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Program.log_user = 0;
            new Form2().Show();
        }
    }
}
