package POO.Projeto_1;

public class ClPaciente {
    private String nomepc, cond;
    private int age;
    
    public ClPaciente(String name, int ida, String cond){
        this.nomepc = name;
        this.age = ida;
        this.cond = cond;
    }

    void showPac(){
        System.out.println("|" + nomepc + "|\nIdade: " + age + "\nAtual Condição: " + cond);
    }

    String getName(){
        return nomepc;
    }
}
