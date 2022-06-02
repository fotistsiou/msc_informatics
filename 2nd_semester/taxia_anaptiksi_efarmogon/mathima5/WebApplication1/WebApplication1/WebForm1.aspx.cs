using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Button1_Click(object sender, EventArgs e)
        {
            Label2.Text = TextBox1.Text;
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Response.Redirect("WebForm2.aspx");
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            if (TextBox1.Text.Length > 0)
            {
                Session["textForm1"] = TextBox1.Text;
                Response.Redirect("WebForm2.aspx");
            } 
        }
    }
}