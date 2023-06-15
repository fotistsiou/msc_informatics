using System.Net;

var builder = WebApplication.CreateBuilder(args);

//I put this line to have a specific port
builder.WebHost.UseUrls("https://localhost:7070");

builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();

var app = builder.Build();

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();