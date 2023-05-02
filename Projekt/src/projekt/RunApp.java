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
	            }	
				break;
	        case 2:
	        	System.out.println("Zadajte druh filmu(h - hraný film, a - animovaný film)");
	        	String check2 = sc.next();
	   	            	
	            if(check2.equals("h")){
	            	
	        	System.out.println("Zadajte názov filmu, ktorý chcete upravit:");
	        	String nazov = sc.next();

	        	SelectQueries sq = new SelectQueries();

	        	if (sq.testIfFilmExists(nazov)) {
	        	    System.out.println("Vyberte atribut, který chcete upravit:");
	        	    System.out.println("1 - názov");
	        	    System.out.println("2 - režisér");
	        	    System.out.println("3 - rok vydania");
	        	    System.out.println("4 - herci");
	        	    int volba = ConsoleInput.readNumberInputFromConsole(sc);

	        	    UpdateQueries uq = new UpdateQueries();

	        	    switch (volba) {
	        	        case 1:
	        	            System.out.println("Zadajte nový názov:");
	        	            String novyNazov = sc.next();
	        	            uq.upadateFilmNazov(nazov, novyNazov);
	        	            System.out.println("Názov pre film " + nazov + " bol úspešne zmenený");
	        	            break;
	        	        case 2:
	        	            System.out.println("Zadajte nového režiséra:");
	        	            String novyReziser = sc.next();
	        	            uq.upadateFilmReziser(nazov, novyReziser);
	        	            System.out.println("Režisér pre film " + nazov + " bol úspešne zmenený");
	        	            break;
	        	        case 3:
	        	            System.out.println("Zadajte nový rok vydania:");
	        	            int novyRok = ConsoleInput.readNumberInputFromConsole(sc);
	        	            uq.upadateFilmRokVydania(nazov, novyRok);
	        	            System.out.println("Rok pre film " + nazov + " bol úspešne zmenený");
	        	            break;
	        	        case 4:
	        	            System.out.println("Zadajte nový zoznam hercov (oddeleny ciarkami):");
	        	            String novySeznam = sc.next();
	        	            uq.upadateFilmHerci(nazov, novySeznam);
	        	            System.out.println("Herci pre film " + nazov + " boli úspešne zmenení");
	        	            break;
	        	        default:
	        	            System.err.println("Neplatná volba.");
	        	            break;
	        	    }

	        	    System.out.println("Film " + nazov + " bol úspešne upravený.");
	        	} else {
	        	    System.err.println("Film " + nazov + " neexistuje.");
	        	}
	            }
	        	
	            if(check2.equals("a")){
	            	System.out.println("Zadajte názov animaku, ktorý chcete upravit:");
		        	String nazov = sc.next();

		        	SelectQueries sq = new SelectQueries();

		        	if (sq.testIfAnimeExists(nazov)) {
		        	    System.out.println("Vyberte atribut, ktorý chcete upravit:");
		        	    System.out.println("1 - názov");
		        	    System.out.println("2 - režisér");
		        	    System.out.println("3 - rok vydání");
		        	    System.out.println("4 - animátoři");
		        	    System.out.println("5 - doporučený vek");
		        	    int volba = ConsoleInput.readNumberInputFromConsole(sc);

		        	    UpdateQueries uq = new UpdateQueries();

		        	    switch (volba) {
		        	        case 1:
		        	            System.out.println("Zadejte nový názov:");
		        	            String novyNazov = sc.next();
		        	            uq.upadateAnimeNazov(nazov, novyNazov);
		        	            System.out.println("Názov pre film " + nazov + " bol úspešne zmenený");
		        	            break;
		        	        case 2:
		        	            System.out.println("Zadajte nového režiséra:");
		        	            String novyReziser = sc.next();
		        	            uq.upadateAnimeReziser(nazov, novyReziser);
		        	            System.out.println("Režisér pre film " + nazov + " bol úspešne zmenený");
		        	            break;
		        	        case 3:
		        	            System.out.println("Zadejte nový rok vydania:");
		        	            int novyRok = ConsoleInput.readNumberInputFromConsole(sc);
		        	            uq.upadateAnimeRokVydania(nazov, novyRok);
		        	            System.out.println("Rok pre film " + nazov + " bol úspešne zmenený");
		        	            break;
		        	        case 4:
		        	            System.out.println("Zadajte nový zoznam animatorov (oddelený čiarkami):");
		        	            String novySeznam = sc.next();
		        	            uq.upadateAnimeAnimatori(nazov, novySeznam);
		        	            System.out.println("Animatori pre film " + nazov + " bol úspešne zmenený");
		        	            break;
		        	        case 5:
		        	            System.out.println("Zadajte nový zoznam animatorov (oddelený čiarkami):");
		        	            String novyvek = sc.next();
		        	            uq.upadateAnimeVek(nazov, novyvek);
		        	            System.out.println("Animatori pre film " + nazov + " bol úspešne zmenený");
		        	            break;
		        	        default:
		        	            System.err.println("Neplatná volba.");
		        	            break;
		        	    }

		        	    System.out.println("Film " + nazov + " bol úspesne upravený.");
		        	} else {
		        	    System.err.println("Film " + nazov + " neexistuje.");
		        	}
	            	
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
	            } 
				break;
	        case  4:
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");
	        	String check4 = sc.next();
	            
	            if(check4.equals("h")){
	            System.out.println("Zadejte názov filmu ktorý chcete ohodnotiť");
	            String nazov1 = sc.next();
	            SelectQueries sq1 = new SelectQueries();
					if (sq1.testIfFilmExists(nazov1)){
						System.out.println("Zadajte vaše hodnotenie filmu (1-10)");
						int rating = ConsoleInput.readNumberInputFromConsole(sc);
						UpdateQueries uq1 = new UpdateQueries();
						uq1.updateFilmRating (nazov1, rating);

	                System.out.println("Hodnotenie pre film " + nazov1 + " bolo úspešne pridané");
	            } 
	       }	
	            
				if(check4.equals("a")){
		            System.out.println("Zadejte názov animáku ktorý chcete ohodnotiť");
		            String nazov = sc.next();
		            SelectQueries sq = new SelectQueries();
					if (sq.testIfAnimeExists(nazov)){
		            	System.out.println("Zadajte vaše hodnotenie filmu vo forme * (1-5 hviezdičiek)");
		            	String hodnotenie = sc.next();
		                UpdateQueries uq = new UpdateQueries();
		                uq.updateAnimeRating (nazov, hodnotenie);

		                System.out.println("Hodnotenie pre film " + nazov + " bolo úspešne pridané");
		            } 
					
				
	            } 
					
	           
	            break;
	        case 5:
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");
	        	String check5 = sc.next();
	        	
	        	if(check5.equals("h")){
	        		SelectQueries se = new SelectQueries(); 
	        		se.getAllFilms();
	        	}
	        	if(check5.equals("a")){
	        		SelectQueries sa = new SelectQueries(); 
		            sa.getAllAnimes();
	        	}
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
		        	System.out.println("Zadejte nazov animaku");
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
	        	System.out.println("Zadejte druh filmu(h - hraný film, a - animovaný film)");	
	        	String check10 = sc.next();
	            
	            if(check10.equals("h")){
	            SelectQueries db4 = new SelectQueries();
	        	System.out.println("Zadejte nazov textového súboru");
	            String fileName = sc.next();
	        	db4.nacitatFilm(fileName);
	            }
	            
	            if(check10.equals("a")){
		            SelectQueries db5 = new SelectQueries();
		        	System.out.println("Zadejte nazov textového súboru");
		            String fileName1 = sc.next();
		        	db5.nacitatAnimak(fileName1);
		            }
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
