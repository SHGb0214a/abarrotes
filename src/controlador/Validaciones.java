package controlador;

public class Validaciones {
    public static boolean noNum(String texto){
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) { 
                return false; 
            }
        }
        return true;
    }
    
    public static boolean noEspacios(String texto){
        for(int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if(Character.isWhitespace(c)){
                return false;
            }
        }
        return true;
    }
    public static boolean soloNum(){
        return true;
    }
}
