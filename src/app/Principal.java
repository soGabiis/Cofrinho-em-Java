package app;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal do Cofrinho de moedas.
 * Permite ao usuário:
 * - Adicionar moedas
 * - Remover moedas (total ou parcial)
 * - Listar moedas existentes
 * - Calcular total em Reais
 * - Consultar histórico de operações
 */
public class Principal {

    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();   // Cria o cofrinho
        Scanner teclado = new Scanner(System.in);  // Scanner para ler entradas do usuário
        int user = -1;

        // Enum para controlar os menus do sistema
        enum Opcoes {
            MENU_INICIAL,
            MENU_MOEDA,
            MENU_QUANTIDADE,
            MENU_CONFIRMA,
            MENU_LISTAR,
            MENU_TOTAL,
            MENU_HISTORICO,
            MENU_SAIR
        }
        Opcoes menu = Opcoes.MENU_INICIAL;

        int operacao = -1;   // 1 = adicionar, 2 = remover
        int moeda = -1;      // 1 = Dólar, 2 = Euro, 3 = Real
        double qnt = -1;     // Valor da moeda

        // Loop principal do programa
        while (true) {
            System.out.println("\n--------------------------------\n");

            switch (menu) {

                // Menu inicial: mostra opções principais
                case MENU_INICIAL -> {
                    // Reseta variáveis a cada entrada no menu principal
                    operacao = -1;
                    qnt = -1;
                    moeda = -1;

                    System.out.print(
                            "Cofrinho:\n\n" +
                            "1 - Adicionar moeda\n" +
                            "2 - Remover moeda\n" +
                            "3 - Listar moedas\n" +
                            "4 - Total em Reais\n" +
                            "5 - Histórico de operações\n" +
                            "0 - Sair\n" +
                            "Informe a opção desejada: "
                    );

                    try {
                        user = teclado.nextInt();  // Lê a opção do usuário
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Valor inválido.");
                        teclado.close();
                        return;
                    }

                    // Define o próximo menu de acordo com a escolha do usuário
                    menu = switch (user) {
                        case 1 -> { operacao = 1; yield Opcoes.MENU_MOEDA; }
                        case 2 -> { operacao = 2; yield Opcoes.MENU_MOEDA; }
                        case 3 -> Opcoes.MENU_LISTAR;
                        case 4 -> Opcoes.MENU_TOTAL;
                        case 5 -> Opcoes.MENU_HISTORICO;
                        case 0 -> Opcoes.MENU_SAIR;
                        default -> {
                            System.out.println("Opção inválida! Tente novamente.");
                            yield Opcoes.MENU_INICIAL;
                        }
                    };
                }

                // Menu para escolher o tipo de moeda
                case MENU_MOEDA -> {
                    qnt = -1;
                    moeda = -1;

                    System.out.printf("Escolha a moeda para %s:\n1 - Dólar\n2 - Euro\n3 - Real\n0 - Cancelar\nOpção: ",
                            (operacao == 1) ? "adicionar" : "remover");

                    try {
                        user = teclado.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Valor inválido.");
                        teclado.close();
                        return;
                    }

                    if (user == 0) menu = Opcoes.MENU_INICIAL; // Cancelar operação
                    else if (user >= 1 && user <= 3) {
                        moeda = user;              // Define o tipo de moeda
                        menu = Opcoes.MENU_QUANTIDADE; // Vai para o menu de quantidade
                    }
                }

                // Menu para informar o valor da moeda
                case MENU_QUANTIDADE -> {
                    qnt = -1;
                    System.out.printf("Operação: %s\n", (operacao == 1) ? "Adicionar" : "Remover");
                    System.out.printf("Moeda: %s\n", (moeda == 1) ? "Dólar" : (moeda == 2) ? "Euro" : "Real");
                    System.out.print("Informe o valor: ");

                    try {
                        qnt = teclado.nextDouble(); // Lê o valor da moeda
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Valor inválido.");
                        teclado.close();
                        return;
                    }

                    if (qnt <= 0) {
                        System.out.println("Operação cancelada.");
                        menu = Opcoes.MENU_INICIAL;
                    } else {
                        menu = Opcoes.MENU_CONFIRMA; // Vai para confirmação
                    }
                }

                // Menu de confirmação da operação
                case MENU_CONFIRMA -> {
                    System.out.printf("Você está prestes a %s %.2f de %s\n",
                            (operacao == 1) ? "adicionar" : "remover",
                            qnt,
                            (moeda == 1) ? "Dólar" : (moeda == 2) ? "Euro" : "Real");
                    System.out.print("Confirmar? 1 - Sim | 2 - Não: ");

                    try {
                        user = teclado.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Valor inválido.");
                        teclado.close();
                        return;
                    }

                    if (user == 1) {
                        // Cria objeto da moeda escolhida
                        Moeda novaMoeda = switch (moeda) {
                            case 1 -> new Dolar(qnt);
                            case 2 -> new Euro(qnt);
                            case 3 -> new Real(qnt);
                            default -> null;
                        };

                        if (novaMoeda != null) {
                            // Executa operação: adicionar ou remover
                            if (operacao == 1) cofrinho.adicionar(novaMoeda);
                            else if (operacao == 2) cofrinho.remover(novaMoeda);
                        }
                    } else {
                        System.out.println("Operação cancelada.");
                    }

                    menu = Opcoes.MENU_INICIAL; // Retorna ao menu principal
                }

                // Lista todas as moedas do cofrinho
                case MENU_LISTAR -> {
                    cofrinho.listagemMoedas();
                    System.out.println("Pressione qualquer tecla para voltar...");
                    try { teclado.nextLine(); teclado.nextLine(); } catch (Exception ignored) {}
                    menu = Opcoes.MENU_INICIAL;
                }

                // Mostra o total em Reais
                case MENU_TOTAL -> {
                    System.out.printf("Total em Reais: R$ %.2f\n", cofrinho.totalConvertido());
                    System.out.println("Pressione qualquer tecla para voltar...");
                    try { teclado.nextLine(); teclado.nextLine(); } catch (Exception ignored) {}
                    menu = Opcoes.MENU_INICIAL;
                }

                // Mostra o histórico de operações
                case MENU_HISTORICO -> {
                    cofrinho.mostrarHistorico();
                    System.out.println("Pressione qualquer tecla para voltar...");
                    try { teclado.nextLine(); teclado.nextLine(); } catch (Exception ignored) {}
                    menu = Opcoes.MENU_INICIAL;
                }

                // Encerra o programa
                case MENU_SAIR -> {
                    System.out.println("Programa finalizado. Até mais!");
                    teclado.close();
                    return;
                }

                // Caso de erro inesperado
                default -> {
                    System.out.println("Opção inválida!");
                    menu = Opcoes.MENU_INICIAL;
                }
            }
        }
    }
}
