package POO.Projeto_1;
import java.util.Scanner;

public class mitenpedido {
    static Scanner scan = new Scanner(System.in);
    static int hor;
    static int cp_cm = 0, cp_al = 0, cp_jan = 0, cpt = 0;
    static void exibirCardapio(int def){
        hor = def;
        if (def == 0){
            hor = scan.nextInt();
            scan.nextLine();
        }
        while(hor > 3 || hor < 0){
            System.out.println("Insira um horario valido");
            hor = scan.nextInt();
            scan.nextLine();
        }
        if (hor == 1){
            System.out.println("\n\t\t|Café da Manhã|\n\t* Entradas:\n\n1) Tartine de abacate com ovo poché e rúcula - R$ 45,00\n2) Iogurte grego com granola artesanal, frutas vermelhas e mel de flor de laranjeira - R$ 38,00\n3) Mini croissants folhados com geleias caseiras e manteiga de fazenda - R$ 32,00\n");
            System.out.println("\t* Pratos Principais:\n\n4) Ovos beneditinos com salmão defumado e molho holandês - R$ 65,00\n5) Panquecas de ricota com raspas de limão siciliano, servidas com maple syrup e frutas frescas - R$ 52,00\n6) Omelete trufado com cogumelos selvagens e queijo brie - R$ 68,00\n");
            System.out.println("\t* Bebidas:\n\n7) Suco detox de espinafre, maçã verde e gengibre - R$ 28,00\n8) Smoothie de manga, maracujá e hortelã - R$ 30,00\n9) Café gourmet coado com grãos especiais da casa - R$ 25,00\n");
        }
        else if (hor == 2){
            System.out.println("\n\t\t|Almoço|\n\t* Entradas:\n\n1) Carpaccio de polvo com vinagrete de limão e azeite de ervas - R$ 75,00\n2) Creme de aspargos com azeite trufado e amêndoas tostadas - R$ 60,00\n3) Terrine de foie gras com chutney de figo e brioche tostado - R$ 85,00");
            System.out.println("\n\t* Pratos Principais:\n\n4) Risoto de lagosta com infusão de açafrão e queijo parmigiano-reggiano - R$ 160,00\n5) Filé de robalo grelhado com purê de batata-baroa, legumes salteados e molho beurre blanc - R$ 140,00\n6) Medalhão de filé mignon com crosta de ervas, acompanhado de batatas gratinadas e molho de vinho tinto - R$ 150,00");
            System.out.println("\n\t* Sobremesas:\n\n7) Tarte tatin de maçã caramelizada com sorvete de baunilha de Madagascar - R$ 55,00\n8) Fondant de chocolate belga com coração de frutas vermelhas - R$ 65,00\n9) Sorbet artesanal de limão siciliano com manjericão - R$ 45,00");
        }
        else if (hor == 3){
            System.out.println("\n\t\t|Jantar|\n\t* Entradas:\n\n1) Vieira grelhada com mousseline de couve-flor e caviar - R$ 130,00\n2) Burrata artesanal com pesto de manjericão, tomates confit e torradas de pão de fermentação natural - R$ 85,00\n3) Salada de quinoa, abóbora assada, rúcula e sementes de abóbora torradas, com vinagrete de laranja - R$ 70,00");
            System.out.println("\n\t* Pratos Principais:\n\n4) Carré de cordeiro ao molho de hortelã com couscous marroquino e legumes assados - R$ 220,00\n5) Peito de pato ao molho de frutas vermelhas, acompanhado de risoto de cogumelos selvagens - R$ 195,00\n6) Tagliatelle artesanal com ragu de vitela e lascas de trufa negra - R$ 180,00");
            System.out.println("\n\t* Sobremesas:\n\n7) Pavlova com creme de mascarpone e frutas vermelhas - R$ 75,00\n8) Crème brûlée de lavanda - R$ 70,00\n9) Torta de amêndoas com sorvete de pistache - R$ 80,00");
        }
        else{
            return;
        }
    }

    static int getHor(){
        return hor;
    }
    

    static double getPreco(int i){
        int hor = getHor();

        if (hor == 1){
            cp_cm++;
            cpt++;
            switch(i){
                case 1:
                return 45.0;
                case 2:
                return 38.0;
                case 3:
                return 32.0;
                case 4:
                return 65.0;
                case 5:
                return 52.0;
                case 6:
                return 68.0;
                case 7:
                return 28.0;
                case 8:
                return 30.0;
                case 9:
                return 25.0;
            }
        }
        else if (hor == 2){
            cp_al++;
            cpt++;
            switch(i){
                case 1:
                return 75.0;
                case 2:
                return 60.0;
                case 3:
                return 85.0;
                case 4:
                return 160.0;
                case 5:
                return 140.0;
                case 6:
                return 160.0;
                case 7:
                return 55.0;
                case 8:
                return 65.0;
                case 9:
                return 45.0;
            }
        }
        else{
            cp_jan++;
            cpt++;
            switch(i){
                case 1:
                return 130.0;
                case 2:
                return 85.0;
                case 3:
                return 70.0;
                case 4:
                return 220.;
                case 5:
                return 195.0;
                case 6:
                return 180.0;
                case 7:
                return 75.0;
                case 8:
                return 70.0;
                case 9:
                return 80.0;
            }
        }

        return 0.0;
    }
}
