package ui;
import java.util.Scanner;
import model.*;


import model.GameController;

public class Game {
    private Scanner reader;
	private GameController controller;
	

	public Game() {
		reader = new Scanner(System.in); 
        controller = new GameController();
	}

	public static void main(String[] args) {
			Game main = new Game(); 

			int option = -1; 
			do{
				option = main.getOptionShowMenu(); 
				main.executeOption(option);

			}while(option != 0);

		}

	public Scanner getReader() {
		return this.reader;
	}

	public void setReader(Scanner reader) {
		this.reader = reader;
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

	}
}