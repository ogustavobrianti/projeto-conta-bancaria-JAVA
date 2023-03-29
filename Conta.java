import java.util.UUID;

public class Conta {
    private final String id;
    private String nome;
    private String banco;
    private String agencia;
    private double saldo;

    public Conta(String nome, String banco, String agencia, double saldo) {
        this.id = this.gerarId();
        this.nome = nome;
        this.banco = banco;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    private String gerarId() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "== Dados da conta ==\n"
                + "Id: " + this.getId() + "\n"
                + "Nome: " + this.getNome() + "\n"
                + "Banco: " + this.getBanco() + "\n"
                + "Agência: " + this.getAgencia() + "\n"
                + "Saldo: " + this.getSaldo() + "\n";
    }
}
