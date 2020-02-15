//HY-252
//Assigment1 - Part 2 - Fractal,RecursiveTriangle
package Homework2;

import java.awt.Color;
import java.io.File;
import java.util.Scanner;

class ReadImageFromTxtFile {

    private Scanner x;

    public void OpenFile() {
        //Prospathoume na anoiksoume to arxeio fractal.txt
        try {
                   x = new Scanner(new File("fractal.txt"));

            //x = new Scanner(new File("C:\\Users\\Tasos\\Dropbox\\Uoc-Csd\\Ασκήσεις\\Εξαμήνου 3ου\\ΗΥ252-Java\\Java_(HY252)_Series1\\src\\Homework2\\fractal.txt"));
        } catch (Exception e) {
            System.out.println("Cound not find or open the file.");
        }
    }

    public void ReadFile() {
        Picture pic = new Picture(512, 512);
        pic.setOriginUpperLeft();
        while (x.hasNext()) {
            int line, column, red, green, blue;
            line = x.nextInt();
            column = x.nextInt();
            red = x.nextInt();
            green = x.nextInt();
            blue = x.nextInt();

            Color color = new Color(red, green, blue);
            Pixel pixel = new Pixel(line, column, color);
            pic.set(pixel);

        }
        pic.show();
    }

    public void CloseFile() {
        x.close();
    }

    public static void main(String[] args) {
        ReadImageFromTxtFile x = new ReadImageFromTxtFile();
        x.OpenFile();
        x.ReadFile();
        x.CloseFile();
    }

}

//Author Tasos Anastasas Csd3166
