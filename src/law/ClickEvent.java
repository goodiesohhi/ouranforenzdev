package law;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ClickEvent {

	int id;
	BufferedImage image;
	int x;
	int y;
	int width;
	int height;
	boolean unlocked;
	boolean collectable;
	ClickEvent(Boolean type , String path,int x, int y, int w, int h,ArrayList<ClickEvent> ce,int id) throws IOException {
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
