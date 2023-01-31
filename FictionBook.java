public class FictionBook extends Book{   
    public FictionBook(String str){
        super(str); // use the constructor in the abstract class Book
    }
    
    public void printInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Edition: " + this.edition);
    }
}
