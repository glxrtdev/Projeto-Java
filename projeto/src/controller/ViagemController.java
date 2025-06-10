package controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Viagem;
import util.ArquivoPersistente;
import util.ArquivoTXT;
import util.Logger;

public class ViagemController {
    private List<Viagem> listaViagens = new ArrayList<>();
    private final ArquivoPersistente<Viagem> persistencia = new ArquivoTXT<>();
    private Path caminhoArquivo;

    public ViagemController() {
        try {
            caminhoArquivo = Paths.get(System.getProperty("user.dir"),"projeto", "src", "dados", "viagens.txt");
            carregar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void adicionarViagem(Viagem viagem) {
        listaViagens.add(viagem);
        Logger.registrar("Viagem adicionada.");
        salvar();
    }

    public List<Viagem> listarViagens() {
        System.out.println("Lista de viagens:");
        Logger.registrar("Lista de viagens exibida.");
        return listaViagens;
    }

    public Viagem buscarPorIdentificador(int id) {
        Logger.registrar("Busca por viagem realizada.");
        for (Viagem v : listaViagens) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public void atualizarViagem(int id, String novoDestino, String novaData, int novoOnibusId) {
        Logger.registrar("Viagem atualizada.");
        Viagem v = buscarPorIdentificador(id);
        if (v != null) {
            v.setDestino(novoDestino);
            v.setData(novaData);
            v.setOnibusId(novoOnibusId);
            salvar();
        }
    }

    public boolean removerPorIdentificador(int id) {
        Logger.registrar("Viagem removida.");
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