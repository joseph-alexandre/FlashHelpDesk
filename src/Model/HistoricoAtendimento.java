//package Model;
//
//import java.util.List;
//
//public class HistoricoAtendimento {
//
//    private Funcionario funcionario;
//    private List<Pedido> listaDePedidos;
//
//    public HistoricoAtendimento(Funcionario funcionario, List<Pedido> listaDePedidos) {
//        this.funcionario = funcionario;
//        this.listaDePedidos = listaDePedidos;
//    }
//
//    public HistoricoAtendimento() {
//    }
//
//    public Funcionario getFuncionario() {
//        return funcionario;
//    }
//
//    public void setFuncionario(Funcionario funcionario) {
//        this.funcionario = funcionario;
//    }
//
//    public List<Pedido> getListaDePedidos() {
//        return listaDePedidos;
//    }
//
//    public void setListaDePedidos(List<Pedido> listaDePedidos) {
//        this.listaDePedidos = listaDePedidos;
//    }
//
//    public Cliente pegarClienteDoPedido(){
//        Cliente cliente = null;
//        for (Pedido pedido: listaDePedidos){
//            cliente.setNome(pedido.getCliente().getNome());
//        }
//
//
//    }
//
//    @Override
//    public String toString() {
//        return "Histórico de Atendimento: " + "\nAtendimento efetuado por: " + funcionario + "\nPara o cliente: " + listaDePedidos.;
//    }
//}
