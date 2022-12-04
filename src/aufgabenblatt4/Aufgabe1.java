package aufgabenblatt4;
/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {
	//b) kein Rückgabewert da das referenzierte Array verändert wird
    private static void fillArray(int[] filledArray) {
        int number = 6;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 6;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        //c) die Referenz wurde übergeben und das Array wurde nicht kopiert
    	int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 4 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[10];
        int number = 6;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 6;
        }
        //d) die locale Variable welche die Referenz des Arrays enthält wurde überschrieben und nicht die Werte des Arrays
        workArray = helpArray;
        printArray(workArray);
    }

    private static void printArray(int[] workArray) {
    	//for (int i = 0; i < workArray.length; i--) {
        //a) Fehler i-- da es bei der Zweiten iteration auf den index -1 verweisen würde und immer(bis zu Overflow) kleiner als workarray.length ist
    	for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 777;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //1.Welchen Datentyp muss der Indexausdruck haben, mit dem die Position in einem Arraybestimmt wird?
    //int oder ein datentyp welcher implizit in int umgewandelt werden kann
    //2. Müssen Sie ein Array initialisieren?
    //nein auser es soll verwendet werden
    //3. Wie kann die Länge eines Arrays verändert werden?
    //Indem ein neues Array erstellt wird und die Werde des ursprünglichen in das neue kopiert werden
    //4. Wie gehen Sie vor, wenn Sie ein int-Array kopieren m ̈ussen?
    //System.arraycopy(alt,0,neu,0,alt.length);
    //oder als Schleife durchiterieren
    //int[] new = new int[alt.length];
    //for(int i =0; i < alt.length;i++){
    //neu[i] = alt[i];
    //}
    //5. Beginnt die Indexzählung eines Arrays immer bei 0?
    //in Java und den meisten anderen Programmiersprachen ja 
    // in Matlab nein
    //6. Ist es sinnvoll, zwei Arrays mit "==" zu vergleichen? Was passiert im Detail, bei einemVergleich mit "=="?    //
    //Ja um zu überprüfen ob diese auf das selbe Array referenzieren
    //Nein wenn die Werte verglichen werden sollen
    //bei einem Vergleich von == werden die Referenzen verglichen
}
