using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp5
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            webBrowser1.Navigate("https://www.unipi.gr/unipi/el/");
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            // for https://www.unipi.gr/unipi/el/ js errors
            webBrowser1.ScriptErrorsSuppressed = true;
        }
    }
}
