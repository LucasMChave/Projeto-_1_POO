package POO.Projeto_1;

public class Consulta {
    private int status = 1, day, mon, yr;
    private String topic;
    ClPaciente paciente;

    public Consulta(int d, int m, int y, String tpc, ClPaciente pac){
        this.day = d;
        this.mon = m;
        this.yr = y;
        this.topic = tpc;
        this.paciente = pac;
    }

    void chDate (int d, int m, int y){
        this.day = d;
        this.mon = m;
        this.yr = y;
    }

    void chStatus(){
        System.out.println("Consulta finalizada");
        this.status = 0;
    }

    int verStatus(){
        return status;
    }

    void showCons(int id){
        String nome = paciente.getName();
        System.out.println("|Consulta " + id+1 +"|\nPaciente: " +nome +"\nData: "+ day + "/" + mon + "/" + yr + "\nAssunto: " + topic);
    }

    void showPac(){
        paciente.showPac();
    }

    String getName(){
        String nom;
        nom = paciente.getName();
        return nom;
    }
}