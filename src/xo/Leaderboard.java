/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


public class Leaderboard extends JFrame {
    private JLabel[] listLbl;
    private JLabel separatorLbl[];
    private int maxScore=0;
    public Leaderboard()
    {
    this.setResizable(false);
    this.setTitle("Leaderboard");
    this.setBounds(400,200,450,600);
    Container c= this.getContentPane();
    c.setLayout(new GridLayout(50,1));
    listLbl=new JLabel[Player.list.size()];
    separatorLbl=new JLabel[Player.list.size()];
    for(int i=0;i<separatorLbl.length;i++){
        separatorLbl[i]=new JLabel("------------------------------------------------------------------------------------------");
    }
    for(int i=0;i<listLbl.length;i++){
        String s= Player.list.get(i).toString().substring(9);
        listLbl[i]=new JLabel(i+1+"- "+s);
        c.add(listLbl[i]);
        c.add(separatorLbl[i]);   
    }
    this.repaint();
    
        
    }
    public static void loadFromFile(){
    
try {
        File file = new File("Leaderboard.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> list2 = new ArrayList<String>();

while (input.hasNextLine()) {
    list2.add(input.nextLine());
}
for(int i=0;i<list2.size();i=i+2){
    String n=list2.get(i);
    int s=Integer.parseInt(list2.get(i+1));
    
    Player.list.add(new Player(n,s));
    
}


}
catch(Exception e){
    if(Player.list.isEmpty())
        return;
    else
        JOptionPane.showMessageDialog(null, "Load failed!", "ERROR!",JOptionPane.WARNING_MESSAGE);
}
    
    
}
}
