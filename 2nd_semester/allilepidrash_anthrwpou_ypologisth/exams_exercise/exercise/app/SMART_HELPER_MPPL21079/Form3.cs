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

namespace SMART_HELPER_MPPL21079
{
    public partial class Form3 : Form
    {
        String connStr = "Data source=SMART_HELPER_MPPL21079.db;Version=3";
        SQLiteConnection conn;
        private void Form3_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
            richTextBox1.Visible = false;
        }
        public Form3()
        {
            InitializeComponent();

            this.BackgroundImage = Properties.Resources.day_plan;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            label2.Visible = false;
            label3.Visible = false;
            label4.Visible = false;
            label5.Visible = false;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            richTextBox1.Visible = true;
            if (comboBox1.Text == "Δευτέρα")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,action,way,proposal FROM program_of_day WHERE day = 'Δευτέρα'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " θα πρέπει να πάς " + reader.GetString(1) + " και αφού θα μετακιμηθεί με " + reader.GetString(2) + " να ξέρει ότι: " + reader.GetString(3) + Environment.NewLine);                  
                }
                conn.Close();
            }
            else if (comboBox1.Text == "Τρίτη")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,action,way,proposal FROM program_of_day WHERE day = 'Τρίτη'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " θα πρέπει να πάς " + reader.GetString(1) + " και αφού θα μετακιμηθεί με " + reader.GetString(2) + " να ξέρει ότι: " + reader.GetString(3) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox1.Text == "Τετάρτη")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,action,way,proposal FROM program_of_day WHERE day = 'Τετάρτη'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " θα πρέπει να πάς " + reader.GetString(1) + " και αφού θα μετακιμηθεί με " + reader.GetString(2) + " να ξέρει ότι: " + reader.GetString(3) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox1.Text == "Πέμπτη")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,action,way,proposal FROM program_of_day WHERE day = 'Πέμπτη'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " θα πρέπει να πάς " + reader.GetString(1) + " και αφού θα μετακιμηθεί με " + reader.GetString(2) + " να ξέρει ότι: " + reader.GetString(3) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox1.Text == "Παρασκευή")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,action,way,proposal FROM program_of_day WHERE day = 'Παρασκευή'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " θα πρέπει να πάς " + reader.GetString(1) + " και αφού θα μετακιμηθεί με " + reader.GetString(2) + " να ξέρει ότι: " + reader.GetString(3) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox1.Text == "Σάβββατο")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,action,way,proposal FROM program_of_day WHERE day = 'Σάβββατο'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " θα πρέπει να πάς " + reader.GetString(1) + " και αφού θα μετακιμηθεί με " + reader.GetString(2) + " να ξέρει ότι: " + reader.GetString(3) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox1.Text == "Κυριακή")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,action,way,proposal FROM program_of_day WHERE day = 'Κυριακή'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " θα πρέπει να πάς " + reader.GetString(1) + " και αφού θα μετακιμηθεί με " + reader.GetString(2) + " να ξέρει ότι: " + reader.GetString(3) + Environment.NewLine);
                }
                conn.Close();
            }
        }

        //Help
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            Help.ShowHelp(this, @".\helper\SMART_HELPER_GUIDE.chm", HelpNavigator.TopicId, "3");
        }
        private void pictureBox2_MouseMove(object sender, MouseEventArgs e)
        {
            label5.Visible = true;
        }
        private void pictureBox2_MouseLeave(object sender, EventArgs e)
        {
            label5.Visible = false;
        }

        // Home
        private void pictureBox3_Click(object sender, EventArgs e)
        {
            new Form1().Show();
        }
        private void pictureBox3_MouseMove(object sender, MouseEventArgs e)
        {
            label2.Visible = true;
        }
        private void pictureBox3_MouseLeave(object sender, EventArgs e)
        {
            label2.Visible = false;
        }

        // Back
        private void pictureBox4_Click(object sender, EventArgs e)
        {
            new Form2().Show();
        }
        private void pictureBox4_MouseMove(object sender, MouseEventArgs e)
        {
            label3.Visible = true;
        }
        private void pictureBox4_MouseLeave(object sender, EventArgs e)
        {
            label3.Visible = false;
        }

        //Exit
        private void pictureBox5_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        private void pictureBox5_MouseMove(object sender, MouseEventArgs e)
        {
            label4.Visible = true;
        }
        private void pictureBox5_MouseLeave(object sender, EventArgs e)
        {
            label4.Visible = false;
        }
    }
}
