package law; // selects package
import java.io.IOException; // imports IOException
public class SaibaApartment extends Location  { // opens class
	StoryManager story = Main.currentCase; // sets current case
	public SaibaApartment() // constructs apartment
	{
		super("Saiba Apartment", 64); // sets location
	}
	@Override
	void enter() throws IOException // enters location
	{
		super.enter(); // enters super
		this.addEvent((new ClickEvent(false,"flowerVase", 50, 300, 60, 50, this.clickEvents, 0))); // creates click events
		this.addEvent((new ClickEvent(false,"briefcase", 150, 600, 30, 70, this.clickEvents, 1)));
		this.addEvent((new ClickEvent(false,"painting", 300, 100, 100, 100, this.clickEvents, 2)));
		this.addEvent((new ClickEvent(false, "bigStick", 500, 100, 128, 128, this.clickEvents, 3)));
		if(!flags[3]) // ensures that this only runs once
		{
			story.insertData("Saiba Corp. Apartment Entrance"); // inserts text
			story.insertData("August 10");
			story.insertData("9:10 PM");
			story.insertD("Puff, puff... You cheated by taking the elevator!", "Ouran");
			story.insertD("It wasn’t cheating! Susan-chan told us we could, desu!", "Nekocchi");
			story.insertR("Elevator and Stairs", "elevStairs", "Stairs next to an elevator.", false, 11); // inserts to record
			story.insertData("Elevator and Stairs have been added to Court Record.");
			story.insertD("Well, let’s get examining...", "Ouran");
			flags[3] = true; // ensures that only runs once
		}
		
	}
	@Override
	void update() // updates location
	{
		super.update(); // updates super
	}
	@Override
	void events (int i) // runs through events
	{
		if (i == 0) // if the event is 0
		{
			story.insertD("Looks like the Saibas love their exotic flowers...", "Ouran"); // play dialogue
		}
		if (i == 1) // chooses event
		{
			story.insertD("The upstanding business family obviously has the symbol of a briefcase.", "Ouran"); // plays dialogue
		}
		if (i == 2) // chooses event
		{
			story.insertD("Garish. Looks kind of like my attorney’s badge.", "Ouran"); // plays dialogue
		}
		if (i == 3) // chooses event
		{
			story.insertD("Weird-looking. Maybe a stick of some kind?", "Ouran"); // plays dialogue
		}
	}
	@Override
	void talk (int i) // talks to character
	{
		
	}
	@Override
	protected void present (RecordEntry recordEntry) // presents item
	{
		story.insertD("I should really stop trying to show things to non-existent people.", "Ouran"); // plays default dialogue
	}
}
