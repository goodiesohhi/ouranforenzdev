package law; // selects package

import java.io.IOException; // imports IOException

class Case3 extends StoryManager  { // opens main class

    int currentArea = 0; // sets current area
    
    Case3() throws IOException // opens constructor
    {
    	
        super(3,"Turnabout Deception"); // calls constructor of Location
        this.currentProsecutor="Adrasteia Rhamnousia";
    }
    void update() throws IOException // runs update loop
    {
        characters.add(new Character("Nekocchi", 280, 0)); //adds Nekocchi
        characters.add(new Character ("Det. Pat. Bluthund", 150, 0)); // adds Bluthund
        characters.add(new Character("Keto Saiba", 200, 0)); // adds Keto
        characters.add(new Character("Susan Ord", 250, 0)); // adds Susan
        characters.add(new Character("Ouran Forenz", 200, 0)); // adds Ouran
        this.getCharacter("Det. Pat. Bluthund").animList.add(new AnimData("Det. Pat. Bluthund", "bluthundWitness",0,false)); // adds animation
        this.getCharacter("Susan Ord").animList.add(new AnimData("Susan Ord", "susanWitness", 0, false)); // adds animation
    	if (flags[25] == false && !oneProc) // checks if investigation has run and that one segment gets added to the event queue
    	{
    		oneProc = true; // makes sure that only one segment gets added to the event queue
    		flags[24] = true; // sets the flag to true
    		inCourt = true; // sets the game to be in court
    		startCExamine(0); // starts first cross-examination
    		// lists statements
    		Main.cExamine[Main.examineSlot].add("The defendant, Keto Saiba, lives with his brother.", "Det. Pat. Bluthund",  new String[] {"So they live together?","Yes, Mr. Forenz.","Alright, if you say so...", "That isn’t too hard to believe when you consider you live with that cat thing.", "(Ugh... he has a point.)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund", "Ouran Forenz"} , 0, (String)null , "bluthundWitness",0);
   		 	Main.cExamine[Main.examineSlot].add("He has a working flamethrower kept in the apartment.", "Det. Pat. Bluthund",  new String[] {"You have proof that the flamethrower was working?","Keto always kept it fuelled.","That was the first thing he did when he woke up.", "Alright, if you say so. (His obsession is rampant.)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund", "Ouran Forenz"} , 0, (String)null,(String)null,0);
   		 	Main.cExamine[Main.examineSlot].add("The brother was killed in the very same apartment!", "Det. Pat. Bluthund",  new String[] {"I’m sorry, you say the same apartment?","Yeah. You were there, weren’t you?","Weren’t you, Ouran-san?", "Was I?"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Nekocchi", "Ouran Forenz"} , 2, "Dragon Model",(String)null,0);
   		 	Main.cExamine[Main.examineSlot].add("Not only that, he died due to severe burns.", "Det. Pat. Bluthund",  new String[] {"The autopsy report says that the victim died from septicemia.","That isn’t burns! Objection, nya!","Actually, septicemia is the cause of death after burns...","Nekocchi, be quiet!"} ,  new String[] {"Ouran Forenz","Nekocchi","Det. Pat. Bluthund","Ouran Forenz"} , 0, (String)null,(String)null,0);
   		 	Main.cExamine[Main.examineSlot].add("Therefore, it’s clear that the cause of death was Keto’s flamethrower.", "Det. Pat. Bluthund",  new String[] {"Couldn’t there be another cause of death?","Can you provide any?","(I don’t think I can. At least, not yet...)"} ,  new String[] {"Ouran Forenz","Adrasteia","Ouran Forenz"} , 0, (String)null,(String)null,0);
   		 	stopCExamine(); // stops first cross-examination
   		 	startCExamine(1); // starts second cross-examination
   		 	// lists statements
		 	Main.cExamine[Main.examineSlot].add("I was staying late at work, as I always do on a Friday night.", "Susan Ord",  new String[] {"You stay late on Fridays?","Doesn’t everybody?","I stay late in order to ensure that justice reaches everyone!", "Am I the only one who goes home early on Fridays?"} ,  new String[] {"Ouran Forenz","Susan","Adrasteia", "Ouran Forenz"} , 0, (String)null , "susanWitness",0);
		 	Main.cExamine[Main.examineSlot].add("I had stepped out to have a cigarette on my break.", "Susan Ord",  new String[] {"How long are your smoking breaks?","10 minutes, on the dot.","(I don’t think I’ve ever done anything on the dot.)"} ,  new String[] {"Ouran Forenz","Susan", "Ouran Forenz"} , 0, (String)null,(String)null,0);
		 	Main.cExamine[Main.examineSlot].add("I saw a bright light from the top floor window!", "Susan Ord",  new String[] {"Nani? That’s probably when Komuba died, desu!","I am well aware. That was probably when he caught fire.","Yes, that’s my assumption.", "Back to what happened!"} ,  new String[] {"Nekocchi","Ouran Forenz","Susan", "Adrasteia"} , 0, (String)null ,(String)null,0);
		 	Main.cExamine[Main.examineSlot].add("I raced up the stairs and saw the dead body.", "Susan Ord",  new String[] {"So you say you saw Komuba dead?","I did. As far as my knowledge goes, I was the first to see the body besides the killer.","How fast did you get there, do you think?","I think under five minutes."} ,  new String[] {"Ouran Forenz","Susan","Ouran Forenz","Susan"} , 0, (String)null,(String)null,0);
		 	Main.cExamine[Main.examineSlot].add("Nobody passed me on the stairs.", "Susan Ord",  new String[] {"Is that the only set of stairs in the building?","We have some stairs in the back, but they don’t go all the way up to the penthouse.","Those are the only stairs that lead to the penthouse.", "Hmm... Only stairs..."} ,  new String[] {"Ouran Forenz","Susan", "Susan","Ouran Forenz"} , 2, "Elevator and Stairs",(String)null,0);
		 	Main.cExamine[Main.examineSlot].add("Only Keto was in the apartment at the time.", "Susan Ord", new String[] {"How can you be sure that he was the only one in the apartment?", "Once I came in, I stayed at the door and called the police.", "Keto and I watched each other the whole time at the entrance.", "Nobody came out until the police arrived.", "Seems factual enough!"}, new String[] {"Ouran, Susan, Susan, Susan, Adrasteia"}, 0, (String)null, (String)null, 0);
		 	stopCExamine(); // ends second cross-examination
		 	startCExamine(2); // starts third cross-examination
		 	// lists statements
		 	Main.cExamine[Main.examineSlot].add("Keto has to be innocent!", "Susan Ord",  new String[] {"You may have hope there.","Keto is innocent until proven guilty, after all.","Please. I knew he was guilty the moment I set eyes on him!", "Doko are her eyes?", "I have no clue."} ,  new String[] {"Ouran Forenz","Ouran Forenz","Adrasteia", "Nekocchi", "Ouran Forenz"} , 0, (String)null , "susanWitness",0);
		 	Main.cExamine[Main.examineSlot].add("That dragon was huge, I saw it!", "Susan Ord",  new String[] {"When did you see the dragon?","I saw it when Keto first unveiled it, three years ago.","It was to commemorate the printing of the 100th White-Eyes Blue Dragon.", "It was a couple months ago. Keto had just printed the card.","He unveiled the model at the company Christmas party." } ,  new String[] {"Ouran Forenz","Susan", "Susan", "Susan", "Susan"} , 0, (String)null,(String)null,0);
		 	Main.cExamine[Main.examineSlot].add("There’s no way he could have moved it back to storage by the time I ran up the stairs.", "Susan Ord",  new String[] {},  new String[] {} , 1, (String)null ,(String)null,0);
		 	Main.cExamine[Main.examineSlot].add("It took me under five minutes to reach the penthouse! It would be impossible.", "Susan Ord",  new String[] {"It took you that long, Susan-san?","Those stairs are long, OK? It takes a while.","I have the company record for the fastest time to run up the stairs.","I once did it in 3 minutes, 38 seconds.", "Must be a strange company if they have a record for that..."} ,  new String[] {"Nekocchi","Ouran Forenz","Susan","Susan","Ouran Forenz"} , 0, (String)null,(String)null,0);
		 	stopCExamine(); // ends third cross-examination
		 	startCExamine(3);// starts fourth cross-examination
		 	// lists statements
		 	Main.cExamine[Main.examineSlot].add("Keto runs Saiba Corp. right now, but some board members prefer Komuba.", "Susan Ord",  new String[] {"Are you among the group that prefers Komuba?","No. I, personally, prefer Keto.","I think that he’s smart and he runs the business well and...", "(This could go on a while.)", "He's really kind, too!", "For all those reasons, I think he does a better job of running the business."} ,  new String[] {"Ouran Forenz","Susan","Susan", "Ouran Forenz", "Susan", "Susan"} , 1, (String)null , "susanWitness",0);
		 	Main.cExamine[Main.examineSlot].add("Komuba announced that he planned to take over a while ago.", "Susan Ord",  new String[] {"When did Komuba announce this?","It was at last quarter’s board meeting.","He planned to take over a few weeks from now, at the next board meeting.", "But then Komuba-kun was killed!"} ,  new String[] {"Ouran Forenz","Susan", "Susan", "Nekocchi"} , 1, (String)null,(String)null,0);
		 	Main.cExamine[Main.examineSlot].add("Since then, there’s been some tension between Keto and Komuba.", "Susan Ord",  new String[] {"And could this tension possibly have resulted in a murder?", "Objection!", "Sustained. Please refrain from leading comments, Adrasteia.", "Did the tension lead to more metaphorical distance between these two?", "I believe it could have, yes."},  new String[] {"Adrasteia", "Ouran Forenz", "Judge Judge", "Ouran Forenz", "Susan"} , 1, (String)null ,(String)null,0);
		 	Main.cExamine[Main.examineSlot].add("Maybe that could be a possible motive?", "Susan Ord",  new String[] {"So you’re saying either Keto or one of his supporters could have killed Komuba.","It’s very possible, yes.","It was well-known that the two brothers had some friction."} ,  new String[] {"Ouran Forenz","Susan","Susan"} , 1, (String)null,(String)null,0);
		 	stopCExamine(); // ends fourth cross-examination
		 	startCExamine(4); // opens question block
		 	// lists questions
		 	Main.cExamine[Main.examineSlot].add("Susan Ord?", "Ouran Forenz", new String[] {"I think it was Susan Ord!"}, new String[] {"Ouran Forenz"}, 1, (String)null, (String)null, 0);
		 	Main.cExamine[Main.examineSlot].add("White-Eyes Blue Dragon?", "Ouran Forenz", new String[] {"I think it was White-Eyes Blue Dragon!", "There’s one copy that Keto doesn’t own!", "Perhaps it escaped and took revenge against the Saiba family.", "I think that's a hair-brained idea.", "I concur."}, new String[] {"Ouran Forenz", "Ouran Forenz", "Ouran Forenz", "Adrasteia", "Judge Judge"}, 0, (String)null, (String)null, 0);
		 	Main.cExamine[Main.examineSlot].add("Komuba himself?", "Ouran Forenz", new String[] {"I think it was a suicide!", "Komuba killed himself because of the pressure to perform.", "Really? He was the one who suggested that he run the company.", "Oh, right..."}, new String[] {"Ouran Forenz", "Ouran Forenz", "Adrasteia", "Ouran Forenz"}, 0, (String)null, (String)null, 0);
		 	stopCExamine(); // closes question block
		 	startCExamine(5); // starts fifth cross-examination
		 	// lists statements
		 	Main.cExamine[Main.examineSlot].add("We have automated security at Saiba Corp.", "Susan Ord", new String[] {"The security’s automated.", "I think we covered that already.", "When you slide your card it sounds like a dragon's roar.", "(Is Keto obsessed or what?)"}, new String[] {"Ouran Forenz", "Ouran Forenz", "Susan", "Ouran Forenz"}, 1, (String)null, "susanWitness", 0);
		 	Main.cExamine[Main.examineSlot].add("I scanned my pass when I entered the penthouse and the building.", "Susan Ord", new String[] {"When do you have to scan your pass?", "I have to scan it every time I enter a private room.", "I also scan it when I enter the building.", "A fair security system, I guess."}, new String[] {"Ouran Forenz", "Susan", "Susan", "Judge Judge"}, 1, (String)null, (String)null, 0);
		 	Main.cExamine[Main.examineSlot].add("I entered the penthouse 5 minutes after I came in from the terrace.", "Susan Ord", new String[] {"And this is on record somewhere, I guess?", "Yes, there should be a record in the Saiba Corp. offices.", "You can check it out any time you wish.", "You get to climb the stairs again, Ouran-san!"}, new String[] {"Ouran Forenz", "Susan", "Susan", "Nekocchi"}, 1, (String)null, (String)null, 0);
		 	Main.cExamine[Main.examineSlot].add("Therefore, I could not have committed the murder.", "Susan Ord", new String[] {"That’s a logical progression.", "Keto must have seen when you came in.", "As you can see, your client will reach justice soon.", "We can, but can you?", "... This is getting old fast."}, new String[] {"Ouran Forenz", "Ouran Forenz", "Adrasteia", "Susan", "Adrasteia"}, 1, (String)null, (String)null, 0);
		 	stopCExamine(); // ends fifth cross-examination
		 	//lists various lines of dialogue and view changes
    		/*insertD("Court is in session for the murder trial of Keto Saiba.", "Judge Judge");
    		insertD("Is the prosecution ready?", "Judge Judge");
    		insertV(2, "Adrasteia Rhamnousia");
    		insertD("The prosecution is prepared...", "Adrasteia");
    		insertD("to bring the defendant to justice, your Honour!", "Adrasteia");
    		insertV(4, (String)null);
    		insertD("She seems intense, nya~~", "Nekocchi");
    		insertV(0, "Judge Judge");
    		insertD("Very well... is the defence team ready?", "Judge Judge");
    		insertV(1, (String)null);
    		insertD("We are as prepared as we can get, your honour.", "Ouran");
    		insertV(0, "Judge Judge");
    		insertD("As it should be... proceed with your opening statements.", "Judge Judge");
    		insertV(2, "Adrasteia Rhamnousia");
    		insertD("The defendant, Keto Saiba, deserves to be brought to justice...", "Adrasteia");
    		insertD("...for the murder of his brother Komuba Saiba.", "Adrasteia");
    		insertD("The prosecution will show that Keto wilfully killed his brother.", "Adrasteia");
    		insertD("We will also show that he had motive to commit this crime.", "Adrasteia");
    		insertD("What is the defendant's plea?", "Adrasteia");
    		insertV(1, (String)null);
    		insertD("We plead not guilty.", "Ouran");
    		insertV(2, "Adrasteia Rhamnousia");
    		insertD("As you plea, so your fate is sealed.", "Adrasteia");
    		insertV(1, (String)null);
    		insertD("(She’s sticking to her formalities, I see...)", "Ouran");
    		insertV(0, "Judge Judge");
    		insertD("Defence, please give your opening statement.", "Judge Judge");
    		insertV(1, (String)null);
    		insertD("Keto Saiba did not murder his younger brother and business associate.", "Ouran");
    		insertD("There is no evidence to prove that he did commit the crime.", "Ouran");
    		insertD("There is nothing pinning him at the scene.", "Ouran");
    		insertD("Therefore, there is reasonable doubt as to his involvement in Komuba’s death.", "Ouran");
    		insertV(0, "Judge Judge");
    		insertD("Fair enough. Will the prosecution call their first witness?", "Judge Judge");
    		insertV(2, "Adrasteia Rhamnousia");
    		insertD("Your Honour, we call the Detective Patrick Bluthund to the stand.", "Adrasteia");
   		 	insertV(3, "Det. Pat. Bluthund");*/
   		 	runFirstExamine(0); // starts first cross-examination
   		 	insertV(1, (String)null);
   		 	insertD("You said it was in the same apartment?", "Ouran");
   		 	insertV(3, "Det. Pat. Bluthund");
   		 	insertD("Yes.", "Det. Pat. Bluthund");
   		 	insertV(1, (String)null);
   		 	insertD("But have you considered: how the dragon left the storage room?", "Ouran");
   		 	insertD("It’s obviously big and heavy!", "Ouran");
   		 	insertV(2, "Adrasteia Rhamnousia");
   		 	insertD("Now, now, there’s an easy explanation for that. The dragon has wheels!", "Adrasteia");
   		 	insertV(3, "Det. Pat. Bluthund");
   		 	insertD("Oh, yeah, the wheels! There are wheels on the bottom of the dragon.", "Det. Pat. Bluthund");
   		 	insertV(1, (String)null);
   		 	insertD("(I see Wheely has been found.)", "Ouran");
   		 	insertV(0, "Judge Judge");
   		 	insertD("Do you have any further objections with this testimony?", "Judge Judge");
   		 	insertV(1, (String)null);
   		 	insertD("No... no, I don’t think so.", "Ouran");
   		 	insertV(0, "Judge Judge");
   		 	insertD("Alright then. Will the prosecution call its next witness?", "Judge Judge");
   		 	insertV(2, "Adrasteia Rhamnousia");
   		 	insertD("We call Susan Ord to the stand.", "Adrasteia");
   		 	insertV(0, "Judge Judge");
   		 	insertD("Please state your name, age, and occupation to the court.", "Judge Judge");
   		 	insertV(3, "Susan Ord");
   		 	insertD("My name is Susan Ord, I’m 32 years of age, and I’m an executive at Saiba Corp.", "Susan");
   		 	insertV(1, (String)null);
   		 	insertD("Executive’s kind of vague, isn’t it?", "Ouran");
   		 	insertV(2, "Adrasteia Rhamnousia");
   		 	insertD("Objection! If that’s her job title, that’s what she should state.", "Adrasteia");
   		 	insertV(0, "Judge Judge");
   		 	insertD("Sustained. Please continue.", "Judge Judge");
   		 	insertV(3, "Susan Ord");
   		 	insertD("Thank you for having me.", "Susan Ord");
   		 	insertD("Hopefully I can help the true killer find justice.", "Susan Ord");
   		 	insertV(2, "Adrasteia Rhamnousia");
   		 	insertD("Hopefully you can.", "Adrasteia");
   		 	insertD("Now, may you please describe what you were doing when the murder took place?", "Adrasteia");
		 	insertV(3, "Susan Ord");
		 	runFirstExamine(1); // starts second cross-examination
		 	insertV(1, (String)null);
		 	insertD("Susan, you say that nobody passed you on the stairs.", "Ouran");
		 	insertV(3, "Susan Ord");
		 	insertD("Yes, that is what I said.", "Susan");
		 	insertV(1, (String)null);
		 	insertD("I had the pleasure of visiting the Saiba Corp. offices yesterday evening.", "Ouran");
		 	insertD("I noticed something about your building.", "Ouran");
		 	insertD("Specifically: you have an elevator!", "Ouran");
		 	insertV(4, (String)null);
		 	insertD("Nani?", "Nekocchi");
		 	insertV(3, "Susan Ord");
		 	insertD("Ghk!", "Susan");
		 	insertV(1, (String)null);
		 	insertD("Could somebody have been going down the elevator at that time?", "Ouran");
		 	insertV(3, "Susan Ord");
		 	insertD("I suppose... it is a possibility.", "Susan");
		 	insertV(2, "Adrasteia Rhamnousia");
		 	insertD("Shouldn’t there have been a guard at the entrance to the building?", "Adrasteia");
		 	insertV(3, "Susan Ord");
		 	insertD("No, it’s all automated security.", "Susan");
		 	insertD("What sort of place doesn’t have a security dog?", "Det. Pat. Bluthund");
		 	insertV(4, (String)null);
		 	insertD("So someone else could have been there, desu ka?", "Nekocchi");
		 	insertV(0, "Judge Judge");
		 	insertD("Yes, it appears so.", "Judge Judge");
		 	insertD("Does the witness wish to add anything else to her testimony?", "Judge Judge");
		 	insertV(3, "Susan Ord");
		 	insertD("Yes, I suppose I do wish to add to my testimony.", "Susan");
		 	insertV(1, (String)null);
		 	insertD("(This should be interesting...)", "Ouran");
		 	runFirstExamine(2); // starts third cross-examination
		 	insertV(1, (String)null);
		 	insertD("The storage place was a couple minutes walk from the crime scene.", "Ouran");
		 	insertD("I suppose I fail to see how he could have moved it.", "Ouran");
		 	insertV(2, "Adrasteia Rhamnousia");
		 	insertD("You don’t need to see! Let justice give you sight.", "Adrasteia");
		 	insertD("Did you examine the bottom of the dragon model, either of you?", "Adrasteia");
		 	insertV(3, "Susan Ord");
		 	insertD("No, I don’t suppose I did.", "Susan");
		 	insertD("If you had, you would realize that there were wheels on the bottom of the dragon.", "Adrasteia");
		 	insertR("Wheels", "wheels", "The dragon can move! Can't be seen normally.", false, 16);
		 	insertData("Wheels have been added to Court Record.");
		 	insertV(0, "Judge Judge");
		 	insertD("When you take that into account, the Dragon could easily have been moved.", "Judge Judge");
		 	insertV(1, (String)null);
		 	insertD("(Our case isn’t looking too good right now.)", "Ouran Forenz");
		 	insertV(0, "Judge Judge");
		 	insertD("Adrasteia, I believe you said that you would prove a motive?", "Judge Judge");
		 	insertV(2, "Adrasteia Rhamnousia");
		 	insertD("That I did. Susan...", "Adrasteia");
		 	insertD("Please talk about the boardroom dynamics at Saiba Corp.", "Adrasteia");
		 	insertV(3, "Susan Ord");
		 	insertD("I guess, if you want me to...", "Susan");
		 	runFirstExamine(3); // sets up fourth cross-examination
		 	insertV(0, "Judge Judge");
		 	insertD("Any further cross-examination, Mr. Forenz?", "Judge Judge");
		 	insertV(1, (String)null);
		 	insertD("Hmm... no thank you, your Honour.", "Ouran");
		 	insertV(0, "Judge Judge");
		 	insertD("Well, this seems very clear to me.", "Judge Judge");
		 	insertD("I'm willing to end this trial right here.", "Judge Judge");
		 	insertD("Unless, of course, you have any other ideas?", "Judge Judge");
		 	insertV(1, (String)null);
		 	insertD("Do I have any other ideas?", "Ouran");
		 	insertV(0, "Judge Judge");
		 	runExamine(4); // creates list of statements
		 	insertV(1, (String)null);
		 	insertD("She even has a motive!", "Ouran");
		 	insertV(3, "Susan Ord");
		 	insertD("I do?", "Susan");
		 	insertV(1, (String)null);
		 	insertD("You obviously loved Keto running the company.", "Ouran");
		 	insertD("Enough to kill to protect him, perhaps?", "Ouran");
		 	insertV(3, "Susan Ord");
		 	insertD("Urk!", "Susan");
		 	insertV(1, (String)null);
		 	insertD("Do you have an alibi?", "Ouran");
		 	insertV(0, "Judge Judge");
		 	insertD("Stop pestering the witness, Mr. Forenz!", "Judge Judge");
		 	insertV(4, (String)null);
		 	insertD("Stop pestering watakushi, nya~~!", "Nekocchi");
		 	insertV(0, "Judge Judge");
		 	insertD("You do have a point, though.", "Judge Judge");
		 	insertD("Do you wish to speak to an alibi, Ms. Ord?", "Judge Judge");
		 	insertV(3, "Susan Ord");
		 	insertD("Alright, I think I’m ready.", "Susan");
		 	insertD("Alright, I think I’m ready.", "Susan Ord");
		 	runFirstExamine(5); // sets up fifth cross-examination
		 	insertV(1, (String)null);
		 	insertD("So, you have an alibi...", "Ouran");
		 	insertV(3, "Susan Ord");
		 	insertD("Yes, I do.", "Susan");
		 	insertV(1, (String)null);
		 	insertD("Well, who else besides my client could have committed the murder?", "Ouran");
		 	insertV(2, "Adrasteia Rhamnousia");
		 	insertD("Objection!", "Adrasteia");
		 	insertV(0, "Judge Judge");
		 	insertD("Sustained.", "Judge Judge");
		 	insertV(4, (String)null);
		 	insertD("We need more evidence, Ouran-san!", "Nekocchi");
		 	insertV(0, "Judge Judge");
		 	insertD("Are both sides good if we stop for the day?", "Judge Judge");
		 	insertV(2, "Adrasteia Rhamnousia");
		 	insertD("I think we could render a verdict today.", "Adrasteia");
		 	insertV(0, "Judge Judge");
		 	insertD("Perhaps, but there is still reasonable doubt in the case.", "Judge Judge");
		 	insertD("We have no real witnesses, and we’re still missing at least one vital piece of evidence.", "Judge Judge");
		 	insertD("In addition, somebody could have taken the elevator to leave the apartment.", "Judge Judge");
		 	insertD("Therefore, we will reconvene tomorrow!", "Judge Judge");
		 	insertV(1, (String)null);
		 	insertD("I am Ouran Forenz.", "Ouran");
		 	insertD("And as long as I am a defence attorney, those falsely accused will never be convicted.", "Ouran");
		 	insertData("To be continued...");
    	}
    	if (flags[25]==false&&!oneProc) // checks if investigation has not yet been run and that it is not already running
        {
            oneProc = true; // sets the segment to already running
            inCourt = false; // sets the game to not being in court
            insertR("Ouran's Attorney's Badge","badge","It’s the badge I got when I first became an Attorney.", false,0); //adds badge to profile
            insertR("Ouran", "ouranProfile", "It's me!", true, 2); // adds Ouran to profile
            insertR("Nekocchi", "nekocchiProfile", "My assistant...", true, 3); // adds Nekocchi to profile
            insertR("Det. Pat. Bluthund", "bluthundProfile", "The detective. Can be a bit over-zealous.", true, 4); // adds Bluthund to profile
            insertR("Adrasteia Rhamnousia", "adrasteiaProfile", "The prosecutor. Blind as a bat.", true, 5); // adds Adrasteia to profile
            // lists starting dialogue
            insertD("Convention Centre", "");
            insertD("August 7", "");
            insertD("2:57 PM", "");
            insertD("Ouran-san! My kawaii Fairilees must see battle!", "Nekocchi");
            insertD("(Nekocchi dragged me to a tournament for some weird card game.)", "Ouran");
            insertD("(I probably shouldn't be here...)", "Ouran");
            insertD("There he is! My final opponent is the famous Keto Saiba!", "Nekocchi");
            insertD("Greetings. You’re using Fairilees, I see? My famous Dragons will destroy you!", "Keto");
            insertD("Silly baka! Dragons cannot hurt fairies, Keto-san!", "Nekocchi");
            insertD("Who cares about the immunity rules? No individual card can stand up to this!", "Keto");
            insertD("Awww...", "Nekocchi");
            insertD("(Nekkochi lost. I feel kind of bad for her.)", "Ouran");
            insertD("That was a good fight, Keto-chan! Your dragons were sugoi cool!", "Nekocchi");
            insertD("Of course they are!", "Keto");
            flags[25] = true; // sets that the investigation has already run
      		 locales[0] = new DetentionThree(0); // adds detention centre
       		 locales[1] = new ForenzOffice(1); // adds office
       		 locales[2] = new SaibaEntrance(2); // adds entrance to Saiba Corp.
       		 locales[3] = new SaibaApartment(3); // adds Saiba Corp. apartment
       		 locales[4] = new LivingRoom(4); // adds apartment living room
       		 locales[5] = new SaibaStorage(5); // adds storage room
       		 locales[0].linkPath(locales[1]); // links path
       		 locales[3].linkPath(locales[4]); // links path
          //flags[25]=true;
       		// this.toCourt();
       		 enterArea(1); //enters office
       		

        }
        

    super.update(); // updates super
    
    }
	@Override
	void setUP() throws IOException {
		// TODO Auto-generated method stub
		
	}
   
}
