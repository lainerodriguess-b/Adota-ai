public class Adocao {
    private static int codigo;
    private Animal animal;
    private Adotante adotante;
    private String data;
    private String situacao; // "Em andamento", "Concluída" ou "Cancelada"

    public Adocao(int codigo, Animal animal, Adotante adotante, String data, String situacao) {
        setCodigo(codigo);
        setAnimal(animal);
        setAdotante(adotante);
        setData(data);
        setSituacao(situacao);
    }
    public static int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        if (codigo < 0) {
            throw new IllegalArgumentException("O código da adoção não pode ser negativo.");
        }
        this.codigo = codigo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("O animal não pode ser nulo.");
        }
        this.animal = animal;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        if (adotante == null) {
            throw new IllegalArgumentException("O adotante não pode ser nulo.");
        }
        this.adotante = adotante;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("A data da adoção não pode ser nula ou vazia.");
        }
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        if (situacao == null || situacao.trim().isEmpty()) {
            throw new IllegalArgumentException("A situação da adoção não pode ser nula ou vazia.");
        }
        this.situacao = situacao;
    }

    public void descricao() {
        System.out.println("Descrição da Adoção:");
        System.out.println("Código: " + getCodigo());
        System.out.println("Animal: " + animal.getNome() + " (");
        if (animal instanceof Cachorro) {
            System.out.println("Cachorro)");
        } else if (animal instanceof Gato) {
            System.out.println("Gato)");
        }
        System.out.println("Adotante: " + adotante.getNome());
        System.out.println("Data: " + getData());
        System.out.println("Situação: " + getSituacao());
    }
}
