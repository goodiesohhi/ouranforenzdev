package law;
import java.io.IOException;
public class ForenzOffice extends Location {
	boolean block;
	StoryManager story = Main.currentCase;
	public ForenzOffice() {
		 super("Forenz Law Office",55);
		 block=true;
	}
	@Override
	void enter() throws IOException {
		super.enter();
		this.addEvent((new ClickEvent(false,"maggotTank", 300, 100, 300, 100, this.clickEvents, 0)));
		this.addEvent((new ClickEvent(false,"workTable", 250, 300, 400, 350, this.clickEvents, 1)));
		this.addEvent((new ClickEvent(false,"chemicalPlant", 900, 100, 50, 50, this.clickEvents, 2)));
		this.addEvent((new ClickEvent(false,"filingCabinet", 850, 150, 100, 300, this.clickEvents, 3)));
		block = true;
		 if (block){
			 if (!flags[0])
			 {
				story.insertD("Forenz Office", "");
				 story.insertD("August 10", "");
				 story.insertD("8:00 PM", "");
				 story.insertD("(It’s the end of a long day doing nothing.)", "Ouran");
				 story.insertD("(I better check the news, since this is how I normally find clients anyways.)", "Ouran");
				 story.insertD("Welcome to the News at 8!", "Newscaster");
				 story.insertD("The famous businessman Keto Saiba’s younger brother Komuba has been found dead!", "Newscaster");
				 story.insertD("Keto himself has been arrested for the crime.", "Newscaster");
				 story.insertD("Not senpai Keto’s brother! Keto was a good opponent desu!", "Nekocchi");
				 story.insertD("Don’t scare me like that, Nekocchi.", "Ouran");
				 story.insertD("You have to take his case, Ouran!", "Nekocchi");
				 story.insertD("Fine, fine.", "Ouran");
				 story.insertR("Komuba Saiba", "komubaProfile", "The victim. Younger brother of Keto.", true, 10);
				 flags[0] = true;
			 }

			 story.playAni("Nekocchi","nekocchiWitness",1,false);
			 this.addQuestion(new Question(0, "Keto", true));
			 this.addQuestion(new Question(1, "What now?", true));
			 
			 block = false;
		 }
	}
	
	@Override
	void update() {
		super.update();
	}

	@Override
	void events(int i) {
		
		if (i==0) {
			story.insertD("The maggots are doing well. I have a suspicion that Nekocchi has started eating them...", "Ouran");
		}
		if (i==1)
		{
			story.insertD("My work table, where I practice forensics. The things that this table has seen...", "Ouran");
		}
		if (i == 2)
		{
			story.insertD("My testing plant. It’s grown roots on its stem.", "Ouran");
		}
		if (i==3)
		{
			story.insertD("Where I keep all of the files from my cases. Depressingly empty." , "Ouran");
			story.insertD("Maybe I shouldn’t have bought such a big cabinet...", "Ouran");
		}
		
	}

	@Override
	void talk(int i) {
		this.getQuestionId(i).asked=true;
		if (i==0)
		{
			story.insertD("Remember Keto, Ouran-kun?", "Nekocchi");
			story.insertD("His dragons beat my kawaii Fairilees in one shot, desu!", "Nekocchi");
			story.insertD("You have to defend him!", "Nekocchi");
		}
		if (i == 1)
		{
			story.insertD("Get yourself involved!", "Nekocchi");
			story.insertD("Go to the Detention Centre and see the baka who arrested Keto!", "Nekocchi");
		}
			
		
	}
	private Question getQuestionId(int id) {


		for (Question q: questions) {
			if (q.id==id) return q;
		}
		
		return null;
		
	}
	@Override
	protected void present(RecordEntry recordEntry)
	{
		if (recordEntry.name.equals("Ouran's Attorney's Badge"))
		{
			story.insertD("Yes, I know that you’re an attorney, Ouran-kun.", "Nekocchi");
		}
		else
		{
			story.insertD("Why are you showing me that, Ouran? I’m just a baka little neko, desu...", "Nekocchi");
		}
	}
}