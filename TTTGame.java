/*Seif Mohamed--
This project is simple 2 players tic tac toe game using java graphics 
 */

import javax.swing.JFrame; 
import javax.swing.JButton; 
import javax.swing.BoxLayout; 
import javax.swing.Box; 
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField; 
import java.awt.*;  
import javax.swing.*; 
import java.awt.geom.Line2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.event.*;

public class TTTGame extends JFrame implements MouseListener {

	/*  Creating all needed variables 
	1- p1 and p2 are players scores
	2- Counter to count each time player plays to help determine whose turn
	3- Games is the number of games played to help determine at the following game who begins
	4- valid is simply deffined to determine whether the mouse should do event in a specific situation
	5- game array is 2 dim array to record the moves (the array is set to zero and if an index has X it sets
	to 1 and if it has O it setss to 2) 
	6- 9 labels to show X and O on screen
	7- States panel that includes turn and scores textfields to show the status and who's turn */
	protected static int p1 = 0;
	protected static int p2 = 0;
	protected static int Counter = 0;
	protected static int games = 0;
	protected static boolean valid = true;

	protected static int [][] game = new int [3][3];
	protected static JLabel b1 = new JLabel ("");
	protected static JLabel b2 = new JLabel ("");
	protected static JLabel b3 = new JLabel ("");
	protected static JLabel b4 = new JLabel ("");
	protected static JLabel b5 = new JLabel ("");
	protected static JLabel b6 = new JLabel ("");
	protected static JLabel b7 = new JLabel ("");
	protected static JLabel b8 = new JLabel ("");
	protected static JLabel b9 = new JLabel ("");
	protected static JPanel Status = new JPanel();
	protected static JTextField turn = new JTextField();
	protected static JTextField scores = new JTextField("P1 (X) =   " + p1 + "    :    P2 (O) =   " + p2);


	// method to check if X wins
	public static boolean checkForWinP1(){
		boolean win = false;
		int i;
		

			for (i = 0; i < 3; i++){
				if ((game [i][0] == 1) && (game[i][1] == 1) && (game [i][2] == 1) )
				win = true;
			}

			for (i = 0; i < 3; i++){
				if ((game [0][i] == 1) && (game[1][i] == 1) && (game [2][i] == 1) )
				win = true;
			}

			if ((game [0][0] == 1) && (game[1][1] == 1) && (game[2][2] == 1))
				win = true;

			if ((game [0][2] == 1) && (game[1][1] == 1) && (game[2][0] == 1))
				win = true;

			return win;

	}

	// method to check if O wins
	public static boolean checkForWinP2(){
		boolean win = false;
		int i;
		

			for (i = 0; i < 3; i++){
				if ((game [i][0] == 2) && (game[i][1] == 2) && (game [i][2] == 2) )
				win = true;
			}

			for (i = 0; i < 3; i++){
				if ((game [0][i] == 2) && (game[1][i] == 2) && (game [2][i] == 2) )
				win = true;
			}

			if ((game [0][0] == 2) && (game[1][1] == 2) && (game[2][2] == 2))
				win = true;

			if ((game [0][2] == 2) && (game[1][1] == 2) && (game[2][0] == 2))
				win = true;

			return win;
		}

		// Method to set all label to empty again after the game ends
	public static void setLabelToZero(){

			b1.setText("");
			b2.setText("");
			b3.setText("");
			b4.setText("");
			b5.setText("");
			b6.setText("");
			b7.setText("");
			b8.setText("");
			b9.setText("");

			}

	// method to set all values of the game array to zero after the game ends
	public static void setToZero() {
		int i;
		int j;
		for (i = 0; i < 3; i++){
			for (j = 0; j < 3; j++){
				game [i][j] = 0;
			}
		}
	}

	// method to print popup message if a player wins
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

