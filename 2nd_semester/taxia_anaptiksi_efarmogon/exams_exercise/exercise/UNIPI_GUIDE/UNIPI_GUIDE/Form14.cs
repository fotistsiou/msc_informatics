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
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ListView;
using System.Xml.Linq;

namespace UNIPI_GUIDE
{
    public partial class Form14 : Form
    {
        String connStr = "Data source=UNIPI_DUIDE_DB.db;Version=3";
        SQLiteConnection conn;

        private void Form14_Load(object sender, EventArgs e)
        {
            conn = new SQLiteConnection(connStr);

            if (Program.log_user == 0)
            {
                υπηρεσίεςToolStripMenuItem.Visible = false;
                ημερολόγιοToolStripMenuItem.Visible = false;
                καθηγητέςToolStripMenuItem.Visible = false;
                label2.Visible = false;
                button1.Visible = false;
                richTextBox1.Visible = false;
            }

            conn.Open();
            String selectSQL = "SELECT username, comment FROM Blog";
            SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);
            SQLiteDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                richTextBox2.AppendText(reader.GetString(0) + ": " + reader.GetString(1) + Environment.NewLine);
            }
            conn.Close();
        }

        public Form14()
        {
            InitializeComponent();

            this.BackColor = ColorTranslator.FromHtml("#a22631");

            label1.ForeColor = Color.White;
            label2.ForeColor = Color.White;
            label3.ForeColor = Color.White;

            button1.BackColor = ColorTranslator.FromHtml("#222c54");
            button1.ForeColor = Color.White;
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

        private void button1_Click(object sender, EventArgs e)
        {
            conn.Open();
            String username = Program.log_username;
            String comment = richTextBox1.Text;
            String insertSQL = "Insert into Blog(username,comment) values('" + username + "','" + comment + "')";
            SQLiteCommand cmd = new SQLiteCommand(insertSQL, conn);
            int count = cmd.ExecuteNonQuery();
            if (count > 0)
                MessageBox.Show("Το σχόλιό σου καταχωρήθηκε");
            richTextBox2.Clear();
            String selectSQL2 = "SELECT username, comment FROM Blog";
            SQLiteCommand cmd2 = new SQLiteCommand(selectSQL2, conn);
            SQLiteDataReader reader = cmd2.ExecuteReader();
            while (reader.Read())
            {
                richTextBox2.AppendText(reader.GetString(0) + ": " + reader.GetString(1) + Environment.NewLine);
            }
            richTextBox1.Clear();
            conn.Close();
        }
    }
}
