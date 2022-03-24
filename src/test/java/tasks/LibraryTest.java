package tasks;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
        assertTrue(library.remove(new Book("гордость и предубеждение", "джейн остин", "роман", "A2")));
        assertFalse(library.contains(new Book("гордость и предубеждение", "джейн остин", "роман", "A2")));

        assertFalse(library.remove(new Book("гордость", "джейн остин", "роман", "A2")));
        assertFalse(library.remove(new Book("vs", "замятин", "антиутопия", "Б3")));
    }


    @Test
    public void changes() {
        Library library = new Library();
        library.add(new Book("время жить и время умирать", "эрих мария", "роман", "T7"));
        library.changes(new Book("время жить и время умирать", "эрих мария", "роман", "T7"),
                null, "ремарк", "антивоенный роман");
        assertTrue(library.contains(new Book("время жить и время умирать", "ремарк", "антивоенный роман", "T7")));

        assertFalse(library.changes(new Book("десять негритят", "агата кристи", "детектив", "T7"),
                null, "ремарк", "антивоенный роман"));
    }


    @Test
    public void shift() {
        Library library = new Library();
        library.add(new Book("собор парижской богоматери", "гюго", "роман", "89"));
        library.shift(new Book("собор парижской богоматери", "гюго", "роман", "89"), "D8");
        assertTrue(library.contains(new Book("собор парижской богоматери", "гюго", "роман", "D8")));
        
        assertFalse(library.shift(new Book("собор парижской богоматери", "виктор", "роман", "89"), "K8"));
    }

    @Test
    public void search() {
        Library library = new Library();
        library.add(new Book("1984", "оруэлл", "роман", "Y0"));
        library.add(new Book("451 градус по фаренгейту", "брэдбери", "антиутопия", "F2"));
        library.add(new Book("записки юного врача", "булгаков", "цикл рассказов", "G1"));
        library.add(new Book("451", "брэдбери", "анти", "F2"));
        library.add(new Book("градус", "брэдбери", "утопия", "F2"));
        Set<Book> books = library.search(null, "брэдбери", null, "F2");
        Set<Book> ideal = new HashSet<Book>();
        ideal.add(new Book("451 градус по фаренгейту", "брэдбери", "антиутопия", "F2"));
        ideal.add(new Book("451", "брэдбери", "анти", "F2"));
        ideal.add(new Book("градус", "брэдбери", "утопия", "F2"));
        assertEquals(ideal, books);

        assertTrue(library.search(null, "брэдбери", null, "F1").isEmpty());
        assertTrue(library.search("1984", null, "антиутопия", null).isEmpty());
    }
}
