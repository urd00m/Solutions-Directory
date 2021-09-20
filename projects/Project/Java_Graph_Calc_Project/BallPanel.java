package Java_Graph_Calc_Project;

import java.awt.Font; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;

import javax.script.ScriptException;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Reused from last year, but completely remodelled to fit calculator
public class BallPanel extends JPanel
{
//	Ball b1;
	int wid;
	int len;
	Button[] keys = new Button[38];
	private Graphics GUI; //graphics input the program is using to draw
	private Console console = new Console();

	public BallPanel(int w, int l)
	{
		wid = w;
		len = l;
		
		//first 4 are the top 4 keys, calc, graph, y= and window
		keys[0] = new Button(40, 170);    //window button
		keys[1] = new Button(130,170); 
		keys[2] = new Button(220,170); 
		keys[3] = new Button(310,170); //y= 2
		//next 10 keys are the number keys
		keys[4] = new Button(85,240);
		keys[5] = new Button(150,240);
		keys[6] = new Button(215, 240);
		keys[7] = new Button(85, 305);
		keys[8] = new Button(150, 305);
		keys[9] = new Button(215, 305);
		keys[10] = new Button(85, 370);
		keys[11] = new Button(150, 370);
		keys[12] = new Button(215, 370);
		keys[13] = new Button(150, 435);
		//next 4 draws the simple operations button
		keys[14] = new Button(280, 240);
		keys[15] = new Button(280, 305);
		keys[16] = new Button(280, 370);
		keys[17] = new Button(280, 435);
		//enter button next to the "/" button
		keys[18] = new Button(345, 435);
		//the parentheses buttons
		keys[19] = new Button(345, 240);  //20 by 45 buttons
		keys[20] = new Button(370, 240);  //20 by 45 buttons
		//delete and clear button
		keys[21] = new Button(280, 215);
		keys[22] = new Button(330, 215 );
		//the sqrt button and ^ button
		keys[23] = new Button(20, 240);
		keys[24] = new Button(20, 305);
		//the dot button
		keys[25] = new Button(215, 435);
		//the ans button
		keys[26] = new Button(85, 435);
		//trig functions
		keys[27] = new Button(85, 500); //cos
		keys[28] = new Button(150, 500); //sin
		keys[29] = new Button(215, 500); //tan
		//variable x for graphing
		keys[30] = new Button(20, 370); // var
		//the factorial key     prints "fact"
		keys[31] = new Button(20, 435);  //fact
		//variable storage keys
		//access to variable storage menu
		keys[32] = new Button(20, 500 ); //sto key
		//access the data in store keys
		//access to variable storage menu
		keys[33] = new Button(20, 565 ); //stoAcc key
		//log key
		keys[34] = new Button(345, 305); //log key
		//natural log key
		keys[35] = new Button(345, 370);
		
		//zoom in zoom out
		keys[36] = new Button(40,200);
		keys[37] = new Button(120, 200);
		
				
		
		
		
		


		setBackground(Color.GRAY);
		setVisible(true);


	}
	public Graphics getGUI() {
		return GUI;   //so the method paint doens't have to be called everytime and single buttons can be changed instead of all of them
		
	}
	public void moveAll()
	{
		/*
		while(true)
		{
			try
            {
                Thread.sleep(10);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
			*/
			repaint();
		//}
	}
	
	public void update(Graphics window)
	{
		paint(window);
		System.out.println(this.getWidth());
	}
	public void addConsole(String a) {
		console.addConsole(a);
		repaint();
	}
	public void clearClicked() {
		console.clear();
		repaint(); 
	}
	public void deleteClicked() {
		console.delete();
		repaint();
	}
	public void enterClicked() {
		console.enter();
		repaint();
	}
	public void shift(int a) {
		console.Shift(a);
		repaint();
	}
	public double ansClicked() {
		return console.getANS();
	}
	
	//mode switchers
	public void setMode(String a) {
		console.setMode(a);
		repaint();
	}
	public Console getConsole() {
		return console;
	}
	
	public void updateGraph() {
		console.nConsole(GUI);
	}

	public void paint(Graphics window)
	{ 
		//draws the keys
		//key draw method    (graphics a, String b) b is the text on the key
		GUI = window; //might not need *remove
		//draws console
		console.nConsole(window);
		//draws the buttons
		keys[0].drawKey2(window, "Calc"); //(40,170) button2: 50 width, and 20 height
		keys[1].drawKey2(window, "Graph"); //(130, 170) type button2
		keys[2].drawKey2(window, "Y=");  //(220, 170) type button2
		keys[3].drawKey2(window, "Y2="); //(310,170) type button2
		keys[4].drawKey(window, "7");
		keys[5].drawKey(window, "8");
		keys[6].drawKey(window, "9");
		keys[7].drawKey(window, "4");
		keys[8].drawKey(window, "5");
		keys[9].drawKey(window, "6");
		keys[10].drawKey(window, "1");
		keys[11].drawKey(window, "2");
		keys[12].drawKey(window, "3");
		keys[13].drawKey(window, "0");
		//draws simple operation buttons, 4
		keys[14].drawKey(window, "+");
		keys[15].drawKey(window, "-");
		keys[16].drawKey(window, "*");
		keys[17].drawKey(window, "/");
		//the enter button
		keys[18].drawKey(window, "Enter");
		//parentheses key
		keys[19].drawKey3(window, "(");
		keys[20].drawKey3(window, ")");
		//delete and clr key
		keys[21].drawKey4(window, "del");
		keys[22].drawKey4(window, "clr");
		//sqrt button and ^ 
		keys[23].drawKey(window, "sqrt");
		keys[24].drawKey(window, "^");
		//the dot button
		keys[25].drawKey(window, ".");
		//the ans button
		keys[26].drawKey(window, "ans");
		//the trig buttons
		keys[27].drawKey(window, "cos");
		keys[28].drawKey(window, "sin");
		keys[29].drawKey(window, "tan");
		//variable for graphing
		keys[30].drawKey(window, "var");
		//factorial key
		keys[31].drawKey(window, "fact");
		//variable storage keys
		//access to variable storage menu
		keys[32].drawKey(window, "Sto");
		//access data
		keys[33].drawKey(window, "StoAcc");
		//log key
		keys[34].drawKey(window, "Log");
		//natural log key
		keys[35].drawKey(window, "ln");
		
		//zoom in, zoom out key
		keys[36].drawGraphKey(window, "Zoom In");
		keys[37].drawGraphKey(window, "Zoom Out");
		
	}
}