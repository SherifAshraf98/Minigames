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
public class FrameComp extends JFrame {
    
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
    public static int order =1;
    public String choice1;
    public String choice2;
    public ArrayList<Integer> arr=new ArrayList<Integer> ();
    int pressedindex;


    public JPanel pnl=new JPanel();    
    public FrameComp(){
    
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
                btn1actionlistener(ae);
                
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btn2actionlistener(ae);
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 btn3actionlistener(ae);
}
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 btn4actionlistener(ae);
        }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 btn5actionlistener(ae);
         }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 btn6actionlistener(ae);
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 btn7actionlistener(ae);
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btn8actionlistener(ae);
}
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btn9actionlistener(ae);
            }

        });
           
        
        this.setVisible(true);
    }
    
    void SetTheText(ActionEvent e)
    {
       String s=play(); 
    }
    
    void computerturn(String s)
    {
            Random rand=new Random();
            int r;
            r=rand.nextInt(10);
            for(int i=0;i<arr.size();i++)
            {
                //r=rand.nextInt(10);
               // System.out.println("rand  " +r);
                if(r==arr.get(i)||r==0)
                {
                    System.out.println("cont");
                    r=rand.nextInt(10);
                    i=-1;
                }
//                else
//                {
//                    System.out.println("else");
//                    break;
//                }
            }
            System.out.println("new rand "+ r);
           
            
            boolean user=UserWin();
            boolean comp=CompWin();
            System.out.println("UserWin "+user);
            System.out.println("CompWin "+comp);
            if(comp==true&&user==true)
            {
                int z;
                z=IndexCompWin();
                if(z!=20)
                {
                    r=z;
                }
                            System.out.println("r1 "+r);

            }
            else if(comp==true&&user==false)
            {
                int z;
                z=IndexCompWin();
                if(z!=20)
                {
                    r=z;
                }
                            System.out.println("r2 "+r);

            }  
            else if(comp==false&&user==true)
            {
                int z;
                z=IndexUserWin();
                if(z!=20)
                {
                    r=z;
                }
                System.out.println("Z from userwin = "+z);
                            System.out.println("r3 "+r);

            }
            System.out.println("final r "+r);
            switch (r)
            {
            case 1:
            {             
              System.out.println("11");
              System.out.println("111");

                pressedindex=1;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                btn1.setText(s);
                System.out.println("1111");
                btn1.setEnabled(false);
                if(check())
                {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 
                }
                break;
            }
            case 2:
            {           
                System.out.println("22");  
                System.out.println("222");

                pressedindex=2;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                btn2.setText(s);
                btn2.setEnabled(false);
                if(check())
                {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 
                }
                break;
            }
            case 3:
            {          
                System.out.println("33");
                System.out.println("333");

                pressedindex=3;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                btn3.setText(s);
                btn3.setEnabled(false);
                if(check())
                {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 
                }
                 break;
            }
            case 4:
            {           
                System.out.println("44");
                System.out.println("444");

                pressedindex=4;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                btn4.setText(s);
                btn4.setEnabled(false);
                if(check())
                {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 
                }
                break;
            }
            case 5:
            {           
                System.out.println("55");
                System.out.println("555");

                pressedindex=5;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                btn5.setText(s);
                btn5.setEnabled(false);
                if(check())
                {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 
                }
                break;
            }
            case 6:
            {          
                System.out.println("66");
                System.out.println("666");

                pressedindex=6;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                btn6.setText(s);
                btn6.setEnabled(false);
                if(check())
                {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 
                }       
                break;
            }
            case 7:
            {           
                System.out.println("77");
                System.out.println("777");

                pressedindex=7;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                btn7.setText(s);
                btn7.setEnabled(false);
                if(check())
                {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 
                }
                break;
            }
            case 8:
            {           
                 System.out.println("88")  ;
                 System.out.println("888");

                pressedindex=8;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                btn8.setText(s);
                btn8.setEnabled(false);
                if(check())
                {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 
                }
                break;
            }
            case 9:
            {          
                System.out.println("99");
                System.out.println("999");

                pressedindex=9;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                btn9.setText(s);
                btn9.setEnabled(false);
                if(check())
                {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 
                }            
                break;
            }
       }
            
    }
    boolean CompWin()
    {
        int z=1;
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
        if(s1.equals(choice2)&&s2.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
                z=1;
               return true; 
            }
        }
        if(s1.equals(choice2)&&s3.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==2)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s2.equals(choice2)&&s3.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s4.equals(choice2)&&s5.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==6)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s4.equals(choice2)&&s6.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s5.equals(choice2)&&s6.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==4)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s7.equals(choice2)&&s8.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s7.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==8)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s8.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s1.equals(choice2)&&s4.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s1.equals(choice2)&&s7.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==4)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s4.equals(choice2)&&s7.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s2.equals(choice2)&&s5.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==8)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s2.equals(choice2)&&s8.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s5.equals(choice2)&&s8.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==2)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s3.equals(choice2)&&s6.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s3.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==6)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s6.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s1.equals(choice2)&&s5.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s1.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s5.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s3.equals(choice2)&&s5.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s3.equals(choice2)&&s7.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s5.equals(choice2)&&s7.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        return false;
    }
    boolean UserWin()
    {
        int z=1;
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
        if(s1.equals(choice1)&&s2.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
            
        }
        if(s1.equals(choice1)&&s3.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==2)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }       
        }
        if(s2.equals(choice1)&&s3.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s4.equals(choice1)&&s5.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==6)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s4.equals(choice1)&&s6.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s5.equals(choice1)&&s6.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==4)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s7.equals(choice1)&&s8.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s7.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==8)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s8.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s1.equals(choice1)&&s4.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
             System.out.println("Z = "+z);
            if(z==1)
            {
               return true; 
            }
        }
        if(s1.equals(choice1)&&s7.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==4)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s4.equals(choice1)&&s7.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s2.equals(choice1)&&s5.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==8)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s2.equals(choice1)&&s8.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s5.equals(choice1)&&s8.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==2)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s3.equals(choice1)&&s6.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s3.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==6)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s6.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s1.equals(choice1)&&s5.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s1.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
                          System.out.println("Z = "+z);

            if(z==1)
            {
               return true; 
            }
        }
        if(s5.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s3.equals(choice1)&&s5.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        if(s3.equals(choice1)&&s7.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
                          System.out.println("Z = "+z);
            if(z==1)
            {
               return true; 
            }
        }
        if(s5.equals(choice1)&&s7.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return true; 
            }
        }
        return false;
    }
    
    int IndexUserWin()
    {
        int z=1;
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
        if(s1.equals(choice1)&&s2.equals(choice1))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 3; 
            }
        }
        if(s1.equals(choice1)&&s3.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==2)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 2; 
            }
        }
        if(s2.equals(choice1)&&s3.equals(choice1))
        {
            z=1;
           for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 1; 
            }
        }
        if(s4.equals(choice1)&&s5.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==6)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 6; 
            }
        }
        if(s4.equals(choice1)&&s6.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 5; 
            }
        }
        if(s5.equals(choice1)&&s6.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==4)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 4; 
            }
        }
        if(s7.equals(choice1)&&s8.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 9; 
            }
        }
        if(s7.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==8)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 8; 
            }
        }
        if(s8.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 7; 
            }
        }
        if(s1.equals(choice1)&&s4.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 7; 
            }
        }
        if(s1.equals(choice1)&&s7.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==4)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 4; 
            }
        }
        if(s4.equals(choice1)&&s7.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 1; 
            }
        }
        if(s2.equals(choice1)&&s5.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==8)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 8; 
            }
        }
        if(s2.equals(choice1)&&s8.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 5; 
            }
        }
        if(s5.equals(choice1)&&s8.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==2)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 2; 
            }
        }
        if(s3.equals(choice1)&&s6.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 9; 
            }
        }
        if(s3.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==6)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 6; 
            }
        }
        if(s6.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 3; 
            }
        }
        if(s1.equals(choice1)&&s5.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 9; 
            }
        }
        if(s1.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 5; 
            }
        }
        if(s5.equals(choice1)&&s9.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 1; 
            }
        }
        if(s3.equals(choice1)&&s5.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 7; 
            }
        }
        if(s3.equals(choice1)&&s7.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 5; 
            }
        }
        if(s5.equals(choice1)&&s7.equals(choice1))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 3; 
            }
        }
        return 20;
    }
    int IndexCompWin()
    {
        int z=1;
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
        if(s1.equals(choice2)&&s2.equals(choice2))
        {
            z=1;
             for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 3; 
            }
        }
        if(s1.equals(choice2)&&s3.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==2)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 2; 
            }
        }
        if(s2.equals(choice2)&&s3.equals(choice2))
        {
            z=1;
           for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 1; 
            }
        }
        if(s4.equals(choice2)&&s5.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==6)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 6; 
            }
        }
        if(s4.equals(choice2)&&s6.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 5; 
            }
        }
        if(s5.equals(choice2)&&s6.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==4)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 4; 
            }
        }
        if(s7.equals(choice2)&&s8.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 9; 
            }
        }
        if(s7.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==8)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 8; 
            }
        }
        if(s8.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 7; 
            }
        }
        if(s1.equals(choice2)&&s4.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 7; 
            }
        }
        if(s1.equals(choice2)&&s7.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 3; 
            }
        }
        if(s4.equals(choice2)&&s7.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 1; 
            }
        }
        if(s2.equals(choice2)&&s5.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==8)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 8; 
            }
        }
        if(s2.equals(choice2)&&s8.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 5; 
            }
        }
        if(s5.equals(choice2)&&s8.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==2)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 2; 
            }
        }
        if(s3.equals(choice2)&&s6.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 9; 
            }
        }
        if(s3.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==6)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 6; 
            }
        }
        if(s6.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 3; 
            }
        }
        if(s1.equals(choice2)&&s5.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==9)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 9; 
            }
        }
        if(s1.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 5; 
            }
        }
        if(s5.equals(choice2)&&s9.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==1)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 1; 
            }
        }
        if(s3.equals(choice2)&&s5.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==7)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 7; 
            }
        }
        if(s3.equals(choice2)&&s7.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==5)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 5; 
            }
        }
        if(s5.equals(choice2)&&s7.equals(choice2))
        {
            z=1;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)==3)
                {
                    z=2;
                }
                
            }
            if(z==1)
            {
               return 3; 
            }
        }
        return 20;
    }
    
    String play()
    {
        //System.out.println("1");
       // System.out.println(choice1);
       // System.out.println(choice2);
        String s=null;
        if(order==1)
        {
          //  System.out.println("2");
            //arr.add(pressedindex);
            //order =2;
            s=choice1;
        }
        
   
        
        return s;
    }


    void end()
    {
        
    }

    void btn1actionlistener(ActionEvent ae)
    {
                pressedindex=1;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                String s=play();
                btn1.setText(s);
                btn1.setEnabled(false);
                boolean x=check();
                if(x==false)
                {
                  if(s.equals(choice1))
                  {
                      computerturn(choice2);
                  }
                  else
                  {
                      computerturn(choice1);
                  }
                }
                else
                    {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 }
    }
    void btn2actionlistener(ActionEvent ae)
    {
                pressedindex=2;
                arr.add(pressedindex);
                for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                String s=play();
                btn2.setText(s);
                btn2.setEnabled(false);
                boolean x=check();
                 if(x==false)
                {
                  if(s.equals(choice1))
                  {
                      computerturn(choice2);
                  }
                  else
                  {
                      computerturn(choice1);
                  }
                }
                else
                    {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 }
    }
    void btn3actionlistener(ActionEvent ae)
    {
                pressedindex=3;   
                arr.add(pressedindex);for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                String s=play();
                btn3.setText(s);
                btn3.setEnabled(false);
                boolean x=check();
                 if(x==false)
                {
                  if(s.equals(choice1))
                  {
                      computerturn(choice2);
                  }
                  else
                  {
                      computerturn(choice1);
                  }
                }
                else
                    {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 }
    }
    void btn4actionlistener(ActionEvent ae)
    {
                pressedindex=4;
                arr.add(pressedindex);for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                String s=play();
                btn4.setText(s);
                btn4.setEnabled(false);
                boolean x=check();
                 if(x==false)
                {
                  if(s.equals(choice1))
                  {
                      computerturn(choice2);
                  }
                  else
                  {
                      computerturn(choice1);
                  }
                }
                else
                    {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 }
    }
    void btn5actionlistener(ActionEvent ae)
    {
                pressedindex=5;
                arr.add(pressedindex);for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                String s=play();
                btn5.setText(s);
                btn5.setEnabled(false);
                boolean x=check();
                 if(x==false)
                {
                  if(s.equals(choice1))
                  {
                      computerturn(choice2);
                  }
                  else
                  {
                      computerturn(choice1);
                  }
                }
                else
                    {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 }
    }
    void btn6actionlistener(ActionEvent ae)
    {
                pressedindex=6;
                arr.add(pressedindex);for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                String s=play();
                btn6.setText(s);
                btn6.setEnabled(false);
                boolean x=check();
                 if(x==false)
                {
                  if(s.equals(choice1))
                  {
                      computerturn(choice2);
                  }
                  else
                  {
                      computerturn(choice1);
                  }
                }
                else
                    {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 }
    }
    void btn7actionlistener(ActionEvent ae)
    {
                pressedindex=7;
                arr.add(pressedindex);for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                String s=play();
                btn7.setText(s);
                btn7.setEnabled(false);
                boolean x=check();
                 if(x==false)
                {
                  if(s.equals(choice1))
                  {
                      computerturn(choice2);
                  }
                  else
                  {
                      computerturn(choice1);
                  }
                }
                else
                    {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 }
    }
    void btn8actionlistener(ActionEvent ae)
    {
                pressedindex=8;
                arr.add(pressedindex);for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                String s=play();
                btn8.setText(s);
                btn8.setEnabled(false);
                boolean x=check();
                 if(x==false)
                {
                  if(s.equals(choice1))
                  {
                      computerturn(choice2);
                  }
                  else
                  {
                      computerturn(choice1);
                  }
                }
                else
                    {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 }
    }
    void btn9actionlistener(ActionEvent ae)
    {
                pressedindex=9;
                arr.add(pressedindex);for(int i=0;i<arr.size();i++)
                    System.out.print(arr.get(i)+"  ");
                System.out.println("");
                String s=play();
                btn9.setText(s);
                btn9.setEnabled(false);
                boolean x=check();
                 if(x==false)
                {
                  if(s.equals(choice1))
                  {
                      computerturn(choice2);
                  }
                  else
                  {
                      computerturn(choice1);
                  }
                }
                else
                 {
                     this.dispose();
                     turn=1;
                     ChooseComp ch=new ChooseComp();
                     ch.setVisible(true);
                 }
    }
   

    
    boolean check()
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
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } 
                else if(choice2.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                    return true;

                } 
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
            if(s1.equals(o))
            {
                if(choice1.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }      
                else if(choice2.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } 
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
        }
        else if((s4.equals(x)||s4.equals(o))&&((s5.equals(x)||s5.equals(o))&&s5.equals(s4))&&((s6.equals(x)||s6.equals(o))&&s6.equals(s4)))
        {       
            if (s4.equals(x))
            {
                if(choice1.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                else if(choice2.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                             
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
            if(s4.equals(o))
            {
                if(choice1.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                }      
                else if(choice2.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                               
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
        }
        else if((s7.equals(x)||s7.equals(o))&&((s8.equals(x)||s8.equals(o))&&s8.equals(s7))&&((s9.equals(x)||s9.equals(o))&&s9.equals(s7)))
        {
            if (s7.equals(x))
            {
                if(choice1.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                else if(choice2.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                               
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
            if(s7.equals(o))
            {
                if(choice1.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                }      
                else if(choice2.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                                
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
        }
        else if((s1.equals(x)||s1.equals(o))&&((s5.equals(x)||s5.equals(o))&&s5.equals(s1))&&((s9.equals(x)||s9.equals(o))&&s9.equals(s1)))
        {
            if (s1.equals(x))
            {
                if(choice1.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                else if(choice2.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                               
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
            if(s1.equals(o))
            {
                if(choice1.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                }      
                else if(choice2.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                               
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
        }
        else if((s3.equals(x)||s3.equals(o))&&((s5.equals(x)||s5.equals(o))&&s5.equals(s3))&&((s7.equals(x)||s7.equals(o))&&s7.equals(s3)))
        {
            if (s3.equals(x))
            {
                if(choice1.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                else if(choice2.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                               
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
            if(s3.equals(o))
            {
                if(choice1.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                }      
                else if(choice2.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                               
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
        }
        else if((s1.equals(x)||s1.equals(o))&&((s4.equals(x)||s4.equals(o))&&s4.equals(s1))&&((s7.equals(x)||s7.equals(o))&&s7.equals(s1)))
        {
           if (s1.equals(x))
            {
                if(choice1.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                else if(choice2.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                               
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
            if(s1.equals(o))
            {
                if(choice1.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                }      
                else if(choice2.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                                
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
        }
        else if((s2.equals(x)||s2.equals(o))&&((s5.equals(x)||s5.equals(o))&&s5.equals(s2))&&((s8.equals(x)||s8.equals(o))&&s8.equals(s2)))
        {
            if (s2.equals(x))
            {
                if(choice1.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                else if(choice2.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                                
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
            if(s2.equals(o))
            {
                if(choice1.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                }      
                else if(choice2.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                         // System.out.println(turn);
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
        }
        else if((s3.equals(x)||s3.equals(o))&&((s6.equals(x)||s6.equals(o))&&s6.equals(s3))&&((s9.equals(x)||s9.equals(o))&&s9.equals(s3)))
        {
            if (s3.equals(x))
            {
                if(choice1.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                else if(choice2.equals(x))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                                
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
            if(s3.equals(o))
            {
                if(choice1.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU WON !", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                }      
                else if(choice2.equals(o))
                {
                    JOptionPane.showMessageDialog(pnl, " YOU LOST ! GAME OVER :D", "END",JOptionPane.INFORMATION_MESSAGE);
                                        return true;

                } 
                               
                this.dispose();
                turn=1;
                ChooseComp ch=new ChooseComp();
                ch.setVisible(true);
            }
        }
        else if((s1.equals(x)||s1.equals(o))&&(s2.equals(x)||s2.equals(o))&&(s3.equals(x)||s3.equals(o))&&(s4.equals(x)||s4.equals(o))&&(s5.equals(x)||s5.equals(o))&&(s6.equals(x)||s6.equals(o))&&(s7.equals(x)||s7.equals(o))&&(s8.equals(x)||s8.equals(o))&&(s9.equals(x)||s9.equals(o)))
        {
            JOptionPane.showMessageDialog(pnl, "DRAW", "END", JOptionPane.INFORMATION_MESSAGE);
                            
                this.dispose();
                turn=1;
                //ChooseComp ch=new ChooseComp();
                //ch.setVisible(true);
                return true;
        }
        return false;
    }
}
    

