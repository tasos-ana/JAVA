//HY-252
//Assigment1 - Part 2 - Text Indexing for Information Retrieval
package Homework3;

class Use_Index_Main {

    public static void main(String[] args) {
        Text_Indexing_for_Information_Retrieval start = new Text_Indexing_for_Information_Retrieval();
        if (args.length!=4) {//o xristis tha prepei na exei dwsei ws eisodo 5 stoixeia, onoma exe  duo fakelous txt to string pou thelei na vrei kai ena N
            System.out.println("Incorrect arguments. Format: <filename.exe Inputname.txt Outputname.txt String N>");
            return;
        } else {
            if(Integer.parseInt(args[3])<args[2].length()){//elegxoume an to N einai mikrotero tou megethous tis leksi, an einai emfanizoume katalilo minima
                System.out.println("Please give a number N higher or equal from the length of <" +args[2] +">.Recommended N>=" +args[2].length());
                return;
            }
            start.Indexed(args[0], args[1],"file","r");//euretiriazoume to input file
            start.searchWord(args[2],Integer.parseInt(args[3]),args[0],"file");//kai stin sinexeia anazitame tin leksi
        }
    }
}
//Author Tasos Anastasas Csd3166
