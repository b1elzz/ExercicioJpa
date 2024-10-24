package aula22_10;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

import aula22_10.Util.tecladoUtil;

public class RegistroController {
    tecladoUtil teclado = new tecladoUtil();
    private RegistroRepository registroRepository;

    public RegistroController() {
        this.registroRepository = new RegistroRepository();
    }

    public void inserirAluno() {
        String nome = teclado.lerString("Insira o nome");
        String sobreNome = teclado.lerString("Insira o sobrenom");
        int idade = teclado.lerInteiro("insira sua idade");

        Registro pessoa = new Registro();
        pessoa.setNome(nome);
        pessoa.setSobreNome(sobreNome);
        pessoa.setIdade(idade);

        registroRepository.inserir(pessoa);
    }

    public void buscarPorId() {
        int id = teclado.lerInteiro("Insira o id: ");
        System.out.println(registroRepository.buscarPorId(id));
    }

    public List<Registro> listarRegistros() {
        return registroRepository.buscar();
    }

    public void remover() {

        Integer id = teclado.lerInteiro("Insira o id do registro a ser removido: ");
        Registro pessoa = registroRepository.buscarPorId(id);
        registroRepository.remover(pessoa);
    }

    public void atualizar() {

        Integer id = teclado.lerInteiro("Insira o id do registro a ser atualizado: ");
        Registro pessoa = registroRepository.buscarPorId(id);
        teclado.limparBuffer();
        String nome = teclado.lerString("Insira o nome");
        String sobreNome = teclado.lerString("Insira o sobrenom");
        int idade = teclado.lerInteiro("insira sua idade");

        pessoa.setNome(nome);
        pessoa.setSobreNome(sobreNome);
        pessoa.setIdade(idade);

        registroRepository.atualizar(pessoa);
    }

    public void menu() {
        System.out.println("Menu: ");
        System.out.println("1. Inserir");
        System.out.println("2. Buscar por id");
        System.out.println("3. Buscar todos registros");
        System.out.println("4. Atualizar");
        System.out.println("5. Remover");
        System.out.println("6. Sair");
    }

    public void executar() {
        int escolha;
        do {
            menu();
            escolha = teclado.lerInteiro("Insira a opção: ");
            teclado.limparBuffer();
            switch (escolha) {
                case 1:
                    inserirAluno();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    System.out.println(listarRegistros());
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    remover();
                    break;
                case 6:
                    escolha = 6;
                default:
                    break;
            }

        } while (escolha != 6);
    }
}
