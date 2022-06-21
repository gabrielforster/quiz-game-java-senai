import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class quiz {
    private static String nonGurreiro (){
        System.out.println("Gurreiro nao existente");
        return "";
    }
    public static void main(String[] args) {
        questions.getQuestionsList();
        Scanner sc = new Scanner(System.in);

        String guerreiro = "";
        int fighterLife = 6, monsterLife = 6;
        System.out.println(questions.questionsList[0]);


        //Definido gurreiros disponiveis no game
        String espada =
                "  0   /\n" +
                "/ | \\%\n" +
                "  |  \n" +
                " / \\";

        String faca =
                "   0  \n" +
                " / | \\/\n" +
                "   |  \n" +
                "  / \\";
        System.out.println("Selecione entre um dos guerreiros (Lembre-se que quanto maior a ferramenta de ataque, mais lento o ataque especial!)");
        System.out.println("Espada: \n" + espada + "\nFaca:\n" + faca + "\nEscolha entre guerreiro com espada ou faca?");
        String answer = sc.next().toLowerCase();

        guerreiro = answer.equals("faca") ? faca : answer.equals("espada") ? espada : nonGurreiro();
        System.out.println(guerreiro);

        if(guerreiro.equals(faca)){
            System.out.println("Seu ataque especial carrega com DUAS respostas certas!");
        }
        else if(guerreiro.equals(espada)){
            System.out.println("Seu ataque especial carrega em TRÊS respostas certas!");
        }
        do{
//            double questionNumber = Math.ceil(Math.random()* 10);
            double questionNumber =  1;
            String actualQuestion = questions.questionsList[(int)questionNumber];
            System.out.println(actualQuestion);
        }while(fighterLife != 0 && monsterLife != 0);
        sc.close();
    }
}