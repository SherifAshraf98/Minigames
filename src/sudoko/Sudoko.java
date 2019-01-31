package sudoko;

public class Sudoko {

    public static void main(String[] args) {
       PlayerS.loadFromFile();
       DifficultyChooser x = new DifficultyChooser();
       x.setVisible(true);
       
       
    }
    
}
