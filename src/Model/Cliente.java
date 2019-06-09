package Model;

import Database.DAO.DAOPersistente.DAOCliente;
import Database.DAO.DAOPersistente.DAOFuncionario;
import Database.DAO.DAOPersistente.DAOProduto;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Cliente extends Usuario {
    private int id;
    private Pedido pedido;
    private Mesa mesa;

    public Cliente(String nome, String cpf, String usuario, String senha) {
        super(nome, cpf, usuario, senha);
        this.mesa = mesa;
    }

    public Cliente(String usuario, String senha) {
        super(usuario, senha);
        this.mesa = mesa;
    }

    public Cliente() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void fazerPedido() {
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.NÃO_FINALIZADO);
        this.pedido = pedido;
    }

    public void adicionarNoPedido(Produto produto) {
        try {
            pedido.addProdutos(produto);
        } catch (NullPointerException e) {
            System.out.println("É necessário fazer um pedido antes de adicionar um produto!");
        }
    }

    public void efetuarPagamento(Comanda comanda) {
        pedido.setStatus(StatusPedido.FINALIZADO);
        comanda.setStatusPagamento(StatusPagamento.PAGO);
    }

    @Override
    public String toString() {
        return "[" + super.toString() + "\nPedido: " + pedido
                + "\nMesa: " + mesa + "]\n";
    }

    public static void main(String[] args) {

//        Produto produto = new Produto();
//        produto.setNome("Coca");
//        produto.setCod_barras("123456789");
//        produto.setPreco(20.0f);

        Produto produto1 = new Produto("Bala", "322323", 2.3f);
//
        Cliente cliente = new Cliente("João", "21821821-02121", "João3223", "232323");
        Cliente cliente1 = new Cliente("John Smith", "323232-02121", "John5543", "232323");
        cliente.fazerPedido();
        cliente.adicionarNoPedido(produto1);
//        cliente.fazerPedido();
//        cliente.adicionarNoPedido(produto);
//        cliente.adicionarNoPedido(produto1);
//
//        Funcionario funcionario = new Funcionario();
//        funcionario.setNome("Joseph Alexandre");
//        funcionario.setCpf("619.152.363-71");
//        funcionario.setCod_empresa("23232323");
//        funcionario.setUsuario("Joseph5543");
//        funcionario.setSenha("5543");
//        funcionario.criarComanda(cliente);
//        cliente.efetuarPagamento(funcionario.getComanda());
//        System.out.println(funcionario.getComanda());

        DAOCliente daoCliente = new DAOCliente();
        daoCliente.adicionar(cliente);
        daoCliente.adicionar(cliente1);
        System.out.println(daoCliente.listarTodos());


    }
}
