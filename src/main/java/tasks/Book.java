package tasks;

public class Book {
    private String name;
    private String author;
    private String genre;
    private String code;

    //конструктор для книги
    public Book(String name, String author, String genre, String code) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.code = code;
    }

    @Override
    public boolean equals(Object book) {
        if (this == book)
            return true;
        if (book == null || this.getClass() != book.getClass())
            return false;
        tasks.Book input = (tasks.Book) book;
        return name.equals(input.name) && author.equals(input.author) &&
                genre.equals(input.genre) && code.equals(input.code);
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getCode() {
        return code;
    }
}
