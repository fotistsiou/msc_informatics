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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (Easy.data != null)
            {
                Form1.maxScoreEasy = Easy.data;
            }
            Easy easy = new Easy();
            easy.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (Hard.data != null)
            {
                Form1.maxScoreHard = Hard.data;
            }
            Hard hard = new Hard();
            hard.Show();
        }
    }
}
