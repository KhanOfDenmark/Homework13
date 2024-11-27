class Book {
    private final String title;
    private final Author author;
    private int yearOfPublication;
    private String nick;

    public Book (String title, Author author, int yearOfPublication){
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        nick = (this.title +this.author +this.yearOfPublication).toUpperCase();
    }

    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author.getAuthor();
    }
    public int getYearOfPublication(){
        return this.yearOfPublication;
    }

    public void setYearOfPublication(int year){
        this.yearOfPublication = year;
        nick = (this.title +this.author +this.yearOfPublication).toUpperCase();
    }

    @Override
    public boolean equals(Object other){
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Book c2 = (Book) other;
        return nick.equals(c2.nick);
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(nick);
    }
    @Override
    public String toString(){
        return title +" | "+author.toString() +" " +yearOfPublication;
    }
}

class Author {
    private final String firstName;
    private final String lastName;
    private final String nick;

    public Author (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = (this.firstName +this.lastName).toUpperCase();
    }

    public Author (String author){
        String[] inintials = author.split(" ");
        this.firstName = inintials[0];
        this.lastName = inintials[1];
        this.nick = (this.firstName +this.lastName).toUpperCase();
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getAuthor(){
        return (this.firstName +this.lastName);
    }

    @Override
    public boolean equals(Object other){
        if (this.getClass() != other.getClass()){
            return false;
        }
        Author c2 = (Author) other;
        return nick.equals(c2.nick);
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(nick);
    }
    @Override
    public String toString(){
        return firstName +" " +lastName;
    }
}

public class Main {
    public static void main(String[] args){
        System.out.println("***");
        Author firstAuthor = new Author("Geremy Nikelson");
        Author secondAuthor = new Author("Geremy", "Nikelson");
        Book firstBook = new Book("Lost in the intertemporal"
                ,firstAuthor,1986);
        Book secondBook = new Book("Lost in the intertemporal"
                ,secondAuthor,1962);

        System.out.println(firstAuthor);    //Выводит информацию автора
        System.out.println(firstAuthor.equals(secondAuthor));   //Сравнивает объекты
        System.out.println(firstAuthor.hashCode()
                ==secondAuthor.hashCode());    //Сравнивает хэшКоды
        System.out.println(firstAuthor.hashCode()); //Выводит хэшКод автора
        System.out.println("---");

        System.out.println(firstBook);  //Выводит информацию книги
        System.out.println(firstBook.equals(secondBook));   //Сравнивает объекты
        System.out.println(firstBook.hashCode()
                ==secondBook.hashCode());  //Сравнивает хэшКоды
        System.out.println(firstBook.hashCode());   //Выводит хэшКод книги
        System.out.println("---");

        firstBook.setYearOfPublication(1962);   //Меняет год публикации
        System.out.println(firstBook);    //Выводит информацию книги
        System.out.println(firstBook.equals(secondBook));   //Сравнивает объекты
        System.out.println(firstBook.hashCode()
                ==secondBook.hashCode());    //Сравнивает хэшКоды
        System.out.println(firstBook.hashCode());   //Выводит хэшКод книги
        System.out.println("***");
    }
}