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

class Book {
    String name;
    String author;
    String genre;
    String code;

    //конструктор для книги
    public Book(String name, String author, String genre, String code) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.code = code;
    }
}

public class Library {
    public ArrayList<Book> library = new ArrayList<Book>();

    public static void main(String args[]) {

    }

    //узнать есть ли эта книга
    private int ind(Book oneBook) {
        int index = -1;
        for (int i = 0; i < library.size(); i++) {
            if ((oneBook.name == library.get(i).name) && (oneBook.author == library.get(i).author) &&
                    (oneBook.genre == library.get(i).genre) && (oneBook.code == library.get(i).code))
                index = i;
        }
        return index;
    }


    //добавить книгу
    public void add(String name, String author, String genre, String code) {
        Book oneBook = new Book(name, author, genre, code);
        int index = ind(oneBook);
        if (index == -1)
            library.add(oneBook);
    }


    //удалить книгу
    public void remove(String name, String author, String genre, String code) {
        Book oneBook = new Book(name, author, genre, code);
        int index = ind(oneBook);
        if (index != -1)
            library.remove(index);
    }

    //изменить параметр книги (вводить параметры, которые хотим изменить, остальные оставлять пустыми строками)
    public void changes(Book oldBook, String name, String author, String genre) {
        int index = ind(oldBook);
        String useName = oldBook.name;
        String useAuthor = oldBook.author;
        String useGenre = oldBook.genre;
        if (!(name.isEmpty()))
            useName = name;
        if (!(author.isEmpty()))
            useAuthor = author;
        if (!(genre.isEmpty()))
            useGenre = genre;
        Book ans = new Book(useName, useAuthor, useGenre, oldBook.code);
        library.set(index, ans);
    }

    //переместить книгу на другую полку
    public void shift(Book oldBook, String newCode) {
        Book makeBook = new Book(oldBook.name, oldBook.author, oldBook.genre, newCode);
        int index = ind(oldBook);
        if (index != -1)
            library.set(index, makeBook);
    }

    //вывод книги по индексу
    public Book get(Integer index) {
        return library.get(index);
    }

    //поиск книги (вводить известные параметры, неизвестные оставлять пустыми строками)
    public Book search(String name, String author, String genre, String code) {
        int index = -1;
        for (int i = 0; i < library.size(); i++) {
            if (((name == library.get(i).name) || (name.isEmpty())) && ((author == library.get(i).author) ||
                    (author.isEmpty())) && ((genre == library.get(i).genre) || (genre.isEmpty())) &&
                    ((code == library.get(i).code) || (code.isEmpty())))
                index = i;
        }
        if (index != -1)
            return library.get(index);
        else
            return new Book("0", "0", "0", "0");
    }

}

