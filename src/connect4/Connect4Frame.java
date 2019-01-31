package connect4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.Timer;

class AddButtonsActionListener implements ActionListener {

    int col;
    Connect4Frame game;

    public AddButtonsActionListener(int col, Connect4Frame game) {
        this.col = col;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 5; i >= 0; i--) {
            if (game.mainGame.filledPlaces[i][col] == "") {
                game.mainGame.filledPlaces[i][col] = game.currentColorString();
                game.mainGame.repaint();
                if (game.currentPlayer == game.colorOne) {
                    game.currentPlayer = game.colorTwo;
                } else {
                    game.currentPlayer = game.colorOne;
                }
                break;
            }
        }
        for (int i = 0; i < 7; i++) {
            game.addButtons[i].setBackground(game.currentPlayer);
        }
        if (game.whoWon() == "1" || game.whoWon() == "2" || game.isFull() == true) {
            String temp = game.whoWon();
            JFrame frame = new JFrame();
            if (temp == "1" || temp == "2"){
            JOptionPane.showMessageDialog(frame, "Player " + temp + " won the game!", "Congratulations!", JOptionPane.DEFAULT_OPTION);
            }
            else if (temp == "None"){
            JOptionPane.showMessageDialog(frame, "It's a draw, what a game!", "Oops!", JOptionPane.DEFAULT_OPTION);
            }
            game.resetBoard();
        }
    }
}

public class Connect4Frame extends JFrame {

    Connect4Panel mainGame = new Connect4Panel(this);
    JPanel buttonPanel = new JPanel();
    Color colorOne;
    Color colorTwo;
    public JButton addButtons[] = new JButton[7];
    Color currentPlayer;

    public Connect4Frame(Color colorOne, Color colorTwo) {
        this.setLocation(400, 200);
        this.colorOne = colorOne;
        this.colorTwo = colorTwo;
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Player 1 starts the game, your color is shown in the bottom panel!", "Start", JOptionPane.DEFAULT_OPTION);
        this.currentPlayer = colorOne;
        this.setLayout(new BorderLayout());
        this.setBounds(200, 200, 548, 523);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(mainGame, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(1, 6));
        for (int i = 0; i < 7; i++) {
            addButtons[i] = new JButton();
            addButtons[i].setText("Place");
            buttonPanel.add(addButtons[i]);
            addButtons[i].addActionListener(new AddButtonsActionListener(i, this));
             this.addButtons[i].setBackground(colorOne);
            
        }
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    
   public boolean isFull(){
       for (int i = 0; i < 6; i++){
           for (int j = 0; j < 7; j++){
               if (this.mainGame.filledPlaces[i][j] == "") return false;
           }
       }
       return true;
   }
    
    public String currentColorString() {
        if (this.currentPlayer == colorOne) {
            return "1";
        } else {
            return "2";
        }
    }

    public String whoWon() {
        int colorOneIndex = 0;
        int colorTwoIndex = 0;
        //Diagonal, TL -> BR, Lower
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 4 + k; i++) {
                if (this.mainGame.filledPlaces[2 - k + i][i] == "1") {
                    colorOneIndex += 1;
                    colorTwoIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
                if (this.mainGame.filledPlaces[2 - k + i][i] == "2") {
                    colorTwoIndex += 1;
                    colorOneIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
            }
            if (colorOneIndex == 4) {
                return "1";
            } else {
                colorOneIndex = 0;
            }
            if (colorTwoIndex == 4) {
                return "2";
            } else {
                colorTwoIndex = 0;
            }
        }
        //Diagonal, TL -> BR, Higher
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 4 + k; i++) {
                if (this.mainGame.filledPlaces[i][3 - k + i] == "1") {
                    colorOneIndex += 1;
                    colorTwoIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
                if (this.mainGame.filledPlaces[i][3 - k + i] == "2") {
                    colorTwoIndex += 1;
                    colorOneIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
            }
            if (colorOneIndex == 4) {
                return "1";
            } else {
                colorOneIndex = 0;
            }
            if (colorTwoIndex == 4) {
                return "2";
            } else {
                colorTwoIndex = 0;
            }
        }
        //Diagonal, TR -> BL, Lower
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i <= 3 + k; i++) {
                if (this.mainGame.filledPlaces[2 - k + i][6 - i] == "1") {
                    colorOneIndex += 1;
                    colorTwoIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
                if (this.mainGame.filledPlaces[2 - k + i][6 - i] == "2") {
                    colorTwoIndex += 1;
                    colorOneIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
            }
            if (colorOneIndex == 4) {
                return "1";
            } else {
                colorOneIndex = 0;
            }
            if (colorTwoIndex == 4) {
                return "2";
            } else {
                colorTwoIndex = 0;
            }
        }
        //Diagonal, TR -> BL, Higher
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i <= 3 + k; i++) {
                if (this.mainGame.filledPlaces[i][3 + k - i] == "1") {
                    colorOneIndex += 1;
                    colorTwoIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
                if (this.mainGame.filledPlaces[i][3 + k - i] == "2") {
                    colorTwoIndex += 1;
                    colorOneIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
            }
            if (colorOneIndex == 4) {
                return "1";
            } else {
                colorOneIndex = 0;
            }
            if (colorTwoIndex == 4) {
                return "2";
            } else {
                colorTwoIndex = 0;
            }
        }
        //Rows
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (this.mainGame.filledPlaces[i][j] == "1") {
                    colorOneIndex += 1;
                    colorTwoIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
                if (this.mainGame.filledPlaces[i][j] == "2") {
                    colorTwoIndex += 1;
                    colorOneIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
            }
            if (colorOneIndex == 4) {
                return "1";
            } else {
                colorOneIndex = 0;
            }
            if (colorTwoIndex == 4) {
                return "2";
            } else {
                colorTwoIndex = 0;
            }
        }
        //Columns
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 6; i++) {
                if (this.mainGame.filledPlaces[i][j] == "1") {
                    colorOneIndex += 1;
                    colorTwoIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
                if (this.mainGame.filledPlaces[i][j] == "2") {
                    colorTwoIndex += 1;
                    colorOneIndex = 0;
                    if (colorOneIndex == 4 || colorTwoIndex == 4) {
                        break;
                    }
                }
            }
            if (colorOneIndex == 4) {
                return "1";
            } else {
                colorOneIndex = 0;
            }
            if (colorTwoIndex == 4) {
                return "2";
            } else {
                colorTwoIndex = 0;
            }
        }

        return "None";
    }

    public void resetBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                this.mainGame.filledPlaces[i][j] = "";
            }
        }
        this.currentPlayer = colorOne;
        for (int i = 0; i < 7; i++) {
            this.addButtons[i].setBackground(colorOne);
        }
        this.mainGame.repaint();
    }
}
