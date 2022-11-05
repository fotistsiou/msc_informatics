using System;
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
    public partial class Form13 : Form
    {
        private string[] folderFile = null;
        private int selected = 0;
        private string path = @"../../Resources/SlideShow";

        private void Form13_Load(object sender, EventArgs e)
        {
            timer1.Enabled = true;
            string[] part1 = null, part2 = null, part3 = null;
            part1 = System.IO.Directory.GetFiles(path, "*.jpg");
            part2 = System.IO.Directory.GetFiles(path, "*.png");
            part3 = System.IO.Directory.GetFiles(path, "*.bmp");
            folderFile = new string[part1.Length + part2.Length + part3.Length];
            Array.Copy(part1, 0, folderFile, 0, part1.Length);
            Array.Copy(part2, 0, folderFile, part1.Length, part2.Length);
            Array.Copy(part3, 0, folderFile, part1.Length + part2.Length, part3.Length);
            showImage(folderFile[selected]);            
            if (Program.log_user == 0)
            {
                υπηρεσίεςToolStripMenuItem.Visible = false;
                ημερολόγιοToolStripMenuItem.Visible = false;
                καθηγητέςToolStripMenuItem.Visible = false;
            }
        }

        public Form13()
        {
            InitializeComponent();

            this.BackColor = ColorTranslator.FromHtml("#a22631");

            label1.ForeColor = Color.White;

        }

        private void showImage(string path)
        {
            Image imgtemp = Image.FromFile(path);
            pictureBox1.Width = imgtemp.Width / 2;
            pictureBox1.Height = imgtemp.Height / 2;
            pictureBox1.Image = imgtemp;
        }

        private void nextImage()
        {
            if (selected == folderFile.Length - 1)
            {
                selected = 0;
                showImage(folderFile[selected]);
            }
            else
            {
                selected = selected + 1; showImage(folderFile[selected]);
            }
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            nextImage();
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

        private void Form13_FormClosed(object sender, FormClosedEventArgs e)
        {
            timer1.Enabled = false;
        }
    }
}
