import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        File srcFile = new File ("./booklist.csv");
        Scanner myScanner = new Scanner(srcFile);

        BookList b = new BookList ();
        
        String line = myScanner.nextLine();

        while (myScanner.hasNextLine()){
            String[] words = line.split(",");
            switch (words[1]){
                case "Fiction":
                    b.books.add(new FictionBook(line));
                    break;
                case "Textbook":
                    b.books.add(new TextBook(line));
                    break;
                case "Nonfiction":
                    b.books.add(new NonfictionBook(line));
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
            line = myScanner.nextLine();
        }
        b.printTable();
        
        
    }
}
