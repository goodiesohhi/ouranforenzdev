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
		this.addEvent((new ClickEvent(false,"wall", 0, 0, 1024, 768, this.clickEvents, 0)));
		 if (!flags[0]){
			
		
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
			 
			 flags[0] = true;
			 
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
			story.insertD("It’s the company that my father built from the ground up to become one of the greatest card game companies in the world!", "Keto");
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
		
	}
}
