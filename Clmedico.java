package POO.Projeto_1;
import java.util.Scanner;

public class Clmedico {
    Scanner scan = new Scanner(System.in);
    private String nomedr;
    private int h_cons, qt_cons = 0, cons_f = 0;
    Consulta []listcons = new Consulta[0];

    public Clmedico(String name, int disp){
        this.nomedr = name;
        this.h_cons = disp;
        this.listcons = updateMax(listcons, disp);
    }

    Consulta[] updateMax(Consulta[] list, int tam){
        Consulta []newTam = new Consulta[tam];
        return newTam;
    }

    void addCons(){
        if (h_cons == qt_cons){
            System.out.println("Sem Horarios Disponiveis");
            return;
        }
        int dia, mes, ano, pacage;
        String pacname, pacond, topc;
        System.out.println("Insira a data da consulta\nDia: ");
        dia = scan.nextInt();
        System.out.println("Mes: ");
        mes = scan.nextInt();
        System.out.println("Ano: ");
        ano = scan.nextInt();
        scan.nextLine();
        System.out.println("O nome do paciente: ");
        pacname = scan.nextLine();
        System.out.println("Idade do paciente: ");
        pacage = scan.nextInt();
        scan.nextLine();
        System.out.println("Condições atuais do paciente:");
        pacond = scan.nextLine();
        System.out.println("O topico da consulta: ");
        topc = scan.nextLine();
        ClPaciente pac = new ClPaciente(pacname, pacage, pacond);
        Consulta cons = new Consulta (dia, mes, ano, topc, pac);
        listcons[qt_cons] = cons;
        qt_cons++;
        System.out.println("Consulta Agendada!!\n");
    }

    void showMed(int id){
        id += 1;
        System.out.println("Médico " + (id) + "- " + nomedr);
    }

    void listMed(int id){
        id += 1;
        System.out.println("Médico " + (id) + "- " + nomedr + ";\n" + cons_f + " finalizadas e " + (h_cons-qt_cons) + " Horarios livres\n");
    }

    void searchPac(int src){
        int i = 0;
        while (i < qt_cons){
            if (i == src){
                System.out.println("Paciente encontrado!!");
                listcons[i].showPac();
                return;
            }
            i++;
        }
        if (i >= qt_cons){
            System.out.println("Paciente não encontrado...");
        }
    }

    void remMed(){
        for (int i = 0; i < qt_cons; i++){
            this.listcons[i] = null;
        } 
        this.nomedr = " ";
        this.h_cons = 0;
        this.qt_cons = 0;
        this.cons_f = 0;
    }

    void showConsul(int id){
        id += 1;
        System.out.println("Médico "+ id +":");
        for (int i = 0; i < qt_cons; i++){
            listcons[i].showCons(i);
            System.out.println("\n");
        }
    }

    void showConsComp(){
        int j;
        for (int i = 0; i < qt_cons; i++){
            j = listcons[i].verStatus();
            if (j == 0){
                listcons[i].showCons(i);
            }
        }
    }

    void finCons(int s){
        listcons[s].chStatus();
        cons_f++;
    }

    int getFins(){
        return cons_f;
    }
}