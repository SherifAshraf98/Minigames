
package whiteball;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Player {
    private String username;
    private int score;
    private String difficulty;
    public static ArrayList<Player> list=new ArrayList<Player>();
    public static ArrayList<Player> easylist=new ArrayList<Player>();
    public static ArrayList<Player> medlist=new ArrayList<Player>();
    public static ArrayList<Player> hardlist=new ArrayList<Player>();
    public Player(String n , int s , String d){
        username=n;
        score=s;
        difficulty=d;
    }
    public Player(String n){
        username=n;
        score=0;
    }
    public String toString(){
        return("Username: "+username  +"          Score: " + score);
    }
    public int getScore(){
        return score;
    }
    public String getUsername(){
        return username;
    }
    public String getDiff(){
        return difficulty;
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
       if(this.difficulty.equals("easy"))
           easylist.add(this);
       if(this.difficulty.equals("medium"))
           medlist.add(this);
       if(this.difficulty.equals("hard"))
           hardlist.add(this);
           
       easylist=this.insertionSort(easylist);
       medlist=this.insertionSort(medlist);
       hardlist=this.insertionSort(hardlist);
       saveToFile();
   }
     
         public static void saveToFile(){
    try{ PrintWriter out = new PrintWriter("Players.txt");
 for(int i=0;i<Player.list.size();i++){
     out.println(Player.list.get(i).getUsername());
     out.println(Player.list.get(i).getScore());
     out.println(Player.list.get(i).getDiff());
  
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
        File file = new File("Players.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> list2 = new ArrayList<String>();

while (input.hasNextLine()) {
    list2.add(input.nextLine());
}
for(int i=0;i<list2.size();i=i+3){
    String n=list2.get(i);
    int s=Integer.parseInt(list2.get(i+1));
    String d=list2.get(i+2);
    Player p=new Player(n,s,d);
    p.addToList();
    
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
