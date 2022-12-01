package aufgabenblatt3;
/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    //Der Spaggeticode gibt ein Muster:
	// 	+\********/+
	// 	++\******/++
	// 	+++\****/+++
	// 	++++\**/++++
	// 	+++++\/+++++
	// 	+++++/\+++++
	// 	++++/**\++++
	//	+++/****\+++
	//	++/******\++
	//	+/********\+
	// aus
    //

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    //anstatt meherer schleifen welche für jede Zeile die Muster erzeugen würde ich eine Schleife 
	//welche dynamisch durch alle Zeilen Iteriert und anhand der Zeilennummer und breite das akuelle Muster berechnet
    //
    //


    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung
	public static void DrawBanner(int width, int height) {
		String  str= "";
		for(int i = 0; i < height;i++) {
			if(i == 0 || i == height-1) {
				str+="#";
				for(int x = 0; x< width-2;x++) {
					str+="|";
				}
				str+="#\n";
			}else {
				str+="+";
				int xcurrent = (i-1)%(width-2);
				for(int x = 0; x< width-2;x++) {
					if(xcurrent == x && width-xcurrent-3 == x) {
						str+="X";
					}else if(xcurrent == x) {
						str+="\\";
					}else if(width-xcurrent-3 == x) {
						str+="/";
					}else if((xcurrent <= x && width-xcurrent-3 >= x)||
							 (xcurrent >= x && width-xcurrent-3 <= x)){
						str += "*";
					}else {
						str += "+";
					}
				}
				str+="+\n";
			}
		}
		System.out.println(str);
	}

    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");
        DrawBanner(12,22);
        //********************************************************
        //*
        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
        System.out.print("|");
        }
        System.out.println("#");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }            System.out.print("\\");
        for (int j = 1; j <= (10 - 2 * i); j++) {System.out.print("*");
            }
            System.out.print("/");
        for (int j = 1; j <= i; j++) {System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10/2-i+1); j++) {
                System.out.print("+");            }
        System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("*");
            }System.out.print("\\");
            for (int j = 1; j <= (10/2-i+1); j++) { System.out.print("+");
            }
            System.out.println();        }
        for (int i = 1; i < 6; i++) {
                for (int j = 1; j <= i; j++) {
                System.out.print("+");            }
            System.out.print("\\");
                for (int j = 1; j <= (10-2*i); j++) {System.out.print("*");     }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
        for (int j = 1; j <= (10/2-i+1); j++) {
                    System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("*");
            }
                System.out.print("\\");
            for (int j = 1; j <= (10/2-i+1); j++) {System.out.print("+");
            }
            System.out.println();
        }
        System.out.print("#");        
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
        //*/
    }
}


