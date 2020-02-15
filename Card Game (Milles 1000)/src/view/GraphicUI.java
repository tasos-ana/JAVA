package view;

import controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import model.Deck.Deck;
import model.Sullogi.Sullogi;
import model.card.Card;

/**
 * @version 1.0
 * @author Tasos Anastasas
 */
public class GraphicUI extends JFrame {

    private Controller game;
    private Image image;
    private myDesktopPane basic_panel;
    private JButton Exit, newGame;
    private JDesktopPane deck1;
    private JDesktopPane deck2, tablo;
    private JTextField turn, p1Milles, p2Milles, drawPnum;
    private JButton[] buttons = new JButton[30];
    private URL imageURL;
    private ClassLoader cldr;

    /**
     * constructor: Creates a new Window and initializes some buttons and panels
     * postconditions: Creates a new Window and initializes some buttonsand
     * panels starting a new game.
     */
    public GraphicUI() {
        basic_panel = new myDesktopPane();
        deck1 = new JDesktopPane();
        deck2 = new JDesktopPane();
        tablo = new JDesktopPane();
        turn = new JTextField();
        p1Milles = new JTextField();
        p2Milles = new JTextField();
        drawPnum = new JTextField();
        Exit = new JButton();
        newGame = new JButton();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cldr = this.getClass().getClassLoader();
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.setResizable(false);
        this.setTitle("Milles Bornes");
        imageURL = cldr.getResource("images/milles_bornes.jpg");
        this.setIconImage(new ImageIcon(imageURL).getImage());
        game = new Controller();
        this.setPreferredSize(new Dimension(550, 665));
        initComponents();
    }

