import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        File srcFile = new File ("./booklist.csv");
        Scanner myScanner = new Scanner(srcFile);

        BookList b = new BookList ();
        
        String line = myScanner.nextLine();

        while (myScanner.hasNextLine()){
            String[] words = line.split(",");
            
            if (words[1].equals("Fiction")){
                b.addToList(new FictionBook(line));
            }
            else if (words[1].equals("Textbook")){
                b.addToList(new TextBook(line));
            }
            else if (words[1].equals("Nonfiction")){
                b.addToList(new NonfictionBook(line));
            }
            else{
                System.out.println("Invalid");
            }
            line = myScanner.nextLine();
        }

        myScanner.close();

        b.printTable();
        //b.sortList("title");
        
    }
}
