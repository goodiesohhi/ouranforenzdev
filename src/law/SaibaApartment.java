package law;
import java.io.IOException;
public class SaibaApartment extends Location  {
	StoryManager story = Main.currentCase;
	public SaibaApartment()
	{
		super("Saiba Apartment", 64);
	}
	@Override
	void enter() throws IOException
	{
		super.enter();
		this.addEvent((new ClickEvent("flowerVase", 50, 300, 60, 50, this.clickEvents, 0)));
		this.addEvent((new ClickEvent("briefcase", 150, 600, 30, 70, this.clickEvents, 1)));
		this.addEvent((new ClickEvent("painting", 300, 100, 100, 100, this.clickEvents, 2)));
		if(!flags[3])
		{
			story.insertD("Saiba Corp. Apartment Entrance", "");
			story.insertD("August 10", "");
			story.insertD("9:10 PM", "");
			story.insertD("Puff, puff... You cheated by taking the elevator!", "Ouran");
			story.insertD("It wasn’t cheating! Susan-chan told us we could, desu!", "Nekocchi");
			story.insertR("Elevator and Stairs", "elevStairs", "Stairs next to an elevator.", false, 11);
			story.insertD("Well, let’s get examining...", "Ouran");
			flags[3] = true;
		}
		
	}
	@Override
	void update()
	{
		super.update();
	}
	@Override
	void events (int i)
	{
		if (i == 0)
		{
			story.insertD("Looks like the Saibas love their exotic flowers...", "Ouran");
		}
		if (i == 1)
		{
			story.insertD("The upstanding business family obviously has the symbol of a briefcase.", "Ouran");
		}
		if (i == 2)
		{
			story.insertD("Garish. Looks kind of like my attorney’s badge.", "Ouran");
		}
	}
	@Override
	void talk (int i)
	{
		
	}
	@Override
	protected void present (RecordEntry recordEntry)
	{
		story.insertD("I should really stop trying to show things to non-existent people.", "Ouran");
	}
}
