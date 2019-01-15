package law; // selects package
import java.io.IOException; // imports IOException
public class ForenzOffice extends Location { // creates class
	boolean block; // holds boolean value
	StoryManager story = Main.currentCase; // holds current case
	public ForenzOffice() { // opens constructor
		 super("Forenz Law Office",55); // holds background
		 block=true; // sets block to true
	}
	@Override
	void enter() throws IOException { // enters area
		super.enter(); // enters super
		// creates click events
		this.addEvent((new ClickEvent(false,"maggotTank", 300, 100, 300, 100, this.clickEvents, 0)));
		this.addEvent((new ClickEvent(false,"workTable", 250, 300, 400, 350, this.clickEvents, 1)));
		this.addEvent((new ClickEvent(false,"chemicalPlant", 900, 100, 50, 50, this.clickEvents, 2)));
		this.addEvent((new ClickEvent(false,"filingCabinet", 850, 150, 100, 300, this.clickEvents, 3)));
		// sets block
		block = true;
		 if (block){ // if block is true
			 if (!flags[0]) // if the location is not entered
			 {
				 //inserts data and dialogues
				 story.insertData("Forenz Office");
				 story.insertData("August 10");
				 story.insertData("8:00 PM");
				 story.insertD("(It’s the end of a long day doing nothing.)", "Ouran");
				 story.insertD("(I better check the news, since this is how I normally find clients anyways.)", "Ouran");
				 story.insertD("Welcome to the News at 8!", "Newscaster");
				 story.insertD("The famous businessman Keto Saiba’s younger brother Komuba has been found dead!", "Newscaster");
				 story.insertD("Keto himself has been arrested for the crime.", "Newscaster");
				 story.insertD("Not senpai Keto’s brother! Keto was a good opponent desu!", "Nekocchi");
				 story.insertD("Don’t scare me like that, Nekocchi.", "Ouran");
				 story.insertD("You have to take his case, Ouran!", "Nekocchi");
				 story.insertD("Fine, fine.", "Ouran");
				 story.insertR("Komuba Saiba", "komubaProfile", "The victim. Younger brother of Keto.", true, 10); //inserts profile
				 flags[0] = true; // sets that the entrance has played
			 }

			 story.playAni("Nekocchi","nekocchiWitness",1,false); // plays animation of Nekocchi
			 this.addQuestion(new Question(0, "Keto", true)); // adds questions
			 this.addQuestion(new Question(1, "What now?", true));
			 
			 block = false; // sets block to false so that this only happens once
		 }
	}
	
	@Override
	void update() { // updates location
		super.update(); // updates super
	}

	@Override
	void events(int i) { // runs events
		
		if (i==0) { // checks for maggot tank, runs dialogue
			story.insertD("The maggots are doing well. I have a suspicion that Nekocchi has started eating them...", "Ouran");
		}
		if (i==1) // checks for table, runs dialogue
		{
			story.insertD("My work table, where I practice forensics. The things that this table has seen...", "Ouran");
		}
		if (i == 2) // checks for plant, runs dialogue
		{
			story.insertD("My testing plant. It’s grown roots on its stem.", "Ouran");
		}
		if (i==3) // checks for cabinet, runs dialogue
		{
			story.insertD("Where I keep all of the files from my cases. Depressingly empty." , "Ouran");
			story.insertD("Maybe I shouldn’t have bought such a big cabinet...", "Ouran");
		}
		
	}

	@Override
	void talk(int i) { // runs talking to people
		this.getQuestionId(i).asked=true; // sets question to asked
		if (i==0) // checks topic
		{
			//plays dialogue
			story.insertD("Remember Keto, Ouran-kun?", "Nekocchi");
			story.insertD("His dragons beat my kawaii Fairilees in one shot, desu!", "Nekocchi");
			story.insertD("You have to defend him!", "Nekocchi");
		}
		if (i == 1) // checks topic
		{
			//plays dialogue
			story.insertD("Get yourself involved!", "Nekocchi");
			story.insertD("Go to the Detention Centre and see the baka who arrested Keto!", "Nekocchi");
		}
			
		
	}
	private Question getQuestionId(int id) { // finds identification of question


		for (Question q: questions) { // runs through questions
			if (q.id==id) return q; // if the question is the one asked, return the question
		}
		
		return null; // return no question asked
		
	}
	@Override
	protected void present(RecordEntry recordEntry) // presents record entry
	{
		if (recordEntry.name.equals("Ouran's Attorney's Badge")) // checks for badge
		{
			//plays dialogue
			story.insertD("Yes, I know that you’re an attorney, Ouran-kun.", "Nekocchi");
		}
		else // checks for other record item
		{
			story.insertD("Why are you showing me that, Ouran? I’m just a baka little neko, desu...", "Nekocchi"); //plays dialogue
		}
	}
}