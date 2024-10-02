package POO.Projeto_1;

import java.util.Scanner;

public class Clinica {
    Scanner scan = new Scanner(System.in);
    private int qtDrs = 0, qtmax;
    private String nomeClin;

    public Clinica(String n, int max){
        this.nomeClin = n;
        this.qtmax = max;
        qtDrs++;
    }

    void showNome(){
        System.out.println(nomeClin);
    }

    void setNome(String name){
        this.nomeClin = name;
    }

    void manMedicos(Clmedico list[]){
        Clmedico newMedico;
        String nome;
        int opc = -1, hors;
        while (opc != 0){
            System.out.println("\n1- Adicionar Médico(a);\n2- Remover medico da lista;\n3- Listar Medicos;\n4- Agendar Consulta;\n5- Realizar Consulta;\n0- Voltar;\n");
            opc = scan.nextInt();
            scan.nextLine();
            switch (opc){
                case 1:
                    if (qtDrs == qtmax){
                        System.out.println("Maximo de capacidade do local, remova um médico antes de adicionar outro.");
                        break;
                    }
                    System.out.println("Adicionemos o registro de um médico(a) na clinica\nNome do Médico(a): ");
                    nome = scan.nextLine();
                    System.out.println("Para quantas consultas que ele(a) está disponivel?");
                    hors = scan.nextInt();
                    scan.nextLine(); 
                    newMedico = new Clmedico(nome, hors);
                    list[qtDrs] = newMedico;
                    qtDrs++;
                    break;
                case 2:
                    int rem;
                    System.out.println("Insira qual remover:\n[IMPORTANTE]: Remover o medico irá remover seus pacientes e consultas\n\n");
                    for (int i = 0; i < qtDrs; i++){
                        list[i].showMed(i);
                    }
                    rem = scan.nextInt();
                    scan.nextLine();
                    remMed(list, rem-1);
                    System.out.println("Médico(a) removido(a).");
                    break;
                case 3:
                    for (int i = 0; i < qtDrs; i++){
                        list[i].listMed(i);
                    }
                    break;
                case 4:
                    int src;
                    System.out.println("Escolha o medico que dedseja agendar: ");
                    for (int i = 0; i < qtDrs; i++){
                        list[i].showMed(i);
                    }
                    src = scan.nextInt();
                    scan.nextLine();
                    list[src-1].addCons();
                    break;
                case 5:
                    int src_m, src_c;
                    System.out.println("Insira o médico e a consulta a ser realizada:");
                    for (int i = 0; i < qtDrs; i++){
                        list[i].showConsul(i);
                    }
                    src_m = scan.nextInt();
                    src_c = scan.nextInt();
                    scan.nextLine();
                    list[src_m-1].finCons(src_c-1);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Insira uma opção valida:");
                    opc = scan.nextInt();
                    scan.nextLine();
            }
        }
    }

    void remMed(Clmedico[] lista, int ID){
        for (int i = 0; i < qtDrs; i++){
            if (i == ID){
                lista[i].remMed();
                int j = i;
                while (j < qtDrs-1){
                    lista[j] = lista[j+1];
                    j++;
                }
                break;
            }
        }
        lista[qtDrs-1] = null;
        qtDrs--;
    }

    void manPac(Clmedico list[]){
        int src, src_pac;
        System.out.println("Qual medico está atendendo o paciente?");
        for (int i = 0; i < qtDrs; i++){
            list[i].showMed(i);
        }
        src = scan.nextInt();
        scan.nextLine();
        System.out.println("Insira o numero da consulta do paciente");
        src_pac = scan.nextInt();
        scan.nextLine();
        list[src-1].searchPac(src_pac-1);
    }

    void showRep(Clmedico list[]){
        System.out.println("Consultas realizadas: ");
        for (int i = 0; i < qtDrs; i++){
            list[i].showConsComp();
        }
    }
}
