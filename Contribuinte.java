package source;

public class Contribuinte {
    private int idade;
    private char sexo; // 'M' ou 'F'
    private int tempoContribuicao; // em anos
    private int tempoContribuicaoPrecaro; // em anos

    public Contribuinte(int idade, char sexo, int tempoContribuicao, int tempoContribuicaoPrecaro) {
        this.idade = idade;
        this.sexo = sexo;
        this.tempoContribuicao = tempoContribuicao;
        this.tempoContribuicaoPrecaro = tempoContribuicaoPrecaro;
    }

    // Calcula o tempo de contribuição total considerando o fator 1,1 para tempo sob condições precárias
    private double calcularTempoContribuicaoTotal() {
        return tempoContribuicao + (tempoContribuicaoPrecaro * 1.1);
    }

    // Método para verificar elegibilidade para aposentadoria
    public boolean podeAposentar() {
        double tempoTotal = calcularTempoContribuicaoTotal();

        if (sexo == 'F') {
            return idade >= 62 && tempoTotal >= 15;
        } else if (sexo == 'M') {
            return idade >= 65 && tempoTotal >= 20;
        } else {
            throw new IllegalArgumentException("Sexo inválido: deve ser 'M' ou 'F'");
        }
    }

    // Getters e setters, se necessários
    public int getIdade() { return idade; }
    public char getSexo() { return sexo; }
    public int getTempoContribuicao() { return tempoContribuicao; }
    public int getTempoContribuicaoPrecaro() { return tempoContribuicaoPrecaro; }
}
