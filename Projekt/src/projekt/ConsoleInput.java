package projekt;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConsoleInput {
	public static int readNumberInputFromConsole(Scanner sc) {
	    int cislo = 0;
	    try {
	      cislo = sc.nextInt();
	    } catch (Exception e) {
	      System.out.println("Nastala vyjimka typu " + e.toString());
	      System.out.println("zadajte prosim cele cislo ");
	      sc.nextLine();
	      cislo = readNumberInputFromConsole(sc);
	    }
	    return cislo;
	  }
	
	
}
