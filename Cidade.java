public class Cidade implements Comparable<Cidade> {
    private String nome;
    private int temp;

    public Cidade(String nome, int temp) {
        this.nome = nome;
        this.temp = temp;
    }

    public String getNome() {
        return nome;
    }

    public int getTemp() {
        return temp;
    }

    @Override
    public int compareTo(Cidade c) {
        return this.nome.compareTo(c.getNome());
    }

    @Override
    public String toString() {
        return "nome: " + nome + "\t temp: " + temp;
    }
}
