package aufgabenblatt2;
/*
    Aufgabe 1) Schleifen - geometrische Formen und Muster (optische Täuschung)
*/

import java.awt.Color;

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe1 {

    public static void main(String[] args) {

        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    	int size = 400;
    	int amount = 16;
    	double r = size /60.0;
    	CodeDraw cd = new CodeDraw(size,size);
    	//black dot
    	for(int x = 0;x < amount ;x++ ) {
    		for(int y = 0;y < amount ;y++ ) {
    			cd.setColor(Color.BLACK);
    			cd.fillCircle((2*r)+4*r*x, (2*r)+4*r*y, r);
    			cd.setLineWidth(3);
    			cd.setColor(Color.GRAY);
    			cd.drawCircle((2*r)+4*r*x, (2*r)+4*r*y, r);
    		}
    	}
    	cd.setColor(Color.WHITE);
    	cd.fillSquare(0.25*size+r,0.25*size+r,0.5*size -2*r);
    	cd.setLineWidth(1);
    	cd.setColor(Color.BLACK);
    	cd.drawSquare(0.25*size+r,0.25*size+r,0.5*size -2*r);
    	for(int x = 0;x < amount/2 -1 ;x++ ) {
    		for(int y = 0;y < amount/2 -1 ;y++ ) {
    	    	cd.setLineWidth(1);
    	    	cd.setColor(Color.BLACK);
    	    	cd.drawSquare(0.25*size+2*r+4*r*x,0.25*size+2*r+4*r*y,2*r);
    		}
    	}
    	
    	cd.show();
    }
}
