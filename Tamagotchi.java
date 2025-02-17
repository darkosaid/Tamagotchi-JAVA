package tamagotchi_v2;

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;





public class Tamagotchi {
	
	private String name; //Name des Tamagotchi
	private int fullStomach; //Definiert wie satt das Tamagotchi ist
	private int feeling; //Definiert wie glücklich das Tamagotchi ist
	private int playedRounds; //Definiert wie viele runden gespielt wurden
	private int dirtiness; //Definiert wie Sauber/schmutzig das Tamagotchi ist
	private int poop;
    static String rot = "\u001B[31m";
    static String grün = "\u001B[32m";
    static String gelb = "\u001B[33m";
    static String cyan = "\u001B[36m";
    static String reset = "\u001B[0m"; 

		

	
	public Tamagotchi(String name) { //Konstrukter mit Übergabeparameter 
		this.name = name;
		this.fullStomach = 50; //Satt-Wert am anfang des spiels
		this.feeling = 50; //Gefühls-Wert am anfang des spiels
		this.playedRounds = 0; //Runden-Wert am anfang des spiels
		this.dirtiness = 50; //Sauber/Schmutzig-Wert am anfang des spiels
		this.poop = 50;
		
		
	}
		
	public void resetGame() { //Methode zum zurücksetzen der runden auf 1 
		this.playedRounds = 0; //Setzt den Wert wieder auf 0
		this.feeling = 50; //Setzt den Wert wieder auf 50 #
		this.fullStomach = 50; // #
		this.dirtiness = 50; // #
		System.out.println(gelb + playedRounds + feeling + fullStomach + dirtiness + reset);
		
	}
	
	public void showerTamagotchi() { //Methode zum Duschen des Tamagotchi
		checkHealthStatus(); //ruft checkHealthStatus methode auf
		this.dirtiness += 5; // Addiert 5 auf den davor definierten Wert
		playedRounds ++; // Addiert eine runde auf den davor definierten wert 
		System.out.println(cyan + this.name + reset + grün +  " hat jetzt geduscht" + reset); // Gibt einen Text aus 
		if (this.dirtiness > 100 ) { //überprüft ob der Wert über 100 ist
			checkHealthStatus(); //falls wert über 100 ist soll methode ausgeführt werden #
		} if  (this.dirtiness < 0) { //überprüft ob wert unter 0 ist 
			checkHealthStatus(); // # unter
		}
		
		checkHealthStatus();
	}
	
	public void toiletTamagotchi() {
	   checkHealthStatus();
	   this.poop -= 4;
	   checkHealthStatus();
	   playedRounds ++;
	   System.out.println(cyan + this.name + reset + grün + " ist auf die Toilette gegangen" + reset);
	   checkHealthStatus();
	
	}
		
	
	
	
	public void giveFood() { //Methode um Tamagotchi essen zu geben 
		checkHealthStatus(); //führt methode checkHealthStatus aus #
			this.fullStomach += 8;//Addiert 8 und sepichert den Wert danach
			checkHealthStatus(); // #
			System.out.println(cyan + this.name + reset + grün + " wurde gefüttert" + reset);
			if (this.fullStomach > 100) { //Überprüft ob fullStomach größer als 100 ist
				checkHealthStatus(); // #
		}
			playedRounds ++; //addiert eine runde auf den davor definierten wert 
			System.out.println(grün + "Runde " + playedRounds + " gespielt" + reset); //gibt einen text aus
			checkHealthStatus();// #
			
		
	}
	
	public void playWithTamagotchi() { //methode um mit tamagotchi zu spielen 
		checkHealthStatus(); //führt methode checkHealthStatus aus // #
		this.feeling += 3; //fügt feeling +3 hinzu und speichert den wert
		System.out.println(cyan + this.name + reset + grün + " hat gespielt" + reset); //gibt einen text aus
		if (this.feeling > 100) { //überprüft ob feeling größer als 100 ist
			checkHealthStatus(); // #
		} else if  (this.feeling < 0) //überprüft ob feeling kleiner als 100
			checkHealthStatus(); // # 
		
		playedRounds ++; // fügt playedRounds eine runde hinzu
		System.out.println(grün + "Runde " + playedRounds + " gespielt" + reset);
		checkHealthStatus(); // # 
		}
	

