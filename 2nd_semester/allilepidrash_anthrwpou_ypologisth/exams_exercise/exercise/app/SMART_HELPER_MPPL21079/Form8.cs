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
    public partial class Form8 : Form
    {
        public Form8()
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
            Help.ShowHelp(this, @".\helper\SMART_HELPER_GUIDE.chm", HelpNavigator.TopicId, "8");
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
            new Form4().Show();
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

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            panel1.Visible = true;
            if (comboBox1.Text == "Εργασία")
            {
                pictureBox6.Image = Properties.Resources.casual;
                richTextBox1.Text = "Καλό είναι να πάρεις ένα δεύτερο ζευγάρι για να τα εναλλάσεις.";
            }
            else if (comboBox1.Text == "Γυμναστήριο")
            {
                pictureBox6.Image = Properties.Resources.gym;
                richTextBox1.Text = "Θα χρειστείς σύντομα νέο ζευγάρι.";
            }
            else if (comboBox1.Text == "Βραδινή Έξοδος")
            {
                pictureBox6.Image = Properties.Resources.night_out;
                richTextBox1.Text = "Να θυμηθείς να τα βάλεις στο πλυντήριο.";
            }
            else if (comboBox1.Text == "Επίσημη Εμφάνιση")
            {
                pictureBox6.Image = Properties.Resources.formal;
                richTextBox1.Text = "Να τα γυαλίσεις πριν τα φορέσεις.";
            }
        }
    }
}
