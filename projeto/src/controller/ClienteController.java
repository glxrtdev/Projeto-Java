package controller;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.ArquivoPersistente;
import util.ArquivoTXT;

public class ClienteController {
    
    private List<Cliente> listaClientes = new ArrayList<>();
    private final ArquivoPersistente<Cliente> persistencia = new ArquivoTXT<>();
     private Path caminhoArquivo;

    public ClienteController() {
        try {
            URI uri = getClass().getClassLoader().getResource("dados/clientes.txt").toURI();
            caminhoArquivo = Paths.get(uri);
            carregar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        salvar();
    }

    public List<Cliente> listarClientes() {
        System.out.println("Lista de clientes:");
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
        persistencia.salvar(listaClientes, caminhoArquivo.toString());

    }

    private void carregar() {
        listaClientes = persistencia.carregar(caminhoArquivo.toString(), Cliente::fromString);

    }

}