  // constructer method to create mouse listener 
 public void mousePressed(MouseEvent e) {
 	/* Here is the whole idea so when the mouse is clicked we determine where it click using 
 	getX() and getY() methods based on the coordinates where the player click we do two things change the label of 
 	that square and change the value of the game array at that squar (notice the additional if statement if game == 0 
 	this statement to ensure that there is no value here already to prevent players from playing the same square twice)
 	 we also increase the counter varible to determine that it's the next player turn */


 	if (valid){
        if ((e.getY() > 190) && (e.getY() < 290) && (e.getX() > 100) && (e.getX() < 200)) {
       	//System.out.println("works 1");

        	if ((Counter % 2 == 0) && (game[0][0] == 0)){

               	b1.setText("X");
           		game [0][0] = 1;
           		Counter++;
           	}

           	if ((Counter % 2 == 1) && (game[0][0] == 0)){

               	b1.setText("O");
           		game [0][0] = 2;
           		Counter++;
           	}

         }

       	if ((e.getY() > 190) && (e.getY() < 290) && (e.getX() > 200) && (e.getX() < 300)) {
       	// System.out.println("works 2");

       		if ((Counter % 2 == 0) && (game[0][1] == 0)){

               	b2.setText("X");
           		game [0][1] = 1;
           		Counter++;
           	}

           	if ((Counter % 2 == 1) && (game[0][1] == 0)){

               	b2.setText("O");
           		game [0][1] = 2;
           		Counter++;
           	}
         }

       	if ((e.getY() > 190) && (e.getY() < 290) && (e.getX() > 300) && (e.getX() < 400)) {
       	System.out.println("works 3");

       		 if ((Counter % 2 == 0) && (game[0][2] == 0)){

               	b3.setText("X");
           		game [0][2] = 1;
           		Counter++;
           	}

           	if ((Counter % 2 == 1) && (game[0][2] == 0)){

               	b3.setText("O");
           		game [0][2] = 2;
           		Counter++;
      		 }
   		}

       	if ((e.getY() > 290) && (e.getY() < 390) && (e.getX() > 100) && (e.getX() < 200)){
       	// System.out.println("works 4");

       		if ((Counter % 2 == 0) && (game[1][0] == 0)){

               	b4.setText("X");
           		game [1][0] = 1;
           		Counter++;
           	}

           	if ((Counter % 2 == 1) && (game[1][0] == 0)){

               	b4.setText("O");
           		game [1][0] = 2;
           		Counter++;
           	}

         }

       	if ((e.getY() > 290) && (e.getY() < 390) && (e.getX() > 200) && (e.getX() < 300)){
       	System.out.println("works 5");

       		if ((Counter % 2 == 0) && (game[1][1] == 0)){

               	b5.setText("X");
           		game [1][1] = 1;
           		Counter++;
           	}

           	if ((Counter % 2 == 1) && (game[1][1] == 0)){

               	b5.setText("O");
           		game [1][1] = 2;
           		Counter++;
           	}
           }

       	if ((e.getY() > 290) && (e.getY() < 390) && (e.getX() > 300) && (e.getX() < 400)){
       	System.out.println("works 6");

       		if ((Counter % 2 == 0) && (game[1][2] == 0)){

               	b6.setText("X");
           		game [1][2] = 1;
           		Counter++;
           	}

           	if ((Counter % 2 == 1) && (game[1][2] == 0)){

               	b6.setText("O");
           		game [1][2] = 2;
           		Counter++;
           	}
           }

       	if ((e.getY() > 390) && (e.getY() < 490) && (e.getX() > 100) && (e.getX() < 200)){
       	System.out.println("works 7");

       		if ((Counter % 2 == 0) && (game[2][0] == 0)){

               	b7.setText("X");
           		game [2][0] = 1;
           		Counter++;
           	}

           	if ((Counter % 2 == 1) && (game[2][0] == 0)){

               	b7.setText("O");
           		game [2][0] = 2;
           		Counter++;
           	}
           }

       	if ((e.getY() > 390) && (e.getY() < 490) && (e.getX() > 200) && (e.getX() < 300)) {
       	System.out.println("works 8");

       		if ((Counter % 2 == 0) && (game[2][1] == 0)){

               	b8.setText("X");
           		game [2][1] = 1;
           		Counter++;
           	}

           	if ((Counter % 2 == 1) && (game[2][1] == 0)){

               	b8.setText("O");
           		game [2][1] = 2;
           		Counter++;
           	}
           }

       	if ((e.getY() > 390) && (e.getY() < 490) && (e.getX() > 300) && (e.getX() < 400)) {
       	System.out.println("works 9");

       		if ((Counter % 2 == 0) && (game[2][2] == 0)){

               	b9.setText("X");
           		game [2][2] = 1;
           		Counter++;
           	}

           	if ((Counter % 2 == 1) && (game[2][2] == 0)){

               	b9.setText("O");
           		game [2][2] = 2;
           		Counter++;
           	}
           }

           /* after each click these to condition checks if someone won. if so we increase that player's score
           and increase number of games and set  valid to false so that no one can do anything using mouse unless we start a new game */
           if (checkForWinP1()){
           	
           		games++;
           		p1++;
           		valid = false;
           		TTTGame.infoBox("Player 1 (X) Wins, Please start New Game", "P1 Wins");
           		
           	}

           	if (checkForWinP2()){
           		
           		games++;
           		p2++;
           		valid = false;
           		TTTGame.infoBox("Player 2 (O) Wins, Please start New Game", "P2 Wins");
           		
           	}
           	// This is just to update the status panel after each move
           	 scores.setText("P1 (X) =   " + p1 + "    :    P2 (O) =  " + p2);
				if (Counter % 2 == 0)
					turn.setText("It's P1 (X) turn");
				else if (Counter % 2 == 1)
					turn.setText("It's P2 (O) turn");



       	}
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
    
    }

