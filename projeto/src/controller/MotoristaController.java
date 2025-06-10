package controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Motorista;
import util.ArquivoPersistente;
import util.ArquivoTXT;


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
        salvar();
    }

    public List<Motorista> listarMotoristas() {
        System.out.println("Lista de motoristas:");
        return listaMotoristas;
    }

    public Motorista buscarPorNome(String nomeMotorista) {
        for (Motorista m : listaMotoristas) {
            if (m.getNome().equals(nomeMotorista)) {
                return m;
            }
        }
        return null;
    }

    public void atualizarMotorista(String nome,double novoSalario) {
        Motorista m = buscarPorNome(nome);
        if (m != null) {
            m.setSalario(novoSalario);
            salvar();
        }
    }

    public boolean removerPorNome(String nome) {
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
