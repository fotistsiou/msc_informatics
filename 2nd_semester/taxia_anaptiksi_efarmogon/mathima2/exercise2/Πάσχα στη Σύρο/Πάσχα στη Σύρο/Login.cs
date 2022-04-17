using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Πάσχα_στη_Σύρο
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "Pasxa" && textBox2.Text == "Syros" && checkBox1.Checked)
            {
                new Form1().Show();
            }
            else
            {
                MessageBox.Show("Προσπαθήστε ξανά. Είτε έχετε συμπληρώσει λάθος στοιχεία είτε δεν έχετε κάνει κλίκ στο 'I_am_not_a_robot'.");
            }
        }

        private void Login_Load(object sender, EventArgs e)
        {
            string allText = File.ReadAllText(@"texts\login.txt", Encoding.UTF8);
            richTextBox1.Text = allText;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                this.BackColor = colorDialog1.Color;
            }
        }
    }
}
