using AxWMPLib;
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

namespace UNIPI_GUIDE
{
    public partial class Form16 : Form
    {
        public bool boldDay ;      
        private void Form16_Load(object sender, EventArgs e)
        {
            if (Program.log_user == 0)
            {
                υπηρεσίεςToolStripMenuItem.Visible = false;
                καθηγητέςToolStripMenuItem.Visible = false;
            }
            label3.Visible = false;
            button1.Visible = false;
            button2.Visible = false;
            button3.Visible = false;
            axWindowsMediaPlayer1.Visible = false;
        }

        public Form16()
        {
            InitializeComponent();

            this.BackColor = ColorTranslator.FromHtml("#a22631");
            this.StartPosition = FormStartPosition.CenterScreen;
            label1.ForeColor = Color.White;
            label2.ForeColor = Color.White;
            label3.ForeColor = Color.White;

            monthCalendar1.BoldedDates = new DateTime[]
            {
                DateTime.Today.AddDays(-3),
                DateTime.Today.AddDays(1),
                DateTime.Today.AddDays(2),
                DateTime.Today.AddDays(4),
                DateTime.Today.AddDays(7),
                DateTime.Today.AddDays(10),
                DateTime.Today.AddDays(40)
            };


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

        private void monthCalendar1_DateChanged(object sender, DateRangeEventArgs e)
        {
            if (monthCalendar1.SelectionRange.Start == DateTime.Today.AddDays(-3))
                MessageBox.Show(DateTime.Today.AddDays(-3).ToString().Remove(10) + ": Λειτουργία Εστίας σίτισης φοιτητών.", "Ανακοινώσεις");
            else if (monthCalendar1.SelectionRange.Start == DateTime.Today.AddDays(1))
                MessageBox.Show(DateTime.Today.AddDays(1).ToString().Remove(10) + ": Έναρξη Εξαμήνου, στην ηλ. γραμματεία θα βρείτε το πρόγραμμα εξαμήνου.", "Ανακοινώσεις");
            else if (monthCalendar1.SelectionRange.Start == DateTime.Today.AddDays(2))
                MessageBox.Show(DateTime.Today.AddDays(2).ToString().Remove(10) + ": Ενημέρωση φοιτητών για το νέο πρωτόκολλο COVID και οι κανονισμοί της σχολής.", "Ανακοινώσεις");
            else if (monthCalendar1.SelectionRange.Start == DateTime.Today.AddDays(4))
                MessageBox.Show(DateTime.Today.AddDays(4).ToString().Remove(10) + ": Ενημέρωση φοιτητών, Αμφιθέατρο 106 ΚΕΚΤ, Job Alert Nokia Hellas.", "Ανακοινώσεις");
            else if (monthCalendar1.SelectionRange.Start == DateTime.Today.AddDays(7))
                MessageBox.Show(DateTime.Today.AddDays(7).ToString().Remove(10) + ": Ενημέρωση φοιτητών, πληρωμή διδάκτρων εξαμήνου εως τέλος του μήνα.", "Ανακοινώσεις");
            else if (monthCalendar1.SelectionRange.Start == DateTime.Today.AddDays(10))
                MessageBox.Show(DateTime.Today.AddDays(10).ToString().Remove(10) + ": Ημερίδα με θέμα την ΙΟΤ πόλης, τεχνολογίες smart city.", "Ανακοινώσεις");
            else if (monthCalendar1.SelectionRange.Start == DateTime.Today.AddDays(40))
            {
                label1.Visible = false;
                label2.Visible = false;
                monthCalendar1.Visible = false;
                label3.Visible = true;
                button1.Visible = true;
                button2.Visible = true;
                button3.Visible = true;
                axWindowsMediaPlayer1.Visible = true;
                axWindowsMediaPlayer1.Dock = DockStyle.Fill;
                axWindowsMediaPlayer1.Size = this.Size;
                label3.BackColor = Color.Black;
                axWindowsMediaPlayer1.uiMode = "none";
                axWindowsMediaPlayer1.URL = @"media/example.mp4";
                axWindowsMediaPlayer1.Ctlcontrols.play();
            }
        }

       

        private void button1_Click(object sender, EventArgs e)
        {
            axWindowsMediaPlayer1.uiMode = "none";
            axWindowsMediaPlayer1.URL = @"media/example.mp4";
            axWindowsMediaPlayer1.Ctlcontrols.play();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            axWindowsMediaPlayer1.Ctlcontrols.stop();
        }

        private void axWindowsMediaPlayer1_Enter(object sender, EventArgs e)
        {
            axWindowsMediaPlayer1.uiMode = "none";
            axWindowsMediaPlayer1.URL = @"media/example.mp4";
            axWindowsMediaPlayer1.Ctlcontrols.play();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            axWindowsMediaPlayer1.Ctlcontrols.stop();
            label1.Visible = true;
            label2.Visible = true;
            monthCalendar1.Visible = true;
            label3.Visible = false;
            button1.Visible = false;
            button2.Visible = false;
            button3.Visible = false;
            axWindowsMediaPlayer1.Visible = false;
        }
    }
}
