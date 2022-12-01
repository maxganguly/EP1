package aufgabenblatt3;
/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addSign(String text, char sign) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	addSign(text, sign+"");
    }

    private static void addSign(int number, char sign) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	addSign(number+"", sign+"");
    }

    private static void addSign(String text, String signs) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	String newstring = "";
    	for(int i = 0; i < text.length();i++) {
    		newstring += text.charAt(i);
    		for(int count = 0; count <= i;count++) {
    			newstring+=signs;
    		}
    	}
    	System.out.println(newstring);
    }

    private static void addSign(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	addSign(text, "=");
    }

    public static void main(String[] args) {
        String text0 = "";
        String text1 = "IT";
        String text2 = "Hello!";
        String text3 = "+EP1+";
        String text4 = "INT";

        addSign(text0, '+');
        addSign(text1, '-');
        addSign(text2, '#');
        addSign(text3, '&');
        addSign(text4, '*');
        System.out.println();

        addSign(1, '$');
        addSign(42, '%');
        addSign(183, '.');
        addSign(4096, ':');
        addSign(65536, ']');
        System.out.println();

        addSign(text1, "/X/");
        addSign(text2, "(#?§");
        System.out.println();

        addSign(text0);
        addSign(text1);
        addSign(text2);
    }
}
