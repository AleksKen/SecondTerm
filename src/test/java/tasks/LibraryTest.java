package tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void add() throws Exception {
        Library library = new Library();
        library.add("гордость и предубеждение", "джейн остин", "роман", "A2");
        assertEquals("гордость и предубеждениеджейн остинроманA2",
                library.get(0).name+library.get(0).author+library.get(0).genre+library.get(0).code);
    }

    @Test
    public void remove() throws Exception {
        Library library = new Library();
        library.add("гордость и предубеждение", "джейн остин", "роман", "A2");
        library.add("мы", "замятин", "антиутопия", "Б3");
        library.remove("гордость и предубеждение", "джейн остин", "роман", "A2");
        assertEquals("мызамятинантиутопияБ3",
                library.get(0).name+library.get(0).author+library.get(0).genre+library.get(0).code);
    }

    @Test
    public void changes() throws Exception {
        Library library = new Library();
        library.add("время жить и время умирать", "эрих мария", "роман", "T7");
        library.changes(new Book("время жить и время умирать", "эрих мария", "роман", "T7"),
                "", "ремарк", "антивоенный роман");
        assertEquals("время жить и время умиратьремаркантивоенный романT7",
                library.get(0).name+library.get(0).author+library.get(0).genre+library.get(0).code);
    }

    @Test
    public void shift() throws Exception {
        Library library = new Library();
        library.add("собор парижской богоматери", "гюго", "роман", "89");
        library.shift(new Book("собор парижской богоматери", "гюго", "роман", "89"), "D8");
        assertEquals("D8", library.get(0).code);
    }

    @Test
    public void search() throws Exception {
        Library library = new Library();
        library.add("1984", "оруэлл", "роман", "Y0");
        library.add("451 градус по фаренгейту", "брэдбери", "антиутопия", "F2");
        library.add("записки юного врача", "булгаков","цикл рассказов","G1");
        Book oneBook = library.search("", "брэдбери", "", "F2");
        assertEquals("451 градус по фаренгейтубрэдбериантиутопияF2",
                oneBook.name+oneBook.author+oneBook.genre+oneBook.code);
    }
}

