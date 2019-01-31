package sudoko;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.util.logging.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;

class Element{
    int s;
    int r;
    int c;
    public Element(int s, int r, int c){
        this.s = s;
        this.r = r;
        this.c = c;
    }
    public void print(){
        System.out.println("S: " + s + " R: " + r + " C: " + c);
    }
}

class cellRend extends DefaultTableCellRenderer{
 
    public  Component getTableCellRendererComponent(JTable table, Object value, boolean sel,
      boolean focus, int row, int col) {
      Component c = super.getTableCellRendererComponent( table, value, sel, focus, row, col);


             
      

    this.setHorizontalAlignment(CENTER);
    this.setFont(new Font("Serif", Font.BOLD, 20));
    setText(value.toString());
    if(focus){
        
        this.setBackground(new Color(102,242,235)); 
 
    }
    else{
        this.setBackground(Color.white);
 
    }
    

    return c;
    }
    

}


class keyLis extends KeyAdapter{
    int square;
    public keyLis(int square){
this.square=square;
    }
 
    
 public void keyReleased(KeyEvent h){
     
try{
      MainGameClass.message.setText("");
      int keyCode = h.getKeyCode();
      int val=h.getKeyChar()-48;
      MainGameClass.sc=MainGameClass.st.getSelectedColumn();
      MainGameClass.sr=MainGameClass.st.getSelectedRow();     
      MouseLis.exVal=MainGameClass.st.getValueAt(MainGameClass.sr, MainGameClass.sc);

  if(keyCode != KeyEvent.VK_UP  && keyCode != KeyEvent.VK_DOWN && keyCode != KeyEvent.VK_RIGHT && keyCode != KeyEvent.VK_LEFT){
      if (MainGameClass.isValidPlacement(square, MainGameClass.sr, MainGameClass.sc, val, MainGameClass.data)
              && val>0 && val<10 || keyCode==KeyEvent.VK_BACK_SPACE){
          if(!MainGameClass.isMainGameCell(square,MainGameClass.sr, MainGameClass.sc)){

      
            
      MainGameClass.st.setValueAt(Integer.toString(val),MainGameClass.sr, MainGameClass.sc);
      MainGameClass.step.add(new Element(square, MainGameClass.sr, MainGameClass.sc));
        MainGameClass.st.removeEditor();

              if(keyCode==KeyEvent.VK_BACK_SPACE){

MainGameClass.st.setValueAt("",MainGameClass.sr, MainGameClass.sc);    
MainGameClass.st.removeEditor();

}           
             if (MainGameClass.isFull(MainGameClass.data)){
                    MainGameClass.message.setText("You won the game!");
                    for(int i=0;i<9;i++){
                      (MainGameClass.table[i]).setEnabled(false);
                  }
                    MainGameClass.endTime = System.nanoTime();
                    float timeInSec = (float)(MainGameClass.endTime - MainGameClass.startTime)/1000000000;
                    String difficultyText = MainGameClass.difficulty;
                    PlayerS p=new PlayerS(MainGameClass.userName, timeInSec , difficultyText);
                    p.addToList();
                    MainGameClass.tl.setText("Time Taken:");
                    MainGameClass.t.setText((int)timeInSec/60 + "m " + (int)timeInSec % 60 + " s");
              }
          }
              else{
              
                   MainGameClass.st.removeEditor();
                   Robot r;
              try {
                  r=new Robot();
                  r.keyPress(KeyEvent.VK_ENTER);
              } catch (AWTException ex) {
                  Logger.getLogger(keyLis.class.getName()).log(Level.SEVERE, null, ex);
              }
              
                  MainGameClass.message.setText("You can't edit this cell!");
              } 
                  
             
      }
            else {
                MainGameClass.st.removeEditor();
                int sr =MainGameClass.sr;
                int sc = MainGameClass.sc;
                if(keyCode != KeyEvent.VK_ENTER && MainGameClass.isMainGameCell(square,MainGameClass.sr, MainGameClass.sc)){
                    
                    MainGameClass.st.setValueAt(MouseLis.exVal, sr,sc);
                }
                MainGameClass.message.setText("Invalid cell placement!");
                
            }
            
          
                
     
     }
}
catch(Exception e){
    
}
 }
}

