using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        // 2nd way data tranfer (with use constractor)
        // public Form2(String s) 
        // {
        //    InitializeComponent();
        //    label1.Text = s;
        // }

        private void button1_Click(object sender, EventArgs e)
        {
            // 1st way data tranfer (with use public static variable)
            label1.Text = Form1.data;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            new Login().Show();
        }
    }
}
