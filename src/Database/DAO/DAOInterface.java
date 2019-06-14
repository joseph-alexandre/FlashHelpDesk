package Database.DAO;

import java.util.List;

public interface DAOInterface<T>  {

    public boolean adicionar(T thing);

    public T pegarPeloNome(String nome);

    public boolean removerPeloNome(String nome);

    public boolean alterar(T thing);

    public List<T> listarTodos();



}
