public class Adotante {
    private String nome;
    private int idade;
    private String cpf;
    private double renda;
    private String endereco;
    private String telefone;

    public Adotante(String nome, int idade, String cpf, double renda, String endereco, String telefone) {
        setNome(nome);
        setIdade(idade);
        setCpf(cpf);
        setRenda(renda);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRenda() {
        return renda;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do adotante não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade do adotante não pode ser negativa.");
        }
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF do adotante não pode ser nulo ou vazio.");
        }
        this.cpf = cpf;
    }

    public void setRenda(double renda) {
        if (renda < 0) {
            throw new IllegalArgumentException("A renda do adotante não pode ser negativa.");
        }
        this.renda = renda;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("O endereço do adotante não pode ser nulo ou vazio.");
        }
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("O telefone do adotante não pode ser nulo ou vazio.");
        }
        this.telefone = telefone;
    }

    public void exibirFicha() {
        System.out.println("Ficha do Adotante:");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Renda: " + renda);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
    }
}
