package Model;

public enum Mesa {
    MESA_1("Mesa 1"),
    MESA_2("Mesa 2"),
    MESA_3("Mesa 3"),
    MESA_4("Mesa 4"),
    MESA_5("Mesa 5"),
    MESA_6("Mesa 6"),
    MESA_7("Mesa 7"),
    MESA_8("Mesa 8");

    private String mesa;
    Mesa(String mesa) {
        this.mesa = mesa;
    }

    public String getMesa() {
        return mesa;
    }
}
