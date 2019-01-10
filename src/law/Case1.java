package law;

import java.io.IOException;

public class Case1 extends StoryManager{
	
	Case1() throws IOException{
		super();
	}
	
	void update() throws IOException{
		inCourt=true;
		
		startCExamine(0);
		 
		 
		 Main.cExamine[Main.examineSlot].add("The body was found in the morning.", "Det. Pat. Bluthund",  new String[] {"Who discovered the body?","Can't tell you that man.","What I can tell you is that it was discovered when some people showed up for work the next morning.", "So around 9 AM?", "Yeah, around 9."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("We know Al was alive at 5:30 PM.", "Det. Pat. Bluthund",  new String[] {"How exactly do you know that?","We have a record of him checking in at work.","So was his shift ending?","No it was starting. Al was a night guard.","Right I knew that...","(I should remember to check the profile section of the court record.)","(That way I can remember who is involved in the case.)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz","Ouran Forenz"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("We also know Gill’s shift ended at around the same time.", "Det. Pat. Bluthund",  new String[] {"So my client’s shift ended at 5:30?","That’s right! The same time as Al.","HE MUST BE THE CULPRIT!!!","Detective Bluthund, were those the only two whose shift ended at 5:30?","Nah, there were others… But still…"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("It stands to reason Gill offed him at around 5:30", "Det. Pat. Bluthund",  new String[] {"What makes you think that?","Well he was there at the same time.","And? There were other workers.","But the dying message! It must be him!","(That message. It’s pretty damning evidence…)","(But there was something else wrong with that statement…)"} ,  new String[] {"Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi","Nekocchi"} , 2, "Autopsy Report1",null,0);
		 Main.cExamine[Main.examineSlot].add("That’s my reasoning and I’m sticking with it.", "Det. Pat. Bluthund",  new String[] {"That’s awful stubborn of you.","I’m never wrong! When I find a suspect, it’s always them!","Always?","Well, maybe not always…","Detective, please just stick to the facts of the case…","You got it!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 
		 stopCExamine();
	}
	}

