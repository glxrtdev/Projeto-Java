package util;

import java.util.List;
import java.util.function.Function;

public interface ArquivoPersistente<T> {
    void salvar(List<T> lista, String caminho);

    List<T> carregar(String caminho, Function<String, T> conversor);
}
