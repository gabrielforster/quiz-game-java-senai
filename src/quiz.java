import java.util.Scanner;

public class quiz {
    
	private static String nonGuerreiro (){
        System.out.println("Gurreiro nao existente");
        return "";
    }
	
	private static Boolean checkAnswer (String answer, int question) {
		if(answer.toLowerCase().equals(questions.answersList[question])) {
			return true;
		}
		
		return false;
	}
    
    public static void main(String[] args) {
        questions.getQuestionsList();
        questions.getAnswersList();
        Scanner sc = new Scanner(System.in);

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
        System.out.println("Guerreiro com Espada: \n" + espada + "\n\nGuerreiro com Faca:\n" + faca + "\nEscolha entre guerreiro com espada ou faca?");
        String answer = sc.next().toLowerCase();

        String guerreiro = "";
        
        switch (answer){
        	case "faca": {
        		guerreiro = faca;
        		break;
        	}
        	case "espada": {
        		guerreiro = espada;
        		break;
        	}
        	default:{
        		nonGuerreiro();
        		break;
        	}
        }
        
        System.out.println("O guerreiro selecionado foi:\n" + guerreiro);
        
        int fighterLife = 6;
        int monsterLife = 6;
        
        while(fighterLife > 0 && monsterLife > 0) {
            double questionNumber = Math.ceil(Math.random()* 10);
        	if (questionNumber > 0) {
        		questionNumber -= 1;
        	}
            
            String actualQuestion = questions.questionsList[(int)questionNumber];
            System.out.println(actualQuestion+"\n"
            		+ "-Resposta-> ");
            String questionAnswer = sc.nextLine();
            
            if (checkAnswer (questionAnswer, (int)questionNumber)) {
            	fighterLife += 1;
            	monsterLife -= 1;
            }
            if(!checkAnswer (questionAnswer, (int)questionNumber)){            	
            	monsterLife += 1;
            	fighterLife -= 1;
            }
            
            if(fighterLife == 0 || monsterLife==0) {
            	break;
            }
            
            System.out.println("Vida do guerreiro: " + fighterLife);
            System.out.println("Vida do monstro: " + monsterLife);
        
        }
        
        if(fighterLife <= 0) System.out.println("Guerreiro morto!");

        if(monsterLife <= 0) System.out.println("Monstro morto!");
        
        sc.close();
    }
}