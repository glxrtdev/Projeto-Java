package controller;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Passagem;
import util.ArquivoPersistente;
import util.ArquivoTXT;
import util.Logger;



public class PassagemController {
    private List<Passagem> listaPassagens = new ArrayList<>();
    private final ArquivoPersistente<Passagem> persistencia = new ArquivoTXT<>();
    private Path caminhoArquivo;

    public PassagemController() {
        try {
            caminhoArquivo = Paths.get(System.getProperty("user.dir"), "projeto", "src", "dados", "passagens.txt");
            carregar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void adicionarPassagem(Passagem passagem) {
        listaPassagens.add(passagem);
        Logger.registrar("Passagem adicionada.");
        salvar();
    }

    public List<Passagem> listarPassagens() {
        System.out.println("Lista de passagens:");
        Logger.registrar("Lista de passagens exibida.");
        return listaPassagens;
    }

    public Passagem buscarPorId(int idPassagem) {
        Logger.registrar("Busca por passagem realizada.");
        for (Passagem p : listaPassagens) {
            if (p.getIdPassagem() == idPassagem) {
                return p;
            }
        }
        return null;
    }

    public void atualizarPassagem(int idPassagem, int novoIdOnibus, String novaData, String novoNomePassageiro, double valor) {
        Logger.registrar("Passagem atualizada.");
        Passagem p = buscarPorId(idPassagem);
        if (p != null) {
            p.setIdOnibus(novoIdOnibus);
            p.setDataViagem(novaData);
            p.setNomePassageiro(novoNomePassageiro);
            p.setValor(valor);
            salvar();
        }
    }

    public boolean removerPorId(int idPassagem) {
        Logger.registrar("Passagem removida.");
        Passagem p = buscarPorId(idPassagem);
        if (p != null) {
            listaPassagens.remove(p);
            salvar();
            return true;
        }
        return false;
    }

    private void salvar() {
        persistencia.salvar(listaPassagens, caminhoArquivo.toString());
    }

    private void carregar() {
        listaPassagens = persistencia.carregar(caminhoArquivo.toString(), Passagem::fromString);
    }

  
}

