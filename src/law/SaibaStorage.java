package law;
import java.io.IOException;
public class SaibaStorage extends Location {
	StoryManager story = Main.currentCase;
	int progression = 0;
	public SaibaStorage()
	{
		super("Saiba Storage", 68);
	}
	@Override
	void enter() throws IOException
	{
		super.enter();
		this.addEvent(new ClickEvent("storageWall", 0, 0, 400, 700, this.clickEvents, 0));
		this.addEvent(new ClickEvent("dragonModel", 400, 100, 450, 500, this.clickEvents, 1));
		this.addEvent(new ClickEvent("dragonMouth", 850, 200, 50, 35, this.clickEvents, 2));
		if(!flags[5])
		{
			story.insertD("Saiba Corp. Storage", "");
			story.insertD("August 10", "");
			story.insertD("9:20 PM", "");
			story.insertD("That dragon...", "Ouran");
			story.insertD("It’s huge!", "Nekocchi");
			story.insertD("The dragon’s 2.5 metres tall.", "Det. Pat. Bluthund");
			story.insertD("(Now I just have to examine it...)", "Ouran");
			flags[5] = true;
		}
	}
	@Override
	void update()
	{
		super.update();
		if(progression == 2)
		{
			progression++;
			story.insertD("Well, we’re packing up for the night.", "Det. Pat. Bluthund");
			story.insertD("Are you good, Ouran?", "Det. Pat. Bluthund");
			story.insertD("Yeah, I think I’m ready.", "Ouran");
			story.insertD("(A dragon? How am I going to deal with that?)", "Ouran");
			story.insertD("TO BE CONTINUED", "");
			story.toCourt();
		}
	}
	@Override
	void events (int i)
	{
		if (i == 0)
		{
			story.insertD("Looks industrial... stark contrast to the rest of the apartment.", "Ouran");
			
		}
		if (i == 1)
		{
			story.insertD("That’s pretty realistic.", "Ouran");
			story.insertD("Looks like it could actually come to life.", "Ouran");
			story.insertD("My Fairilees are quaking in their boots, nya!", "Nekocchi");
			story.insertR("Dragon Model", "dragonModel", "It’s big, bulky, and heavy.", false, 14);
			progression++;
		}
		if (i == 2)
		{
			story.insertD("What’s that in the mouth?", "Ouran");
			story.insertD("It’s a flamethrower, Mr. Forenz", "Det. Pat. Bluthund");
			story.insertD("A flamethrower?", "Ouran");
			story.insertD("But wasn’t the victim killed by burns, desu ka?", "Nekocchi");
			story.insertD("It seems so...", "Ouran");
			story.insertR("Flamethrower", "flamethrower", "Used to kill Komuba, or so the prosecution claims...", false, 15);
			progression++;
		}
	}
	@Override
	void talk (int i)
	{
		
	}
	@Override
	protected void present(RecordEntry recordEntry)
	{
		story.insertD("Why would I show this to the dragon?", "Ouran");
		story.insertD("Stop being sugoi baka, Ouran.", "Nekocchi");
	}
}
