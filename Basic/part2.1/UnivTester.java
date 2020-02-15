package Homework1;

class UnivTester {
   
    public static void main(String[] args){
        Department csd = new Department("Computer Science Department");
        Department math = new Department("Mathematics");
        Student stud;
        GradStudent gStud;
        //department csd
        String first="Tasos", second="Anastasas",at="AZ 123",am="31";
        String first1="Sakis", second1="Rouvas",at1="KA 567",am1="26",meleti="Ypologistika Systimata";
        //vazoume  sto department csd 200 proptixiakous
        for(int i=1; i <=200; i++){
            stud = new Student(first+i,second+i,at+i,am+i,csd);
            csd.add(stud);
        }
        //24 metaptixiakous
        for(int i=1; i <=24; i++){
            gStud = new GradStudent(first1+i,second1+i,at1+i,am1+i,csd,meleti+1);
            csd.add(gStud);
        }    
        
        
        //department math vazoume 200 proptixiakous kai stin sinexeia metaptixiakous
        String first2="Pamela", second2="Aderson",at2="LA 947",am2="12";
        String first3="Elena", second3="Paparizou",at3="GR 162",am3="03",meleti1="Eurovision";
        for(int i=1; i <=200; i++){
            stud = new Student(first2+i,second2+i,at2+i,am2+i,csd);
            math.add(stud);
        }
        
        for(int i=1; i <=24; i++){
            gStud = new GradStudent(first3+i,second3+i,at3+i,am3+i,csd,meleti1+1);
            math.add(gStud);
        }
        
        System.out.println(csd.toString());
    }
}
