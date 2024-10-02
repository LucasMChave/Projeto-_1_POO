package POO.Projeto_1;
import java.util.Scanner;

public class main_all {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int trueopc = -1;
        while (trueopc != 0){
            System.out.println("\nQual Sistema gostaria de utilizar?\n1- Manejamento da Database de uma Clinica\n2- Manejamento de Eventos\n3- Manejamento de Reservas e Compras em um restaurante\n0- Finalizar operações");
            trueopc = scanner.nextInt();
            scanner.nextLine();
            switch(trueopc){
                case 1:
                    main_clinica clinicaDatabase = new main_clinica();
                    clinicaDatabase.executar();
                    break;
                case 2:
                    main_event ManEvento = new main_event();
                    ManEvento.executar();
                    break;
                case 3:
                    main_restaurante RestReserv = new main_restaurante();
                    RestReserv.executar();
                    break;
                case 0:
                    System.out.println("|Espero que tenham gostado da apresentação!|\nTodos direitos do projeto acima pertencem a Lucas Mourato A. Melo");
                    break;
                default:
                    System.out.println("Insira uma opção valida");
            }
        }
        scanner.close();
    }
}