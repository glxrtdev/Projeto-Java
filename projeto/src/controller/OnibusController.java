package controller;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Onibus;
import util.ArquivoTXT;
import util.ArquivoPersistente;


public class OnibusController {
    private List<Onibus> listaOnibus = new ArrayList<>();
    private final ArquivoPersistente<Onibus> persistencia = new ArquivoTXT<>();
    private Path caminhoArquivo;

    public OnibusController() {
        try {
            URI uri = getClass().getClassLoader().getResource("dados/onibus.txt").toURI();
            caminhoArquivo = Paths.get(uri);
            carregar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarOnibus(Onibus onibus) {
        listaOnibus.add(onibus);
        salvar();
    }

    public List<Onibus> listarOnibus() {
        System.out.println("Lista de ônibus:");
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
            if (o.getId() == numeroId) {
                return o;
            }
        }
        return null;
    }


    private void salvar() {
        persistencia.salvar(listaOnibus, caminhoArquivo.toString());
    }

    private void carregar() {
        listaOnibus = persistencia.carregar(caminhoArquivo.toString(), Onibus::fromString);
    }

}
