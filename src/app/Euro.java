package app;

/**
 * Classe Euro
 * 
 * Representa a moeda Euro.
 * Herda da classe Moeda e implementa métodos para:
 * - mostrar informações da moeda
 * - converter para Reais
 */
public class Euro extends Moeda {

    private final double cotacao = 5.36; // Cotação do euro em reais

    /**
     * Construtor da moeda Euro
     * @param valor valor em euros
     */
    public Euro(double valor) {
        super(valor);
    }

    /**
     * Exibe informações da moeda (tipo e valor)
     */
    @Override
    public void info() {
        System.out.printf("Moeda: EUR %9.2f\n", getValor());
    }

    /**
     * Converte o valor da moeda para reais
     * @return valor em reais
     */
    @Override
    public double converter() {
        return cotacao * getValor();
    }

    /**
     * Retorna o tipo da moeda como String
     * @return "Euro"
     */
    @Override
    public String getTipo() {
        return "Euro";
    }
}
