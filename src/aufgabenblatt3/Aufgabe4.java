package aufgabenblatt3;
/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static int countNOrderedPairs(String text, int index) {
    	if(text.length() < index+2)
    		return 0;
    	return countNOrderedPairs(text, index+1)+((text.charAt(index) <=  text.charAt(index+1))?1:0);
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
    }

    private static String shiftAllSignsRight(String text, char sign) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
    	if(text == null || text.isEmpty())
    		return "";
    	if(text.charAt(0) == sign) {
    		return shiftAllSignsRight(text.substring(1), sign)+sign;
    	}else {
    		return text.charAt(0)+shiftAllSignsRight(text.substring(1), sign);
    	}
    }

    public static void main(String[] args) {
        String text = "bhhebegcmoqast";
        System.out.println(countNOrderedPairs(text, 0));
        System.out.println(countNOrderedPairs(text, 2));
        System.out.println(countNOrderedPairs(text, 5));
        System.out.println(countNOrderedPairs(text, 6));
        System.out.println(countNOrderedPairs(text, 8));
        System.out.println();

        System.out.println(shiftAllSignsRight("az3kj", 'z'));
        System.out.println(shiftAllSignsRight("kjdn{nd8xngs+d#k", 'n'));
        System.out.println(shiftAllSignsRight("", 'e'));
        System.out.println(shiftAllSignsRight("4", '4'));
        System.out.println(shiftAllSignsRight("ji)o3ie6pk(2i", 'i'));
        System.out.println(shiftAllSignsRight("nothing", 'x'));

        assert (countNOrderedPairs(text, 0) == 9);
        assert (countNOrderedPairs(text, 2) == 7);
        assert (countNOrderedPairs(text, 5) == 6);
        assert (countNOrderedPairs(text, 6) == 5);
        assert (countNOrderedPairs(text, 8) == 4);

        assert (shiftAllSignsRight("az3kj", 'z').equals("a3kjz"));
        assert (shiftAllSignsRight("kjdn{nd8xngs+d#k",'n').equals("kjd{d8xgs+d#knnn"));
        assert (shiftAllSignsRight("", 'e').equals(""));
        assert (shiftAllSignsRight("4", '4').equals("4"));
        assert (shiftAllSignsRight("ji)o3ie6pk(2i", 'i').equals("j)o3e6pk(2iii"));
        assert (shiftAllSignsRight("nothing", 'x').equals("nothing"));
    }
}
