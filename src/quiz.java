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
        
        
        String medusa = 
        		"   ~Õ~\n"
        		+ "   /|\\   \n"
        		+ "    |    \n"
        		+ "   \\|/   \n";
        
        String medusaDead = 
        		"     |}\n"
        		+ "<-----O}\n"
        		+ "     |}";
        
        System.out.println("Selecione entre um dos guerreiros (Lembre-se que quanto maior a ferramenta de ataque, mais lento o ataque especial!)");
        System.out.println("Guerreiro com Espada: \n" + espada + "\n\nGuerreiro com Faca:\n" + faca + "\nEscolha entre guerreiro com espada ou faca?");
        String answer = sc.next().toLowerCase();

        String guerreiro = "";
        int superAttackCounter = 0, correctSequence = 0;
        
        switch (answer){
        	case "faca": {
        		guerreiro = faca;
        		superAttackCounter = 2;
        		break;
        	}
        	case "espada": {
        		guerreiro = espada;
        		superAttackCounter = 3;
        		break;
        	}
        	default:{
        		nonGuerreiro();
        		break;
        	}
        }
        
        System.out.println("O guerreiro selecionado foi:\n" + guerreiro);
        System.out.println("Lutando contra a medusa:\n" + medusa);
        
        int fighterLife = 6;
        int monsterLife = 6;
        
        while(fighterLife > 0 && monsterLife > 0) {
        	
        	if (correctSequence == superAttackCounter) {
        		System.out.println("Deseja usar o ataque especial?");
        		String attackAnswer = sc.next();
        		
        		if(attackAnswer.toLowerCase().equals("sim")) {
        			monsterLife -=2;
        			System.out.println("Vida do guerreiro: " + fighterLife);
                    System.out.println("Vida do monstro: " + monsterLife);
        		}
        	}
        	
            double questionNumber = Math.ceil(Math.random()* 10);
        	if (questionNumber > 0) {
        		questionNumber -= 1;
        	}
            
            String actualQuestion = questions.questionsList[(int)questionNumber];
            System.out.println(actualQuestion+"\n"
            		+ "-Resposta-> ");
            String questionAnswer = sc.next();
            
            if (checkAnswer (questionAnswer, (int)questionNumber)) {
            	correctSequence += 1;
            	monsterLife -= 1;
            }
            if(!checkAnswer (questionAnswer, (int)questionNumber)){
            	fighterLife -= 1;
            }
            
            if(fighterLife == 0 || monsterLife==0) {
            	break;
            }
            
            System.out.println("Vida do guerreiro: " + fighterLife);
            System.out.println("Vida do monstro: " + monsterLife);
        
        }
        
        if(fighterLife <= 0) System.out.println("Guerreiro morto!");

        if(monsterLife <= 0) System.out.println("\n\nMedusa morta!\n" + medusaDead);
        
        sc.close();
    }
}