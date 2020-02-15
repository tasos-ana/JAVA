package Homework3;

import java.io.File;

public class Use_FileIndex_Main {

    public static void main(String[] args) {
        Text_Indexing_for_Information_Retrieval start = new Text_Indexing_for_Information_Retrieval();
        if (args.length != 4) {//o xristis tha prepei na exei dwsei ws eisodo 5 stoixeia, onoma exe  duo fakelous txt to string pou thelei na vrei kai ena N
            System.out.println("Incorrect arguments. Format: <filename.exe FolderPath Outputname.txt String N>");
            return;
        } else {
            if (Integer.parseInt(args[3]) < args[2].length()) {//elegxoume an to N einai mikrotero tou megethous tis leksi, an einai emfanizoume katalilo minima
                System.out.println("Please give a number N higher or equal from the length of <" + args[2] + ">.Recommended N>=" + args[2].length());
                return;
            } else {
                /**
                 * diavazoume ta arxeia tou folder
                 */
                File folderDir = new File(args[0]);
                File[] listOfFiles = folderDir.listFiles();
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        start.Indexed(listOfFiles[i].getAbsolutePath(), args[1], "folder", "r");//arxizoume tin euretiriasi
                    }
                }
                start.Indexed("empty", args[1], "folder", "w");//arxizoume tin egrafi sto output file
                start.searchWord(args[2], Integer.parseInt(args[3]), args[0], "folder");//kanoume anazitis tin leksi
            }
        }
    }
}
