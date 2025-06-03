package controller;

import java.util.ArrayList;
import java.util.List;
import model.Onibus;
import util.ArquivoTXT;
import util.ArquivoPersistente;


public class OnibusController {
    private List<Onibus> listaOnibus = new ArrayList<>();
    private final ArquivoPersistente<Onibus> persistencia = new ArquivoTXT<>();
    private final String caminhoArquivo = "dados/onibus.txt";

    public OnibusController() {
        carregar();
    }

    public void adicionarOnibus(Onibus onibus) {
        listaOnibus.add(onibus);
        salvar();
    }

    public List<Onibus> listarOnibus() {
        return listaOnibus;
    }

    public void atualizarOnibus(int numeroId, String novoModelo, int novaCapacidade) {
    Onibus o = buscarPorIdentificador(numeroId);
        if (o != null) {
            o.setModelo(novoModelo);
            o.setCapacidade(novaCapacidade);
            salvar();
        }
    }
    
    public boolean removerPorIdentificador(int numeroId) {
        Onibus o = buscarPorIdentificador(numeroId);
        if (o != null) {
            listaOnibus.remove(o);
            salvar();
            return true;
        }
        return false;
    }


    public Onibus buscarPorIdentificador(int numeroId) {
        for (Onibus o : listaOnibus) {
            if (o.getNumeroIdentificacao() == numeroId) {
                return o;
            }
        }
        return null;
    }


    private void salvar() {
        persistencia.salvar(listaOnibus, caminhoArquivo);
    }

    private void carregar() {
        listaOnibus = persistencia.carregar(caminhoArquivo, Onibus::fromString);
    }
}
