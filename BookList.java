import java.util.ArrayList;

public class BookList {
    ArrayList<Book> books;

    public BookList(){ //constructor
        books = new ArrayList<Book>();
    }

    public void addToList(Book book){ //add this book to the ArrayList. if an instance already exists, increment the quantity by one
        //search
        boolean found = false; //
        
        for (Book i : books){
            if (i.author.equals(book.author) && i.title.equals(book.title)){ //check author and title to see if they match
                i.qty ++;
                //System.out.println("Added a copy of " + book.title);
                found = true;
            } 
        }
        if (!found){
            books.add(book);
            //System.out.println("Added " + book.title);
        }
    }

    public void removeFromList(String author, String title){ // input an author and title of a book. if they match an element in the arraylist, remove it from the list
        for (Book book : books){
            if (book.author.equals(author) && book.title.equals(title)){
                books.remove(book);
                System.out.println("Alright, removed " + book.title);
            }
        }
    }

    public void removeFromList(String author, String title, int edition){ // same as the previous function, but overloaded to also take in an int edition 
        for (Book book : books){
            if (book.author.equals(author) && book.title.equals(title) && book.edition == edition){
                books.remove(book);
                System.out.println("Alright, removed " + book.title);
            }
        }
    }

    public void sortList(String method){ //methods: title, genre, author, subject
        //just for giggles, what if we do quicksort
        //okay nevermind that is too much work and i am lazy
        
        switch (method.toLowerCase()){ //insertion sort to sort by string method input
            case "title":
                for (int i = 1; i < books.size(); i ++){
                    if (books.get(i).title.compareTo(books.get(i -1).title) < 0){
                        /* Swap (index 1, index 2, temp)
                        temp = 2 (1, 2, 2)
                        2 = 1   (1, 1, 2)
                        1 = temp(2) (2, 1, 2)                
                         */
                        Book temp = books.get(i - 1);
                        books.set(i - 1, books.get(i));
                        books.set(i, temp);
                        if (i > 1){
                            for (int j = i - 1; i > 0; i--){
                                if (books.get(j).title.compareTo(books.get(j-1).title) < 0){
                                    Book temp2 = books.get(j - 1);
                                    books.set(j - 1, books.get(j));
                                    books.set(j, temp2);
                                }
                            }
                        }
                    }
                }
                System.out.println("\nHere's the booklist sorted by " + method + ":");
                printTable();
                break;
            case "genre":
                for (int i = 1; i < books.size(); i ++){
                    if (books.get(i).genre.compareTo(books.get(i -1).genre) < 0){
                        Book temp = books.get(i - 1);
                        books.set(i - 1, books.get(i));
                        books.set(i, temp);
                        if (i > 1){
                            for (int j = i - 1; i > 0; i--){
                                if (books.get(j).genre.compareTo(books.get(j-1).genre) < 0){
                                    Book temp2 = books.get(j - 1);
                                    books.set(j - 1, books.get(j));
                                    books.set(j, temp2);
                                }
                            }
                        }
                    }
                }
                System.out.println("\nHere's the booklist sorted by " + method + ":");
                printTable();
                break;
            case "author":
                for (int i = 1; i < books.size(); i ++){
                    if (books.get(i).author.compareTo(books.get(i -1).author) < 0){
                        Book temp = books.get(i - 1);
                        books.set(i - 1, books.get(i));
                        books.set(i, temp);
                        if (i > 1){
                            for (int j = i - 1; i > 0; i--){
                                if (books.get(j).author.compareTo(books.get(j-1).author) < 0){
                                    Book temp2 = books.get(j - 1);
                                    books.set(j - 1, books.get(j));
                                    books.set(j, temp2);
                                }
                            }
                        }
                    }
                }
                System.out.println("\nHere's the booklist sorted by " + method + ":");
                printTable();
                break;
            case "subject":
                for (int i = 1; i < books.size(); i ++){
                    if (books.get(i).subject.compareTo(books.get(i -1).subject) < 0){
                        Book temp = books.get(i - 1);
                        books.set(i - 1, books.get(i));
                        books.set(i, temp);
                        if (i > 1){
                            for (int j = i - 1; i > 0; i--){
                                if (books.get(j).subject.compareTo(books.get(j-1).subject) < 0){
                                    Book temp2 = books.get(j - 1);
                                    books.set(j - 1, books.get(j));
                                    books.set(j, temp2);
                                }
                            }
                        }
                    }
                }
                System.out.println("\nHere's the booklist sorted by " + method + ":");
                printTable();
                break;
            default:
                System.out.println("\ninvalid method");
        }

    }

