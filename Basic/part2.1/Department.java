package Homework1;

import java.util.ArrayList;

public class Department {

    int i = 0, in = 1;
    private String name, str;
    private ArrayList<Person> community = new ArrayList<Person>(1);

    public String getName() {
        return name;
    }

   public  Department(String name) {
        this.name = name;
        this.str = name + "\n"; //to str tha exei argotera apo tin toStrin ola ta dedomena tou community
    }

    public String toString() {
        if (i < community.size()) {
            str = str + community.get(i).toString() + "\n";//vazoume ena dedomeno apo to community sto str
            i++; //allazoume thesi/
            in++;
            toString();
        }
        in--;
        if (in == 0) {
            i = 0;
        }
        return str;
    }

    public void add(Student std) {
        try {
            community.add(std);
        } catch (Exception e) {
            System.out.println("Fatal error, given false instance of Student");
        }
    }

    public void delete(String AM) {
        int i =0;
        boolean found=false;
        try {
            while(i<community.size()){
            if (community.get(i) instanceof Student) {//an einai to community(i) tipou student 
                if (((Student) community.get(i)).getAM() == AM) { //elegxoume ta am
                    found=true;
                    community.remove(i);
                    community.trimToSize();
                    break;
                }
            }
            i++;
            }
            if (found==false){
                System.out.println("The student with AM: "+ AM + " isn't member of department " + name);
            }
        } catch (Exception e) {
            System.out.println("Fatal error, given false AM");
        }
    }
}
