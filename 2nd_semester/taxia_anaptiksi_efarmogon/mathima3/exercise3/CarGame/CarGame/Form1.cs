using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CarGame
{
    public partial class Form1 : Form
    {
        public static String userName = "";
        public static DateTime date;
        public static String maxScoreEasy = "0";
        public static String maxScoreHard = "0";

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load_1(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            userName = richTextBox1.Text;
            date = DateTime.Now;

            if (Easy.data != null)
            {
                maxScoreEasy = Easy.data;
                maxScoreHard = Hard.data;
            }

            Form2 f2 = new Form2();
            f2.Show();
        }
    }
}
