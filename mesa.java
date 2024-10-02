package POO.Projeto_1;
import java.util.Scanner;

public class mesa {
    Scanner scan = new Scanner(System.in);
    private int qtp, tp_ref, tp_mes, disc = 0, p_real;
    private double conta;
    private mpedido pedido;

    public mesa(int qpd, int tp, int tpm){
        this.qtp = qpd;
        this.tp_ref = tp;
        this.tp_mes = tpm;
    }

    void relPedido(){
        if (p_real == 1){
            System.out.println("Pedido já realizado");
            return;
        }
        int qtped;
        System.out.println("Insira quantos pratos diferentes sua mesa terá?");
        qtped = scan.nextInt();
        mpedido ped = new mpedido(qtped, disc);
        mitenpedido.exibirCardapio(tp_ref);
        ped.addPedidos();
        System.out.println("Pedido Finalizado!!\n");
        pedido = ped;
        p_real = 1;
    }

    void aplCupon(String c){
        System.out.println(c);
        if ((c == "ANTON") || (c == "EMILE") || (c == "LOUIE") || (c == "ITALY") || (c == "JAV<3") || (c == "AMIGO") || (c == "LUCAS")){
            disc = 1;
        }
        else{
            System.out.println("Cupon Invalido :c");
        }
    }

    void listMesas(int id){
        id += 1;
        if (tp_mes == 1){
            if(tp_ref == 1){
                System.out.println("Mesa "+id+": "+qtp+" pessoas Reservada com serviço Gourmet para Café da Manhã");
            }
            else if(tp_ref == 2){
                System.out.println("Mesa "+id+": "+qtp+" pessoas Reservada com serviço Gourmet para Almoço");
            }
            else{
                System.out.println("Mesa "+id+": "+qtp+" pessoas Reservada com serviço Gourmet para Jantar");
            }
        }
        else{
            if(tp_ref == 1){
                System.out.println("Mesa "+id+": "+qtp+" pessoas Reservada para Café da Manhã");
            }
            else if(tp_ref == 2){
                System.out.println("Mesa "+id+": "+qtp+" pessoas Reservada para Almoço");
            }
            else{
                System.out.println("Mesa "+id+": "+qtp+" pessoas Reservada para Jantar");
            }
        }
    }

    void remMesa(){
        conta = pedido.getConta(qtp, tp_mes);

        System.out.println("Conta final: " + String.format("%.2f", conta));
        for (int i = 0; i < qtp; i++){
            this.pedido = null;
        } 
        this.qtp = 0;
        this.tp_ref = 0;
        this.tp_mes = 0;
        this.disc = 0;
    }

    double getContaS(){
        return conta;
    }
}

