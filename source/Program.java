import libmngr.*;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.EnumSet;

public class Program {
  public static void main(String[] args) throws FileNotFoundException {
    // NOTE: It is important that the entry point is in a class called "Program".
    //       Either copy your code here or modify the last statement in the "scripts/run.bat"
    //       file to match the class where the entry point lies.
    Logger.initialize(new PrintStream[] { System.out, new PrintStream(new FileOutputStream("C:\\Users\\MJJ\\Downloads\\libmngr-logs.txt"), true)});
    LibraryManager mngr = new LibraryManager();
    
    Book mathBook = new Book(
      "Calculus",
      new Author("Unknown Author"),
      new Date(2000, 11, 10),
      EnumSet.of(Book.Genre.NON_FICTION)
    );

    mngr.addBook(mathBook);

    // EXAMPLE CHANGE
  }
}