	public void checkHealthStatus() { //methode um stats vom tamagotchi zu überprüfen und jenachdem zu agieren 
		if (this.fullStomach > 100) { 
			handleOvereating();
		} else if  (this.fullStomach < 1) {
			handleStarvation();
		}
		if (this.feeling > 100) {
			handleExhausting();
		} else if (this.feeling < 0) {
			handleLoneliness();
		}
		if (this.dirtiness > 100) {
			handleShowerCleanDeath();
		} else if (this.dirtiness < 0) {
			handleShowerDirtyDeath();
			
		}
		if (this.feeling <= 25) {
			System.out.println(cyan + this.name + reset + gelb + " wird traurig, denk daran mit" + reset + cyan + this.name + gelb + " zu spielen, sonst stirbt es >:( " + reset);
		} else if (this.feeling >= 75) {
			System.out.println(gelb + "Willst du das " + reset + cyan + this.name + reset + gelb + "dir abkratzt?" + cyan + this.name + reset + gelb + "Stirbt bald an einem Lungenkolapps :(" + reset);
		}
		if (this.poop > 100) {
			handleDeathCauseFullPoop();
		} else if (this.poop < 0) {
			handleDeathCauseNoPoop();
		}
	}
		
	public void handleDeathCauseFullPoop() {
		System.out.println(cyan + this.name + reset + rot + " ist geplatzt weil du es nicht auf Toiette gehen lassen hast"); 
		System.out.println("Das Spiel wird zurückgesetzt" + reset);
		resetGame();
	}
	
	public void handleDeathCauseNoPoop() {
		System.out.println(cyan + this.name + reset + rot + " ist gestorben weil du es gezwungen hast zu oft auf Toilette zu gehen");
		System.out.println("Das Spiel wird zurückgesetzt" + reset);
		resetGame();
		
	}
		
	
	public void handleShowerCleanDeath() {
		System.out.println(rot + "Du hast " + reset + cyan + this.name + rot + " so sauber gemacht das es seine/ihre Haut verätzt wurde :C" + reset);
		System.out.println(rot + "Das Spiel wird jetzt zurückgesetzt" + reset);
		resetGame();
	}
	
	
	public void handleShowerDirtyDeath() { 
		System.out.println(rot + "Du hättest " + reset + cyan + this.name + reset + rot + " öfter sauber machen sollen, der arme ist an seinem eigenen Geruch erstickt:C" + reset);
		System.out.println(rot + "Das Spiel wird jetzt zurückgesetzt" + reset);
		resetGame();
	}
	
	
	public void handleOvereating() { 
		System.out.println(rot + "Du hast " + reset + cyan + this.name + reset + rot +" zu viel Essen gegeben! Leider ist es geplatzt :C" + reset);
		System.out.println(rot + "Das Spiel wird jetzt zurückgesetzt!" + reset);
		resetGame();
	}
	
	public void handleStarvation() { 
		System.out.println(rot + "Du hast " + reset + cyan + this.name + reset + rot + " verhungern lassen, jetzt ist es tot" + reset);
		System.out.println(rot + "Das Spiel wird jetzt zurückgesetzt" + reset);
		resetGame();
	}
	
	public void handleExhausting() {
		System.out.println(rot + "Du hast zu viel mit " + reset + cyan + this.name + reset + rot + " gespielt, es ist an Herzversagen gestorben :C" + reset);
		System.out.println(rot + "Das Spiel wird jetzt zurückgesetzt" + reset);
		resetGame();
		
	}
	
