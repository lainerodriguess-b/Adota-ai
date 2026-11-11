import java.util.ArrayList;

// Classe Gato herda os atributos e métodos da classe Animal.
public class Gato extends Animal {

    // Atributo específico da classe Gato.
    private String temperamento;

    // Construtor que recebe os dados do gato e da classe Animal.
    public Gato(int codigo, String nome, String especie, int idade, ArrayList<Vacina> carteiraVacinas, String temperamento) {
        super(codigo, nome, especie, idade, carteiraVacinas);
        setTemperamento(temperamento);
    }

    // Construtor sobrecarregado sem informar o temperamento.
    public Gato(int codigo, String nome, String especie, int idade, ArrayList<Vacina> carteiraVacinas) {
        super(codigo, nome, especie, idade, carteiraVacinas);
        this.temperamento = "Não informado";
    }

    // Getter: retorna o temperamento do gato.
    public String getTemperamento() {
        return temperamento;
    }

    // Setter: permite alterar o temperamento do gato.
    public void setTemperamento(String temperamento) {
        if (temperamento == null || temperamento.trim().isEmpty()) {
            throw new IllegalArgumentException("O temperamento do gato não pode ser nulo ou vazio.");
        }
        this.temperamento = temperamento;
    }

    // Sobrescreve o método exibirFicha() da classe Animal.
    @Override
    public void exibirFicha() {
        super.exibirFicha();
        System.out.println("Temperamento: " + temperamento);
    }
}
