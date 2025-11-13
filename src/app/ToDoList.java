package app;

import java.util.ArrayList; // Importa a classe ArrayList
import java.util.Scanner;   // Importa a classe Scanner para entrada de dados

public class ToDoList {
    // Declara uma lista de tarefas (Strings) que pode crescer dinamicamente.
    private ArrayList<String> tarefas; 
    // Declara o objeto Scanner para ler a entrada do usuário.
    private Scanner scanner;          

    // Construtor da classe ToDoList. É chamado quando um novo objeto é criado.
    public ToDoList() {
        // Inicializa a lista de tarefas como um novo ArrayList vazio.
        this.tarefas = new ArrayList<>(); 
        // Inicializa o Scanner para ler a entrada do Sistema (System.in).
        this.scanner = new Scanner(System.in); 
    }

    // Método principal onde a execução do programa começa.
    public static void main(String[] args) {
        // Cria uma nova instância (objeto) da nossa ToDoList.
        ToDoList app = new ToDoList(); 
        // Chama o método que inicia o menu e o loop do programa.
        app.iniciarAplicacao(); 
    }
    
    // Método para iniciar o loop principal da aplicação.
    public void iniciarAplicacao() {
        int opcao = -1; // Variável para armazenar a escolha do usuário.

        // Loop principal: executa o bloco de código ENQUANTO a opção não for 4 (Sair).
        while (opcao != 4) {
            exibirMenu(); // Chama o método para mostrar as opções.
            
            // Tenta ler a opção do usuário. O bloco try/catch trata erros de entrada.
            try {
                // Lê a linha digitada e tenta convertê-la para um número inteiro.
                opcao = Integer.parseInt(scanner.nextLine()); 
                
                // Estrutura de controle 'switch' para executar a ação baseada na 'opcao'.
                switch (opcao) {
                    case 1:
                        adicionarTarefa(); // Chama o método de adicionar.
                        break;
                    case 2:
                        listarTarefas(); // Chama o método de listar.
                        break;
                    case 3:
                        removerTarefa(); // Chama o método de remover.
                        break;
                    case 4:
                        // Opção 4: o loop será encerrado na próxima verificação do 'while'.
                        System.out.println("Saindo do Sistema. Tchau!"); 
                        break;
                    default:
                        // Se o número digitado não for 1, 2, 3 ou 4.
                        System.out.println("Opção inválida. Tente novamente."); 
                }
            } catch (NumberFormatException e) {
                // Captura se o usuário digitar texto em vez de um número.
                System.out.println("Entrada inválida. Digite um número."); 
                opcao = -1; // Reseta a opção para garantir que o loop continue.
            }
        }
    }

    // Método para exibir o menu de opções no console.
    private void exibirMenu() {
        System.out.println("\n--- Gerenciador de Tarefas ---");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Remover Tarefa");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    // Método para adicionar uma nova tarefa à lista.
    private void adicionarTarefa() {
        System.out.print("Digite a tarefa a ser adicionada: ");
        // Lê a linha digitada pelo usuário.
        String novaTarefa = scanner.nextLine(); 
        // Adiciona a String (tarefa) ao ArrayList.
        tarefas.add(novaTarefa); 
        System.out.println("Tarefa '" + novaTarefa + "' adicionada com sucesso!");
    }
    
    // Método para listar todas as tarefas com seus índices.
    private void listarTarefas() {
        // Verifica se a lista está vazia.
        if (tarefas.isEmpty()) { 
            System.out.println("A lista de tarefas está vazia.");
            return; // Sai do método se a lista estiver vazia.
        }
        
        System.out.println("\n--- Suas Tarefas ---");
        // Loop 'for' aprimorado: itera sobre cada elemento na coleção 'tarefas'.
        for (int i = 0; i < tarefas.size(); i++) {
            // Exibe o índice (i+1) e o conteúdo da tarefa na posição 'i'.
            System.out.println((i + 1) + ". " + tarefas.get(i)); 
        }
    }

    // Método para remover uma tarefa da lista.
    private void removerTarefa() {
        // Primeiro lista as tarefas para que o usuário saiba o número a remover.
        listarTarefas(); 
        if (tarefas.isEmpty()) {
            return; // Sai se a lista estiver vazia.
        }
        
        System.out.print("Digite o número da tarefa para remover: ");
        try {
            // Lê o índice que o usuário quer remover (por exemplo, 1, 2, 3...).
            int indiceParaRemover = Integer.parseInt(scanner.nextLine()); 
            // Converte o número do usuário para o índice real do ArrayList (começa em 0).
            int indiceArray = indiceParaRemover - 1; 

            // Verifica se o índice está dentro dos limites válidos do ArrayList.
            if (indiceArray >= 0 && indiceArray < tarefas.size()) {
                // Remove a tarefa no índice especificado e guarda a String removida.
                String tarefaRemovida = tarefas.remove(indiceArray); 
                System.out.println("Tarefa '" + tarefaRemovida + "' removida.");
            } else {
                System.out.println("Número de tarefa inválido.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número.");
        }
    }
}
    

