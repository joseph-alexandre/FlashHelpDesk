package Util;

public class Validacao {

    public static boolean validarCampo(String campo){
        if (campo.length() <= 0){
            return false;
        } else {
            return true;
        }

    }
}
