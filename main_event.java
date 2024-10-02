package POO.Projeto_1;
import java.util.Scanner;

public class main_event {
    public static Inscrito[] copylist(Inscrito list[], int max, int curt){
        Inscrito []newuser = new Inscrito [max];
        for (int i = 0; i < curt; i++){
            newuser[i] = list[i];
        }
        return newuser;
    }
    
    public void executar(){
        Scanner scan = new Scanner(System.in);
        int opc = -1, opc2 = -1, num = 0, qtd = 0, newnum = 0;
        int age, type, days, max, srch, cont, Natr, Ninsc, Nmax;
        String event, atr, currAdd, nomeE, nomeInsc, nomeLoc;


        System.out.println("Bem vindo ao nosso programa de manejamento de eventos. Antes de iniciar iremos requizitar alguns dados\nIniciemos com o Nome do evento: ");
        event = scan.nextLine();
        Evento evento = new Evento(event);
        System.out.println("Insira o local onde o evento será hospedado:");
        String end = scan.nextLine();
        Local venue = new Local(end);
        System.out.println("Insira a quantidade de Inscritos MÁXIMO que o local permite: ");
        num = scan.nextInt();
        venue.limitar(num);
        Inscrito []user = new Inscrito [num]; 
        
        System.out.println("Perfeito!! Agora podemos iniciar proseguir com nossas operações!!");
        while(opc != 0){
            System.out.println("\n1- Manejar Evento\n2- Manejar Inscritos\n3- Manejar local de evento\n0- Finalizar Programa");
            opc = scan.nextInt();
            scan.nextLine();
            switch(opc){
                case 1:
                    while (opc == 1){
                        System.out.println("\n|Manegamento do Evento|\n\n1- Adicionar Atração (MAX = 10)\n2- Remover Atração\n3- Gerar Relatorio\n0- Voltar");
                        opc2 = scan.nextInt();
                        scan.nextLine();
                        switch(opc2){
                            case 1:
                                if (evento.vermax() == 1){
                                    System.out.println("Alcançamos o maximo de atrações possiveis, remova uma antes de adicionar.");
                                    break;
                                }
                                System.out.println("Insira o nome de uma atração nova: ");
                                atr = scan.nextLine();
                                System.out.println("Insira o maximo de possiveis inscritos para a atração: ");
                                max = scan.nextInt();
                                evento.addatr(atr, max);
                                System.out.println("Nova atração adicionada");
                                break;
                            case 2:
                                System.out.println("Insira qual atração remover:");
                                evento.showAtr();
                                srch = scan.nextInt();
                                evento.remAtr(srch);
                                break;
                            case 3:
                                nomeE = evento.getNome();
                                Natr = evento.getAtr();
                                nomeLoc = venue.getNome();
                                Ninsc = venue.getAtual();
                                Nmax = venue.getMax();
                                System.out.println("|"+ nomeE +"|\nEndereço: " + nomeLoc + "\nNos temos atualmente "+ Ninsc +" (Max:"+ Nmax + ") totais paricipantes no evento e "+ Natr +" atrações confirmadas");
                                if (Natr > 0){
                                    evento.showAtr();    
                                }
                                break;
                            case 0:
                                opc = -1;
                                break;
                            default:
                                System.out.println("Insira uma opção valida");
                                opc = scan.nextInt();
                                scan.nextLine();
                        }
                    }
                    break;
                case 2:
                    while (opc == 2){
                        System.out.println("\n|Manegamento de Inscritos|\n\n1- Adicionar Inscrito\n2- Listar inscritos\n0- Voltar"); 
                        opc2 = scan.nextInt();
                        scan.nextLine();
                        switch(opc2){
                            case 1:
                                if (venue.verLot() == 1){
                                    System.out.println("Capacidade máxima alcançada, não será possivel adição de inscritos");
                                    break;
                                }
                                System.out.println("Insira o nome do inscrito:");
                                nomeInsc = scan.nextLine();
                                System.out.println("A idade do inscrito: ");
                                age = scan.nextInt(); 
                                if (age >= 18){
                                    System.out.println("Insira o tipo de Entrada do inscrito\n 1- Meia / 2- Inteira ");
                                    type = scan.nextInt();
                                }
                                else{
                                    System.out.println("Menor que 18 = meia entrada");
                                    type = 1;
                                }
                                System.out.println("Insira quais dias ele estará no evento\n1- Sabado / 2- Domingo / 3- Ambos ");
                                days = scan.nextInt();
                                Inscrito new_user = new Inscrito(nomeInsc, age, type, days, qtd);
                                user[qtd] = new_user;
                                qtd++;
                                venue.adicionar();
                                System.out.println("Participante adicionado");
                                break;
                            case 2:
                                System.out.println("Lista de Inscritos:");
                                for (int i = 0; i < qtd; i++){
                                    user[i].showcase();
                                }
                                break;
                            case 0:
                                opc = -1;
                                break;
                            default:
                                System.out.println("Insira uma opção valida");
                                opc2 = scan.nextInt();
                                scan.nextLine();
                            }
                        }
                case 3:
                    while(opc == 3){
                        System.out.println("\n|Manegamento de Local|\n\n1- Modificar Local do Evento\n2- Verificar Lotação\n3- Atualizar limite de lotação\n0- Voltar");
                        opc2 = scan.nextInt();
                        scan.nextLine();
                        switch(opc2){
                            case 1:
                                currAdd = venue.getNome();
                                System.out.println("Endereçoa atual: "+ currAdd +"\nInsira o novo endereço do evento:");
                                String newname = scan.nextLine();
                                venue.setNome(newname);
                                break;
                            case 2:
                                if (venue.verLot() == 1){
                                    System.out.println("O local está lotado, chegamos na capacidade maxima de inscritos");
                                }
                                else{
                                    Ninsc = venue.getAtual();
                                    Nmax = venue.getMax();
                                    int resto = (Nmax - Ninsc);
                                    System.out.println("O local não está lotado, temos "+ resto +" vagas disponiveis");
                                }
                                break;
                            case 3:
                                System.out.println("Insira o novo maximo de participantes no evento");
                                newnum = scan.nextInt();
                                while (newnum < num){
                                    System.out.println("O Maximo atual não pode ser menor q o maximo anterior, insira uma opção valida (ou aperte 0 pra cancelar):");
                                    newnum = scan.nextInt();
                                    if (newnum == 0){
                                        break;
                                    }
                                }
                                venue.limitar(newnum);
                                cont = venue.getAtual();
                                user = copylist(user, newnum, cont);
                                num = newnum;
                                break;
                            case 0:
                                opc = -1;
                                break;
                            default:
                                System.out.println("Insira uma opção valida");
                                opc = scan.nextInt();
                                scan.nextLine();
                                break;
                            }
                        }
                    break;
                case 0:
                    System.out.println("\nObrigado por utilizar de nossos serviços!!\nFinalizando operação...");
                    break;
                default:
                    System.out.println("Insira uma opção valida");
                    opc = scan.nextInt();
                    scan.nextLine();
            }
        }
    }
}