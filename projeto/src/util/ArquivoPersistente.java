package util;

import java.util.List;

public interface ArquivoPersistente<T> {
    void salvar(List<T> lista, String caminho);
    List<T> carregar(String caminho);
}
