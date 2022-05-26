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

namespace WindowsFormsApp4
{
    public partial class Form1 : Form
    {
        // Step 1 for connection with DB
        // Create connection string
        String connStr = "Data source=rad2022_4.db;Version=3";

        // Step 2 for connection with DB
        // Create a variable with type"SQLiteConnection" (need "using System.Data.SQLite;")
        SQLiteConnection conn;
        
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // Step 3 for connection with DB
            // Create a connect object
            conn = new SQLiteConnection(connStr);
        }

        // Select all from DB
        private void button1_Click(object sender, EventArgs e)
        {
            richTextBox1.Clear();

            // Step 4 for connection with DB
            // Start connect object
            conn.Open();

            // Step 5 for connection with DB
            // Create a select sql query
            String selectSQL = "SELECT * from User";

            // Step 6 for connection with DB
            // Create a command object with use connect object and sql query
            SQLiteCommand cmd = new SQLiteCommand(selectSQL, conn);

            // Step 7 for connection with DB
            // Execute the command and create an object for the execution
            // ExecuteReader() = only for select query
            SQLiteDataReader reader = cmd.ExecuteReader();

            // Step 8 for connection with DB
            // Read all rows one by one and display only 2nd and 3rd column 
            while (reader.Read())
            {
                richTextBox1.AppendText(reader.GetString(1) + "," + reader.GetString(2) + Environment.NewLine);
            }

            // Step 9 for connection with DB
            // End connect object
            conn.Close(); 
        }

        // Insert to DB  Hardcoded 
        private void button2_Click(object sender, EventArgs e)
        {
            // Step 4 for connection with DB
            // Start connect object
            conn.Open();

            // Step 5 for connection with DB
            // Create an insert sql query
            String insertSQL = "Insert into User(name,email,password) values('Kostas','konn@test.com','test12345')";

            // Step 6 for connection with DB
            // Create a command object with use connect object and sql query
            SQLiteCommand cmd = new SQLiteCommand(insertSQL, conn);

            // Step 7 for connection with DB
            // Execute the command
            // ExecuteNonQuery() = for all queries (insert, update, delete etc) except from select
            int count = cmd.ExecuteNonQuery();
            if (count > 0)
            {
                MessageBox.Show(count.ToString() + " rows affected");
            }

            // Step 8 for connection with DB
            // End connect object
            conn.Close();
        }

        // Insert to DB  User Text (1st way)
        private void button3_Click(object sender, EventArgs e)
        {
            conn.Open();
            String name = textBox1.Text;
            String email = textBox2.Text;
            String password = textBox3.Text;
            String insertSQL = "Insert into User(name,email,password) values('" + name + "','" + email + "','" + password + "')";
            SQLiteCommand cmd = new SQLiteCommand(insertSQL, conn);
            int count = cmd.ExecuteNonQuery();
            if (count > 0)
                MessageBox.Show(count.ToString() + " row affected");
            conn.Close();
        }

        // Insert to DB  User Text (2nd way)
        private void button4_Click(object sender, EventArgs e)
        {
            conn.Open();
            String name = textBox1.Text;
            String email = textBox2.Text;
            String password = textBox3.Text;
            String insertSQL = "Insert into User(name,email,password) values(@name,@email,@password)";
            SQLiteCommand cmd = new SQLiteCommand(insertSQL, conn);
            cmd.Parameters.AddWithValue("@name", name);
            cmd.Parameters.AddWithValue("@email", email);
            cmd.Parameters.AddWithValue("@password", password);
            int count = cmd.ExecuteNonQuery();
            if (count > 0)
                MessageBox.Show(count.ToString() + " row affected");
            conn.Close();
        }
        
    }
}
