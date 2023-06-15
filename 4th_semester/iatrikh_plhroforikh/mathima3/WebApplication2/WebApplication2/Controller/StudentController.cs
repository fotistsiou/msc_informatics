using Microsoft.AspNetCore.Mvc;
using WebApplication2.Model;

namespace WebApplication2.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentController : ControllerBase
    {
        // test lists
        static List<Student> students = new List<Student>()
        {
            new Student("mppl21001","Fotis","fot@test.com"),
            new Student("mppl21002","Aspa","asp@test.com"),
            new Student("mppl21003","Rafahlia","raf@test.com")
        };

        // Get All Students
        [HttpGet]
        [Route("allstudents")]
        public List<Student> GetStudents()
        {
            return students;
        }

        // Add A Student
        [HttpPost]
        [Route("newStudent")]
        public Student Post([FromBody] Student student)
        {
            students.Add(student);
            return student;
        }

        // Get A Student By AM
        [HttpGet]
        [Route("findone/{AM}")]
        public Student Get(String AM) 
        { 
            Student? student = students.Find(s => s.AM == AM);
            if (student != null)
            {
                return student;
            }
            return null;
        }

        // Delete A Student with AM
        [HttpDelete]
        [Route("deletestudent/{AM}")]
        public List<Student> Delete(String AM)
        {
            Student? student = students.Find(s => s.AM == AM);
            if (student != null)
            {
                students.Remove(student);
            }
            return students;
        }


        // Update A Student with AM
        [HttpPut]
        [Route("updatestudent/{AM}")]
        public Student Put(String AM, [FromBody] Student student)
        {
            Student? studentToUpdate = students.Find(s => s.AM == AM);
            if (studentToUpdate != null)
            {
                int index = students.IndexOf(studentToUpdate);
                students.RemoveAt(index);
                students.Insert(index, student);
            }
            return student;
        }
    }
}
