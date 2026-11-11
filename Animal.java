import java.util.ArrayList;

// Classe abstrata que representa um animal genérico.
public abstract class Animal {

    // Atributos comuns a todos os animais.
    private int codigo;
    private String nome;
    private String especie;
    private int idade;

    // Lista que armazena as vacinas do animal.
    private ArrayList<Vacina> carteiraVacinas;

    // Indica se o animal já foi adotado.
    private boolean adotado;

    // Construtor: inicializa os atributos do animal ao criar um objeto.
    public Animal(int codigo,String nome, String especie, int idade, ArrayList<Vacina> carteiraVacinas) {
        setCodigo(codigo);
        setNome(nome);
        setEspecie(especie);
        setIdade(idade);
        setCarteiraVacinas(carteiraVacinas);
        // Todo animal começa como não adotado.
        setAdotado(false);
    }

    // Retorna o código do animal.
    public int getCodigo() {
        return codigo;
    }

    // Altera o código do animal.
    public void setCodigo(int codigo) {
        if (codigo < 0) {
            throw new IllegalArgumentException("O código do animal não pode ser negativo.");
        }
        this.codigo = codigo;
    }

    // Retorna o nome do animal.
    public String getNome() {
        return nome;
    }

    // Altera o nome do animal.
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do animal não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    // Retorna a espécie do animal.
    public String getEspecie() {
        return especie;
    }

    // Altera a espécie do animal.
    public void setEspecie(String especie) {
        if (especie == null || especie.trim().isEmpty()) {
            throw new IllegalArgumentException("A espécie do animal não pode ser nula ou vazia.");
        }
        this.especie = especie;
    }

    // Retorna a idade do animal.
    public int getIdade() {
        return idade;
    }

    // Altera a idade do animal.
    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade do animal não pode ser negativa.");
        }
        this.idade = idade;
    }

    // Retorna a lista de vacinas do animal.
    public ArrayList<Vacina> getCarteiraVacinas() {
        return carteiraVacinas;
    }

    // Altera a lista de vacinas do animal.
    public void setCarteiraVacinas(ArrayList<Vacina> carteiraVacinas) {
        // Evita NullPointerException: se vier null, começa com carteira vazia.
        if (carteiraVacinas == null) {
            this.carteiraVacinas = new ArrayList<>();
        } else {
            this.carteiraVacinas = carteiraVacinas;
        }
    }

    // Adiciona uma vacina à lista de vacinas do animal.
    public void adicionarVacina(Vacina vacina){
        if (vacina == null) {
            throw new IllegalArgumentException("A vacina não pode ser nula.");
        }
        this.carteiraVacinas.add(vacina);
    }

    // Retorna true se o animal foi adotado e false caso contrário.
    public boolean getAdotado() {
        return adotado;
    }

    // Permite alterar o estado de adoção do animal.
    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    // Marca o animal como adotado.
    public void serAdotado() {
        if (this.adotado) {
            throw new IllegalStateException("O animal já foi adotado.");
        }
        this.adotado = true;
    }

    // Exibe os dados gerais do animal no console.
    public void exibirFicha() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie);
        System.out.println("Idade: " + idade);
        System.out.println("Carteira de vacinas: ");
        if (carteiraVacinas.isEmpty()) {
            System.out.println("Nenhuma vacina registrada.");
        } else {
            for (Vacina vacina : carteiraVacinas) {
                System.out.println("- " + vacina.getNome());
            }
        }

        // Verifica se o animal foi adotado para exibir Sim ou Não.
        System.out.print("Adotado: ");
        if (this.adotado) {
            System.out.println("Sim");
        } else {
            System.out.println("Não");
        }
    }
}
