package tasks;

import java.util.ArrayList;

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

    public ArrayList<Book> library = new ArrayList<Book>();

    public static void main(String args[]) {

    }

    //содержится ли книга в библиотеке
    public Boolean contains(Book oneBook) {
        return library.contains(oneBook);
    }

    //добавить книгу
    public void add(Book oneBook) {
        int index = library.indexOf(oneBook);
        if (index == -1)
            library.add(oneBook);
        else
            throw new NullPointerException("такая книга уже существует");
    }

    //удалить книгу
    public void remove(Book oneBook) {
        int index = library.indexOf(oneBook);
        if (index != -1)
            library.remove(index);
        else
            throw new NullPointerException("такой книги не существует");
    }

    //изменить параметр книги (вводить параметры, которые хотим изменить, остальные null)
    public void changes(Book oldBook, String name, String author, String genre) {
        int index = library.indexOf(oldBook);
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
        library.set(index, ans);
    }

    //переместить книгу на другую полку
    public void shift(Book oldBook, String newCode) {
        Book makeBook = new Book(oldBook.getName(), oldBook.getAuthor(), oldBook.getGenre(), newCode);
        int index = library.indexOf(oldBook);
        if (index != -1)
            library.set(index, makeBook);
        else
            throw new NullPointerException("книга для перемещения не найдена");
    }

    //поиск книги (вводить известные параметры, неизвестные null)
    public Book search(String name, String author, String genre, String code) {
        Book book = new Book(null, null, null, null);
        for (Book i : library) {
            if (((name == null) || (name.equals(i.getName()))) && ((author == null) || (author.equals(i.getAuthor()))) && ((genre == null) ||
                    (genre.equals(i.getGenre()))) && ((code == null) || (code.equals(i.getCode()))))
                book = i;
        }
        if (book.equals(new Book(null, null, null, null)))
            throw new NullPointerException("такой книги не существует");
        else
            return book;
    }
}

