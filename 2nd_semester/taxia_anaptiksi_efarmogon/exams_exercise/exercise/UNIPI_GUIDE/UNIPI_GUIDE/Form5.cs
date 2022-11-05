using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Reflection.Emit;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UNIPI_GUIDE
{
    public partial class Form5 : Form
    {
        private void Form5_Load(object sender, EventArgs e)
        {
            if (Program.log_user == 0)
            {
                υπηρεσίεςToolStripMenuItem.Visible = false;
                ημερολόγιοToolStripMenuItem.Visible = false;
                καθηγητέςToolStripMenuItem.Visible = false;
            }
        }

        public Form5()
        {
            InitializeComponent();

            this.BackColor = ColorTranslator.FromHtml("#a22631");

            label1.ForeColor = Color.White;

        }

        private void αρχικήToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form2().Show();
        }

        private void βασικέςΠληροφορίεςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form3().Show();
        }

        private void τμήμαΟικονομικήςΕπιστήμηςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form4().Show();
        }

        private void τμήμαΔιεθνώνΕυρωπαϊκώνΣπουδώνToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form6().Show();
        }

        private void τμήμαΝαυτιλιακώνΣπουδώνToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form7().Show();
        }

        private void τμήμαΒιομηχανικήςΔιοίκησηςΤεχνολογίαςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form8().Show();
        }

        private void τμήμαΧρηματοοικονομικήςΤραπεζικήςΔιοικητικήςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form9().Show();
        }

        private void τμήμαΣτατιστικήςΑσφαλιστικήςΕπιστήμηςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form10().Show();
        }

        private void τμήμαΠληροφορικήςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form11().Show();
        }

        private void τμήμαΨηφιακώνΣυστημάτωνToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form12().Show();
        }

        private void φωτογραφίεςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form13().Show();
        }

        private void blogToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form14().Show();
        }

        private void υπηρεσίεςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form15().Show();
        }

        private void ημερολόγιοToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form16().Show();
        }

        private void καθηγητέςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form17().Show();
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form18().Show();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void richTextBox2_LinkClicked(object sender, LinkClickedEventArgs e)
        {
            Process.Start("MicrosoftEdge.exe", e.LinkText);
        }
    }
}
