import java.nio.channels.Pipe;

public abstract class Book{
    String title;
    String genre;
    String author;
    String subject;
    int edition;
    int qty;

    public void book(String str){
        
    }

    public void printInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
    }
}