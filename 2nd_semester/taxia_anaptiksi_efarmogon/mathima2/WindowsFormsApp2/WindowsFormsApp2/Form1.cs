using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Media;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        // 1st way data tranfer (with use public static variable)
        public static String data;

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // 1st way data tranfer (with use public static variable)
            data = textBox1.Text;
            Form2 f2 = new Form2();
            f2.Show();

            // 2nd way data tranfer (with use constractor)
            // Form2 f2 = new Form2(textBox1.Text); 
            // f2.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            // 1st way: Absolute Path (from C: to file) (not good practise)
            // pictureBox1.ImageLocation = @"C:\Users\fotistsiou_personal\source\repos\WindowsFormsApp2\WindowsFormsApp2\bin\Debug\images\download.png";

            // 2nd way: Relative Path (from .exe to file) (good practise)
            pictureBox1.ImageLocation = @"images\download.png";  
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Miaou!");
        }

        private void button3_Click_1(object sender, EventArgs e)
        {
            richTextBox1.LoadFile("text\\text1.txt", RichTextBoxStreamType.PlainText);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            // 1st way (not good practise)
            // colorDialog1.ShowDialog();
            // this.BackColor = colorDialog1.Color;

            // 2nd way (good practise)
            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                this.BackColor = colorDialog1.Color;
            }
            else 
            {
                MessageBox.Show("Cancel");
            }
            
        }

        private void button5_Click_1(object sender, EventArgs e)
        {
            openFileDialog1.InitialDirectory = Application.StartupPath + "\\text"; // path of .exe + concatenate subfile
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                richTextBox1.LoadFile(openFileDialog1.FileName, RichTextBoxStreamType.PlainText);
            }
        }


        private void button6_Click(object sender, EventArgs e)
        {
            if(saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                richTextBox1.SaveFile(saveFileDialog1.FileName, RichTextBoxStreamType.PlainText);
            }
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button7_Click(object sender, EventArgs e)
        {
            SoundPlayer play1 = new SoundPlayer("sound/test.wav");
            play1.Play();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // This code run after load of Form1
            openFileDialog1.InitialDirectory = Application.StartupPath + "\\text"; // path of .exe + concatenate subfile
        }
    }
}
