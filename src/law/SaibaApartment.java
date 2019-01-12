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
		this.addEvent((new ClickEvent(false,"flowerVase", 50, 300, 60, 50, this.clickEvents, 0)));
		this.addEvent((new ClickEvent(false,"briefcase", 150, 600, 30, 70, this.clickEvents, 1)));
		this.addEvent((new ClickEvent(false,"painting", 300, 100, 100, 100, this.clickEvents, 2)));
		this.addEvent((new ClickEvent(false, "bigStick", 500, 100, 128, 128, this.clickEvents, 3)));
		if(!flags[3])
		{
			story.insertData("Saiba Corp. Apartment Entrance");
			story.insertData("August 10");
			story.insertData("9:10 PM");
			story.insertD("Puff, puff... You cheated by taking the elevator!", "Ouran");
			story.insertD("It wasn’t cheating! Susan-chan told us we could, desu!", "Nekocchi");
			story.insertR("Elevator and Stairs", "elevStairs", "Stairs next to an elevator.", false, 11);
			story.insertData("Elevator and Stairs have been added to Court Record.");
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
		if (i == 3)
		{
			story.insertD("Weird-looking. Maybe a stick of some kind?", "Ouran");
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
