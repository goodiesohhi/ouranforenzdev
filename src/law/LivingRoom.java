package law;
import java.io.IOException;
public class LivingRoom extends Location{
	StoryManager story = Main.currentCase;
	int progression = 0;
	public LivingRoom()
	{
		super("Living Room", 66);
	}
	@Override
	void enter() throws IOException
	{
		super.enter();
		this.addEvent(new ClickEvent("body", 600, 400, 80, 60, this.clickEvents, 0));
		this.addEvent(new ClickEvent("uniform", 700, 350, 60, 50, this.clickEvents, 1));
		this.addEvent(new ClickEvent("tv", 50, 200, 150, 500, this.clickEvents, 2));
		this.addEvent(new ClickEvent("coffeeTable", 200, 500, 150, 50, this.clickEvents, 3));
		if (!flags[4])
		{
			story.insertD("Saiba Corp. Apartment Living Room", "");
			story.insertD("August 10", "");
			story.insertD("9:12 PM", "");
			story.insertD("This is where the murder happened, desu!", "Nekocchi");
			story.insertD("So it seems...", "Ouran");
			story.playAni("Det. Pat. Bluthund", "bluthundWitness", 1, false);
			story.insertD("Ouran! You’re on this case?", "Det. Pat. Bluthund");
			story.insertD("Yes. We just saw you, remember?", "Ouran");
			story.insertD("Oh. Right.", "Det. Pat. Bluthund");
			story.insertD("Well, then, take your time and examine the scene of the crime.", "Det. Pat. Bluthund");
			flags[4] = true;
			this.addQuestion(new Question(0, "The Crime", true));
			this.addQuestion(new Question(1, "The Scene", true));
			this.addQuestion(new Question(2, "Witnesses?", true));
			this.addQuestion(new Question(3, "Replica Dragon", true));
		}
	}
	@Override
	void update()
	{
		super.update();
		if (progression == 2)
		{
			story.locales[3].linkPath(story.locales[4]);
			progression++;
			story.insertD("Ouran! We’ve found the dragon! Follow me!", "Det. Pat. Bluthund");
		}
	}
	@Override
	void events (int i)
	{
		if (i == 0)
		{
			story.insertD("So this is Komuba... looks kind of small for his age.", "Ouran");
		}
		if (i == 1)
		{
			story.insertD("Strange... this doesn’t look a bit burnt.", "Ouran");
			story.insertD("Why did he take off his uniform?", "Ouran");
			story.insertR("Uniform", "uniform", "This uniform wasn’t burned a mite.", false, 12);
			progression++;
		}
		if (i == 2)
		{
			story.insertD("I’m pretty sure 10 of my TV could fit on that screen...", "Ouran");
		}
		if (i == 3)
		{
			story.insertD("The richer you are, the lower to the ground your coffee table is.", "Ouran");
			story.insertD("It definitely holds true here.", "Ouran");
		}
	}
	@Override
	void talk (int i)
	{
		this.getQuestionId(i).asked=true;
		if (i == 0)
		{
			story.insertD("It appears that Komuba was burnt.", "Det. Pat. Bluthund");
			story.insertD("We have his autopsy report here if you want to take a look.", "Det. Pat. Bluthund");
			story.insertR("Autopsy Report","autopsyReport", "Died due to septicaemia after severe burns", false, 13);
			progression++;
		}
		if (i == 1)
		{
			story.insertD("The body does not appear to have been moved.", "Det. Pat. Bluthund");
			story.insertD("Therefore, it seems like the crime took place here.", "Det. Pat. Bluthund");
		}
		if (i == 2)
		{
			story.insertD("As of yet, we do not have any witnesses.", "Det. Pat. Bluthund");
			story.insertD("Maybe we’ll ask around later.", "Det. Pat. Bluthund");
		}
		if (i == 3)
		{
			story.insertD("Yeah, I heard about that.", "Det. Pat. Bluthund");
			story.insertD("We’re trying to locate the replica dragon as we speak.", "Det. Pat. Bluthund");
			story.insertD("My guess is it’ll turn up in the next half-hour.", "Det. Pat. Bluthund");
			story.insertD("Hard to move such a large model.", "Det. Pat. Bluthund");
		}
	}
	private Question getQuestionId(int id)
	{
		for (Question q: questions) {
			if (q.id==id) return q;
		}
		
		return null;
	}
	@Override
	protected void present (RecordEntry recordEntry)
	{
		if(recordEntry.name.equals("Ouran's Attorney's Badge"))
		{
			story.insertD("Why do attorneys get a badge, anyways?", "Det. Pat. Bluthund");
			story.insertD("They aren’t detectives...", "Det. Pat. Bluthund");
		}
		else if (recordEntry.name.equals("White-Eyes Blue Dragon"))
		{
			story.insertD("It’s the dragon! You have one?", "Det. Pat. Bluthund");
			story.insertD("I’ll trade you my entire collection!", "Det. Pat. Bluthund");
			story.insertD("(Bluthund plays card games too?)", "Ouran");
		}
		else
		{
			story.insertD("I don’t think I’m authorized to talk about that.", "Det. Pat. Bluthund");
		}
	}
	
}
