package Java_Graph_Calc_Project;

import java.awt.Graphics;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;

import javax.script.ScriptException;

public class ClickListener extends MouseAdapter {
	private String mode = "Calc";
	private BallPanel panel;
	public ClickListener(BallPanel a) {
		panel = a;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//Example: panel.addConsole("a");
		//design
		//coordinates for if clicked inside the coordinates then 
		//either changes mode or prints to console through the ball panel which then sends it to the console
		//top 4 keys
		
		//methods in panel that are used**
		//addConsole prints the text to screen
		//setMode sets the desired mode and relays the information to the console class changing the screen
		//shift   shifts the text in the console a specific amount of characters
		//enterClicked   causes the current expression on the screen to be evaluated
		//deleteClicked   removes one character on screen
		//clearClicked   removes all characters on screen
		if(e.getX() >= 40 && e.getX() <= 90 && e.getY() >= 170 && e.getY() <= 190 && !mode.equals("Calc")) {  //calc key
			panel.setMode("Calc"); 
			mode = "Calc"; //sets in class mode
		}
		else if(e.getX() >= 130 && e.getX() <= 180 && e.getY() >= 170 && e.getY() <= 190 && !mode.equals("Graph")) {  //graph key
			panel.setMode("Graph"); 
			mode = "Graph";
		}		
		else if(e.getX() >= 220 && e.getX() <= 270 && e.getY() >= 170 && e.getY() <= 190 && !mode.equals("Y=")) {  //Y= key
			panel.setMode("Y="); //sets the mode in console through panel
			mode = "Y=";
		}
		else if(e.getX() >= 310 && e.getX() <= 360 && e.getY() >= 170 && e.getY() <= 190 && !mode.equals("Y=2")) {  //2nd Y= key
			panel.setMode("Y=2"); 
			mode = "Y=2";
		}
		
		
		
		
		//number keys
		else if(e.getX() >= 85 && e.getX() <= 130 && e.getY() >= 240 && e.getY() <= 285 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 7
			panel.addConsole("7");
		}
		else if(e.getX() >= 150 && e.getX() <= 195 && e.getY() >= 240 && e.getY() <= 285 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 8
			panel.addConsole("8");
		}
		else if(e.getX() >= 215 && e.getX() <= 260 && e.getY() >= 240 && e.getY() <= 285 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 9
			panel.addConsole("9");
		}
		else if(e.getX() >= 85 && e.getX() <= 130 && e.getY() >= 305 && e.getY() <= 350 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 4
			panel.addConsole("4");
		}
		else if(e.getX() >= 150 && e.getX() <= 195 && e.getY() >= 305 && e.getY() <= 350 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 5
			panel.addConsole("5");
		}
		else if(e.getX() >= 215 && e.getX() <= 260 && e.getY() >= 305 && e.getY() <= 350 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 6
			panel.addConsole("6");
		}
		else if(e.getX() >= 85 && e.getX() <= 130 && e.getY() >= 370 && e.getY() <= 415 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 1
			panel.addConsole("1");
		}
		else if(e.getX() >= 150 && e.getX() <= 195 && e.getY() >= 370 && e.getY() <= 415 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 2
			panel.addConsole("2");
		}
		else if(e.getX() >= 215 && e.getX() <= 260 && e.getY() >= 370 && e.getY() <= 415 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 3
			panel.addConsole("3");
		}
		else if(e.getX() >= 150 && e.getX() <= 195 && e.getY() >= 435 && e.getY() <= 480 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number 0
			panel.addConsole("0");
		}
		
		//simple operation keys
		else if(e.getX() >= 280 && e.getX() <= 325 && e.getY() >= 240 && e.getY() <= 285 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number +
			panel.addConsole("+");
		}
		else if(e.getX() >= 280 && e.getX() <= 325 && e.getY() >= 305 && e.getY() <= 350 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number -
			panel.addConsole("-");
		}
		else if(e.getX() >= 280 && e.getX() <= 325 && e.getY() >= 370 && e.getY() <= 415 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number *
			panel.addConsole("*");
		}
		else if(e.getX() >= 280 && e.getX() <= 325 && e.getY() >= 435 && e.getY() <= 480 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //number /
			panel.addConsole("/");
		}
		
		//enter button
		else if(e.getX() >= 345 && e.getX() <= 390 && e.getY() >= 435 && e.getY() <= 480 && mode.equals("Calc")) {  //enter
				panel.enterClicked();
		}
		
		//the parentheses button
		else if(e.getX() >= 345 && e.getX() <= 365 && e.getY() >= 240 && e.getY() <= 285 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //(
			panel.addConsole("(");
		}
		else if(e.getX() >= 370 && e.getX() <= 395 && e.getY() >= 240 && e.getY() <= 285 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //)
			panel.addConsole(")");
		}
		//delete and clear button
		else if(e.getX() >= 280 && e.getX() <= 320 && e.getY() >= 215 && e.getY() <= 235 && (mode.equals("Calc") || mode.equals("Y=")  || mode.equals("Y=2"))) {  //del 
			panel.deleteClicked();
		}
		else if(e.getX() >= 330 && e.getX() <= 370 && e.getY() >= 215 && e.getY() <= 235 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //clr
			panel.clearClicked();
		}
		//sqrt and ^ buttons
		else if(e.getX() >= 20 && e.getX() <= 65 && e.getY() >= 240 && e.getY() <= 285 && (mode.equals("Calc") || mode.equals("Y=2") || mode.equals("Y="))) {  //sqrt 
			panel.addConsole("sqrt("); //needs to make a call for shift 4
			panel.shift(4); //shifts it for the other 3 characters
		}
		else if(e.getX() >= 20 && e.getX() <= 65 && e.getY() >= 305 && e.getY() <= 350 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //^
			panel.addConsole("^");
		}
		//the dot button
		else if(e.getX() >= 215 && e.getX() <= 260 && e.getY() >= 435 && e.getY() <= 480 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //.
			panel.addConsole(".");
		}
		
		//the ans button
		else if(e.getX() >= 85 && e.getX() <= 130 && e.getY() >= 435 && e.getY() <= 480 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //ANS
			panel.addConsole("" + panel.ansClicked());
			panel.shift((""+panel.ansClicked()).length()-1);
		}
		
		//the trig functions for the calc area
		else if(e.getX() >= 85 && e.getX() <= 130 && e.getY() >= 500 && e.getY() <= 545 && (mode.equals("Calc"))) {  //cos
			panel.addConsole("cos(");
			panel.shift(3);
		}
		else if(e.getX() >= 150 && e.getX() <= 195 && e.getY() >= 500 && e.getY() <= 545 && (mode.equals("Calc"))) {  //sin
			panel.addConsole("sin(");
			panel.shift(3);
		}
		else if(e.getX() >= 215 && e.getX() <= 260 && e.getY() >= 500 && e.getY() <= 545 && (mode.equals("Calc"))) {  //tan
			panel.addConsole("tan(");
			panel.shift(3);
		}
		
		//for the Y= section
		else if(e.getX() >= 85 && e.getX() <= 130 && e.getY() >= 500 && e.getY() <= 545 && (mode.equals("Y=") || mode.equals("Y=2"))) {  //cos
			panel.addConsole("cos(");
		}
		else if(e.getX() >= 150 && e.getX() <= 195 && e.getY() >= 500 && e.getY() <= 545 && (mode.equals("Y=") || mode.equals("Y=2"))) {  //sin
			panel.addConsole("sin(");
		}
		else if(e.getX() >= 215 && e.getX() <= 260 && e.getY() >= 500 && e.getY() <= 545 && (mode.equals("Y=") || mode.equals("Y=2"))) {  //tan
			panel.addConsole("tan(");
		}
		
		
		//variable for graphing
		else if(e.getX() >= 20 && e.getX() <= 65 && e.getY() >= 370 && e.getY() <= 415 && (mode.equals("Y=") || mode.equals("Y=2"))) {  //var
			panel.addConsole("x");
		}
		
		//the factorial key
		else if(e.getX() >= 20 && e.getX() <= 65 && e.getY() >= 435 && e.getY() <= 480 && mode.equals("Calc")) {  //fact
			panel.addConsole("fact");
			panel.shift(3);
		}
		
		//store key
		else if(e.getX() >= 20 && e.getX() <= 65 && e.getY() >= 500 && e.getY() <= 545 && mode.equals("Calc")) {  //sto
			panel.setMode("Store");
			mode = "Store";
		}
		//storeAcc key
		else if(e.getX() >= 20 && e.getX() <= 65 && e.getY() >= 565 && e.getY() <= 610 && mode.equals("Calc")) {  //stoAcc
			panel.setMode("StoreAcc");
			mode = "StoreAcc";
		}
		//store a,b,c keys
		else if(e.getX() >= 70 && e.getX() <= 115 && e.getY() >= 40 && e.getY() <= 85 && mode.equals("Store")) {  //storea
			panel.addConsole("A(");
			panel.shift(1);
			panel.setMode("Calc");
			mode = "Calc";
		}		
		else if(e.getX() >= 165 && e.getX() <= 210 && e.getY() >= 40 && e.getY() <= 85 && mode.equals("Store")) {  //storeb
			panel.addConsole("B(");
			panel.shift(1);
			panel.setMode("Calc");
			mode = "Calc";
		}
		else if(e.getX() >= 260 && e.getX() <= 305 && e.getY() >= 40 && e.getY() <= 85 && mode.equals("Store")) {  //storec
			panel.addConsole("C(");
			panel.shift(1);
			panel.setMode("Calc");
			mode = "Calc";
		}
		//the actual stored values
		else if(e.getX() >= 70 && e.getX() <= 115 && e.getY() >= 40 && e.getY() <= 85 && mode.equals("StoreAcc")) {  //a
			double a = panel.getConsole().getA();
			panel.addConsole("" + a);
			panel.shift( ("" + a).length()-1);
			panel.setMode("Calc");
			mode = "Calc";
		}		
		else if(e.getX() >= 165 && e.getX() <= 210 && e.getY() >= 40 && e.getY() <= 85 && mode.equals("StoreAcc")) {  //b
			double a = panel.getConsole().getB();
			panel.addConsole("" + a);
			panel.shift( ("" + a).length()-1);
			panel.setMode("Calc");
			mode = "Calc";
		}
		else if(e.getX() >= 260 && e.getX() <= 305 && e.getY() >= 40 && e.getY() <= 85 && mode.equals("StoreAcc")) {  //c
			double a = panel.getConsole().getC();
			panel.addConsole("" + a);
			panel.shift( ("" + a).length()-1);
			panel.setMode("Calc");
			mode = "Calc";
		}
		//log key
		else if(e.getX() >= 345 && e.getX() <= 390 && e.getY() >= 305 && e.getY() <= 350 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //log
			panel.addConsole("log(");
			panel.shift(3);
		}
		//natural log key
		else if(e.getX() >= 345 && e.getX() <= 390 && e.getY() >= 370 && e.getY() <= 415 && (mode.equals("Calc") || mode.equals("Y=") || mode.equals("Y=2"))) {  //ln
			panel.addConsole("ln(");
			panel.shift(2);
		}
		
		//added these parts
		//Zoom in 
		else if(e.getX() >= 40 && e.getX() <= 110 && e.getY() >= 200 && e.getY() <= 220 && (mode.equals("Graph"))) {  
			Console.zoomIn();
			
			panel.moveAll();
		}
		
		//Zoom out 
		else if(e.getX() >= 120 && e.getX() <= 190 && e.getY() >= 200 && e.getY() <= 220 && (mode.equals("Graph"))) {  
			Console.zoomOut();
			panel.moveAll();
		}
		
		
	}

}
