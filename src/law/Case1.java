package law; // sets package

import java.io.IOException; // imports IOException


public class Case1 extends StoryManager{ // opens class for first case
	Case1() throws IOException{ // constructor for first case
		super(); // invokes super
		this.currentProsecutor="Mel Practiss"; // sets current prosecutor
	}
	
	void update() throws IOException{ // runs update loop
		characters.add(new Character ("Det. Pat. Bluthund", 150, 0)); //adds Bluthund
		characters.add(new Character("Gilligan Tam",350,500)); // adds Gilligan
		characters.add(new Character("Photo of Body", 150, 0)); // adds picture of body so it can be shown in court
		if (!oneProc) // checks if the case is already running
		{
		oneProc=true; // sets the case to be running
		inCourt=true; // places case in court
		
		startCExamine(0); // starts first cross-examination
		 
		 // lists statements for cross-examination
		 Main.cExamine[Main.examineSlot].add("The body was found in the morning.", "Det. Pat. Bluthund",  new String[] {"Who discovered the body?","Can't tell you that man.","What I can tell you is that it was discovered when some people showed up for work the next morning.", "So around 9 AM?", "Yeah, around 9."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("We know Al was alive at 5:30 PM.", "Det. Pat. Bluthund",  new String[] {"How exactly do you know that?","We have a record of him checking in at work.","So was his shift ending?","No it was starting. Al was a night guard.","Right I knew that...","(I should remember to check the profile section of the court record.)","(That way I can remember who is involved in the case.)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz","Ouran Forenz"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("We also know Gill�s shift ended at around the same time.", "Det. Pat. Bluthund",  new String[] {"So my client�s shift ended at 5:30?","That�s right! The same time as Al.","HE MUST BE THE CULPRIT!!!","Detective Bluthund, were those the only two whose shift ended at 5:30?","Nah, there were others� But still�"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("It stands to reason Gill offed him at around 5:30", "Det. Pat. Bluthund",  new String[] {"What makes you think that?","Well he was there at the same time.","And? There were other workers.","But the dying message! It must be him!","(That message. It�s pretty damning evidence�)","(But there was something else wrong with that statement�)"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 2, "Autopsy Report1",null,0);
		 Main.cExamine[Main.examineSlot].add("That�s my reasoning and I�m sticking with it.", "Det. Pat. Bluthund",  new String[] {"That�s awful stubborn of you.","I�m never wrong! When I find a suspect, it�s always them!","Always?","Well, maybe not always�","Detective, please just stick to the facts of the case�","You got it!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 
		 stopCExamine(); // ends first cross-examination
		 
		 
		 //insertV(5, null);
		 //For the defendant lobby.
		 insertR("Ouran Forenz", "ouranProfile", "You thought it was Wright, but it was me, Forenz.",true,0); // adds Ouran to record
		 insertR("Attorney's Badge","badge","The proof of my profession, my badge.",false,1); // adds attorney's badge to record
		 // various changes of view and pieces of dialogue
		 insertV(1,null);
		 insertD("Mr. Forenz, court is about to begin.", "Bailiff");
		 insertD("...","Ouran Forenz");
		 insertD("Huh?", "Ouran Forenz");
		 insertR("Nekocchi", "nekocchiProfile", "An annoying weeb that follows me around.",true,2); // adds Nekocchi to record
		 insertD("Oh nyan, get up you silly baka-chan. ~owo", "Nekocchi");
		 insertD("Calm down, I'm up jeez...", "Ouran Forenz");
		 insertD("(I'm Ouran Forenz, a defense attorney.)", "Ouran Forenz");
		 insertD("We need to be in court soon nyan desu. ->_<-", "Nekocchi");
		 insertD("Yeah I know. I'm coming.","Ouran Forenz");
		 insertD("(That's Nekocchi. She�s incredibly annoying, I don�t know why I keep her around.)", "Ouran Forenz");
		 insertD("(Sometimes she annoys witnesses so much that it encourages them to talk just to make her go away.)","Ouran Forenz");
		 insertD("Well, time to go in I suppose.","Ouran Forenz");
		 insertD("Let�s go get a sugoi acquittal Ouran-kun!!!","Nekocchi");
		 insertD("I hate you so much...","Ouran Forenz");
		 insertV(0, null);
		 insertData("---Courtroom A  May 22nd, 2:34 PM.---");
		 insertD("Court is now in session for the trial Gilligan Tam. Is the prosecution ready?","Judge Judge");
		 insertV(2,null);
		 insertR("Mel Practiss", "melProfile", "A nervous but decently proficient prosecutor... Maybe.",true,3);
		 insertD("The prosecution is� r-r-ready... maybe.", "Mel Practiss");
		 insertV(1, null);
		 insertD("The defense is ready your honor.","Ouran Forenz");
		 insertV(0, null);
		 insertD("Prosecution, call your first witness.","Judge Judge");
		 insertV(2,null);
		 insertD("The prosecution calls Mr. Bloodhound","Mel Practiss");
		 insertD("... I mean, D-detective Bluthund...","Mel Practiss");
		 insertV(4,null);
		 insertD("Nyan? This is going super super super fast!!! ^o^","Nekocchi");
		 insertD("Please stop...","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false); // plays animation for Bluthund
		 insertR("Detective Bluthund", "bluthundProfile", "A detective who may or may not be just a dog.",true,4); // inserts Bluthund into the record
		 insertData("---Detective Patrick Bluthund---");
		 insertV(2,null);
		 insertD("Please state your name and profession.","Mel Practiss");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("My name is Patrick Bluthund, homicide division. I sniff out criminals and this dude is one of them!", "Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("Ummm, that�s a dog�", "Ouran Forenz");
		 insertV(2,null);
		 insertD("What are you talking about, this is Detective Patrick Bluthund?", "Mel Practiss");
		 insertV(1,null);
		 insertD("That�s a dog in a trench coat are you blind?", "Ouran Forenz");
		 insertV(0,null);
		 insertD("I will not have you slander the witness this way Mr. Forenz.", "Judge Judge");
		 insertD("This is one of the best detectives in the homicide division.","Judge Judge");
		 insertV(1,null);
		 insertD("He even said he sniffs out criminals. That is an anthropomorphic dog.","Ouran Forenz");
		 insertV(4,null);
		 insertD("Ummm Ouran-san, I think you should stop now.","Nekocchi");
		 insertD("Your being a bigger baka than normal nyan-desu~~","Nekocchi");
		 insertV(1,null);
		 insertD("Ahhh� Ok whatever. As long as he does his job.","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Don�t worry man, I get it a lot for some reason. I�m used to it.","Det. Pat. Bluthund");
		 insertD("By the way...","Det. Pat. Bluthund");
		 insertD("I got the preliminary autopsy report right here in case you want to review it.","Det. Pat. Bluthund");
		 insertD("His cause of death was blunt force trauma.","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("You say preliminary, right?","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Yes, but it should be pretty accurate. We are just investigating finer details.","Det. Pat. Bluthund");
		 insertD("We will be informed right away once it gets updated.","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("Perfect. (This guy seems to know what he's doing...)","Ouran Forenz");
		 insertR("Autopsy Report","autopsy","Cause of Death: Blunt Force Trauma, 9:45-10:30 PM",false,5); // inserts autopsy report in record
		 insertData("You got the Autopsy Report.");
		 insertV(4,null);
		 insertD("Ouran-kun desu, if you want to peep into the sugoi court record...","Nekocchi");
		 insertD("Use the arrow keys to navigatilate to the Record button and pressity press Z.","Nekocchi");
		 insertD("Use the arrow keys and Z for other menu options too!!! (OuO)->-","Nekocchi");
		 insertD("I know how to be a lawyer, just let me handle this.","Ouran Forenz");
		 insertD("Besides I can't do that right now, we need to listen. Wait until Cross-Examination.","Ouran Forenz");
		 insertD("Well sumimasen Ouran-kun I guess you are a professional or something�","Nekocchi");
		 insertD("I am.","Ouran Forenz");
		 insertV(1,null);
		 insertD("(I should check the court record frequently. All the information I could ever need is in there.)","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("I got more for you. The victim was Al Protecc, a security guard at Fat Stacks Bank.","Det. Pat. Bluthund");
		 insertD("Here�s a photo of him when he was alive.", "Det. Pat. Bluthund");
		 insertR("Photo of Al","photoalprotecc","Al holding a coffee cup in his left hand when he was alive.",false,6); //inserts photo of Al
		 insertData("You got the Photo of Al.");
		 insertD("A witness found the body the next morning. His dying message implicates your client a lot.", "Det. Pat. Bluthund");
		 insertData("You got the Photo of the Body.");
		 showAni("Photo of Body","albodypic",0,false); //plays animation of picture of body
		 insertD("Clear as day, written right there is the name of your client.","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("I�m a little confused. My client�s name is Gilligan Tam not 'Gill T'....","Ouran Forenz");
		 insertD("Oh...","Ouran Forenz");
		 insertV(3,"Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertR("Gilligan Tam", "gilliganProfile", "A teller at Fat Stacks Bank.",true,7);
		 insertD("THATS ME!!!","Gilligan Tam");
		 insertV(1,null);
		 insertD("Gilligan, you shouldn�t be speaking. I�m your attorney, you need to leave it to me.","Ouran Forenz");
		 insertV(3,"Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertD("Well I just wanted to let you know that Gill is my nickname. I�m Gill T!","Gilligan Tam");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("THAT�S A CONFESSION!!!","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("(This isn't going well...)","Ouran Forenz");
		 insertData("You got the Photo of the Body.");
		 insertR("Photo of Body","albodypic","Dying message by right hand that reads 'Gill T'.",false,8);
		 insertData("You got the Picture of the Body.");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("The murder weapon was a stick found at the scene. It was covered in Mr. Protecc�s blood.","Det. Pat. Bluthund");
		 insertV(4,null);
		 insertD("OwO B-blood???","Nekocchi");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Yes blood. This was a murder after all.","Det. Pat. Bluthund");
		 insertV(4,null);
		 insertD("Nani-desu? No one told me someone got murdered desu~~ <~_~>","Nekocchi");
		 insertD("I told you multiple times. You reacted like this every time, how can you not remember?","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Anyway the stick was nothing special. Just something from outside on the ground.","Det. Pat. Bluthund");
		 insertR("Big Stick","bigStick","Just a big stick. Murder weapon.",false,9);
		 insertData("You got the Big Stick.");
		 insertV(2,null);
		 insertD("Thank you Detective. Can you testify about some of your reasoning?","Mel Practiss");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Sure can!","Det. Pat. Bluthund");
		 runFirstExamine(0); // runs beginning of cross-examination
		 insertD("Detective, you said Al must have died from 5:30-6:00 correct?","Ouran Forenz");
		 
		 
		}
		super.update(); // updates super
		 
	}
	}

