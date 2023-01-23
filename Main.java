import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        File srcFile = new File ("./booklist.csv");
        Scanner myScanner = new Scanner(srcFile);
        
        ArrayList<Book> books = new ArrayList<Book>();

        String line = myScanner.nextLine();
        String[] words = line.split(",");
        switch (words[1]){
            case "Fiction":
                books.add(new FictionBook(line));
                break;
            case "Textbook":
                books.add(new TextBook(line));
                break;
            case "Nonfiction":
                books.add(new NonfictionBook(line));
                break;
        }
        
    }
}
