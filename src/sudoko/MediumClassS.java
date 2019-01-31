/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoko;
import whiteball.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JTable;

public class MediumClassS extends JFrame {
    private String[] titles={"Rank","Username","Time (Sec)"};
    private Object[][] players=new Object[10][3];
    JTable table=new JTable(players,titles);
    public MediumClassS()
    {
    this.setResizable(false);
    this.setTitle("Medium Class Leaderboard");
    this.setBounds(400,200,400,216);
    Container c= this.getContentPane();
    table.setSize(400,500);
    c.add(table.getTableHeader(),BorderLayout.PAGE_START);
    c.add(table);
    for(int i=0;i<PlayerS.medlist.size() && i<10; i++){
        players[i][0]=i+1;
        players[i][1]=PlayerS.medlist.get(i).getUsername();
        players[i][2]=PlayerS.medlist.get(i).getScore();
    }
        }
    
}