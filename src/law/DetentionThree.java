package law;

import java.io.IOException;

public class DetentionThree extends Location {
	StoryManager story = Main.currentCase;
	public DetentionThree()
	{
		super("Detention center",201);
	}
	void enter () throws IOException {
		super.enter();
		this.addEvent((new ClickEvent("wall", 0, 0, 1024, 768, this.clickEvents, 0)));
		 if (!flags[1]){
			
		
			 story.insertD("Detention Centre", "");
			 story.insertD("August 10", "");
			 story.insertD("8:10 PM", "");
			 story.playAni("Det. Pat. Bluthund","bluthundWitness",1,false);
			 story.insertD("Forenz! What are you doing here with your annoying cat?", "Det. Pat. Bluthund");
			 story.insertD("Hey, that’s not nice, Bluthund-san!", "Nekocchi");
			 story.insertD("I’m here to see the accused for the Saiba case.", "Ouran");
			 story.insertD("Alright, keep your hair on. Follow me.", "Det. Pat. Bluthund");
			 Main.currentCase.clearSprites();
			 story.playAni("Keto Saiba", "ketoWitness", 1, false);
			 story.insertR("Keto Saiba", "ketoProfile", "The accused. Spends his time playing card games.", true, 6);
			 story.insertD("You’re an attorney?", "Keto");
			 story.insertD("Yes, I’m here to help you. May I defend you?", "Ouran");
			 story.insertD("Sure, why not? I trust your card-playing companion.", "Keto");
			 story.insertD("Did you hear that, Ouran-chan?", "Nekocchi");
			 
			 flags[1] = true;
			 
		 }
		 story.playAni("Keto Saiba", "ketoWitness", 1, false);
		 this.addQuestion(new Question(0, "You", true));
		 this.addQuestion(new Question(1, "Komuba's death", true));
		 this.addQuestion(new Question(2, "Saiba Corp.", false));
		 this.addQuestion(new Question (3, "White-Eyes Blue Dragon", false));
	}
	@Override
	void update() {
		super.update();
	}

	@Override
	void events(int i) {
		
		if (i==0) {
			story.insertD("Just a grey wall. It’s a prison, so it’s what you’d expect.", "Ouran");
		}
		
	}

	@Override
	void talk(int i) {
		this.getQuestionId(i).asked=true;
		if (i == 0)
		{
			story.insertD("I’m the heir of the famous company Saiba Corp.", "Keto");
			story.insertD("I’ve been CEO for a few weeks, but Komuba was going to take over after my death.", "Keto");
			this.unlockQuestion(2);
		}
		if (i == 1)
		{
			story.insertD("He was burnt by my replica White-Eyes Blue Dragon.", "Keto");
			story.insertD("I see how they think it was me, but it couldn’t be!", "Keto");
			story.insertD("I would never kill my own brother in such an unstylish way!", "Keto");
			this.unlockQuestion(3);
		}
		if (i == 2)
		{
			story.insertD("It’s the company that my father built from the ground up.", "Keto");
			story.insertD("Now, it's the top card game company in the world.", "Keto");
			story.insertD("I took over a few years ago. We did have a problem with the media a while back, though...", "Keto");
			story.insertD("Here, take a copy of this article.", "Keto");
			story.insertR("Saiba Corp. Article", "article", "UNETHICAL BUSINESS PRACTICES REVEALED", false, 1);
		}
		if (i == 3)
		{
			story.insertD("It’s the greatest card in the game!", "Keto");
			story.insertD("There are only 100 in the world, and I own 99 of them.", "Keto");
			story.insertD("You should take one if you’re going to be defending me.", "Keto");
			story.insertD("Otherwise, they might shred my collection...", "Keto");
			story.insertR("White-Eyes Blue Dragon", "webd", "This is Keto’s favourite card in the Saiba OCG.", false, 7);
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
		if(recordEntry.name.equals("Ouran's Attorney's Badge"))
		{
			story.insertD("Thank you for taking my case, Mr. Forenz!", "Keto");
		}
		else if (recordEntry.name.equals("Saiba Corp. Article"))
		{
			story.insertD("So what are these “unethical business practices?”", "Ouran");
			story.insertD("Some have been complaining about the conditions of the workers in our factories.", "Keto");
			story.insertD("Trading card games have a small margin, you know!", "Keto");
			story.insertD("I hear Ms. Ord was going to be working on solving that...", "Keto");
			story.insertD("You should go see her at our offices.", "Keto");
			story.insertD("Maybe I will...", "Ouran");
			story.locales[0].linkPath(story.locales[2]);
		}
		else if (recordEntry.name.equals("White-Eyes Blue Dragon"))
		{
			story.insertD("It’s the lynchpin card in my deck.", "Keto");
			story.insertD("Its power level is greater than that of any other plain card in the game.", "Keto");
			story.insertD("I have strategies that can stop any attempts to destroy it.", "Keto");
			story.insertD("It’s the main reason why I’m the champion.", "Keto");
			story.insertD("He’s sugoi amazing, desu!", "Nekocchi");
			story.insertD("(If he owns all the copies of the best card, then what’s the point of even holding competitions?)", "Ouran");
			story.insertD("(He’s just going to pay out the money to himself!)", "Ouran");
		}
		else
		{
			story.insertD("I don’t think I’m aware of anything about that. Sorry...", "Keto");
		}
	}
}
