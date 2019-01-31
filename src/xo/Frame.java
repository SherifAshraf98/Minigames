/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author Sherif Ashraf
 */
public class Frame extends JFrame {
    
    public JTable tbl=new JTable();
    public JButton btn1=new JButton("");
    public JButton btn2=new JButton("");
    public JButton btn3=new JButton("");
    public JButton btn4=new JButton("");
    public JButton btn5=new JButton("");
    public JButton btn6=new JButton("");
    public JButton btn7=new JButton("");
    public JButton btn8=new JButton("");
    public JButton btn9=new JButton("");
    public static int turn =1;
    public String choice1;
    public String choice2;
    private boolean oneWon=false;
    private boolean twoWon=false;


    public JPanel pnl=new JPanel();    
    public Frame(){
    
        this.setTitle("TIC-TAC-TOE");
        this.setBounds(400, 200, 500, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c=this.getContentPane();
        
        pnl.setLayout(new GridLayout(3,3));
        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(btn3);
        pnl.add(btn4);
        pnl.add(btn5);
        pnl.add(btn6);
        pnl.add(btn7);
        pnl.add(btn8);
        pnl.add(btn9);
        c.add(pnl);
        btn1.setFont(new Font("Viner Hand ITC", Font.BOLD, 90));
        btn2.setFont(new Font("Viner Hand ITC", Font.BOLD, 90));
        btn3.setFont(new Font("Viner Hand ITC", Font.BOLD, 90));
        btn4.setFont(new Font("Viner Hand ITC", Font.BOLD, 90));
        btn5.setFont(new Font("Viner Hand ITC", Font.BOLD, 90));
        btn6.setFont(new Font("Viner Hand ITC", Font.BOLD, 90));
        btn7.setFont(new Font("Viner Hand ITC", Font.BOLD, 90));
        btn8.setFont(new Font("Viner Hand ITC", Font.BOLD, 90));
        btn9.setFont(new Font("Viner Hand ITC", Font.BOLD, 90));

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               // SetTheText(ae);
                String s=play();
                btn1.setText(s);
                btn1.setEnabled(false);
                check();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s=play();
                btn2.setText(s);
                btn2.setEnabled(false);
                check();

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s=play();
                btn3.setText(s);   
                btn3.setEnabled(false);
                check();

}
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s=play();
                btn4.setText(s); 
                btn4.setEnabled(false);
                check();

        }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s=play();
                btn5.setText(s); 
                btn5.setEnabled(false);
                check();

         }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s=play();
                btn6.setText(s); 
                btn6.setEnabled(false);
                check();

            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s=play();
                btn7.setText(s);    
                btn7.setEnabled(false);
                check();

            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s=play();
                btn8.setText(s);  
                btn8.setEnabled(false);
                check();

}
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s=play();
                btn9.setText(s);  
                btn9.setEnabled(false);
                check();
            }

        });
        
        

