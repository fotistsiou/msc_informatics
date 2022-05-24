using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Media;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CarGame
{
    public partial class Easy : Form
    {
        
        Random rand;
        SoundPlayer player;
        private int timer;
        private int score;
        private int maxScore = Int32.Parse(Form1.maxScoreEasy);
        public static String data;
        private String userName;
        private String saveText;

        public Easy()
        {
            InitializeComponent();
            label5.Text = maxScore.ToString();
            userName = Form1.userName;
            label8.Text = "Hello " + userName + ", you are at the Easy Level of Car Game!";
        }

        private void Easy_Load(object sender, EventArgs e)
        {
            rand = new Random();
            player = new SoundPlayer(@"sounds/blip.wav");
            pictureBox2.Load(@"images/car.png");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            timer1.Start();
            timer2.Start();
            menuStrip1.Visible = false;
            button1.Visible = false;
            button2.Visible = false;
            richTextBox1.Visible = false;
            pictureBox2.Enabled = true;
            label4.Text = "20";
            timer = 20;
            label6.Text = "0";
            score = 0;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            saveFileDialog1.InitialDirectory = Application.StartupPath;
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                richTextBox1.SaveFile(saveFileDialog1.FileName, RichTextBoxStreamType.PlainText);
            }
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            timer -= 1;
            label4.Text = timer.ToString();
            if (timer == 0)
            {
                timer1.Stop();
                timer2.Stop();
                menuStrip1.Visible = true;
                button1.Visible = true;
                button2.Visible = true;
                richTextBox1.Visible = true;
                pictureBox2.Enabled = false;
                saveText = Form1.date + ": "+ userName + " " + score;
                richTextBox1.Text = saveText;
                pictureBox2.Location = new Point(400, 200);
                if (maxScore < score)
                {
                    maxScore = score;
                    label5.Text = maxScore.ToString();
                }
            }   
        }

        private void timer2_Tick(object sender, EventArgs e)
        {
            if (pictureBox2.Location.X < this.Width)
            {
                pictureBox2.Location = new Point(pictureBox2.Location.X + 10, pictureBox2.Location.Y);
            }
            else
            {
                int randX = rand.Next(this.Width - pictureBox2.Width);
                pictureBox2.Location = new Point(randX, pictureBox2.Location.Y);
            }
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            score++;
            label6.Text = score.ToString();
            player.Play();
        }

        private void loginPageToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            data = maxScore.ToString();
            Form1 f1 = new Form1();
            f1.Show();
        }

        private void loginPageToolStripMenuItem_Click(object sender, EventArgs e)
        {
            data = maxScore.ToString();
            Form2 f2 = new Form2();
            f2.Show();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
