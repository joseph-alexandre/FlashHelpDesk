package Model;

public class Funcionario extends Usuario {

    private String cod_matricula;

    public Funcionario(String nome, String cpf, String usuario, String senha, String cod_matricula) {
        super(nome, cpf, usuario, senha);
        this.cod_matricula = cod_matricula;
    }

    public Funcionario(String cod_matricula) {
        this.cod_matricula = cod_matricula;
    }

    public Funcionario() {

    }

    public String getCod_matricula() {
        return cod_matricula;
    }

    public void setCod_matricula(String cod_matricula) {
        this.cod_matricula = cod_matricula;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCódigo da empresa: " + cod_matricula;
    }
}
