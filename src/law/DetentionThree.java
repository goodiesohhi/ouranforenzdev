package law; // selects package

import java.io.IOException; // imports IOException

public class DetentionThree extends Location {// opens class
	StoryManager story = Main.currentCase; // holds current case
	public DetentionThree() // opens constructor
	{
		super("Detention center",201); // creates detention centre
	}
	void enter () throws IOException { // enters location
		super.enter(); // enters super

		this.addEvent((new ClickEvent(false,"wall", 0, 0, 1024, 768, this.clickEvents, 0))); // creates click-event
		 if (!flags[1]){ // checks if area has been entered

			
		
			 story.insertData("Detention Centre"); // plays opening
			 story.insertData("August 10");
			 story.insertData("8:10 PM");
			 story.playAni("Det. Pat. Bluthund","bluthundWitness",1,false); // plays animation
			 story.insertD("Forenz! What are you doing here with your annoying cat?", "Det. Pat. Bluthund"); //plays dialogue
			 story.insertD("Hey, thatâ€™s not nice, Bluthund-san!", "Nekocchi");
			 story.insertD("Iâ€™m here to see the accused for the Saiba case.", "Ouran");
			 story.insertD("Alright, keep your hair on. Follow me.", "Det. Pat. Bluthund");
			 Main.currentCase.clearSprites(); // clears sprite
			 story.playAni("Keto Saiba", "ketoWitness", 1, false); // plays animation
			 story.insertR("Keto Saiba", "ketoProfile", "The accused. Spends his time playing card games.", true, 6); //inserts profile to record
			 story.insertD("Youâ€™re an attorney?", "Keto"); // plays dialogue
			 story.insertD("Yes, Iâ€™m here to help you. May I defend you?", "Ouran");
			 story.insertD("Sure, why not? I trust your card-playing companion.", "Keto");
			 story.insertD("Did you hear that, Ouran-chan?", "Nekocchi");
			 
			 flags[1] = true; // sets area to already entered
			 
		 }
		 story.playAni("Keto Saiba", "ketoWitness", 1, false); // plays sprite
		 this.addQuestion(new Question(0, "You", true)); // adds questions
		 this.addQuestion(new Question(1, "Komuba's death", true));
		 this.addQuestion(new Question(2, "Saiba Corp.", false));
		 this.addQuestion(new Question (3, "White-Eyes Blue Dragon", false));
	}
	@Override
	void update() { // updates location
		super.update(); // updates super
	}

	@Override
	void events(int i) { // runs events
		
		if (i==0) { // checks if the wall was chosen
			story.insertD("Just a grey wall. Itâ€™s a prison, so itâ€™s what youâ€™d expect.", "Ouran"); // plays dialogue
		}
		
	}

	@Override
	void talk(int i) { // runs talk
		this.getQuestionId(i).asked=true; // sets the question to asked
		if (i == 0) // checks which question was chosen
		{
			story.insertD("Iâ€™m the heir of the famous company Saiba Corp.", "Keto"); //plays dialogue
			story.insertD("Iâ€™ve been CEO for a few weeks, but Komuba was going to take over after my death.", "Keto");
			this.unlockQuestion(2); // unlocks new question
		}
		if (i == 1) // checks which question was chosen
		{
			story.insertD("He was burnt by my replica White-Eyes Blue Dragon.", "Keto"); // plays dialogue
			story.insertD("I see how they think it was me, but it couldnâ€™t be!", "Keto");
			story.insertD("I would never kill my own brother in such an unstylish way!", "Keto");
			this.unlockQuestion(3); // unlocks new question
		}
		if (i == 2) // checks which question was chosen
		{
			story.insertD("Itâ€™s the company that my father built from the ground up.", "Keto"); //plays dialogue
			story.insertD("Now, it's the top card game company in the world.", "Keto");
			story.insertD("I took over a few years ago. We did have a problem with the media a while back, though...", "Keto");
			story.insertD("Here, take a copy of this article.", "Keto");
			story.insertR("Saiba Corp. Article", "article", "UNETHICAL BUSINESS PRACTICES REVEALED", false, 1); // inserts article into record
			story.insertData("Saiba Corp. Article added to Court Record.");
		}
		if (i == 3) // checks which question was chosen
		{
			story.insertD("Itâ€™s the greatest card in the game!", "Keto"); // plays dialogue
			story.insertD("There are only 100 in the world, and I own 99 of them.", "Keto");
			story.insertD("You should take one if youâ€™re going to be defending me.", "Keto");
			story.insertD("Otherwise, they might shred my collection...", "Keto");
			story.insertR("White-Eyes Blue Dragon", "webd", "This is Ketoâ€™s favourite card in the Saiba OCG.", false, 7); //inserts card into record
			story.insertData("White-Eyes Blue Dragon added to Court Record.");
		}
	}
	private Question getQuestionId(int id) { // finds which question was asked


		for (Question q: questions) { // runs through questions
			if (q.id==id) return q; // if the question was asked, return the question
		}
		
		return null; // if no question was asked, return nothing
		
	}
	@Override
	protected void present(RecordEntry recordEntry) // presents evidence
	{
		if(recordEntry.name.equals("Ouran's Attorney's Badge")) // checks if the badge was presented
		{
			story.insertD("Thank you for taking my case, Mr. Forenz!", "Keto"); // plays dialogue
		}
		else if (recordEntry.name.equals("Saiba Corp. Article")) // checks if the article was presented
		{
			story.insertD("So what are these â€œunethical business practices?â€�", "Ouran"); // plays dialogue
			story.insertD("Some have been complaining about the conditions of the workers in our factories.", "Keto");
			story.insertD("Trading card games have a small margin, you know!", "Keto");
			story.insertD("I hear Ms. Ord was going to be working on solving that...", "Keto");
			story.insertD("You should go see her at our offices.", "Keto");
			story.insertD("Maybe I will...", "Ouran");
			story.locales[0].linkPath(story.locales[2]); // adds new location
		}
		else if (recordEntry.name.equals("White-Eyes Blue Dragon")) // checks if the dragon was presented
		{
			story.insertD("Itâ€™s the lynchpin card in my deck.", "Keto"); // plays dialogue
			story.insertD("Its power level is greater than that of any other plain card in the game.", "Keto");
			story.insertD("I have strategies that can stop any attempts to destroy it.", "Keto");
			story.insertD("Itâ€™s the main reason why Iâ€™m the champion.", "Keto");
			story.insertD("Heâ€™s sugoi amazing, desu!", "Nekocchi");
			story.insertD("(If he owns all the copies of the best card, then whatâ€™s the point of even competing?)", "Ouran");
			story.insertD("(Heâ€™s just going to pay out the money to himself!)", "Ouran");
		}
		else // checks if anything else was presented
		{
			story.insertD("I donâ€™t think Iâ€™m aware of anything about that. Sorry...", "Keto"); // plays dialogue
		}
	}
}
