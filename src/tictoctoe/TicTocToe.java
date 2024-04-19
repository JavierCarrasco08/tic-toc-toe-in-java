/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictoctoe;

/**
 *
 * @author Javi
 */
public class TicTocToe {
    private String[][] coordenadasDelTablero = {{"   ", "   ", "   "},{"   ", "   ", "   "},{"   ", "   ", "   "}};
    private boolean turno = true;
    private String jugadorX;
    private String jugadorO;
    private boolean repetir = true;
    private int turnosJugados = 0;
    // Meotodos get & publicos
    public String getJugadorX(){
        return jugadorX;
    }
    
    public String getJugadorO(){
        return jugadorO;
    }
    
    public boolean getRepetir() {
        return repetir;
    }
    
    public boolean getTurno() {
        return turno;
    }
    // Meotodos publicos 
    public void mostrarTablero(){
        System.out.println("   |   |   ");
        System.out.print(coordenadasDelTablero[0][0] + "|" + coordenadasDelTablero[0][1] + "|" + coordenadasDelTablero[0][2]);
        System.out.println();
        System.out.println("___|___|___");
        System.out.println("   |   |   ");        
        System.out.print(coordenadasDelTablero[1][0] + "|" + coordenadasDelTablero[1][1] + "|" + coordenadasDelTablero[1][2]);
        System.out.println();
        System.out.println("___|___|___");
        System.out.println("   |   |   ");
        System.out.println(coordenadasDelTablero[2][0] + "|" + coordenadasDelTablero[2][1] + "|" + coordenadasDelTablero[2][2]);
        System.out.println("   |   |   ");
    }
    
    public void insertarJugador(int columna, int fila, String jugador){
        if(coordenadasDelTablero[columna][fila] == "   "){
            coordenadasDelTablero[columna][fila] = jugador;
            turnosJugados += 1; 
            turno = !turno;
        }else {
            System.out.println("Ya ese espacio esta ocupado");
        }
        
        filas(jugador);
        columnas(jugador);
        entreFilaColumna(jugador);
        
        if(turnosJugados == 9 && repetir == true) {
            repetir = false;
            mostrarTablero();
            System.out.println("Ningun jugador ha ganado.");
        }
    }
    // Metodos privados.
    private void filas(String jugador){
        int contadorDeFilaIgual = 0;
        for(int y = 0; y < coordenadasDelTablero.length; y++){
            for(int x = 0; x < coordenadasDelTablero.length; x++){
                if(coordenadasDelTablero[y][x] == jugador) contadorDeFilaIgual += 1;
            }
            
            if(contadorDeFilaIgual == 3) {
                repetir = false;
                mostrarTablero();
                System.out.println("El ganador es :" + jugador);
                break;
            }
            
            contadorDeFilaIgual = 0;
        }
    }
    
    private void columnas(String jugador){
        int contadorDeColumnaIgual = 0;
        for(int x = 0; x < coordenadasDelTablero.length; x++){
            for(int y = 0; y < coordenadasDelTablero.length; y++){
                if(coordenadasDelTablero[y][x] == jugador) contadorDeColumnaIgual += 1;
            }
            
            if(contadorDeColumnaIgual == 3) {
                repetir = false;
                mostrarTablero();
                System.out.println("El ganador es :" + jugador);
                break;
            }
            
            contadorDeColumnaIgual = 0;
        }
    }
    
    private void entreFilaColumna(String jugador) {
        int contadorEntreX = 0;
        for(int i = 0; i < coordenadasDelTablero.length; i++){
            if(coordenadasDelTablero[i][i] == jugador) contadorEntreX += 1;
            
            if(contadorEntreX == 3) {
                repetir = false;
                mostrarTablero();
                System.out.println("El ganador es :" + jugador);
                break;
            }
        }
        
        contadorEntreX = 0;

        for(int i = 0; i < coordenadasDelTablero.length; i++){
            if(coordenadasDelTablero[i][2 - i] == jugador) contadorEntreX += 1;
            
            if(contadorEntreX == 3) {
                repetir = false;
                mostrarTablero();
                System.out.println("El ganador es :" + jugador);
                break;
            }
        }
    }
    // Metodos estaticos.
    public static void mensajeBienvenida() {
        System.out.println("Listo para jugar Tres en raya?");
    }
    
    // Contructores y sobrecarga de constructores
    public TicTocToe(String primerJugador, String segundoJugador) {
        jugadorX = " " + primerJugador + " ";
        jugadorO = " " + segundoJugador + " ";
    }
    
    public TicTocToe(String primerJugador) {
       this(primerJugador, primerJugador != "X" ? "X" : "O");
    }
}