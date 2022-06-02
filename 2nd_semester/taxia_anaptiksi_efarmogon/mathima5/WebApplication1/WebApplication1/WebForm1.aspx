<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication1.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 29px">
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Font-Size="Medium" Text="Hello World form ASP.NET"></asp:Label>
        </div>
        <p>
            <asp:Image ID="Image1" runat="server" Height="116px" ImageUrl="~/images/test.png" Width="157px" />
        </p>
        <asp:Label ID="Label2" runat="server" Text="Label"></asp:Label>
        <p>
            <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        </p>
        <p>
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Change the Label" />
        </p>
        <p>
            <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="Go to Form2" />
        </p>
        <asp:Button ID="Button3" runat="server" OnClick="Button3_Click" Text="Transfer the Text to Form 2" />
    </form>
</body>
</html>
