/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiteball;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JTable;

public class MediumClass extends JFrame {
    private String[] titles={"Rank","Username","Score"};
    private Object[][] players=new Object[10][3];
    JTable table=new JTable(players,titles);
    public MediumClass()
    {
    this.setResizable(false);
    this.setTitle("Medium Class Leaderboard");
    this.setBounds(400,200,400,216);
    Container c= this.getContentPane();
    table.setSize(400,500);
    c.add(table.getTableHeader(),BorderLayout.PAGE_START);
    c.add(table);
    for(int i=0;i<Player.medlist.size() && i<10; i++){
        players[i][0]=i+1;
        players[i][1]=Player.medlist.get(i).getUsername();
        players[i][2]=Player.medlist.get(i).getScore();
    }
        }
    
}