package tasks;

public class Book {
    private final String name;
    private final String author;
    private final String genre;
    private final String code;

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
        Book input = (Book) book;
        return name.equals(input.name) && author.equals(input.author) &&
                genre.equals(input.genre) && code.equals(input.code);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + author.hashCode() + genre.hashCode() + code.hashCode();
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

    public boolean simile(String simName, String simAuthor, String simGenre, String simCode) {
        return ((simName == null) || (simName.equals(name))) && ((simAuthor == null) || (simAuthor.equals(author))) && ((simGenre == null) ||
                (simGenre.equals(genre))) && ((simCode == null) || (simCode.equals(code)));
    }
}
