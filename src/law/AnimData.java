 package law;
 public class AnimData{
	String charName;
	String animName;
	int frames;
	boolean loop;
	
	AnimData(String cn,String n, int f, boolean b){
		animName=n;
		frames=f;
		loop=b;
		charName=cn;
		
	}
}