package controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Motorista;
import util.ArquivoPersistente;
import util.ArquivoTXT;
import util.Logger;


public class MotoristaController {
    private List<Motorista> listaMotoristas = new ArrayList<>();
    private final ArquivoPersistente<Motorista> persistencia = new ArquivoTXT<>();
    private Path caminhoArquivo;

    public MotoristaController() {
        try {
            caminhoArquivo = Paths.get(System.getProperty("user.dir"), "projeto", "src", "dados", "motoristas.txt");
            carregar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void adicionarMotorista(Motorista motorista) {
        listaMotoristas.add(motorista);
        Logger.registrar("Motorista " + motorista.getNome() + " adicionado(a).");
        salvar();
    }

    public List<Motorista> listarMotoristas() {
        System.out.println("Lista de motoristas:");
        Logger.registrar("Lista de motoristas exibida.");
        return listaMotoristas;
    }

    public Motorista buscarPorNome(String nomeMotorista) {
        Logger.registrar("Busca por motorista realizada.");
        for (Motorista m : listaMotoristas) {
            if (m.getNome().equals(nomeMotorista)) {
                return m;
            }
        }
        return null;
    }

    public void atualizarMotorista(String nome,double novoSalario) {
        Logger.registrar("Motorista atualizado(a).");
        Motorista m = buscarPorNome(nome);
        if (m != null) {
            m.setSalario(novoSalario);
            salvar();
        }
    }

    public boolean removerPorNome(String nome) {
        Logger.registrar("Motorista " + nome + " removido(a).");
        Motorista m = buscarPorNome(nome);
        if (m != null) {
            listaMotoristas.remove(m);
            salvar();
            return true;
        }
        return false;
    }

    private void salvar() {
        persistencia.salvar(listaMotoristas, caminhoArquivo.toString());
    }

    private void carregar() {
        listaMotoristas = persistencia.carregar(caminhoArquivo.toString(), Motorista::fromString);
    }


}
