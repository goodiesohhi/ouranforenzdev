package law;

import java.io.IOException;


public class Case1 extends StoryManager{
	Case1() throws IOException{
		super();
	}
	
	void update() throws IOException{
		characters.add(new Character ("Det. Pat. Bluthund", 150, 0));
		if (!oneProc)
		{
		oneProc=true;
		inCourt=true;
		
		startCExamine(0);
		 
		 
		 Main.cExamine[Main.examineSlot].add("The body was found in the morning.", "Det. Pat. Bluthund",  new String[] {"Who discovered the body?","Can't tell you that man.","What I can tell you is that it was discovered when some people showed up for work the next morning.", "So around 9 AM?", "Yeah, around 9."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("We know Al was alive at 5:30 PM.", "Det. Pat. Bluthund",  new String[] {"How exactly do you know that?","We have a record of him checking in at work.","So was his shift ending?","No it was starting. Al was a night guard.","Right I knew that...","(I should remember to check the profile section of the court record.)","(That way I can remember who is involved in the case.)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz","Ouran Forenz"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("We also know Gill’s shift ended at around the same time.", "Det. Pat. Bluthund",  new String[] {"So my client’s shift ended at 5:30?","That’s right! The same time as Al.","HE MUST BE THE CULPRIT!!!","Detective Bluthund, were those the only two whose shift ended at 5:30?","Nah, there were others… But still…"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("It stands to reason Gill offed him at around 5:30", "Det. Pat. Bluthund",  new String[] {"What makes you think that?","Well he was there at the same time.","And? There were other workers.","But the dying message! It must be him!","(That message. It’s pretty damning evidence…)","(But there was something else wrong with that statement…)"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 2, "Autopsy Report1",null,0);
		 Main.cExamine[Main.examineSlot].add("That’s my reasoning and I’m sticking with it.", "Det. Pat. Bluthund",  new String[] {"That’s awful stubborn of you.","I’m never wrong! When I find a suspect, it’s always them!","Always?","Well, maybe not always…","Detective, please just stick to the facts of the case…","You got it!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 
		 stopCExamine();
		 
		 //insertV(5, null);
		 //For the defendant lobby.
		 insertV(1,null);
		 insertD("Mr. Forenz, court is about to begin.", "Bailiff");
		 insertD("...","Ouran Forenz");
		 insertD("Huh?", "Ouran Forenz");
		 insertD("Oh nyan, get up you silly baka-chan. ~owo", "Nekocchi");
		 insertD("Calm down, I'm up jeez...", "Ouran Forenz");
		 insertD("(I'm Ouran Forenz, a defense attorney.", "Ouran Forenz");
		 insertD("We need to be in court soon nyan desu. ->_<-", "Nekocchi");
		 insertD("Yeah I know. I'm coming.","Ouran Forenz");
		 insertD("(That's Nekocchi. She’s incredibly annoying, I don’t know why I keep her around.)", "Ouran Forenz");
		 insertD("(Sometimes she annoys witnesses so much that it encourages them to talk just to make her go away.)","Ouran Forenz");
		 insertD("Well, time to go in I suppose.","Ouran Forenz");
		 insertD("Let’s go get a sugoi acquittal Ouran-kun!!!","Nekocchi");
		 insertD("I hate you so much...","Ouran Forenz");
		 insertV(0, null);
		 insertData("---Courtroom A  May 22nd, 2:34 PM.---");
		 insertD("Court is now in session for the trial Gilligan Tam. Is the prosecution ready?","Judge Judge");
		 insertV(2,null);
		 insertD("The prosecution is… r-r-ready... maybe.", "Mel Practiss");
		 insertV(1, null);
		 insertD("The defense is ready your honor.","Ouran Forenz");
		 insertV(0, null);
		 insertD("Prosecution, call your first witness.","Judge Judge");
		 insertV(2,null);
		 insertD("The prosecution calls Mr. Bloodhound","Mel Practiss");
		 insertD("... I mean, D-detective Bluthund...","Mel Practiss");
		 //insertV(4,null);
		 //For defense counsel
		 insertD("Nyan? This is going super super super fast!!! ^o^","Nekocchi");
		 insertD("Please stop...","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertData("---Detective Patrick Bluthund---");
		 insertV(2,null);
		 insertD("Please state your name and profession.","Mel Practiss");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("My name is Patrick Bluthund, homicide division. I sniff out criminals and this dude is one of them!", "Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("Ummm, that’s a dog…", "Ouran Forenz");
		 insertV(2,null);
		 insertD("What are you talking about, this is Detective Patrick Bluthund?", "Mel Practiss");
		 insertV(1,null);
		 insertD("That’s a dog in a trench coat are you blind?", "Ouran Forenz");
		 insertV(0,null);
		 insertD("I will not have you slander the witness this way Mr. Forenz.", "Judge Judge");
		 insertD("This is one of the best detectives in the homicide division.","Judge Judge");
		 insertV(1,null);
		 insertD("He even said he sniffs out criminals. That is an anthropomorphic dog.","Ouran Forenz");
		 //insertV(4,null);
		 insertD("Ummm Ouran-san, I think you should stop now.","Nekocchi");
		 insertD("Your being a bigger baka than normal nyan-desu~~","Nekocchi");
		 //insertV(1,null);
		 insertD("Ahhh… Ok whatever. As long as he does his job.","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Don’t worry man, I get it a lot for some reason. I’m used to it.","Det. Pat. Bluthund");
		 
		}
		super.update();
		 
	}
	}

