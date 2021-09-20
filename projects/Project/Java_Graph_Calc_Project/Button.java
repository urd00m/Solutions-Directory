package Java_Graph_Calc_Project;

import java.awt.Color; 
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//Modified from last year
public class Button 
{

	private double xCoord;
	private double yCoord;
	private Color col;
	//private double xAcc;
	//private double yAcc;

    public Button(double a, double b) 
    {
    	xCoord = a;
    	yCoord = b;
    	col = new Color(255,255,255); //white
    }

    public void drawKey(Graphics g, String a)  //different type of keys
    {
    	Font font = new Font("Verdana", Font.TRUETYPE_FONT, 12); //resests font size
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setFont(font);
    	g.setColor(col);
        Rectangle box = new Rectangle((int)(xCoord),(int)(yCoord),45,45);  //smaller type key
        g2.fill(box);
        g2.draw(box);
        g2.setColor(new Color(0,0,0));  //setting text color to black
        g2.drawString(a, (int)(xCoord+5), (int)(yCoord+25));
    }
    public void drawKey2(Graphics g, String a)
    {
    	Font font = new Font("Verdana", Font.TRUETYPE_FONT, 12); //resests font size
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setFont(font);
    	g.setColor(col);
        Rectangle box = new Rectangle((int)(xCoord),(int)(yCoord),50,20);   //wider but not as tall and more rectanglish type key
        g2.fill(box);
        g2.draw(box);
        g2.setColor(new Color(0,0,0)); //setting text color to black
        g2.drawString(a, (int)(xCoord+5), (int)(yCoord+15));
    }
    
    public void drawKey3(Graphics g, String a) {  //20 by 45 used for the parantheses button
    	Font font = new Font("Verdana", Font.TRUETYPE_FONT, 12); //resests font size
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setFont(font);
    	g.setColor(col);
        Rectangle box = new Rectangle((int)(xCoord),(int)(yCoord),20,45);  //smaller type key
        g2.fill(box);
        g2.draw(box);
        g2.setColor(new Color(0,0,0));  //setting text color to black
        g2.drawString(a, (int)(xCoord+7), (int)(yCoord+25));
    }
    
    public void drawKey4(Graphics g, String a) { //four the clr and del button
    	Font font = new Font("Verdana", Font.TRUETYPE_FONT, 12); //resests font size
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setFont(font);
    	g.setColor(col);
        Rectangle box = new Rectangle((int)(xCoord),(int)(yCoord),40,20);  //smaller type key
        g2.fill(box);
        g2.draw(box);
        g2.setColor(new Color(0,0,0));  //setting text color to black
        g2.drawString(a, (int)(xCoord+7), (int)(yCoord+15));
    }
    
    public void drawGraphKey(Graphics g, String a) { //four the clr and del button
    	Font font = new Font("Verdana", Font.TRUETYPE_FONT, 12); //resests font size
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setFont(font);
    	g.setColor(col);
        Rectangle box = new Rectangle((int)(xCoord),(int)(yCoord),70,20);  //smaller type key
        g2.fill(box);
        g2.draw(box);
        g2.setColor(new Color(0,0,0));  //setting text color to black
        g2.drawString(a, (int)(xCoord+7), (int)(yCoord+15));
    }
    
    
    
    

    
    
    
}