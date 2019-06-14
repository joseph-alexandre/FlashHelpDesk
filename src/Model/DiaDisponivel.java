package Model;

public enum DiaDisponivel {

    SEGUNDA_FEIRA("Segunda-feira, das 19 horas às 03:00"),
    TERCA_FEIRA("Terça-feira, das 19 horas às 03:00"),
    QUARTA_FEIRA("Quarta-feira, das 19 horas às 03:00"),
    QUINTA_FEIRA("Quinta-feira, das 19 horas às 03:00"),
    SEXTA_FEIRA("Sexta-feira, das 19 horas às 03:00"),
    SABADO("Sábado, das 19 horas às 03:00");

    private String diaDisponivel;

    DiaDisponivel(String diaDisponivel) {
        this.diaDisponivel = diaDisponivel;
    }

    public String getDiaDisponivel() {
        return diaDisponivel;
    }
}
