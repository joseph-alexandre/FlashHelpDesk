package Util.TreeTableView;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;

public class PizzaPojo extends RecursiveTreeObject<PizzaPojo> {

    private final SimpleStringProperty sabor, preco;

    public PizzaPojo(String sabor, String preco) {
        this.sabor = new SimpleStringProperty(sabor);
        this.preco = new SimpleStringProperty(preco);
    }

    public String getSabor() {
        return sabor.get();
    }

    public SimpleStringProperty saborProperty() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor.set(sabor);
    }

    public String getPreco() {
        return preco.get();
    }

    public SimpleStringProperty precoProperty() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco.set(preco);
    }
}
