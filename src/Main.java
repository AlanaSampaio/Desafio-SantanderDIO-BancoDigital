public class Main {
    public static void main(String[] args) {
        Cliente maria = new Cliente();
        maria.setNome("Maria");

        Conta cc = new ContaCorrente(maria);
        Conta poupanca = new ContaPoupanca(maria);

        cc.adicionarLimite(300);
        cc.depositar(225);
        cc.transferir(200,poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}
