package view;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @author dxanthak - mountanton
 */
public class MenuDialog {

    int option;
    String strin;
    URL imageURL;
    ClassLoader cldr = this.getClass().getClassLoader();

    /**
     * constructor: Creates a new Menu Window 
     * postconditions: Creates a new Menu Window starting a new Menu
     */
    public MenuDialog(Object a, Object b, String str, String str2) {
        JFrame parent = new JFrame();
        if (str2.charAt(0) == 'E') {
            strin = "exit2";
        } else if (str2.charAt(0) == 'N') {
            strin = "new2";
        } else {
            strin = "winner";
        }

        Object[] options = {a,
            b};
        imageURL = cldr.getResource("images/" + strin + ".png");
        int n = JOptionPane.showOptionDialog(parent,
                str,
                str2,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(imageURL), //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title

        if (n == JOptionPane.YES_OPTION) {
            option = 1;
        } else if (n == JOptionPane.NO_OPTION) {
            option = 2;
        } else {
            option = 0;
        }
    }

    /**
     *accessor: Returns the choice of a player
     * Postcondition:Returns the choice of a player
     * @return the choice of the player
     */
    public int choice() {
        return this.option;
    }
}
