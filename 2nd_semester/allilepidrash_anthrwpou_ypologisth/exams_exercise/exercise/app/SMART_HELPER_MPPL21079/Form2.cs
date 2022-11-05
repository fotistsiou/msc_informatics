using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SQLite;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SMART_HELPER_MPPL21079
{
    public partial class Form2 : Form
    {
        String connStr = "Data source=SMART_HELPER_MPPL21079.db;Version=3";
        SQLiteConnection conn;

        private void Form2_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);
        }

        public Form2()
        {
            InitializeComponent();

            this.BackgroundImage = Properties.Resources.day_plan;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            label6.Visible = false;
            label7.Visible = false;
            label9.Visible = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            conn.Open();
            String day = comboBox1.Text;
            String time = comboBox2.Text;
            String action = comboBox3.Text;
            String way = comboBox4.Text;
            String proposal = "";
            if (action == "Εργασία" && way == "Πόδια") 
            {
                proposal = "Η Εργασία σου απέχει 2 χιλιόμετρα από το Σπίτι σου και 3 χιλιόμετρα από τα Πανεπιστήμιο. Καλό είναι να πάρεις μια μπλούζα να αλλάξεις. Αν δεν έχεις φάει πρωινό να πάρεις από το Palmar ένα σάντουιτς και έναν καφέ.";
            } 
            else if (action == "Εργασία" && way == "Αυτοκίνητο")
            {
                proposal = "Η Εργασία σου απέχει 2 χιλιόμετρα από το Σπίτι σου και 3 χιλιόμετρα από τα Πανεπιστήμιο. Μπορείς να παρκάρεις στο parking απέναντι από την Εργασία σου. Αν δεν έχεις φάει πρωινό να πάρεις από το Palmar ένα σάντουιτς και έναν καφέ.";
            }
            else if (action == "Εργασία" && way == "ΜΜΜ")
            {
                proposal = "Η Εργασία σου απέχει 2 χιλιόμετρα από το Σπίτι σου και 3 χιλιόμετρα από τα Πανεπιστήμιο. Να σταματήσεις στη στάση Ζέρβα. Αν δεν έχεις φάει πρωινό να πάρεις από το Palmar ένα σάντουιτς και έναν καφέ.";
            }
            else if (action == "Πανεπιστήμιο" && way == "Πόδια")
            {
                proposal = "Το Πανεπιστήμιο σου απέχει 2 χιλιόμετρα από το Σπίτι σου και 3 χιλιόμετρα από την Εργασία σου. Καλό είναι να πάρεις μια μπλούζα να αλλάξεις. Αν δεν έχεις φάει πρωινό να πάρεις από το Luma ένα σάντουιτς και έναν καφέ.";
            }
            else if (action == "Πανεπιστήμιο" && way == "Αυτοκίνητο")
            {
                proposal = "Το Πανεπιστήμιο σου απέχει 2 χιλιόμετρα από το Σπίτι σου και 3 χιλιόμετρα από την Εργασία σου. Μπορείς να παρκάρεις στο parking απέναντι από τo Πανεπιστήμιο σου. Αν δεν έχεις φάει πρωινό να πάρεις από το Luma ένα σάντουιτς και έναν καφέ.";
            }
            else if (action == "Πανεπιστήμιο" && way == "ΜΜΜ")
            {
                proposal = "Το Πανεπιστήμιο σου απέχει 2 χιλιόμετρα από το Σπίτι σου και 3 χιλιόμετρα από την Εργασία σου. Να σταματήσεις στη στάση Δημοτικό. Αν δεν έχεις φάει πρωινό να πάρεις από το Luma ένα σάντουιτς και έναν καφέ.";
            }
            else if (action == "Σπίτι" && way == "Πόδια")
            {
                proposal = "Το Σπίτι σου απέχει 2 χιλιόμετρα από το Πανεπιστήμιο σου και 3 χιλιόμετρα από την Εργασία σου. Έχεις και ένα σκύλο να ταϊσεις οπότε μην αργήσεις";
            }
            else if (action == "Σπίτι" && way == "Αυτοκίνητο")
            {
                proposal = "Το Σπίτι σου απέχει 2 χιλιόμετρα από το Πανεπιστήμιο σου και 3 χιλιόμετρα από την Εργασία σου. Έχεις και ένα σκύλο να ταϊσεις οπότε μην αργήσεις";
            }
            else if (action == "Σπίτι" && way == "ΜΜΜ")
            {
                proposal = "Το Σπίτι σου απέχει 2 χιλιόμετρα από το Πανεπιστήμιο σου και 3 χιλιόμετρα από την Εργασία σου. Να σταματήσεις στη στάση Πυροσβεστική. Έχεις και ένα σκύλο να ταϊσεις οπότε μην αργήσεις";
            }
            else if (action == "Ψυχαγωγία" && way == "Πόδια")
            {
                proposal = "Πάρε καλού κακού μια μπλούζα να αλλάξεις. Καλά να περάσεις!";
            }
            else if (action == "Ψυχαγωγία" && way == "Αυτοκίνητο")
            {
                proposal = "Καλό είναι να μην πιεις πάνω από ένα ποτό. Καλά να περάσεις!";
            }
            else if (action == "Ψυχαγωγία" && way == "ΜΜΜ")
            {
                proposal = "Να θυμάσαι ότι τα περισσότερα ΜΜΜ σταματάνε στις 00:00. Καλά να περάσεις!";
            }
            String insertSQL = "Insert into program_of_day(day,time,action,way,proposal) values('" + day + "','" + time + "','" + action + "','" + way + "','" + proposal + "')";
            SQLiteCommand cmd = new SQLiteCommand(insertSQL, conn);
            int count = cmd.ExecuteNonQuery();
            if (count > 0)
                MessageBox.Show("To πλάνο σου ανανεώθηκε!");
            comboBox1.Text = "";
            comboBox2.Text = "";
            comboBox3.Text = "";
            comboBox4.Text = "";
            conn.Close();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            new Form3().Show();
        }

        //Help
        private void pictureBox2_Click(object sender, EventArgs e)
        {
            Help.ShowHelp(this, @".\helper\SMART_HELPER_GUIDE.chm", HelpNavigator.TopicId, "2");
        }
        private void pictureBox2_MouseMove(object sender, MouseEventArgs e)
        {
            label6.Visible = true;
        }
        private void pictureBox2_MouseLeave(object sender, EventArgs e)
        {
            label6.Visible = false;
        }

        // Home
        private void pictureBox3_Click(object sender, EventArgs e)
        {
            new Form1().Show();
        }
        private void pictureBox3_MouseMove(object sender, MouseEventArgs e)
        {
            label9.Visible = true;
        }
        private void pictureBox3_MouseLeave(object sender, EventArgs e)
        {
            label9.Visible = false;
        }

        //Exit
        private void pictureBox5_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        private void pictureBox5_MouseMove(object sender, MouseEventArgs e)
        {
            label7.Visible = true;
        }
        private void pictureBox5_MouseLeave(object sender, EventArgs e)
        {
            label7.Visible = false;
        }
    }
}
