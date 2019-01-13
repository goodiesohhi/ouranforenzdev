package law; // sets package

import java.awt.image.BufferedImage; // imports image
import java.io.IOException; // imports IOException
import java.util.ArrayList; // imports ArrayList

import javax.imageio.ImageIO; // imports image input

public class ClickEvent { // opens class

	int id; // holds id of event
	BufferedImage image; // holds image
	int x; // holds x value
	int y; // holds y value
	int width; // holds width
	int height; // holds height
	boolean unlocked; // holds if the event was unlocked
	boolean collectable; // holds if the event should disappear
	ClickEvent(Boolean type , String path,int x, int y, int w, int h,ArrayList<ClickEvent> ce,int id) throws IOException { // constructs click event and sets all fields
		 image= ImageIO.read( Main.class.getResource("/resources/ce/"+path+".png"));
		 this.x=x;
		 this.y=y;
		 height=h;
		 width=w;
		 this.id =  id;
		 unlocked=false;
		 //true means its collectable and disappears
		 collectable=type;
	}
}
