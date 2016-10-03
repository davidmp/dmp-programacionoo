package mc.jeanpaul;
import java.util.Scanner;

/**
 * Created by PaulMamaniCoaquira on 9/19/16.
 */
public class MTresEnRaya {
    String tablero[][] = new String [3][3];

    public void cInicializarTablero(){
        for (int x = 0; x<tablero.length; x++){
            for(int y = 0; y<tablero.length; y++){
                tablero[x][y] = " ";
            }
        }
    }
    public void cImprimirTablero(){
        for (int x = 0; x<tablero.length; x++){
            for(int y = 0; y<tablero.length; y++){
                if(y!= 2) System.out.print( tablero[x][y] + " | ");
                else{
                    System.out.println(tablero[x][y]);
                    if (x != 2) System.out.println("----------");
                }
            }
        }
    }
    public boolean cComprobarGanador(String tablero[][]){
        String value = " ";
        String value1 = " ";
        for (int x = 0; x < tablero.length; x++) {
            int x1 = 0;
            int o1 = 0;
            int x2 = 0;
            int o2 = 0;
            for (int y = 0; y < tablero.length; y++) {
                value = tablero[x][y];
                value1 = tablero[y][x];
                if(value == "X" ) x1++;
                if(value == "O" ) o1++;
                if(value1 == "X" ) x2++;
                if(value1 == "O" ) o2++;
                if(x1 == 3 || o1 == 3 || x2 == 3 || o2 == 3){
                    return true;
                }
            }
        }
        int x1 = 0;
        int o1 = 0;
        int x2 = 0;
        int o2 = 0;
        int y = 2;
        for(int x = 0; x < tablero.length; x++){
            value = tablero[x][x];
            value1 = tablero[y][x];
            if(value == "X" ) x1++;
            if(value == "O" ) o1++;
            if(value1 == "X") x2++;
            if(value1 == "O" ) o2++;
            if(x1 == 3 || o1 == 3 || x2 == 3 || o2 == 3){
                return true;
            }
            y--;
        }
        return false;
    }
    public void cJugar(int tipo){
        cInicializarTablero();
        Scanner sc = new Scanner(System.in);
        boolean juego = false;
        //jugador = 1 juega con X jugador = 0 juego con O
        int jugador = 1;
        String ficha = "X";
        try{
            while(juego == false){
                int x = 0;
                int y = 0;
                if(tipo == 1 || jugador == 1){
                    System.out.println("Turno del jugador " + jugador + " Ficha: " + ficha );
                    System.out.println("Ingrese las (0,2)");
                    System.out.println("Ingrese la coordenada X: ");
                    x = sc.nextInt();
                    System.out.println("Ingrese la coordenada Y: ");
                    y = sc.nextInt();
                }
                else if(tipo == 2 && jugador == 2){
                    boolean position = false;
                    x = (int) (Math.random () * (3 - 1) + 1);
                    y = (int) (Math.random () * (3 - 1) + 1);
                    while(position==false){
                        System.out.println("Maquina haciendo jugada...");
                        if(x-1 <= 2 || y-1 < 2) {
                            position = true;
                        }
                    }
                }
                if(x <= 2 || y < 2){
                    if(tablero[x][y]==" "){
                        tablero[x][y] = ficha;
                        cImprimirTablero();
                        juego = cComprobarGanador(tablero);
                        if(juego){
                            System.out.println("El ganador es - Jugador "+ jugador );
                        }
                        else{
                            if (jugador == 1){
                                jugador = 2;
                                ficha = "O";
                            }
                            else {
                                jugador = 1;
                                ficha = "X";
                            }
                        }
                    }
                    else{
                        System.out.println("No se puede insertar en esas coordeanadas");
                    }

                }
                else{
                    System.out.println("Fuera de rango!!! Vuelve a ingresar nuevas coordeandas");
                }
                System.out.println("                           ");
                System.out.println("---------");
                System.out.println("                           ");

            }
        }catch (Exception e){
            System.out.println("Ocurrio un error" + e);
        }


    }
}
