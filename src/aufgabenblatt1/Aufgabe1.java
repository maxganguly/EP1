package aufgabenblatt1;
/*
    Aufgabe 1) for-Schleifen
*/
public class Aufgabe1 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	int sum = 0;
    	for(int i = 17; i<=170;i++) {
    		sum+=i;
    	}
    	System.out.println(sum);
    	
    	for(int i = 60; i<=82;i++) {
    		if(i%6 == 0)
    			System.out.print(i+" ");
    	}
    	System.out.println();
    	
    	for(int i = 118; i<585;i++) {
    		if(i%9 == 0 && i%13 == 0)
    			System.out.print("+"+i);
    	}
    	System.out.println("+");
    	
    	for(int i = 65; i> 45;i--) {
    			System.out.print((char)i+" ");
    	}
    	System.out.println();
    	
    	String s = "Es ist kein echtes Edelmetall!";
    	sum = 0;
    	for(int i = 0; i<s.length();i++) {
    		if(s.charAt(i)== 'e' || s.charAt(i) == 'E')
    			sum++;
    	}
    	System.out.println(sum);
    }
}
