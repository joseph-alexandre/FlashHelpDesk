
package model;

/**
 *
 * @author Usuario
 */
public abstract class Usuario extends Pessoa{
    protected Login login;
    protected boolean isFuncionario;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public boolean getIsFuncionario() {
        return isFuncionario;
    }

    public void setIsFuncionario(boolean isFuncionario) {
        this.isFuncionario = isFuncionario;
    }
    
    
}
