package aufgabenblatt1;
/*
    Aufgabe 5) Schleifen und Zeichnen innerhalb des CodeDraw-Fensters
*/

import java.awt.Color;

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe5 {

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    int size = 300;
    CodeDraw cd = new CodeDraw(size,size);
    int n = 19;
    if(n>19 || n < 5 || n%2 == 0)
    	n = 5;
    float parts = ((float)size)/n;
    for(int x = 0;x< n;x++) {
    	for(int y = 0;y< n;y++) {
        	if((x == 0||y==n-1) || (x<=n-3 && y >= 2 && (x == 2||y==n-3) && x!= 1 && y!= n-2)) {
        		cd.setColor(Color.RED);
        		cd.setLineWidth(2);
        		cd.drawCircle(x*parts+parts/2, y*parts+parts/2, parts/2);
        	}else if((x == n-2||y==1)&& !(x == n-1 || y == 0)){
        		cd.setColor(Color.BLUE);
        		cd.setLineWidth(4);
        		cd.drawCircle(x*parts+parts/2, y*parts+parts/2, parts/2);

        	}
        }
    }
    cd.show();
    }
}
