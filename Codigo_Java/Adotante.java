// Classe que representa uma pessoa interessada em adotar um animal.
public class Adotante {

    private String nome;
    private int idade;
    private String cpf;
    private double renda;
    private String endereco;
    private String email;
    private String telefone;

    public Adotante(String nome, int idade, String cpf, double renda,
                    String endereco, String email, String telefone) {
        setNome(nome);
        setIdade(idade);
        setCpf(cpf);
        setRenda(renda);
        setEndereco(endereco);
        setEmail(email);
        setTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do adotante não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("O adotante deve ser maior de idade.");
        }
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("[0-9]{11}")) {
            throw new IllegalArgumentException("O CPF deve ter 11 dígitos numéricos.");
        }
        this.cpf = cpf;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        if (renda < 0) {
            throw new IllegalArgumentException("A renda não pode ser negativa.");
        }
        this.renda = renda;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("O endereço não pode ser nulo ou vazio.");
        }
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("O telefone não pode ser nulo ou vazio.");
        }
        this.telefone = telefone;
    }

    // Exibe os dados do adotante no console.
    public void exibirFicha() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Renda: " + renda);
        System.out.println("Endereço: " + endereco);
        System.out.println("E-mail: " + email);
        System.out.println("Telefone: " + telefone);
    }
}
