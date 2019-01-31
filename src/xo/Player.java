/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Player {
    private String username;
    private int score;
    public static ArrayList<Player> list=new ArrayList<Player>();
    public Player(String n , int s){
        username=n;
        score=s;
    }
    public Player(String n){
        username=n;
        score=0;
    }
    public String toString(){
        return("Username: "+username +" Games won: " + score);
    }
    public int getScore(){
        return score;
    }
    public String getUsername(){
        return username;
    }
    public void setScore(int s){
        score=s;
    }
    public  static ArrayList<Player> insertionSort(ArrayList<Player> l){
        for (int i = 1; i < l.size(); i++) {
         Player next =  l.get(i);
        int j = i;
        while (j > 0 && l.get(j - 1).getScore() < next.getScore()) {
            l.set(j, l.get(j-1));
            j--;
        }
        
        l.set(j,next);
    }
        return l;
    }
     public void addToList(){
       list.add(this);
       list=this.insertionSort(list);
       saveToFile();
   }
     
         public static void saveToFile(){
    try{ PrintWriter out = new PrintWriter("Leaderboard.txt");
 for(int i=0;i<Player.list.size();i++){
     out.println(Player.list.get(i).getUsername());
     out.println(Player.list.get(i).getScore());
  
         }
 out.close();
 }

 
     catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Save failed!", "ERROR!",JOptionPane.WARNING_MESSAGE);
            }
     
     }
    
}
    

