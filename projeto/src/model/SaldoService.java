package src.model;

public class SaldoService {
    private Usuario usuario;

    public SaldoService(Usuario usuario) {
        this.usuario = usuario;
    }

    public void recarregar(double valor) {
        usuario.adicionarSaldo(valor);
    }

    public boolean retirar(double valor) {
        return usuario.retirarSaldo(valor);
    }

    public double consultarSaldo() {
        return usuario.getSaldo();
    }
}