//        Choose ch=new Choose();
//        System.out.println(ch.choice1);
//        System.out.println(ch.choice2);
//        
        
        this.setVisible(true);
    }
    
    void SetTheText(ActionEvent e)
    {
       String s=play();
       
    
    }
    String play(){
        Choose ch=new Choose();
        String s = null;
        if(turn==1)
        {
            
            s=choice1;
            turn=2;
        }
        else
        {
            s=choice2;
            turn=1;
        }
        
        return s;
    }


    void check()
    {
        
        String x="X";
        String o="O";
        String s1=btn1.getText();
        String s2=btn2.getText();
        String s3=btn3.getText();
        String s4=btn4.getText();
        String s5=btn5.getText();
        String s6=btn6.getText();
        String s7=btn7.getText();  
        String s8=btn8.getText();
        String s9=btn9.getText();


        if((s1.equals(x)||s1.equals(o))&&((s2.equals(x)||s2.equals(o))&&s2.equals(s1))&&((s3.equals(x)||s3.equals(o))&&s3.equals(s1)))
        {         
            if (s1.equals(x))
            {
                if(choice1.equals(x))
                {   oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "END",JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(choice2.equals(x))
                {   twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "END",JOptionPane.INFORMATION_MESSAGE);
                } 
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
            if(s1.equals(o))
            {
                if(choice1.equals(o))
                {   oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "END",JOptionPane.INFORMATION_MESSAGE);
                }      
                else if(choice2.equals(o))
                {   twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "END",JOptionPane.INFORMATION_MESSAGE);
                } 
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
        }
        else if((s4.equals(x)||s4.equals(o))&&((s5.equals(x)||s5.equals(o))&&s5.equals(s4))&&((s6.equals(x)||s6.equals(o))&&s6.equals(s4)))
        {       
            if (s4.equals(x))
            {
                if(choice1.equals(x))
                {    oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(choice2.equals(x))
                {   twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                             
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
            if(s4.equals(o))
            {
                if(choice1.equals(o))
                {    oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                }      
                else if(choice2.equals(o))
                {   twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                               
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
        }
        else if((s7.equals(x)||s7.equals(o))&&((s8.equals(x)||s8.equals(o))&&s8.equals(s7))&&((s9.equals(x)||s9.equals(o))&&s9.equals(s7)))
        {
            if (s7.equals(x))
            {
                if(choice1.equals(x))
                {   oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(choice2.equals(x))
                {   twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                               
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
            if(s7.equals(o))
            {
                if(choice1.equals(o))
                {   oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                }      
                else if(choice2.equals(o))
                {   twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                                
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
        }
        else if((s1.equals(x)||s1.equals(o))&&((s5.equals(x)||s5.equals(o))&&s5.equals(s1))&&((s9.equals(x)||s9.equals(o))&&s9.equals(s1)))
        {
            if (s1.equals(x))
            {
                if(choice1.equals(x))
                {    oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(choice2.equals(x))
                {   twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                               
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
            if(s1.equals(o))
            {
                if(choice1.equals(o))
                {    oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                }      
                else if(choice2.equals(o))
                {   twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                               
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
        }
        else if((s3.equals(x)||s3.equals(o))&&((s5.equals(x)||s5.equals(o))&&s5.equals(s3))&&((s7.equals(x)||s7.equals(o))&&s7.equals(s3)))
        {
            if (s3.equals(x))
            {
                if(choice1.equals(x))
                {   oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(choice2.equals(x))
                {twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                               
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
            if(s3.equals(o))
            {
                if(choice1.equals(o))
                {oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                }      
                else if(choice2.equals(o))
                {twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                               
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
        }
        else if((s1.equals(x)||s1.equals(o))&&((s4.equals(x)||s4.equals(o))&&s4.equals(s1))&&((s7.equals(x)||s7.equals(o))&&s7.equals(s1)))
        {
           if (s1.equals(x))
            {
                if(choice1.equals(x))
                {oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(choice2.equals(x))
                {twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                               
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
            if(s1.equals(o))
            {
                if(choice1.equals(o))
                {oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                }      
                else if(choice2.equals(o))
                {twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                                
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
        }
        else if((s2.equals(x)||s2.equals(o))&&((s5.equals(x)||s5.equals(o))&&s5.equals(s2))&&((s8.equals(x)||s8.equals(o))&&s8.equals(s2)))
        {
            if (s2.equals(x))
            {
                if(choice1.equals(x))
                {oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(choice2.equals(x))
                {twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                                
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
            if(s2.equals(o))
            {
                if(choice1.equals(o))
                {oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                }      
                else if(choice2.equals(o))
                {twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                                System.out.println(turn);

                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
        }
        else if((s3.equals(x)||s3.equals(o))&&((s6.equals(x)||s6.equals(o))&&s6.equals(s3))&&((s9.equals(x)||s9.equals(o))&&s9.equals(s3)))
        {
            if (s3.equals(x))
            {
                if(choice1.equals(x))
                {oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(choice2.equals(x))
                {twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                                
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
            if(s3.equals(o))
            {
                if(choice1.equals(o))
                {oneWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 1 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                }      
                else if(choice2.equals(o))
                {twoWon=true;
                    JOptionPane.showMessageDialog(pnl, " User 2 Wins", "CONGRATULATIONS",JOptionPane.INFORMATION_MESSAGE);
                } 
                               
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
            }
        }
        else if((s1.equals(x)||s1.equals(o))&&(s2.equals(x)||s2.equals(o))&&(s3.equals(x)||s3.equals(o))&&(s4.equals(x)||s4.equals(o))&&(s5.equals(x)||s5.equals(o))&&(s6.equals(x)||s6.equals(o))&&(s7.equals(x)||s7.equals(o))&&(s8.equals(x)||s8.equals(o))&&(s9.equals(x)||s9.equals(o)))
        {
            JOptionPane.showMessageDialog(pnl, "DRAW", "END", JOptionPane.INFORMATION_MESSAGE);
                            
                this.dispose();
                turn=1;
                Choose ch=new Choose();
                ch.setVisible(true);
        }
    }
    
}
    

