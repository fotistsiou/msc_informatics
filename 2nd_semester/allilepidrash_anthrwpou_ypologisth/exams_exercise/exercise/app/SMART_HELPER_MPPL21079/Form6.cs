using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SMART_HELPER_MPPL21079
{
    public partial class Form6 : Form
    {
        int bedroom_light = 0, kitchen_light = 0, wc_light = 0, living_light = 0;

        public Form6()
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
            Help.ShowHelp(this, @".\helper\SMART_HELPER_GUIDE.chm", HelpNavigator.TopicId, "6");
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

        // Room Selector
        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            panel1.Visible = true;
            if (comboBox1.Text == "Υπνοδωμάτιο")
            {
                if (bedroom_light == 1)
                {
                    pictureBox6.Image = Properties.Resources.bedroom;
                    button2.Enabled = true;
                }
                else if (bedroom_light == 0)
                {
                    pictureBox6.Image = Properties.Resources.bedroom_off;
                    button1.Enabled = true;
                }
            }
            else if (comboBox1.Text == "Κουζίνα")
            {
                if (kitchen_light == 1)
                {
                    pictureBox6.Image = Properties.Resources.kitchen;
                    button2.Enabled = true;
                }
                else if (kitchen_light == 0)
                {
                    pictureBox6.Image = Properties.Resources.kitchen_off;
                    button1.Enabled = true;
                }
            }
            else if (comboBox1.Text == "Τουαλέτα")
            {
                if (wc_light == 1)
                {
                    pictureBox6.Image = Properties.Resources.wc;
                    button2.Enabled = true;
                }
                else if (wc_light == 0)
                {
                    pictureBox6.Image = Properties.Resources.wc_off;
                    button1.Enabled = true;
                }
            }
            else if (comboBox1.Text == "Σαλόνι")
            {
                if (living_light == 1)
                {
                    pictureBox6.Image = Properties.Resources.living_room;
                    button2.Enabled = true;
                }
                else if (living_light == 0)
                {
                    pictureBox6.Image = Properties.Resources.living_room_off;
                    button1.Enabled = true;
                }
            }
        }

        // Switch ON
        private void button1_Click(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Υπνοδωμάτιο")
            {
                pictureBox6.Image = Properties.Resources.bedroom;
                bedroom_light = 1;
            }
            else if (comboBox1.Text == "Κουζίνα")
            {
                pictureBox6.Image = Properties.Resources.kitchen;
                kitchen_light = 1;
            }
            else if (comboBox1.Text == "Τουαλέτα")
            {
                pictureBox6.Image = Properties.Resources.wc;
                wc_light = 1;
            }
            else if (comboBox1.Text == "Σαλόνι")
            {
                pictureBox6.Image = Properties.Resources.living_room;
                living_light = 1;
            }
            button1.Enabled = false;
            button2.Enabled = true;
        }

        // Switch OFF
        private void button2_Click(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Υπνοδωμάτιο")
            {
                pictureBox6.Image = Properties.Resources.bedroom_off;
                bedroom_light = 0;
            }
            else if (comboBox1.Text == "Κουζίνα")
            {
                pictureBox6.Image = Properties.Resources.kitchen_off;
                kitchen_light = 0;
            }
            else if (comboBox1.Text == "Τουαλέτα")
            {
                pictureBox6.Image = Properties.Resources.wc_off;
                wc_light = 0;
            }
            else if (comboBox1.Text == "Σαλόνι")
            {
                pictureBox6.Image = Properties.Resources.living_room_off;
                living_light = 0;
            }
            button2.Enabled = false;
            button1.Enabled = true;
        }
    }
}
