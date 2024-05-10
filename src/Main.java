import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Veterinario> listaVeterinarios = new ArrayList<Veterinario>();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        ArrayList<Animal> listaAnimais = new ArrayList<Animal>();
        ArrayList<Intervencao> listaIntervencoes = new ArrayList<Intervencao>();
        ArrayList<Data> listaData = new ArrayList<Data>();

        Menus.menuPrincipal(listaAnimais, listaClientes, listaVeterinarios, listaIntervencoes, listaData);

    }
}



