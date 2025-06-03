package controller;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Motorista;
import util.ArquivoPersistente;
import util.ArquivoTXT;

public class ClienteController {
    
    private List<Cliente> listaClientes = new ArrayList<>();
    private final ArquivoPersistente<Cliente> persistencia = new ArquivoTXT<>();
    private final String caminhoArquivo = "projeto/dados/clientes.txt";

    public  ClienteController() {
        carregar();
    }

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        salvar();
    }

    public List<Cliente> listarClientes() {
        return listaClientes;
    }

    public Cliente buscarPorNome(String nomeCliente) {
        for (Cliente c : listaClientes) {
            if (c.getNome().equals(nomeCliente)) {
                return c;
            }
        }
        return null;
    } 

    public boolean removerPorNome(String nome) {
        Cliente c = buscarPorNome(nome);
        if (c != null) {
            listaClientes.remove(c);
            salvar();
            return true;
        }
        return false;
    }

    private void salvar() {
        persistencia.salvar(listaClientes, caminhoArquivo);
    }

    private void carregar() {
        listaClientes = persistencia.carregar(caminhoArquivo, Cliente::fromString);
    }

}