    /**
     * transformer: initialize some buttons and labels 
     * Postcondition: initialize some buttons and labels
     *
     */
    private void initComponents() {
        Exit.setBounds(468, 12, 60, 60);
        Exit.setOpaque(false);
        Exit.setFocusPainted(false);
        Exit.setBorderPainted(false);
        Exit.setContentAreaFilled(false);
        Exit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        imageURL = cldr.getResource("images/exit.png");
        Exit.setIcon(new ImageIcon(imageURL));
        Exit.addActionListener(new SettingsListener());
        Exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        basic_panel.add(Exit);

        newGame.setBounds(12, 12, 60, 60);
        imageURL = cldr.getResource("images/new.png");
        newGame.setIcon(new ImageIcon(imageURL));
        newGame.setOpaque(false);
        newGame.setFocusPainted(false);
        newGame.setBorderPainted(false);
        newGame.setContentAreaFilled(false);
        newGame.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        newGame.addActionListener(new SettingsListener());
        newGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        basic_panel.add(newGame, JLayeredPane.DEFAULT_LAYER);

        deck1.setBounds(12, 405, 516, 213);
        basic_panel.add(deck1, new JLayeredPane());
        deck2.setBounds(12, 78, 516, 213);
        basic_panel.add(deck2, JLayeredPane.DEFAULT_LAYER);
        tablo.setBounds(12, 293, 516, 110);
        basic_panel.add(tablo, JLayeredPane.DEFAULT_LAYER);

        turn.setBounds(225, 12, 76, 17);
        basic_panel.add(turn, JLayeredPane.DEFAULT_LAYER);
        turn.setBackground(Color.white);
        turn.setText(" Player " + game.seeTurn());
        turn.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12));
        turn.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
        turn.setEditable(false);

        p2Milles.setBounds(3, 3, 110, 20);
        tablo.add(p2Milles, JLayeredPane.DEFAULT_LAYER);
        p2Milles.setBackground(Color.white);
        p2Milles.setText("Player 2: " + Integer.toString(game.p2Milles()));
        p2Milles.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12));
        p2Milles.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
        p2Milles.setEditable(false);

        p1Milles.setBounds(3, 85, 110, 20);
        tablo.add(p1Milles, JLayeredPane.DEFAULT_LAYER);
        p1Milles.setBackground(Color.white);
        p1Milles.setText("Player 1: " + Integer.toString(game.p1Milles()));
        p1Milles.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12));
        p1Milles.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
        p1Milles.setEditable(false);

        drawPnum.setBounds(151, 47, 20, 20);
        tablo.add(drawPnum, JLayeredPane.DEFAULT_LAYER);
        drawPnum.setBackground(Color.white);
        drawPnum.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 12));
        drawPnum.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
        drawPnum.setEditable(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(basic_panel, GroupLayout.PREFERRED_SIZE, 910, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(basic_panel, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE)
        );

        pack();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        imageURL = cldr.getResource("images/Green G.png");
        image = new ImageIcon(imageURL).getImage();
        deck1.setBackground(Color.yellow);
        deck1.setOpaque(false);
        deck1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        deck2.setBackground(Color.yellow);
        deck2.setOpaque(false);
        deck2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
        tablo.setBackground(Color.orange);
        tablo.setOpaque(false);
        Graphics g1 = basic_panel.getGraphics();
        basic_panel.paintComponent(g1);
        basic_panel.repaint();

        for (int i = 0; i < 30; i++) {
            buttons[i] = new JButton();
            if ((i < 7) || ((i < 21 && i > 13))) {
                buttons[i].addActionListener(new CardListener(i));
                buttons[i].addMouseListener(new RightCardListener(i));
                buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        }

        buttons[0].setBounds(3, 3, 67, 100);
        buttons[0].setOpaque(false);
        buttons[0].setEnabled(false);

        buttons[14].setBounds(441, 109, 67, 100);
        buttons[14].setOpaque(false);
        buttons[14].setEnabled(false);
        deck1.add(buttons[14], JLayeredPane.DEFAULT_LAYER);
        deck2.add(buttons[0], JLayeredPane.DEFAULT_LAYER);
        for (int i = 1; i < 8; i++) {
            if (i < 7) {
                buttons[i].setBounds(3 + 73 * i, 3, 67, 100);
                buttons[i + 14].setBounds(441 - 73 * i, 109, 67, 100);
                deck2.add(buttons[i], JLayeredPane.DEFAULT_LAYER);
                deck1.add(buttons[i + 14], JLayeredPane.DEFAULT_LAYER);
            }
            buttons[i + 6].setBounds(3 + 73 * (i - 1), 109, 67, 100);
            buttons[i + 20].setBounds(441 - 73 * (i - 1), 3, 67, 100);
            buttons[i + 6].setOpaque(false);
            buttons[i + 6].setEnabled(false);
            buttons[i + 20].setOpaque(false);
            buttons[i + 20].setEnabled(false);
            deck2.add(buttons[i + 6], JLayeredPane.DEFAULT_LAYER);
            deck1.add(buttons[i + 20], JLayeredPane.DEFAULT_LAYER);
        }
        buttons[28].setBounds(176, 3, 67, 100);
        buttons[29].setBounds(249, 3, 67, 100);
        buttons[29].setOpaque(false);
        buttons[29].setEnabled(false);
        tablo.add(buttons[28], JLayeredPane.DEFAULT_LAYER);
        tablo.add(buttons[29], JLayeredPane.DEFAULT_LAYER);

        cardShare();
        setVisible(true);
    }

    /**
     * transformer:sets some buttons and labels for a new deal
     * Postcondition:sets some buttons and labels for a new deal
     *
     */
    public void init_buttons() {
        Sullogi x = game.getDeck1().getPlayer().getCards();
        Sullogi y = game.getDeck2().getPlayer().getCards();
        for (int i = 0; i < x.size(); i++) {
            imageURL = cldr.getResource("images/" + x.getCard(i).toString() + ".jpg");
            buttons[i + 15].setIcon(new ImageIcon(imageURL));
            buttons[i + 15].setName(x.getCard(i).toString());

            imageURL = cldr.getResource("images/" + y.getCard(i).toString() + ".jpg");
            buttons[i + 1].setIcon(new ImageIcon(imageURL));
            buttons[i + 1].setName(y.getCard(i).toString());
        }

        Card temp = game.getTempCard();
        x.addCard(temp);
        imageURL = cldr.getResource("images/" + temp.toString() + ".jpg");
        buttons[14].setIcon(new ImageIcon(imageURL));
        buttons[14].setName(temp.toString());
        buttons[14].setEnabled(true);

        imageURL = cldr.getResource("images/" + game.getDeck1().getDrawPile().getCard(game.getDeck1().getDrawPile().size() - 1).toString() + ".jpg");
        buttons[28].setIcon(new ImageIcon(imageURL));
        buttons[28].setName(game.getDeck1().getDrawPile().getCard(game.getDeck1().getDrawPile().size() - 1).toString());
        basic_panel.repaint();
    }

    /**
     * transformer:sharing the cards to the players and init the buttons
     */
    public void cardShare() {
        game.shareCards();
        this.init_buttons();
        drawPnum.setText(Integer.toString(game.getDeck1().getDrawPile().size()));
    }
    
    /**
     * a class which is used for putting a background image to a jdesktoppane
     */
    public class myDesktopPane extends JDesktopPane {

        private Image backImage = null;

        public myDesktopPane() {

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    /**
    *transformer: doing some action after New Game or Exit
    * button has been pushed
    */
    private class SettingsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == newGame) {
                MenuDialog J = new MenuDialog("Yes", "No",
                        "Do you really want to play a new game?", "New");
                if (J.choice() == 1) {
                    setVisible(false);
                    new GraphicUI();
                }

            } else if (e.getSource() == Exit) {
                MenuDialog J = new MenuDialog("Yes", "No",
                        "Do you really want to exit?", "Exit");
                if (J.choice() == 1) {
                    System.exit(0);
                }
            }
        }
    }

    /**
    * transformer: doing some action after a card button has been pushed
    */
    private class CardListener implements ActionListener {

        private int buttonNum;
        private String name;

        public CardListener(int i) {
            this.buttonNum = i;
        }

        @Override
        
        public void actionPerformed(ActionEvent e) {
            if (!game.game_has_finished()) {
                if (game.seeTurn() == 1) {
                    if (buttonNum > 7) {
                        Card temp = game.getDeck1().getPlayer().getCard(buttons[buttonNum].getName());
                        if (game.PlayCard(temp, game.getDeck1().getPlayer())) {
                            game.DiscardCard(buttons[buttonNum].getName());
                            this.set_TempTablo();
                            this.set_piles(game.getDeck2());
                            this.set_piles(game.getDeck1());
                        }
                    }
                } else {
                    if (buttonNum < 7) {
                        Card temp = game.getDeck2().getPlayer().getCard(buttons[buttonNum].getName());
                        if (game.PlayCard(temp, game.getDeck2().getPlayer())) {
                            game.DiscardCard(buttons[buttonNum].getName());
                            this.set_TempTablo();
                            this.set_piles(game.getDeck2());
                            this.set_piles(game.getDeck1());
                        }
                    }
                }
            } else {
                String winner = " ";
                if (game.getDeck1().getDistancePile().getTotalMilles() > game.getDeck2().getDistancePile().getTotalMilles()) {
                    winner = "Congratulations! Player 1 you are the winner!!!";
                } else if (game.getDeck1().getDistancePile().getTotalMilles() < game.getDeck2().getDistancePile().getTotalMilles()) {
                    winner = "Congratulations! Player 2 you are the winner!!!";
                } else {
                    winner = "The game is Draw!";
                }
                MenuDialog J = new MenuDialog("Ok", "New Game",
                        winner, "winner");
                if (J.choice() == 2) {
                    setVisible(false);
                    new GraphicUI();
                }
            }
            basic_panel.repaint();

        }

        /**
         * Setting the next card on the drawPile,getting 7th card, p1-p2 score
         */
        private void set_TempTablo() {
            int p, tempP;
            Card temp = game.getTempCard();
            if (game.seeTurn() == 1) {
                p = 14;
                tempP = 0;
                deck1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
                deck2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
            } else {
                p = 0;
                tempP = 14;
                deck1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
                deck2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
            }
            if (temp != null) {
                if (buttonNum != p) {
                    imageURL = cldr.getResource("images/" + buttons[p].getName() + ".jpg");
                    name = buttons[p].getName();
                    buttons[buttonNum].setIcon(new ImageIcon(imageURL));
                    buttons[buttonNum].setName(name);
                }
                buttons[p].setEnabled(false);
                buttons[p].setIcon(null);
                if (p == 14) {
                    game.getDeck2().getPlayer().getCards().addCard(temp);
                } else {
                    game.getDeck1().getPlayer().getCards().addCard(temp);
                }
                imageURL = cldr.getResource("images/" + temp.toString() + ".jpg");
                buttons[tempP].setIcon(new ImageIcon(imageURL));
                buttons[tempP].setName(temp.toString());
                buttons[tempP].setEnabled(true);
                if (!game.getDeck1().isEmptyDrawPile()) {
                    imageURL = cldr.getResource("images/" + game.getDeck1().getDrawPile().getCard(game.getDeck1().getDrawPile().size() - 1).toString() + ".jpg");
                    buttons[28].setIcon(new ImageIcon(imageURL));
                    buttons[28].setName(game.getDeck1().getDrawPile().getCard(game.getDeck1().getDrawPile().size() - 1).toString());
                    drawPnum.setText(Integer.toString(game.getDeck1().getDrawPile().size()));
                } else {
                    buttons[28].setIcon(null);
                    buttons[28].setEnabled(false);
                    buttons[28].setOpaque(false);
                    drawPnum.setText(Integer.toString(game.getDeck1().getDrawPile().size()));
                }
            } else {
                buttons[buttonNum].setIcon(null);
                buttons[buttonNum].setEnabled(false);
                buttons[buttonNum].setOpaque(false);
            }
            game.nextPlayer();
            turn.setText(" Player " + game.seeTurn());
            p1Milles.setText("Player 1: " + Integer.toString(game.p1Milles()));
            p2Milles.setText("Player 2: " + Integer.toString(game.p2Milles()));
        }

        /**
         * Setting the piles of the player that played
         * @param d the deck
         */
        private void set_piles(Deck d) {
            int x;
            if (d.getPlayer().getID() == 1) {
                x = 0;
            } else {
                x = 14;
            }

            if (d.getBattlePile().getCard() == null) {
                buttons[22 - x].setIcon(null);
                buttons[22 - x].setName("b" + (22 - x));
                buttons[22 - x].setEnabled(false);
                buttons[22 - x].setOpaque(false);
            } else {
                imageURL = cldr.getResource("images/" + d.getBattlePile().getCard().toString() + ".jpg");
                buttons[22 - x].setIcon(new ImageIcon(imageURL));
                buttons[22 - x].setEnabled(true);
                buttons[22 - x].setName(d.getBattlePile().getCard().toString());
            }

            if (d.getDistancePile().getLastCard() == null) {
                buttons[23 - x].setIcon(null);
                buttons[23 - x].setName("b" + (23 - x));
                buttons[23 - x].setEnabled(false);
                buttons[23 - x].setOpaque(false);
            } else {
                imageURL = cldr.getResource("images/" + d.getDistancePile().getLastCard().toString() + ".jpg");
                buttons[23 - x].setIcon(new ImageIcon(imageURL));
                buttons[23 - x].setEnabled(true);
                buttons[23 - x].setName(d.getDistancePile().getLastCard().toString());
            }

            if (d.getSpeedPile().getCard() == null) {
                buttons[21 - x].setIcon(null);
                buttons[21 - x].setName("b" + (21 - x));
                buttons[21 - x].setEnabled(false);
                buttons[21 - x].setOpaque(false);
            } else {
                imageURL = cldr.getResource("images/" + d.getSpeedPile().getCard().toString() + ".jpg");
                buttons[21 - x].setIcon(new ImageIcon(imageURL));
                buttons[21 - x].setEnabled(true);
                buttons[21 - x].setName(d.getSpeedPile().getCard().toString());
            }

            Sullogi temp = d.getSafetyPile().getAllCard();
            for (int i = 0; i < temp.size(); i++) {
                if (temp.getCard(i).toString() == null) {
                    return;
                } else {
                    imageURL = cldr.getResource("images/" + temp.getCard(i).toString() + ".jpg");
                    buttons[24 + i - x].setIcon(new ImageIcon(imageURL));
                    buttons[24 + i - x].setEnabled(true);
                    buttons[24 + i - x].setName(temp.getCard(i).toString());
                }

            }
        }

    }
    
    /**
    * transformer: doing some action after a right push on a button
    */
    private class RightCardListener extends MouseAdapter {

        private int buttonNum;
        private String name;

        public RightCardListener(int i) {
            this.buttonNum = i;
        }

        
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                //player1
                if (!game.game_has_finished()) {
                    if (game.seeTurn() == 1) {
                        game.DiscardCard(buttons[buttonNum].getName());
                        if (buttonNum > 7) {
                            imageURL = cldr.getResource("images/" + buttons[buttonNum].getName() + ".jpg");
                            buttons[29].setIcon(new ImageIcon(imageURL));
                            buttons[29].setEnabled(true);
                            this.set_TempTablo();
                        }
                        //player2
                    } else {
                        game.DiscardCard(buttons[buttonNum].getName());
                        if (buttonNum < 7) {
                            imageURL = cldr.getResource("images/" + buttons[buttonNum].getName() + ".jpg");
                            buttons[29].setIcon(new ImageIcon(imageURL));
                            buttons[29].setEnabled(true);
                            this.set_TempTablo();
                        }
                    }
                } else {
                    String winner = " ";
                    if (game.getDeck1().getDistancePile().getTotalMilles() > game.getDeck2().getDistancePile().getTotalMilles()) {
                        winner = "Congratulations! Player 1 you are the winner!!!";
                    } else if (game.getDeck1().getDistancePile().getTotalMilles() < game.getDeck2().getDistancePile().getTotalMilles()) {
                        winner = "Congratulations! Player 2 you are the winner!!!";
                    } else {
                        winner = "The game is Draw!";
                    }

                    MenuDialog J = new MenuDialog("Ok", "New Game",
                            winner, "winner");
                    if (J.choice() == 2) {
                        setVisible(false);
                        new GraphicUI();
                    }
                }
            }
            basic_panel.repaint();
        }

        /**
         * Setting the next card on the drawPile,getting 7th card, p1-p2 score
         */
        private void set_TempTablo() {
            int p, tempP;
            Card temp = game.getTempCard();
            if (game.seeTurn() == 1) {
                p = 14;
                tempP = 0;
                deck1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
                deck2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
            } else {
                p = 0;
                tempP = 14;
                deck1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
                deck2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
            }
            if (temp != null) {
                if (buttonNum != p) {
                    imageURL = cldr.getResource("images/" + buttons[p].getName() + ".jpg");
                    name = buttons[p].getName();
                    buttons[buttonNum].setIcon(new ImageIcon(imageURL));
                    buttons[buttonNum].setName(name);
                }
                buttons[p].setEnabled(false);
                buttons[p].setIcon(null);
                if (p == 14) {
                    game.getDeck2().getPlayer().getCards().addCard(temp);
                } else {
                    game.getDeck1().getPlayer().getCards().addCard(temp);
                }
                imageURL = cldr.getResource("images/" + temp.toString() + ".jpg");
                buttons[tempP].setIcon(new ImageIcon(imageURL));
                buttons[tempP].setName(temp.toString());
                buttons[tempP].setEnabled(true);
                if (!game.getDeck1().isEmptyDrawPile()) {
                    imageURL = cldr.getResource("images/" + game.getDeck1().getDrawPile().getCard(game.getDeck1().getDrawPile().size() - 1).toString() + ".jpg");
                    buttons[28].setIcon(new ImageIcon(imageURL));
                    buttons[28].setName(game.getDeck1().getDrawPile().getCard(game.getDeck1().getDrawPile().size() - 1).toString());
                    drawPnum.setText(Integer.toString(game.getDeck1().getDrawPile().size()));
                } else {
                    buttons[28].setIcon(null);
                    buttons[28].setEnabled(false);
                    buttons[28].setOpaque(false);
                    drawPnum.setText(Integer.toString(game.getDeck1().getDrawPile().size()));
                }
            } else {
                buttons[buttonNum].setIcon(null);
                buttons[buttonNum].setName("b" + buttonNum);
                buttons[buttonNum].setEnabled(false);
                buttons[buttonNum].setOpaque(false);
            }
            game.nextPlayer();
            turn.setText(" Player " + game.seeTurn());
            p1Milles.setText("Player 1: " + Integer.toString(game.p1Milles()));
            p2Milles.setText("Player 2: " + Integer.toString(game.p2Milles()));

        }
    }
}
