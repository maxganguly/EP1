package aufgabenblatt1;
/*
    Aufgabe 2) while-Schleifen
*/
public class Aufgabe2 {

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	String text = "Wir beginnen am Anfang mit den Grundlagen.";
    	//String text = "Kein gesuchtes Zeichen im String!";
    
    	int i = 1;
    	while(i < text.length()) {
    		if(text.charAt(i) != 'a') {
    			System.out.print(text.charAt(i));
    		}
    		i+=2;
    	}
    	System.out.println();
    	
    	int index = -1;
    	i = 0;
    	while(i < text.length()) {
    		if(text.charAt(i) == 's') {
    			index = i;
    			break;
    		}
    		i++;
    	}
    	System.out.println(index);
    	
    	i = 18;
    	while(i < 238) {
    		if(i%17 == 0) {
    			System.out.print(i+" ");
    		}
    		i++;
    	}
    	System.out.println();
    	
    	int count = 0;
    	i = text.length()-1;
    	while(i >= 0 ) {
    		if(text.charAt(i) == 'e') {
    			count++;
    			if(count == 3)
    			break;
    		}
    		System.out.print(text.charAt(i));
    		i--;
    	}
    	
    	count = 0;
    	i = 0;
    	while(i < text.length()) {
    		if(text.charAt(i) == '.' || text.charAt(i) == '!') {
    			count++;

    		}
    		i++;
    	}
    	System.out.println(count);
    }
}






