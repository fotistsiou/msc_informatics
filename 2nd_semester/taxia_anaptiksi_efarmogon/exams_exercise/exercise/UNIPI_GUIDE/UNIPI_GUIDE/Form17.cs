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
using System.Runtime.InteropServices;

namespace UNIPI_GUIDE
{
    public partial class Form17 : Form
    {
        private void Form17_Load(object sender, EventArgs e)
        {
            if (Program.log_user == 0)
            {
                υπηρεσίεςToolStripMenuItem.Visible = false;
                ημερολόγιοToolStripMenuItem.Visible = false;
            }
            for (int i = 0; i <= 9; i++)
            {
                dataGridView1.Rows.Add("");
            }
            
            //
            dataGridView1.Rows[0].Cells[0].Value = "Αλέπης Ευθύμιος";
            dataGridView1.Rows[0].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[0].Cells[2].Value = "Αναπληρωτής Καθηγητής";
            dataGridView1.Rows[0].Cells[3].Value = "540/ΚΕΚΤ";
            dataGridView1.Rows[0].Cells[4].Value = "210 4142311";
            dataGridView1.Rows[0].Cells[5].Value = "talepis@unipi.gr";
            //
            dataGridView1.Rows[1].Cells[0].Value = "Βίρβου Μαρία";
            dataGridView1.Rows[1].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[1].Cells[2].Value = "Καθηγητής";
            dataGridView1.Rows[1].Cells[3].Value = "507/ΚΕΚΤ";
            dataGridView1.Rows[1].Cells[4].Value = "210 4142269";
            dataGridView1.Rows[1].Cells[5].Value = "mvirvou@unipi.gr";
            //
            dataGridView1.Rows[2].Cells[0].Value = "Δουληγέρης Χρήστος";
            dataGridView1.Rows[2].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[2].Cells[2].Value = "Καθηγητής";
            dataGridView1.Rows[2].Cells[3].Value = "302/ΚΕΚΤ";
            dataGridView1.Rows[2].Cells[4].Value = "210 4142137";
            dataGridView1.Rows[2].Cells[5].Value = "cdoulig@unipi.gr";
            //
            dataGridView1.Rows[3].Cells[0].Value = "Θεοδωρίδης Ιωάννης";
            dataGridView1.Rows[3].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[3].Cells[2].Value = "Καθηγητής";
            dataGridView1.Rows[3].Cells[3].Value = "501/ΚΕΚΤ";
            dataGridView1.Rows[3].Cells[4].Value = "210 4142449";
            dataGridView1.Rows[3].Cells[5].Value = "ytheod@unipi.gr";
            //
            dataGridView1.Rows[4].Cells[0].Value = "Παναγιωτόπουλος Θεμιστοκλής";
            dataGridView1.Rows[4].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[4].Cells[2].Value = "Καθηγητής";
            dataGridView1.Rows[4].Cells[3].Value = "541/ΚΕΚΤ";
            dataGridView1.Rows[4].Cells[4].Value = "210 4142146";
            dataGridView1.Rows[4].Cells[5].Value = "themisp@unipi.gr";
            //
            dataGridView1.Rows[5].Cells[0].Value = "Πικράκης Άγγελος";
            dataGridView1.Rows[5].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[5].Cells[2].Value = "Επίκουρος Καθηγητής"; 
            dataGridView1.Rows[5].Cells[3].Value = "540/ΚΕΚΤ";
            dataGridView1.Rows[5].Cells[4].Value = "210 4142128";
            dataGridView1.Rows[5].Cells[5].Value = "pikrakis@unipi.gr";
            //
            dataGridView1.Rows[6].Cells[0].Value = "Πατσάκης Κωνσταντίνος";
            dataGridView1.Rows[6].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[6].Cells[2].Value = "Αναπληρωτής Καθηγητής";
            dataGridView1.Rows[6].Cells[3].Value = "540/ΚΕΚΤ";
            dataGridView1.Rows[6].Cells[4].Value = "210 4142261";
            dataGridView1.Rows[6].Cells[5].Value = "kpatsak@unipi.gr";
            //
            dataGridView1.Rows[7].Cells[0].Value = "Σακκόπουλος Ευάγγελος";
            dataGridView1.Rows[7].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[7].Cells[2].Value = "Αναπληρωτής Καθηγητής";
            dataGridView1.Rows[7].Cells[3].Value = "543/ΚΕΚΤ";
            dataGridView1.Rows[7].Cells[4].Value = "210 4142312";
            dataGridView1.Rows[7].Cells[5].Value = "sakkopul@unipi.gr";
            //
            dataGridView1.Rows[8].Cells[0].Value = "Τασούλας Ιωάννης";
            dataGridView1.Rows[8].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[8].Cells[2].Value = "Επίκουρος Καθηγητής";
            dataGridView1.Rows[8].Cells[3].Value = "542/ΚΕΚΤ";
            dataGridView1.Rows[8].Cells[4].Value = "210 4142313";
            dataGridView1.Rows[8].Cells[5].Value = "jtas@unipi.gr";
            //
            dataGridView1.Rows[9].Cells[0].Value = "Τσιχριντζής Γεώργιος";
            dataGridView1.Rows[9].Cells[1].Value = "Τμήμα Πληροφορικής";
            dataGridView1.Rows[9].Cells[2].Value = "Καθηγητής";
            dataGridView1.Rows[9].Cells[3].Value = "506/ΚΕΚΤ";
            dataGridView1.Rows[9].Cells[4].Value = "210 4142322";
            dataGridView1.Rows[9].Cells[5].Value = "geoatsi@unipi.gr";
            //
        }

