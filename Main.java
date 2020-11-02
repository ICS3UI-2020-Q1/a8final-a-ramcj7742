import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables 
  JPanel mainPanel;

  JLabel countLabel;

  JTextField display;

  JButton resetButton;
  JButton countDownButton;
  


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initalize main panel and disable layout helpers
    mainPanel = new JPanel();
    mainPanel.setLayout(null);

    //create the count label 
    countLabel = new JLabel("Counter:");

    //set location and size of label 
    countLabel.setBounds(80, 40, 150, 20);

    //create the display
    display = new JTextField("10");

    //set size and location of display
    display.setBounds(250, 30, 200, 30);

    //disable the display
    display.setEnabled(false);

    //create the buttons
    resetButton = new JButton("Reset");
    countDownButton = new JButton("Count Down");

    //sets location and size for buttons
    resetButton.setBounds(80, 80, 175, 30);
    countDownButton.setBounds(265, 80, 175, 30);

    //adds action listener to buttons
    resetButton.addActionListener(this);
    countDownButton.addActionListener(this);

    //sets action command to buttons
    resetButton.setActionCommand("reset");
    countDownButton.setActionCommand("countDown");

    //puts everything on the main panel
    mainPanel.add(countLabel);
    mainPanel.add(countDownButton);
    mainPanel.add(display);
    mainPanel.add(resetButton);

    //adds main panel to frame
    frame.add(mainPanel);

 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //gets user button press
    if(command.equals("countDown")){
      //gets text currently on display
      String displayText = display.getText();
      int displayInt = Integer.parseInt(displayText);
      //takes one away from the current # on screen, unless # is 0
      if(displayInt > 0){
        displayInt = displayInt - 1;
        display.setText("" + displayInt);
      }
    }else if(command.equals("reset")){
      display.setText("10");
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
