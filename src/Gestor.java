import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class Gestor {

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

    public static boolean nifExists (int nif, ArrayList<Cliente> clientes){
        for (Cliente c : clientes){
            if (c.getNif() == nif){
                return true;
            }
        }
        return false;
    }
    public static boolean contactoExiste (int contacto, ArrayList<Cliente> clientes){
        for (Cliente c : clientes){
            if (c.getContacto() == contacto){
                return true;
            }
        }
        return false;
    }
    public static Cliente AddCliente(Scanner sc, ArrayList<Cliente> clientes){
        int nif = 0, contacto, numero, codPostal;
        String nome, rua, localidade;

        while (true) {
            System.out.println("Insira o NIF do cliente (9 dígitos): ");
            if (sc.hasNextInt()) {
                nif = sc.nextInt();
                if (String.valueOf(nif).length() == 9 && !nifExists(nif, clientes)) {
                    break;
                } else {
                    System.out.println("O NIF deve conter 9 dígitos e não estar na lista de clientes. Tente novamente.");
                }
            } else {
                System.out.println("Por favor, insira um valor inteiro para o NIF.");
                sc.next(); // Limpar o buffer
            }
        }
        sc.nextLine(); // Limpar o buffer

        System.out.println("Insira o nome do cliente: ");
        nome = sc.nextLine();

        while (true) {
            System.out.println("Insira o Contacto do cliente: ");
            if (sc.hasNextInt()) {
                contacto = sc.nextInt();
                if (String.valueOf(contacto).length() == 9 && String.valueOf(contacto).startsWith("9") && !contactoExiste(contacto, clientes)) {
                    break;
                } else {
                    System.out.println("O Contacto deve conter 9 dígitos, começar com '9' e não estar na lista de clientes. Tente novamente.");
                }
            } else {
                System.out.println("Por favor, insira um valor inteiro para o Contacto.");
                sc.next(); // Limpar o buffer
            }
        }
        sc.nextLine(); // Limpar o buffer

        System.out.println("Insira a rua do cliente: ");
        rua = sc.nextLine();

        System.out.println("Insira o numero da rua do cliente:");
        numero = sc.nextInt();
        sc.nextLine(); // Limpar o buffer

        System.out.println("Insira a localidade do cliente: ");
        localidade = sc.nextLine();

        System.out.println("Insira o código postal do cliente: ");
        codPostal = sc.nextInt();
        sc.nextLine(); // Limpar o buffer

        clientes.add(new Cliente(nif, nome, new Morada(rua,numero,codPostal ,localidade), contacto));
        return null;
    }

    public static void ListarClientes(ArrayList<Cliente> clientes){
        for (Cliente c : clientes){
            System.out.println(c.toString());
        }
    }

    public static void RemoverCliente(Scanner sc,ArrayList<Cliente> clientes){
        System.out.println("Insira o NIF do cliente que quer remover:");
        int nif= sc.nextInt();
        for (Cliente c : clientes){
            if (c.getNif() == nif){
                System.out.println("Cliente Econtrado :"+ c.getNome());
                System.out.println("Remover?");
                System.out.println("1-Sim");
                System.out.println("2-Não");
                int op = sc.nextInt();
                switch (op){
                    case 1:
                        clientes.remove(c);
                        System.out.println("Cliente removido com sucesso.");
                        break;
                    case 2:
                        System.out.println("Operação cancelada,a voltar ao Menu.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }


            }
        }
    }
    public static void ListarClienteEAnimais(ArrayList<Cliente> clientes, ArrayList<Animal> animais) {
        for (Cliente c : clientes) {
            System.out.print(c.getNome() + ":{");
            boolean primeiroAnimal = true;
            for (Animal a : animais) {
                if (a.getCliente().getNif() == c.getNif()) {
                    if (!primeiroAnimal) {
                        System.out.print(",");
                    }
                    System.out.print(a.getNome());
                    primeiroAnimal = false;
                }
            }
            System.out.println("}");
        }
    }

    public static Animal criarAnimal(Scanner sc, ArrayList<Animal> listaAnimais, ArrayList<Cliente> listaClientes){
        float peso;
        int id, nif, op;
        String nome, especie, genero;
        Cliente cliente = null;
        System.out.println("\nAdicionar Animal\n");
        do {
            System.out.println("Nome do animal: ");
            nome = sc.nextLine();
            if(nome.length()<3){
                System.out.println("\nNome inválido: Insira um nome com mais de 3 caracteres.\n");
            }
        }while(nome.length()<3);
        do {
            System.out.println("Especie do animal: ");
            especie = sc.nextLine();
            if(especie.length()<4){
                System.out.println("\nEspecie inválido.\n");
            }
        }while(especie.length()<3);
        do {
            System.out.println("Gênero do animal:(1- Macho, 2- Fêmea)");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();
            if (op != 1 && op != 2) {
                System.out.println("\nInsira uma opção dada.\n");
            }
        }while( op != 1 && op != 2);
        if(op == 1){
            genero = "Macho";
        }else{
            genero = "Fêmea";
        }
        do{
            System.out.println("Peso do animal: ");
            peso = sc.nextFloat();
            sc.nextLine();
            if(peso <= 0){
                System.out.println("\nPeso Inválido: o peso deve ser positivo.\n");
            }
        }while (peso <= 0);
        do {
            System.out.println("Introduza o nif do dono do animal: ");
            nif = sc.nextInt();
            sc.nextLine();
            if (nif <= 9) {
                System.out.println("\nNif inválido: O nif deve ter 9 digitos.\n");
            }
            for (Cliente c : listaClientes) {
                if (c.getNif() == nif){
                    System.out.println("\nCliente encontrado.\n");
                    cliente = c;
                    break;
                }else{
                    System.out.println("\nNif inválido: Cliente não encontrado.\n");
                }
            }
        }while(nif <= 9 && cliente == null);
        id = listaAnimais.size() + 1;
        sc.nextLine();
        Animal a = new Animal(id, nome, especie,genero, peso, cliente );
        listaAnimais.add(a);
        return a;
    }

    public static void listarAnimais(ArrayList<Animal> listaAnimais){
        System.out.println("\nLista de Animais\n");
        for (Animal a : listaAnimais){
            System.out.println(a.toString());
        }
    }

    public static void listarIntervencoesAnimal(Scanner sc, ArrayList<Intervencao> listaIntervencoes, ArrayList<Animal> listaAnimais, ArrayList<Cliente> listaClientes){
        int nif;
        do {
            System.out.printf("Introduza o seu nif: (0 - Voltar)\n");
            nif = sc.nextInt();
            if (nif <= 9 ) {
                System.out.println("\nNif inválido: O nif deve ter 9 digitos.\n");
            }else if(nif == 0){
                System.out.println("\nA voltar ...\n");
            }else{
                for (Cliente c : listaClientes) {
                    if (c.getNif() == nif){
                        System.out.println("\nCliente encontrado.\n");
                        for (Animal a : listaAnimais){
                            if (a.getCliente().getNif() == nif){
                                for (Intervencao i : listaIntervencoes){
                                    if (i.getAnimal().getId() == a.getId()){
                                        if(i instanceof Consulta){
                                            System.out.printf(i.toString());
                                        }

                                    }
                                }
                            }
                        }
                        break;
                    }else{
                        System.out.println("\nNif inválido: Cliente não encontrado.\n");
                    }
                }
            }
        }while (nif <= 9 || nif == 0);

    }

    public static boolean nifExistsV (int nif, ArrayList<Veterinario> veterinarios){
        for (Veterinario v : veterinarios){
            if (v.getNif() == nif){
                return true;
            }
        }
        return false;
    }

    public static boolean contactoExisteV (int contacto, ArrayList<Veterinario> veterinarios){
        for (Veterinario v : veterinarios){
            if (v.getContacto() == contacto){
                return true;
            }
        }
        return false;
    }

    public static void CriarVeterinario(Scanner sc, ArrayList<Veterinario> veterinarios){
        int nif = 0, contacto, numero, codPostal;
        String nome,rua,localidade;
        while (true) {
            System.out.println("Insira o NIF do veterinário (9 dígitos): ");
            if (sc.hasNextInt()) {
                nif = sc.nextInt();
                if (String.valueOf(nif).length() == 9 && !nifExistsV(nif, veterinarios)) {
                    break;
                } else {
                    System.out.println("O NIF deve conter 9 dígitos e não estar na lista de veterinários. Tente novamente.");
                }
            } else {
                System.out.println("Por favor, insira um valor inteiro para o NIF.");
                sc.next(); // Limpar o buffer
            }
        }
        sc.nextLine(); // Limpar o buffer

        System.out.println("Insira o nome do veterinário: ");
        nome = sc.nextLine();

        while (true) {
            System.out.println("Insira o Contacto do veterinário: ");
            if (sc.hasNextInt()) {
                contacto = sc.nextInt();
                if (String.valueOf(contacto).length() == 9 && String.valueOf(contacto).startsWith("9") && !contactoExisteV(contacto, veterinarios)) {
                    break;
                } else {
                    System.out.println("O Contacto deve conter 9 dígitos, começar com '9' e não estar na lista de veterinários. Tente novamente.");
                }
            } else {
                System.out.println("Por favor, insira um valor inteiro para o Contacto.");
                sc.next(); // Limpar o buffer
            }
        }
        sc.nextLine(); // Limpar o buffer
        int count = 0;
        for (Veterinario v : veterinarios){
            count++;
        }
        count ++;

        veterinarios.add(new Veterinario(nif, nome, count, contacto));

    }

    public static void ListarVeterinarios(ArrayList<Veterinario> veterinarios){
        for (Veterinario v : veterinarios){
            System.out.println(v.toString());
        }
    }

    public static void ListarIntervencoesVeterinario(Scanner sc,ArrayList<Veterinario> veterinarios){
        System.out.println("Insira o ID do Veterinario: (0-Voltar)");
        int id = sc.nextInt();
        while (id != 0){
            for (Veterinario v : veterinarios){
                if (v.getId_OrdemVet() == id){
                    System.out.println("Veterinario Encontrado: "+v.getNome());
                    System.out.println("Intervenções:");
                    for (Intervencao i : v.getListaInter()){
                        System.out.println(i.toString());
                    }
                }
            }
            System.out.println("Insira o ID do Veterinario: (0-Voltar)");
            id = sc.nextInt();
        }

    }

    //TODO fazer esta funcao
    public static void ListarAnimaisVeterinario(Scanner sc,ArrayList<Veterinario> veterinarios){
        System.out.println("Insira o ID do Veterinario: (0-Voltar)");
        int id = sc.nextInt();
        while (id != 0){
            for (Veterinario v : veterinarios){
                if (v.getId_OrdemVet() == id){
                    System.out.println("Veterinario Encontrado: "+v.getNome());
                    System.out.println("Animais:");
                    for (Intervencao i : v.getListaInter()){
                        System.out.println(i.toString());
                    }
                }
            }
            System.out.println("Insira o ID do Veterinario: (0-Voltar)");
            id = sc.nextInt();
        }

    }



}



