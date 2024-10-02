package POO.Projeto_1;

public class Local {
    private String address;
    private int qtInsc, qtMax;

    public Local(String nome){
        this.address = nome;
    }

    void limitar(int maximo){
        this.qtMax = maximo;
    }

    void adicionar(){
        this.qtInsc++;
    }

    int verLot(){
        if (qtMax == qtInsc){
            return 1;
        }
        else{
            return 0;
        }
    }
    String getNome(){
        return address;
    }

    void setNome(String nname){
        this.address = nname;
    }

    int getAtual(){
        return qtInsc;    
    }

    int getMax(){
        return qtMax;
    }
}
