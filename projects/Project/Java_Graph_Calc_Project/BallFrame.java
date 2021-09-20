package Java_Graph_Calc_Project;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
//reused code from last year
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class BallFrame extends JFrame
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 700;
	BallPanel bp;
	public BallFrame()
	{
		super("T-51.WangWang1.0");

		setSize(WIDTH,HEIGHT);
		bp = new BallPanel(WIDTH,HEIGHT);
		getContentPane().add(bp);
		getContentPane().addMouseListener(new ClickListener(bp)); //adds in the mouse listener to the frame
		//bp.setBackground(Color.BLACK); unneccasary it can be done in the actual panel constructor
		setVisible(true);
		bp.moveAll(); //activates the graphics and program
		
		
	}
	
}