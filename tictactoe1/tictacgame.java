import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.event.DocumentListener;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class tictacgame extends JFrame implements ActionListener{
    char playerMark = 'X'; //the users playermark.

    JButton[] buttons = new JButton[9]; //makes 9 buttons
    Container contentPane = getContentPane(); //the container

    //Game and right panels
    JPanel gamePanel = new JPanel();
    JPanel rightPanel = new JPanel();
    String playerMark1 = "";
    String m = ""; // the users name is stored in this string.

    JLabel displayUser = new JLabel(m);
    static JMenuBar menuBar;
    static JMenu x;
    static JMenuItem x1,x2;

    public static final int ROWS = 3; //3 rows made.
    public static final int COLS = 3; //3 collums made. 3x3 = 9 which is the 9 squares for the grid.
    boolean computerBOO = false;
    boolean yes = true; //boolean for creating name.
    boolean yes1 = true; //boolean for updating name.

    String [][] gridLay = new String [3][3]; //creates the grid.
    Button a=new Button("Start"); //start button 
    Button b=new Button("Re-play"); //replay button
    public tictacgame() {
        //most of this is just setting the placements of all the panels.
        contentPane.setLayout(new BorderLayout());
        contentPane.add(gamePanel, BorderLayout.CENTER); 
        contentPane.add(rightPanel, BorderLayout.EAST);

        //adds start and replay button.
        rightPanel.add(a);
        rightPanel.add(b);

        //adds actuon listener functions to buttons
        a.addActionListener(e -> initializeButtons1());
        b.addActionListener(e -> resetTheButtons1());

        a.setEnabled(false);
        //user data becomes name. if they input nothing it prompts them to enter a name.
        while(yes){
            String m = JOptionPane.showInputDialog("Enter Username."); 
            if(!m.isEmpty()) {

                this.m = m;
                yes = false;
                a.setEnabled(true);

            }

            else {

                JOptionPane.showMessageDialog(null, "Enter a username!");

            }
        }

        JLabel displayUser = new JLabel(m + " turn");
        contentPane.add(displayUser, BorderLayout.NORTH);
        displayUser.setHorizontalAlignment(JLabel.CENTER);

        gamePanel.setLayout(new GridLayout(ROWS,COLS));
        initializeButtons();
        menuBar = new JMenuBar();

        //creates menu for top left. and the dropdown for that menu is reset and quit.
        x1 = new JMenuItem("Reset");
        x2 = new JMenuItem("Quit");
        x = new JMenu("Menu");

        x.add(x1);
        x.add(x2);
        menuBar.add(x);
        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        setBounds(750,500,500,500); // sets the area of screen
        setVisible(true); // makes window visible so you can see it.

        // action listener for reset and quit.
        x1.addActionListener(e -> resetTheButtons2()); 
        x2.addActionListener(e -> System.exit(0));

        b.setEnabled(false);
    }

    private void AIturn() {

        boolean computersTurn = true;

        int [] num9 = {1,2,3,4,5,6,7,8}; 
        int counter1 = 1;
        //if the winner hasnt been 
        while(computersTurn && !checkWinner() && counter1 < 3 ){
            Random rn = new Random();
            int turnPlace = rn.nextInt((num9.length) + 1);

            for(int i = 0; i <= 9; i++){

                if(turnPlace == 0 && buttons[0].getText().equals("-")){
                    buttons[0].setText("O");
                    computersTurn = false;
                    computerBOO = false;
                    playerMark1 = "Computer";
                    counter1++;
                }
                else if(turnPlace == 1 && buttons[1].getText().equals("-") ){
                    buttons[1].setText("O");
                    computersTurn = false;
                    computerBOO = false;
                    playerMark1 = "Computer";
                    counter1++;
                }
                else if(turnPlace == 2 && buttons[2].getText().equals("-")){
                    buttons[2].setText("O");
                    computersTurn = false;
                    computerBOO = false;
                    playerMark1 = "Computer";
                    counter1++;
                }
                else if(turnPlace == 3 && buttons[3].getText().equals("-") ){
                    buttons[3].setText("O");
                    computersTurn = false;
                    computerBOO = false;
                    playerMark1 = "Computer";
                    counter1++;
                }
                else if(turnPlace == 4 && buttons[4].getText().equals("-")){
                    buttons[4].setText("O");
                    computersTurn = false;
                    computerBOO = false;
                    playerMark1 = "Computer";
                    counter1++;
                }
                else if(turnPlace == 5 && buttons[5].getText().equals("-")){
                    buttons[5].setText("O");
                    computersTurn = false;
                    computerBOO = false;
                    playerMark1 = "Computer";
                    counter1++;
                }
                else if(turnPlace == 6 && buttons[6].getText().equals("-")){
                    buttons[6].setText("O");
                    computersTurn= false;
                    computerBOO = false;
                    playerMark1 = "Computer";
                    counter1++;
                }
                else if(turnPlace == 7 && buttons[7].getText().equals("-")){
                    buttons[7].setText("O");
                    computersTurn = false;
                    computerBOO = false;
                    playerMark1 = "Computer";
                    counter1++;
                }
                else if(turnPlace == 8 && buttons[8].getText().equals("-")){
                    buttons[8].setText("O");
                    computersTurn = false;
                    computerBOO = false;
                    playerMark1 = "Computer";
                    counter1++;
                }

            }
        }
    }

        public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tictacgame game = new tictacgame();
                game.setVisible(true);
            }
        });
    }
}

    private void resetTheButtons2() {
        //resets all buttons and askes for name again.
        playerMark = 'X';
        yes1 = true;
        while(yes1) {
            String m = JOptionPane.showInputDialog("Enter Username."); 
            if (m.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Enter a username!");

            }
            else{

                this.m = m;
                yes1 = false;
                a.setEnabled(true);

                displayUser.setText(m + " Turn");

            }
        }

        for(int i =0;i<9;i++) {
            buttons[i].setText("-");
            buttons[i].setEnabled(false);

        }    

        b.setEnabled(false);
        a.setEnabled(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        //game closes if they pick quit.
        if(e.getSource()==x1) {

        }
        else if(e.getSource()==x2){
            System.exit(0);

        }
    }

    public void initializeButtons1()
    {
        //creates buttons
        for(int i = 0; i <= 8; i++){

            buttons[i].setEnabled(true);
        }
        a.setEnabled(false);
        b.setEnabled(true);
    }

    public void initializeButtons()
    {
        //creates buttons and has some functionality for user/computer inputs.
        for(int i = 0; i <= 8; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setText("-");
            buttons[i].setBackground(Color.white);
            buttons[i].addActionListener(new ActionListener() 
                {

                    public void actionPerformed(ActionEvent e) {
                        JButton buttonClicked = (JButton) e.getSource(); //gets the clicked button

                        if(buttonClicked.getText().charAt(0) == '-') {
                            buttonClicked.setText(String.valueOf(playerMark)); 
                            playerMark1 = "X";

                            computerBOO = true;
                            winner(); 

                            if(computerBOO && checkWinner() == false){
                                //if the user hasnt won then it will do AI turn after the user has done there go. so userinput -> check if they won from -> if not they ai does turn.
                                AIturn();
                            }
                        }

                        winner(); 
                    }
                });
            gamePanel.add(buttons[i]);     
            buttons[i].setEnabled(false);
        }
    }

    public void winner() {
        //checks winner
        if(checkWinner() == true) {
            computerBOO = false;
            // if(playerMark1 == "X") {
            // playerMark1 = "O";
            // }
            // else {
            // playerMark1 ="X";

            // }
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over. "+ playerMark1 + " wins. Would you like to play again?","Game over.",
                    JOptionPane.YES_NO_OPTION);

            if(dialogResult == JOptionPane.YES_OPTION){ 
                resetTheButtons3();

            }
            else {
                System.exit(0);
            }
        }
        else if(draw()) {
            //checks explanatory.
            computerBOO = false;

            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, "Draw. Play again?","Game over.", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION) { 
                resetTheButtons3();

            }
            else {
                System.exit(0);
            }
        }
    }

    private void resetTheButtons() {
        //self explanitory. checks if its a draw.
        playerMark = 'X';
        for(int i =0;i<9;i++) {

            buttons[i].setText("-");

        }    
    }

    private void resetTheButtons1() {
        //self explanitory. checks if its a draw. this one turns start off after game starts.
        playerMark = 'X';
        for(int i =0;i<9;i++) {

            buttons[i].setText("-");
            buttons[i].setEnabled(true);

        }    
        b.setEnabled(true);
        a.setEnabled(false);
    }

    private void resetTheButtons3() {
        //self explanitory. checks if its a draw. this one turns replay off after clicked.
        playerMark = 'X';
        for(int i =0;i<9;i++) {

            buttons[i].setText("-");
            buttons[i].setEnabled(false);

        }    
        b.setEnabled(false);
        a.setEnabled(true);
    }

    public boolean draw() {
        //checks draw
        boolean full = true;
        for(int i = 0 ; i<9; i++) {
            if(buttons[i].getText().charAt(0) == '-' || buttons[i].getText().equals("-")) {
                full = false;
            }
        }
        return full;
    }

    public boolean checkWinner() {
        //checks winner
        if(Rows() == true || Columns() == true || Diagonals() == true) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean Rows() {
        //checks whats in the rows and is used for winner
        int i = 0;
        for(int j = 0;j<3;j++) {
            if( buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) 
            && buttons[i].getText().charAt(0) != '-') {
                return true;
            }
            i = i+3;

        }
        return false;
    }

    public boolean Columns() {
        //checks whats in the columns and is used for winner
        int i = 0;
        for(int j = 0;j<3;j++) {
            if( buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText())
            && buttons[i].getText().charAt(0) != '-') 
            {
                return true;
            }
            i++;
        }
        return false;    
    }

    public boolean Diagonals() {
        //checks whats in the diagonals and is used for winner.
        if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText())
        && buttons[0].getText().charAt(0) !='-')
            return true;
        else if(buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText())
        && buttons[2].getText().charAt(0) !='-'){       
            return true;
        }
        else{
            return false;
        }
    }

}
