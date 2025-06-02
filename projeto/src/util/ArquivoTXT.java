package util;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class ArquivoTXT<T> implements ArquivoPersistente<T> {

    @Override
    public void salvar(List<T> lista, String caminho) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (T item : lista) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @Override
    public List<T> carregar(String caminho, Function<String, T> conversor) {
        List<T> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                T objeto = conversor.apply(linha);
                lista.add(objeto);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar: " + e.getMessage());
        }
        return lista;
    }
}
