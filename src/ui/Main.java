package ui;
import java.util.Scanner;
import model.*;


public class Main {
    private Scanner reader;
	private GameController controller;
	

	public Main() {
		reader = new Scanner(System.in); 
        controller = new GameController();
	}

	public static void main(String[] args) {
			Main main = new Main();

			int option = -1; 
			do{
				option = main.getOptionShowMenu(); 
				main.executeOption(option);

			}while(option != 0);

		}

	public int getOptionShowMenu(){
			int option = 0; 
			printMenu();

			option = validateIntegerOption(); 

			return option; 
	}

	public void printMenu(){
			System.out.print(
                "\n<<<<< Welcome to the Game >>>>>\n"+	
                "1. Jugar\n"+
				"0. Exit. \n"+
				"Opcion: ");  
	}

		public void executeOption(int option){

			switch(option){
				case 1-> init();

				case 0-> System.out.println("Exit program.");
						
				default-> System.out.println("Invalid Option");
			}
		}
	
	/**
	 * @param: Option that gives the user
	 * @return: Validates the option and if the user gives a number that doesnt exist will give (Invalid Option) or even with letters (Invalid Option)
	 */	
	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

	public void init(){
		System.out.println("Dime que la cantidad de filas que deseas para el tablero: ");
		int rows = reader.nextInt();
		reader.nextLine();

		System.out.println("Dime la cantidad de columnas que deseas para el tablero: ");
		int columns = reader.nextInt();
		reader.nextLine();

		System.out.println("Dime cuantos toboganes deseas para este juego: ");
		int snakes = reader.nextInt();
		reader.nextLine();

		System.out.println("Dime cuantas escaleras deseas: ");
		int ladders = reader.nextInt();
		reader.nextLine();

		controller.createBoard(rows, columns, snakes, ladders);
	}

	public int playMenu(int player, int numPlayers){
		if(player>numPlayers-1){
			player=0;
		}
		System.out.println("Jugador,"); //Aqui se pone el +Jugador
		System.out.print("\nElije una opcion\n"+
				"1. Tirar dado\n"+
				"2. Ver escaleras y serpientes\n"+
				"Opcion: ");
		int option = reader.nextInt();
		controller.inGame(option, player);
		if(option==2){
			return playMenu(player, numPlayers);
		}
		return playMenu(player+1, numPlayers);
	}

}