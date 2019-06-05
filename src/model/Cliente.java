package model;

public class Cliente extends Usuario{

    private Pedido pedido;
    private Mesa mesa;

    public Cliente(String nome, String cpf, String usuario, String senha, Mesa mesa) {
        super(nome, cpf, usuario, senha);
        this.mesa = mesa;
    }

    public Cliente(String usuario, String senha, Mesa mesa) {
        super(usuario, senha);
        this.mesa = mesa;
    }

    public Cliente(Mesa mesa) {
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

    public void fazerPedido(){
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.NÃO_FINALIZADO);
        this.pedido = pedido;
    }
    public void adicionarNoPedido(Produto produto) {
        pedido.addProdutos(produto);
    }

    public void efetuarPagamento(Comanda comanda){
        comanda.setStatusPagamento(StatusPagamento.PAGO);
    }

    @Override
    public String toString() {
        return super.toString() + "\nPedido: " + pedido
                + "\nMesa: " + mesa;
    }

    public static void main(String[] args) {

        Produto produto = new Produto();
        produto.setNome("Refrigerante");
        produto.setCod_barras("123456789");
        produto.setPreco(1.35f);

        Produto produto1 = new Produto("Bala", "322323", 2.3f);

        Cliente cliente = new Cliente("João", "21821821-02121", "João3223", "232323", Mesa.MESA_1);
        cliente.fazerPedido();
        cliente.adicionarNoPedido(produto);
        cliente.adicionarNoPedido(produto1);

        Funcionario funcionario = new Funcionario();
        funcionario.criarComanda(cliente);

        System.out.println(funcionario.getComanda());




    }
}
