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

namespace SMART_HELPER_MPPL21079
{
    public partial class Form11 : Form
    {
        String connStr = "Data source=SMART_HELPER_MPPL21079.db;Version=3";
        SQLiteConnection conn;

        private void Form11_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
            richTextBox1.Visible = false;
        }

        public Form11()
        {
            InitializeComponent();

            this.BackgroundImage = Properties.Resources.animals;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            label2.Visible = false;
            label3.Visible = false;
            label4.Visible = false;
            label5.Visible = false;
        }

        //Help
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            Help.ShowHelp(this, @".\helper\SMART_HELPER_GUIDE.chm", HelpNavigator.TopicId, "11");
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

        private void button1_Click(object sender, EventArgs e)
        {
            conn.Open();
            String date = comboBox1.Text;
            String time = comboBox2.Text;
            String food = comboBox3.Text;
            String action = "";
            if (food == "Κονσέρβα")
            {
                action = "Έφαγε τη μισή ποσότητα.";
            }
            else if (food == "Μαγειρευτό")
            {
                action = "Έφαγε ολόκληρη τη ποσότητα.";
            }
            else if (food == "Ξηρά Τροφή")
            {
                action = "Έσπρωξε το πιάτο.";
            }
            else if (food == "Νερό")
            {
                action = "Ήπιε όλο το νερό";
            }
            String insertSQL = "Insert into animal_eat(date,time,food,action) values('" + date + "','" + time + "','" + food + "','" + action + "')";
            SQLiteCommand cmd = new SQLiteCommand(insertSQL, conn);
            int count = cmd.ExecuteNonQuery();
            if (count > 0)
                MessageBox.Show("To διατροφολόγιο ανανεώθηκε!");
            comboBox1.Text = "";
            comboBox2.Text = "";
            comboBox3.Text = "";
            conn.Close();
        }

        private void comboBox4_SelectedIndexChanged(object sender, EventArgs e)
        {
            richTextBox1.Visible = true;
            if (comboBox4.Text == "Δευτέρα")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,food,action FROM animal_eat WHERE date = 'Δευτέρα'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " που έφαγε " + reader.GetString(1) + " αντέδρασε ως εξής: " + reader.GetString(2) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox4.Text == "Τρίτη")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,food,action FROM animal_eat WHERE date = 'Τρίτη'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " που έφαγε " + reader.GetString(1) + " αντέδρασε ως εξής: " + reader.GetString(2) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox4.Text == "Τετάρτη")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,food,action FROM animal_eat WHERE date = 'Τετάρτη'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " που έφαγε " + reader.GetString(1) + " αντέδρασε ως εξής: " + reader.GetString(2) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox4.Text == "Πέμπτη")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,food,action FROM animal_eat WHERE date = 'Πέμπτη'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " που έφαγε " + reader.GetString(1) + " αντέδρασε ως εξής: " + reader.GetString(2) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox4.Text == "Παρασκευή")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,food,action FROM animal_eat WHERE date = 'Παρασκευή'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " που έφαγε " + reader.GetString(1) + " αντέδρασε ως εξής: " + reader.GetString(2) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox4.Text == "Σάβββατο")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,food,action FROM animal_eat WHERE date = 'Σάβββατο'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " που έφαγε " + reader.GetString(1) + " αντέδρασε ως εξής: " + reader.GetString(2) + Environment.NewLine);
                }
                conn.Close();
            }
            else if (comboBox4.Text == "Κυριακή")
            {
                richTextBox1.Clear();
                conn.Open();
                String selectSQL = "SELECT time,food,action FROM animal_eat WHERE date = 'Κυριακή'";
                SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
                SQLiteDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    richTextBox1.AppendText("- Στις " + reader.GetString(0) + " που έφαγε " + reader.GetString(1) + " αντέδρασε ως εξής: " + reader.GetString(2) + Environment.NewLine);
                }
                conn.Close();
            }
        }
    }
}
