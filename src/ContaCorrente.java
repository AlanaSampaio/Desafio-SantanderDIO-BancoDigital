public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente  ====");
        System.out.println();
        super.imprimirInfosComuns();

    }

    public void implementarLimite(double valor) {
        limite += valor;
   }


}
