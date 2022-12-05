package aufgabenblatt1;
/*
    Aufgabe 3) Verschachtelte Schleifen
*/
public class Aufgabe3 {

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
		int height = 10;
		int pattern = 0;
		if(height < 1)
			height = 1;
		String output = "";
		if(pattern == 0) { 		//Line
			for(int line =0;line < height;line++) {
				for(int i=0;i< (height+1)*height;i++) {
					int part = i/(height+1);
					if(part >= (height-(line+1))&& i%(height+1) == line) {
							output += "*";
					}else
						output+=" ";
				}
				output+="\n";
			}
		}else if(pattern == 1) {//Triangle
			for(int line =0;line < height;line++) {
				for(int i=0;i< (height+1)*height;i++) {
					int part = i/(height+1);
					if(part >= (height-(line+1))&& i%(height+1) >= (height-(line+1))+(height-part)) {
							output += "*";
					}else
						output+=" ";
				}
				output+="\n";
			}
		}else if(pattern == 2) {//Parallelogram
			for(int line =0;line < height;line++) {
				for(int i=0;i< (2*height+1)*height;i++) {
					int part = i/(2*height+1);
					if(part >= (height-(line+1))&&(i%(2*height+1) >= line && i%(2*height+1) <= line+part )) {
							output += "*";
					}else
						output+=" ";
				}
				output+="\n";
			}
		}else {
			System.out.println("Trottel kein akzeptiertes Pattern");
		}
		System.out.println(output);
	}
}
