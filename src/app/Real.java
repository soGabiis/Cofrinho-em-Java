package app;

/**
 * Classe Real
 * 
 * Representa a moeda Real (BRL).
 * Herda da classe Moeda e implementa métodos para:
 * - mostrar informações da moeda
 * - retornar valor em reais
 */
public class Real extends Moeda {

    /**
     * Construtor da moeda Real
     * @param valor valor em reais
     */
    public Real(double valor) {
        super(valor);
    }

    /**
     * Exibe informações da moeda
     */
    @Override
    public void info() {
        System.out.printf("Moeda: BRL %9.2f\n", getValor());
    }

    /**
     * Retorna o valor da moeda em reais
     * @return valor em reais
     */
    @Override
    public double converter() {
        return getValor();
    }

    /**
     * Retorna o tipo da moeda como String
     * @return "Real"
     */
    @Override
    public String getTipo() {
        return "Real";
    }
}
