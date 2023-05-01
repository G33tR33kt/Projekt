package projekt;
import java.util.Scanner;


public class RunApp {
	    public static void main(String[] args) {
	
	    Scanner sc = new Scanner(System.in);
	    
	    int choice = 0;
	    boolean run = true;
	    int iteration = 0;

	    while (run) {
	      if (iteration == 0)
	        iteration++;
	      else
	      System.out.println(System.lineSeparator());
	      System.out.println("Vyberte požadovanú činnosť:");
	      System.out.println("1 .. vloženie nového filmu");
	      System.out.println("2 .. úprava filmu");
	      System.out.println("3 .. odstránenie filmu");
	      System.out.println("4 .. pridať hodnotenie");
	      System.out.println("5 .. výpis filmov");
	      System.out.println("6 .. vyhľadanie filmu");
	      System.out.println("7 .. výpis hercov/animátorov");
	      System.out.println("8 .. výpis filmu podľa tvorcu");
	      System.out.println("9 .. uloženie informácii o filme");
	      System.out.println("10 .. načítanie informácii o filme");
	      System.out.println("11 .. ukončenie");
	      choice = ConsoleInput.readNumberInputFromConsole(sc);
	      switch (choice) {
	        case 1:
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");
	        	String check = sc.next();
	   	            	
	            if(check.equals("h")){
	            System.out.println("Zadejte názov filmu");
	            String nazov = sc.next();
	            SelectQueries testFilmExistence = new SelectQueries();
	            if (testFilmExistence.testIfFilmExists(nazov)) {
	              String filmNameToCreate = "";
	              do {
	                System.out.println(
	                    "Film s daným názvom existuje prosím zadajte názov znovu: ");
	                filmNameToCreate = sc.next();
	              } while (testFilmExistence.testIfFilmExists(filmNameToCreate));
	            }

	            System.out.println("Zadejte meno režiséra");
	            String reziser = sc.next();
	            System.out.println("Zadejte rok vydania");
	            Integer rok = sc.nextInt();
	            System.out.println("Zadejte herca/ov");
	            String herci = sc.next();
	            
	            InsertQueries i2 = new InsertQueries();
	            i2.insertNewFilm(nazov, reziser, rok, herci);
	            }	if(check.equals("a")) {
		            System.out.println("Zadejte názov animáku");
		            String nazov = sc.next();
		            SelectQueries testAnimeExistence = new SelectQueries();
		            if (testAnimeExistence.testIfAnimeExists(nazov)) {
		              String animeNameToCreate = "";
		              do {
		                System.out.println(
		                    "Animík s daným názvom existuje prosím zadajte názov znovu: ");
		                animeNameToCreate = sc.next();
		              } while (testAnimeExistence.testIfAnimeExists(animeNameToCreate));
		            }

		            System.out.println("Zadejte meno režiséra");
		            String reziser = sc.next();
		            System.out.println("Zadejte rok vydania");
		            Integer rok = sc.nextInt();
		            System.out.println("Zadejte animatora/ov");
		            String animatori = sc.next();
		            System.out.println("Zadejte doporučený vek");
		            Integer vek = sc.nextInt();
		        
	            	InsertQueries i3 = new InsertQueries();
		            i3.insertNewAnime(nazov, reziser, rok, animatori, vek);
	            }	else {
	            	System.err.println("Nesprávne zadaný druh filmu");
	            }
				break;
	        case 2:
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");
	        	String check2 = sc.next();
	            
	            if(check2.equals("h")){
	            System.out.println("Zadejte názov filmu ktorý chcete upraviť");
	            String nazov = sc.next();
	            SelectQueries sq = new SelectQueries();
					if (sq.testIfFilmExists(nazov)){
						System.out.println("Zadajte upravený názov:");
						String nazov1 = sc.next();
						System.out.println("Zadajte upravené meno režiséra:");
						String reziser = sc.next();
						System.out.println("Zadajte upravený rok vydania:");
						int rok = sc.nextInt();
						System.out.println("Zadajte upravené meno herca:");
						String herci = sc.next();
						System.out.println("Zadajte upravené hodnotenie(1-10) filmu:");
						int rating = sc.nextInt();
						UpdateQueries uq = new UpdateQueries();
						uq.upadateFilm (nazov1, reziser, rok, herci, rating);

	                System.out.println("Film " + nazov + " bol úspešne upravený");
	            } 
	            }	
					else {
	            	
	            	System.err.println("Nesprávne zadaný názov filmu");
	            }
	        	
	        	
	        	
	        	
	        	
	        	
	          break;
	        case 3:
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");	
	        	String check3 = sc.next();
	            
	            if(check3.equals("h")){
	        	System.out.println("Zadajte názov filmu");
	        	String Name = sc.next();
	            SelectQueries sf = new SelectQueries();
	            if (sf.testIfFilmExists(Name)) {
	            	DeleteQueries d = new DeleteQueries();

	                  d.deleteFilmByName(Name);
	                } else {
	                  System.out.println("Film s daným názvom neexistuje, skúste zadať názov správne.");
	                }
	            }	if(check3.equals("a")) {
	            	System.out.println("Zadajte názov animaku");
		        	String Name = sc.next();
		            SelectQueries sa = new SelectQueries();
		            if (sa.testIfAnimeExists(Name)){
		            	DeleteQueries d = new DeleteQueries();

		                  d.deleteAnimeByName(Name);
		                } else {
		                  System.out.println("Animák s daným názvom neexistuje, skúste zadať názov správne.");
		                }
	            } else {
	            	System.err.println("Nesprávne zadaný druh filmu");
	            }
				break;
	        case  4:
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");
	        	String check4 = sc.next();
	            
	            if(check4.equals("h")){
	            System.out.println("Zadejte názov filmu ktorý chcete ohodnotiť");
	            String nazov = sc.next();
	            SelectQueries sq = new SelectQueries();
					if (sq.testIfFilmExists(nazov)){
						System.out.println("Zadajte vaše hodnotenie filmu (1-10)");
						int rating = ConsoleInput.readNumberInputFromConsole(sc);
						UpdateQueries uq = new UpdateQueries();
						uq.updateFilmRating (nazov, rating);

	                System.out.println("Hodnotenie pre film " + nazov + " bolo úspešne pridané");
	            } 
	            }	
					else {
	            	
	            	System.err.println("Nesprávne zadaný názov filmu");
	            }
	            
				if(check4.equals("a")){
		            System.out.println("Zadejte názov animáku ktorý chcete ohodnotiť");
		            String nazov = sc.next();
		            SelectQueries sqq = new SelectQueries();
					if (sqq.testIfFilmExists(nazov)){
		            	System.out.println("Zadajte vaše hodnotenie filmu vo forme * (1-5 hviezdičiek)");
		            	String hodnotenie = sc.next();
		                UpdateQueries uqq = new UpdateQueries();
		                uqq.updateAnimeRating (nazov, hodnotenie);

		                System.out.println("Hodnotenie pre film " + nazov + " bolo úspešne pridané");
		            } 
					
				
	            } 
					else {
	            	System.err.println("Nesprávne zadaný názov animáku");
	            }
	           
	            break;
	        case 5:
	        	SelectQueries se = new SelectQueries(); 
	            se.getAllFilms();
	            SelectQueries sa = new SelectQueries(); 
	            sa.getAllAnimes();
	          break;
	        case 6:
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");
	        	String check6 = sc.next();
	  
	            
	            if(check6.equals("h")){	
	        	SelectQueries db = new SelectQueries(); 
	        	System.out.println("Zadejte nazov filmu");
	            String film = sc.next();
	            if(db.testIfFilmExists(film)) {
	        	db.najdiFilm(film);
	            }else {
	            	System.out.println("Film s daným názvom neexistuje, skúste zadať názov správne.");
	            }
	            }	
	            
	            if(check6.equals("a")) {
	            	
	            	SelectQueries db = new SelectQueries(); 
		        	System.out.println("Zadejte nazov animaku");
		            String animak = sc.next();
		            if(db.testIfAnimeExists(animak)) {
		        	db.najdiAnimak(animak);
		            }else {
		            	System.out.println("Animak s daným názvom neexistuje, skúste zadať názov správne.");
		            }
	            } else {
	            	System.err.println("Nesprávne zadaný druh filmu");
	            }
	          break;
	        case 7:
	        	System.out.println("Zadejte či sa jedná o herca alebo animátora(h - herec, a - animátor)");
	        	String check7 = sc.next();
	            if(check7.equals("h")){
		        	SelectQueries.vypisHercovVDvochFilmoch();
	            } else {
	            	SelectQueries.vypisAnimatorovVDvochFilmoch();
	            }
	          break;
	        case 8:
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");	
	        	String check8 = sc.next();
	            
	            if(check8.equals("h")){
	        	SelectQueries db2 = new SelectQueries();  
	        	System.out.println("Zadejte priezvisko herca");
	            String herci = sc.next();
	            SelectQueries testActorsExistence = new SelectQueries();
	            if (testActorsExistence.testIfActorExists(herci)) {
	        	db2.najdiFilmyHercovi(herci);
	            }
	            else {
	            	System.out.println("Tento herec neexistuje!");
	            }
	            }
	            if(check8.equals("a")) {
	            	SelectQueries db3 = new SelectQueries(); 
		        	System.out.println("Zadejte priezvisko animatora");
		            String animatori = sc.next();
		            SelectQueries testAnimatorsExistence = new SelectQueries();
		            if (testAnimatorsExistence.testIfAnimatorExists(animatori)) {
		            	db3.najdiFilmyAnimatorovi(animatori);
		            }
		            else {
		            	System.out.println("Tento animátor neexistuje");
	            }
	            }else {
	            	System.err.println("Nesprávne zadaný druh filmu");
	            }
	            	
	          break;
	        case 9:
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");	
	        	String check9 = sc.next();
	            
	            if(check9.equals("h")){
	        	SelectQueries db3 = new SelectQueries(); 
	        	System.out.println("Zadejte nazov filmu");
	            String filmfile = sc.next();
	            if(db3.testIfFilmExists(filmfile)) {
	        	db3.ulozFilm(filmfile);
	            }else {
	            	System.out.println("Film s daným názvom neexistuje, skúste zadať názov správne.");
	            }
	            }	if(check9.equals("a")) {
	            	SelectQueries db3 = new SelectQueries(); 
		        	System.out.println("Zadejte nazov animaku");;;
		            String animefile = sc.next();
		            if(db3.testIfAnimeExists(animefile)) {
		        	db3.ulozAnime(animefile);
		            }else {
		            	System.out.println("Film s daným názvom neexistuje, skúste zadať názov správne.");
		            }
	            } else {
	            	System.err.println("Nesprávne zadaný druh filmu");
	            }
		      break;
	        case 10:
		      break;
	        case 11:
	        	 run = false;
	             DBConnection.closeConnection();
	             break;
	        default:
	        	 run = false;
	        	 DBConnection.closeConnection();
	        	 break;
	      }
	    }
	    }
	}
