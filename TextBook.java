public class TextBook extends Book{
    public TextBook(String str){
        super(str); // use the constructor in the abstract class Book
    }
    public void printInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Genre: " + this.genre);
        System.out.println("Author: " + this.author);
        System.out.println("Subject: " + this.subject);
        System.out.println("Edition: " + this.edition);
    }
}