    public void printTable(){
        int longestTitle = findLongestTitle(); //variables used to have identialy spaced columns
        int longestGenre = findLongestGenre();
        int longestAuthor = findLongestAuthor();
        int longestSubject = findLongestSubject();
        int longestEdition = findLongestEdition();
        int longestQty = findLongestQty();
        
        System.out.print(" ");
        for (int i = 0; i < longestTitle + longestGenre + longestAuthor + longestSubject + longestEdition + longestQty + 15; i++){ //long line at the top
            System.out.print("_");
        }
        System.out.print("\n| Title"); //this part prints out the column headers
        for (int i = 0; i < longestTitle - 6; i++){
            System.out.print(" ");
        }
        System.out.print("| Genre");
        for (int i = 0; i < longestGenre - 6; i++){
            System.out.print(" ");
        }
        System.out.print("| Author");
        for (int i = 0; i < longestAuthor - 7; i++){
            System.out.print(" ");
        }
        System.out.print("| Subject");
        for (int i = 0; i < longestSubject - 8; i++){
            System.out.print(" ");
        }
        System.out.print("| Edition | QTY|");
        
        
        for (Book b : books){ //prints out the rows, with proper spacing
            System.out.print("\n|" + b.title);
            for (int i = 0; i < longestTitle - b.title.length(); i++){
                System.out.print(" ");
            }
            System.out.print("|" + b.genre);
            for (int i = 0; i < longestGenre - b.genre.length(); i++){
                System.out.print(" ");
            }
            System.out.print("|" + b.author);
            for (int i = 0; i < longestAuthor - b.author.length(); i++){
                System.out.print(" ");
            }
            System.out.print("|" + b.subject);
            for (int i = 0; i < longestSubject - b.subject.length(); i++){
                System.out.print(" ");
            }
            System.out.print("|" + b.edition);
            for (int i = 0; i < 9 - Integer.valueOf(b.edition).toString().length(); i++){
                System.out.print(" ");
            }
            System.out.print("|" + b.qty + "   |");
        }
        System.out.println(" "); //then, print out a long bar at the bottom (same as above)
        for (int i = 0; i < longestTitle + longestGenre + longestAuthor + longestSubject + longestEdition + longestQty + 16; i++){
            System.out.print("_");
        }
    }

    //there's gotta be a better way to do this, right?

    public int findLongestTitle(){
        String longestTitle = "";
        for (Book b: books){
            if (b.title.length() > longestTitle.length()){
                longestTitle = b.title;
            }
        }
        return longestTitle.length();
    }
    public int findLongestGenre(){
        String longestGenre = "";
        for (Book b: books){
            if (b.genre.length() > longestGenre.length()){
                longestGenre = b.title;
            }
        }
        return longestGenre.length();
    }
    public int findLongestAuthor(){
        String longestAuthor = "";
        for (Book b: books){
            if (b.author.length() > longestAuthor.length()){
                longestAuthor = b.author;
            }
        }
        return longestAuthor.length();
    }
    public int findLongestSubject(){
        String longestSubject = "";
        for (Book b: books){
            if (b.subject.length() > longestSubject.length()){
                longestSubject = b.title;
            }
        }
        return longestSubject.length();
    }
    public int findLongestEdition(){
        String longestEdition = "";
        for (Book b: books){
            if (Integer.toString(b.edition).length() > longestEdition.length()){
                longestEdition = Integer.toString(b.edition);
            }
        }
        return longestEdition.length();
    }
    public int findLongestQty(){
        String longestQty = "";
        for (Book b: books){
            if (Integer.toString(b.qty).length() > longestQty.length()){
                longestQty = Integer.toString(b.qty);
            }
        }
        return longestQty.length();
    }
}
