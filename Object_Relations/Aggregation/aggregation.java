package Object_Relations.Aggregation;
import java.util.ArrayList;

class course{

    String name;
    String courseCode;
    String teacherName;

    course(String name,String courseCode,String teacherName){
        this.name=name;
        this.courseCode=courseCode;
        this.teacherName=teacherName;
    }

}

// courses can exist without student.

class student{ // one to many relationship between course and student.

    String name;
    String regno;
    int sem;
    ArrayList<course> courses;  // Aggregation

    student(String name,String regno,ArrayList<course> courses){
        this.name=name;
        this.regno=regno;
        this.courses=courses;
    }

    void addCourse(String name , String courseCode , String teacherName){
        courses.add(new course(name, courseCode, teacherName));
    }

}

