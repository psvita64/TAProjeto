import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Gestor {
    public static Scanner sc = new Scanner(System.in);
    public static boolean DataExists(int dia, int mes, ArrayList<Data> listaData){
        for(Data d: listaData){
            if(d.getDia() == dia && d.getMes() == mes)
                return true;
        }
        return false;
    }

    public static ArrayList<Intervencao> ListarPorTipo(ArrayList<Intervencao> listaIntervencoes, int op){
        ArrayList<Intervencao> lista = new ArrayList<>();
        for (Intervencao i : listaIntervencoes){
            if (op == 1 && i instanceof Consulta){
                lista.add(i);
            }else if (op == 2 && i instanceof Cirurgia){
                lista.add(i);
            }else if (op == 3 && i instanceof Vacinacao){
                lista.add(i);
            }
        }
        return lista;

    }
    public static void listarIntervencoesAnimalFuturas(ArrayList<Intervencao> listaIntervencao, ArrayList<Cliente> listaclientes, ArrayList<Animal> listaAnimais, ArrayList<Data> listaData){
        int nif;
        do {
            System.out.printf("Introduza o seu nif: (0 - Voltar)\n");
            nif = sc.nextInt();
            if (nif <= 9 ) {
                System.out.println("\nNif inválido: O nif deve ter 9 digitos.\n");
            }else if(nif == 0){
                System.out.println("\nA voltar ...\n");
            }else{
                for (Cliente c : listaclientes) {
                    if (c.getNif() == nif){
                        System.out.println("\nCliente encontrado: "+c.getNome()+"\n");
                        for (Animal a : listaAnimais){
                            if (a.getCliente().getNif() == nif){
                                for (Intervencao i : listaIntervencao){
                                    if (i.getAnimal().getId() == a.getId()){
                                        if (i.getData().getDia() > 2 && i.getData().getMes() > 5){
                                            System.out.printf(i.toString());
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }else{
                        System.out.println("\nNif inválido: Cliente não encontrado.\n");
                        nif = 1;
                    }
                }
            }
        }while (nif <= 9 || nif != 0);
    }
    public static void listarIntervencoesAnimalHoje(ArrayList<Intervencao> listaIntervencao, ArrayList<Cliente> listaclientes, ArrayList<Animal> listaAnimais, ArrayList<Data> listaData){
        int nif;
        do {
            System.out.printf("Introduza o seu nif: (0 - Voltar)\n");
            nif = sc.nextInt();
            if (nif <= 9 ) {
                System.out.println("\nNif inválido: O nif deve ter 9 digitos.\n");
            }else if(nif == 0){
                System.out.println("\nA voltar ...\n");
            }else{
                for (Cliente c : listaclientes) {
                    if (c.getNif() == nif){
                        System.out.println("\nCliente encontrado: "+c.getNome()+"\n");
                        for (Animal a : listaAnimais){
                            if (a.getCliente().getNif() == nif){
                                for (Intervencao i : listaIntervencao){
                                    if (i.getAnimal().getId() == a.getId()){
                                        if (i.getData().getDia() == 2 && i.getData().getMes() == 5){
                                            System.out.printf(i.toString());
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }else{
                        System.out.println("\nNif inválido: Cliente não encontrado.\n");
                        nif = 1;
                    }
                }
            }
        }while (nif <= 9 || nif != 0);
    }
    public static void listarIntervencoesAnimalPassadas(ArrayList<Intervencao> listaIntervencao, ArrayList<Cliente> listaclientes, ArrayList<Animal> listaAnimais, ArrayList<Data> listaData){
        int nif;
        do {
            System.out.printf("Introduza o seu nif: (0 - Voltar)\n");
            nif = sc.nextInt();
            if (nif <= 9 ) {
                System.out.println("\nNif inválido: O nif deve ter 9 digitos.\n");
            }else if(nif == 0){
                System.out.println("\nA voltar ...\n");
            }else{
                for (Cliente c : listaclientes) {
                    if (c.getNif() == nif){
                        System.out.println("\nCliente encontrado: "+c.getNome()+"\n");
                        for (Animal a : listaAnimais){
                            if (a.getCliente().getNif() == nif){
                                for (Intervencao i : listaIntervencao){
                                    if (i.getAnimal().getId() == a.getId()){
                                        if (i.getData().getDia() < 2 && i.getData().getMes() < 5){
                                            System.out.printf(i.toString());
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }else{
                        System.out.println("\nNif inválido: Cliente não encontrado.\n");
                        nif = 1;
                    }
                }
            }
        }while (nif <= 9 || nif != 0);
    }
    public static void ListarIntervencoes(ArrayList<Intervencao> listaIntervencoes){
        int op;
        do{
            System.out.println("Que tipo de intervenção pretende listar?");
            System.out.println("1 - Consulta;");
            System.out.println("2 - Cirurgia;");
            System.out.println("3 - vacinação;");
            System.out.println("0 - Voltar\n");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();
            if (op == 1 || op == 2 || op == 3){
                ArrayList<Intervencao> lista = ListarPorTipo(listaIntervencoes,op);
                System.out.println("Intervenções: ");
                for (Intervencao i : lista){
                    System.out.println(i.toString());
                }
            }else if(op == 0){
                System.out.println("A voltar ...");
            }else {
                System.out.println("\nOpção inválida: insira uma opção dada.\n");
            }
        }while(op != 0);

    }
    public static void ListarIntervencoesVeterinarioData(ArrayList<Intervencao> listainervencoes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Data> listaData){
        int op, dia, mes;
        do{
            System.out.println("Que tipo de intervenção pretende listar?");
            System.out.println("1 - Consulta;");
            System.out.println("2 - Cirurgia;");
            System.out.println("3 - vacinação;");
            System.out.println("0 - Voltar\n");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();
            if (op == 1 || op == 2 || op == 3){
                System.out.println("Insira o dia da intervenção: ");
                dia = sc.nextInt();
                sc.nextLine();
                System.out.println("Insira o mês da intervenção: ");
                mes = sc.nextInt();
                sc.nextLine();
                if(dia <= 0 || dia > 31) {
                    System.out.println("Dia inválido: Insira um valor entre 1 e 31.");
                }else if(mes <= 0 || mes > 12) {
                    System.out.println("Mês inválido: Insira um valor entre 1 e 12.");
                }
                if (DataExists(dia,mes,listaData)){
                    ArrayList<Intervencao> lista = ListarPorTipo(listainervencoes,op);
                    System.out.println("Intervenções: ");
                    for (Intervencao i : lista){
                        if (i.getData().getDia() == dia && i.getData().getMes() == mes){
                            System.out.println(i.toString());
                        }
                    }
                }else{
                    System.out.println("Não existe intervenções na data " + dia + "/" +mes+ ".");
                }
            }else if(op == 0){
                System.out.println("A voltar ...");
            }else {
                System.out.println("\nOpção inválida: insira uma opção dada.\n");
            }
        }while(op != 0);

    }
    public static void ListarIntervencoesData(ArrayList<Intervencao> listaIntervencoes, ArrayList<Data> listaData){
        int op, dia, mes;
        do{
            System.out.println("Que tipo de intervenção pretende listar?");
            System.out.println("1 - Consulta;");
            System.out.println("2 - Cirurgia;");
            System.out.println("3 - vacinação;");
            System.out.println("0 - Voltar\n");
            System.out.print("Opção: ");
            op = sc.nextInt();
            sc.nextLine();
            if (op == 1 || op == 2 || op == 3){
                System.out.println("Insira o dia da intervenção: ");
                dia = sc.nextInt();
                sc.nextLine();
                System.out.println("Insira o mês da intervenção: ");
                mes = sc.nextInt();
                sc.nextLine();
                if (DataExists(dia,mes,listaData)){
                    ArrayList<Intervencao> lista = ListarPorTipo(listaIntervencoes,op);
                    for (Intervencao i : lista){
                        if (i.getData().getDia() == dia && i.getData().getMes() == mes){
                            System.out.println(i.toString());
                        }
                    }
                }else{
                    System.out.println("Não existe intervenções na data " + dia + "/" +mes+ ".");
                }
            }else if(op == 0){
                System.out.println("A voltar ...");
            }else {
                System.out.println("\nOpção inválida: insira uma opção dada.\n");
            }
        }while(op != 0);
    }
    public static boolean verificarDisponibilidade(ArrayList<Veterinario> listaVeterinarios, int id_ordem, Data data, float hora) {
        for (Veterinario v : listaVeterinarios) {
            if (v.getId_OrdemVet() == id_ordem) {
                ArrayList<Horario> horarios = v.getHorario();
                for (Horario horario : horarios) {
                    if (horario.getData().equals(data)) {
                        ArrayList<Horas> horas = horario.getHoras();
                        for (Horas h : horas) {
                            if (h.getHora() == hora) {
                                return h.isDisponibilidade();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void Mudardisponibilidade (ArrayList<Veterinario> listaVeterinarios, int id_ordem, Data data, float hora){
        for (Veterinario v : listaVeterinarios) {
            if (v.getId_OrdemVet() == id_ordem) {
                ArrayList<Horario> horarios = v.getHorario();
                for (Horario horario : horarios) {
                    if (horario.getData().equals(data)) {
                        ArrayList<Horas> horas = horario.getHoras();
                        for (Horas h : horas) {
                            if (h.getHora() == hora) {
                                h.setDisponibilidade(false);
                            }
                        }
                    }
                }
            }
        }

    }

    public static void addIntervencao(ArrayList<Intervencao> intervencao, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Animal> listaAnimais, ArrayList<Data> listaData){
        int tipo, dia, mes, hora, nif, id_ordem,id_Animal, op;
        Veterinario veterinario = null;
        Animal animal = null;
        float preco = 0,km = 0;
        boolean deslocacao, verifyData = false, verifyDisponibilidade;
        Data data = null;
        do {
            System.out.println("Que tipo de intervenção pretende fazer?");
            System.out.println("1 - Consulta;");
            System.out.println("2 - Cirurgia;");
            System.out.println("3 - vacinação;");
            System.out.println("0 - Voltar\n");
            System.out.print("Opção: ");
            tipo = sc.nextInt();
            sc.nextLine();
            do {
                System.out.println("Insira o ID de ordem do veterinário: ");
                id_ordem = sc.nextInt();
                sc.nextLine();
                if (id_ordem <= 0) {
                    System.out.println("ID de ordem inválido: Insira um valor positivo.");
                }else{
                    for (Veterinario v : listaVeterinarios){
                        if (v.getId_OrdemVet() == id_ordem){
                            System.out.println("\nVeterinário encontrado.\n");
                            veterinario = v;
                            break;
                        }else{
                            System.out.println("\nID de ordem inválido: Veterinário não encontrado.\n");
                        }
                    }
                }
            }while (id_ordem <= 0 || veterinario == null); ;
            do {
                System.out.println("Insira o Nif do cliente: ");
                nif = sc.nextInt();
                sc.nextLine();
                if (nif <= 9) {
                    System.out.println("Nif inválido: O nif deve ter 9 digitos.");
                } else {
                    for (Cliente c : listaClientes) {
                        if (c.getNif() == nif) {
                            System.out.println("\nCliente encontrado.\n");
                            for (Animal a : listaAnimais) {
                                if (a.getCliente().getNif() == nif) {
                                    System.out.println("Animais do cliente:");
                                    System.out.println(a.toString());
                                }
                            }
                            do {
                                System.out.println("Insira o ID do animal: ");
                                id_Animal = sc.nextInt();
                                sc.nextLine();
                                for (Animal a : listaAnimais) {
                                    if (a.getId() == id_Animal) {
                                        System.out.println("\nAnimal encontrado.\n");
                                        animal = a;
                                        break;
                                    } else {
                                        System.out.println("\nID invalido: Animal não encontrado.\n");
                                    }
                                }
                            }while (animal == null);
                            break;
                        } else {
                            System.out.println("\n Nif inválido: Cliente não encontrado.\n");
                        }
                    }
                }
            } while (nif <= 9);
            do{
                System.out.println("Deseja deslocação?(1-Sim, 2-Não)");
                op = sc.nextInt();
                sc.nextLine();
                if (op != 1 && op != 2){
                    System.out.println("\n Opção inválida: Insira uma intervenção dada.\n");
                }
            }while (op != 1 && op != 2);
            if(op == 1) {
                deslocacao = true;
                do {
                    System.out.println("Insira o número de km: ");
                    km = sc.nextFloat();
                    sc.nextLine();
                    if (km <= 0) {
                        System.out.println("\n Número inválido: Insira um valor positivo.\n");
                    }
                }while (km <= 0);
                preco = km * 1 + 40;
            }else{
                deslocacao = false;
            }
            switch (tipo){
                case 1:
                    if(animal.getPeso()<=10) {
                        preco += 25;
                    }else{
                        preco += 50;
                    }
                    break;
                case 2:
                    if(animal.getPeso()<=10) {
                        preco += 50;
                    }else{
                        preco += 100;
                    }
                    break;
                case 3:
                    if(animal.getPeso()<=10) {
                        preco += 200;
                    }else{
                        preco += 400;
                    }
                    break;
                    default:
                        System.out.println("\n Opção inválida: Insira uma opção dada.\n");
                        break;
            }
            do {
                System.out.println("Insira o dia da intervenção: ");
                dia = sc.nextInt();
                sc.nextLine();
                System.out.println("Insira o mês da intervenção: ");
                mes = sc.nextInt();
                sc.nextLine();
                System.out.println("Insira a hora da intervenção: ");
                hora = sc.nextInt();
                sc.nextLine();
                if (dia <= 0 || dia > 31) {
                    System.out.println("\n Dia inválido: Insira um valor entre 1 e 31.\n");
                }else if (mes <= 0 || mes > 12) {
                    System.out.println("\n Mês inválido: Insira um valor entre 1 e 12.\n");
                }else if (hora < 0 || hora > 24) {
                    System.out.println("\n Hora inválida: Insira um valor entre 8 e 18.\n");
                }
                if(!verifyData){
                    data = new Data(dia,mes);
                }
                if(!verificarDisponibilidade(listaVeterinarios,id_ordem,data,hora)) {
                    System.out.println("Hora não disponível.");
                    do {
                        System.out.println("Insira outra hora: ");
                        hora = sc.nextInt();
                        sc.nextLine();
                    }while(verificarDisponibilidade(listaVeterinarios,id_ordem,data,hora));

                }
            }while (dia <= 0 || dia > 31);
            do {
                op = 0;
                System.out.println("Confirma os dados da intervenção? (1- Sim, 2- Não)");
                System.out.println("Veterinário: " + veterinario.getNome()+ "\n Animal: " + animal.getNome());
                if(deslocacao){
                    System.out.println("Deslocação: Sim Kilometros: " + km);
                }else{
                    System.out.println("Deslocação: Não");
                }
                System.out.println("Data: " + dia + "/" + mes + " Hora: " + hora);
                System.out.print("Opção: ");
                op = sc.nextInt();
                sc.nextLine();
                if(op != 1 && op != 2){
                    System.out.println("\n Opção inválida: Insira uma opção dada.\n");
                }else if(op ==1){
                    switch (tipo) {
                        case 1:
                            intervencao.add(new Consulta(veterinario, animal, preco, deslocacao, data));
                            Mudardisponibilidade(listaVeterinarios,id_ordem,data,hora);
                            break;
                        case 2:
                            intervencao.add(new Cirurgia(veterinario, animal, preco, deslocacao, data));
                            for(float i = 0; i < 2; i+=0.5){
                                Mudardisponibilidade(listaVeterinarios,id_ordem,data,hora+i);
                            }
                            break;
                        case 3:
                            intervencao.add(new Vacinacao(veterinario, animal, preco, deslocacao, data));
                            Mudardisponibilidade(listaVeterinarios,id_ordem,data,hora);
                            break;
                    }
                }
            }while(op != 1 && op != 2);
        } while (tipo != 0);
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
    public static Cliente AddCliente( ArrayList<Cliente> clientes){
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

    public static void RemoverCliente(ArrayList<Cliente> clientes){
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

    public static Animal criarAnimal( ArrayList<Animal> listaAnimais, ArrayList<Cliente> listaClientes){
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
            if(especie.length()<3){
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
            if (nif < 9) {
                System.out.println("\nNif inválido: O nif deve ter 9 digitos.\n");
            }
            for (Cliente c : listaClientes) {
                if (c.getNif() == nif){
                    System.out.println("\nCliente encontrado.\n");
                    cliente = c;
                    break;
                }
            }
        }while(nif < 9 && cliente == null);
        id = listaAnimais.size() + 1;
        Animal a = new Animal(id, nome, especie,genero, peso, cliente );
        System.out.println("\nAnimal criado com sucesso.\n");
        listaAnimais.add(a);
        return a;
    }

    public static void listarAnimais(ArrayList<Animal> listaAnimais){
        System.out.println("\nLista de Animais\n");
        if(listaAnimais == null){
            System.out.println("Não existem animais.");
        }else {
            for (Animal a : listaAnimais) {
                System.out.println("1:");
                System.out.println(a.toString());
            }
        }
    }

    public static void listarIntervencoesAnimal(ArrayList<Intervencao> listaIntervencoes, ArrayList<Animal> listaAnimais, ArrayList<Cliente> listaClientes){
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
                        System.out.println("\nCliente encontrado: "+c.getNome()+"\n");
                        for (Animal a : listaAnimais){
                            if (a.getCliente().getNif() == nif){
                                for (Intervencao i : listaIntervencoes){
                                    if (i.getAnimal().getId() == a.getId()){
                                        System.out.printf(i.toString());
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
        }while (nif <= 9 || nif != 0);

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

    public static void ListarIntervencoesVeterinario(ArrayList<Veterinario> veterinarios){
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
    public static void getListaConsultas(ArrayList<Intervencao> listaIntervencoes, ArrayList<Animal> listaAnimais, int idVet){
        for (Animal a : listaAnimais){
            for (Intervencao i : listaIntervencoes){
                if (i.getAnimal().getId() == a.getId() && i.getVeterinario().getId_OrdemVet() == idVet){
                    if(i instanceof Consulta){
                        System.out.println(i.getAnimal().getNome() +" ");
                    }
                }
            }
        }
    }

    public static void getListaCirurgias(ArrayList<Intervencao> listaIntervencoes, ArrayList<Animal> listaAnimais, int idVet){
        for (Animal a : listaAnimais){
            for (Intervencao i : listaIntervencoes){
                if (i.getAnimal().getId() == a.getId() && i.getVeterinario().getId_OrdemVet() == idVet){
                    if(i instanceof Cirurgia){
                        System.out.println(i.getAnimal().getNome() +" ");
                    }
                }
            }
        }
    }

    public static void getListaVacinas(ArrayList<Intervencao> listaIntervencoes, ArrayList<Animal> listaAnimais, int idVet){
        for (Animal a : listaAnimais){
            for (Intervencao i : listaIntervencoes){
                if (i.getAnimal().getId() == a.getId() && i.getVeterinario().getId_OrdemVet() == idVet){
                    if(i instanceof Vacinacao){
                        System.out.println(i.getAnimal().getNome() +" ");
                    }
                }
            }
        }
    }

    public static void ListarAnimaisVeterinario( ArrayList<Veterinario> veterinarios, ArrayList<Intervencao> listaIntervencoes){
        System.out.println("Insira o ID do Veterinario: (0-Voltar)");

        // Verifica se o próximo token é um inteiro
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            sc.next(); // Limpa o buffer
        }
        int id = sc.nextInt();

        while (id != 0){
            boolean encontrou = false;
            for (Veterinario v : veterinarios){
                if (v.getId_OrdemVet() == id){
                    encontrou = true;
                    System.out.println("Veterinario Encontrado: "+v.getNome());
                    System.out.println("Animais:");
                    Set<Integer> animaisSet = new HashSet<>();
                    for (Intervencao i : listaIntervencoes){
                        if (i.getVeterinario().getId_OrdemVet() == id) {
                            animaisSet.add(i.getAnimal().getId());
                        }
                    }
                    for (Integer animalId : animaisSet) {
                        Animal animal = null;
                        for (Intervencao i : listaIntervencoes){
                            if (i.getAnimal().getId() == animalId) {
                                animal = i.getAnimal();
                                break;
                            }
                        }
                        if (animal != null) {
                            System.out.println(animal.toString());
                        }
                    }
                }
            }
            if (!encontrou) {
                System.out.println("Veterinario não encontrado.");
            }
            System.out.println("Insira o ID do Veterinario: (0-Voltar)");

            sc.nextLine();

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro.");
                sc.next();
            }
            id = sc.nextInt();
        }
    }

    public static void ListarClientesVeterinario(ArrayList<Veterinario> veterinarios, ArrayList<Intervencao> listaIntervencoes) {
        System.out.println("Insira o ID do Veterinario: (0-Voltar)");

        // Verifica se o próximo token é um inteiro
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            sc.next(); // Limpa o buffer
        }
        int id = sc.nextInt();

        while (id != 0) {
            boolean encontrou = false;
            for (Veterinario v : veterinarios) {
                if (v.getId_OrdemVet() == id) {
                    encontrou = true;
                    System.out.println("Veterinario Encontrado: " + v.getNome());
                    System.out.println("Clientes:");
                    Set<Integer> clientesSet = new HashSet<>();
                    for (Intervencao i : listaIntervencoes) {
                        if (i.getVeterinario().getId_OrdemVet() == id) {
                            clientesSet.add(i.getAnimal().getCliente().getNif());
                        }
                    }
                    for (Integer clienteNif : clientesSet) {
                        Cliente cliente = null;
                        for (Intervencao i : listaIntervencoes) {
                            if (i.getAnimal().getCliente().getNif() == clienteNif) {
                                cliente = i.getAnimal().getCliente();
                                break;
                            }
                        }
                        if (cliente != null) {
                            System.out.println(cliente.toString());
                        }
                    }
                }
            }
            if (!encontrou) {
                System.out.println("Veterinario não encontrado.");
            }
            System.out.println("Insira o ID do Veterinario: (0-Voltar)");


            sc.nextLine();

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro.");
                sc.next();
            }
            id = sc.nextInt();
        }
    }


    public static void removerVeterinario(ArrayList<Veterinario> veterinarios) {
        System.out.println("Insira o ID de Ordem do Veterinário:");

        while (!sc.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            sc.next();
        }
        int id = sc.nextInt();

        for (Veterinario v : veterinarios) {
            if (v.getId_OrdemVet() == id) {
                veterinarios.remove(v);
                System.out.println("Veterinário removido com sucesso.");
                return;
            }
        }
        System.out.println("Veterinário não encontrado.");
    }


    public static void RemoverAnimal(ArrayList<Animal> listaAnimal){
        System.out.println("Insira o ID do animal que quer remover:");


        while (!sc.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro para o ID do animal que deseja remover.");
            sc.next();
        }
        int id = sc.nextInt();

        for (Animal a : listaAnimal){
            if (a.getId() == id){
                System.out.println("Animal Encontrado: " + a.getNome());
                System.out.println("Remover?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                int op;

                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, insira um número inteiro para a opção.");
                    sc.next();
                }
                op = sc.nextInt();

                switch (op){
                    case 1:
                        listaAnimal.remove(a);
                        System.out.println("Animal removido com sucesso.");
                        break;
                    case 2:
                        System.out.println("Operação cancelada, voltando ao Menu.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                return;
            }
        }
        System.out.println("Animal não encontrado.");
    }

}







