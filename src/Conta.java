public abstract class Conta implements IConta {
  private static final int Agencia_Padrao = 1;
  private static int SEQUENCIAL = 1;

  protected int agencia;
  protected int numero;
  protected double saldo;
  protected double limite =0.0;
  protected Cliente cliente;

  public Conta(Cliente cliente){
    this.agencia = Conta.Agencia_Padrao;
    this.numero = SEQUENCIAL++;
    this.cliente = cliente;
    this.limite = 0.0;
  }

  public int getAgencia() {
    return agencia;
  }

  public void setAgencia(int agencia) {
    this.agencia = agencia;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public double getLimite() {
    return limite;
  }

  public void setLimite(double limite) {
    this.limite = limite;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  @Override
  public void sacar(double valor) {
    if(saldo > valor)
        saldo -= valor;
    else {
      double diferenca = valor - saldo;
      limite = (limite - diferenca);
      saldo = saldo - (valor - diferenca);


    }
  }

  @Override
  public void depositar(double valor) {
    saldo += valor;
  }

  @Override
  public void transferir(double valor, Conta contaDestino) {
    this.sacar(valor);
    contaDestino.depositar(valor);
  }

  @Override
  public void adicionarLimite(double valor) {
    this.setLimite(valor);
  }

  protected void imprimirInfosComuns(){
    System.out.println(String.format("Titular: %s", this.cliente.getNome()));
    System.out.println(String.format("Agencia: %d", this.agencia));
    System.out.println(String.format("Numero: %d", this.numero));
    System.out.println(String.format("Limite: %.2f", this.limite));
    System.out.println(String.format("Saldo: %.2f", this.saldo));
  }
}
