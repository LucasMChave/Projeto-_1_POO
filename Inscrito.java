package POO.Projeto_1;

public class Inscrito {
    private String nomeIns;
    private int idadeIns, tpIns, daysIns, ID;

    public Inscrito(String nom, int age, int tipo, int datas, int qtd){
        this.nomeIns = nom;
        this.idadeIns = age;
        this.tpIns = tipo;
        this.daysIns = datas;
        this.ID = qtd+1;
    }

    void showcase(){
        if (this.tpIns == 1){
            System.out.print("> Inscrito "+ this.ID +": " + this.nomeIns +"\n-Idade: "+ this.idadeIns +"\n-Ingresso: Meia");
            if (daysIns == 1){
                System.out.println(" para Sabado\n");
            }
            else if(daysIns == 2){
                System.out.println(" para Domingo\n");
            }        
            else{
                System.out.println(" para ambos Sabado e Domingo\n");
            }     
        }
        else{
            System.out.print("> Inscrito "+ this.ID +": " + this.nomeIns +"\n-Idade: "+ this.idadeIns +"\n-Ingresso: Inteira");
            if (daysIns == 1){
                System.out.println(" para Sabado\n");
            }
            else if(daysIns == 2){
                System.out.println(" para Domingo\n");
            }        
            else{
                System.out.println(" para ambos Sabado e Domingo\n");
            }    
        }
    }
}
