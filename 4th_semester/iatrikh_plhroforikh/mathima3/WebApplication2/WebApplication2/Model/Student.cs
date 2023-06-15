namespace WebApplication2.Model
{
    public class Student
    {
        public String AM { get; }
        public String fullName { get; }
        public String email { get; }
        public Student(string AM, string fullName, string email)
        {
            this.AM = AM;
            this.fullName = fullName;
            this.email = email;
        }
    }
}
