package Java_Graph_Calc_Project;

import java.awt.Color; 
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Console {  //how you see the output from the buttons
	private String consoleStorage = "";
	private final int xCoord = 20;
	private final int yCoord = 20;
	private final Color col = new Color(153,255,153);
	private int locationOfTextX = 380;
	private int locationOfTextY = 70;
	private double ans = 0.0;
	private String mode = "Calc";
	private static double ZoomFactor = 1.0;
	
	private double storeA;
	private double storeB;
	private double storeC;
	
	
	//for the Y= mode
	private String yStorage = "";
	//second y storage
	private String yStorage2 = "";
	
    public void nConsole(Graphics g) //repaints the console
    {
    	if(mode.equals("Calc")) {  //draws the calc display
    		//resets the background
    		Graphics2D g2 = (Graphics2D) g;  //creates rectangle
    		g2.setColor(Color.GRAY); //sets it to the color gray
        	Rectangle bConsole = new Rectangle(0, 0, 400,145);
        	g2.fill(bConsole);
        	g2.draw(bConsole);
        	
        	g.setColor(col);
        	Rectangle nConsole = new Rectangle((int)(xCoord), (int)(yCoord), 360,100);
        	g2.fill(nConsole);
        	g2.draw(nConsole);
        	
        	
        	//Example of how to draw new test
        	//Font font = new Font("Verdana", Font.BOLD, 12); 	then 	(graphics).setFont(font)
        	
        	//Font size we will be using is 20 

        	//locationOfTextX += 20;
        	Font font = new Font("Verdana", Font.BOLD, 20);
        	g.setFont(font);
        	g.setColor(new Color(0,0,0)); //black colored font
        	g.drawString(consoleStorage, locationOfTextX, locationOfTextY);
    	}
    	else if(mode.equals("Graph")) { //increase size of the panel to fit in the graph
    		Graphics2D g2 = (Graphics2D) g;  //creates rectangle
    		g2.setColor(new Color(255,255,255)); //sets it to the color white
        	Rectangle nConsole = new Rectangle(0, 0, 400,145);
        	g2.fill(nConsole);
        	g2.draw(nConsole);
        	
        	//add in the x and y axis
        	g2.setColor(new Color(0,0,0)); //sets the axis color to black
        	Line2D.Double line1 = new Line2D.Double(200,0,200,145);  //draws the y axis
        	g2.draw(line1);
        	Line2D.Double line2 = new Line2D.Double(0,72, 400, 72); //draws the x axis 
        	g2.draw(line2);
        	
        	graph(g, g2, yStorage, true); //graphs the first equation 
        	graph(g, g2, yStorage2, false);  //graphs the second equation

    	}
    	else if(mode.equals("Y=")) {  //draws the equation input 
    		//resets the background
    		Graphics2D g2 = (Graphics2D) g;  //creates rectangle
    		g2.setColor(Color.GRAY); //sets it to the color gray
        	Rectangle bConsole = new Rectangle(0, 0, 400,145);
        	g2.fill(bConsole);
        	g2.draw(bConsole);
    		
        	g.setColor(new Color(255,255,0));   //sets background to yellow
        	Rectangle nConsole = new Rectangle((int)(xCoord), (int)(yCoord), 360,100);
        	g2.fill(nConsole);
        	g2.draw(nConsole);
        	
        	Font font = new Font("Verdana", Font.BOLD, 20); //sets font to bold 
        	g.setFont(font);
        	g.setColor(new Color(0,191,255)); //blue colored font  **matching the graph color
        	g.drawString("Y=", 40, 92);
        	g.drawString(yStorage, 75, 92);
    	}
    	else if (mode.equals("Y=2")){  //Y= 2    draws the second equation input
    		//resets the background
    		Graphics2D g2 = (Graphics2D) g;  //creates rectangle
    		g2.setColor(Color.GRAY); //sets it to the color gray
        	Rectangle bConsole = new Rectangle(0, 0, 400,145);
        	g2.fill(bConsole);
        	g2.draw(bConsole);
    		
        	g.setColor(new Color(255,255,0));   //sets background to yellow
        	Rectangle nConsole = new Rectangle((int)(xCoord), (int)(yCoord), 360,100);
        	g2.fill(nConsole);
        	g2.draw(nConsole);
        	
        	Font font = new Font("Verdana", Font.BOLD, 20); //sets font to bold 
        	g.setFont(font);
        	g.setColor(new Color(255,0,0)); //red colored font **matching graph
        	g.drawString("Y=", 40, 92);
        	g.drawString(yStorage2, 75, 92); //second storage
    	}
    	else if(mode.equals("Store")) {  //draws the store menu 
    		//draws a new panel
    		Graphics2D g2 = (Graphics2D) g;  //creates rectangle
    		g2.setColor(Color.BLUE); //sets it to the color blue
        	Rectangle bConsole = new Rectangle(0, 0, 400,145);  
        	g2.fill(bConsole);
        	g2.draw(bConsole);
        	
        	//draws the store keys
        	Font font = new Font("Verdana", Font.BOLD, 12); //sets font size to bold
        	bConsole = new Rectangle(70, 40, 45, 45);  //store a key
      		g2.setColor(Color.WHITE); //sets it to the color WHITE
        	g2.fill(bConsole);
        	g2.draw(bConsole);
            g2.setColor(new Color(0,0,0));  //setting text color to black
            g2.drawString("A", (int)(85), (int)(65));
        	bConsole = new Rectangle(165, 40, 45, 45); //b store key
        	g2.setColor(Color.WHITE); //sets it to the color WHITE
        	g2.fill(bConsole);
        	g2.draw(bConsole);
            g2.setColor(new Color(0,0,0));  //setting text color to black
            g2.drawString("B", (int)(180), (int)(65));
        	bConsole = new Rectangle(260, 40, 45, 45); //c store key
        	g2.setColor(Color.WHITE); //sets it to the color WHITE
        	g2.fill(bConsole);
        	g2.draw(bConsole);
            g2.setColor(new Color(0,0,0));  //setting text color to black
            g2.drawString("C", (int)(275), (int)(65));
        	
    		
    	}
    	else if(mode.equals("StoreAcc")) {  //draws the store access menu
    		//draws a new panel
    		Graphics2D g2 = (Graphics2D) g;  //creates rectangle
    		g2.setColor(Color.RED); //sets it to the color red
        	Rectangle bConsole = new Rectangle(0, 0, 400,145);
        	g2.fill(bConsole);
        	g2.draw(bConsole);
        	
        	//draws the store keys
        	Font font = new Font("Verdana", Font.BOLD, 12); //sets font size to bold
        	bConsole = new Rectangle(70, 40, 45, 45);  //store a key
      		g2.setColor(Color.WHITE); //sets it to the color WHITE
        	g2.fill(bConsole);
        	g2.draw(bConsole);
            g2.setColor(new Color(0,0,0));  //setting text color to black
            g2.drawString("A", (int)(85), (int)(65));
        	bConsole = new Rectangle(165, 40, 45, 45); //b store key
        	g2.setColor(Color.WHITE); //sets it to the color WHITE
        	g2.fill(bConsole);
        	g2.draw(bConsole);
            g2.setColor(new Color(0,0,0));  //setting text color to black
            g2.drawString("B", (int)(180), (int)(65));
        	bConsole = new Rectangle(260, 40, 45, 45); //c store key
        	g2.setColor(Color.WHITE); //sets it to the color WHITE
        	g2.fill(bConsole);
        	g2.draw(bConsole);
            g2.setColor(new Color(0,0,0));  //setting text color to black
            g2.drawString("C", (int)(275), (int)(65));
        	
    		
    	}
    	
    }
    //graphs a function onto the console
    //created by me
    public static void graph(Graphics g, Graphics2D g2, String yStorage, boolean graph1) { //graphing the equation
    	//code to graph the equation in Y=
    	if(yStorage.length() != 0) { //makes sure their is an equation
    		//Step one for the window 21 by 21 their has to be 2100 points if you scan every .01
    		//So first thing find the points
    		double value;
    		point[] store = new point[2001];
    		for(double i = -10*ZoomFactor; i <= 10*ZoomFactor; i += .01*ZoomFactor) { //increments by .01
    			i = round(i, 2);
    			value = eval(insertX("(" + i + ")", yStorage)); //inserts for x and then evalualates
    			//equation to get coordinates for x is 20x+200
    			//equation to get coordinates for y  -7.2x+72
    			float a = (float) (((100*i)/ZoomFactor)+1000); //scales it up to the correct index
    			store[(int)(a)] = new point((((20*i)/ZoomFactor)+200),(((-7.2*value)/ZoomFactor)+72));  //stores the point in the correct place with the correct coordinates
    		}
    		//after you get the points you have to plot all the points
    		for(int i = 0; i < 1999; i++) {
    			if(graph1 == true) g2.setColor(new Color(0,191,255)); //sets color to blue for graph 1 and 		red for graph 2
    			else g2.setColor(new Color(255,0,0)); //sets to red if graph two
    			Line2D.Double a = null;
            	try { 
            		a = new Line2D.Double(store[i].getX(),store[i].getY(),store[i+1].getX(),store[i+1].getY());  //creates the line 
            	}
            	catch(Exception e){
            		
            	}
            	if(a != null && store[i].getY() <= 145 && store[i].getY() >= 0 && store[i+1].getY() <= 145 && store[i+1].getY() >= 0) g2.draw(a);  //draws the line if in console
    		}
    	}
    }
    public double getA() { //gets the value in a variable
    	return storeA;
    }
    public double getB() { //gets the value in b variable
    	return storeB;
    }
    public double getC() { //gets the value in c variable
    	return storeC;
    }
    
    public static void zoomOut() { //zoom out 
    	ZoomFactor += .25;
    }
    public static void zoomIn() { //zoom in
    	if(ZoomFactor != .75)
    		ZoomFactor -= .25;
    }
    public static String insertX(String insert, String a) { //inserts value for x
    	String save = "";
    	String save2 = "";
    	String word = a;
    	for(int k = 0; k < word.length(); k++) {
    		if(word.substring(k, k+1).equals("x")) { //finds x
    			save = word.substring(0,k);
    			save2 = word.substring(k+1,word.length());
    			word = save + insert + save2;
    			k += insert.length() - 1; 
    		}
    	}
    	return word;
    }
    private static double round(double value, int precision) { //copied from DevilsHnd from stack overflow
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;   //allows you to round at a certain point
    }
    public void addConsole(String a) { //adds the current text to designated area
    	//adds a string to the arraylist
    	if(mode.equals("Calc") || mode.equals("Store") || mode.equals("StoreAcc")) {
    		consoleStorage = consoleStorage + a;
    		locationOfTextX -= 15;  //shifting it down so you can see the numbers
    	}
    	else if(mode.equals("Y=")) yStorage = yStorage + a;
    	else if(mode.equals("Y=2")) yStorage2 = yStorage2 + a;
    	
    }
    public void enter() { //for enter button if clicked
    	
		if(consoleStorage.substring(0,1).equals("A")) {
			storeA = Double.parseDouble(consoleStorage.substring(2,consoleStorage.length()-1));
	    	consoleStorage = "";
	    	locationOfTextX = 380;
		}
		else if(consoleStorage.substring(0,1).equals("B")) {
			storeB = Double.parseDouble(consoleStorage.substring(2,consoleStorage.length()-1));
	    	consoleStorage = "";
	    	locationOfTextX = 380;
		}
		else if(consoleStorage.substring(0,1).equals("C")) {
			storeC = Double.parseDouble(consoleStorage.substring(2,consoleStorage.length()-1));
	    	consoleStorage = "";
	    	locationOfTextX = 380;
		}
		else {
			ans = eval(consoleStorage);
	    	consoleStorage = "" + ans;
	    	locationOfTextX = 380;
	    	locationOfTextX -= (15*("" + ans).length());
		}

    	
    }
    public void clear() { //gets rid of all the text 
    	if(mode.equals("Calc")) {
    		consoleStorage = "";
    		locationOfTextX = 380; //resets the text positioning
    	}
    	else if(mode.equals("Y=")) {
    		yStorage = ""; //gets rid of the all the values in the storage for display
    	}
    	else if(mode.equals("Y=2")) {
    		yStorage2 = "";
    	}
    }
    public void delete() { //gets rid of one character on the screan
    	if(mode.equals("Calc")) {
    		consoleStorage = consoleStorage.substring(0, consoleStorage.length()-1);
    		locationOfTextX += 15; //shifts the text back 
    	}
    	else if(mode.equals("Y=")) {
    		yStorage = yStorage.substring(0, yStorage.length()-1);
    	}
    	else if(mode.equals("Y=2")) {
    		yStorage2 = yStorage2.substring(0, yStorage2.length()-1);
    	}
    	
    	
    }
    public void Shift(int a) { //shifts everything done for sqrt
    	locationOfTextX -= a*15;
    }
    public double getANS() { //gets the previous value after enter clicked 
    	return ans;
    }
    
    //mode changers
    public void setMode(String a) {
    	mode = a;
    }
    
    //evaluates a expression
    public static double eval(final String str) {  //eval method copied from stack overflow author: Boann    modified by: Alan Wang
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);  //changed by Alan Wang
                    else if (func.equals("sin")) x = Math.sin(x); //degree mode
                    else if (func.equals("cos")) x = Math.cos(x); //degree mode 
                    else if (func.equals("tan")) x = Math.tan(x); //degree mode
                    else if (func.equals("fact")) x = factorial((int)x);
                    else if (func.equals("log")) x = round((Math.log(x)/Math.log(10.0)),5); //log and change base from natural log to actual log
                    else if (func.equals("ln")) x = Math.log(x); //natural log
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
    public static int factorial(int a) { //calculates factorial
    	int product = 1;
    	for(int i = a; i >= 1; i-- ) {
    		product = product * i;
    	}
    	return product;
    }

}
