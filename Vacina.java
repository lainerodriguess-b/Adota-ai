public class Vacina {
    private String nome;
    private String fabricante;
    private String lote;

    public Vacina(String nome, String fabricante, String lote) {
        setNome(nome);
        setFabricante(fabricante);
        setLote(lote);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da vacina não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        if (fabricante == null || fabricante.trim().isEmpty()) {
            throw new IllegalArgumentException("O fabricante da vacina não pode ser nulo ou vazio.");
        }
        this.fabricante = fabricante;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        if (lote == null || lote.trim().isEmpty()) {
            throw new IllegalArgumentException("O lote da vacina não pode ser nulo ou vazio.");
        }
        this.lote = lote;
    }

    public void descricao(){
        System.out.println("Nome: " + nome);
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Lote: " + lote);
    }
}
