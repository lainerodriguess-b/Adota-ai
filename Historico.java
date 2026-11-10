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

    public void permitirAdocao(int codigoAdocao){
        for (Adocao adocao : registrosAdocao) {
            if (adocao.getCodigo() == codigoAdocao) {
                adocao.setSituacao("Concluída");
                return;
            }
        }
        throw new IllegalArgumentException("Adoção com o código " + codigoAdocao + " não encontrada.");
    }
    public void cancelarAdocao(int codigoAdocao){
        for (Adocao adocao : registrosAdocao) {
            if (adocao.getCodigo() == codigoAdocao) {
                adocao.setSituacao("Cancelada");
                return;
            }
        }
        throw new IllegalArgumentException("Adoção com o código " + codigoAdocao + " não encontrada.");
    }

    public void adicionarRegistro(Adocao adocao) {
        if (adocao == null) {
            throw new IllegalArgumentException("O registro de adoção não pode ser nulo.");
        }
        registrosAdocao.add(adocao);
    }
}