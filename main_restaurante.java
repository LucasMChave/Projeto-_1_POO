package POO.Projeto_1;
import java.util.Scanner;

public class main_restaurante {
    public void executar(){
        Scanner scan = new Scanner(System.in);
        int opc = -1, res = 0, qtRes = 0, mes;
        int ct_cm = 0, ct_al = 0 , ct_jan = 0;
        String cupon;
        mesa listamesas[] = new mesa[100];

        System.out.println("Seja bem vindo ao Restaurante Savore di Classe. Famigerado Restaurante Gourmet 5 Estrelas com 100 Reservas Exclusivas\nAceitamos reservas e disponilizamos Café da Manhã, Almoço e Jantar");
        while (opc != 0){
            System.out.print("\n1- Reservar nova mesa;\n2- Ler Cardapio Online");
            if (res == 1){
                System.out.print("\n3- Reservar Pedido;\n4- Usar Cupon de Desconto;\n5- Fechar Conta de mesa;\n6- Gerar Relatorio de Vendas;");
            }
            System.out.print("\n0- Finalizar programa;\n\n");
            opc = scan.nextInt();
            scan.nextLine(); 
            switch(opc){
                case 1:
                    if (qtRes == 100){
                        System.out.println("Restaurante Lotado, sem vagas livres.\n");
                    }
                    int qt, tmp, tp;
                    System.out.println("Mesa para quantas pessoas?\nOferecemos discontos de 10% se acima de 10 pessoas (MAX: 20);\n(aperte 0 para cancelar a qualquer momento)\n\n");
                    qt = scan.nextInt();
                    scan.nextLine();
                    while(qt > 20){
                        System.out.println("Acima do limite por mesa, por favor insira uma quantidade menor");
                        qt = scan.nextInt();
                        scan.nextLine();
                    }
                    if (qt <= 0){
                        break;
                    }
                    System.out.println("Para que Horario que a mesa deve ser reservada?\n1- Café da Manhã\n2- Almoço\n3- Jantar\n");
                    tmp = scan.nextInt();
                    scan.nextLine();
                    while(tmp > 3){
                        System.out.println("Insira um Horario valido");
                        qt = scan.nextInt();
                        scan.nextLine();
                    }
                    if (tmp <= 0){
                        break;
                    }
                    else if (tmp == 1){
                        ct_cm++;
                    }
                    else if (tmp == 2){
                        ct_al++;
                    }
                    else if (tmp == 3){
                        ct_jan++;
                    }
                    System.out.println("Temos o serviço 'Seção especial Gourmet', que garante atendimento imediato de nossos garçons privados e profissionais, gostaria de assinar ele  para sua reserva? (A conta aumentará em 20%)\n1- Sim\n2- Não");
                    tp = scan.nextInt();
                    scan.nextLine();
                    if (tp <= 0){
                        break;
                    }
                    mesa reserva = new mesa(qt, tmp, tp);
                    listamesas[qtRes] = reserva;
                    res = 1;
                    qtRes++;
                    break;
                case 2:
                    System.out.println("Qual Horaio que gostaria de ver o cardapio?\n1- Café da Manhã\n2- Almoço\n3- Jantar\n0- Voltar");
                    mitenpedido.exibirCardapio(0);
                    break;
                case 3:
                    System.out.println("Insira qual mesa fará o pedido (ou 0 pra retornar):");
                    for (int j = 0; j < qtRes; j++){
                        listamesas[j].listMesas(j);
                    }
                    mes = scan.nextInt();
                    scan.nextLine();
                    while (mes > qtRes || mes < 0){
                        System.out.println("Mesa não encontrada, insira um valor valido(ou 0 pra retornar):");
                        mes = scan.nextInt();
                        scan.nextLine();
                    }
                    if (mes == 0){
                        break;
                    }
                    listamesas[mes-1].relPedido();
                    break;
                case 4:
                    System.out.println("Insira o cupon de desconto (5 LETRAS MAIUSCULAS): ");
                    cupon = scan.nextLine();
                    System.out.println("Insira a mesa para aplicar o desconto: ");
                    for (int j = 0; j < qtRes; j++){
                        listamesas[j].listMesas(j);
                    }
                    mes = scan.nextInt();
                    scan.nextLine();
                    while (mes > qtRes || mes < 0){
                        System.out.println("Mesa não encontrada, insira um valor valido(ou 0 pra retornar):");
                        mes = scan.nextInt();
                        scan.nextLine();
                    }
                    if (mes == 0){
                        break;
                    }
                    listamesas[mes-1].aplCupon(cupon);
                    break;
                case 5:
                    System.out.println("Insira a mesa para fechar a conta:");
                    for (int j = 0; j < qtRes; j++){
                        listamesas[j].listMesas(j);
                    }
                    mes = scan.nextInt();
                    scan.nextLine();
                    while (mes > qtRes || mes < 0){
                        System.out.println("Mesa não encontrada, insira um numero valido(ou 0 pra retornar):");
                        mes = scan.nextInt();
                        scan.nextLine();
                    }
                    if (mes == 0){
                        break;
                    }
                    listamesas[mes-1].remMesa();
                    listamesas[mes-1] = null;
                    if(mes < qtRes){
                        int i = mes;
                        while (i < qtRes){
                            listamesas[mes-1] = listamesas[mes];
                            i++;
                        }
                    }
                    qtRes--;
                    if (qtRes == 0){
                        res = 0;
                    } 
                    System.out.println("Conta fechada");
                    break;
                case 6:
                    double total = 0.0;
                    for (int i = 0; i < qtRes; i++){
                        total = listamesas[i].getContaS();
                    }
                    int ct_total = (ct_cm + ct_al + ct_jan);
                    System.out.println("Lucro total do Restaurante: " + String.format("%.2f", total) + "\nNumero de reservas por Horario:\n- Café da manhã: " + ct_cm + " com " + mitenpedido.cp_cm + "vendas\n- Almoço: "+ ct_al + " com " + mitenpedido.cp_al + "vendas\n- Jantar: "+ ct_jan + "com " + mitenpedido.cp_jan + " vendas\n- Total: " + ct_total + " Vendas Totais: " + mitenpedido.cpt);
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
