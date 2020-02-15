//HY-252
//Assigment1 - Part 2 - Fractal,RecursiveTriangle
package Homework2;

import java.awt.Color;

class Pixel 
{
    private int x=0, y=0;
    private Color color = Color.white;

    //constructor
    public Pixel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    //modifiers
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    //accessors
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Color getColor() {
        return color;
    }
}

//Author Tasos Anastasas Csd3166