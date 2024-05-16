import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Veterinario> listaVeterinarios = new ArrayList<Veterinario>();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        ArrayList<Animal> listaAnimais = new ArrayList<Animal>();
        ArrayList<Intervencao> listaIntervencoes = new ArrayList<Intervencao>();
        ArrayList<Data> listaData = new ArrayList<Data>();
        ArrayList<Recibo> listaRecibos = new ArrayList<Recibo>();
        ArrayList<Horario> listaHorarios = new ArrayList<Horario>();
        ArrayList<Horas> listaHoras = new ArrayList<Horas>();

        FileObject<Veterinario> fileObjectV = new FileObject<>();
        FileObject<Animal> fileObjectA = new FileObject<>();
        FileObject<Cliente> fileObjectC = new FileObject<>();
        FileObject<Intervencao> fileObjectI = new FileObject<>();
        FileObject<Data> fileObjectD = new FileObject<>();
        FileObject<Recibo> fileObjectR = new FileObject<>();
        FileObject<Horario> fileObjectH = new FileObject<>();
        FileObject<Horas> fileObjectHo = new FileObject<>();

        FileText fileText = new FileText();
        /*
        Morada morada = new Morada("Rua", 1, 123, "Cidade");
        Cliente cliente = new Cliente(123456789, "joao", morada, 123456789);
        Animal animal = new Animal(1, "rex", "labrador", "Macho", 1, cliente);
        Veterinario veterinario = new Veterinario(123456789, "joao", 1, 123456789);
        listaClientes.add(cliente);
        listaAnimais.add(animal);
        listaVeterinarios.add(veterinario);*/


        listaHoras = fileObjectHo.reader("./horas.dat");
        listaHorarios = fileObjectH.reader("./horario.dat");
        listaVeterinarios = fileObjectV.reader("./veterinario.dat");
        listaClientes = fileObjectC.reader("./cliente.dat");
        listaAnimais = fileObjectA.reader("./animal.dat");
        listaIntervencoes = fileObjectI.reader("./intervencao.dat");
        listaData = fileObjectD.reader("./data.dat");
        listaRecibos = fileObjectR.reader("./recibo.dat");

        Menus.menuPrincipal(listaAnimais, listaClientes, listaVeterinarios, listaIntervencoes, listaData, listaRecibos);


        fileObjectHo.writer("./horas.dat",listaHoras);
        fileObjectH.writer("./horario.dat",listaHorarios);
        fileObjectV.writer("./veterinario.dat",listaVeterinarios);
        fileObjectA.writer("./animal.dat",listaAnimais);
        fileObjectC.writer("./cliente.dat",listaClientes);
        fileObjectI.writer("./intervencao.dat",listaIntervencoes);
        fileObjectD.writer("./data.dat",listaData);
        fileObjectR.writer("./recibo.dat",listaRecibos);

        System.out.println("\nFim\n");


    }
}



