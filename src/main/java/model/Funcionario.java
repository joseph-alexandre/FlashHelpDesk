
package model;

/**
 *
 * @author Joseph Alexandre.
 */
public class Funcionario extends Usuario{
    private String cod_empresa;
    private String cargo;

    public Funcionario(String cod_empresa, String cargo) {
        this.cod_empresa = cod_empresa;
        this.cargo = cargo;
        this.isFuncionario = true;
    }
    
    
    public String getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public boolean getIsFuncionario() {
        return isFuncionario;
    }
    
    public static void main(String[] args) {
        Funcionario f = new Funcionario("dsjdask", "dasjdas");
        System.out.println(f.getIsFuncionario());
    }
    
    
    
}
