package Model;

public class Funcionario extends Usuario {
    private int id;
    private String cod_empresa;
    private Comanda comanda;
    public Funcionario(String nome, String cpf, String usuario, String senha, String cod_empresa, Comanda comanda) {
        super(nome, cpf, usuario, senha);
        this.cod_empresa = cod_empresa;
        this.comanda = comanda;
    }

    public Funcionario(String usuario, String senha, String cod_empresa, Comanda comanda) {
        super(usuario, senha);
        this.cod_empresa = cod_empresa;
        this.comanda = comanda;
    }

    public Funcionario(String cod_empresa, Comanda comanda) {
        this.cod_empresa = cod_empresa;
        this.comanda = comanda;
    }

    public Funcionario(){
    }

    public String getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comanda criarComanda(Cliente cliente){
        comanda = new Comanda(cliente);
        return comanda;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCódigo da empresa: " + cod_empresa;
    }
}
