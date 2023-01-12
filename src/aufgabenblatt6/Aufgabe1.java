package aufgabenblatt6;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.HashMap;

import codedraw.CodeDraw;
import codedraw.EventScanner;
import codedraw.Key;
import codedraw.MouseClickEvent;
import codedraw.TextFormat;
import codedraw.TextOrigin;

public class Aufgabe1 {

	public static HashMap<Integer,int[]> transitiontable;
	public static int[][] genboard(int cols, int rows){
		return new int[cols][rows];
	}
	public static void drawGameBoard(CodeDraw cd, int[][] currentGameBoard, int oneSquareSize) {
		//cd.setColor(Color.BLUE);
		//cd.fillRectangle(0, 0, cd.getWidth(),cd.getHeight());
		cd.clear(Color.BLUE);
		for(int x = 0; x< currentGameBoard.length; x++) {
			for(int y = 0; y< currentGameBoard[x].length; y++) {
				if(currentGameBoard[x][y] == 0) {
					cd.setColor(Color.GRAY);
				}else if(currentGameBoard[x][y] == 1) {
					cd.setColor(Color.RED);
				}else if(currentGameBoard[x][y] == 2) {
					cd.setColor(Color.YELLOW);
				}
				cd.fillCircle(x*oneSquareSize+(oneSquareSize/2), y*oneSquareSize+(oneSquareSize/2), oneSquareSize/3);
			}
		}
		//cd.show();
	}
	public static boolean isMovePossible(int[][] currentGameBoard, int col) {
		return currentGameBoard[col][0] == 0;
		
	}
	public static void makeMove(int[][] currentGameBoard, int player, int col) {
		for(int i = currentGameBoard[col].length-1; i >= 0 ;i--) {
			if(currentGameBoard[col][i] == 0) {
				currentGameBoard[col][i] = player;
				return;
			}
		}
	}
	public static boolean existsWinner(int[][] currentGameBoard, int player) {
		for(int x = 0; x< currentGameBoard.length; x++) {
			for(int y = 0; y< currentGameBoard[x].length; y++) {
				if(currentGameBoard.length > x+3 &&
					currentGameBoard[x][y] == player &&
					currentGameBoard[x+1][y] == player &&
					currentGameBoard[x+2][y] == player &&
					currentGameBoard[x+3][y] == player) {
					return true;
				}
				if(currentGameBoard[x].length > y+3 &&
					currentGameBoard[x][y] == player &&
					currentGameBoard[x][y+1] == player &&
					currentGameBoard[x][y+2] == player &&
					currentGameBoard[x][y+3] == player) {
					return true;
				}
				if(currentGameBoard.length > x+3 &&
					currentGameBoard[x].length > y+3 &&
					currentGameBoard[x][y] == player &&
					currentGameBoard[x+1][y+1] == player &&
					currentGameBoard[x+2][y+2] == player &&
					currentGameBoard[x+3][y+3] == player) {
					return true;
				}
				if(currentGameBoard.length > x+3 &&
					0 < y-3 &&
					currentGameBoard[x][y] == player &&
					currentGameBoard[x+1][y-1] == player &&
					currentGameBoard[x+2][y-2] == player &&
					currentGameBoard[x+3][y-3] == player) {
					return true;
				}
			}
		}
		return false;
	}
	public static void cleanboard(int[][] board) {
		for(int x = 0; x< board.length; x++) {
			for(int y = board[x].length-1; y >= 0; y--) {
				if(y != 0) {
					board[x][y] =board[x][y-1];
				}else {
					board[x][y] = 0;
				}
				
			}
		}
	}
	public static int moveofAI(int[][] board, int player, double difficulty) {
		long timestart = System.currentTimeMillis();
		boolean bestmove = difficulty >= Math.random();
		int[] mini = minimax(board, player, true, 9, Integer.MIN_VALUE, Integer.MAX_VALUE,bestmove);
		int fail = 0;
		if(mini[1] == -1) {
			for(int i = 0; i < board.length;i++) {
				if(isMovePossible(board, i)) {
					fail = i;
					int[][] newboard = new int[board.length][board[0].length];
					for(int x = 0; x< board.length; x++) {
						for(int y = 0; y< board[x].length; y++) {
							newboard[x][y] = board[x][y];
						}
					}
					makeMove(newboard, player, i);
					int points = evalpoints(newboard, player);
					if(points > mini[0]) {
						mini[0] = points;
						mini[1] = i;
					}
				}
			}
		}
		if(mini[1] == -1)
			mini[1] = fail;
		System.out.println("Best move for AI "+player+" is "+mini[1]+" with a score of "+mini[0]+"\n this move was calculatet in "+((System.currentTimeMillis()-timestart))+"ms");
		if(mini[0] == Integer.MAX_VALUE) {
			printboard(board);
		}
		return mini[1];
	}
	public static int getnext(int current) {
		if(current == 0) {
			return -1;
		}else if(current  < 0) {
			return -current;
		}else {
			return -(current+1);
		}
	}
	public static int[] minimax(int[][] board, int player, boolean currentplayer, int depth, int alpha, int beta,boolean bestmove) {
		int score;
		int move = -1;
		if(depth == 0) {
			if(currentplayer) {
				score = evalpoints(board, player);
			}else {
				score = -evalpoints(board, player);
			}
			return new int[]{score};
		}
		int temp = 0;
		if(currentplayer) {
			score = Integer.MIN_VALUE;
			for(int i = board.length/2; i < board.length && i >= 0;i=board.length/2 + temp) {
				if(isMovePossible(board, i)) {
					int[][] newboard = new int[board.length][board[0].length];
					for(int x = 0; x< board.length; x++) {
						for(int y = 0; y< board[x].length; y++) {
							newboard[x][y] = board[x][y];
						}
					}
					makeMove(newboard, player, i);
					if(existsWinner(newboard, player)) {
						return new int[] {100,i,Math.max(alpha, 100),beta};
					}
					int[] mini = minimax(newboard, (player%2)+1, !currentplayer, depth-1, alpha, beta,bestmove);
					/*
					if(transitiontable.containsKey(newboard.hashCode())) {
						mini = transitiontable.get(newboard.hashCode());
					}else {
						transitiontable.put(newboard.hashCode(), mini);
					}//*/
					
					//printboard(newboard);
					//System.out.println("Score: "+mini[0]);
					if(mini[0] > score) {
						score = mini[0];
						move = i;
						//System.out.println("Currently best move = "+score+" on column "+i);
					}else
					if(mini[0] > beta) {
						break;
					}
					alpha = Math.max(alpha, mini[0]);
				}
				if(score == -1) {
					
				}
				temp= getnext(temp);
			}
			if(!bestmove) {
				score-= (int)(Math.random()* 200)-100;
			}
		}else { // enemy
			score = Integer.MAX_VALUE;
			for(int i = board.length/2; i < board.length && i >= 0;i=board.length/2 + temp) {
				if(isMovePossible(board, i)) {
					int[][] newboard = new int[board.length][board[0].length];
					for(int x = 0; x< board.length; x++) {
						for(int y = 0; y< board[x].length; y++) {
							newboard[x][y] = board[x][y];
						}
					}
					makeMove(newboard, player, i);
					if(existsWinner(newboard, player)) {
						return new int[] {-100,i,alpha,Math.max(beta, -100)};
					}
					int[] mini = minimax(newboard, (player%2)+1, !currentplayer, depth-1, alpha, beta,bestmove);
					/*
					if(transitiontable.containsKey(newboard.hashCode())) {
						mini = transitiontable.get(newboard.hashCode());
						//mini[0]*=-1;
					}else {
						//mini[0]*=-1;
						transitiontable.put(newboard.hashCode(), mini);
						//mini[0]*=-1;
					}//*/
					//printboard(newboard);
					//System.out.println("Score: "+mini[0]);
					if(mini[0] < score) {
						score = mini[0];
						move = i;
						//System.out.println("Currently best move (for enemy) = "+score+" on column "+i);
					}
					if(mini[0] < alpha) {
						break;
					}else
					beta = Math.max(beta, mini[0]);
				}
				temp= getnext(temp);
			}
			if(!bestmove) {
				score+= (int)(Math.random()* 200)-100;
			}
		}
		
		
		return new int[] {score+((currentplayer)?-1:1),move};
	}
	public static void printboard(int[][] board) {
		String output = "";
		for(int x = 0; x< board.length; x++) {
			for(int y = board[x].length-1; y >= 0; y--) {
				output+="| "+board[x][y];
			}
			output+=" |\n";
		}
		System.out.println(output);
	}
	public static int evalpoints(int[][] field, int player) {
		int current = 0;
		if(existsWinner(field, player)) {
			return 100; //current = 100;
		}else if(existsWinner(field, (player%2)+1)) {
			return -100; //current = -100;
		}
		
		for(int i = 0; i < field[0].length;i++) {// Center is important
			if(field[field.length/2][i] == player) {
				current += 7;
			}
		}
		
		
		for(int x = 0; x< field.length; x++) {
			for(int y = 0; y< field[x].length; y++) {
				//if(field[x][y] == player) {//disttocenter
				//	current -= (int) Math.sqrt(Math.pow((field.length/2)-x,2)+Math.pow((field[x].length/2)-y,2));
				//}
				if(field.length > x+ 2&&
					field[x][y] == player &&
					field[x+1][y] == player) { // horizontal
					if(field[x+2][y] == player) {// 3 in a row
						if((x-1 >= 0 && field[x-1][y] == 0) &&
							(x+3 < field.length && field[x+3][y] == 0)) {
							current+=15;
						}else if((x-1 >= 0 && field[x-1][y] == 0) ||
							(x+3 < field.length && field[x+3][y] == 0)) {
							current+=12;
						}
					}else {	// 2 in a row	
						if((x-1 >= 0 && field[x-1][y] == 0)&&
							(field[x+2][y] == 0)) {
							current+=7;
						}else if((x-1 >= 0 && field[x-1][y] == 0)&&
							(field[x+2][y] == 0)) {
							current+=3;
						}
					}
				}
				if(field[x].length > y+2 &&
					field[x][y] == player &&
					field[x][y+1] == player) { //verticalt
					if(field[x][y+2] == player) {// 3 in a row
						if((y-1 >= 0 && field[x][y-1] == 0) &&
							(y+3 < field[x].length && field[x][y+3] == 0)) {
							current+=15;
						}else if((y-1 >= 0 && field[x][y-1] == 0)) {
							current+=12;
						}
					}else {	// 2 in a row	
						if((y-1 >= 0 && field[x][y-1] == 0)) {
							current+=7;
						}
					}
				}
				if(field.length > x+2 &&
					field[x].length > y+2 &&
					field[x][y] == player &&
					field[x+1][y+1] == player) { // rechts rauf diagonal
					if(field[x+2][y+2] == player) {// 3 in a row
						if((x-1 >= 0 && y-1 >= 0 && field[x-1][y-1] == 0) &&
							(x+3 < field.length && y+3 < field[x].length && field[x+3][y+3] == 0)) {
							current+=15;
						}else if((x-1 >= 0 && y-1 >= 0 && field[x-1][y-1] == 0) ||
							(x+3 < field.length && y+3 < field[x].length && field[x+3][y+3] == 0)) {
							current+=12;
						}
					}else {	// 2 in a row	
						if((x-1 >= 0 && y-1 >= 0 && field[x-1][y-1] == 0)&&
							(field[x+2][y+2] == 0)) {
							current+=7;
						}else if((x-1 >= 0 && y-1 >= 0 && field[x-1][y-1] == 0)&&
							(field[x+2][y+2] == 0)) {
							current+=3;
						}
					}
				}
				if(field.length > x+2 &&
					0 < y-2 &&
					field[x][y] == player &&
					field[x+1][y-1] == player) { // links rauf diagonal
					if(field[x+2][y-2] == player) {// 3 in a row
						if((x-1 >= 0 && y+1 < field[x].length && field[x-1][y+1] == 0) &&
							(x+3 < field.length && y-3 >= 0 && field[x+3][y-3] == 0)) {
							current+=15;
						}else if((x-1 >= 0 && y+1 < field[x].length && field[x-1][y+1] == 0) ||
								(x+3 < field.length && y-3 >= 0 && field[x+3][y-3] == 0)) {
							current+=12;
						}
					}else {	// 2 in a row	
						if((x-1 >= 0 && y+1 < field[x].length && field[x-1][y-1] == 0)&&
							(field[x+2][y-2] == 0)) {
							current+=7;
						}else if((x-1 >= 0 && y+1 < field[x].length && field[x-1][y-1] == 0)||
								(field[x+2][y-2] == 0)) {
							current+=3;
						}
					}
				}
				// 2 zu 1 oder 1 zu 2
				if(field.length > x+3 &&
					field[x][y] == player &&
					((field[x+1][y] == player && field[x+2][y] == 0) ||
					(field[x+2][y] == player && field[x+1][y] == 0))&&
					field[x+3][y] == player) { // horizontal
					current+=15;
				}
				if(field.length > x+3 &&
					field[x].length > y+3 &&
					field[x][y] == player &&
					((field[x+1][y+1] == player && field[x+2][y+2] == 0)||
					(field[x+2][y+2] == player && field[x+1][y+1] == 0))&&
					field[x+3][y+3] == player) {// rechts runter
					current+=15;;
				}
				if(field.length > x+3 &&
					0 < y-3 &&
					field[x][y] == player &&
					((field[x+1][y-1] == player && field[x+2][y-2] == 0)||
					(field[x+2][y-2] == player && field[x+1][y-1] == 0))&&
					field[x+3][y-3] == player) {// rechts rauf
					current+=15;;
				}
				
			}
		}
		return current;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
		transitiontable = new HashMap<>();
		int cols = 7;
		int rows = 6;
		int squaresize = 50;
		CodeDraw cd = new CodeDraw((cols)*squaresize,(rows)*squaresize);
		int[][] field;
		EventScanner es = cd.getEventScanner();
		int currentplayer = 1;
		int mouseX,mouseY;
		TextFormat font = cd.getTextFormat();
		font.setFontName("Arial");
		font.setFontSize(28);
		font.setBold(true);
		font.setTextOrigin(TextOrigin.CENTER);
		cd.setTextFormat(font);
		int fields_used = 0;
		field = genboard(cols,rows);
		drawGameBoard(cd, field, squaresize);
		cd.show();
		boolean play = true;
		while(true) {
			
			//*
			//System.out.println("Drew the board");
			makeMove(field,currentplayer,moveofAI(field,currentplayer,1));
			fields_used++;
			if(existsWinner(field, currentplayer)) {
				drawGameBoard(cd, field, squaresize);
				cd.setColor(Color.CYAN);
				cd.drawText(cd.getWidth()/2, cd.getHeight()/2, ("AI "+currentplayer+" won!"));
				cd.show(3000);
				for(int row = 0; row < rows;row++) {
					cleanboard(field);
					drawGameBoard(cd, field, squaresize);
					cd.show(500);
				}
				drawGameBoard(cd, field, squaresize);
				cd.drawText(cd.getWidth()/2, cd.getHeight()/2, ("Next Round"));
				cd.show(1000);
				field = genboard(cols, rows);
				fields_used = 0;
			}
			currentplayer = (currentplayer%2)+1;
			//*/
			/*
			if(es.hasEvent()) {
				if(es.hasKeyDownEvent()) {
					if(es.nextKeyDownEvent().getKey() == Key.Q)
						System.exit((int)(Math.random() * Integer.MAX_VALUE));
				}else if(es.hasMouseClickEvent()) {
					MouseClickEvent mce = es.nextMouseClickEvent();
					mouseX = mce.getX();
					mouseY = mce.getY();
					int col = mouseX/(cd.getWidth()/cols);
					if(isMovePossible(field, col)) {
						makeMove(field, currentplayer, col);
						drawGameBoard(cd, field, squaresize);
						fields_used++;
						System.out.println("Player "+currentplayer+" Move at column"+col+" score "+(evalpoints(field, currentplayer)-evalpoints(field, (currentplayer%2)+1)));
						
						if(existsWinner(field, currentplayer)) {
							drawGameBoard(cd, field, squaresize);
							cd.setColor(Color.CYAN);
							cd.drawText(cd.getWidth()/2, cd.getHeight()/2, ("Player "+currentplayer+" won!"));
							cd.show(1000);
							for(int row = 0; row < rows;row++) {
								cleanboard(field);
								drawGameBoard(cd, field, squaresize);
								cd.show(500);
							}
							drawGameBoard(cd, field, squaresize);
							cd.drawText(cd.getWidth()/2, cd.getHeight()/2, ("Next Round"));
							cd.show(1000);
							field = genboard(cols, rows);
							fields_used = 0;
							continue;
						}
						cd.show();
						currentplayer = (currentplayer%2)+1;
						makeMove(field,currentplayer,moveofAI(field,2));
						drawGameBoard(cd, field, squaresize);
						if(existsWinner(field, currentplayer)) {
							drawGameBoard(cd, field, squaresize);
							cd.setColor(Color.CYAN);
							cd.drawText(cd.getWidth()/2, cd.getHeight()/2, ("AI won!"));
							cd.show(1000);
							for(int row = 0; row < rows;row++) {
								cleanboard(field);
								drawGameBoard(cd, field, squaresize);
								cd.show(500);
							}
							drawGameBoard(cd, field, squaresize);
							cd.drawText(cd.getWidth()/2, cd.getHeight()/2, ("Next Round"));
							cd.show(1000);
							field = genboard(cols, rows);
							fields_used = 0;
							continue;
						}
						currentplayer = (currentplayer%2)+1;
					}else {
						cd.setColor(Color.PINK);
						cd.drawText(cd.getWidth()/2, cd.getHeight()/2, "Column full");
						System.out.println("Column full");
						cd.show(3000);
					} 
					
				}else {
					es.nextEvent();
				}
			}//*/
			drawGameBoard(cd, field, squaresize);
			cd.show();
			if(fields_used == cols*rows) {
				drawGameBoard(cd, field, squaresize);
				cd.setColor(Color.PINK);
				cd.drawText(cd.getWidth()/2, cd.getHeight()/2, "Board full");
				System.out.println("Board full");
				cd.show(3000);
				for(int row = 0; row < rows;row++) {
					cleanboard(field);
					drawGameBoard(cd, field, squaresize);
					cd.show(500);
				}
				cd.drawText(cd.getWidth()/2, cd.getHeight()/2, ("Try again"));
				cd.show(1000);
				field = genboard(cols, rows);
				fields_used = 0;
			}
		}
	}
}
