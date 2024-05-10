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

        System.out.println("Vamos criar um cliente:");
        //Cliente c = Gestor.AddCliente(sc, listaClientes);
        Cliente c = new Cliente(123456789, "Joao", new Morada("Rua", 1, 4000, "Porto"), 912345678);
        Cliente c1 = new Cliente(2, "Maria", new Morada("Rua", 2, 4000, "Porto"), 912345678);
        Animal a = new Animal(1, "Rex", "Cao", "M", 10, c);
        Veterinario v = new Veterinario(123456789, "Dr. Joao", 123456789, 123456789);
        Consulta con = new Consulta(v, a, 20,true);
        listaAnimais.add(a);
        listaClientes.add(c);
        listaClientes.add(c1);
        listaVeterinarios.add(v);
        listaIntervencoes.add(con);
        /*System.out.println("vamos listar o Cliente:");
        Gestor.ListarClientes(listaClientes);
        System.out.println("Vamos criar um animal:");
        System.out.println("Vamos Criar outro:");
        Animal a2 = new Animal(2, "Miau", "Gato", "F", 5, c);
        listaAnimais.add(a2);
        System.out.println("Vamos Criar outro:");
        Animal a3 = new Animal(3, "Piu", "Passaro", "M", 1, c1);
        listaAnimais.add(a3);
        System.out.println("Vamos listar os Animais dos clientes:");
        Gestor.ListarClienteEAnimais(listaClientes, listaAnimais);
        System.out.println("Vamos remover um cliente");
        Gestor.RemoverCliente(sc, listaClientes);
        System.out.println("Vamos listar os clientes:");
        Gestor.ListarClientes(listaClientes);*/
        System.out.println("listar intervenções:");
        Gestor.listarIntervencoesAnimal(sc, listaIntervencoes, listaAnimais, listaClientes);

    }
}



