package util;

import java.io.*;
import java.util.*;

public class ArquivoTXT<T> implements ArquivoPersistente<T> {

    @Override
    public void salvar(List<T> lista, String caminho) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (T obj : lista) {
                writer.write(obj.toString()); // Importante: o toString() deve retornar o formato gravável
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    @Override
    public List<T> carregar(String caminho) {
        // Esse método é genérico, mas não consegue reconstruir objetos sem saber o tipo.
        // A leitura deve ser feita com lógica específica nos controllers.
        return new ArrayList<>();
    }
}
