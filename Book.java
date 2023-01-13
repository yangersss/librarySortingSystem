public abstract class Book{
    public String title;
    public String genre;
    public String author;
    public String subject;
    public int edition;
    public int qty;

    //longer projects should use private attributes and setter/getter methods

    public void book(String str){
        // title, genre, author, subject, edition, qty

        String[] words = str.split(",");
        title = words[0];
        genre = words[1];
        author = words[2];
        subject = words[3];
        edition = Integer.parseInt(words[4]);
        qty = Integer.parseInt(words[5]);
    }

    public void printInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
    }
}