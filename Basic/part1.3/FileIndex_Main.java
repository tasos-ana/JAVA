//HY-252
//Assigment1 - Part 2 - Text Indexing for Information Retrieval
package Homework3;

import java.io.File;


public class FileIndex_Main {
    
    public static void main(String[] args){
        if (args.length != 2) {//o xristis tha prepei na exei dwsei ws eisodo 3 stoixeia, onoma exe kai duo fakelous txt
            System.out.println("Incorrect arguments. Format: filename.exe FolderPath Outputname.txt");
            return;
        } else {
           Text_Indexing_for_Information_Retrieval start = new Text_Indexing_for_Information_Retrieval();
           /**
            * arxizoume na diavazoume ta arxeia tou folder
            */
           File folderDir = new File(args[0]);
           File[] listOfFiles = folderDir.listFiles();
           for(int i=0; i<listOfFiles.length;i++){
               if(listOfFiles[i].isFile()){//gia kathe arxeio kanoume euretiriasi
                   start.Indexed(listOfFiles[i].getAbsolutePath(),args[1],"folder","r");//ta teleftaia wrismata einai to ena to eidous tis eureteriasis diladi apo folder h aplo txt kai to deftero ti praksi theloume na kanoume r=read
               }
           }
           start.Indexed("empty",args[1],"folder","w");//Molis euretiriasoume ola ta arxeia tote ta grafoume sto outputfolder
        }

    }
}
