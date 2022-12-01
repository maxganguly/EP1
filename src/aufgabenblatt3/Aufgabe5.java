package aufgabenblatt3;

import codedraw.*;
import java.awt.*;

/*
Aufgabe 5) Kreismuster => Rekursiv vs. Iterativ
*/

public class Aufgabe5 {

    private static void drawCirclePatternRecursively(CodeDraw myDrawObj, int x, int y, int r) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
    	if(r <= 2)
    		return;
    	drawCirclePatternRecursively(myDrawObj, x-r, y-r, r/2);
    	drawCirclePatternRecursively(myDrawObj, x+r, y-r, r/2);
    	drawCirclePatternRecursively(myDrawObj, x-r, y+r, r/2);
    	drawCirclePatternRecursively(myDrawObj, x+r, y+r, r/2);
    	myDrawObj.setColor(Color.YELLOW);
    	myDrawObj.fillCircle(x, y, r);
    	myDrawObj.setColor(Color.RED);
    	myDrawObj.drawCircle(x, y, r);
    }

    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
    	
    	int size = myDrawObj.getWidth();
    	if(size != myDrawObj.getHeight())
    		return;
    	
    	for(int i = 4; i < maxRadius;i*=2) {
    		for(int x = i*2; x < size; x += i*4) {
    			for(int y = i*2; y < size; y += i*4) {
    				myDrawObj.setColor(Color.YELLOW);
    		    	myDrawObj.fillCircle(x, y, i);
    		    	myDrawObj.setColor(Color.RED);
    		    	myDrawObj.drawCircle(x, y, i);
        		}
    		}
    	}
    	CodeDraw cd = myDrawObj;
    }

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	int size = 512;
    	CodeDraw cd = new CodeDraw(size,size);
    	//drawCirclePatternRecursively(cd, size/2, size/2, size/4);
    	drawCirclePatternIteratively(cd, size/2);
    	cd.show();
    }
}


