import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Gestor {
    public static Scanner sc = new Scanner(System.in);

    public static void mostrarRecibos(ArrayList<Recibo> listaRecibos, ArrayList<Cliente> listaClientes, ArrayList<Animal> listaAnimais){
        Animal animal = null;
        int idAnimal, nif;
        int dia, mes;
        System.out.printf("Insira o Id do animal (0 - Mostrar animais): ");
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro válido.");
                sc.next();
            }
            idAnimal = sc.nextInt();
            if(idAnimal == 0){
                do {
                    System.out.println("Insira o Nif do cliente: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, insira um número inteiro válido.");
                        sc.next();
                    }
                    nif = sc.nextInt();
                    sc.nextLine();
                    if (nif <= 99999999 || nif > 999999999) {
                        System.out.println("Nif inválido: O nif deve ter 9 digitos.");
                    } else {
                        for (Cliente c : listaClientes) {
                            if (c.getNif() == nif) {
                                System.out.println("\nCliente encontrado.\n");
                                System.out.println("Animais do cliente: ");
                                for (Animal a : listaAnimais) {
                                    if (a.getCliente().getNif() == nif) {
                                        System.out.println(a.getNome() + " ID: " + a.getId());
                                    }
                                }
                                do {
                                    System.out.println("Insira o ID do animal: ");
                                    while (!sc.hasNextInt()) {
                                        System.out.println("Por favor, insira um número inteiro válido.");
                                        sc.next();
                                    }
                                    idAnimal = sc.nextInt();
                                    sc.nextLine();
                                    for (Animal a : listaAnimais) {
                                        if (a.getId() == idAnimal) {
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
                }while(nif <= 99999999 || nif > 999999999);
                for (Recibo r : listaRecibos){
                    if(r.getIdAnimal() == idAnimal){
                        System.out.println(r.toString());
                    }
                }
            }else{
                for (Recibo r : listaRecibos){
                    if(r.getIdAnimal() == idAnimal){
                        System.out.println(r.toString());
                    }
                }
            }
        }while(idAnimal == 0);
    }
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
        };
        return lista;

    }

    public static void ListarAnimaisDeCliente( ArrayList<Animal> animais) {
        boolean encontrado = false;

        while (true) {
            System.out.println("Insira o NIF do Cliente (ou 0 para sair):");
            if (sc.hasNextInt()) {
                int id = sc.nextInt();
                if (id == 0) {
                    System.out.println("Saindo da função...");
                    return;
                }
                if (String.valueOf(id).length() == 9) {
                    for (Animal a : animais) {
                        if (a.getCliente().getNif() == id) {
                            System.out.println("Nome: " + a.getNome() + " ID: " + a.getId());
                            encontrado = true;
                        }
                    }

                    if (encontrado) {
                        break;
                    } else {
                        System.out.println("Nenhum animal encontrado para o NIF inserido. Tente novamente.");
                    }
                } else {
                    System.out.println("Insira um NIF com 9 digitos.");
                    sc.nextLine();
                }
            } else {
                System.out.println("Por favor, insira um valor inteiro para o NIF.");
                sc.nextLine();
            }
        }
    }



    public static void listarIntervencoesAnimalFuturas(ArrayList<Intervencao> listaIntervencao, ArrayList<Cliente> listaclientes, ArrayList<Animal> listaAnimais, ArrayList<Data> listaData){
        int nif;
        do {
            System.out.printf("Introduza o seu nif: (0 - Voltar)\n");
            nif = sc.nextInt();
            if (nif <= 99999999 || nif > 999999999 ) {
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
        }while (nif <= 99999999 || nif > 999999999 || nif != 0);
    }
    public static void listarIntervencoesAnimalHoje(ArrayList<Intervencao> listaIntervencao, ArrayList<Cliente> listaclientes, ArrayList<Animal> listaAnimais, ArrayList<Data> listaData){
        int nif;
        do {
            System.out.printf("Introduza o seu nif: (0 - Voltar)\n");
            nif = sc.nextInt();
            if (nif <= 99999999 || nif > 999999999 ) {
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
        }while (nif <= 99999999 || nif > 999999999 || nif != 0);
    }
    public static void listarIntervencoesAnimalPassadas(ArrayList<Intervencao> listaIntervencao, ArrayList<Cliente> listaclientes, ArrayList<Animal> listaAnimais, ArrayList<Data> listaData){
        int nif;
        do {
            System.out.printf("Introduza o seu nif: (0 - Voltar)\n");
            nif = sc.nextInt();
            if (nif <= 99999999 || nif > 999999999 ) {
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
        }while (nif <= 99999999 || nif > 999999999 || nif != 0);
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
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro válido.");
                sc.next();
            }
            op = sc.nextInt();
            sc.nextLine();
            if (op == 1 || op == 2 || op == 3){
                ArrayList<Intervencao> lista = ListarPorTipo(listaIntervencoes,op);
                System.out.println("\nIntervenções: \n");
                for (Intervencao i : lista){
                    System.out.println(i.toString());
                }
                return;
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
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro válido.");
                sc.next();
            }
            op = sc.nextInt();
            sc.nextLine();
            if (op == 1 || op == 2 || op == 3){
                System.out.println("Insira o dia da intervenção: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, insira um número inteiro válido.");
                    sc.next();
                }
                dia = sc.nextInt();
                sc.nextLine();
                System.out.println("Insira o mês da intervenção: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, insira um número inteiro válido.");
                    sc.next();
                }
                mes = sc.nextInt();
                sc.nextLine();
                if (DataExists(dia,mes,listaData)){
                    ArrayList<Intervencao> lista = ListarPorTipo(listaIntervencoes,op);
                    if(lista.size() == 0){
                        System.out.println("Não existem intervenções do tipo " + op + " na data " + dia + "/" + mes + ".");
                    }
                    for (Intervencao i : lista){
                        if (i.getData().getDia() == dia && i.getData().getMes() == mes){
                            System.out.println(i.toString());
                        }
                    }
                    return;
                }else{
                    Data data = new Data(dia,mes);
                    ArrayList<Intervencao> lista = ListarPorTipo(listaIntervencoes,op);
                    if(lista.size() == 0){
                        System.out.println("Não existem intervenções do tipo " + op + " na data " + dia + "/" + mes + ".");

                    }
                    for (Intervencao i : lista){
                        if (i.getData().getDia() == dia && i.getData().getMes() == mes){
                            System.out.println(i.toString());
                        }
                    }
                    return;
                }
            }else if(op == 0){
                System.out.println("A voltar ...");
            }else {
                System.out.println("\nOpção inválida: insira uma opção dada.\n");
            }
        }while(op != 0);
    }


    public static Horario getHorarioByData(Data data, ArrayList<Horario> listaHorario) {
        for (Horario h : listaHorario) {
            if (h.getData().equals(data)) {
                return h;
            }
        }
        return null;
    }


    public static Intervencao addIntervencao(ArrayList<Intervencao> listaIntervencao, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Animal> listaAnimais, ArrayList<Data> listaData, ArrayList<Recibo> listaRecibos){
        int tipo, dia= 0, mes= 0, nif, id_ordem,id_Animal, op;
        Veterinario veterinario = null;
        Animal animal = null;
        float preco = 0,km = 0,hora = 0;
        boolean deslocacao;
        Data data = null;
        Data d;
        Horario horario;
        Recibo recibo ;
        ArrayList<Intervencao> listaIntervencaoRecibo = new ArrayList<>();
        do {

            System.out.println("Que tipo de intervenção pretende fazer?");
            System.out.println("1 - Consulta;");
            System.out.println("2 - Cirurgia;");
            System.out.println("3 - Vacinação;");
            System.out.println("0 - Voltar\n");
            System.out.print("Opção: ");
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro válido.");
                sc.next();
            }
            tipo = sc.nextInt();
            sc.nextLine();
            if(tipo == 0){
                System.out.println("A voltar ...");
                break;
            }
            do {
                System.out.println("Insira o ID de ordem do veterinário: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, insira um número inteiro válido.");
                    sc.next();
                }
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
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, insira um número inteiro válido.");
                    sc.next();
                }
                nif = sc.nextInt();
                sc.nextLine();
                if (nif <= 99999999 || nif > 999999999) {
                    System.out.println("Nif inválido: O nif deve ter 9 digitos.");
                } else {
                    for (Cliente c : listaClientes) {
                        if (c.getNif() == nif) {
                            System.out.println("\nCliente encontrado.\n");
                            System.out.println("Animais do cliente: ");
                            for (Animal a : listaAnimais) {
                                if (a.getCliente().getNif() == nif) {
                                    System.out.println(a.getNome() + " ID: " + a.getId());
                                }
                            }
                            do {
                                System.out.println("Insira o ID do animal: ");
                                while (!sc.hasNextInt()) {
                                    System.out.println("Por favor, insira um número inteiro válido.");
                                    sc.next();
                                }
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
            } while (nif <= 99999999 || nif > 999999999);
            do{
                System.out.println("Deseja deslocação?(1-Sim, 2-Não)");
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, insira um número inteiro válido.");
                    sc.next();
                }
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
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, insira um número inteiro válido.");
                        sc.next();
                    }
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
                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, insira um número inteiro válido.");
                        sc.next(); // Consume the invalid input
                    }
                    dia = sc.nextInt();

                    if(dia <= 0 || dia > 31){
                        System.out.println("Insira uma Data Válida.");
                    }
                } while(dia <= 0 || dia > 31);

                sc.nextLine();
                System.out.println("Insira o mês da intervenção: ");
                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, insira um número inteiro válido.");
                        sc.next(); // Consume the invalid input
                    }
                    mes = sc.nextInt();

                    if(mes <= 0 || mes > 12){
                        System.out.println("Insira uma Data Válida.");
                    }
                } while(mes <= 0 || mes > 12);

                sc.nextLine();
                System.out.println("Insira a hora da intervenção (Exemplo: 9,5): ");
                do {
                    while (!sc.hasNextFloat()) {
                        System.out.println("Por favor, insira um número  válido.");
                        sc.next(); // Consume the invalid input
                    }
                    hora = sc.nextFloat();

                    if(hora <= 8 || dia > 18 || hora%1 != 0.5 ){
                        System.out.println("Insira uma Hora Válida.");
                    }
                } while(hora <= 8 || dia > 18 || hora%1 != 0.5 );
                sc.nextLine();

                d = new Data(dia,mes);
                if(!DataExists(dia,mes,listaData)){
                    horario = new Horario(d);
                    veterinario.getHorario().add(horario);
                    listaData.add(d);
                }else {
                    horario = getHorarioByData(d, veterinario.getHorario());
                    System.out.println("Horario: " + horario.getHorasLivres());
                }
                 if(!horario.isHoraLivre(hora, d)){
                    System.out.println("Hora não disponível, selecione outro dia ou outra hora.");
                }

            }while (dia <= 0 || dia > 31 || mes <= 0 || mes > 12 || hora < 8 || hora > 18 || hora%1 != 0.5 || !horario.isHoraLivre(hora, d));

            do {
                op = 0;
                System.out.println("Confirma os dados da intervenção? (1- Sim, 2- Não)");
                System.out.println("\nVeterinário: " + veterinario.getNome()+ "\nAnimal: " + animal.getNome());
                if(deslocacao){
                    System.out.println("Deslocação: Sim \n Kilometros: " + km);
                }else{
                    System.out.println("Deslocação: Não");
                }
                System.out.println("Data: " + dia + "/" + mes + "\nHora: " + hora);
                System.out.print("\nOpção: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, insira um número inteiro válido.");
                    sc.next();
                }
                op = sc.nextInt();
                sc.nextLine();
                if(op != 1 && op != 2){
                    System.out.println("\n Opção inválida: Insira uma opção dada.\n");
                }else if(op ==1){
                    switch (tipo) {
                        case 1:
                            Consulta consulta = new Consulta(veterinario, animal, preco, deslocacao, data);
                            listaIntervencao.add(consulta);
                            horario.marcarHoraComoOcupada(hora);
                            System.out.println("Consulta criada com sucesso.");
                            System.out.printf("\nDeseja adicionar mais alguma intervenção? (1- Sim, 2- Não)\n");
                            while (!sc.hasNextInt()) {
                                System.out.println("Por favor, insira um número inteiro válido.");
                                sc.next();
                            }
                            op = sc.nextInt();
                            sc.nextLine();
                            if(op == 1){
                                listaIntervencaoRecibo.add(addIntervencao(listaIntervencao, listaClientes, listaVeterinarios, listaAnimais, listaData, listaRecibos));
                            }

                            recibo = new Recibo(veterinario, animal.getCliente() , animal , listaIntervencaoRecibo);
                            listaRecibos.add(recibo);
                            System.out.printf("Recibo criado com sucesso.");
                            tipo = 0;
                            return null;
                        case 2:
                            Cirurgia cirurgia = new Cirurgia(veterinario, animal, preco, deslocacao, data);
                            listaIntervencao.add(cirurgia);
                            for(float i = 0; i < 2; i+=0.5){
                                horario.marcarHoraComoOcupada(hora + i);
                            }
                            System.out.println("Cirurgia criada com sucesso.");
                            System.out.printf("\nDeseja adicionar mais alguma intervenção? (1- Sim, 2- Não)\n");
                            while (!sc.hasNextInt()) {
                                System.out.println("Por favor, insira um número inteiro válido.");
                                sc.next();
                            }
                            op = sc.nextInt();
                            sc.nextLine();
                            if(op == 1){
                                listaIntervencaoRecibo.add(addIntervencao(listaIntervencao, listaClientes, listaVeterinarios, listaAnimais, listaData, listaRecibos));
                            }
                            recibo = new Recibo(veterinario, animal.getCliente() , animal , listaIntervencaoRecibo);
                            listaRecibos.add(recibo);
                            System.out.printf("Recibo criado com sucesso.");
                            tipo = 0;
                            return null;
                        case 3:
                            Vacinacao vacinacao = new Vacinacao(veterinario, animal, preco, deslocacao, data);
                            listaIntervencao.add(vacinacao);
                            horario.marcarHoraComoOcupada(hora);
                            System.out.println("Vacinação criada com sucesso.");
                            System.out.printf("\nDeseja adicionar mais alguma intervenção? (1- Sim, 2- Não)\n");
                            while (!sc.hasNextInt()) {
                                System.out.println("\nPor favor, insira um número inteiro válido.\n");
                                sc.next();
                            }
                            op = sc.nextInt();
                            sc.nextLine();
                            if(op == 1){
                                listaIntervencaoRecibo.add(addIntervencao(listaIntervencao, listaClientes, listaVeterinarios, listaAnimais, listaData, listaRecibos));
                            }
                            recibo = new Recibo(veterinario, animal.getCliente() , animal , listaIntervencaoRecibo);
                            listaRecibos.add(recibo);
                            System.out.printf("Recibo criado com sucesso.");
                            tipo = 0;
                            return null;
                    }
                }
            }while(op != 1 && op != 2);
        } while (tipo != 0);
        return null;
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


        System.out.println("Insira a numero da rua do cliente : ");
        while (true) {
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                sc.nextLine(); // Limpar o buffer
                break;
            } else {
                System.out.println("Por favor, insira apenas o número da rua.");
                sc.nextLine(); // Limpar o buffer
            }
        }

        System.out.println("Insira a localidade do cliente: ");
        localidade = sc.nextLine();

        System.out.println("Insira o código postal do cliente (apenas números): ");
        while (true) {
            if (sc.hasNextInt()) {
                codPostal = sc.nextInt();
                sc.nextLine(); // Limpar o buffer
                break;
            } else {
                System.out.println("Por favor, insira apenas números para o código postal.");
                sc.nextLine(); // Limpar o buffer
            }
        }

        clientes.add(new Cliente(nif, nome, new Morada(rua,numero,codPostal ,localidade), contacto));
        return null;
    }

    public static void ListarClientes(ArrayList<Cliente> clientes){
        for (Cliente c : clientes){
            System.out.println(c.toString());
        }
    }

    public static void RemoverCliente(ArrayList<Cliente> clientes) {
        System.out.println("Insira o NIF do cliente que quer remover:");
        int nif = sc.nextInt();

        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente c = iterator.next();
            if (c.getNif() == nif) {
                System.out.println("Cliente Encontrado: " + c.getNome());
                System.out.println("Remover?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                int op = sc.nextInt();
                switch (op) {
                    case 1:
                        iterator.remove(); // Remove o cliente usando o iterador
                        System.out.println("Cliente removido com sucesso.");
                        return; // Saia do método após remover o cliente
                    case 2:
                        System.out.println("Operação cancelada, a voltar ao Menu.");
                        return; // Saia do método sem remover o cliente
                    default:
                        System.out.println("Opção inválida.");
                        return; // Saia do método em caso de opção inválida
                }
            }
        }
        System.out.println("Cliente com NIF " + nif + " não encontrado.");
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
                    System.out.print(a.getNome() + " Id:"+ a.getId());
                    primeiroAnimal = false;
                }
            }
            System.out.println("}");
        }
    }

    public static void criarAnimal( ArrayList<Animal> listaAnimais, ArrayList<Cliente> listaClientes){
        if (listaClientes.size() == 0){
            System.out.println("\nErro: Para adicionar animais é necessário ter clientes.\n");
            return;
        }
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
            while (!sc.hasNextInt()) {
                System.out.println("\nPor favor, insira um número inteiro válido.\n");
                sc.next();
                System.out.print("Opção: ");
            }
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
            while (!sc.hasNextFloat()) {
                System.out.println("\nPor favor, insira um número válido.\n");
                sc.next();
                System.out.print("Opção: ");
            }
            peso = sc.nextFloat();
            sc.nextLine();
            if(peso <= 0){
                System.out.println("\nPeso Inválido: o peso deve ser positivo.\n");
            }
        }while (peso <= 0);
        do {
            System.out.println("Introduza o nif do dono do animal: ");
            while (!sc.hasNextInt()) {
                System.out.println("\nPor favor, insira um número inteiro válido.\n");
                sc.next();
                System.out.print("Opção: ");
            }
            nif = sc.nextInt();
            sc.nextLine();
            if (nif < 9) {
                System.out.println("\nNif inválido: O nif deve ter 9 digitos.\n");
            }
            for (Cliente c : listaClientes) {
                if (c.getNif() == nif){
                    System.out.println("\nCliente encontrado.\n");
                    cliente = c;
                    id = listaAnimais.size() + 1;
                    Animal a = new Animal(id, nome, especie,genero, peso, cliente );
                    System.out.println("\nAnimal criado com sucesso.\n");
                    listaAnimais.add(a);
                    break;
                }
            }
            if(cliente == null){
                System.out.println("\nNif inválido: Cliente não encontrado.\n");
            }
        }while(nif < 9 && cliente == null);

    }

    public static void listarAnimais(ArrayList<Animal> listaAnimais){
        System.out.println("\nLista de Animais\n");
        if(listaAnimais == null){
            System.out.println("Não existem animais.");
        }else {
            for (Animal a : listaAnimais) {
                System.out.println(a.toString());
                System.out.println("\n");
            }
        }
    }

    public static void listarIntervencoesAnimal(ArrayList<Intervencao> listaIntervencoes, ArrayList<Animal> listaAnimais, ArrayList<Cliente> listaClientes){
        int nif;
        do {
            System.out.printf("Introduza o seu nif: (0 - Voltar)\n");
            nif = sc.nextInt();
            if (nif <= 99999999 || nif > 999999999 ) {
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
        }while (nif <= 99999999 || nif > 999999999 || nif != 0);

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

    public static void CriarVeterinario(ArrayList<Veterinario> veterinarios){
        int nif = 0, contacto, numero, codPostal;
        String nome,rua,localidade;
        System.out.println("Insira o NIF do veterinário (9 dígitos): ");
        while (true) {
            if (sc.hasNextInt()) {
                nif = sc.nextInt();
                if (String.valueOf(nif).length() == 9 && !nifExistsV(nif, veterinarios)) {
                    break;
                } else {
                    System.out.println("O NIF deve conter 9 dígitos e não estar na lista de veterinários. Tente novamente.");
                }
            } else {
                System.out.println("\nPor favor, insira um valor inteiro para o NIF.\n");
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
        Veterinario vet = new Veterinario(nif, nome, count, contacto);
        veterinarios.add( vet);


        System.out.println("Veterinário criado com sucesso.");

    }

    public static void ListarVeterinarios(ArrayList<Veterinario> veterinarios){
        for (Veterinario v : veterinarios){
            System.out.println(v.toString());
        }
    }

    public static void ListarIntervencoesVeterinario(ArrayList<Veterinario> veterinarios){
        if(veterinarios.size() == 0){
            System.out.println("Não existem veterinários.");
            return;
        }
        System.out.println("Insira o ID do Veterinario: (0-Voltar)");
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            sc.next(); // Limpa o buffer
        }
        int id = sc.nextInt();
        while (id != 0){
            for (Veterinario v : veterinarios){
                if (v.getId_OrdemVet() == id){
                    System.out.println("Veterinario Encontrado: "+v.getNome());
                    System.out.println("Intervenções:");
                    if(v.getListaInter().size() == 0) {
                        System.out.println("Não existem intervenções.");
                    }
                    for (Intervencao i : v.getListaInter()){
                        System.out.println(i.toString());
                    }
                    id=0;
                }else{
                    System.out.println("Veterinario não encontrado.");

                }
            }
        }

    }

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
                            System.out.println("Animais:");
                            System.out.println(animal.toString());
                        }else{
                            System.out.println("Não existem animais.");
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
                            System.out.println("Clientes:");
                            System.out.println(cliente.toString());
                        }else {
                            System.out.println("Não existem clientes.");
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
        Iterator<Veterinario> iterator = veterinarios.iterator();
        for (Veterinario v : veterinarios) {
            if (v.getId_OrdemVet() == id) {
                System.out.println("Veterinario Encontrado: " + v.getNome());
                System.out.println("Remover?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                while (!sc.hasNextInt()) {
                    System.out.println("Por favor, insira um número inteiro.");
                    sc.next();
                }
                int op = sc.nextInt();
                switch (op) {
                    case 1:
                        iterator.remove(); // Remove o cliente usando o iterador
                        System.out.println("Veterinario removido com sucesso.");
                        return; // Saia do método após remover o cliente
                    case 2:
                        System.out.println("Operação cancelada, a voltar ao Menu.");
                        return; // Saia do método sem remover o cliente
                    default:
                        System.out.println("Opção inválida.");
                        return; // Saia do método em caso de opção inválida
                }
            }
        }
        System.out.println("Veterinário não encontrado.");
    }


    public static void RemoverAnimal(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes){
        int op = 0;
        ListarClienteEAnimais(listaClientes, listaAnimal);
        System.out.println("Insira o ID do animal que quer remover:");


        while (!sc.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro para o ID do animal que deseja remover.");
            sc.next();
        }
        int id = sc.nextInt();

        for (Animal a : listaAnimal){
            if (a.getId() == id){
                System.out.println("Animal Encontrado: " + a.getNome());
                do {
                    System.out.println("Remover?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");

                    while (!sc.hasNextInt()) {
                        System.out.println("\nPor favor, insira um número inteiro para a opção.\n");
                        sc.next();
                    }
                    op = sc.nextInt();

                    switch (op) {
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
                } while (op != 1 && op != 2);
            }
        }
        System.out.println("Animal não encontrado.");
    }

}