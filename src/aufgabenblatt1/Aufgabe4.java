package aufgabenblatt1;
/*
    Aufgabe 4) CodeDraw Bibliothek
*/

import java.awt.Color;

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe4 {

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    int size = 400;
    CodeDraw cd =new CodeDraw(size,size);
    cd.setLineWidth(2);
    
    cd.setColor(Color.CYAN);
    cd.drawCircle(100, 100, 100);
    
    cd.setColor(Color.MAGENTA);
    cd.fillCircle(100, 100, 50);
    
    cd.setColor(Color.YELLOW);
    cd.fillSquare(50, 250, 100);
    
    cd.setColor(Color.BLACK);
    cd.drawLine(50, 250, 150, 350);
    cd.drawLine(150, 250, 50, 350);
    
    cd.setColor(Color.RED);
    cd.fillEllipse(340, 60, 15, 60);
    cd.fillEllipse(340, 60, 60, 15); 
    
    cd.setColor(Color.GREEN);
    for(int i = 0; i < 6;i++) {
    	cd.drawLine(200, 0, 200+i*40, 400);
    	cd.drawLine(200, 0, 400,200+i*40);
    	cd.show(500);
    }
    cd.show();
    }
}
