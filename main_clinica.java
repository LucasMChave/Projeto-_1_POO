package POO.Projeto_1;
import java.util.Scanner;

public class main_clinica {
    public void executar(){
        Scanner scan = new Scanner(System.in);
        int opc = -1;
        int qtmax, hors;
        String nomeClin, nomeDr;


        System.out.println("Bem vindo ao nosso programa de manejamento de consultas de uma clinica.\nVamos inciar criando um registro em nossa database\nPrimeiramente qual nome de sua clinica?");
        nomeClin = scan.nextLine();
        System.out.println("Quantos medicos sua clinica pode hospedar?");
        qtmax = scan.nextInt();
        scan.nextLine();
        System.out.println("Adicionemos o registro de um medico na clinica\nNome do Medico: ");
        nomeDr = scan.nextLine();
        System.out.println("Para quantas consultas que ele(a) está disponivel?");
        hors = scan.nextInt();
        scan.nextLine();
        Clinica clin = new Clinica(nomeClin, qtmax);
        Clmedico newMedico = new Clmedico(nomeDr, hors);
        Clmedico []listMedicos = new Clmedico[qtmax];
        listMedicos[0] = newMedico;
        
        clin.showNome();
        System.out.print(" | Clinica Registrada, Iniciemos Operações");

        while (opc != 0){
            System.out.println("\n1- Manejar Medicos e Consultas;\n2- Dados dos Pacientes;\n3- Mostrar Relatorio de Consultas Realizadas;\n0- Finalizar Programa;");
            opc = scan.nextInt();
            switch(opc){
                case 1:
                    clin.manMedicos(listMedicos);
                    break;
                case 2:
                    clin.manPac(listMedicos);
                    break;
                case 3:
                    clin.showRep(listMedicos);
                    break;
                case 0:
                    System.out.println("\nObrigado por utilizar de nossos serviços!!\nFinalizando operação...");
                    break;
                default:
                    System.out.println("Insira uma opção valida:");
                    opc = scan.nextInt();
                    scan.nextLine();
            }
        }
    }
}
