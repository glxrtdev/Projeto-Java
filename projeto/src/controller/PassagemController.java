package controller;

import java.util.ArrayList;
import java.util.List;
import model.Passagem;
import util.ArquivoPersistente;
import util.ArquivoTXT;



public class PassagemController {
    private List<Passagem> listaPassagens = new ArrayList<>();
    private final ArquivoPersistente<Passagem> persistencia = new ArquivoTXT<>();
    private final String caminhoArquivo = "dados/passagens.txt";

    public PassagemController() {
        carregar();
    }

    public void adicionarPassagem(Passagem passagem) {
        listaPassagens.add(passagem);
        salvar();
    }

    public List<Passagem> listarPassagens() {
        return listaPassagens;
    }

    public Passagem buscarPorId(int idPassagem) {
        for (Passagem p : listaPassagens) {
            if (p.getIdPassagem() == idPassagem) {
                return p;
            }
        }
        return null;
    }

    public void atualizarPassagem(int idPassagem, int novoIdOnibus, String novaData, String novoNomePassageiro, double valor) {
        Passagem p = buscarPorId(idPassagem);
        if (p != null) {
            p.setNumeroOnibus(novoIdOnibus);
            p.setDataViagem(novaData);
            p.setNomePassageiro(novoNomePassageiro);
            p.setValor(valor);
            salvar();
        }
    }

    public boolean removerPorId(int idPassagem) {
        Passagem p = buscarPorId(idPassagem);
        if (p != null) {
            listaPassagens.remove(p);
            salvar();
            return true;
        }
        return false;
    }

    private void salvar() {
        persistencia.salvar(listaPassagens, caminhoArquivo);
    }

    private void carregar() {
        listaPassagens = persistencia.carregar(caminhoArquivo, Passagem::fromString);
    }
}