
package model;

/**
 *
 * @author Joseph Alexandre.
 */
public class Cliente extends Usuario{

    public Cliente() {
        this.isFuncionario = false;
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
        Cliente c = new Cliente();
        System.out.println(c.getIsFuncionario());
    }
    
}
