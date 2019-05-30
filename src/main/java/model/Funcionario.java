package model;

public class Funcionario extends Usuario {

    private String cod_empresa;

    public Funcionario(String nome, String cpf, String usuario, String senha, String cod_empresa, String cargo) {
        super(nome, cpf, usuario, senha);
        this.cod_empresa = cod_empresa;
    }

    public Funcionario(String usuario, String senha, String cod_empresa, String cargo) {
        super(usuario, senha);
        this.cod_empresa = cod_empresa;
    }

    public Funcionario(String cod_empresa, String cargo) {
        this.cod_empresa = cod_empresa;
    }

    public Funcionario(){
    }

    public String getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public Comanda criarComanda(Cliente cliente){
        Comanda comanda = new Comanda(cliente);
        return comanda;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCódigo da empresa: " + cod_empresa;
    }

}
