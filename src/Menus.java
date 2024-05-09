import java.util.Scanner;

public class Menus {
    public static Scanner sc = new Scanner(System.in);

    public static void  menuCliente() {
        int op = 0;
        do {
            System.out.println("---------Menu---------");
            System.out.println("1- Criar Cliente");
            System.out.println("2- Remover Cliente");
            System.out.println("3- Listar Cliente");
            System.out.println("4-Listar Animais do Cliente");
            System.out.println("0- Sair");
            System.out.println("----------------------");
            System.out.print("Opção: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    CriarCliente();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }


        } while (op != 0) ;
    }


  public static void menuAnimal(){
        int op = 0;
        do{
            System.out.println("---------Menu---------");
            System.out.println("1- Adicionar Animal");
            System.out.println("2- Listar Animais");
            System.out.println("3- Listar Intervenções do Animal");
            System.out.println("4- Remover Animal");
            System.out.println("0- Sair");
            System.out.println("----------------------");
            System.out.println("Opção: ");
            op = sc.nextInt();
            switch(op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(op != 0);
    }
    public static void menuIntervencao() {
        int op = 0;
        do {
            System.out.println("---------Menu---------");
            System.out.println("1- Agendar Intervenção");
            System.out.println("2- Listar Intervenções(Data)");
            System.out.println("3- Listar Intervenções(Veterinário)");
            System.out.println("4- Listar Intervenções(Veterinário+Data)");
            System.out.println("5- Listar Intervenções(Animal Passadas)");
            System.out.println("6- Listar Intervenções(Animal Hoje)");
            System.out.println("7- Listar Intervenções(Animal Futuras)");
            System.out.println("8- Listar Intervenções(Animal)");
            System.out.println("0- Sair");
            System.out.println("----------------------");
            System.out.print("Opção: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }


        } while (op != 0) ;
    }

    public static void menuVeterinario(){
        int op = 0;
        do{
            System.out.println("---------Menu---------");
            System.out.println("1- Adicionar Veterinario");
            System.out.println("2- Listar Veterinarios");
            System.out.println("3- Listar Intervenções do Veterinario");
            System.out.println("5- Listar Animais do Veterinario");
            System.out.println("6- Listar Clientes do Veterinario");
            System.out.println("4- Remover Veterinario");
            System.out.println("0- Sair");
            System.out.println("----------------------");
            System.out.println("Opção: ");
            op = sc.nextInt();
            switch(op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while(op != 0);
    }
    public static void menuPrincipal() {
        int op = 0;

        do {
            System.out.println("---------Menu---------");
            System.out.println("1- Animal");
            System.out.println("2- Cliente");
            System.out.println("3- Veterinario");
            System.out.println("4- Intervencao");
            System.out.println("0- Sair");
            System.out.println("----------------------");
            System.out.println("Opção: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    menuAnimal();
                    break;
                case 2:
                    menuCliente();
                    break;
                case 3:
                    menuVeterinario();
                    break;
                case 4:
                    menuIntervencao();
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

    void CriarCliente(){
        String nome;
        int NIF;
        int contacto;
        while (nome.noisEme.nome.IsemptyisEmpty()) {
        }
        }

    }



}




