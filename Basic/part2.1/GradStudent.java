package Homework1;

public class GradStudent extends Student {
    
    private String thesisArea;

    public GradStudent(String fName, String lName, String AT,String AM,Department depa,String thesisArea) {
        super(fName,lName,AT,AM,depa);
        this.thesisArea = thesisArea;
    }  

    public String getThesisArea() {
        return thesisArea;
    }

    public String toString() {
        return (super.toString() + " " + getThesisArea());
    }
}