package tasks;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LibraryTest {

    @Test
    public void add() throws Exception {
        Library library = new Library();
        library.add(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));
        assertTrue(library.contains(new Book("гордость и предубеждение", "джейн остин", "роман", "A2")));
    }

    @Test(expected = Exception.class)
    public void ExAddAndRem() throws Exception {
        Library library = new Library();
        library.add(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));
        library.add(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));

        library.add(new Book("мы", "замятин", "антиутопия", "Б3"));
        library.remove(new Book("гордость", "джейн остин", "роман", "A2"));
        library.remove(new Book("vs", "замятин", "антиутопия", "Б3"));
    }

    @Test
    public void remove() throws Exception {
        Library library = new Library();
        library.add(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));
        library.add(new Book("мы", "замятин", "антиутопия", "Б3"));
        library.remove(new Book("гордость и предубеждение", "джейн остин", "роман", "A2"));
        assertTrue(library.contains(new Book("мы", "замятин", "антиутопия", "Б3")));
    }

    @Test
    public void changes() throws Exception {
        Library library = new Library();
        library.add(new Book("время жить и время умирать", "эрих мария", "роман", "T7"));
        library.changes(new Book("время жить и время умирать", "эрих мария", "роман", "T7"),
                null, "ремарк", "антивоенный роман");
        assertTrue(library.contains(new Book("время жить и время умирать", "ремарк", "антивоенный роман", "T7")));
    }

    @Test
    public void shift() throws Exception {
        Library library = new Library();
        library.add(new Book("собор парижской богоматери", "гюго", "роман", "89"));
        library.shift(new Book("собор парижской богоматери", "гюго", "роман", "89"), "D8");
        assertTrue(library.contains(new Book("собор парижской богоматери", "гюго", "роман", "D8")));
    }

    @Test(expected = Exception.class)
    public void ExShift() throws Exception {
        Library library = new Library();
        library.add(new Book("собор парижской богоматери", "гюго", "роман", "89"));
        library.shift(new Book("собор парижской богоматери", "виктор", "роман", "89"), "D8");
    }

    @Test
    public void search() throws Exception {
        Library library = new Library();
        library.add(new Book("1984", "оруэлл", "роман", "Y0"));
        library.add(new Book("451 градус по фаренгейту", "брэдбери", "антиутопия", "F2"));
        library.add(new Book("записки юного врача", "булгаков", "цикл рассказов", "G1"));
        Book oneBook = library.search(null, "брэдбери", null, "F2");
        assertTrue(oneBook.equals(new Book("451 градус по фаренгейту", "брэдбери", "антиутопия", "F2")));
    }

    @Test(expected = Exception.class)
    public void ExSearch() throws Exception {
        Library library = new Library();
        library.add(new Book("1984", "оруэлл", "роман", "Y0"));
        library.add(new Book("451 градус по фаренгейту", "брэдбери", "антиутопия", "F2"));
        library.add(new Book("записки юного врача", "булгаков", "цикл рассказов", "G1"));
        Book oneBook = library.search(null, "брэдбери", null, "F1");
        Book seconBook = library.search("1984", null, "антиутопия", null);
    }
}
