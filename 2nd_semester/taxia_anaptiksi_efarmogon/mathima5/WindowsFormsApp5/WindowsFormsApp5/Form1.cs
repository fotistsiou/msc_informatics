using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Speech.Synthesis;

namespace WindowsFormsApp5
{
    public partial class Form1 : Form
    {
        SpeechSynthesizer engine = new SpeechSynthesizer();
        public Form1()
        {
            InitializeComponent();
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            foreach (var voice in engine.GetInstalledVoices())
            {
                comboBox1.Items.Add(voice.VoiceInfo.Name);
            }

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            engine.Speak(this.textBox1.Text);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            StringBuilder builder = new StringBuilder();
            // var: abstract data type
            foreach(var voice in engine.GetInstalledVoices())
            {
                builder.Append(voice.VoiceInfo.Name).Append(Environment.NewLine);
                builder.Append(voice.VoiceInfo.Culture).Append(Environment.NewLine);
            }
            MessageBox.Show(builder.ToString());
        }

        private void button3_Click(object sender, EventArgs e)
        {
            engine.SelectVoice("Microsoft Mark");
            engine.Speak(this.textBox1.Text);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            engine.SelectVoice(comboBox1.Text);
            engine.Speak(this.textBox1.Text);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            engine.SelectVoice(comboBox1.Text);
            // speak run asynchronus and it is not busy the main thread of app
            engine.SpeakAsync(this.textBox1.Text);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            // engine.Volume = 100;
            engine.Volume = trackBar1.Value;
        }

        private void button7_Click(object sender, EventArgs e)
        {
            engine.Rate = 4;
        }

        private void button8_Click(object sender, EventArgs e)
        {
            axWindowsMediaPlayer1.uiMode = "none";
            axWindowsMediaPlayer1.URL = @"media/example.mp4";
            axWindowsMediaPlayer1.Ctlcontrols.play();
        }

        private void button9_Click(object sender, EventArgs e)
        {
            axWindowsMediaPlayer1.Ctlcontrols.stop();
        }

        private void axWindowsMediaPlayer1_Enter(object sender, EventArgs e)
        {

        }
    }
}
