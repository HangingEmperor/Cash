public class prueba {

    public static void main(String[] args) {
        String aux = "1                    \n";
        if (aux.matches("^+[\\d]\\p{Space}+")) {
            System.out.println("ok");
        }
    }
}
