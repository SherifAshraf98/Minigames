
package whiteball;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
abstract class Shape {
    protected int x;
    protected int y;

    public Shape(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public abstract void draw(Graphics g);
    
    public int getX() {return x;}
    public int getY() {return y;}
}

class Ball extends Shape{
    private Color c;
    public Ball(int x , int y , Color c){
    super(x,y);
    this.c=c;
    }
    public void setX(int x){
        super.x=x;
    }
    public void setY(int y){
        super.y=y;
    }
    public void setCol(Color c){
        this.c=c;
    }
    public void draw(Graphics g){
        g.setColor(c);
        g.fillOval(getX(),getY(),30,30);
    }     
}


class Bar extends Shape{
    int barLength=WhiteBall.barLength;
    public Bar(int x){
        super(x,500);
    }
    public void setX(int x){
        super.x=x;
    }
    public int getBarLength(){
        return barLength;
    }
    public void setBarLength(int x){
        barLength=x;
    }
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(getX(),500,barLength,20);
}
}


class GamePanel extends JPanel{
  
    private Ball b;
    private Bar c;
    private Ball b2;
    public GamePanel(Ball b , Bar c){
        this.b=b;
        this.c=c;
     }
    public GamePanel(Ball b ,Ball b2, Bar c){
        this.b=b;
        this.c=c;
        this.b2=b2;
        
    }
   
    
    
    public void paint(Graphics g){
        super.paint(g);
        b.draw(g);
        c.draw(g);
        b2.draw(g);
    }
}


