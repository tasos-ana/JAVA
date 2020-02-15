//HY-252
//Assigment1 - Part 2 - Text Indexing for Information Retrieval
package Homework3;

class UrlIndex_Main {
    
    public static void main(String[] args){
        if (args.length != 2) {//o xristis tha prepei na exei dwsei ws eisodo 3 stoixeia, onoma exe kai duo fakelous txt
            System.out.println("Incorrect arguments. Format: filename.exe Url Outputname.txt");
            return;
        } else {
           Text_Indexing_for_Information_Retrieval start = new Text_Indexing_for_Information_Retrieval();
           start.Indexed(args[0],args[1],"url","r");//arxizoume na euretiriazoume ton fakelo
           start.Indexed(args[0],args[1],"url","w");//arxizoume na euretiriazoume ton fakelo
        }
    }
}
//Author Tasos Anastasas Csd3166