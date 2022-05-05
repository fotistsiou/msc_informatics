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

namespace WindowsFormsApp3
{
    public partial class Form3 : Form
    {
        Boolean redColor = true;
        Random r;
        int score;
        int maxTime = 20;
        SoundPlayer player = new SoundPlayer("Robot_blip.wav");
        public Form3()
        {
            InitializeComponent();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            //MessageBox.Show("Hello");
            //timer1.Enabled = false;
            /*if (BackColor == Color.Red)
            {
                this.BackColor = Color.Green;
            }
            else 
            { 
                this.BackColor = Color.Red;
            }*/
            if (redColor == true)
            {
                this.BackColor = Color.Green;
                redColor = false;
            }
            else
            {
                this.BackColor = Color.Red;
                redColor = true;
            }

        }

        private void button1_Click(object sender, EventArgs e)
        {
            timer1.Enabled = true;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            /*int randX = r.Next(this.Width - pictureBox1.Width);
            int randY = r.Next(this.Height - pictureBox1.Height);
            pictureBox1.Location = new Point(randX, randY);*/
            timer3.Enabled = true;
            timer2.Enabled = true;

        }

        private void timer2_Tick(object sender, EventArgs e)
        {
            // this.Width = width of Form
            if (pictureBox1.Location.X < this.Width)
            {
                pictureBox1.Location = new Point(pictureBox1.Location.X + 10, pictureBox1.Location.Y);
            }
            else
            {
                /*pictureBox1.Location = new Point(0, pictureBox1.Location.Y);*/
                int randX = r.Next(this.Width - pictureBox1.Width);
                int randY = r.Next(this.Height - pictureBox1.Height);
                pictureBox1.Location = new Point(randX, randY);
            }
            
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            r = new Random();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            score += 10;
            label1.Text = score.ToString();
            player.Play();
        }

        private void timer3_Tick(object sender, EventArgs e)
        {
            maxTime -= 1;
            label2.Text = maxTime.ToString();
            if (maxTime == 0)
            {
                timer3.Enabled = false;
                timer2.Enabled=false;
                pictureBox1.Enabled=false;
                MessageBox.Show("Your score: " + score);
            }
        }
    }
}
