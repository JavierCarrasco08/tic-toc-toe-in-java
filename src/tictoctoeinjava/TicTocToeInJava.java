/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictoctoeinjava;
import tictoctoe.TicTocToe;
import java.util.Scanner;

/**
 *
 * @author Javi
 */
public class TicTocToeInJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        TicTocToe.mensajeBienvenida();
        while(numero == 0) {
            System.out.println("- Si \n- No");
            String opcion = sc.nextLine();
            numero = switch(opcion) {
                case "si", "Si", "Esta bien", "esta bien", "Claro", "claro" -> 1;
                case "no", "No" -> 2;
                default -> {
                    System.out.println("Este valor es incorrecto.");
                    yield 0;
                }
            };
        }
        
        if(numero == 1) {
            int columna, fila;
            System.out.println("Empezemos a jugar!");
            TicTocToe primerJuego = new TicTocToe("X", "O");
            while(primerJuego.getRepetir()){
                System.out.println(" ");
                primerJuego.mostrarTablero();
                System.out.println(" ");
                System.out.println("Donde quieres insertar la ficha: " + (primerJuego.getTurno() ? primerJuego.getJugadorX(): primerJuego.getJugadorO()));
                System.out.print("En la columna numero(1, 2, 3): ");
                columna = sc.nextInt() - 1;
                sc.nextLine();
                System.out.print("Con la fila numero(1, 2, 3): ");
                fila = sc.nextInt() - 1;
                sc.nextLine();
                if(columna > 2 || fila > 2){
                    System.out.println("Acabas de colocar algun numero mal, recuerde que solo son: (1,2,3)");
                }else {
                    primerJuego.insertarJugador(columna, fila, (primerJuego.getTurno() ? primerJuego.getJugadorX(): primerJuego.getJugadorO()));
                }
            }
        }else {
            System.out.println("Juguemos en otro momento.");
        }
        sc.close();
    }
}
