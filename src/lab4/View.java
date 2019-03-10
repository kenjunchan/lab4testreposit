package lab4;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

public class View extends JPanel{
    final int frameCount = 10;
    int picNum = 0;
    BufferedImage[] pics;
    int amtOfImages = 8;
    int xloc,yloc;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    
	View(){
		JFrame frame = new JFrame();
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(View.frameWidth, View.frameHeight);
		frame.setVisible(true);
		frame.getContentPane().add(this);
    	pics = new BufferedImage[(amtOfImages) * 10];    	
    	for(int n = 0; n <= 7 ; n++) 
    	{
    		BufferedImage img = createImage(n);
    		for(int i = 0; i < frameCount; i++) 
    		{
    			pics[i + (n * 10)] = img.getSubimage(imgWidth*i, 0, imgWidth, imgHeight);
    		}
    	}
    	
	}
	public void paint(Graphics g){
	    g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);	
	}
	public int getWidth() {
		return this.frameWidth;
	}
	public int getHeight() {
		return this.frameHeight;
	}
	public int getImageWidth() {
		return this.imgWidth;
	}
	public int getImageHeight() {
		return this.imgHeight;
	}
	
	//called to create a buffered image, int n refers to the Direction the orc is facing (check Direction enum)
	private BufferedImage createImage(int n)
    {
    	BufferedImage bufferedImage;
    	try 
    	{
    		String fileName = "images/orc/orc_forward_" + Direction.getStrEquiv(n) + ".png";
    		bufferedImage = ImageIO.read(new File(fileName));
    		return bufferedImage;
    	} 
    	catch (IOException e) 
    	{
    		e.printStackTrace();
    	}
    	return null;
    }
	
	//called to update the location and direction of the image (orc)
	public void update(int x, int y, Direction direct) {
		picNum = ((picNum + 1) % frameCount) + (direct.getNum() * 10);
		this.xloc = x;
		this.yloc = y;
		this.repaint();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
