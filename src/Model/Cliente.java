package Model;

import Database.DAO.DAOPersistente.DAOCliente;

public class Cliente extends Pessoa{

    private String endereco;
    private String telefone;

    public Cliente(String nome, String cpf, String endereco, String telefone) {
        super(nome, cpf);
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente(String endereco, String telefone) {
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente(){

    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente: \n" + super.toString() + "\nEndereço: " + endereco + "\nTelefone: " + telefone;
    }

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("John Silvessdr");
        cliente.setCpf("619.152.363-7sdds1");
        cliente.setTelefone("(47)99902-dsds9982");
        cliente.setEndereco("Rua Conquidsdssta");
        DAOCliente daoCliente = new DAOCliente();
        daoCliente.adicionar(cliente);
        System.out.println(daoCliente.listarTodos());

    }
}
