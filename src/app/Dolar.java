package app;

/**
 * Classe Dolar
 * 
 * Representa a moeda Dólar dos Estados Unidos.
 * Herda da classe Moeda e implementa métodos para:
 * - mostrar informações da moeda
 * - converter para Reais
 */
public class Dolar extends Moeda {

    private final double cotacao = 4.98; // Cotação do dólar em reais

    /**
     * Construtor da moeda Dólar
     * @param valor valor em dólares
     */
    public Dolar(double valor) {
        super(valor);
    }

    /**
     * Exibe informações da moeda (tipo e valor)
     */
    @Override
    public void info() {
        System.out.printf("Moeda: USD %9.2f\n", getValor());
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
     * @return "Dólar"
     */
    @Override
    public String getTipo() {
        return "Dólar";
    }
}
