package aufgabenblatt2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import codedraw.CodeDraw;

/*
    Aufgabe 5) Designaufgabe
*/
public class Aufgabe5 {

	public static void drawSomething(int[][] points, CodeDraw cd, Color color) {
		cd.setColor(color);
		drawSomething(points, cd);
	}
	public static void drawSomething(int[][] points, CodeDraw cd) {
		for(int i = 0; i < points.length;i++) {
			cd.drawLine(points[i][0],points[i][1],points[(i+1)%points.length][0],points[(i+1)%points.length][1]);
		}
	}
	public static void drawSomethinginsideSomething(int[][] points, CodeDraw cd, int recursions, boolean randomColor) {
		if(randomColor)
		cd.setColor(new Color((float) Math.random(),(float) Math.random(),(float) Math.random()));
		if(recursions == 0)
			return;
		int [][] newpoints = new int[points.length][];
		for(int i = 0; i< newpoints.length;i++ ) {
			newpoints[i] = new int[]{
					(points[i][0]+points[(i+1)%newpoints.length][0])/2,
					(points[i][1]+points[(i+1)%newpoints.length][1])/2};
		}
		drawSomethinginsideSomething(newpoints, cd, recursions-1,randomColor);
		drawSomething(newpoints,cd);
	}

	public static void drawSomethinginsideSomethingShifted(int[][] points, CodeDraw cd, float shift, int recursions, boolean randomColor) {
		if(recursions == 0)
			return;
		int [][] newpoints = new int[points.length][];
		for(int i = 0; i< newpoints.length;i++ ) {
			int[] vector = {points[(i+1)%newpoints.length][0]-points[i][0],
							points[(i+1)%newpoints.length][1]-points[i][1]};
			newpoints[i] = new int[] {
					(int) (points[i][0]+(vector[0]/2.0) * shift),
					(int) (points[i][1]+(vector[1]/2.0) * shift),
			};
		}

		drawSomethinginsideSomethingShifted(newpoints, cd, shift, recursions-1,randomColor);
		if(randomColor)
			cd.setColor(new Color((float) Math.random(),(float) Math.random(),(float) Math.random()));
		drawSomething(newpoints,cd);
	}
	
	public static void main(String[] args) {
		int recursions = 15;
		int sidelength = 1000;
		float change = 0.05f;
		int sidesofpolygonfrom = 5;
		int sidesofpolygonto = 5;
		Dimension size= Toolkit.getDefaultToolkit().getScreenSize();
		CodeDraw cd = new CodeDraw((int)size.getWidth(),(int)size.getHeight());
		cd.setAlwaysOnTop(true);
		cd.setCanvasPositionX(0);
		cd.setCanvasPositionY(0);
		
		int polygon[][][] = new int[1+sidesofpolygonto-sidesofpolygonfrom][][];
		for(int it = 0; it < polygon.length;it++) {
			polygon[it] = new int[sidesofpolygonfrom+it][];
			for(int i = 0; i < polygon[it].length;i++) {
				polygon[it][i] = new int[] {
					(int) (((sidelength/2.0f)* Math.cos((2.0*Math.PI*(float)i/(float)polygon[it].length) -(Math.PI/2)))+size.getWidth()/2),
					(int) (((sidelength/2.0f)* Math.sin((2.0*Math.PI*(float)i/(float)polygon[it].length) -(Math.PI/2)))+size.getHeight()/2)
				};
			}
		}
		cd.setLineWidth(3);
		while(true) {
			change %= 2;
			change += 0.01f;
			cd.clear(Color.BLACK);
			//cd.clear(new Color((float) Math.random(),(float) Math.random(),(float) Math.random()));
			for(int i = 0; i < polygon.length;i++) {
				drawSomethinginsideSomethingShifted(polygon[i], cd, change, recursions, true);
			}
			
			cd.show(10);
			
			
		}
	}
}
