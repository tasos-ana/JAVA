//HY-252
//Assigment1 - Part 2 - Text Indexing for Information Retrieval
package Homework3;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Formatter;
import java.util.Scanner;

class Text_Indexing_for_Information_Retrieval {

    private Scanner fRead; //Orizoume tin fread gia na kanoume file read (diavasma apo to arxeio)
    private Scanner lRead; //Orizoume tin lread gia na kanoume line read (diavazoume ena string leksi leksi)
    private Scanner read;
    private Formatter fWrite; //Orizoume tin fwrite gia na grapsoume sto arxeio eksodou ta dedomena.
    public static String UniqueWords[] = new String[100000]; //dimiourgoume ton pinaka me tis monadikes lekseis.
    public static String UwordsPos[] = new String[100000]; //dimiourgoume ton pinaka me tis thesi (stili,thesi) kathe monadikis lekseis.
    public static String UwordsFile[] = new String[100000];//dimiourgoume ton pinaka me ta onomata twn arxeiwn.
    public static char[] array;
    int nLine; // h nline krataei ton arithmo tis grammis pou eimaste twra.

    //i sinartisi afti ksekinaei na anoigei,na diavazei kai na grafei ta arxeia
    public void Indexed(String inFile, String outFile, String type, String action) {
        Text_Indexing_for_Information_Retrieval start = new Text_Indexing_for_Information_Retrieval();

        if (type == "file") {
            /**
             * Ksekiname na anoigoume to arxeio mas stin sunexeia na diavazoume
             * mesa apo to arxeio kai na xwrizoume tis lekseis kai telos na
             * kleinoume to arxeio eisodou.
             */
            start.rOpenFile(inFile, "file");
            start.ReadFile(inFile);
            start.rCloseFile();

            /**
             * Anoigoume twra to arxeio eksodou arxizoume na grafoume ta
             * dedomena mas telos to kleinoume
             */
            start.wOpenFile(outFile);
            start.WriteFile("file");
            start.wCloseFile();
        } else if (type == "folder" && action == "r") {
            /**
             * Ksekiname na anoigoume to arxeio mas stin sunexeia na diavazoume
             * mesa apo to arxeio kai na xwrizoume tis lekseis kai telos na
             * kleinoume to arxeio eisodou.
             */
            start.rOpenFile(inFile, "folder");
            start.ReadFile(inFile);
            start.rCloseFile();
        } else if (type == "folder" && action == "w") {
            /**
             * Anoigoume twra to arxeio eksodou arxizoume na grafoume ta
             * dedomena mas telos to kleinoume
             */
            start.wOpenFile(outFile);
            start.WriteFile("folder");
            start.wCloseFile();
        } else if (type == "url") {
            String urlStr = inFile;
            String pageContents = "";
            StringBuilder sb = new StringBuilder();
            try {
                URL url = new URL(urlStr);//dimiourgoume ena url
                URLConnection con = url.openConnection();//anoigoume to url
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));//diavazoume me ton in apo to Url
                String input;
                while ((input = in.readLine()) != null) {
                    pageContents = pageContents + input + "\n"; // diavazoume kathe grammi tis selidas
                }
                in.close();
            } catch (Exception c) {
                System.out.println("Cound not find or open the URL: " + inFile + ".Please give the correct address or check the internet connection.");// an den mporesoume na anoiksoume to arxeio petame to minima
            }
            //////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////
            // pageContents = StringEscapeUtils.escapeHtml(pageContents);
            pageContents = pageContents.replaceAll("\\<.*?>", "");//kanoume replace ola ta simeia pou periexontai se  < > 
            System.out.println(pageContents);
            /**
             * Ksekiname na anoigoume to arxeio mas stin sunexeia na diavazoume
             * mesa apo to arxeio kai na xwrizoume tis lekseis kai telos na
             * kleinoume to arxeio eisodou.
             */
            if (action == "r") {
                start.rOpenFile(pageContents, "url");
                start.ReadFile(pageContents);
                start.rCloseFile();
            } else {
                /**
                 * Anoigoume twra to arxeio eksodou arxizoume na grafoume ta
                 * dedomena mas telos to kleinoume
                 */
                start.wOpenFile(outFile);
                start.WriteFile("file");
                start.wCloseFile();
            }
        }
    }

    //anoigoume to arxeio gia read
    public void rOpenFile(String file, String type) {
        try {
            if (type == "url") {
                fRead = new Scanner(file);
            } else {
                fRead = new Scanner(new File(file));//orizoume tin  fread me vasi to name tou arxeiou pou exoume  
            }
        } catch (Exception e) {
            System.out.println("Cound not find or open the " + file + ".Please give the full path of the file.");// an den mporesoume na anoiksoume to arxeio petame to minima
        }
    }

    //anoigoume to arxeio gia grapsimo
    public void wOpenFile(String file) {
        try {
            fWrite = new Formatter(new File(file)); //orizoume tin fwrite se poio arxeio tha grapsi
        } catch (Exception e) {
            System.out.println("Error-Can't open file to write data!" + "Please give the full path of the file.");//an den mporesei na to anoiksei bgazoume to minima
        }
    }

    //diavazoume to arxeio ana grammi
    public void ReadFile(String file) {
        nLine = 0;
        String sLine;
        while (fRead.hasNext()) {
            sLine = fRead.nextLine();// diavazoume mia grammi
            nLine++;//orizoume pia grammi einai
            splitLineToWords(sLine, nLine, file);// kaloume tin sinartisi gia na xwrisei tin grammi se leksis.
        }
    }

    //dinoume stin sinartisi ena string pou einai h grammi kathos kai pia grammi einai afti wste na xwrisi to string se lekseis.
    public void splitLineToWords(String sLine, int row, String file) {
        // stin sLine kratame to string pou uparxei ston pinaka wLine kai i word krataei tin kathe leksi tou string
        int lastPos = 0; //edw tha exoume tin thesi pou vrethike h leksi mesa sto string
        sLine = sLine.toLowerCase(); //kanoume olous tous xaraktires tou string se mikrous
        lRead = new Scanner(sLine); //dhmiourgoume ena object tis lread wste na diavasoume tis lekseis apo to string sline
        while (lRead.hasNext()) {
            int i = 0;
            String word = lRead.next(); //diavazoume to epomeno string mexri na vroume keno.
            //Kanoume mikra kai bgazoume ola ta simvola apo tin leksi.
            word = word.toLowerCase();
            word = word.replaceAll("[^A-Za-z0-9]+", "");
            boolean found = false;
            /**
             * ean uparxei leksi stin thesi i kanoume elegxo, an exoume vrei tin
             * leksi tote einai askopo na trexei h while opote tin stamatame me
             * tin found
             */
            while (UniqueWords[i] != null && found == false) {
                //An uparxei h leksi word ston pinaka UniqueWords tote..
                if (UniqueWords[i].equals(word)) {
                    //an uparxei i leksi tote leme found = true kai stamatame tin while.
                    found = true;
                } else {
                    found = false; //alliws false kai sinexizoume
                    i++;            // stin epomeni leksi
                }
            }
            sLine = sLine.replaceAll("[^A-Za-z0-9]+ ", "");//kanoume replace apo to string olous tous eidikous xaraktires
            if (found == true) {
                /**
                 * An exoume vrei oti i leksi uparxei ston pinaka tote
                 * pigainoume stin antistixi thesi tou pinaka UwordsPos kai
                 * prosthetoume tin nea thesi sto uparxwn string. H
                 * "sLine.indexOf(word, lastPos) + 1" epistrefei tin thesi pou
                 * vriskete i leksi omws epeidi se mia grammi mporei na exoume 2
                 * fores to word ara tha epestrefe panta tin idia thesi, me tin
                 * lastpos tou orizoume apo pou na ksekinisei na tsekarei to
                 * last pos exei oristei stin arxi tis kathe teleftaias
                 * monadikis leksi pou vriskoume
                 */
                UwordsPos[i] = UwordsPos[i] + row + ";" + (sLine.indexOf(word, lastPos) + 1) + ", ";
                if (UwordsFile[i].indexOf(file) == -1) {
                    UwordsFile[i] = UwordsFile[i] + file + ";" + row + ";" + (sLine.indexOf(word, lastPos) + 1) + ", ";
                } else {
                    UwordsFile[i] = UwordsFile[i] + ";" + row + ";" + (sLine.indexOf(word, lastPos) + 1) + ", ";
                }
                //if(UwordsFile[i].indexOf(file)==-1){
                //    UwordsFile[i]=UwordsFile+" ";
                //}
            } else {
                /**
                 * An den uparxei i leksi word tote tin topothetoume sto
                 * UniqueWords[i] opou to i dixnei stin apomeni thesi null tou
                 * pinaka. topothetoume kai tin thesi pou vrikame to string
                 * kratame kai sto lastpos apo pou na arxisei meta i indexof na
                 * elegxei
                 */
                UniqueWords[i] = word;
                UwordsPos[i] = "\t" + row + ";" + (sLine.indexOf(word, lastPos) + 1) + ", ";
                UwordsFile[i] = file + ";" + row + ";" + (sLine.indexOf(word, lastPos) + 1) + ", ";
                lastPos = sLine.indexOf(word);

            }
        }
    }

    // kleinoume to arxeio pou anoiksame gia diavasma
    public void rCloseFile() {
        fRead.close();
    }

    //grafoume sto arxeio
    public void WriteFile(String type) {
        int i = 0;
        if (type == "file") {
            while (UniqueWords[i] != null) {//oso den exoume teleiwsei i lekseis
                /**
                 * grafoume sto arxeio me forma words line;position ,
                 * anotherLine;anotherPosition(pou vrethike ksana h leksi)
                 */
                fWrite.format("%s  %s \n", UniqueWords[i], UwordsPos[i]);
                i++;
            }
        } else {
            while (UniqueWords[i] != null) {//oso den exoume teleiwsei i lekseis
                /**
                 * grafoume sto arxeio me forma words line;position ,
                 * anotherLine;anotherPosition(pou vrethike ksana h leksi)
                 */
                fWrite.format("%s  %s \n", UniqueWords[i], UwordsFile[i]);
                i++;
            }
        }
    }

    //kleinoume to arxeio pou anoiksame gia eggrafi.
    public void wCloseFile() {
        fWrite.close();
    }

    //me tin sinartisi afti checkaroume an to str mporei na metatrapei se int i oxi
    public static boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);//metatrepoume to str se int
        } catch (NumberFormatException nfe) {//an den ginei epistrefoume false
            return false;
        }
        return true;//alliws true
    }

    public void searchWord(String word, int N, String file, String type) {
        /**
         * to Row krataei tin grammi pou einai i leksi pou vrike to Column
         * krataei to simeio pou arxeizei i leksi pou vrike to fColumn krataei
         * tin arxi tis emfanisis tou snipet to lColumn krataei to telos tis
         * emfanisis tou snipet to sColumn krataei to simeio pou arxizei i leksi
         * san string to sRow krataei tin grammi pou vriskete i leksi san string
         * to nN einai newN opou einai to N xwris to megethos tis lekseis
         */
        int i = 0, Column, Row, fColumn, lColumn, nN = N - word.length();
        String sPositions, sColumn, sRow;
        boolean found = false;
        int aRest = 0, dRest = 0;
        while (UniqueWords[i] != null && found == false) {
            if (UniqueWords[i].equals(word)) {
                found = true;//an tin vroume kanoume true to found
                if (type == "file") {//an exoume san eisodo ena arxeio
                    sPositions = (UwordsPos[i].replace(";", " ")); //kanoume replace ta erwtimatika
                    sPositions = (sPositions.replace(",", " ")); //kai ta kommata
                    lRead = new Scanner(sPositions);//dinoume stin scanner to string
                } else {// an exoume san eisodo ena folder
                    sPositions = (UwordsFile[i].replace(";", " "));//kanoume replace ta erwtimatika
                    sPositions = (sPositions.replace(",", " "));//kai ta kommata
                    lRead = new Scanner(sPositions);//dinoume stin scanner to string
                }
                while (lRead.hasNext()) {
                    if (type == "file") {
                        sRow = lRead.next();//diavazoume to prwto string pou einai enas arithmos pou antistixi stin grammi
                        sColumn = lRead.next();//diavazoume to deftero string pou einai o arithmos pou antistixi stin thesi
                        Column = Integer.parseInt(sColumn);//stili
                        Row = Integer.parseInt(sRow);//grammi
                    } else {//an exoume ws eisodo folder
                        String nString = lRead.next();//diavazoume to prwto string
                        if (isNumeric(nString)) {//elegxoume an einai arithmos i onoma arxeiou
                            Row = Integer.parseInt(nString);//an einai arithmos tote to strin afto pou diavasame einai mia grammi
                            sColumn = lRead.next();//diavazoume to epomeno pou einai i thesi
                            Column = Integer.parseInt(sColumn);// tin metatrepoume se int
                        } else {//an den einai arithmos alla onoma
                            file = nString;//tote to string afto einai to onoma tou arxeio
                            sRow = lRead.next();//diavazoume ta duo epomena string pou einai to prwto o arithmos pou antistixi stin grammi
                            sColumn = lRead.next();//diavazoume to deftero string pou einai o arithmos pou antistixi stin thesi
                            Column = Integer.parseInt(sColumn);//stili
                            Row = Integer.parseInt(sRow);//grammi
                        }
                    }
                    try {
                        read = new Scanner(new File(file));//orizoume tin  read me vasi to name tou arxeiou pou exoume
                    } catch (Exception b) {
                        System.out.println("Cound not find or open the " + file);// an den mporesoume na anoiksoume to arxeio petame to minima
                    }
                    String sLine;//orizoume to string pou tha diavazei kathe grammi
                    int nLine = 1;//orizoume to arithmo tis grammis
                    while (read.hasNext()) {
                        sLine = read.nextLine();// diavazoume mia grammi
                        if (nLine == Row) {//an h grammi pou eimaste einai h grammi Row pou vrethike h leksi
                            if (sLine.length() >= N) {//an gnwrizoume oti uparxoun oi N xaraktires pou zitithikan gia emfanisi
                                if (nN % 2 != 0) {//an o arithmos - to megethos tis lekseis den einai pollaplasio tou 2 diladi den xwrizete stin mesi
                                    if ((Column - 1) - nN / 2 <= 0) {//kai an den eparkoun oi xaraktires h einai isoi apo aristera
                                        fColumn = 0;//thetoume san arxi to 0
                                        aRest = nN / 2 - (Column - 1);
                                    } else {//An eparkoun ta stoixeia
                                        fColumn = Column - 1 - nN / 2;//thetoume tin arxi na einai h thesi pou vrikame to string-nN/2
                                        aRest = 0;
                                    }
                                    //elegxoume an eparkoun apo deksia
                                    if (sLine.length() - word.length() - (Column - 1) >= nN / 2) {
                                        lColumn = (Column - 1) + word.length() + nN / 2 + 1;//kai telos to n-1
                                        dRest = 0;
                                    } else {//an den eparkoun
                                        lColumn = sLine.length();//column-1 giati arxizei o pinaka apo 0 , prosthetoume to megethos tis leksis kai meta to nN
                                        dRest = nN / 2 - (sLine.length() - (Column - 1) + word.length());
                                    }
                                } else {
                                    if ((Column - 1) - nN / 2 <= 0) {//kai an den eparkoun oi xaraktires h einai isoi apo aristera
                                        fColumn = 0;//thetoume san arxi to 0
                                        aRest = nN / 2 - (Column - 1);
                                    } else {//An eparkoun ta stoixeia
                                        fColumn = Column - 1 - nN / 2;//thetoume tin arxi na einai h thesi pou vrikame to string-nN/2
                                        aRest = 0;
                                    }
                                    //elegxoume an eparkoun apo deksia
                                    if (sLine.length() - word.length() - (Column - 1) >= nN / 2) {//an eparkoun
                                        lColumn = (Column - 1) + word.length() + nN / 2;//kai telos to n-1
                                        dRest = 0;
                                    } else {//an den eparkoun
                                        lColumn = sLine.length();//column-1 giati arxizei o pinaka apo 0 , prosthetoume to megethos tis leksis kai meta epeidi to nN den xwrizete stin mesi kanoume+1
                                        dRest = nN / 2 - (sLine.length() - ((Column - 1) + word.length()));
                                    }
                                }
                                fColumn = fColumn - dRest;
                                lColumn = lColumn + aRest;
                            } else {
                                fColumn = 0;
                                lColumn = sLine.length();
                            }
                            array = sLine.toCharArray();//metatrepoume ton string se array
                            if (type == "file" && found == true) {
                                System.out.print("The input <" + word + "> found at line <" + nLine + "> and was: <");
                            } else if (type == "folder" && found == true) {
                                System.out.print("The input <" + word + "> found in file <" + file + "> at line <" + nLine + "> and was: <");
                            }
                            for (int j = fColumn; j < lColumn; j++) {//emfanizoume ton pinaka apo tin thesi fcolumn mexri tin lcolumn
                                System.out.print(array[j]);
                            }
                            System.out.print(">\n");
                            break;//stamatame tin while.
                        } else {//an den eimaste stin grammi pou theloume tote pame stin epomeni
                            nLine++;//pame stin epomeni grammi
                        }

                    }
                    read.close();//klinoume to arxeio pou anoiksama gia na diavazoume tin grammes
                }
            } else {
                i++;//pame stin epomeni leksi gia na eleksoume an uparxei to word.
            }

        }
        if (found == false) {//an den vroume katholou tin leksi tote emfanizoume.
            System.out.println("No results for the given query!");
        }

    }
}

//Author Tasos Anastasas Csd3166
