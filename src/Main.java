import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Veterenario> listaVeterinarios = new ArrayList<Veterenario>();
     /*   listaVeterinarios.add(new Veterenario(123456789, "João", 1, 912345678));
        listaVeterinarios.add(new Veterenario(987654321, "Maria", 2, 912345678));
        listaVeterinarios.add(new Veterenario(123456789, "João", 3, 912345678));
        listaVeterinarios.add(new Veterenario(987654321, "Maria", 4, 912345678));
        listaVeterinarios.add(new Veterenario(123456789, "João", 5, 912345678));
        listaVeterinarios.add(new Veterenario(987654321, "Maria", 6, 912345678));
        listaVeterinarios.add(new Veterenario(123456789, "João", 7, 912345678));
        listaVeterinarios.add(new Veterenario(987654321, "Maria", 8, 912345678));
        listaVeterinarios.add(new Veterenario(123456789, "João", 9, 912345678));
        listaVeterinarios.add(new Veterenario(987654321, "Maria", 10, 912345678));*/

        FileObject<Veterenario> fileObject = new FileObject<Veterenario>();
        fileObject.writer("veterinarios.dat", listaVeterinarios);

        ArrayList<Veterenario> listaVeterinariosLidos = fileObject.reader("veterinarios.dat");

        for (Veterenario veterinario : listaVeterinariosLidos) {
            System.out.println("NIF: " + veterinario.getNif());
            System.out.println("Nome: " + veterinario.getNome());
            System.out.println("ID Ordem Vet: " + veterinario.getId_OrdemVet());
            System.out.println("Contacto: " + veterinario.getContacto());
            System.out.println();
        }


    }
}



