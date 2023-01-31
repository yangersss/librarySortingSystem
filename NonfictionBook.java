public class NonfictionBook extends Book{
    public NonfictionBook (String str){
        super(str); // use the constructor in the abstract class Book
    }
    public void printInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Genre: " + this.genre);
    }
}
