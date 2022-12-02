package aufgabenblatt2;
/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {

    //TODO: Implementieren Sie hier die in der Angabe beschriebenen Methoden
	public static void printChar(char c) {
		System.out.println(c);
	}
	public static void printAlphabetPartsReverse(char startChar) {
		while(startChar >= 'a' && startChar <= 'z') {
			printChar(startChar);
			startChar--;
		}
	}
	public static int calcSum(int start, int end) {
		if(start <1 || end < 1 || end < start) {
			return -1;
		}
		int sum = 0;
		while(start <= end) {
			sum+=start;
			start++;
		}
		return sum;
	}
	public static boolean isAsciiValueInRange(char sign,char start,char end) {
		return (sign >= start && sign <= end);
	}
	public static String removeInString789(String text) {
		String neu = "";
		char c;
		for(int i = 0; i < text.length(); i++) {
			c = text.charAt(i);
			if(!(c >= '7' && c <= '9'))
				neu += c;
		}
		return neu;
	}
    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //ENTFERNEN SIE DIE KOMMENTARE, UM IHRE METHODEN ZU TESTEN.
        //*
        assert (calcSum(1,1) == 1);
        assert (calcSum(1,3) == 6);
        assert (calcSum(20,22) == 63);
        assert (calcSum(10,356) == 63501);

        assert (isAsciiValueInRange('B', 'A', 'G'));
        assert (!isAsciiValueInRange('!', '0', 'Z'));
        assert (isAsciiValueInRange('A','A', 'A'));
        assert (isAsciiValueInRange('B', 'A', 'C'));
        assert (isAsciiValueInRange(':', '8', 'D'));
        assert (!isAsciiValueInRange('+', '5', 'A'));

        assert (removeInString789("").equals(""));
        assert (removeInString789("7").equals(""));
        assert (removeInString789("67").equals("6"));
        assert (removeInString789("7493").equals("43"));
        assert (removeInString789("Hallo 0123456789:").equals("Hallo 0123456:"));
        assert (removeInString789("Telefonnummer 120, 178 oder 911?").equals("Telefonnummer 120, 1 oder 11?"));
        //*/
        //**********************************************************************

        //TODO: Testen Sie hier zusätzlich alle Methoden mit verschiedenen Inputs!
        System.out.println(calcSum(1,1));
        System.out.println(calcSum(1,3));
        System.out.println(calcSum(20,22));
        System.out.println(calcSum(10,356));
        System.out.println(isAsciiValueInRange('B', 'A', 'G'));
        System.out.println(!isAsciiValueInRange('!', '0', 'Z'));
        System.out.println(isAsciiValueInRange('A','A', 'A'));
        System.out.println(isAsciiValueInRange('B', 'A', 'C'));
        System.out.println(isAsciiValueInRange(':', '8', 'D'));
        System.out.println(!isAsciiValueInRange('+', '5', 'A'));
        System.out.println(removeInString789(""));
        System.out.println(removeInString789("7"));
        System.out.println(removeInString789("67"));
        System.out.println(removeInString789("7493"));
        System.out.println(removeInString789("Hallo 0123456789:"));
        System.out.println(removeInString789("Telefonnummer 120, 178 oder 911?"));

    }
}