        public Form17()
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
            string line;
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();
            saveFileDialog1.AddExtension = true;
            saveFileDialog1.DefaultExt = "txt";
            saveFileDialog1.Filter = "Text files (*.txt)|*.txt|All files (*.*)|*.*";
            saveFileDialog1.InitialDirectory = Application.StartupPath + "\\Records";

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                StreamWriter record = new StreamWriter(saveFileDialog1.FileName);

                record.Write("  ");
                line = dataGridView1.Columns[0].HeaderCell.Value.ToString();
                record.Write(line.PadRight(30));
                line = dataGridView1.Columns[1].HeaderCell.Value.ToString();
                record.Write(line.PadRight(30));
                line = dataGridView1.Columns[2].HeaderCell.Value.ToString();
                record.Write(line.PadRight(30));
                line = dataGridView1.Columns[3].HeaderCell.Value.ToString();
                record.Write(line.PadRight(30));
                line = dataGridView1.Columns[4].HeaderCell.Value.ToString();
                record.Write(line.PadRight(30));
                line = dataGridView1.Columns[5].HeaderCell.Value.ToString();
                record.Write(line);
                record.WriteLine();
                for (int i = 0; i < dataGridView1.Rows.Count; i++)
                {
                    for (int j = 0; j < dataGridView1.Columns.Count; j++)
                    {
                        line = ("  " + dataGridView1.Rows[i].Cells[j].Value.ToString());
                        record.Write(line.PadRight(30));
                    }
                    record.WriteLine();
                }
                record.Close();
                MessageBox.Show("File saved succesfully");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Microsoft.Office.Interop.Excel._Application app = new Microsoft.Office.Interop.Excel.Application();
            Microsoft.Office.Interop.Excel._Workbook workbook = app.Workbooks.Add(Type.Missing);
            Microsoft.Office.Interop.Excel._Worksheet worksheet = null;
            if (workbook.Sheets == null)
            {
                worksheet = workbook.Sheets.Add("Sheet1");
            }
            worksheet = workbook.ActiveSheet;
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();
            saveFileDialog1.AddExtension = true;
            saveFileDialog1.DefaultExt = "xlsx";
            saveFileDialog1.Filter = "Excel files (*.xlsx)|*.xlsx|All files (*.*)|*.*";
            saveFileDialog1.InitialDirectory = Application.StartupPath + "\\Records";
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                for (int i = 0; i < dataGridView1.Columns.Count; i++)
                {
                    worksheet.Cells[1, i + 2] = dataGridView1.Columns[i].HeaderText;
                }
                for (int i = 0; i < dataGridView1.Rows.Count; i++)
                {
                    worksheet.Cells[i + 2, 1] = dataGridView1.Rows[i].HeaderCell.Value;
                }
                for (int i = 0; i < dataGridView1.Rows.Count; i++)
                {
                    for (int j = 0; j < dataGridView1.Columns.Count; j++)
                    {
                        worksheet.Cells[i + 2, j + 2] = dataGridView1.Rows[i].Cells[j].Value.ToString();
                    }
                }
                workbook.SaveAs(saveFileDialog1.FileName);
                workbook.Close();
                app.Quit();
                Marshal.ReleaseComObject(worksheet);
                Marshal.ReleaseComObject(workbook);
                Marshal.ReleaseComObject(app);
                MessageBox.Show("File saved succesfully");
            }
        }
    }
}
