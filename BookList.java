import java.util.ArrayList;

public class BookList {
    ArrayList<Book> books;

    public void addToList(Book book){
        //search
        for (Book i : books){
            if (i.author.equals(book.author) && i.title.equals(book.title)){
                book.qty ++;
                System.out.println("Added a copy of " + book.title);
            }
            else{
                books.add(book);
                System.out.println("Added " + book.title);
            }
        }
    }

    public void removeFromList(String author, String title){
        for (Book book : books){
            if (book.author.equals(author) && book.title.equals(title)){
                books.remove(book);
                System.out.println("Alright, removed " + book.title);
            }
        }
    }

    public void removeFromList(String author, String title, int edition){
        for (Book book : books){
            if (book.author.equals(author) && book.title.equals(title) && book.edition == edition){
                books.remove(book);
                System.out.println("Alright, removed " + book.title);
            }
        }
    }

    public void sortList(String method){ //methods: title, genre, author, subject
        //just for giggles, what if we do quicksort
    }

    public void printTable(){

    }
}
