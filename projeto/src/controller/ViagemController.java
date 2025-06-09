package controller;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Viagem;
import util.ArquivoPersistente;
import util.ArquivoTXT;

public class ViagemController {
    private List<Viagem> listaViagens = new ArrayList<>();
    private final ArquivoPersistente<Viagem> persistencia = new ArquivoTXT<>();
    private Path caminhoArquivo;

    public ViagemController() {
        try {
            URI uri = getClass().getClassLoader().getResource("dados/viagens.txt").toURI();
            caminhoArquivo = Paths.get(uri);
            carregar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarViagem(Viagem viagem) {
        listaViagens.add(viagem);
        salvar();
    }

    public List<Viagem> listarViagens() {
        System.out.println("Lista de viagens:");
        return listaViagens;
    }

    public Viagem buscarPorIdentificador(int id) {
        for (Viagem v : listaViagens) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public void atualizarViagem(int id, String novoDestino, String novaData, int novoOnibusId) {
        Viagem v = buscarPorIdentificador(id);
        if (v != null) {
            v.setDestino(novoDestino);
            v.setData(novaData);
            v.setOnibusId(novoOnibusId);
            salvar();
        }
    }

    public boolean removerPorIdentificador(int id) {
        Viagem v = buscarPorIdentificador(id);
        if (v != null) {
            listaViagens.remove(v);
            salvar();
            return true;
        }
        return false;
    }

    private void salvar() {
        persistencia.salvar(listaViagens, caminhoArquivo.toString());
    }

    private void carregar() {
        listaViagens = persistencia.carregar(caminhoArquivo.toString(), Viagem::fromString);
    }
}