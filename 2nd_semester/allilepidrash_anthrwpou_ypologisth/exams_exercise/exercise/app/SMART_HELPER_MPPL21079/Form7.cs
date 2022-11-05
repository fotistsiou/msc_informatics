using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SMART_HELPER_MPPL21079
{
    public partial class Form7 : Form
    {
        int radiator = 0, water_heater = 0, air_conditioner = 0, oven = 0;

        public Form7()
        {
            InitializeComponent();
            this.BackgroundImage = Properties.Resources.remote_control;
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
            Help.ShowHelp(this, @".\helper\SMART_HELPER_GUIDE.chm", HelpNavigator.TopicId, "7");
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
            new Form5().Show();
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

        // Device Selector
        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            panel1.Visible = true;
            if (comboBox1.Text == "Καλοριφέρ")
            {
                if (radiator == 1)
                {
                    pictureBox6.Image = Properties.Resources.radiator;
                    button2.Enabled = true;
                }
                else if (radiator == 0)
                {
                    pictureBox6.Image = Properties.Resources.radiator_off;
                    button1.Enabled = true;
                }
            }
            else if (comboBox1.Text == "Θερμοσίφωνας")
            {
                if (water_heater == 1)
                {
                    pictureBox6.Image = Properties.Resources.water_heater;
                    button2.Enabled = true;
                }
                else if (water_heater == 0)
                {
                    pictureBox6.Image = Properties.Resources.water_heater_off;
                    button1.Enabled = true;
                }
            }
            else if (comboBox1.Text == "Κλιματιστικό")
            {
                if (air_conditioner == 1)
                {
                    pictureBox6.Image = Properties.Resources.air_conditioner;
                    button2.Enabled = true;
                }
                else if (air_conditioner == 0)
                {
                    pictureBox6.Image = Properties.Resources.air_conditioner_off;
                    button1.Enabled = true;
                }
            }
            else if (comboBox1.Text == "Φούρνος")
            {
                if (oven == 1)
                {
                    pictureBox6.Image = Properties.Resources.oven;
                    button2.Enabled = true;
                }
                else if (oven == 0)
                {
                    pictureBox6.Image = Properties.Resources.oven_off;
                    button1.Enabled = true;
                }
            }
        }

        // Switch ON
        private void button1_Click(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Καλοριφέρ")
            {
                pictureBox6.Image = Properties.Resources.radiator;
                radiator = 1;
            }
            else if (comboBox1.Text == "Θερμοσίφωνας")
            {
                pictureBox6.Image = Properties.Resources.water_heater;
                water_heater = 1;
            }
            else if (comboBox1.Text == "Κλιματιστικό")
            {
                pictureBox6.Image = Properties.Resources.air_conditioner;
                air_conditioner = 1;
            }
            else if (comboBox1.Text == "Φούρνος")
            {
                pictureBox6.Image = Properties.Resources.oven;
                oven = 1;
            }
            button1.Enabled = false;
            button2.Enabled = true;
        }

        // Switch OFF
        private void button2_Click(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Καλοριφέρ")
            {
                pictureBox6.Image = Properties.Resources.radiator_off;
                radiator = 0;
            }
            else if (comboBox1.Text == "Θερμοσίφωνας")
            {
                pictureBox6.Image = Properties.Resources.water_heater_off;
                water_heater = 0;
            }
            else if (comboBox1.Text == "Κλιματιστικό")
            {
                pictureBox6.Image = Properties.Resources.air_conditioner_off;
                air_conditioner = 0;
            }
            else if (comboBox1.Text == "Φούρνος")
            {
                pictureBox6.Image = Properties.Resources.oven_off;
                oven = 0;
            }
            button2.Enabled = false;
            button1.Enabled = true;
        }
    }
}
