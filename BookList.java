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
        int longestTitle = findLongestTitle();
        int longestGenre = findLongestGenre();
        int longestAuthor = findLongestAuthor();
        int longestSubject = findLongestSubject();
        int longestEdition = findLongestEdition();
        int longestQty = findLongestQty();
        
        System.out.print(" ");
        
        
        
        System.out.println(" ______________________________________________________________");
        System.out.println("| Title       | Genre    | Author       | Subject| Edition |QTY|");
        System.out.println("|-------------|----------|--------------|--------|---------|---|");
    }

    //there's gotta be a better way to do this, right?

    public int findLongestTitle(){
        String longestTitle = books.get(0).title;
        for (Book b: books){
            if (b.title.length() > longestTitle.length()){
                longestTitle = b.title;
            }
        }
        return longestTitle.length();
    }
    public int findLongestGenre(){
        String longestGenre = books.get(0).genre;
        for (Book b: books){
            if (b.genre.length() > longestGenre.length()){
                longestGenre = b.title;
            }
        }
        return longestGenre.length();
    }
    public int findLongestAuthor(){
        String longestAuthor = books.get(0).author;
        for (Book b: books){
            if (b.author.length() > longestAuthor.length()){
                longestAuthor = b.title;
            }
        }
        return longestAuthor.length();
    }
    public int findLongestSubject(){
        String longestSubject = books.get(0).subject;
        for (Book b: books){
            if (b.subject.length() > longestSubject.length()){
                longestSubject = b.title;
            }
        }
        return longestSubject.length();
    }
    public int findLongestEdition(){
        String longestEdition = Integer.toString(books.get(0).edition);
        for (Book b: books){
            if (Integer.toString(b.edition).length() > longestEdition.length()){
                longestEdition = Integer.toString(b.edition);
            }
        }
        return longestEdition.length();
    }
    public int findLongestQty(){
        String longestQty = Integer.toString(books.get(0).qty);
        for (Book b: books){
            if (Integer.toString(b.qty).length() > longestQty.length()){
                longestQty = Integer.toString(b.qty);
            }
        }
        return longestQty.length();
    }
}
