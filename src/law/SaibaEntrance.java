/**
 * 
 */
package law;
import java.io.IOException;

public class SaibaEntrance extends Location {
	
	StoryManager story = Main.currentCase;
	int progression = 0;
	public SaibaEntrance()
	{
		super("Saiba Entrance", 62);
		
	}
	@Override
	void enter() throws IOException
	{
		super.enter();
		this.addEvent((new ClickEvent(false,"stairs", 300, 0, 300, 500, this.clickEvents, 0)));
		this.addEvent((new ClickEvent(false,"elevator", 700, 0, 300, 500, this.clickEvents, 1)));
		this.addEvent((new ClickEvent(false,"receptionDesk", 500, 550, 300, 50, this.clickEvents, 2)));
		this.addEvent((new ClickEvent(false,"tracks", 200, 600, 100, 50, this.clickEvents, 3)));
		if (!flags[2])
		{
			story.insertD("Saiba Corp. Entrance", "");
			story.insertD("August 10", "");
			story.insertD("9:00 PM", "");
			story.playAni("Susan Ord", "susanWitness", 1, false);
			story.insertD("We’re finally here.", "Ouran");
			story.insertD("Isn’t this where the murder took place, desu?", "Nekocchi");
			story.insertD("Hello. Are you a detective?", "Susan");
			story.insertD("No, ma’am. I’m Keto’s defence attorney, Ouran Forenz.", "Ouran");
			story.insertD("And you are?", "Nekocchi");
			story.insertD("My name’s Susan Ord.", "Susan");
			story.insertR("Susan Ord", "susanProfile", "Head of the Saiba Corp. board.", true, 9);
			story.insertD("I’m the head of the board of directors here at Saiba Corp.", "Susan");
			story.insertD("If you have any questions, I’ll be happy to help.", "Susan");
			this.addQuestion(new Question(0, "Keto", true));
			this.addQuestion(new Question(1, "Komuba", true));
			this.addQuestion(new Question(2, "The investigation", true));
			this.addQuestion(new Question(3, "White-Eyes Blue Dragon", false));
			flags[2] = true;
		}
	}
	
	@Override
	void update()
	{
		super.update();
		if (progression == 2)
		{
			story.locales[2].linkPath(story.locales[3]);
			progression++;
		}
	}
	
	@Override
	void events (int i)
	{
		if (i == 0)
		{
			story.insertD("It spirals up and up for stories. I sort of want to climb it...", "Ouran");
		}
		if (i == 1)
		{
			story.insertD("For people who don’t want to spend hours on the stairs.", "Ouran");
		}
		if (i == 2)
		{
			story.insertD("The receptionist has gone home.", "Ouran");
			story.insertD("I guess it is pretty late at night for her to stay...", "Susan");
		}
		if (i == 3)
		{
			story.insertD("Those tracks look suspicious...", "Ouran");
			story.insertR("Tracks", "tracks", "Tracks similar to those on a motorbike.", true, 8);
		}
	}

	@Override
	void talk (int i)
	{
		this.getQuestionId(i).asked=true;
		if (i == 0)
		{
			story.insertD("Keto was a good and reliable CEO.", "Susan");
			story.insertD("Sure, he had his weird card game obsession.", "Susan");
			story.insertD("But he was always focused on the business first and foremost.", "Susan");
			story.insertD("I’ll help you as much as I can.", "Susan");
			story.insertD("I only want to ensure he can get back to work as soon as possible.", "Susan");
		}
		if (i == 1)
		{
			story.insertD("Komuba... I honestly couldn’t stand that kid.", "Susan");
			story.insertD("To tell the truth, I won’t miss him that much.", "Susan");
			story.insertD("He was always meddling around in our plans.", "Susan");
		}
		if (i == 2)
		{
			story.insertD("The police have been meddling around here for the past hour.", "Susan");
			story.insertD("Hopefully they’ll leave soon so I can go home...", "Susan");
		}
		if (i == 3)
		{
			story.insertD("How could he be killed by a White-Eyes Blue Dragon?", "Ouran");
			story.insertD("It appears to be Keto’s replica dragon. That’s why Keto was implicated in the case.", "Susan");
			story.insertD("I suppose you want to see the crime scene now.", "Susan");
			story.insertD("Nya... nya, nya!", "Nekocchi");
			story.insertD("...OK", "Susan");
			story.insertD("Proceed up the stairs or the elevator to the Saiba family’s apartment.", "Susan");
			story.insertD("(They have an apartment in their office? Talk about dedicated...)", "Ouran");
			progression++;
			
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
			story.insertD("I think that I am clear about you being an attorney, Mr. Forenz.", "Susan");
		}
		else if (recordEntry.name.equals("Saiba Corp. Article"))
		{
			story.insertD("Ah. That article.", "Susan");
			story.insertD("We have been working hard to improve conditions in our factories.", "Susan");
			story.insertD("Soon our workers will see the fruits of our labours.", "Susan");
			story.insertD("(It doesn’t seem like she has much to say...)", "Ouran");
		}
		else if (recordEntry.name.equals("White-Eyes Blue Dragon"))
		{
			story.insertD("What are you doing with that? After what happened?", "Susan");
			story.insertD("What?", "Ouran");
			story.insertD("Komuba was killed... by a White-Eyes Blue Dragon!", "Susan");
			story.insertD("OwO", "Nekocchi");
			this.unlockQuestion(3);
		}
	}
}
