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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            label6.Visible = false;
            label7.Visible = false;

            // Elements Styles
            this.BackColor = ColorTranslator.FromHtml("#D6CDA4");
            //
            button1.BackColor = ColorTranslator.FromHtml("#CFD2CF");
            button1.ForeColor = ColorTranslator.FromHtml("#1C6758");
            button1.FlatStyle = FlatStyle.Flat;
            button1.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#1C6758");            
            //
            button2.BackColor = ColorTranslator.FromHtml("#CFD2CF");
            button2.ForeColor = ColorTranslator.FromHtml("#1C6758");
            button2.FlatStyle = FlatStyle.Flat;
            button2.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#1C6758");
            //
            button3.BackColor = ColorTranslator.FromHtml("#CFD2CF");
            button3.ForeColor = ColorTranslator.FromHtml("#1C6758");
            button3.FlatStyle = FlatStyle.Flat;
            button3.FlatAppearance.BorderColor = ColorTranslator.FromHtml("#1C6758");
            //
            label1.ForeColor = ColorTranslator.FromHtml("#1C6758");
            label2.ForeColor = ColorTranslator.FromHtml("#1C6758");  
        }

        private void button1_Click(object sender, EventArgs e)
        {
            new Form2().Show();
        }
        private void button2_Click(object sender, EventArgs e)
        {
            new Form4().Show();
        }
        private void button3_Click(object sender, EventArgs e)
        {
            new Form9().Show();
        }

        //Help
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            Help.ShowHelp(this, @".\helper\SMART_HELPER_GUIDE.chm", HelpNavigator.TopicId, "1");
        }
        private void pictureBox2_MouseMove(object sender, MouseEventArgs e)
        {
            label6.Visible = true;
        }
        private void pictureBox2_MouseLeave(object sender, EventArgs e)
        {
            label6.Visible = false;
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
    }
}
