package POO.Projeto_1;

public class Evento {
    private String nomeEvn;
    private String nomeAtr[] = new String [10];
    private int qtAtr = 0;
    private int qtmaxAtr[] = new int [10];

    public Evento(String nome){
        this.nomeEvn = nome;
    }

    int vermax(){
        if (qtAtr == 10){
            return 1;
        }
        else{
            return 0;
        }
    }

    void addatr(String atr, int qtmax){
        nomeAtr[this.qtAtr] = atr;
        qtmaxAtr[this.qtAtr] = qtmax;
        qtAtr++;
    }

    void remAtr(int ID){
        ID -= 1;
        if (ID == this.qtAtr){    
            nomeAtr[this.qtAtr] = " ";
            qtmaxAtr[this.qtAtr] = 0;
            qtAtr--;
            System.out.println("Atração Removida");
        }
        else if (ID < this.qtAtr){
            for (int i = ID; i < qtAtr; i++){
                nomeAtr[i] = nomeAtr[i+1];
                qtmaxAtr[i] = qtmaxAtr[i+1];
            }
            nomeAtr[this.qtAtr] = " ";
            qtmaxAtr[this.qtAtr] = 0;
            qtAtr--;
            System.out.println("Atração Removida");
        }
        else{
            System.out.println("Atração invalida");
        }
    }

    void showAtr(){
        int i = 0;
        System.out.println("Lista de atrações:");
        while (i < this.qtAtr){
            System.out.println((i+1) + " - " + nomeAtr[i] +"\t Limite de inscritos: " + qtmaxAtr[i]);
            i++;
        }
    }

    int getAtr(){
        return qtAtr;
    }

    String getNome(){
        return nomeEvn;
    }
}
