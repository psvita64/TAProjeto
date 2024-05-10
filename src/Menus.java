import java.util.ArrayList;
import java.util.Scanner;

public class Menus {
    public static Scanner sc = new Scanner(System.in);

    public static void  menuCliente(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Intervencao> listaIntervencoes) {
        int op = 0;
        do {
            System.out.println("---------Menu---------");
            System.out.println("1- Criar Cliente");
            System.out.println("2- Remover Cliente");
            System.out.println("3- Listar Cliente");
            System.out.println("4- Listar Animais dos Clientes");
            System.out.println("5- Listar Animais de um Cliente");
            System.out.println("0- Sair");
            System.out.println("----------------------");
            System.out.print("Opção: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    Gestor.AddCliente( listaClientes);
                    break;
                case 2:
                    Gestor.RemoverCliente(listaClientes);
                    break;
                case 3:
                    Gestor.ListarClientes(listaClientes);
                    break;
                case 4:
                    Gestor.ListarClienteEAnimais(listaClientes,listaAnimal);
                    break;
                case 5:
                    Gestor.ListarAnimaisDeCliente(listaAnimal);
                    break;
                case 0:
                    System.out.println("\nA voltar...\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }


        } while (op != 0) ;
    }

    public static void menuFaturacaoFuturas(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Intervencao> listaIntervencoes, ArrayList<Data> listaDatas){
        int op = 0;
        do{
            System.out.println("---------Menu---------");
            System.out.println("1-Listar por tipo de Intervenção");
            System.out.println("2-Listar por Animal");
            System.out.println("3-Listar por Cliente ");
            System.out.println("0-Sair");
            op= sc.nextInt();
            switch (op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("\nVoltando ao menu\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(op != 0);
    }
    public static void menuFaturacaoPresentes(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Intervencao> listaIntervencoes, ArrayList<Data> listaDatas){
        int op = 0;
        do{
            System.out.println("---------Menu---------");
            System.out.println("1-Listar por tipo de Intervenção");
            System.out.println("2-Listar por Animal");
            System.out.println("3-Listar por Cliente ");
            System.out.println("0-Sair");
            op= sc.nextInt();
            switch (op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("\nVoltando ao menu\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(op != 0);
    }
    public static void menuFaturacaoPassadas(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Intervencao> listaIntervencoes, ArrayList<Data> listaDatas){
        int op = 0;
        do{
            System.out.println("---------Menu---------");
            System.out.println("1-Listar por tipo de Intervenção");
            System.out.println("2-Listar por Animal");
            System.out.println("3-Listar por Cliente ");
            System.out.println("0-Sair");
            op= sc.nextInt();
            switch (op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("\nVoltando ao menu\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(op != 0);
    }

    public static void menuFaturacao(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Intervencao> listaIntervencoes, ArrayList<Data> listaDatas){
        int op = 0;
        do{
            System.out.println("---------Menu---------");
            System.out.println("1-Faturações Passadas");
            System.out.println("2-Faturações Presentes(Hoje)");
            System.out.println("3-Faturações Futuras");
            System.out.println("0-Sair");
            op= sc.nextInt();
            switch (op){
                case 1:
                    menuFaturacaoPassadas(listaAnimal,listaClientes,listaVeterinarios,listaIntervencoes,listaDatas);
                    break;
                case 2:
                    menuFaturacaoPresentes(listaAnimal,listaClientes,listaVeterinarios,listaIntervencoes,listaDatas);
                    break;
                case 3:
                    menuFaturacaoFuturas(listaAnimal,listaClientes,listaVeterinarios,listaIntervencoes,listaDatas);
                    break;
                case 0:
                    System.out.println("\nVoltando ao menu\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(op != 0);
    }


  public static void menuAnimal(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Intervencao> listaIntervencoes, ArrayList<Data> listaData){
        int op = 0;
        do{
            System.out.println("---------Menu---------");
            System.out.println("1- Adicionar Animal");
            System.out.println("2- Listar Animais");
            System.out.println("3- Listar Intervenções do Animal");
            System.out.println("4- Remover Animal");
            System.out.println("0- Voltar");
            System.out.println("----------------------");
            System.out.println("Opção: ");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro válido.");
                sc.next();
            }
            op = sc.nextInt();
            switch(op){
                case 1:
                    Gestor.criarAnimal( listaAnimal, listaClientes);
                    break;
                case 2:
                    Gestor.listarAnimais(listaAnimal);
                    break;
                case 3:
                    if(listaIntervencoes.size()==0){
                        System.out.println("\nErro: Não existem intervenções.\n");
                        break;
                    }
                    do{
                        op = 0;
                        System.out.println("Que intervenções deseja listar?");
                        System.out.println("1- Passadas");
                        System.out.println("2- Hoje");
                        System.out.println("3- Futuras");
                        System.out.println("4- Todas");
                        System.out.println("0- Voltar\n");
                        System.out.println("Opção:");
                        while (!sc.hasNextInt()) {
                            System.out.println("Por favor, insira um número inteiro válido.");
                            sc.next();
                        }
                        op = sc.nextInt();
                        sc.nextLine();
                        switch (op){
                            case 1:
                                Gestor.listarIntervencoesAnimalPassadas(listaIntervencoes,listaClientes,listaAnimal,listaData);
                                break;
                            case 2:
                                Gestor.listarIntervencoesAnimalHoje(listaIntervencoes,listaClientes,listaAnimal, listaData);
                                break;
                            case 3:
                                Gestor.listarIntervencoesAnimalFuturas(listaIntervencoes,listaClientes,listaAnimal, listaData);
                                break;
                            case 4:
                                Gestor.listarIntervencoesAnimal(listaIntervencoes,listaAnimal,listaClientes);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    }while(op != 0 && op != 1 && op != 2 && op != 3 && op != 4);
                    break;
                case 4:
                    Gestor.RemoverAnimal(listaAnimal,listaClientes);
                    break;
                case 0:
                    System.out.println("\nA voltar...\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(op != 0);
    }
    public static void menuIntervencao(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Intervencao> listaIntervencoes, ArrayList<Data> listaData){
        int op = 0;
        do {
            System.out.println("---------Menu---------");
            System.out.println("1- Agendar Intervenção");
            System.out.println("2- Listar Intervenções");
            System.out.println("3- Listar Intervenções(c/Data)");
            System.out.println("0- Sair");
            System.out.println("----------------------");
            System.out.print("Opção: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    Gestor.addIntervencao(listaIntervencoes,listaClientes,listaVeterinarios,listaAnimal,listaData);
                    break;
                case 2:
                    Gestor.ListarIntervencoes(listaIntervencoes);
                    break;
                case 3:
                    Gestor.ListarIntervencoesData(listaIntervencoes,listaData);
                    break;
                case 0:
                    System.out.println("\nA voltar...\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }


        } while (op != 0) ;
    }

    public static void menuVeterinario(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Intervencao> listaIntervencoes, ArrayList<Data> listaDatas){
        int op = 0;
        do{
            System.out.println("---------Menu---------");
            System.out.println("1- Adicionar Veterinario");
            System.out.println("2- Listar Veterinarios");
            System.out.println("3- Listar Intervenções do Veterinario");
            System.out.println("4- Listar Animais do Veterinario");
            System.out.println("5- Listar Clientes do Veterinario");
            System.out.println("6- Remover Veterinario");
            System.out.println("0- Sair");
            System.out.println("----------------------");
            System.out.println("Opção: ");
            op = sc.nextInt();
            switch(op){
                case 1:
                    Gestor.CriarVeterinario(listaVeterinarios);
                    break;
                case 2:
                    Gestor.ListarVeterinarios(listaVeterinarios);
                    break;
                case 3:
                    Gestor.ListarIntervencoesVeterinario(listaVeterinarios);
                    break;
                case 4:
                    Gestor.ListarAnimaisVeterinario(listaVeterinarios,listaIntervencoes);
                    break;
                case 5:
                    Gestor.ListarClientesVeterinario(listaVeterinarios,listaIntervencoes);
                    break;
                case 6:
                    Gestor.removerVeterinario(listaVeterinarios);
                    break;
                case 0:
                    System.out.println("\nA voltar...\n");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(op != 0);
    }
    public static void menuPrincipal(ArrayList<Animal> listaAnimal, ArrayList<Cliente> listaClientes, ArrayList<Veterinario> listaVeterinarios, ArrayList<Intervencao> listaIntervencoes, ArrayList<Data> listaDatas){
        int op = 0;

        do {
            System.out.println("---------Menu---------");
            System.out.println("1- Animal");
            System.out.println("2- Cliente");
            System.out.println("3- Veterinario");
            System.out.println("4- Intervencao");
            System.out.println("5- Faturas");
            System.out.println("0- Sair");
            System.out.println("----------------------");
            System.out.println("Opção: ");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, insira um número inteiro válido.");
                sc.next();
            }

            op = sc.nextInt();
            switch (op) {
                case 1:
                    menuAnimal(listaAnimal, listaClientes, listaVeterinarios, listaIntervencoes, listaDatas);
                    break;
                case 2:
                    menuCliente(listaAnimal, listaClientes, listaVeterinarios, listaIntervencoes);
                    break;
                case 3:
                    menuVeterinario(listaAnimal, listaClientes, listaVeterinarios, listaIntervencoes, listaDatas);
                    break;
                case 4:
                    menuIntervencao(listaAnimal, listaClientes, listaVeterinarios, listaIntervencoes, listaDatas);
                    break;
                case 5:
                    menuFaturacao(listaAnimal, listaClientes, listaVeterinarios, listaIntervencoes, listaDatas);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (op != 0);


    }



}




