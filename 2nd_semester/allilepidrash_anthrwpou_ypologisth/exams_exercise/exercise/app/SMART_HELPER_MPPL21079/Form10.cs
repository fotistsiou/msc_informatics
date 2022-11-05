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
    public partial class Form10 : Form
    {
        String connStr = "Data source=SMART_HELPER_MPPL21079.db;Version=3";
        SQLiteConnection conn;

        private void Form10_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
            richTextBox1.Clear();
            conn.Open();
            String selectSQL = "SELECT date_time,action FROM animal_control";
            SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
            SQLiteDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                richTextBox1.AppendText(reader.GetString(0) + ": " + reader.GetString(1) + Environment.NewLine);
            }
            conn.Close();
        }

        public Form10()
        {
            InitializeComponent();

            this.BackgroundImage = Properties.Resources.animals;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            label2.Visible = false;
            label3.Visible = false;
            label4.Visible = false;
            label5.Visible = false;
            panel1.Visible = false;
        }

        //Help
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            Help.ShowHelp(this, @".\helper\SMART_HELPER_GUIDE.chm", HelpNavigator.TopicId, "10");
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
            new Form9().Show();
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

        // Room Selector
        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            panel1.Visible = true;
            if (comboBox1.Text == "Υπνοδωμάτιο")
            { 
                    pictureBox6.Image = Properties.Resources.bedroom;
            }
            else if (comboBox1.Text == "Κουζίνα")
            {
                    pictureBox6.Image = Properties.Resources.kitchen;
            }
            else if (comboBox1.Text == "Τουαλέτα")
            {
                    pictureBox6.Image = Properties.Resources.wc;
            }
            else if (comboBox1.Text == "Σαλόνι")
            {
                    pictureBox6.Image = Properties.Resources.living_room;
            }
        }
    }
}
