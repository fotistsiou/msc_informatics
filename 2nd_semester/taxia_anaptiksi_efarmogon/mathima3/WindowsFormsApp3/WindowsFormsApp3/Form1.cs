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
    public partial class Form1 : Form
    {
        Button button2;
        public Form1()
        {
            InitializeComponent();
            button2 = new Button();
            button2.Text = "Fotis";
            button2.Location = new Point(100, 200);
            button2.Size = new Size(100, 70);
            button2.TabIndex = 2;
            button2.UseVisualStyleBackColor = true;
            Controls.Add(button2);
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void myClick(object sender, EventArgs e)
        {
            MessageBox.Show("Hi!");
        }
        private void button3_Click(object sender, EventArgs e)
        {
            int result = Convert.ToInt32(textBox1.Text);
            for (int i = 0; i < result; i++)
            {
                Button button2;
                button2 = new Button();
                button2.Text = "Fotis";
                button2.Name = "Button " + i + 1;
                button2.Size = new Size(100, 70);
                button2.Location = new Point(600, (i*button2.Height+10));
                button2.TabIndex = 2;
                button2.UseVisualStyleBackColor = true;
                button2.Click += myClick;
                Controls.Add(button2);
            }

        }
    }
}
