package controller;

import java.util.ArrayList;
import java.util.List;
import model.Motorista;
import util.ArquivoPersistente;
import util.ArquivoTXT;


public class MotoristaController {
    private List<Motorista> listaMotoristas = new ArrayList<>();
    private final ArquivoPersistente<Motorista> persistencia = new ArquivoTXT<>();
    private final String caminhoArquivo = "dados/motoristas.txt";

    public MotoristaController() {
        carregar();
    }

    public void adicionarMotorista(Motorista motorista) {
        listaMotoristas.add(motorista);
        salvar();
    }

    public List<Motorista> listarMotoristas() {
        return listaMotoristas;
    }

    public Motorista buscarPorNome(String nomeMotorista) {
        for (Motorista m : listaMotoristas) {
            if (m.getNome() == nomeMotorista) {
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
        persistencia.salvar(listaMotoristas, caminhoArquivo);
    }

    private void carregar() {
        listaMotoristas = persistencia.carregar(caminhoArquivo, Motorista::fromString);
    }

}