class MouseLis extends MouseAdapter{
    int square;
    MainGameClass mainFrame;
    static Object exVal;
    public MouseLis(int square){
    this.square = square;
    this.mainFrame = mainFrame;
    }
    public void mouseClicked(MouseEvent e) {
          
        
        MainGameClass.message.setText("");
        MainGameClass.st=(JTable)e.getSource();
        MainGameClass.sr=MainGameClass.st.getSelectedRow();
        MainGameClass.sc=MainGameClass.st.getSelectedColumn();
        if((MainGameClass.st).isEnabled())
        exVal = MainGameClass.st.getValueAt(MainGameClass.sr, MainGameClass.sc);
            
        }
    
    public void mousePressed(MouseEvent e){
        MainGameClass.st.removeEditor();
    }
}


public class MainGameClass extends JFrame{
    public static long startTime;
    public static long endTime;
    public JFrame difficultyFrame;
    public static ArrayList<Element> x;
    public static ArrayList<Element> mainGameCells;
    public static String difficulty;
    public static Random main = new Random();
    public static int validSolutions = 0;
    private JPanel parent = new JPanel();
    protected static JTable[] table = new JTable[9];
    public static  ArrayList<JFrame> window = new ArrayList<JFrame>();
    public static ArrayList<Element> step=new ArrayList<Element>();
    Container c = this.getContentPane();
    static JTable st;
    static int sr,sc;
    public static JPanel bottom = new JPanel();
    public static JLabel tl=new JLabel("");
    public static JLabel t = new JLabel("");
    public static JLabel message=new JLabel();
    public static JButton done=new JButton("Return to menu");
    public static String userName;
    private JMenuBar menu = new JMenuBar();
    private JMenu options = new JMenu("Options");
    private JMenuItem undo = new JMenuItem("Clear last used cell");

    // Each table needs 2D array:
    // We have 9 tables:
    public static Object data[][][] = {
        {{"", "", ""}, {"6", "8", ""}, {"1", "9", ""}},
        {{"2", "6", ""}, {"", "7", ""}, {"", "", "4"}},
        {{"7", "", "1"}, {"", "9", ""}, {"5", "", ""}},
        {{"8", "2", ""}, {"", "", "4"}, {"", "5", ""}},
        {{"1", "", ""}, {"6", "", "2"}, {"", "", "3"}},
        {{"", "4", ""}, {"9", "", ""}, {"", "2", "8"}},
        {{"", "", "9"}, {"", "4", ""}, {"7", "", "3"}},
        {{"3", "", ""}, {"", "5", ""}, {"", "1", "8"}},
        {{"", "7", "4"}, {"", "3", "6"}, {"", "", ""}},};

