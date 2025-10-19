package app;

import java.util.ArrayList;

/**
 * Classe Cofrinho
 * Armazena moedas de diferentes tipos (Dólar, Euro, Real, etc.)
 * e permite adicionar, remover, listar, calcular total em reais
 * e manter histórico das operações realizadas.
 */
public class Cofrinho {
    private ArrayList<Moeda> listaMoedas = new ArrayList<>();
    private ArrayList<String> historico = new ArrayList<>();

    /**
     * Adiciona uma moeda ao cofrinho.
     * @param moeda Moeda a ser adicionada
     */
    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
        historico.add(String.format("Adicionado: %.2f de %s", moeda.getValor(), moeda.getTipo()));
    }

    /**
     * Remove uma quantidade específica de uma moeda do cofrinho.
     * Suporta remoção parcial.
     * @param moeda Moeda e valor a serem removidos
     */
    public void remover(Moeda moeda) {
        double valorParaRemover = moeda.getValor();
        boolean encontrou = false;

        for (int i = 0; i < listaMoedas.size(); i++) {
            Moeda m = listaMoedas.get(i);

            if (m.getClass() == moeda.getClass()) {
                double valorAtual = m.getValor();

                if (valorAtual >= valorParaRemover) {
                    // Subtrai o valor solicitado da moeda atual
                    m.setValor(round(valorAtual - valorParaRemover));
                    historico.add(String.format("Removido: %.2f de %s", valorParaRemover, m.getTipo()));

                    // Remove da lista se valor chegar a zero
                    if (m.getValor() <= 0.01) {
                        listaMoedas.remove(i);
                        i--; // Ajusta índice após remoção
                    }

                    encontrou = true;
                    break;
                } else {
                    // Remove a moeda inteira e continua subtraindo o restante
                    valorParaRemover -= valorAtual;
                    historico.add(String.format("Removido: %.2f de %s", valorAtual, m.getTipo()));
                    listaMoedas.remove(i);
                    i--;
                }
            }
        }

        if (!encontrou) {
            System.out.println("Erro: não há moeda suficiente para remover.");
            historico.add(String.format("Falha ao remover: %.2f de %s", moeda.getValor(), moeda.getTipo()));
        }
    }

    /**
     * Lista todas as moedas no cofrinho.
     */
    public void listagemMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
            return;
        }
        for (Moeda moeda : listaMoedas) {
            if (moeda.getValor() > 0.01) { // ignora moedas com valor quase zero
                moeda.info();
            }
        }
    }

    /**
     * Calcula o total de moedas em reais.
     * @return soma de todas as moedas convertidas
     */
    public double totalConvertido() {
        double total = 0;
        for (Moeda moeda : listaMoedas) {
            total += moeda.converter();
        }
        return round(total);
    }

    /**
     * Mostra o histórico das operações realizadas no cofrinho.
     */
    public void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma operação realizada ainda.");
            return;
        }
        System.out.println("Histórico de operações:");
        for (String registro : historico) {
            System.out.println(registro);
        }
    }

    /**
     * Arredonda um valor para duas casas decimais
     */
    private double round(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
