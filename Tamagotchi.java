package tamagotchi;


import java.util.Scanner;




public class Tamagotchi {
	
	private String name; //Name des Tamagotchi
	private int fullStomach; //Definiert wie satt das Tamagotchi ist
	private int feeling; //Definiert wie glücklich das Tamagotchi ist
	private boolean isAlive; //Definiert ob das Tamagotchi lebt
	private int playedRounds; //Definiert wie viele runden gespielt wurden
	private int dirtiness; //Definiert wie Sauber/schmutzig das Tamagotchi ist
	

		

	
	public Tamagotchi(String name) { //Konstrukter mit Übergabeparameter 
		this.name = name;
		this.fullStomach = 50; //Satt-Wert am anfang des spiels
		this.feeling = 50; //Gefühls-Wert am anfang des spiels
		this.isAlive = true; //Lebt-Wert am anfang des spiels
		this.playedRounds = 0; //Runden-Wert am anfang des spiels
		this.dirtiness = 50; //Sauber/Schmutzig-Wert am anfang des spiels
		
		
	}
		
	public void resetGame() { //Methode zum zurücksetzen 
		this.playedRounds = 0; //Setzt den Wert wieder auf 0
		this.feeling = 50; //Setzt den Wert wieder auf 50 #
		this.fullStomach = 50; // #
		this.dirtiness = 50; // #
		System.out.println(playedRounds + feeling + fullStomach + dirtiness);
		
	}
	
	public void showerTamagotchi() { //Methode zum Duschen des Tamagotchi
		checkHealthStatus(); //ruft checkHealthStatus methode auf
		this.dirtiness += 5; // Addiert 5 auf den davor definierten Wert
		playedRounds ++; // Addiert eine runde auf den davor definierten wert 
		System.out.println(name + " hat jetzt geduscht"); // Gibt einen Text aus 
		if (this.dirtiness > 100 ) { //überprüft ob der Wert über 100 ist
			checkHealthStatus(); //falls wert über 100 ist soll methode ausgeführt werden #
		} if  (this.dirtiness < 0) { //überprüft ob wert unter 0 ist 
			checkHealthStatus(); // # unter
		}
		
		checkHealthStatus();
	}
	
		
	
	
	
	public void giveFood() { //Methode um Tamagotchi essen zu geben 
		checkHealthStatus(); //führt methode checkHealthStatus aus #
			this.fullStomach += 8;//Addiert 8 und sepichert den Wert danach
			checkHealthStatus(); // #
			System.out.println( this.name + " wurde gefüttert");
			if (this.fullStomach > 100) { //Überprüft ob fullStomach größer als 100 ist
				checkHealthStatus(); // #
		}
			playedRounds ++; //addiert eine runde auf den davor definierten wert 
			System.out.println("Runde " + playedRounds + " gespielt"); //gibt einen text aus
			checkHealthStatus();// #
			
		
	}
	
	public void playWithTamagotchi() { //methode um mit tamagotchi zu spielen 
		checkHealthStatus(); //führt methode checkHealthStatus aus // #
		this.feeling += 3; //fügt feeling +3 hinzu und speichert den wert
		System.out.println(this.name + " hat gespielt"); //gibt einen text aus
		if (this.feeling > 100) { //überprüft ob feeling größer als 100 ist
			checkHealthStatus(); // #
		} else if  (this.feeling < 0) //überprüft ob feeling kleiner als 100
			checkHealthStatus(); // # 
		
		playedRounds ++; // fügt playedRounds eine runde hinzu
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
			System.out.println(name + " wird traurig, denk daran mit Ihm/Sie zu spielen, sonst stirbt es >:( ");
		} else if (this.feeling >= 75) {
			System.out.println("Willst du das " + name + "dir abkratzt?" + name + "Stirbt bald an einem Lungenkolapps :(");
		}
		
	}
	
	public void handleShowerCleanDeath() {
		System.out.println("Du hast " + this.name + " so sauber gemacht das es seine/ihre Haut verätzt wurde :C");
		System.out.println("Das Spiel wird jetzt zurückgesetzt");
		resetGame();
	}
	
	
	public void handleShowerDirtyDeath() { 
		System.out.println("Du hättest " + this.name + " öfter sauber machen sollen, der arme ist an seinem eigenen Geruch erstickt:C");
		System.out.println("Das Spiel wird jetzt zurückgesetzt");
		resetGame();
	}
	
	
	public void handleOvereating() { 
		System.out.println("Du hast deinen Tamagotchi zu viel Essen gegeben! Leider ist es geplatzt :C");
		System.out.println("Das Spiel wird jetzt zurückgesetzt!");
		resetGame();
	}
	
	public void handleStarvation() { 
		System.out.println("Du hast deinen Tamagotchi verhungern lassen, jetzt ist es tot");
		System.out.println("Das Spiel wird jetzt zurückgesetzt");
		resetGame();
	}
	
	public void handleExhausting() {
		System.out.println("Du hast zu viel mit deinem Tamagotchi gespielt, es ist an Herzversagen gestorben :C");
		System.out.println("Das Spiel wird jetzt zurückgesetzt");
		resetGame();
		
	}
	
	public void handleLoneliness() {
		System.out.println("Du hast nichts mit deinem Tamagotchi unternommen, es ist an Einsamkeit gestorben");
		System.out.println("Das Spiel wird jetzt zurückgesetzt");
		resetGame();
		
	}
	

	
	 public void getStatus() {
	        System.out.println("Name: " + name + "\n" + "Magenfüllung: " + fullStomach + "\nGlücklich: " + feeling + "\n" + "Gespielte Runden: " + playedRounds + "\nSauberkeit: " + dirtiness);
	    }
	 
	 
	public void reducingStats() { //methode um stats zu reduzieren
	
		
		if (playedRounds % 3 == 0) { //überprüft ob rundenanzahl teilbar durch 3 ist, wenn wahr werden werte reduziert
			fullStomach -= 10;
			feeling -= 7;
			dirtiness -= 5;
			
			System.out.println("Nach Runde " + playedRounds + " wurde der Magen um 16 reduziert");
			System.out.println("Nach Runde " + playedRounds + " wurde das Glück um 16 reduziert");
			
			
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
	        System.out.println("\nWas möchtest du tun?");
	        System.out.println("1. " + name + " füttern");
	        System.out.println("2. Mit " + name + " spielen");
	        System.out.println("3. Status anzeigen");
	        System.out.println("4. Beenden");
	        System.out.println("5. Konsole Leeren");
	        System.out.println("6. " + name + " duschen");
	        int choice = scanner.nextInt();
	        scanner.nextLine();  // Verhindert Probleme mit Eingaben, die nach nextInt() kommen.

	        switch (choice) {
	            case 1:
	                myTamagotchi.giveFood(); // Tamagotchi füttern
	                break;
	            case 2:
	                myTamagotchi.playWithTamagotchi(); // Mit Tamagotchi spielen
	                break;
	            case 3:
	                myTamagotchi.getStatus();// Status anzeigen
	                break;
	            case 4:
	                System.out.println("Spiel beendet."); //Beendet das Spiel, bzw lässt keine texteingabe mehr zu
	                return;
	            case 5:
	            	myTamagotchi.clearConsole();
	            	break;
	            case 6: 
	            	myTamagotchi.showerTamagotchi();
	            	break;
	            default:
	                System.out.println("Ungültige Wahl. Versuche es erneut.");
	                break;
	        }

	        // Nach jeder Runde prüfen, ob der Hunger und Gefühl reduziert werden müssen
	        myTamagotchi.reducingStats();
	    }
	}
}
	
	

	
	
	
	
	
	
	
	


