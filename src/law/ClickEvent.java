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
	ClickEvent(String path,int x, int y, int w, int h,ArrayList<ClickEvent> ce) throws IOException {
		 image= ImageIO.read( Main.class.getResource("/resources/ce/"+path+".png"));
		 this.x=x;
		 this.y=y;
		 height=h;
		 width=w;
		 id =  ce.indexOf(this);
	}
}
