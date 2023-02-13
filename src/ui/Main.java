package ui; 

import java.util.Scanner;

import model.Seguimiento; 

public class Main{

	public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        Seguimiento r = new Seguimiento();
	System.out.println("Recursion Examples!!");

    //requerimiento 1, suma de un array. 

    System.out.println("Sum Array: ");
    int[] array = {12, -1, 15, 2, 4 , 14};
    System.out.println(r.sum(array));
    

    //requerimiento 2, Revertir un String.

    System.out.println("Revertir un String, porfavor ingresa una palabra xd");
    String palabra = reader.nextLine();
    System.out.println("The reverse of the String is : " + r.reverseString(palabra));


    //requerimiento 3, promedio del array.
    System.out.println("promedio del array xD");
    int[] arrayProm = {1, 2, 3, 4, 5 , 6};
    System.out.println(r.prom(arrayProm));

    //requerimiento 4, posicion del array.

    int[] arrayPosition = {1, 15, 8, 19, 21, 40, -4, 10};
    
    System.out.println("cual es el numero del arreglo que deseas buscar, 1, 15, 8, 19, 21, 40, -4, 10");
    int num = reader.nextInt(); 
    System.out.println(r.position(arrayPosition, num));

     //requerimiento 5, division por restas sucesivas xd. 
     System.out.println("division por restas."); 
     System.out.println("ingrese el numero que se va a dividir");
     int num1 = reader.nextInt();
     System.out.println("ingrese el numero el cual va a divudur al otro numero xd ");
     int num2 = reader.nextInt();

     System.out.println(r.division(num1,num2));

     //requerimiento 6, maximo comun divisor.
     System.out.println("maximo comun divisor."); 
     System.out.println("ingrese el numero 1");
    num1 = reader.nextInt();
     System.out.println("ingrese el numero 2 ");
    num2 = reader.nextInt();

     System.out.println(r.mcd(num1,num2));

     //requerimiento 7, cambio de dinero. 

     int[] dinerocol = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50}; 
     System.out.println("ingrese el dinero que desea cambiar ");
     int dinerox = reader.nextInt(); 
    
     System.out.println(r.cambioDinero(dinerox, dinerocol));

     





	}
}