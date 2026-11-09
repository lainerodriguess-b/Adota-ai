import java.util.ArrayList;

// Classe principal do programa, responsável por executar os testes.
public class Main {
    public static void main(String[] args) {

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

        // Cria um objeto Cachorro.
        Cachorro cachorro = new Cachorro(
            1, "Aisha", "Cachorro", 3, vacinasCachorro, true
        );

        // Cria um objeto Gato utilizando o primeiro construtor.
        // Nesse construtor, o temperamento é informado.( sobrecarga)
        Gato gato = new Gato(
            2, "Stella", "Gato", 2, vacinasGato, "Brincalhão"
        );

        // Cria um objeto Gato utilizando o segundo construtor.
        // Nesse construtor, o temperamento não é informado.(sobrecarga)
        Gato gato2 = new Gato(
            3, "Tecna", "Gato", 1, new ArrayList<Vacina>()
        );

        // Testa a exibição da ficha do cachorro.
        System.out.println("TESTE CACHORRO");
        cachorro.exibirFicha();

        // Testa a exibição das fichas dos gatos.
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
        System.out.println("\nTESTE DOS SETTERS DOS ANIMAIS");
        cachorro.setNome("Flora");
        cachorro.setAdestracao(false);
        gato.setNome("Musa");
        gato.setTemperamento("Calmo");
        gato.setIdade(4);

        // Exibe os valores atualizados.
        System.out.println("Novo nome do cachorro: " + cachorro.getNome());
        System.out.println("Adestrado: " + cachorro.getAdestracao());
        System.out.println("Novo nome do gato: " + gato.getNome());
        System.out.println("Novo temperamento: " + gato.getTemperamento());
        System.out.println("Nova idade do gato: " + gato.getIdade());

        // Testa os getters da classe Vacina.
        System.out.println("\nTESTE GETTERS DAS VACINAS");
        System.out.println("Nome: " + vacina1.getNome());
        System.out.println("Fabricante: " + vacina1.getFabricante());
        System.out.println("Lote: " + vacina1.getLote());

        // Testa os setters da classe Vacina.
        System.out.println("\nTESTE SETTERS DAS VACINAS");
        vacina1.setNome("Antirrábica atualizada");
        vacina1.setFabricante(" Jett");
        vacina1.setLote("L010");

        // Exibe os dados atualizados da vacina.
        vacina1.descricao();

        // Testa o método adicionarVacina().
        System.out.println("\nTESTE DE ADICIONAR VACINA");
        Vacina vacina4 = new Vacina("Gripe Canina", "Viper", "L004");
        cachorro.adicionarVacina(vacina4);
        System.out.println("Vacina adicionada");
        vacina4.descricao();

        // Testa o método serAdotado().
        System.out.println("\nTESTE DE ADOÇÃO");
        cachorro.serAdotado();
        gato.serAdotado();
        gato2.serAdotado();

        // Exibe o estado de adoção dos animais.
        System.out.println("Cachorro adotado: " + cachorro.getAdotado());
        System.out.println("Gato 1 adotado: " + gato.getAdotado());
        System.out.println("Gato 2 adotado: " + gato2.getAdotado());

        // Exibe novamente as fichas com os dados atualizados.
        System.out.println("\nFICHAS ATUALIZADAS");

        cachorro.exibirFicha();

        System.out.println();
