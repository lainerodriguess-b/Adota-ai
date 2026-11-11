
import java.util.ArrayList;

// Classe principal do programa, responsável por executar os testes.
public class Main {
    public static void main(String[] args) {

        // 1. TESTES DAS VACINAS

        // Cria listas para armazenar as vacinas dos animais.
        ArrayList<Vacina> vacinasCachorro = new ArrayList<>();
        ArrayList<Vacina> vacinasGato = new ArrayList<>();

        // Cria objetos da classe Vacina.
        Vacina vacina1 = new Vacina("Antirrábica", "ASTRA", "L001");
        Vacina vacina2 = new Vacina("V10", "SAGE", "L002");
        Vacina vacina3 = new Vacina("Antirrábica", "BRIMSTONE", "L003");

        // Adiciona as vacinas às carteiras dos animais.
        vacinasCachorro.add(vacina1);
        vacinasCachorro.add(vacina2);
        vacinasGato.add(vacina3);

        // Testa os getters das vacinas.
        System.out.println("TESTE GETTERS DAS VACINAS");
        System.out.println("Nome: " + vacina1.getNome());
        System.out.println("Fabricante: " + vacina1.getFabricante());
        System.out.println("Lote: " + vacina1.getLote());

        // Testa os setters das vacinas.
        System.out.println("\nTESTE SETTERS DAS VACINAS");
        vacina1.setNome("Antirrábica atualizada");
        vacina1.setFabricante("SAGE");
        vacina1.setLote("L010");
        vacina1.descricao();

        // 2. TESTES DOS ANIMAIS

        // Cria um objeto Cachorro.
        Cachorro cachorro = new Cachorro(
            1, "Aisha", "Cachorro", 3, vacinasCachorro, true
        );

        // Cria um Gato informando o temperamento.
        Gato gato = new Gato(
            2, "Stella", "Gato", 2, vacinasGato, "Brincalhão"
        );

        // Cria um Gato sem informar o temperamento.
        Gato gato2 = new Gato(
            3, "Tecna", "Gato", 1, new ArrayList<Vacina>()
        );

        // Testa a exibição das fichas.
        System.out.println("\nTESTE CACHORRO");
        cachorro.exibirFicha();

        System.out.println("\nTESTE GATO 1");
        gato.exibirFicha();

        System.out.println("\nTESTE GATO 2 - SOBRECARGA");
        gato2.exibirFicha();

        // Testa os getters dos animais.
        System.out.println("\nTESTE GETTERS DOS ANIMAIS");
        System.out.println("Código do cachorro: " + cachorro.getCodigo());
        System.out.println("Nome do cachorro: " + cachorro.getNome());
        System.out.println("Adestrado: " + cachorro.getAdestracao());
        System.out.println("Código do gato: " + gato.getCodigo());
        System.out.println("Nome do gato: " + gato.getNome());
        System.out.println("Temperamento: " + gato.getTemperamento());

        // Testa os setters dos animais.
        System.out.println("\nTESTE SETTERS DOS ANIMAIS");
        cachorro.setNome("Flora");
        cachorro.setAdestracao(false);
        gato.setNome("Musa");
        gato.setTemperamento("Calmo");
        gato.setIdade(4);

        System.out.println("Novo nome do cachorro: " + cachorro.getNome());
        System.out.println("Adestrado: " + cachorro.getAdestracao());
        System.out.println("Novo nome do gato: " + gato.getNome());
        System.out.println("Novo temperamento: " + gato.getTemperamento());
        System.out.println("Nova idade do gato: " + gato.getIdade());

        // Testa a adição de uma vacina.
        System.out.println("\nTESTE ADICIONAR VACINA");
        Vacina vacina4 = new Vacina("Gripe Canina", "Viper", "L004");
        cachorro.adicionarVacina(vacina4);
        System.out.println("Vacina adicionada à carteira do cachorro.");
        vacina4.descricao();

        // Testa o método de adoção do animal.
        System.out.println("\nTESTE SER ADOTADO");
        cachorro.serAdotado();
        gato.serAdotado();
        gato2.serAdotado();

        System.out.println("Cachorro adotado: " + cachorro.getAdotado());
        System.out.println("Gato 1 adotado: " + gato.getAdotado());
        System.out.println("Gato 2 adotado: " + gato2.getAdotado());

        // 3. TESTES DA CLASSE ADOTANTE

        Adotante adotante = new Adotante(
            "Ana Ju", 18, "12345678900",
            2500.00, "Rua Toquio, 100", "62940028922"
        );

        System.out.println("\nTESTE ADOTANTE");
        adotante.exibirFicha();

        // Testa os getters e setters do adotante.
        System.out.println("\nTESTE GETTERS E SETTERS DO ADOTANTE");
        System.out.println("Nome: " + adotante.getNome());
        System.out.println("Idade: " + adotante.getIdade());
        System.out.println("CPF: " + adotante.getCpf());
        System.out.println("Renda: " + adotante.getRenda());
        System.out.println("Endereço: " + adotante.getEndereco());
        System.out.println("Telefone: " + adotante.getTelefone());

        adotante.setNome("Marina Silva");
        adotante.setIdade(21);
        adotante.setRenda(8000.00);
        adotante.setEndereco("Avenida Pará, 200");
        adotante.setTelefone("62988888888");

        System.out.println("\nDados atualizados do adotante:");
        adotante.exibirFicha();

        // 4. TESTES DA ONG

        ONG ong = new ONG();

        // Cadastra animais e adotante na ONG.
        ong.adicionarAnimal(cachorro);
        ong.adicionarAnimal(gato);
        ong.adicionarAnimal(gato2);
        ong.adicionarAdotante(adotante);

        System.out.println("\nTESTE ONG");
        System.out.println("Quantidade de animais cadastrados: "
            + ong.getAnimaisDisponiveis().size());
        System.out.println("Quantidade de adotantes cadastrados: "
            + ong.getAdotantes().size());

        // Consulta animal pelo código.
        System.out.println("\nAnimal encontrado pelo código:");
        ong.getAnimalPorCodigo(1).exibirFicha();

        // Consulta adotante pelo CPF.
        System.out.println("\nAdotante encontrado pelo CPF:");
        ong.getAdotantePorCpf("12345678900").exibirFicha();

        // 5. TESTES DA CLASSE ADOCAO E DO HISTORICO

        // Registra uma adoção no histórico da ONG.
        System.out.println("\nTESTE REGISTRO DE ADOÇÃO");
        ong.registrarAdocao(1, "12345678900", "11/11/2026");

        System.out.println("Quantidade de adoções registradas: "
            + ong.getHistorico().quantAdocoes());

        // Consulta a adoção registrada.
        Adocao adocao = ong.getAdocaoPorCodigo(1);

        System.out.println("\nDados da adoção registrada:");
        adocao.descricao();

        // Testa a conclusão da adoção.
        System.out.println("\nTESTE CONCLUIR ADOÇÃO");
        ong.permitirAdocao(1);

        System.out.println("Situação da adoção: " + adocao.getSituacao());

        // Exibe o registro atualizado.
        System.out.println("\nHISTÓRICO ATUALIZADO");
        adocao.descricao();

        // 6. EXIBIÇÃO FINAL DAS FICHAS

        System.out.println("\nFICHAS ATUALIZADAS");

        cachorro.exibirFicha();

        System.out.println();
        gato.exibirFicha();

        System.out.println();
        gato2.exibirFicha();

    }
}
