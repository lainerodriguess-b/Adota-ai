
import java.util.ArrayList;

// Classe Cachorro herda os atributos e métodos da classe Animal.
public class Cachorro extends Animal {

    // Atributo específico que indica se o cachorro é adestrado.
    private boolean adestracao;

    // Construtor que recebe os dados do cachorro e da classe Animal.
    public Cachorro(int codigo,String nome, String especie, int idade, ArrayList<Vacina> carteiraVacinas, boolean adestracao) {

        // Chama o construtor da classe Animal para inicializar os atributos herdados.
        super(codigo, nome, especie, idade, carteiraVacinas);

        // Inicializa o atributo específico de adestramento.
        setAdestracao(adestracao);
    }

    // Getter: retorna se o cachorro é adestrado.
    public boolean getAdestracao() {
        return adestracao;
    }

    // Setter: altera o estado de adestramento do cachorro.
    public void setAdestracao(boolean adestracao) {
        this.adestracao = adestracao;
    }

    // Sobrescreve o método exibirFicha() da classe Animal.
    @Override
    public void exibirFicha() {

        // Exibe primeiro os dados gerais herdados da classe Animal.
        super.exibirFicha();

        // Exibe se o cachorro é adestrado.
        System.out.print("Adestrado: ");
        if (adestracao) {
            System.out.println("Sim");
        }
        else {
            System.out.println("Não");
        }
    }
}