	public void handleLoneliness() {
		System.out.println(rot + "Du hast nichts mit " + reset + cyan + this.name + reset + rot +" unternommen, es ist an Einsamkeit gestorben" + reset);
		System.out.println(rot +"Das Spiel wird jetzt zurückgesetzt" + reset);
		resetGame();
		
	}
	

	
	 public void getStatus() {
	        System.out.println("Name: " + name + "\n" + "Magenfüllung: " + fullStomach + "\nGlücklich: " + feeling + "\n" + "Gespielte Runden: " + playedRounds + "\nSauberkeit: " + dirtiness + "\nToilette: " + poop);
	    }
	 
	 
	public void reducingStats() { //methode um stats zu reduzieren
	
		
		if (playedRounds % 3 == 0) { //überprüft ob rundenanzahl teilbar durch 3 ist, wenn wahr werden werte reduziert
			fullStomach -= 10;
			feeling -= 7;
			dirtiness -= 5;
			poop -= 5;
			
			System.out.println("Nach Runde " + playedRounds + " wurde der Magen um 10 reduziert");
			System.out.println("Nach Runde " + playedRounds + " wurde das Glück um 7 reduziert");
			System.out.println("Nach Runde " + playedRounds + " wurde Sauberkeit um 5 reduziert");
			System.out.println("Nach Runde " + playedRounds + " wurde Toilettenwert um 5 reduziert");
			
		} else  {  
			
			
		}
		
		}
	
	public void clearConsole() { //Methode zum "leeren" der Konsole
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
				
		}
	
	public static void main(String[] args) { //ausführbarer code
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Das sind die Spielregeln: Du kannst deinen Tamagotchi Essen geben oder mit ihm Spielen.Sowie auch den Status anzeigen");
	    System.out.println("Wählst du eine von den ersten beiden wird den Werten `+8´ hinzugefügt und die nächste Runde wird gestartet");
	    System.out.println("Wählst du die 3 Methode werden dir die Status Werte deines Tamagotchis angezeigt. Dabei wird keine neue Runde gestartet");
	    System.out.println("Mit Methode 4 kannst du das Spiel beenden");
	    System.out.println("Nach allen 4 gespielten Runden werden die Status Werte um `-16´ reduziert");
	    System.out.println("Fallen die Status Werte unter 0, wird das Spiel zurückgesetzt");
	    System.out.println("------------");
	    System.out.println("Spiel kann jetzt gespielt werden");
	    System.out.println("------------");
	    System.out.println("Gib deinem Tamagotchi einen Namen:");
	    String name = scanner.nextLine();

	    Tamagotchi myTamagotchi = new Tamagotchi(name);

	   
	    while (true) {
	        System.out.println(gelb + "\nWas möchtest du tun?");
	        System.out.println("1. " + reset + cyan +  name + reset + gelb + " füttern");
	        System.out.println("2. Mit " + reset + cyan + name + reset + gelb + " spielen");
	        System.out.println("3. Mit " + reset + cyan + name + reset + gelb + " auf die Toilette gehen");
	        System.out.println("4. " + reset + cyan + name + reset + gelb + " duschen");
	        System.out.println("5. Status anzeigen");
	        System.out.println("6. Konsole Leeren");
	        System.out.println("7. Spiel beenden" + reset);//Beenden
	        int choice = scanner.nextInt();
	        scanner.nextLine();  // Verhindert Probleme mit Eingaben, die nach nextInt() kommen.

	        switch (choice) {
	            case 1:
	                myTamagotchi.giveFood();
	                myTamagotchi.reducingStats();// Tamagotchi füttern
	                break;
	            case 2:
	                myTamagotchi.playWithTamagotchi();
	                myTamagotchi.reducingStats();// Mit Tamagotchi spielen
	                break;
	            case 3:
	                myTamagotchi.toiletTamagotchi();// Status anzeigen
	                myTamagotchi.reducingStats();
	                break;
	            case 4:
	            	myTamagotchi.showerTamagotchi();
	            	myTamagotchi.reducingStats();
	            	break;
	            case 5:
	            	myTamagotchi.getStatus();
	            	break;
	            case 6: 
	            	myTamagotchi.clearConsole();
	            	break;
	            case 7:
	            	System.out.println(rot + "Spiel beendet." + reset);
	            	return;
	            default:
	                System.out.println(rot + "Ungültige Wahl. Versuche es erneut." + reset);
	                break;
	        }     
	}
}
}
	
	

	
	
	
	
	
	
	
	

