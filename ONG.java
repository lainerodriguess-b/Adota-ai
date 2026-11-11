import java.util.ArrayList;

public class ONG {
    private ArrayList<Animal> animaisDisponiveis;
    private ArrayList<Adotante> adotantes;
    private Historico historico;

    public ONG() {
        this.animaisDisponiveis = new ArrayList<Animal>();
        this.adotantes = new ArrayList<Adotante>();
        this.historico = new Historico();
    }

    public ArrayList<Animal> getAnimaisDisponiveis() {
        return animaisDisponiveis;
    }
    public ArrayList<Adotante> getAdotantes() {
        return adotantes;
    }
    public Historico getHistorico() {
        return historico;
    }

    public void adicionarAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("O animal não pode ser nulo.");
        }
        animaisDisponiveis.add(animal);
    }
    public void removerAnimal(int codigo) {
        boolean removido = animaisDisponiveis.removeIf(animal -> animal.getCodigo() == codigo);
        if (!removido) {
            throw new IllegalArgumentException("Animal com o código " + codigo + " não encontrado.");
        }
    }
    public void adicionarAdotante(Adotante adotante) {
        if (adotante == null) {
            throw new IllegalArgumentException("O adotante não pode ser nulo.");
        }
        adotantes.add(adotante);
    }
    public void removerAdotante(String cpf) {
        boolean removido = adotantes.removeIf(adotante -> adotante.getCpf().equals(cpf));
        if (!removido) {
            throw new IllegalArgumentException("Adotante com o CPF " + cpf + " não encontrado.");
        }
    }

    public Animal getAnimalPorCodigo(int codigo) {
        for (Animal animal : animaisDisponiveis) {
            if (animal.getCodigo() == codigo) {
                return animal;
            }
        }
        throw new IllegalArgumentException("Animal com o código " + codigo + " não encontrado.");
    }

    public Adotante getAdotantePorCpf(String cpf) {
        for (Adotante adotante : adotantes) {
            if (adotante.getCpf().equals(cpf)) {
                return adotante;
            }
        }
        throw new IllegalArgumentException("Adotante com o CPF " + cpf + " não encontrado.");
    }

    public Adocao getAdocaoPorCodigo(int codigo) {
        return historico.buscarAdocao(codigo);
    }

    public void registrarAdocao(int codigoAnimal, String cpfAdotante, String data) {
        Animal animal = getAnimalPorCodigo(codigoAnimal);
        Adotante adotante = getAdotantePorCpf(cpfAdotante);

        if (animal.getAdotado()) {
            throw new IllegalStateException("O animal " + animal.getNome() + " já foi adotado.");
        }
        if (historico.temAdocaoEmAndamento(animal)) {
            throw new IllegalStateException("O animal " + animal.getNome() + " já tem uma adoção em andamento.");
        }

        Adocao adocao = new Adocao(historico.quantAdocoes() + 1, animal, adotante, data, "Em andamento");
        historico.adicionarRegistro(adocao);
    }

    public void permitirAdocao(int codigo){
        historico.permitirAdocao(codigo);
    }
    public void cancelarAdocao(int codigo){
        historico.cancelarAdocao(codigo);
    }

}
