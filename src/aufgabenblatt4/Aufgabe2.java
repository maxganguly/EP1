package aufgabenblatt4;
/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

	public static void printArrayformatted(int[] values, String seperator) {
		String output = "";
		for(int i = 0; i < values.length;i++) {
			output += values[i]+seperator;
		}
		if(output.length() > 1) {
			output = output.substring(0, output.length()-seperator.length());
		}
		System.out.println(output);
	}
	public static int[] insertAt(int[] array , int index, int value) {
		if(array == null || index < 0 || index > array.length)
			return null;
		int[] newarray = new int[array.length+1];
		for(int i = 0; i < newarray.length; i++) {
			if(i == index+1) {
				newarray[i] = value;
			}else if(i < index+1) {
				newarray[i] = array[i];
			}else {
				newarray[i] = array[i-1];
			}
		}
		return newarray;
	}
    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	//a
    	int[] a = new int[]{6, 1, 8, 2, 5, 3, 4, 7, 9, 0};
    	printArrayformatted(a, "#");
    	//b
    	int length = 12;
    	int[] b = new int[length];
    	for(int i = 1; i <= b.length;i++) {
    		if(6*i % 9 == 0) {
    			b[i-1] = 0;
    		}else {
    			b[i-1] = i*6;
    		}
    	}
    	printArrayformatted(b, " ");
    	//c
    	int[] c = new int[]{7, 3, 2, 7, 6, 7, 7, 8, 9, 5};
    	for(int i = 0;i < c.length;i++) {
    		if(c[i] == 7) {
    			c = insertAt(c, i, -1);
    			i++;
    		}	
    	}
    	printArrayformatted(c, " ");
    	//d
    	length = 11;
    	int[] d = new int[length];
    	for(int i = 0; i < length;i++) {
    		d[i]=i+1;
    	}
    	String output = "for-Schleife: ";
    	for(int i = d.length-1; i >= 0 ;i--) {
    		output+=d[i];
    		if(i > 0) {
    			output+= ",";
    		}
    	}
    	output+="\nwhile-Schleife: ";
    	int i = d.length-1;
    	while(i >= 0){
    		output+=d[i];
    		if(i > 0) {
    			output+= ",";
    		}
    		i--;
    	}
    	System.out.println(output);
    }
}

