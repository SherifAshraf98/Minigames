
package sudoko;
import whiteball.*;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PlayerS {
    private String username;
    private float score;
    private String difficulty;
    public static ArrayList<PlayerS> list=new ArrayList<PlayerS>();
    public static ArrayList<PlayerS> easylist=new ArrayList<PlayerS>();
    public static ArrayList<PlayerS> medlist=new ArrayList<PlayerS>();
    public static ArrayList<PlayerS> hardlist=new ArrayList<PlayerS>();
    public PlayerS(String n , float s , String d){
        username=n;
        score=s;
        difficulty=d;
    }
    public PlayerS(String n){
        username=n;
        score=0;
    }
    public String toString(){
        return("Username: "+username  +"          Score: " + score);
    }
    public float getScore(){
        return score;
    }
    public String getUsername(){
        return username;
    }
    public String getDiff(){
        return difficulty;
    }
    public void setScore(float s){
        score=s;
    }
    public  static ArrayList<PlayerS> insertionSort(ArrayList<PlayerS> l){
        for (int i = 1; i < l.size(); i++) {
         PlayerS next =  l.get(i);
        int j = i;
        while (j > 0 && l.get(j - 1).getScore() > next.getScore()) {
            l.set(j, l.get(j-1));
            j--;
        }
        
        l.set(j,next);
    }
        return l;
    }
     public void addToList(){
       list.add(this);
       if(this.difficulty.equals("Easy"))
           easylist.add(this);
       if(this.difficulty.equals("Medium"))
           medlist.add(this);
       if(this.difficulty.equals("Hard"))
           hardlist.add(this);
           
       easylist=this.insertionSort(easylist);
       medlist=this.insertionSort(medlist);
       hardlist=this.insertionSort(hardlist);
       saveToFile();
   }
     
         public static void saveToFile(){
    try{ PrintWriter out = new PrintWriter("PlayersS.txt");
 for(int i=0;i<PlayerS.list.size();i++){
     out.println(PlayerS.list.get(i).getUsername());
     out.println(PlayerS.list.get(i).getScore());
     out.println(PlayerS.list.get(i).getDiff());
  
         }
 out.close();
 }

 
     catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Save failed!", "ERROR!",JOptionPane.WARNING_MESSAGE);
            }
     
     }
     public static void loadFromFile(){
    
try {
        File file = new File("PlayersS.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> list2 = new ArrayList<String>();

while (input.hasNextLine()) {
    list2.add(input.nextLine());
}
for(int i=0;i<list2.size();i=i+3){
    String n=list2.get(i);
    float s=Float.parseFloat(list2.get(i+1));
    String d=list2.get(i+2);
    PlayerS p=new PlayerS(n,s,d);
    p.addToList();
    
}


}
catch(Exception e){
    if(PlayerS.list.isEmpty())
        return;
    else
        JOptionPane.showMessageDialog(null, "Load failed!", "ERROR!",JOptionPane.WARNING_MESSAGE);
}
    
    
}     
    
}
