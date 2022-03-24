package tasks;

import java.util.HashSet;
import java.util.Set;

/**
 * Хранит информацию о книгах и позволяет их искать.
 * Для каждой книги хранится название, автор и жанр,
 * а также код полки, на которой она лежит (например, А3 или Г4.
 * Вы можете сами придумать реалистичную систему кодирования полок).
 * Операции: конструктор, добавить/удалить книгу, изменить существующую книгу,
 * переместить книгу на другую полку, поиск книг по разным признакам
 * (по автору, по названию, по словам из названия, по жанру, по коду полки,
 * по комбинации этих признаков).
 */

public class Library {
    private final HashSet<Book> library = new HashSet<Book>();

    public static void main(String args[]) {

    }

    //содержится ли книга в библиотеке
    public boolean contains(Book oneBook) {
        return library.contains(oneBook);
    }

    //добавить книгу
    public void add(Book oneBook) {
        library.add(oneBook);
    }

    //удалить книгу
    public boolean remove(Book oneBook) {
        return library.remove(oneBook);
    }

    //изменить параметр книги (вводить параметры, которые хотим изменить, остальные null)
    public boolean changes(Book oldBook, String name, String author, String genre) {
        if (library.contains(oldBook)) {
            String useName = oldBook.getName();
            String useAuthor = oldBook.getAuthor();
            String useGenre = oldBook.getGenre();
            if (name != null)
                useName = name;
            if (author != null)
                useAuthor = author;
            if (genre != null)
                useGenre = genre;
            Book ans = new Book(useName, useAuthor, useGenre, oldBook.getCode());
            library.remove(oldBook);
            library.add(ans);
            return true;
        } else
            return false;
    }

    //переместить книгу на другую полку
    public boolean shift(Book oldBook, String newCode) {
        Book makeBook = new Book(oldBook.getName(), oldBook.getAuthor(), oldBook.getGenre(), newCode);
        if (library.remove(oldBook)) {
            library.add(makeBook);
            return true;
        } else
            return false;
    }

    //поиск книги (вводить известные параметры, неизвестные null)
    public Set<Book> search(String name, String author, String genre, String code) {
        Set<Book> booksForYou = new HashSet<Book>();
        for (Book i : library) {
            if (i.simile(name, author, genre, code))
                booksForYou.add(i);
        }
        return booksForYou;
    }
}