    public MainGameClass(String difficulty, JFrame difficultyFrame, String userName) {
        this.userName = userName;
        mainGameCells = new ArrayList<Element>();
        this.difficultyFrame = difficultyFrame;
        main.setSeed(5);
        MainGameClass.difficulty = difficulty;
        this.setTitle("Sudoko"+" - "+difficulty);
        this.setBounds(400, 200, 500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(300, 300));
        parent.setLayout(new GridLayout(3, 3));
        bottom.setLayout(new GridLayout(1, 4));

        DefaultTableCellRenderer rend = new DefaultTableCellRenderer();
        rend.setHorizontalAlignment(JLabel.CENTER);

        // col[] just needed to construct the table but not actually used:
        String col[] = {"", "", ""};
        MatteBorder border = new MatteBorder(1, 1, 1, 1, Color.BLACK);

        for (int i = 0; i < table.length; i++) {
            table[i] = new JTable(data[i], col);
            table[i].setRowHeight(this.getHeight() / 9);
            table[i].setGridColor(Color.red);
       
            //table[i].setFont(new Font("Serif", Font.BOLD, 20));
            for (int j = 0; j < 3; j++) {
                table[i].getColumnModel().getColumn(j).setCellRenderer(new cellRend()); // Formatting text to be 
            }                                                                   //set in the middle of the cell

            
            table[i].setBackground(null);
            table[i].setBorder(border);
            table[i].addMouseListener(new MouseLis(i));
            table[i].addKeyListener(new keyLis(i));
            parent.add(table[i]);
        }
            st= table[0];
            sr = MainGameClass.st.getSelectedRow();
            sc=MainGameClass.st.getSelectedColumn();



            message.setFont(new Font("Serif", Font.BOLD, 13));
            
            options.add(undo);
            menu.add(options);
            this.setJMenuBar(menu);
            c.add(parent);
            bottom.add(tl);
            bottom.add(t);
            bottom.add(message);
            bottom.add(done);
            this.add(bottom,BorderLayout.SOUTH);
        // To track the game frame resizing and resize the row heights accordingly
        this.addComponentListener(
                new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                for (int i = 0; i < 9; i++) {
                    table[i].setRowHeight(parent.getHeight() / 9);
                    table[i].repaint();

                }
            }
        });
          
            undo.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                        if(step.size()>0){
                            data[MainGameClass.step.get(step.size() - 1).s][MainGameClass.step.get(step.size() - 1).r][MainGameClass.step.get(step.size() - 1).c] = "";
                            MainGameClass.table[MainGameClass.step.get(step.size() - 1).s].setValueAt("", MainGameClass.step.get(step.size() - 1).r, MainGameClass.step.get(step.size() - 1).c);
                            MainGameClass.step.remove(step.size() - 1);
                     
                        }
                        }
                    }
            
            
            
            );


        
        
          done.addActionListener(
           new ActionListener(){
               public void actionPerformed(ActionEvent e){
                   
                   
                  MainGameClass tempFrame = (MainGameClass)SwingUtilities.getWindowAncestor((JPanel)((MainGameClass.st).getParent()));
                  tempFrame.showDifficultyFrame();
                  tempFrame.setVisible(true);
                  JFrame tempFrame2 = (JFrame)SwingUtilities.getWindowAncestor((JButton)(e.getSource()));
                  tempFrame2.setVisible(false);
                  MainGameClass.data=MainGameClass.resetSudokoData(MainGameClass.data);

                  
                  
               }
        
        
                });
        
        resetInvalidPlacementCells();
        data = resetSudokoData(data);
        data = solveRandomly(data);
        data = hideRandomElements(data);
        setInvalidPlacementCells();
    }
    
      public static boolean isMainGameCell(int s, int r, int c){
        for (int i = 0; i < mainGameCells.size(); i++){
            if (mainGameCells.get(i).s == s && mainGameCells.get(i).r == r && mainGameCells.get(i).c == c){
                return true;
            }
                    
        }
        return false;
    }
      public static void setInvalidPlacementCells(){
        for (int s = 0; s < 9; s++){
            for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                    if (data[s][r][c] != ""){
                        Element test = new Element(s,r,c);
                        mainGameCells.add(test);
                    }
                }
            }
        }
    }
      public static void resetInvalidPlacementCells(){
        mainGameCells.clear();
    }
    
    public static ArrayList<Element> getValidHideElements(Object data[][][]){
        Random n = new Random();
        ArrayList<Element> currentTableElements = new ArrayList<Element>();
        for (int s = 0; s < 9; s++){
            for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                    if (data[s][r][c] != ""){
                       currentTableElements.add(new Element(s,r,c));
                    }
                }
            }
        }
        return currentTableElements;
    }
    public void showDifficultyFrame(){
        
        difficultyFrame.setVisible(true);
    }
    public static Object[][][] hideRandomElements(Object data[][][]){
        int difficultyIndex = 50;
        switch (difficulty){
            case "Easy": difficultyIndex = 35;
            break;
            case "Medium": difficultyIndex = 55;
            break;
            case "Hard": difficultyIndex = 80;
            break;
        }

        x = getValidHideElements(data);
        for (int i = 0; i < difficultyIndex; i++){
            data = hideRandomElementBeta(data);
        }
        x.clear();
        return data;
    }
    public static Object[][][] hideRandomElementBeta(Object data[][][]){
        Random n = new Random();
        
        
        if (x.size() == 0){
            System.out.println("No More iterations needed");
        }else{
        int randomIndex = n.nextInt(x.size());
        Element temp1 = x.get(randomIndex);
        String temp2 = (String)data[temp1.s][temp1.r][temp1.c];
        x.remove(randomIndex);
        data[temp1.s][temp1.r][temp1.c] = "";
        if(hasMoreThanOneSolution(data)){
            data[temp1.s][temp1.r][temp1.c] = "" + temp2;
        }
        }
        return data;
    }
    public static boolean hasMoreThanOneSolution(Object data[][][]){
        boolean temp = hasMoreThanOneSolutionBeta(data);
        validSolutions = 0;
        return temp;        
    }
    public static boolean hasMoreThanOneSolutionBeta(Object data[][][]){
        Object test [][][];
        test = cloneSudokuData(data);
        for (int s = 0; s < 9; s++) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if ((String) test[s][r][c] != "") {
                        continue;
                    }
                    for (int val = 1; val <= 9; val++) {
                        if (isValidPlacement(s, r, c, val, test)) {
                            test[s][r][c] = "" + val;
                            if (hasMoreThanOneSolutionBeta(test)) {
                                return true;
                            } else {
                                test[s][r][c] = "";
                            }
                        }
                    }
                    return false;
                }
            }
        }
        validSolutions++;
        if (validSolutions == 2) return true;
        return false;
        

    }
    public static Object[][][] cloneSudokuData(Object giver[][][]){
        Object receiver [][][] = new Object [9][3][3];
        for (int s = 0; s < 9; s++){
            for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                    receiver[s][r][c] = giver[s][r][c];
                }
            }
        }
        return receiver;
    }
    public static Object[][][] resetSudokoData(Object data [][][]){
        for (int s = 0; s < 9; s++){
            for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                    data[s][r][c] = "";
                }
            }
        }
        return data;
    }
    public static boolean isValidPlacement(int square, int row, int col, int val, Object data [][][]) {
        //Check if the same element is in the same row
        for (int i =3 * (square / 3); i < 3 * (square / 3) + 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((String)data[i][row][j] != "")
                if (Integer.parseInt((String)data[i][row][j]) == val) {
                    return false;
                }
            }
        }
        //Check if the same element is in the same column
        for (int i = (square + 3) % 3; i <= ((square + 3) % 3) + 6; i += 3) {
            for (int j = 0; j < 3; j++) {
                if ((String)data[i][j][col] != "")
                if (Integer.parseInt((String)data[i][j][col]) == val) {
                    return false;
                }
            }
        }
        //Check if the same element is in the same square
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((String)data[square][i][j] != "")
                if (Integer.parseInt((String)data[square][i][j]) == val) {
                    return false;
                }
            }
        }
        return true;
    }
    public static Object[][][] solveRandomlyBeta(Object data[][][], ArrayList<Integer> sList, ArrayList<Integer> rList, ArrayList<Integer> cList, ArrayList<ArrayList<Integer>> vList){
        
        
        
        for (int s = 0; s < 9; s++) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if ((String) data[sList.get(s)][rList.get(r)][cList.get(c)] != "") {
                        continue;
                    }
                    for (int val = 0; val < 9; val++) {
                        if (isValidPlacement(sList.get(s), rList.get(r), cList.get(c), vList.get(s).get(val), data)) {
                            data[sList.get(s)][rList.get(r)][cList.get(c)] = "" + vList.get(s).get(val);
                            if (isFull(solveRandomlyBeta(data, sList, rList, cList, vList))) {
                                return data;
                            }
                            else {
                                data[sList.get(s)][rList.get(r)][cList.get(c)] = "";
                                continue;
                            }
                        }
                    }
                    
                    return data;
                }
            }
        }
        return data;
    }
    public static Object[][][] solveRandomly(Object data[][][]){
        Random temp = new Random();
        main.setSeed(temp.nextInt(2000000));
ArrayList<Integer> sList = new ArrayList<Integer>();
        ArrayList<Integer> rList = new ArrayList<Integer>();
        ArrayList<Integer> cList = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> vList = new ArrayList<ArrayList<Integer>>();
for (int i = 0; i < 9; i++){
            sList.add(i);
        }
        for (int i = 0; i < 3; i++){
            rList.add(i);
        }
        for (int i = 0; i < 3; i++){
            cList.add(i);
        }
        for (int i = 0; i < 9; i++){
            vList.add(new ArrayList<Integer>());
            for (int j = 0; j < 9; j++){
            vList.get(i).add(j + 1);
            }
        }
        Collections.shuffle(sList, main);
        Collections.shuffle(rList, main);
        Collections.shuffle(cList, main);
        for (int i = 0; i < 9; i++){
            main.setSeed(temp.nextInt(2000000));
            Collections.shuffle(vList.get(i), main);
        }
//        for (int i = 0; i < 9; i++){
//            System.out.println(sList.get(i));
//        }
        return solveRandomlyBeta(data, sList, rList, cList, vList);
    }
    public static boolean isFull (Object data[][][]){
        for (int s = 0; s < 9; s++){
            for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                    if ((String)data[s][r][c] == "") return false;
                }
            }
        }
        return true;
    }
    }
