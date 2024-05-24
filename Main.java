import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
class Main {
  static BinTree morseTrans = new BinTree();
  public static void main(String[] args) {
    treeCreator(); //adds everything to the binary tree
    try {
      File myObj = new File("Messages.txt");
      Scanner reader = new Scanner(myObj);
      while (reader.hasNextLine()) {//goes line by line
        while (reader.hasNext()) {//goes space to space
        String morse = reader.next();
        if ((morse.charAt(0) == '.')||(morse.charAt(0) == '-')) //ir morse code, translates
        {
          System.out.print(morseTrans.getLetter(morse));//prints letter
        }
        if (morse.charAt(0) == '/')//adds space
        {
          System.out.print(" ");
        }
        if (morse.charAt(0) == '*')//adds new line
        {
          System.out.print("\n");
        }
        }

        
      }
      
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("\n\n>End of File");
  }
  
  public static void treeCreator(){
  
  try {
      File myObj = new File("Morse.txt");
      Scanner scan = new Scanner(myObj);
      
      
      while (scan.hasNextLine()) { //line by line
        String data = scan.nextLine();
        //System.out.println(data);
        char letter = data.charAt(0);//splits letter and code
        String code = data.substring(4);
        /*
        System.out.println(letter +"-("+code+")"); */
        morseTrans.InsertItem(letter, code); //inserts letter into tree
        //morseTrans.InOrder();
      }
      //morseTrans.InOrder();
      //System.out.println();
      scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}