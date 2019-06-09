package Database.DAO;

import java.util.List;

public interface DAOInterface<T>  {

    public boolean adicionar(T thing);

    public T pegarPorId(int id);

    public boolean remover(int id);

    public boolean alterar(T thing);

    public List<T> listarTodos();

}
