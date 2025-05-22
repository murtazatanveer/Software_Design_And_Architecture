package Patterns;

import java.util.ArrayList;

interface Student{
void update(String msg);
}

interface Teacher{
    void addStudent(Student stu);
    void removeStudent(Student stu);
    void notifyStudents();
}

class students implements Student{

    String name;

    students(String name){
        this.name=name;
    }
    @Override
    public void update(String msg){
        System.out.println("Student "+name+" has been Informed about "+msg+"\n");
    }
}

class Teacher_1 implements Teacher{

    ArrayList<Student> students;
    String update;

    Teacher_1(String update){
        students=new ArrayList<>();
        this.update=update;
    }

    Teacher_1(){
        students=new ArrayList<>();
        update="";
    }

      public void setUpdate(String update) {
        this.update = update;
    }

    public String getUpdate(){
        return this.update;
    }

    @Override
    public void addStudent(Student stu){
        students.add(stu);
    }

    @Override
    public void removeStudent(Student stu){
       students.remove(stu);
    }

    @Override
    public void notifyStudents(){
        for (Student stu : students) {
            stu.update(update);
        }
    }

}

public class observer {

    public static void main(String[] args) {
       
        Teacher_1 t1 = new Teacher_1("Assignment 1 is Uploaded");

        students s1 = new students("Murtaza");
        students s2 = new students("Naseem");
        students s3 = new students("Ali");
        students s4 = new students("Haris");

        t1.addStudent(s1);
        t1.addStudent(s2);
        t1.addStudent(s3);
        t1.addStudent(s4);

        t1.notifyStudents();

        t1.setUpdate("Quiz 1 will be scheduled in next class");
        t1.notifyStudents();

    }
    
}

