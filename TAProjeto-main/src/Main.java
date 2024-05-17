import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable{
    public static void main(String[] args) {

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
        FileText<Veterinario> fileTextV = new FileText<>();
        FileText<Cliente> fileTextC = new FileText<>();
        FileText<Animal> fileTextA = new FileText<>();
        FileText<Intervencao> fileTextI = new FileText<>();
        FileText<Data> fileTextD = new FileText<>();
        FileText<Recibo> fileTextR = new FileText<>();
        FileText<Horario> fileTextH = new FileText<>();
        FileText<Horas> fileTextHo = new FileText<>();

        //Criação de objetos para teste
        /*Morada morada = new Morada("Rua", 1, 123, "Cidade");
        Cliente cliente = new Cliente(123456789, "joao", morada, 123456789);
        Animal animal = new Animal(1, "rex", "labrador", "Macho", 1, cliente);
        Veterinario veterinario = new Veterinario(123456789, "joao", 1, 123456789);
        listaClientes.add(cliente);
        listaAnimais.add(animal);
        listaVeterinarios.add(veterinario);*/


        //Ler em Objeto
        listaHoras = fileObjectHo.reader("./horas.dat");
        listaHorarios = fileObjectH.reader("./horario.dat");
        listaVeterinarios = fileObjectV.reader("./veterinario.dat");
        listaClientes = fileObjectC.reader("./cliente.dat");
        listaAnimais = fileObjectA.reader("./animal.dat");
        listaIntervencoes = fileObjectI.reader("./intervencao.dat");
        listaData = fileObjectD.reader("./data.dat");
        listaRecibos = fileObjectR.reader("./recibo.dat");

        Menus.menuPrincipal(listaAnimais, listaClientes, listaVeterinarios, listaIntervencoes, listaData, listaRecibos);

        //Gravar em Objeto
        fileObjectHo.writer("./horas.dat",listaHoras);
        fileObjectH.writer("./horario.dat",listaHorarios);
        fileObjectV.writer("./veterinario.dat",listaVeterinarios);
        fileObjectA.writer("./animal.dat",listaAnimais);
        fileObjectC.writer("./cliente.dat",listaClientes);
        fileObjectI.writer("./intervencao.dat",listaIntervencoes);
        fileObjectD.writer("./data.dat",listaData);
        fileObjectR.writer("./recibo.dat",listaRecibos);

        //Gravar em Texto
        fileTextV.writer("./veterinario.txt", listaVeterinarios);
        fileTextC.writer("./cliente.txt", listaClientes);
        fileTextA.writer("./animal.txt", listaAnimais);
        fileTextI.writer("./intervencao.txt", listaIntervencoes);
        fileTextD.writer("./data.txt", listaData);
        fileTextR.writer("./recibo.txt", listaRecibos);
        fileTextH.writer("./horario.txt", listaHorarios);
        fileTextHo.writer("./horas.txt", listaHoras);


        System.out.println("\nFim\n");


    }
}



