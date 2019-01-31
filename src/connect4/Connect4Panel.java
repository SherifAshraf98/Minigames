/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Connect4Panel extends JPanel {
    private BufferedImage image;
    public String filledPlaces[][] = new String[6][7];
    Connect4Frame parent;
    public Connect4Panel(Connect4Frame parent) {
        this.parent = parent;
        initFilledPlacesArray();
       try {
          
          //image = ImageIO.read(new File("Board.gif"));
          image = ImageIO.read(getClass().getResource("Board.gif"));
       } catch (Exception ex) {
            System.out.println("Problem with image");
       }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (filledPlaces[i][j] == "1") {
                    g.setColor(parent.colorOne);
                    g.fillOval((5 * j) + (70 * j) + 5, (5 * i) +(70 * i) + 6, 70, 70);
                }
                else if (filledPlaces[i][j] == "2") {
                    g.setColor(parent.colorTwo);
                    g.fillOval((5 * j) + (70 * j) + 5, (5 * i) +(70 * i) + 6, 70, 70);
                }
                else if (filledPlaces [i][j] == ""){
                    g.setColor(new Color(42,58,99));
                    g.fillOval((5 * j) + (70 * j) + 5, (5 * i) +(70 * i) + 6, 70, 70);
                }
            }
        }
    }
    public void initFilledPlacesArray(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                this.filledPlaces[i][j] = "";
            }
        }
    }
}
