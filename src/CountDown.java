//Name: Melody Huang
//Date: 05/23/2021
//Rev: 03
//Note: CountDown timer 30 seconds
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class CountDown extends JPanel{

	private int timer = 60;
	private String timerText = "30";

	//constructor
	public CountDown()
	{

	}
	//keep track of time
	public void setTime()
	{
		timer--;
	}
	//draws the clock on window
	public void draw(Graphics g)
	{

		//timer drawer
		g.setFont(new Font("Monospaced", Font.PLAIN, 40));

		if (timer > 0) {

			if (timer < 10 ) {
				timerText = "0"+ Integer.toString(timer);
			}		
			else {
				timerText = Integer.toString(timer);
			}

			if (timer < 5 ) {
				g.setColor(Color.RED);
				g.drawString("00:" + timerText, 4, 30);
				repaint();
			}
			else {
				g.setColor(new Color(43, 164, 99));
				g.drawString("00:" + timerText, 4, 30);
				repaint();
			}

		}

		if(timer == 0)
		{

		}
	}

	//decrease time by one second
	public void setTimer()
	{
		timer--;
	}
	// returns remaining time
	public int getTime()
	{
		return timer;
	}


}
