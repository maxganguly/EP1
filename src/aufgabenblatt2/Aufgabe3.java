package aufgabenblatt2;
/*
    Aufgabe 3) Verschachtelung von Schleifen und Methoden - Fröhliche Zahlen
*/
public class Aufgabe3 {

    public static boolean isHappyNumber(int number) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	while(number >0){
    		int sum = 0;
    		while(number >0){
    			int div = number % 10;
    			sum += div*div;
    			number /= 10;
   			}
   			if(sum == 1) {
   				return true;
   			}
   			else if(sum == 4) {
   				return false;
   			}
   			number = sum;
   		}
   		return false;
   	}

    private static int countHappyNumbers(int start, int end) {
        int count = 0;
        while(start <= end) {
        	if(isHappyNumber(start))
        		count++;
        	start++;
        }
        return count; //Zeile kann geändert oder entfernt werden.
    }

    private static void printHappyNumbers(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	while(start <= end) {
        	if(isHappyNumber(start))
        		System.out.print(start+" ");
        	start++;
        }
    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE isHappyNumber(...).
        System.out.println("23 --> " + isHappyNumber(23));
        assert (isHappyNumber(23));
        System.out.println("97 --> " + isHappyNumber(97));
        assert (isHappyNumber(97));
        System.out.println("7 --> " + isHappyNumber(7));
        assert (isHappyNumber(7));
        assert (isHappyNumber(1));
        System.out.println("58 --> " + isHappyNumber(58));
        assert (!isHappyNumber(58));
        System.out.println("40 --> " + isHappyNumber(40));
        assert (!isHappyNumber(40));
        System.out.println("5 --> " + isHappyNumber(5));
        assert (!isHappyNumber(5));
        assert (!isHappyNumber(4));
        System.out.println();
        //**********************************************************************

        //TODO: Testen Sie hier alle Methoden mit verschiedenen Inputs!
        System.out.println(countHappyNumbers(0, 100));
        printHappyNumbers(0, 100);
    }
}
