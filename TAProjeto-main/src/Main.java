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
        ArrayList<Recibo> listaRecibos = new ArrayList<Recibo>();

        Morada m1 = new Morada("Rua do João", 4, 4000, "Portugal");
        Cliente c1 = new Cliente(123456789, "João", m1, 123456789);
        listaClientes.add(c1);
        Animal a1 = new Animal(1, "Rex", "Cão", "Macho", 10, c1);
        listaAnimais.add(a1);
        Veterinario v1 = new Veterinario(123456789, "Dr. João", 1, 987654321);
        listaVeterinarios.add(v1);

        for(int i = 0; i < 20; i++){
            v1.getHorario();
        }
        Menus.menuPrincipal(listaAnimais, listaClientes, listaVeterinarios, listaIntervencoes, listaData, listaRecibos);

    }
}