public class WhiteBall  extends JFrame   {
JFrame f=this;
public static int delayTime=15; //static in order to be edited from difficulty class
public static int barLength=140;
private Random rand=new Random();
private int x=rand.nextInt(750);
private int y=rand.nextInt(30);
private Ball ball1=new Ball(x,y,Color.white); 
private Ball ball2=new Ball(830,630,Color.BLACK); //black in order to be hidden at first then at level 3 it appears
private Bar bar=new Bar(150);
private int ball1xSpeed=4;  //ball 1 direction changing pace
private int ball1ySpeed=6;  //ball 2 direction changing pace
private int ball2xSpeed=3;
private int ball2ySpeed=5;
private Timer t;
private boolean levelup=false;
private int scr=0;
private int bestScr=0;
public int score1 = 0;
private int scorefinal;
public int bestscore1;
private int level=1;
private JLabel userLbl=new JLabel();
private JLabel levelLbl=new JLabel("Level: ");
private JTextField levelTxt=new JTextField(level+"",1);
private JLabel scrLbl=new JLabel("Score: ");
private JTextField scrTxt=new JTextField(scr+"",2);
private boolean gameOver=false;
private int count=0;
private Container c;
private GamePanel centerPanel;
private JPanel southPanel=new JPanel();

//Constructor takes username of player , delaytime of chosen difficulty , barlength of chosen difficulty
//and a string indicating the chosen difficulty
public WhiteBall(String n , int delayTime , int barLength , String d){
    this.delayTime=delayTime;
    this.barLength=barLength;   
    this.setTitle("White Ball");
    this.setLocation(400, 200);
    this.setSize(800,600);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    scrTxt.setEditable(false);
    levelTxt.setEditable(false);
    centerPanel=new GamePanel(ball1,ball2,bar);
    centerPanel.setLayout(null);
    centerPanel.setBackground(Color.black);
    userLbl.setText("Username: "+n);
    southPanel.setLayout(new FlowLayout());
    southPanel.add(userLbl);
    southPanel.add(scrLbl);
    southPanel.add(scrTxt);
    southPanel.add(levelLbl);
    southPanel.add(levelTxt);
    southPanel.setBackground(Color.white);
    c=this.getContentPane();
    c.add(centerPanel);
    c.add(southPanel , BorderLayout.SOUTH);
    
    //Game action
    t = new javax.swing.Timer(delayTime,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                gameOver=false;
       
        //First ball motion algorithm   
    
        ballOneMotion();

        //second ball motion algorithm
      if(level>=3)
         ballTwoMotion();
        
        //Score calculating algorithm
        
        calcScore();
        
       
            
          
        if(gameOver)
        { 
         bar.setBarLength(WhiteBall.barLength); //to return to the game start state
         t.setDelay(WhiteBall.delayTime);
        
         int z=JOptionPane.showConfirmDialog(null, "Name: " +n +"\nBest score: " + scorefinal +"\nDo you want to try again?", "Game Over!",JOptionPane.YES_NO_OPTION);
          t.stop();
          if(z==JOptionPane.YES_OPTION)  //if user wishes to play again
          { ball2.setCol(Color.black);  // ball 2 disappears again
            ball2.setX(830);
            ball2.setY(630);
            int x2=rand.nextInt(750);
            int y2=rand.nextInt(30);
            ball1.setX(x2);
            ball1.setY(y2);
            scr = 0;
            count=0;
            ball2.setY(0);
            scrTxt.setText(scr+"");
            level=1;
            levelTxt.setText(level+"");
            gameOver=false;
            t.start();
          }
          else{
          Player p=new Player(n,scorefinal , d);
          p.addToList();  //adds player to players list which will be checked to see if he joins the leaderboard
          f.dispose();
          }
          
        }
         
           
        centerPanel.repaint();
    };
            
        });
        t.start();
        
        
  //Motion of the bar
        centerPanel.addMouseMotionListener(new MouseMotionAdapter(){
        public void mouseMoved(MouseEvent e) {

        bar.setX(e.getX() - 50);
        bar.draw(centerPanel.getGraphics());
        
    }
        
    });
        
            
}
   public void ballOneMotion(){
              ball1.setX(ball1.getX()+ball1xSpeed);
              ball1.setY(ball1.getY()+ball1ySpeed);
              ball1.draw(centerPanel.getGraphics());
                

        
       if (ball1.getX()+30 >= bar.getX() && ball1.getX() <= bar.getX() + bar.getBarLength() && ball1.getY() >= 475 && ball1.getY()<=490) {

            ball1ySpeed = -6;
            scr++;
            count++;
            scrTxt.setText(scr+"");
        }

        if (ball1.getY() >= centerPanel.getHeight() ) {

            gameOver = true;

        }

        
        if (ball1.getY() <= 0) {

            ball1ySpeed = 6;

        }

        
        if (ball1.getX() >= 775) {

            ball1xSpeed = -4;
        }

        
        if (ball1.getX() <= 0) {

            ball1xSpeed = 4;

        }

       
        
        
    }
 public void ballTwoMotion(){
          
      
           if(ball2.getX()==830 && ball2.getY()==630)
          { int x3=rand.nextInt(750);
            int y3=rand.nextInt(30);
            ball2.setX(x3);
            ball2.setY(y3);
          }
            ball2.setCol(Color.white);
            ball2.setX(ball2.getX()+ball2xSpeed);
            ball2.setY(ball2.getY()+ball2ySpeed);
            ball2.draw(centerPanel.getGraphics());
             if (ball2.getX()+30 >= bar.getX() && ball2.getX()+10 <= bar.getX() + bar.getBarLength() && ball2.getY() >= 475 && ball2.getY()<=490) {

            ball2ySpeed = -5;
            scr++;
            count++;
            scrTxt.setText(scr+"");
        }

        if (ball2.getY() >= centerPanel.getHeight() ) {

           
            gameOver = true;

        }

        
        if (ball2.getY() <= 0) {

            ball2ySpeed = 5;

        }

        
        if (ball2.getX() >= 775) {

            ball2xSpeed = -3;
        }

        
        if (ball2.getX() <= 0) {

            ball2xSpeed = 3;

        }
 }
 public void calcScore(){
        bestScr = scr;
        bestscore1 = score1;

        if (scorefinal > bestScr) {

            scorefinal = scorefinal;

        } else {

            scorefinal = bestScr;
            scorefinal = scr + score1;
        }
        
        if (scorefinal > bestscore1) {

            scorefinal = scorefinal;

        } else {

            scorefinal = bestscore1;
            scorefinal = scr + score1;
        }
        
        // leveling up
        if(count==5 )
        { count=0;
          levelup=true;
        }
        if(levelup)
        {levelup=false; 
         level++;
         levelTxt.setText(level+"");
         t.setDelay(t.getDelay()-1);
         if(level<=5)
           bar.setBarLength(bar.getBarLength()-10);
         
         bar.draw(centerPanel.getGraphics());
           
        
            }
 
}
  





    public static void main(String[] args) {
        Player.loadFromFile();
        Menu menu=new Menu();
        menu.setVisible(true);
    }
    
}
