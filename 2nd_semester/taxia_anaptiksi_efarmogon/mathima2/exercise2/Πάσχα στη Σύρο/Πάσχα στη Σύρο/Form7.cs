using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Media;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Πάσχα_στη_Σύρο
{
    public partial class Form7 : Form
    {
        public Form7()
        {
            InitializeComponent();
        }

        private void αρχικήToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form1 f1 = new Form1();
            f1.Show();
        }

        private void ανασκόπησηToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.Show();
        }

        private void αξιοθέαταToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form3 f3 = new Form3();
            f3.Show();
        }

        private void ιστορίαToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form4 f4 = new Form4();
            f4.Show();
        }

        private void έθιμαToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form5 f5 = new Form5();
            f5.Show();
        }

        private void τοπικάΠροϊόνταToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form6 f6 = new Form6();
            f6.Show();
        }

        private void έξοδοςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form7_Load(object sender, EventArgs e)
        {
            pictureBox1.ImageLocation = @"images/6.jpg";
            string allText = File.ReadAllText(@"texts\mar_vav.txt", Encoding.UTF8);
            richTextBox1.Text = allText;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SoundPlayer play1 = new SoundPlayer("sounds/sound1.wav");
            play1.Play();

        }
        private void button6_Click(object sender, EventArgs e)
        {
            SoundPlayer stop1 = new SoundPlayer();
            stop1.Stop();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            SoundPlayer play2 = new SoundPlayer("sounds/sound2.wav");
            play2.Play();
        }
        private void button5_Click(object sender, EventArgs e)
        {
            SoundPlayer stop2 = new SoundPlayer();
            stop2.Stop();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            SoundPlayer play3 = new SoundPlayer("sounds/sound3.wav");
            play3.Play();
        }
        private void button7_Click(object sender, EventArgs e)
        {
            SoundPlayer stop3 = new SoundPlayer();
            stop3.Stop();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            SoundPlayer play4 = new SoundPlayer("sounds/sound4.wav");
            play4.Play();
        }

        private void button8_Click(object sender, EventArgs e)
        {
            SoundPlayer stop4 = new SoundPlayer();
            stop4.Stop();
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            
        }

        private void button9_Click(object sender, EventArgs e)
        {
            saveFileDialog1.InitialDirectory = Application.StartupPath + "\\texts";
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                richTextBox1.SaveFile(saveFileDialog1.FileName, RichTextBoxStreamType.PlainText);
            }
        }

        private void button10_Click(object sender, EventArgs e)
        {
            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                this.BackColor = colorDialog1.Color;
            }
        }
    }
}
