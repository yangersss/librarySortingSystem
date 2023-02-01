import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        File srcFile = new File ("./booklist.csv");
        Scanner myScanner = new Scanner(srcFile); //ready the file

        BookList b = new BookList ();
        
        String line = myScanner.nextLine(); //prepare first line

        while (myScanner.hasNextLine()){ //until it goes to the end
            String[] words = line.split(",");//split each line of csv into array of words
            
            if (words[1].equals("Fiction")){//index 1 contains genre. based off genre, create instance of fictionbook, textbook,nonfictionbook
                b.addToList(new FictionBook(line));
            }
            else if (words[1].equals("Textbook")){
                b.addToList(new TextBook(line));
            }
            else if (words[1].equals("Nonfiction")){
                b.addToList(new NonfictionBook(line));
            }
            else{
                System.out.println("Run out of lines");
            }
            line = myScanner.nextLine();//incrememnt to next line
        }

        myScanner.close();

        //b.printTable();
        b.sortList("title");
        b.sortList("genre");
        b.sortList("author");
        b.sortList("subject");
        
        b.sortList("dababy");
    }
}
