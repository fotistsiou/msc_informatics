﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UNIPI_GUIDE
{
    public partial class Form2 : Form
    {

       // public static int log_user;

        private void Form2_Load(object sender, EventArgs e)
        {
            if (Program.log_user == 0)
            {
                υπηρεσίεςToolStripMenuItem.Visible = false;
                ημερολόγιοToolStripMenuItem.Visible = false;
                καθηγητέςToolStripMenuItem.Visible = false;
                button5.Visible = false;
                button6.Visible = false;
                button7.Visible = false;
            }
        }

        public Form2()
        {
            InitializeComponent();

            this.BackColor = ColorTranslator.FromHtml("#a22631");

            button1.BackColor = ColorTranslator.FromHtml("#222c54");
            button2.BackColor = ColorTranslator.FromHtml("#222c54");
            button3.BackColor = ColorTranslator.FromHtml("#222c54");
            button4.BackColor = ColorTranslator.FromHtml("#222c54");
            button5.BackColor = ColorTranslator.FromHtml("#222c54");
            button6.BackColor = ColorTranslator.FromHtml("#222c54");
            button7.BackColor = ColorTranslator.FromHtml("#222c54");
            button1.ForeColor = Color.White;
            button2.ForeColor = Color.White;
            button3.ForeColor = Color.White;
            button4.ForeColor = Color.White;
            button5.ForeColor = Color.White;
            button6.ForeColor = Color.White;
            button7.ForeColor = Color.White;
        }

        private void βασικέςΠληροφορίεςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form3().Show();
        }

        private void τμήμαΟικονομικήςΕπιστήμηςToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form4().Show();
        }

        private void τμήμαΟργάνωσηςΔιοίκησηςΕπιχειρήσεωνToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Form5().Show();
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

        private void button1_Click(object sender, EventArgs e)
        {
            new Form3().Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            new Form11().Show();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            new Form13().Show();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            new Form14().Show();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            new Form15().Show();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            new Form16().Show();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            new Form17().Show();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
