package app;

/**
 * Classe abstrata Moeda
 * Representa uma moeda genérica com valor
 */
public abstract class Moeda {
    protected double valor; // Valor da moeda

    public Moeda(double valor) {
        this.valor = valor;
    }

    /**
     * Retorna o valor da moeda
     * @return valor atual
     */
    public double getValor() {
        return valor;
    }

    /**
     * Permite alterar o valor da moeda
     * @param valor novo valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Cada moeda deve implementar como se converte para reais
     * @return valor convertido para reais
     */
    public abstract double converter();

    /**
     * Retorna o tipo da moeda como String (ex: "Dólar", "Euro", "Real")
     * @return nome da moeda
     */
    public abstract String getTipo();

    /**
     * Mostra informações da moeda
     */
    public void info() {
        System.out.printf("%s: %.2f (equivalente a R$ %.2f)\n",
                getTipo(), valor, converter());
    }
}
