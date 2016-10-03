package mc.jeanpaul;
import java.util.Scanner;
/**
 * Created by AlexeiDev on 9/19/16.
 */
public class MJuegoDeMesa {
    public void cMenu(){
        int option = 0;
        while(option != 3){
            System.out.println("-------------MENU DE JUEGO--------------");
            System.out.println("");
            System.out.println("1. Enfrentamiento entre personas");
            System.out.println("2. Enfrentamiento con la maquina");
            System.out.println("3. Salir");
            Scanner sc = new Scanner(System.in);
            try{
                System.out.println("Ingrese un valor: ");
                option = sc.nextInt();
                if(option == 1){
                    System.out.println("Que empiece la diversión");
                    MTresEnRaya tres_en_raya = new MTresEnRaya();
                    tres_en_raya.cJugar(option);
                }
                else if(option == 2){
                    System.out.println("Que empiece la diversión");
                    MTresEnRaya tres_en_raya = new MTresEnRaya();
                    tres_en_raya.cJugar(option);
                }
                else if(option == 3){
                    System.out.println("Hasta la vista baby!");
                    sc.close();
                }
                else{
                    System.out.println("Escogiste un valor incorrecto");
                    sc.close();
                    break;
                }

            }
            catch (Exception e){
                System.out.println("Ocurrio un error" + e);
            }
        }
    }
}
