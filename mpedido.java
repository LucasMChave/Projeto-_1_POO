package POO.Projeto_1;
import java.util.Scanner;

public class mpedido {
    Scanner scan = new Scanner(System.in);
    private int n_pedidos, disc;
    private double money = 0.0;


    public mpedido(int np, int disc){
        this.n_pedidos = np;
        this.disc = disc;
    }

    void addPedidos(){
        int i = 0, ped;
        System.out.println("\nInsira seu(s) prato(s) desejado: ");
        while (i < n_pedidos){
            System.out.println("Pedido "+(i+1)+":");
            ped = scan.nextInt();
            System.out.println("\n");
            money = (money + mitenpedido.getPreco(ped));
            i++;
        }
        
    }
    
    double getConta(int qp, int vip){
        if (disc == 1){
            money *= 0.75;    
        }
        if (qp > 10){
            money *= 0.90;
        }
        if (vip == 1){
            money *= 1.20;
        }
        return money;
    }
}