package tasks;

import java.util.ArrayList;
import java.util.HashSet;

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

    public HashSet<Book> library = new HashSet<Book>();

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
    public void remove(Book oneBook) {
        if (library.contains(oneBook))
            library.remove(oneBook);
        else
            throw new NullPointerException("такой книги не существует");
    }

    //изменить параметр книги (вводить параметры, которые хотим изменить, остальные null)
    public void changes(Book oldBook, String name, String author, String genre) {
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
        } else
            throw new NullPointerException("отсутствует книга для изменений");
    }

    //переместить книгу на другую полку
    public void shift(Book oldBook, String newCode) {
        Book makeBook = new Book(oldBook.getName(), oldBook.getAuthor(), oldBook.getGenre(), newCode);
        if (library.contains(oldBook)) {
            library.remove(oldBook);
            library.add(makeBook);
        } else
            throw new NullPointerException("книга для перемещения не найдена");
    }

    //поиск книги (вводить известные параметры, неизвестные null)
    public HashSet<Book> search(String name, String author, String genre, String code) {
        HashSet<Book> booksForYou = new HashSet<Book>();
        for (Book i : library) {
            if (i.simile(name, author, genre, code))
                booksForYou.add(i);
        }
        if (booksForYou.isEmpty())
            throw new NullPointerException("такой книги не существует");
        else
            return booksForYou;
    }
}

