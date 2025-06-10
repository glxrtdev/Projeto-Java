package controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.ArquivoPersistente;
import util.ArquivoTXT;
import util.Logger;

public class ClienteController {
    
    private List<Cliente> listaClientes = new ArrayList<>();
    private final ArquivoPersistente<Cliente> persistencia = new ArquivoTXT<>();
    private Path caminhoArquivo;

    public ClienteController() {
        try {
            caminhoArquivo = Paths.get(System.getProperty("user.dir"), "projeto", "src", "dados", "clientes.txt");
            carregar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        Logger.registrar("Cliente " + cliente.getNome() +  " registrado(a).");
        salvar();
    }

    public List<Cliente> listarClientes() {
        System.out.println("Lista de clientes:");
        Logger.registrar("Lista de clientes exibida.");
        return listaClientes;  
    }

    public Cliente buscarPorNome(String nomeCliente) {
        Logger.registrar("Busca por cliente realizada.");
        for (Cliente c : listaClientes) {
            if (c.getNome().equals(nomeCliente)) {
                return c;
            }
        }
        return null;
    } 

    public boolean removerPorNome(String nome) {
        Logger.registrar("Cliente " + nome + " removido(a).");
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
