import java.util.Scanner;
import java.util.ArrayList;

public class listaDeTarefas {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<String> tarefas = new ArrayList<>();

	public static void main(String[] args) {
		
		
		int opcao;
		boolean querSair = false;


	
		do {
			opcoesMenu();
			
			if(sc.hasNextInt()){
				opcao = sc.nextInt();
				sc.nextLine();
			} else{
				System.out.println("Entrada inválida! Digite um número de 1 a 4.\n");
				sc.nextLine();
				continue;
			}
			
			switch(opcao) {
			case 1:
				addTarefa(tarefas);
				break;
			case 2:
				verTarefa();
				break;
			case 3:
				removerTarefa(tarefas);
				break;
			case 4:
				System.out.println("Até mais!");
				querSair = true;
				break;
			default:
				System.out.println("Número inválido! Digite um número de 1 a 4.\n");
			}
			
		} while(!querSair);
	
		
		sc.close();
	}
	
	
	
	public static void opcoesMenu() {
		System.out.println("Gerenciador de tarefas");
		System.out.println("1 - Adicionar Tarefa");
		System.out.println("2 - Ver a Lista de Tarefas");
		System.out.println("3 - Remover Tarefa");
		System.out.println("4 - Sair");
	}
	
	public static void addTarefa(ArrayList<String> tarefas) {
		System.out.println("Digite a sua tarefa: ");
		String textoDaTarefa = sc.nextLine();
		tarefas.add(textoDaTarefa);	
		System.out.println("tarefa adicionada!\n");
	}
	
	public static void verTarefa() {
		if (tarefas.isEmpty()) {
			System.out.println("A lista de tarefas está vazia.\n");
		} else {
			System.out.println("Lista de tarefas:");
			for(int i = 0; i < tarefas.size(); i++) {
				System.out.println((i + 1) + " - " + tarefas.get(i));
			}
			System.out.println();
		}
	}
	
	public static void removerTarefa(ArrayList<String> tarefas) {
		if (tarefas.isEmpty()) {
			System.out.println("Não existe tarefas na sua lista.\n");
		} else {
			System.out.println("Digite o número da tarefa que você quer remover: ");
			for (int i = 0; i < tarefas.size(); i++) {
				System.out.println((i + 1) + " - " + tarefas.get(i));
			}
			
			int opcaoRemover;

			while(true){
				if (sc.hasNextInt()){
					opcaoRemover = sc.nextInt();
					sc.nextLine();

					if (opcaoRemover < 1 || opcaoRemover > tarefas.size()) {
						System.out.println("Número inválido! Escolha um número entre 1 e " + tarefas.size());
						continue;
					} 
					
					tarefas.remove(opcaoRemover - 1);
					System.out.println("A tarefa foi removida da lista!\n");
					break;
					
				}  else{
					System.out.println("Valor inválido, escolha uma tarefa por números entre 1 e " + tarefas.size());
					sc.nextLine();
				}
			}
		}
	}
	

}

