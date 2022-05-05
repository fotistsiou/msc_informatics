using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp3
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_MouseDown(object sender, MouseEventArgs e)
        {
            richTextBox1.AppendText("Mouse Down at: " + e.X + "," + e.Y + Environment.NewLine);
        }

        private void Form2_MouseUp(object sender, MouseEventArgs e)
        {
            richTextBox1.AppendText("Mouse Up at: " + e.X + "," + e.Y + Environment.NewLine);
        }

        private void Form2_MouseMove(object sender, MouseEventArgs e)
        {
            label1.Text = e.X + "," + e.Y;
        }

        private void Form2_MouseLeave(object sender, EventArgs e)
        {
            label1.Text = "Leave";
        }
    }
}
