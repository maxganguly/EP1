package aufgabenblatt2;
/*
    Aufgabe 4) "Guessing Game" und Verwendung von Methoden
*/

import java.util.Scanner;

public class Aufgabe4 {

    //TODO: Implementieren Sie hier Ihre Methoden
	private static int getRandomNumber(int start,int end) {
		return (int)(Math.random()*(end-start))+start;
	}
	private static int getNumber() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			if(scan.hasNextInt()) {
				return scan.nextInt();
			}else {
				String next = scan.next();
				if(next.equals("q"))
					System.exit((int) (Math.random()*Integer.MAX_VALUE));
				print(next+" is not an int");
			}

		}
		
	}
	private static void print(String msg) {
		System.out.println(msg);
	}
	private static int getNumberbetween(int start, int end) {
		int i = getNumber();
		while(true) {
			if(i >= start && i <= end)
				return i;
			print(i+" is not between "+start+" and "+end+" please try again");
			i = getNumber();
		}
	}
    public static void main(String[] args) {
    	//TODO: Implementieren Sie hier Ihr "GuessingGame"
    	int start,end,num;
    	start = 0;
    	end = 200;
    	num = getRandomNumber(start, end);
    	print("Guessing Game \nGuess a Number between "+start+" and "+end);
    	while(true) {
    		for(int i = 0; i< 8;i++) {
    			int guess = getNumberbetween(start, end);
    			if(guess == num) {
    				print("Correct the number is "+num+" it took you "+(i+1)+" tries");
    				break;
    			}else if(guess > num) {
    				print("Your guess of "+guess+" was to high");
    			}else {
    				print("Your guess of "+guess+" was to low");
    			}
    			if(i == 7) {
    				print("Too bad you were unable to guess the number "+num+" within 8 tries try again");
    			}
    		}
    	}
    }
}
