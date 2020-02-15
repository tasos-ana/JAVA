package Homework1;

public class Student extends Person {

    private String AM;
    private Department department;

   public  String getAM() {
        return AM;
    }

   public  Student(String fName, String lName, String AT,String AM,Department depa) {
        super(fName,lName,AT);
        this.department = depa;
        this.AM=AM;
    }
    
     public String toString() {
        return (super.toString() + " (" + getAM() + ") " + this.department.getName());
    }
}