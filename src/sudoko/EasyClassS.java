package sudoko;
import whiteball.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JTable;

public class EasyClassS extends JFrame {
    private String[] titles={"Rank","Username","Time (Sec)"};
    private Object[][] players=new Object[10][3];
    JTable table=new JTable(players,titles);
    public EasyClassS()
    {
    this.setResizable(false);
    this.setTitle("Easy Class Leaderboard");
    this.setBounds(400,200,400,216);
    Container c= this.getContentPane();
    table.setSize(400,500);
    c.add(table.getTableHeader(),BorderLayout.PAGE_START);
    c.add(table);
    for(int i=0;i<PlayerS.easylist.size() && i<10; i++){
        players[i][0]=i+1;
        players[i][1]=PlayerS.easylist.get(i).getUsername();
        players[i][2]=PlayerS.easylist.get(i).getScore();
    }
        }
    
}