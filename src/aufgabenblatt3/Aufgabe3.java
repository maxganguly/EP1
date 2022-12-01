package aufgabenblatt3;
/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printEvenNumbersAscending(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
    	if(start > end)
    		return;
    	if(start%2 == 1)
    		start++;
    	System.out.println(start);
		printEvenNumbersAscending(start+2, end);
    }

    private static void printOddNumbersDescending(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
    	if(start > end)
    		return;
    	if(end%2 == 0)
    		end--;
    	System.out.println(end);
    	printOddNumbersDescending(start, end-2);
    }

    private static int sumSquaredDigits(int number) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
    	if(number == 0)
    		return 0;
    	return (int) (sumSquaredDigits(number/10)+Math.pow(number%10, 2));
    }

    private static String removeSpaces(String text) {
    	if(text.isBlank())
    		return "";
    	return ((text.charAt(0)== ' ')?"":text.charAt(0))+removeSpaces(text.substring(1));
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
    }

    public static void main(String[] args) {
        printEvenNumbersAscending(10, 20);
        System.out.println();
        printOddNumbersDescending(5, 15);
        System.out.println();

        System.out.println(sumSquaredDigits(1));
        System.out.println(sumSquaredDigits(102));
        System.out.println(sumSquaredDigits(1234));
        System.out.println(sumSquaredDigits(10000));
        System.out.println(sumSquaredDigits(93842));
        System.out.println(sumSquaredDigits(875943789));
        assert (sumSquaredDigits(1) == 1);
        assert (sumSquaredDigits(102) == 5);
        assert (sumSquaredDigits(1234) == 30);
        assert (sumSquaredDigits(10000) == 1);
        assert (sumSquaredDigits(93842) == 174);
        assert (sumSquaredDigits(875943789) == 438);
        System.out.println();

        System.out.println(removeSpaces(" "));
        System.out.println(removeSpaces("+ +"));
        System.out.println(removeSpaces(" 12 3 45 "));
        System.out.println(removeSpaces("a  b   c    d"));
        assert (removeSpaces(" ").equals(""));
        assert (removeSpaces("+ +").equals("++"));
        assert (removeSpaces(" 12 3 45 ").equals("12345"));
        assert (removeSpaces("a  b   c    d").equals("abcd"));
    }
}

