//HY-252
//Assigment1 - Part 2 - RecursiveTriangle
package Homework2;

import java.awt.Color;

class RecursiveTriangle {

    public static Pixel Triangle[][] = new Pixel[512][512]; //Dimiourgoume enan pinaka disdiastato megelthous 512x512
    public static Picture pic = new Picture(512, 512);      //Orizoume ton Canva megethous 512x512
    public static Pixel pixel;
    //H synartisi draw emfanizei ton pinaka Triangle ston opoio exoume apothikeusi ta pixel.

    public static void draw() {
        for (int i = 0; i < 512; i++) {
            for (int j = 0; j < 512; j++) {
                if (Triangle[j][i]== null) {
                    pixel = new Pixel(i, j, Color.white);
                    Triangle[j][i] = pixel;
                }
                pic.set(Triangle[j][i]); //h fuction set emfanizei ta pixel.
            }
        }
    }

    /**
     *
     * Me ton parakatw kwdika gia tin draw kai kapoies alles mikres rithmiseis
     * to programma trexei pio grigora ap oti twra.
     *
     * public static void draw(Pixel p1, Pixel p2, Pixel p3) {
     *
     * int x1, x2, x3, y1, y2, y3;
     *
     * x1 = p1.getX(); x2 = p2.getX(); x3 = p3.getX();
     *
     * y1 = p1.getY(); y2 = p2.getY(); y3 = p3.getY();
     *
     * //aristeri meria int j = y2; int i = x2; while (i >= x1) { pixel = new
     * Pixel(j, i, Color.black); pic.set(pixel); if (j == y1) { break; } i = i -
     * 1; j++; } //deksia meria j = y3; i = x3; while (i >= x1) { pixel = new
     * Pixel(j, i, Color.black); pic.set(pixel); if (j == y1) { break; } i = i -
     * 1; j--; } //katw meria j = y2; i = x2; while (j <= y3) { pixel = new
     * Pixel(j, i, Color.black); pic.set(pixel); j = j + 1; } }
     */
    //H anadromiki sunartisi pou dexete 3 pixel pou einai oi korufes twn trigwnwn.
    public static int Recursive(Pixel p1, Pixel p2, Pixel p3) {
        int x1, x2, x3, y1, y2, y3;

        //diavazoume ta x kai ta y tou kathe simeiou.
        x1 = p1.getX();
        x2 = p2.getX();
        x3 = p3.getX();

        y1 = p1.getY();
        y2 = p2.getY();
        y3 = p3.getY();

        //Vazoume afta ta pixel xrwmatos maurou ston pinaka kai stin thesi pou antistixoi sta x kai y tous.
        Triangle[y1][x1] = p1;
        Triangle[y2][x2] = p2;
        Triangle[y3][x3] = p3;

        //h fuction set emfanizei ta pixel.
        //Dhmiourgoume 3 nea pixel. Opou kathe neo pixel tha einai h mesi kathe pleura tou ekastote trigwnou
        Pixel p4 = new Pixel(0, 0, Color.black);
        Pixel p5 = new Pixel(0, 0, Color.black);
        Pixel p6 = new Pixel(0, 0, Color.black);

        //Elegxoume tin apoluti timi an einai < tou 2 tote stamatame tin anadromi kai gurname piso.
        if (Math.abs(y1 - y2) < 2 && Math.abs(x1 - x2) < 2 && Math.abs(y2 - y3) < 2 && Math.abs(x2 - x3) < 2 && Math.abs(y1 - y3) < 2 && Math.abs(x1 - x3) < 2) {
            //draw(p1, p2, p3);
            //draw();//kaloume tin draw gia tin emfanisi tou pinaka
            return 0;
        } else {
            //h pixel p4 tha einai to meso twn p1,p2
            p4.setX((x2 + x1) / 2);
            p4.setY((y2 + y1) / 2);

            //h pixel p5 tha einai to meso twn p3,p2
            p5.setX((x2 + x3) / 2);
            p5.setY((y2 + y3) / 2);

            //h pixel p6 tha einai to meso twn p1,p3
            p6.setX((x1 + x3) / 2);
            p6.setY((y1 + y3) / 2);

            //Topothetoume ta p4,p5,p6 ston pinaka.
            Triangle[p4.getY()][p4.getX()] = p4;
            Triangle[p5.getY()][p5.getX()] = p5;
            Triangle[p6.getY()][p6.getX()] = p6;

            //Ksekiname nea anadromi 
            //Mia gia kathe meria, 
            //mia gia to neo aristero trigono tou trigwnou pou exoume.
            //mia gia to neo deksi trigono tou trigwnou pou exoume.
            //mia gia to neo katw trigono tou trigwnou pou exoume.
            Recursive(p1, p4, p6);
            Recursive(p4, p2, p5);
            Recursive(p6, p5, p3);
            return 0;
        }
    }

    public static void main(String args[]) {
        pic.setOriginUpperLeft();//Orizoume to (0,0) panw aristera tou parathirou.
        //Dhmiourgoume ta p1,p2,p3 pou einai oi korufes tou arxikou trigwnou
        Pixel p1 = new Pixel(256, 0, Color.black);
        Pixel p2 = new Pixel(0, 511, Color.black);
        Pixel p3 = new Pixel(511, 511, Color.black);
        //Arxizoume tin anadromi.
        Recursive(p1, p2, p3);
        draw();
        //Emfanizoume ton Canva
        pic.show();
    }
}

//Author Tasos Anastasas Csd3166