    public void mouseExited(MouseEvent e) {
       
    }

    public void mouseClicked(MouseEvent e) {
      
    }
    // constructer method of the class

    TTTGame (){

    	// creating the frame to display the game
    	JFrame Game = new JFrame();
		Game.setSize(480,580);
		Game.setTitle("TTTGame");
		Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game.addMouseListener(this);


		//Creating Status panel
		BoxLayout boxlayout = new BoxLayout(Status, BoxLayout.X_AXIS);
		Status.setLayout(boxlayout);
		Status.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
		Status.setSize(480, 100);
		JFrame.setDefaultLookAndFeelDecorated(true);
		

		//Creating button
		JButton Start = new JButton("New Game");
		Status.add(Start);
		Start.setMargin(new Insets(10, 10, 10, 10));
		Status.add(Box.createRigidArea(new Dimension(60, 0)));
		Start.addActionListener(new ActionListener() {

		 public void actionPerformed(ActionEvent ae) {

		 	setToZero();
           	setLabelToZero();
           	valid = true;
           	if (games % 2 == 0)
           		Counter = 0;
           	if (games % 2 == 1)
           		Counter =1;
           	

		 	}
     	
      	});

		//creating Player's turn
		
		if (Counter % 2 == 0)
			turn.setText("It's P1 (X) turn");
		else 
			turn.setText("It's P2 (O) turn");
			
		turn.setEditable(false);
		turn.setHorizontalAlignment(JTextField.CENTER);
		Status.add(turn);


		Status.add(Box.createRigidArea(new Dimension(60, 0)));

		//Creating players scores
		
		scores.setEditable(false);
		scores.setHorizontalAlignment(JTextField.CENTER);
		Status.add(scores);

		//crerating labels

		b1.setBounds(95,162,96,96);
		Game.add(b1);
		b1.setFont(new Font("Arial", Font.PLAIN, 40));
		//b1.setText("X");
		b1.setHorizontalAlignment(JTextField.CENTER);

		b2.setBounds(195,162,96,96);
		Game.add(b2);
		b2.setFont(new Font("Arial", Font.PLAIN, 40));
		//b2.setText("X");
		b2.setHorizontalAlignment(JTextField.CENTER);

		b3.setBounds(295,162,96,96);
		Game.add(b3);
		b3.setFont(new Font("Arial", Font.PLAIN, 40));
		//b3.setText("X");
		b3.setHorizontalAlignment(JTextField.CENTER);

		b4.setBounds(95,262,96,96);
		Game.add(b4);
		b4.setFont(new Font("Arial", Font.PLAIN, 40));
		//b4.setText("X");
		b4.setHorizontalAlignment(JTextField.CENTER);

		b5.setBounds(195,262,96,96);
		Game.add(b5);
		b5.setFont(new Font("Arial", Font.PLAIN, 40));
		//b5.setText("X");
		b5.setHorizontalAlignment(JTextField.CENTER);

		b6.setBounds(295,262,96,96);
		Game.add(b6);
		b6.setFont(new Font("Arial", Font.PLAIN, 40));
		//b6.setText("X");
		b6.setHorizontalAlignment(JTextField.CENTER);

		b7.setBounds(95,362,96,96);
		Game.add(b7);
		b7.setFont(new Font("Arial", Font.PLAIN, 40));
		//b7.setText("X");
		b7.setHorizontalAlignment(JTextField.CENTER);

		b8.setBounds(195,362,96,96);
		Game.add(b8);
		b8.setFont(new Font("Arial", Font.PLAIN, 40));
		//b8.setText("X");
		b8.setHorizontalAlignment(JTextField.CENTER);

		b9.setBounds(295,362,96,96);
		Game.add(b9);
		b9.setFont(new Font("Arial", Font.PLAIN, 40));
		//b9.setText("X");
		b9.setHorizontalAlignment(JTextField.CENTER);


		// finally adding everything to the panel and create instance of the board class that is declared in the other file to draw the board

		Game.add(Status);
		Board L = new Board();
		Game.add(L);
		Game.setVisible(true);

    }
    // then our main method that just create instance of the game class using the constructor method 
         public static void main (String [] args){
         TTTGame board = new TTTGame();


    }

	}
