package tasks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void add() {
        Library library = new Library();
        library.add(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));
        library.add(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));
        assertTrue(library.contains(new Book("гордость и предубеждение", "джейн остин", "роман", "A2")));
    }

    @Test
    public void remove() {
        Library library = new Library();
        library.add(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));
        library.add(new Book("мы", "замятин", "антиутопия", "Б3"));
        library.remove(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));
        assertFalse(library.contains(new Book("гордость и предубеждение", "джейн остин", "роман", "A2")));
    }

    @Test(expected = Exception.class)
    public void ExRemove() {
        Library library = new Library();
        library.add(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));
        library.add(new Book("мы", "замятин", "антиутопия", "Б3"));
        library.remove(new Book("гордость", "джейн остин", "роман", "A2"));
        library.remove(new Book("vs", "замятин", "антиутопия", "Б3"));
    }

    @Test
    public void changes() {
        Library library = new Library();
        library.add(new Book("время жить и время умирать", "эрих мария", "роман", "T7"));
        library.changes(new Book("время жить и время умирать", "эрих мария", "роман", "T7"),
                null, "ремарк", "антивоенный роман");
        assertTrue(library.contains(new Book("время жить и время умирать", "ремарк", "антивоенный роман", "T7")));
    }

    @Test(expected = Exception.class)
    public void ExChanges() {
        Library library = new Library();
        library.add(new Book("время жить и время умирать", "эрих мария", "роман", "T7"));
        library.changes(new Book("десять негритят", "агата кристи", "детектив", "T7"),
                null, "ремарк", "антивоенный роман");
    }

    @Test
    public void shift() {
        Library library = new Library();
        library.add(new Book("собор парижской богоматери", "гюго", "роман", "89"));
        library.shift(new Book("собор парижской богоматери", "гюго", "роман", "89"), "D8");
        assertTrue(library.contains(new Book("собор парижской богоматери", "гюго", "роман", "D8")));
    }

    @Test(expected = Exception.class)
    public void ExShift() {
        Library library = new Library();
        library.add(new Book("собор парижской богоматери", "гюго", "роман", "89"));
        library.shift(new Book("собор парижской богоматери", "виктор", "роман", "89"), "D8");
    }

    @Test
    public void search() {
        Library library = new Library();
        library.add(new Book("1984", "оруэлл", "роман", "Y0"));
        library.add(new Book("451 градус по фаренгейту", "брэдбери", "антиутопия", "F2"));
        library.add(new Book("записки юного врача", "булгаков", "цикл рассказов", "G1"));
        library.add(new Book("451", "брэдбери", "анти", "F2"));
        library.add(new Book("градус", "брэдбери", "утопия", "F2"));
        HashSet<Book> books = library.search(null, "брэдбери", null, "F2");
        HashSet<Book> ideal = new HashSet<Book>();
        ideal.add(new Book("451 градус по фаренгейту", "брэдбери", "антиутопия", "F2"));
        ideal.add(new Book("451", "брэдбери", "анти", "F2"));
        ideal.add(new Book("градус", "брэдбери", "утопия", "F2"));
        assertEquals(ideal, books);
    }

    @Test(expected = Exception.class)
    public void ExSearch() {
        Library library = new Library();
        library.add(new Book("1984", "оруэлл", "роман", "Y0"));
        library.add(new Book("451 градус по фаренгейту", "брэдбери", "антиутопия", "F2"));
        library.add(new Book("записки юного врача", "булгаков", "цикл рассказов", "G1"));
        HashSet<Book> firstBooks = library.search(null, "брэдбери", null, "F1");
        HashSet<Book> secondBooks = library.search("1984", null, "антиутопия", null);
    }
}
