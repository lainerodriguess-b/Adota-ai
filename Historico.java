import java.util.ArrayList;

public class Historico {
    private ArrayList<Adocao> registrosAdocao;

    public Historico() {
        this.registrosAdocao = new ArrayList<>();
    }

    public ArrayList<Adocao> getRegistrosAdocao() {
        return registrosAdocao;
    }
    public void setRegistrosAdocao(ArrayList<Adocao> registrosAdocao) {
        this.registrosAdocao = registrosAdocao;
    }

    public int quantAdocoes() {
        return registrosAdocao.size();
    }

    // Procura uma adoção pelo código; lança exceção se não existir.
    public Adocao buscarAdocao(int codigoAdocao) {
        for (Adocao adocao : registrosAdocao) {
            if (adocao.getCodigo() == codigoAdocao) {
                return adocao;
            }
        }
        throw new IllegalArgumentException("Adoção com o código " + codigoAdocao + " não encontrada.");
    }

    // Retorna true se o animal já tem uma adoção em andamento.
    public boolean temAdocaoEmAndamento(Animal animal) {
        for (Adocao adocao : registrosAdocao) {
            if (adocao.getAnimal() == animal && adocao.getSituacao().equals("Em andamento")) {
                return true;
            }
        }
        return false;
    }

    // Conclui a adoção e marca o animal como adotado.
    public void permitirAdocao(int codigoAdocao) {
        Adocao adocao = buscarAdocao(codigoAdocao);
        if (!adocao.getSituacao().equals("Em andamento")) {
            throw new IllegalStateException("Só é possível concluir uma adoção em andamento.");
        }
        adocao.getAnimal().serAdotado();
        adocao.setSituacao("Concluída");
    }

    // Cancela uma adoção que ainda esteja em andamento.
    public void cancelarAdocao(int codigoAdocao) {
        Adocao adocao = buscarAdocao(codigoAdocao);
        if (!adocao.getSituacao().equals("Em andamento")) {
            throw new IllegalStateException("Só é possível cancelar uma adoção em andamento.");
        }
        adocao.setSituacao("Cancelada");
    }

    public void adicionarRegistro(Adocao adocao) {
        if (adocao == null) {
            throw new IllegalArgumentException("O registro de adoção não pode ser nulo.");
        }
        registrosAdocao.add(adocao);
    }
}
