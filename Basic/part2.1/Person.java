package Homework1;

public class Person {

    private String fName;
    private String lName;
    private String AT;

   public  Person(String fName, String lName, String AT) {
        this.fName = fName;
        this.lName = lName;
        this.AT = AT;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getAT() {
        return AT;
    }

    public String toString() {
        return (getfName() + " " + getlName() + " <" + getAT() +">");
    }
}