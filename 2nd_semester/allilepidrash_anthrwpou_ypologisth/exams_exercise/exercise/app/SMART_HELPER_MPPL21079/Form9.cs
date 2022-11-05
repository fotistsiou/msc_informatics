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
    public partial class Form9 : Form
    {
        public Form9()
        {
            InitializeComponent();

            this.BackgroundImage = Properties.Resources.animals;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            label6.Visible = false;
            label7.Visible = false;
            label9.Visible = false;
        }

        //Help
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            Help.ShowHelp(this, @".\helper\SMART_HELPER_GUIDE.chm", HelpNavigator.TopicId, "9");
        }
        private void pictureBox2_MouseMove(object sender, MouseEventArgs e)
        {
            label6.Visible = true;
        }
        private void pictureBox2_MouseLeave(object sender, EventArgs e)
        {
            label6.Visible = false;
        }

        // Home
        private void pictureBox3_Click(object sender, EventArgs e)
        {
            new Form1().Show();
        }
        private void pictureBox3_MouseMove(object sender, MouseEventArgs e)
        {
            label9.Visible = true;
        }
        private void pictureBox3_MouseLeave(object sender, EventArgs e)
        {
            label9.Visible = false;
        }

        //Exit
        private void pictureBox5_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        private void pictureBox5_MouseMove(object sender, MouseEventArgs e)
        {
            label7.Visible = true;
        }
        private void pictureBox5_MouseLeave(object sender, EventArgs e)
        {
            label7.Visible = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            new Form10().Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            new Form11().Show();
        }
    }
}
