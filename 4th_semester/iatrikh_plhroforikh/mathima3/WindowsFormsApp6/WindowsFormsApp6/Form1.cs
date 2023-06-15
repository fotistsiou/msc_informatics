using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp6
{
    public partial class Form1 : Form
    {
        // Step1: Add "entities" and "associations" on Model1.edmx
        // Step2: Press right click on space and select "Generate Database fromModel"
        // Step3: Create a DB or select an exists DB
        // Step4: Click button "Execute" of left top corner of Model1.edms.sql
        // Step5: Add a label and a button on Form1.cs

        //Step6: Initial an object from the "Model1Container" class
        Model1Container context = new Model1Container();
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Step7: Add records on the tables and print the number of "contacts" records.
            Contact c1 = new Contact();
            c1.Email = "fotis@test.com";
            c1.Address = "Test 134";
            c1.FullName = "Fotis Tsioumas";
            Telephone t1 = new Telephone();
            t1.Number = "2107945632";
            c1.Telephones.Add(t1);
            Telephone t2 = new Telephone();
            t2.Number = "2107945698";
            c1.Telephones.Add(t2);
            context.Contacts.Add(c1);
            context.SaveChanges();
            MessageBox.Show(context.Contacts.Count().ToString());
        }
    }
}
