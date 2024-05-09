import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {

    private static ArrayList<Intervencao> listaIntervenção = new ArrayList<>();

    public static void addIntervencao(Scanner sc, ArrayList<Intervencao> intervencao){
        int tipo;
        do{
            System.out.println("Que tipo de intervenção pretende fazer?");
            System.out.println("1 - Consulta;");
            System.out.println("2 - Cirurgia;");
            System.out.println("3 - vacinação;");
            System.out.println("0 - Voltar\n");
            System.out.print("Opção: ");
            tipo = sc.nextInt();
            switch (tipo){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }

        }while(tipo != 0);
    }

}



