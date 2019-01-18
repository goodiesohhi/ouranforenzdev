package law; // sets package

import java.io.IOException; // imports IOException


public class Case1 extends StoryManager{ // opens class for first case
	Case1() throws IOException{ // constructor for first case
		super(1,"NAME UR CASE"); // invokes super
		this.currentProsecutor="Mel Practiss"; // sets current prosecutor
	}
	
	void update() throws IOException{ // runs update loop
		characters.add(new Character ("Det. Pat. Bluthund", 150, 0)); //adds Bluthund
		characters.add(new Character("Gilligan Tam",350,500)); // adds Gilligan
		characters.add(new Character("Photo of Body", 150, 0)); // adds picture of body so it can be shown in court
		characters.add(new Character("Nekocchi",250,200));
		this.getCharacter("Gilligan Tam").animList.add(new AnimData("Gilligan Tam", "gilliganWitness",0, true)); // adds character animation
		this.getCharacter("Det. Pat. Bluthund").animList.add(new AnimData("Det. Pat. Bluthund", "bluthundWitness", 0, true)); // adds character animation
		characters.add(new Character("Enrico Nocent",150,0));
		if (!oneProc) // checks if the case is already running
		{
		oneProc=true; // sets the case to be running
		
		
		startCExamine(0); // starts first cross-examination
		 
		 // lists statements for cross-examination
		 Main.cExamine[Main.examineSlot].add("The body was found in the morning.", "Det. Pat. Bluthund",  new String[] {"Who discovered the body?","Can't tell you that man.","What I can tell you is that it was discovered when some people showed up for work the next morning.", "So around 9 AM?", "Yeah, around 9."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , "bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("We know Al was alive at 5:30 PM.", "Det. Pat. Bluthund",  new String[] {"How exactly do you know that?","We have a record of him checking in at work.","So was his shift ending?","No it was starting. Al was a night guard.","Right I knew that...","(I should remember to check the profile section of the court record.)","(That way I can remember who is involved in the case.)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz","Ouran Forenz"} , 0, null,"bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("We also know Gill's shift ended at around the same time.", "Det. Pat. Bluthund",  new String[] {"So my client's shift ended at 5:30?","That's right! The same time as Al.","HE MUST BE THE CULPRIT!!!","Detective Bluthund, were those the only two whose shift ended at 5:30?","Nah, there were others. But still..."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,"bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("It stands to reason Gill offed him at around 5:30", "Det. Pat. Bluthund",  new String[] {"What makes you think that?","Well he was there at the same time.","And? There were other workers.","But the dying message! It must be him!","(That message. It's pretty damning evidence...)","(But there was something else wrong with that statement...)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz"} , 2, "Autopsy Report","bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("That's my reasoning and I'm sticking with it.", "Det. Pat. Bluthund",  new String[] {"That's awful stubborn of you.","I'm never wrong! When I find a suspect, it's always them!","Always?","Well, maybe not always...","Detective, please just stick to the facts of the case...","You got it!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,"bluthundTalk",2);
		 
		 stopCExamine(); // ends first cross-examination

		 
		 startCExamine(1);
		 
		 Main.cExamine[Main.examineSlot].add("When the body was found, a message was found next to him", "Det. Pat. Bluthund", new String[] {"Tell me more about the discovery.","Well another witness we have discovered the body when he went into work the next day.","Who is this witness?","AHAHAHAHA. I'm not telling you that. I have no reason to.","(If I want to know more about this mystery witness I need them on the stand')","(I need to get through this mutt first.)"}, new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz"}, 0, null, "bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("It very clearly says GILL T, that's your client man.", "Det. Pat. Bluthund",  new String[] {"So your saying the message implicates my client?","Sure does. Look at it!","How do you know it was the victim who wrote it.","Anyone with eyes can tell. You see..."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , "bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("There's even blood on is finger showing he wrote it.", "Det. Pat. Bluthund",  new String[] {"So, the victim wrote the message?","Sure did. Look, his right finger has blood on it.","(Right hand..?)","He wrote the message with his right hand, can't you see?","I'd like you to add that to your testimony please.","Really? Alrighty then."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 1, null,"bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("He must have written the message after he got hit.", "Det. Pat. Bluthund",  new String[] {"So after he was hit with the stick he wrote the message right before his death?","Yeah pal. This is often the case.","Not everyone dies instantly. Usually they are alive for seconds or minutes after the initial trauma.","Interesting.", "Nyan?"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Nekocchi"} , 0, null,"bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("Luckily he did, now we can catch the culprit.", "Det. Pat. Bluthund",  new String[] {"That's conjecture!","It's a reasonable hypothesis based off of evidence and a professional's expert opinion.","Nyan~~desu he has a point.","Well it's my job to prove the evidence is unreliable.","And show that my client couldn't have done it!!!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Nekocchi","Ouran Forenz","Ouran Forenz"} , 0, null,"bluthundTalk",2);
		 
		 stopCExamine();
		 
         startCExamine(2);
		 

		 Main.cExamine[Main.examineSlot].add("When the body was found, a message was found next to him", "Det. Pat. Bluthund", new String[] {"Tell me more about the discovery.","Well another witness we have discovered the body when he went into work the next day.","Who is this witness?","AHAHAHAHA. I'm not telling you that. I have no reason to.","(If I want to know more about this mystery witness I need them on the stand')","(I need to get through this mutt first.)"}, new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz"}, 0, null, "bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("It very clearly says GILL T, that's your client man.", "Det. Pat. Bluthund",  new String[] {"So your saying the message implicates my client?","Sure does. Look at it!","How do you know it was the victim who wrote it.","Anyone with eyes can tell. You see..."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , "bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("He wrote the message using his right hand, can't you see?", "Det. Pat. Bluthund",  new String[] {"Your claim is that the victim wrote his dying message using his right hand?","Yup!","Jeez you just asked this. Do you have anything new to ask?","Well I guess not'","Please don't hound the witness Mr. Forenz.","You got it... (hound?)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Judge Judge"} , 2, "Photo of Al","bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("He must have written the message after he got hit.", "Det. Pat. Bluthund",  new String[] {"So after he was hit with the stick he wrote the message right before his death?","Yeah pal. This is often the case.","Not everyone dies instantly. Usually they are alive for seconds or minutes after the initial trauma.","Interesting.", "Nyan?"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Nekocchi"} , 0, null,"bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("Luckily he did, now we can catch the culprit.", "Det. Pat. Bluthund",  new String[] {"That's conjecture!","It's a reasonable hypothesis based off of evidence and a professional's expert opinion.","Nyan~~desu he has a point.","Well it's my job to prove the evidence is unreliable.","And show that my client couldn't have done it!!!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Nekocchi","Ouran Forenz","Ouran Forenz"} , 0, null,"bluthundTalk",2);
		 
		 stopCExamine();
		 
		 startCExamine(3);
		 

		 Main.cExamine[Main.examineSlot].add("When the body was found, a message was found next to him", "Det. Pat. Bluthund", new String[] {"Tell me more about the discovery.","Well another witness we have discovered the body when he went into work the next day.","Who is this witness?","AHAHAHAHA. I'm not telling you that. I have no reason to.","(If I want to know more about this mystery witness I need them on the stand')","(I need to get through this mutt first.)"}, new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz"}, 0, null, "bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("It very clearly says GILL T, that's your client man.", "Det. Pat. Bluthund",  new String[] {"So your saying the message implicates my client?","Sure does. Look at it!","How do you know it was the victim who wrote it.","Anyone with eyes can tell. You see..."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , "bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("He wrote the message using his right hand, can't you see?", "Det. Pat. Bluthund",  new String[] {"Your claim is that the victim wrote his dying message using his right hand?","Yup!","Jeez you just asked this. Do you have anything new to ask?","Well I guess not'","Please don't hound the witness Mr. Forenz.","You got it... (hound?)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Judge Judge"} , 0, null,"bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("He must have written the message after he got hit.", "Det. Pat. Bluthund",  new String[] {"So after he was hit with the stick he wrote the message right before his death?","Yeah pal. This is often the case.","Not everyone dies instantly. Usually they are alive for seconds or minutes after the initial trauma.","Interesting.", "Nyan?"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Nekocchi"} , 2, "Autopsy Report","bluthundTalk",2);
		 Main.cExamine[Main.examineSlot].add("Luckily he did, now we can catch the culprit.", "Det. Pat. Bluthund",  new String[] {"That's conjecture!","It's a reasonable hypothesis based off of evidence and a professional's expert opinion.","Nyan~~desu he has a point.","Well it's my job to prove the evidence is unreliable.","And show that my client couldn't have done it!!!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Nekocchi","Ouran Forenz","Ouran Forenz"} , 0, null,"bluthundTalk",2);
		 
		 stopCExamine();
		 
		 startCExamine(4);
		 
		 Main.cExamine[Main.examineSlot].add("The bank is locked down tiiiiight. The only ways to get in are locked.", "Enrico Nocent", new String[] {"What ways are there to enter the back?","Welllllll. You can enter through the frooont door.","Or the seccurrrity door.","But only security can go through there.", "I surmised as much."}, new String[] {"Ouran Forenz","Enrico Nocent","Enrico Nocent","Enrico Nocent","Ouran Forenz"}, 0, null, null, 0);
		 Main.cExamine[Main.examineSlot].add("Employees have a key to unlock these doors in case of an e-mer-gen-cy.", "Enrico Nocent",  new String[] {"So any employee could have entered?","There is a camera at the front door tooooo.","It just shows Gill T entering and leaving, not any other employeeeessss.","Yeah, I guess...","I don't think any other employee went through there nyan."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Enrico Nocent","Ouran Forenz", "Nekocchi"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("The back of the bank is only for employeeees. Yeah. It’s also where the money is stored.", "Enrico Nocent",  new String[] {"Only for employees?","Yeeeaahhh. Patrons are not allowed back there. Biiiggg no no.","But since the money is there too...","It needs to be monitored.","Exaclttttly. That’s why Al was there. As well it’s why..."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Ouran Forenz","Ouran Forenz","Enrico Nocent"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Cameras are positioned to watch both hallways leading to the back. Oh yeah.", "Enrico Nocent",  new String[] {"So they would see anyone heading to the back?","Yes indeed!!! They watch the two main hallllls.","Oooh exciting! Are there any blind spots En-chan?~~(&o&)?","The cameras don’t actually watch the back, only the main hallways.","But what’s really important is..."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Nekocchi","Enrico Nocent","Enrico Nocent"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Gill T here is seen going to the back.", "Enrico Nocent",  new String[] {"Going to the back isn’t enough to convince this court of his guilt!","It is for me.","And me.","And me~~","And me if you don’t get back on track with this cross-examination."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Det. Pat. Bluthund","Nekocchi","Judge Judge"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Clearly he is going back there to off our good friend Al.", "Enrico Nocent",  new String[] {"So, according to you, Gilligan at this point has an intent to kill?","ou are making the claim that this murder is of the first degree!","Well yes, isn’t that what this trial is for?","Yeah I know, I’m just trying to sound dramatic.","Please stay focused Forenz..."} ,  new String[] {"Ouran Forenz","Ouran Forenz","Enrico Nocent","Ouran Forenz","Judge Judge"} , 2, "Big Stick",null,0);
		 
		 
		 stopCExamine();
		 
		 startCExamine(5);
		 
		 Main.cExamine[Main.examineSlot].add("Well you see I know Gilligan pretty well.", "Enrico Nocent", new String[] {"You know my client well? This is the first time I’m hearing about this.","Me too~~","Me too.","Me too.","Me too.","Bluthund why are you still here.","Well it’s true, I know Mr. Tam very well.","Very well?","Oh yeaaaaahh. We. Are. Work. Friends!","(Wouldn’t exactly call that close...)"}, new String[] {"Ouran Forenz","Nekocchi","Judge Judge","Mel Practiss","Det. Pat Bluthund","Ouran Forenz","Enrico Nocent","Ouran Forenz","Enrico Nocent","Ouran Forenz"}, 0, null, null, 0);
		 Main.cExamine[Main.examineSlot].add("We work together after all...", "Enrico Nocent",  new String[] {"You may work at the same company but in completely separate departments.","How often could you possibly see each other?","On occasion my good friend. On. Occasion.","I see things on occasion! Things no one else can nyan...","They swirl everywhere. They tell me things...","Dark things...","Only I can see them...","They... Are...","Well that’s enough of that. I think we should move on."} ,  new String[] {"Ouran Forenz","Ouran Forenz","Enrico Nocent","Nekocchi","Nekocchi", "Nekocchi","Nekocchi","Nekocchi","Ouran Forenz"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("We got off work at 5:00 and started talking.", "Enrico Nocent",  new String[] {"You two got off at the same time?","Yeah and we talked. Talked for a while about life.","General normal stuff that normal people would talk about.","Did you now?","Yes we did, let’s move riiight along. Moment of truth now..."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Enrico Nocent","Ouran Forenz","Enrico Nocent"} , 2, "Work Record",null,0);
		 Main.cExamine[Main.examineSlot].add("That’s when he mentioned to me he forgot his papers.", "Enrico Nocent",  new String[] {"How did that come up in conversation.","Incredibly naturally of course. He mentioned it as an aside. Said he was going to go back later to get them.","My guess is he wanted to give his story credibility by telling me that.","That... (actually makes a lot of sense. Crap...)","That's all. That's how I know."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Enrico Nocent","Ouran Forenz","Enrico Nocent"} , 0, null,null,0);
		 
		 
		 stopCExamine();
		 
		 startCExamine(6);
		 
		 Main.cExamine[Main.examineSlot].add("As we talked about before, this bank is locked up tiiighhht.", "Enrico Nocent", new String[] {"But how tight?","Tight.","Tight?","Tiyight.","Tiyight?","Tiiiiiiiyyiiyiyiyiyight.","I see. (What just happened?)"}, new String[] {"Ouran Forenz","Enrico Nocent","Ouran Enrico","Enrico Nocent","Ouran Forenz","Enrico Nocent","Ouran Forenz"}, 0, null, null, 0);
		 Main.cExamine[Main.examineSlot].add("As a security guard myself, I know the ins and outs of the system.", "Enrico Nocent",  new String[] {"So you can confidently testify about this?","I know the security of this bank by heart.","It's flawless, just like me.","Factually incorrect. You are not perfect.","No one is as no one is able to reproduce on their own.","Oh god what?","A single cell organism is closer in that it can asexually reproduce through binary fission.","Unfortunately they are small, lack human intellectual capabilities and don’t have opposable thumbs.","Just shut up.","I have disposable thumbs!","You mean opposable?","No silly baka, I’m a neko I gots paws. I have paws cause I disposed of my thumbs.","They were holding me back...","That’s deeply disturbing..."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Enrico Nocent","Ouran Forenz", "Ouran Forenz", "Enrico Nocent","Nekocchi","Ouran Forenz","Nekocchi","Nekocchi","Ouran Forenz"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("I can confidently say there are no blind spots.", "Enrico Nocent",  new String[] {"No blind spots?","No blind spots.","Then why wasn’t the murder captured on film?","Well the back isn't monitored nearly as much as the halls.","The only cameras are the two hallway cameras.","And one monitoring the vault.","No one could have gone into the back without being seen on camera.","Hmmmmm..."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Ouran Forenz","Enrico Nocent","Enrico Nocent","Enrico Nocent","Enrico Nocent","Ouran Forenz"} , 2, "Bank Floorplan",null,0);
		 Main.cExamine[Main.examineSlot].add("Trust me, I’m a professional.", "Enrico Nocent",  new String[] {"A professional?","Yes, a professional.","Ok."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Ouran Forenz"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("There’s no way I could have entered.", "Enrico Nocent",  new String[] {"So you say.","I do say. Who is more qualified than me?","Maybe someone not being accused of being present during a murder?","This is a fair point. Your expertise isn’t as credible as it would be otherwise.","Trust me judge, I ain’t lying.","(So you claim..."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Ouran Forenz","Judge Judge","Enrico Nocent","Ouran Forenz"} , 0, null,null,0);
		 
		 
		 stopCExamine();
		 
		 startCExamine(7);
		 
		 Main.cExamine[Main.examineSlot].add("Ok, yes I was at the bank that night...", "Enrico Nocent", new String[] {"Why were you at the bank?","Well I also forgot some papers...","Really? That’s awfully convenient.","Especially since you specifically entered in a way that the cameras couldn’t see you.","It’s all a big coincidence I tell you! Please...","Let’s move on Ouran-kun...desu"}, new String[] {"Ouran Forenz","Enrico Nocent","Ouran Enrico","Enrico Nocent","Nekocchi"}, 0, null, null, 0);
		 Main.cExamine[Main.examineSlot].add("But I didn’t murder anybody!", "Enrico Nocent",  new String[] {"You did murder someone. You murdered Al Protecc!!!","Aren’t you trying to prove that?","Yes, and I will.","...","Just... Give me a minute."} ,  new String[] {"Ouran Forenz","Judge Judge","Ouran Forenz","Ouran Forenz", "Ouran Forenz"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("I know because I saw the murder!", "Enrico Nocent",  new String[] {"You realize withholding information like this...","It doesn't look good.","I realize...","...","And it seems like a desperate lie...","But it isn't...","...","(I'm getting nowhere."} ,  new String[] {"Ouran Forenz","Ouran Forenz","Enrico Nocent","Ouran Forenz","Ouran Forenz","Enrico Nocent","Ouran Forenz","Ouran Forenz"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("It was Gilligan, I saw it!", "Enrico Nocent",  new String[] {"Please explain further. What exactly did you see?","Well Gill had that big stick and he used it to hit and kill Al.","That's it?","Yes. I’ll say it again for you if you want."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Ouran Forenz","Enrico Nocent"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("He hit Al in the head hard with a stick.", "Enrico Nocent",  new String[] {"So Gilligan hit Al?","Yes.","With the stick?","Yes.","Describe it. How did Al get hit? Give details. We need to know details.","I do remember the scene clearly. Gilligan smacked Al hard right in the back of the head.","Please add that to your testimony.","Can diddly do.","Man he’s an annoying baka.","He is indeed desu... (whoops slipped out.)"} ,  new String[] {"Ouran Forenz","Enrico Nocent","Ouran Forenz","Enrico Nocent","Ouran Forenz","Enrico Nocent","Ouran Forenz","Enrico Nocent","Nekocchi","Ouran Forenz"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("That's the whole truth.", "Enrico Nocent",  new String[] {"Enrico Nocent...","Yes?","I don't have much more to say...","But I know you are lying!","Then prove it!"," I will then."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Ouran Forenz","Ouran Forenz","Enrico Nocent","Ouran Forenz"} , 0, null,null,0);
		 
		 
		 stopCExamine();
		 
		 startCExamine(8);
		 
		 Main.cExamine[Main.examineSlot].add("Ok, yes I was at the bank that night...", "Enrico Nocent", new String[] {"Why were you at the bank?","Well I also forgot some papers...","Really? That’s awfully convenient.","Especially since you specifically entered in a way that the cameras couldn’t see you.","It’s all a big coincidence I tell you! Please...","Let’s move on Ouran-kun...desu"}, new String[] {"Ouran Forenz","Enrico Nocent","Ouran Enrico","Enrico Nocent","Nekocchi"}, 0, null, null, 0);
		 Main.cExamine[Main.examineSlot].add("But I didn’t murder anybody!", "Enrico Nocent",  new String[] {"You did murder someone. You murdered Al Protecc!!!","Aren’t you trying to prove that?","Yes, and I will.","...","Just... Give me a minute."} ,  new String[] {"Ouran Forenz","Judge Judge","Ouran Forenz","Ouran Forenz", "Ouran Forenz"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("I know because I saw the murder!", "Enrico Nocent",  new String[] {"You realize withholding information like this...","It doesn't look good.","I realize...","...","And it seems like a desperate lie...","But it isn't...","...","(I'm getting nowhere."} ,  new String[] {"Ouran Forenz","Ouran Forenz","Enrico Nocent","Ouran Forenz","Ouran Forenz","Enrico Nocent","Ouran Forenz","Ouran Forenz"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("It was Gilligan, I saw it!", "Enrico Nocent",  new String[] {"Please explain further. What exactly did you see?","Well Gill had that big stick and he used it to hit and kill Al.","That's it?","Yes. I’ll say it again for you if you want."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Ouran Forenz","Enrico Nocent"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("I vividly remember! Gilligan hit Al in the back of the head.", "Enrico Nocent",  new String[] {"I need more details. Set the scene for me.","A cold moonlit night. A shocking scene. I crept into the bank slowly and softly...","Suddenly, I hear a sound. An awful sound. I hear men arguing. A stick is drawn.","I don’t think that’s what Ouran-kun meant desu...","No it is. Keep going...","A threat! A terrified man. Al stands up and defends himself through the fear.","It isn’t enough. Gill runs behind him and WHAM...","It’s all over...","I stand paralyzed in fear...","More details!","A fly buzzes by. The only sound around. The thud of the stick resonates as it drops to the ground.","Beads of sweat roll down my face. The body is lifeless... Sitting there...","What an interesting tale.... Why didn’t you call the police?","Well... Look just believe me, it’s all true."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Enrico Nocent","Nekocchi","Ouran Forenz","Enrico Nocent","Enrico Nocent","Enrico Nocent","Enrico Nocent","Ouran Forenz","Enrico Nocent","Enrico Nocent","Ouran Forenz","Enrico Nocent"} , 2, "Autopsy Report",null,0);
		 Main.cExamine[Main.examineSlot].add("That's the whole truth.", "Enrico Nocent",  new String[] {"Enrico Nocent...","Yes?","I don't have much more to say...","But I know you are lying!","Then prove it!"," I will then."} ,  new String[] {"Ouran Forenz","Enrico Nocent","Ouran Forenz","Ouran Forenz","Enrico Nocent","Ouran Forenz"} , 0, null,null,0);
		 
		 
		 stopCExamine();
		 
		 
		 insertR("Ouran Forenz", "ouranProfile", "You thought it was Wright, but it was me, Forenz.",true,0); // adds Ouran to record
		 insertR("Attorney's Badge","badge","The proof of my profession, my badge.",false,1); // adds attorney's badge to record
		 // various changes of view and pieces of dialogue
		 insertV(5,"Nekocchi");
		 playAni("Nekocchi","nekocchiWitness",0,false);
		 insertD("Mr. Forenz, court is about to begin.", "Bailiff");
		 insertD("...","Ouran Forenz");
		 insertD("Huh?", "Ouran Forenz");
		 insertR("Nekocchi", "nekocchiProfile", "An annoying weeb that follows me around.",true,2); // adds Nekocchi to record
		 insertD("Oh nyan, get up you silly baka-chan. ~owo", "Nekocchi");
		 insertD("Calm down, I'm up jeez...", "Ouran Forenz");
		 insertD("(I'm Ouran Forenz, a defense attorney.)", "Ouran Forenz");
		 insertD("We need to be in court soon nyan desu. ->_<-", "Nekocchi");
		 insertD("Yeah I know. I'm coming.","Ouran Forenz");
		 insertD("(That's Nekocchi. She's incredibly annoying, I don't know why I keep her around.)", "Ouran Forenz");
		 insertD("(Sometimes she annoys witnesses so much that it encourages them to talk just to make her go away.)","Ouran Forenz");
		 insertD("Well, time to go in I suppose.","Ouran Forenz");
		 insertD("Let's go get a sugoi acquittal Ouran-kun!!!","Nekocchi");
		 insertD("I hate you so much...","Ouran Forenz");
		 insertV(0,(String)null);
		 insertData("---Courtroom A  May 22nd, 2:34 PM.---");
		 insertD("Court is now in session for the trial of Gilligan Tam. Is the prosecution ready?","Judge Judge");
		 insertV(2,(String)null);
		 insertR("Mel Practiss", "melProfile", "A nervous but decently proficient prosecutor... Maybe.",true,3);
		 insertD("The prosecution is... r-r-ready... maybe.", "Mel Practiss");
		 insertV(1,(String)null);
		 insertD("The defense is ready your honor.","Ouran Forenz");
		 insertV(0,(String)null);
		 insertD("Prosecution, call your first witness.","Judge Judge");
		 insertV(2,(String)null);
		 insertD("The prosecution calls Mr. Bloodhound","Mel Practiss");
		 insertD("... I mean, D-detective Bluthund...","Mel Practiss");
		 insertV(4,(String)null);
		 insertD("Nyan? This is going super super super fast!!! ^o^","Nekocchi");
		 insertD("Please stop...","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		  // plays animation for Bluthund
		 insertR("Detective Bluthund", "bluthundProfile", "A detective who may or may not be just a dog.",true,4); // inserts Bluthund into the record
		 insertData("---Detective Patrick Bluthund---");
		 insertV(2,(String)null);
		 insertD("Please state your name and profession.","Mel Practiss");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("My name is Patrick Bluthund, homicide division. I sniff out criminals and this dude is one of them!", "Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("Ummm, that's a dog'", "Ouran Forenz");
		 insertV(2,(String)null);
		 insertD("What are you talking about, this is Detective Patrick Bluthund?", "Mel Practiss");
		 insertV(1,(String)null);
		 insertD("That's a dog in a trench coat are you blind?", "Ouran Forenz");
		 insertV(0,(String)null);
		 insertD("I will not have you slander the witness this way Mr. Forenz.", "Judge Judge");
		 insertD("This is one of the best detectives in the homicide division.","Judge Judge");
		 insertV(1,(String)null);
		 insertD("He even said he sniffs out criminals. That is an anthropomorphic dog.","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Ummm Ouran-san, I think you should stop now.","Nekocchi");
		 insertD("Your being a bigger baka than normal nyan-desu~~","Nekocchi");
		 insertV(1,(String)null);
		 insertD("Ahhh... Ok whatever. As long as he does his job.","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Don't worry man, I get it a lot for some reason. I'm used to it.","Det. Pat. Bluthund");
		 insertD("By the way...","Det. Pat. Bluthund");
		 insertD("I got the preliminary autopsy report right here in case you want to review it.","Det. Pat. Bluthund");
		 insertD("His cause of death was blunt force trauma.","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("You say preliminary, right?","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Yes, but it should be pretty accurate. We are just investigating finer details.","Det. Pat. Bluthund");
		 insertD("We will be informed right away once it gets updated.","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("Perfect. (This guy seems to know what he's doing...)","Ouran Forenz");
		 insertR("Autopsy Report","autopsy","Cause of Death: Blunt Force Trauma, 9:45-10:30 PM",false,5); // inserts autopsy report in record
		 insertData("You got the Autopsy Report.");
		 insertV(4,(String)null);
		 insertD("Ouran-kun desu, if you want to peep into the sugoi court record...","Nekocchi");
		 insertD("Use the arrow keys to navigatilate to the Record button and pressity press Z.","Nekocchi");
		 insertD("Use the arrow keys and Z for other menu options too!!! (OuO)->-","Nekocchi");
		 insertD("I know how to be a lawyer, just let me handle this.","Ouran Forenz");
		 insertD("Besides I can't do that right now, we need to listen. Wait until Cross-Examination.","Ouran Forenz");
		 insertD("Well sumimasen Ouran-kun I guess you are a professional or something'","Nekocchi");
		 insertD("I am.","Ouran Forenz");
		 insertV(1,(String)null);
		 insertD("(I should check the court record frequently. All the information I could ever need is in there.)","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertR("Al Protecc","alProfile","Night guard at Fat Stacks Bank",true,6);
		 insertD("I got more for you. The victim was Al Protecc, a security guard at Fat Stacks Bank.","Det. Pat. Bluthund");
		 insertD("Here's a photo of him when he was alive.", "Det. Pat. Bluthund");
		 insertR("Photo of Al","photoalprotecc","Al holding a coffee cup in his left hand when he was alive.",false,7); //inserts photo of Al
		 insertData("You got the Photo of Al.");
		 insertD("He was murdered within Fat Stacks Bank in the back employee area.","Det. Pat Bluthund");
		 insertD("A witness found the body the next morning. His dying message implicates your client a lot.", "Det. Pat. Bluthund");
		 showAni("Photo of Body","albodypic",0,false); //plays animation of picture of body
		 insertD("Clear as day, written right there is the name of your client.","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("I'm a little confused. My client's name is Gilligan Tam not 'Gill T'....","Ouran Forenz");
		 insertD("Oh...","Ouran Forenz");
		 insertV(3,"Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertR("Gilligan Tam", "gilliganProfile", "A teller at Fat Stacks Bank.",true,8);
		 insertD("THATS ME!!!","Gilligan Tam");
		 insertV(1,(String)null);
		 insertD("Gilligan, you shouldn't be speaking. I'm your attorney, you need to leave it to me.","Ouran Forenz");
		 insertV(3,"Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertD("Well I just wanted to let you know that Gill is my nickname. I'm Gill T!","Gilligan Tam");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("THAT'S A CONFESSION!!!","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("(This isn't going well...)","Ouran Forenz");
		 insertR("Photo of Body","albodypic","Dying message by right hand that reads 'Gill T'.",false,9);
		 insertData("You got the Photo of the Body.");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("The murder weapon was a stick found at the scene. It was covered in Mr. Protecc's blood.","Det. Pat. Bluthund");
		 insertV(4,(String)null);
		 insertD("OwO B-blood???","Nekocchi");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Yes blood. This was a murder after all.","Det. Pat. Bluthund");
		 insertV(4,(String)null);
		 insertD("Nani-desu? No one told me someone got murdered desu~~ <~_~>","Nekocchi");
		 insertD("I told you multiple times. You reacted like this every time, how can you not remember?","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Anyway the stick was nothing special. Just something from outside on the ground.","Det. Pat. Bluthund");
		 insertR("Big Stick","bigStick","Just a big stick. Murder weapon.",false,10);
		 insertData("You got the Big Stick.");
		 insertV(2,(String)null);
		 insertD("Thank you Detective. Can you testify about some of your reasoning?","Mel Practiss");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Sure can!","Det. Pat. Bluthund");
		 runFirstExamine(0); // runs beginning of cross-examination
		 insertD("That's it...","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,(String)null);
		 insertD("Detective, you said Al must have died from 5:30-6:00 correct?","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Yeah, so?", "Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("Well there's where you're wrong!", "Ouran Forenz");
		 insertD("According to this autopsy report the victim died sometime between 9:45-10:30 PM.","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Hontou?!?! Great job Ouran desu~~","Nekocchi");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("AHAHAHAHAHAHAHA","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("What's so funny?","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Well I was just testing you Mr. Forenz.","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("(Really? Just a test? Sure')","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("You don't think I know that?","Det. Pat. Bluthund");
		 insertD("He did check out of work though. We have a record of that. Here.","Det. Pat. Bluthund");
		 insertR("Work Record","workRecord","Gilligan ended work at 5:30 and Al started at 5:30.",false,11);
		 insertData("You got the Work Record.");
		 insertV(2,(String)null);
		 insertD("Well this is news to me!?!","Mel Practiss");
		 insertD("Detective please don't lie on the stand'","Mel Practiss");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("No problem. Besides we have evidence showing him entering the bank at 9:50 PM.","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("Hmmm...?","Ouran Forenz");
		 insertD("WHAT!!?!??!?","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Nani?! OwO","Nekocchi");
		 insertV(2,(String)null);
		 insertD("Y-yes now I remember'","Mel Practiss");
		 insertD("Cameras within the bank monitor all routes to the employee area where the corpse was found.","Mel Practiss");
		 insertD("Security Cameras caught Gilligan entering the back of the bank at 9:50 PM.","Mel Practiss");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Yes. They also caught him leaving at 10:00 PM.","Det. Pat. Bluthund");
		 insertD("Al Protecc was shown on the cameras at 5:30 when he started his shift.","Det. Pat. Bluthund");
		 insertD("The cameras don't show anyone else.","Det. Pat. Bluthund");
		 insertV(4,(String)null);
		 insertD("Itai","Nekocchi");
		 insertV(1,(String)null);
		 insertD("Oh no desu...","Ouran Forenz");
		 insertD("Wait... ignore that.","Ouran Forenz");
		 insertD("(Nekocchi's a bad influence on me...)","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Well this isn't good at all nyan.","Nekocchi");
		 insertR("Security Footage","securityFootage","Shows only Gilligan and Al entering the back of the bank.",false,12);
		 insertData("You got the Security Footage.");
		 insertV(2,(String)null);
		 insertD("Well now Judge, between the dying message and this footage, I believe we are ready for a verdict'","Mel Practiss");
		 insertV(0,(String)null);
		 insertD("Hmmm, I suppose you're right'","Judge Judge");
		 insertV(1,(String)null);
		 insertD("Wait, Detective. Why don't you testify about the dying message.","Ouran Forenz");
		 insertD("I'd like to hear more about that.","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("No problem. Now listen and listen well.","Det. Pat. Bluthund");
		 runFirstExamine(1);
		 insertD("That's it...","Ouran Forenz");
		 runExamine(2);
		 insertD("That's it...","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,(String)null);
		 insertD("Detective it seems you've made an error.","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Huh, in what way.","Det. Pat. Bluthund");
		 insertV(2,(String)null);
		 insertD("I see. You claim the victim is left handed since he's holding the mug in his left hand.","Mel Practiss");
		 insertV(1,(String)null);
		 insertD("Yeah... (How did he know that's what I was going to say?)","Ouran Forenz");
		 insertV(2,(String)null);
		 insertD("I noticed that as well, so I looked into it beforehand.","Mel Practiss");
		 insertD("Testimony from family and friends state that he is ambidextrous.","Mel Practiss");
		 insertD("He can use both his left and right hands.","Mel Practiss");
		 insertV(1,(String)null);
		 insertD("Now you're just making up words!","Ouran Forenz");
		 insertV(2,(String)null);
		 insertD("What?","Mel Practiss");
		 insertV(1,(String)null);
		 insertD("Am-bee-dex-ter-us? You think a made up word like that will fly?","Ouran Forenz");
		 insertD("This is a court of law, act serious.","Ouran Forenz");
		 insertD("Honestly, being able to use both hands. Ridiculous.","Ouran Forenz");
		 insertV(0,(String)null);
		 insertD("Ummm, Mr. Forenz?","Judge Judge");
		 insertV(1,(String)null);
		 insertD("Yes your honor?","Ouran Forenz");
		 insertV(0,(String)null);
		 insertD("What on earth are you talking about? Do you really not know the word ambidextrous?","Judge Judge");
		 insertV(1,(String)null);
		 insertD("Wait...","Ouran Forenz");
		 insertD("What?","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Even I know that you baka ~~nyan~~UwU","Nekocchi");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Yeah really man. That won't work.","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("Ok fine, I concede that this word exists, and that the victim was...","Ouran Forenz");
		 insertD("Ambeedextrus.","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Close enough.","Nekocchi");
		 insertV(1,(String)null);
		 insertD("(Crap! What do I do now? I'm out of leads...)","Ouran Forenz");
		 insertD("I have news! I bear this updated autopsy report and humbly present it to court.","Bailiff");
		 insertD("So that it's wonder and magnificence may shine upon all within this room.","Bailiff");
		 insertD("Thank you?","Ouran Forenz");
		 insertR("Autopsy Report","autopsy","Blunt Force Trauma to back of head, 9:45-10:30 PM. Died instantly.",false,5);
		 insertData("The Autopsy Report was updated.");
		 insertD("Maybe this contains some new information. I should read it over.","Ouran Forenz");
		 insertV(0,(String)null);
		 insertD("Detective Bluthund please resume your testimony.","Judge Judge");
		 runExamine(3);
		 insertD("That's it...","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,(String)null);
		 insertD("Tsk tsk Bluthund...","Ouran Forenz");
		 insertD("Your initial logic may have been sound, but I shall gloriously point out this contradiction.","Ouran Forenz");
		 insertD("GLORIOUS","Bailiff");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Geez, just get on with it.","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("It is your claim that after being hit, the victim wrote a dying message.","Ouran Forenz");
		 insertD("However according to this new autopsy, the victim died instantly!","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("WOOF!!!","Det. Pat. Bluthund");
		 insertD("I guess you're right!","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("So are you saying my client would implicate himself?","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Smart criminals try to do things a criminal would never do.","Det. Pat. Bluthund");
		 insertD("I've had cases where the criminal is the one to call the cops.","Det. Pat. Bluthund");
		 insertD("It's an attempt to divert suspicion.","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("Come on Detective!","Ouran Forenz");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("But I will concede, this is a pretty big blow to the prosecution's case...","Det. Pat. Bluthund");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("But I will concede, this is a pretty big blow to the prosecution's case...","Det. Pat. Bluthund");
		 insertV(2,(String)null);
		 insertD("Not so fast...","Mel Practiss");
		 insertD("I have...","Mel Practiss");
		 insertD("A f-few things...","Mel Practiss");
		 insertV(1,(String)null);
		 insertD("Like what?","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("I haven't had a line in a while desu~~","Nekocchi");
		 insertV(2,(String)null);
		 insertD("I have a witness to call.","Mel Practiss");
		 insertD("Security guard on the day shift, Enrico Nocent.","Mel Practiss");
		 insertV(0,(String)null);
		 insertD("I see. We will take a short 15 minute recess then reconvene. Court is dismissed.","Judge Judge");
		 insertV(5,"Nekocchi");
		 playAni("Nekocchi","nekocchiWitness",0,false);
		 insertData("---Defendant's Lobby C May 22nd, 3:01---");
		 insertD("Lobby C huh? I thought there were only two lobbies...","Ouran Forenz");
		 insertD("Me too desu. Guess not OwO.","Nekocchi");
		 insertV(5, "Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertD("Thanks Forenz!", "Gilligan Tam");
		 insertD("We aren't out of the woods yet.","Ouran Forenz");
		 insertV(5,"Nekocchi");
		 playAni("Nekocchi","nekocchiWitness",0,false);
		 insertD("Woods! I'm afraid of trees!","Nekocchi");
		 insertData("Nekocchi flees.");
		 insertV(5,"Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertD("I think we can do this. I believe in your innocence.","Ouran Forenz");
		 insertD("Thanks.","Gilligan Tam");
		 insertD("We never got a good chance to talk. What exactly happened when you went into the bank that night.","Ouran Forenz");
		 insertD("Well I had left some papers in the back. But I didn't know where.","Gilligan Tam");
		 insertD("I saw Al alive when I went. He helped me find the papers.","Gilligan Tam");
		 insertD("I left right away once I found them.","Gilligan Tam");
		 insertD("So he was alive at the time.","Ouran Forenz");
		 insertD("Court is reconvening gloriously.","Bailiff");
		 insertD("Good, Nekocchi isn't back yet.","Ouran Forenz");
		 insertV(5,"Nekocchi");
		 playAni("Nekocchi","nekocchiWitness",0,false);
		 insertD("Did you summon me Ouran-kun nyan desu OwU","Nekocchi");
		 insertD("(Why...)","Ouran Forenz");
		 insertV(0,(String)null);
		 insertData("---Courtroom A May 22nd, 3:09---");
		 insertD("Court is now in session.","Judge Judge");
		 insertD("Prosecution, you had a witness to call I believe.","Judge Judge");
		 insertV(2,(String)null);
		 insertD("The prosecution now calls Enrico Nocent to the stand.","Mel Practiss");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertR("Enrico Nocent","enricoProfile","Day guard at Fat Stacks Bank",true,13);
		 insertData("Enrico Nocent");
		 insertD("Hellllllllooooo.","Enrico Nocent");
		 insertD("Enrico Nocent is my name, but you can call me En.","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("We will not.","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("I will En-chan desu.","Nekocchi");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Niiice.","Enrico Nocent");
		 insertV(2,(String)null);
		 insertD("Please maybe state your profession?","Mel Practiss");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("I'm a guard on the day shift at Fat Stacks Banking.","Enrico Nocent");
		 insertV(2,(String)null);
		 insertD("Please testify about the security at Fat Stacks.","Mel Practiss");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Will do. I know that Gill T is guilty.","Enrico Nocent");
		 insertD("Besides I need to finish up here quickity quick.","Enrico Nocent");
		 insertD("I think I left some coookiesssss in my ovveeennn.","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Why? You knew you were going to be here. Why did you start baking cookies?","Ouran Forenz");
		 insertV(0,(String)null);
		 insertD("Please Mr. Forenz, save it for the cross-examination.","Judge Judge");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("By the way have this diagram of the bank's floor plan.","Enrico Nocent");
		 insertD("It should help you simpletons follow along.","Enrico Nocent");
		 insertV(4,(String)null);
		 insertD("Hooray!","Nekocchi");
		 insertR("Bank Floorplan","floorPlan","Floorplan of Fat Stacks. Cameras and Body shown.",false,14);
		 insertData("You got the floorplan.");
		 insertV(0,(String)null);
		 insertD("Please begin your testimony Mr. Nocent.","Judge Judge");
		 runFirstExamine(4);
		 insertD("(Figured it out...)","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,(String)null);
		 insertD("Witness, I believe you've made a strong assumption...","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Huh? In what way?","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("If Gilligan truly was planning on murdering Al...","Ouran Forenz");
		 insertD("He would have the murder weapon in his possession.","Ouran Forenz");
		 insertD("But the security footage clearly shows him holding only a single briefcase!","Ouran Forenz");
		 insertV(2,(String)null);
		 insertD("The stick was in the briefcase.","Mel Practiss");
		 insertV(1,(String)null);
		 insertD("What...","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Nani?","Nekocchi");
		 insertV(2,(String)null);
		 insertD("Well, i-if you make the stick diagonal, it can... can fit in the briefcase perfectly...","Mel Practiss");
		 insertD("This w-was tested before the trial...","Mel Practiss");
		 insertV(1,(String)null);
		 insertD("WHAT!!!","Ouran Forenz");
		 insertV(2,(String)null);
		 insertD("The prosecution's case is clear. We request... a verdict I g-guess'","Mel Practiss");
		 insertV(1,(String)null);
		 insertD("Wait I'm not finished!","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("But weren't there papers in there?","Nekocchi");
		 insertD("What, in the briefcase?","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("No way. He'd left his papers in the back of the bank that night. His briefcase was totally free.","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("(What did he just say?)","Ouran Forenz");
		 insertD("Mr. Nocent, how do you know that?","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Know what?","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("I don't believe you were informed of that fact.","Ouran Forenz");
		 insertD("The fact that Gilligan Tam left papers at the bank that night.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Oh I uh...","Enrico Nocent");
		 insertD("I probably overheard it from somewhere...","Enrico Nocent");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Hang on. Don't go saying that. I properly sequestered ya I while ago, you heard nothing of the sort!","Det. Pat. Bluthund");
		 insertV(1,(String)null);
		 insertD("Thank you Detective.","Ouran Forenz");
		 insertD("(He really is man's best friend.)","Ouran Forenz");
		 insertD("Mr. Nocent, how did you find out?","Ouran Forenz");insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Ummm....","Enrico Nocent");
		 insertD("Oh!","Enrico Nocent");
		 insertD("I remember now. I remember clearly.","Enrico Nocent");
		 insertV(0,(String)null);
		 insertD("Please tell the court how you are aware of Gilligan's misplaced papers.","Judge Judge");
		 insertV(1,(String)null);
		 insertD("I have him now.","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Are you bluffing again? Stop doing that nyan.~~~~~~","Nekocchi");
		 insertD("No I swear this time I'm not.","Ouran Forenz");
		 insertD("Hontou? Sounds sugoi suspicious...","Nekocchi");
		 insertD("That's not how you use sugoi... you know what, I don't care.","Ouran Forenz");
		 insertD("Let's get on with the testimony already.","Ouran Forenz");
		 runFirstExamine(5);
		 insertD("(I got him now...)","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,(String)null);
		 insertD("Enrico your story makes as much sense as a bank...","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("But banks make cents...","Nekocchi");
		 insertV(1,(String)null);
		 insertD("Ummm... ACTUALLY.","Ouran Forenz");
		 insertD("Mints are the facilities that produce currency.","Ouran Forenz");
		 insertD("Banks merely store it and use it for things such as loans.","Ouran Forenz");
		 insertD("Mints provide money to banks, but the banks don’t make the money themselves.","Ouran Forenz");
		 insertD("In fact while mints do make cents, many believe that mints should cease production of one cent coins.","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Ouran-kun...","Nekocchi");
		 insertV(1,(String)null);
		 insertD("Since one cent coins actually cost two cents to make...","Ouran Forenz");
		 insertD("It is actually a financial detriment to continue this.","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Ouran-kun, pls stop Owo.","Nekocchi");
		 insertV(1,(String)null);
		 insertD("What?","Ouran Forenz");
		 insertV(0,(String)null);
		 insertD("What was your objection again?","Judge Judge");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("I think he was saying I work at a mint?","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("No I’m saying your story is flawed.","Ouran Forenz");
		 insertD("You claim you got off work at the same time as my client. 5:00 you said.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Yeaaah, what is the issueeee.","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Well according to this work log, Mr. Tam didn’t get off of work until 5:30.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("aawwWWAAAAAA","Enrico Nocent");
		 insertV(4,(String)null);
		 insertD("Sugoi contradiction Ouran-kun! ~~nyan-desu","Nekocchi");
		 insertV(0,(String)null);
		 insertD("Mr. Nocent, how did you know Gilligan Tam was there that night to gather papers.","Judge Judge");
		 insertV(3,new AnimData("Det. Pat. Bluthund", "bluthundTalk", 2, true));
		 
		 insertD("Yeah. You gotta explain yourself.","Det. Pat. Bluthund");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Ahhhhh... Ummmmmm...","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("I think I might have an answer...","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("This sounds like a bluff Ouran.","Nekocchi");
		 insertD("Absolutely not (.... well yeah pretty much.)","Ouran Forenz");
		 insertD("Enrico Nocent... There is only one way you could have known about Gilligan’s papers...","Ouran Forenz");
		 insertD("You were at Fat Stacks Bank that night, weren’t you!","Ouran Forenz");
		 insertD("You saw him going back for the papers in person!","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("uwwaAAAAAAHHHH","Enrico Nocent");
		 insertV(2,(String)null);
		 insertD("Wait wait... Mr. Forenz... That’s going a b-b-b-b-bit far?","Mel Practiss");
		 insertV(1,(String)null);
		 insertD("NO! IT’S THE ONLY EXPLANATION!!!","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("B-but I'm not on the security tapes...","Enrico Nocent");
		 insertV(2,(String)null);
		 insertD("Y-y-yes! Testify about that.","Mel Practiss");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("I shall.","Enrico Nocent");
		 runFirstExamine(6);
		 insertD("(Aha...)","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,(String)null);
		 insertD("I know you were there that night Nocent.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Didn’t you hear me? The security...","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Has no blind spots? Think again.","Ouran Forenz");
		 insertD("You know better than anyone here that there is a blind spot.","Ouran Forenz");
		 insertD("From the security door, a blindspot exists within the cameras.","Ouran Forenz");
		 insertD("This floorplan proves it.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("AAAHHHHHHH!!!","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Only security personel such as yourself could enter.","Ouran Forenz");
		 insertD("And as you testified, you know the ins and outs of the security system.","Ouran Forenz");
		 insertD("You could have snuck into the bank undetected.","Ouran Forenz");
		 insertD("You could have seen Gilligan gathering is papers.","Ouran Forenz");
		 insertD("And you could have murdered Al Protecc!!!","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("N-N-N-N-N-NOOOOOOOOOO!!!","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Just admit it already.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("F-f-fine I admit...","Enrico Nocent");
		 insertD("I was there that night. I saw Gilligan.","Enrico Nocent");
		 insertD("I saw him murder Al!","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Wh-","Ouran Forenz");
		 insertD("What???","Ouran Forenz");
		 insertD("You are just lying now. Just give up.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("I'm telling the truth. I'll tell the truth now. The whole truth.","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Why didn't you say this earlier? What reason did you have to hide it.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("Well, it made me sound suspicious.","Enrico Nocent");
		 insertD("Plus, since I don't show up on the security footage, I was worried the police would suspect me.","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Why weren't you on the security cameras then?","Ouran Forenz");
		 insertD("You should have a perfectly good reason to be going there at 10 at night.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("T-that isn't relevant","Enrico Nocent");
		 insertD("Now I will tell you exactly what I saw.","Enrico Nocent");
		 insertV(0,(String)null);
		 insertD("Please testify as to what you saw.","Judge Judge");
		 insertV(1,(String)null);
		 insertD("Wait really judge? He’s lied on the stand frequently already. You are going to let him testify more.?","Ouran Forenz");
		 insertV(0,(String)null);
		 insertD("Well since you’ve accused him of murder, we must hear his response.","Judge Judge");
		 insertV(4,(String)null);
		 insertD("Yeah Ouran-kun, gotta let that baka speak.","Nekocchi");
		 insertV(1,(String)null);
		 insertD("Ok... (Let's end this.)","Ouran Forenz");
		 runFirstExamine(7);
		 insertD("Ok, now we are getting somewhere.","Ouran Forenz");
		 runExamine(8);
		 insertD("(This is it!)","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,(String)null);
		 insertD("I've caught you in your lies Nocent.","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("What lie? I didn’t t-t-tell a lie...","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("I'd like to direct the court's attention to the autopsy.","Ouran Forenz");
		 insertV(2,(String)null);
		 insertD("This again? How much information could you possibly get from that one file?","Mel Practiss");
		 insertV(1,(String)null);
		 insertD("As a forensic investigator, I can get all the information I want.","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("You never told me you were a forensic investigator.","Nekocchi");
		 insertD("Yes I did. You just never listen to me.","Ouran Forenz");
		 insertD("What did you say?","Nekocchi");
		 insertV(1,(String)null);
		 insertD("Anyways... Mr. Nocent testified that Gilligan Tam hit Mr. Protecc in the back of the head.","Ouran Forenz");
		 insertD("But according to the autopsy the wound was to the top of the head!","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("uuuWWAAAGGHH","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("It’s funny really. Someone as short as Gilligan...","Ouran Forenz");
		 insertD("He would have a hard time hitting someone on the top of the head huh?","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("W-w-well it c-could happen...","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("No not likely. Especially against a trained security guard.","Ouran Forenz");
		 insertD("It’s far more likely an injury like that was caused by someone of an appropriate height.","Ouran Forenz");
		 insertD("Mr. Nocent, you are of the appropriate height.","Ouran Forenz");
		 insertD("Mr. Nocent, you were at the bank at the night of the murder","Ouran Forenz");
		 insertD("Mr. Nocent, you intentionally avoided security cameras.","Ouran Forenz");
		 insertD("Mr. Nocent, you killed Al Protecc, didn't you!","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("No no... I wasn’t robbing the bank...","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Wait, were you trying to rob the bank?","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("No I didn’t... I just.... Please........","Enrico Nocent");
		 insertD("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!!!!!!!!!!!","Enrico Nocent");
		 //Insert breakdown animation if that ever happens
		 //More comment to make this stand out more when scrolling
		 //lalalalala
		 //lalalalalalal
		 //lalalalalalalallalal
		 insertD("...","Enrico Nocent");
		 insertD("Fine... I killed him.","Enrico Nocent");
		 insertD("No use hiding it.","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("But why?","Ouran Forenz");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertD("I don't need to tell you anything.","Enrico Nocent");
		 insertV(1,(String)null);
		 insertD("Well “En”, I guess En Nocent was guilty after all.","Ouran Forenz");
		 insertV(4,(String)null);
		 insertD("Yeah Ouran, we all get the puns you don’t need to point them out you baka ~~nyandesu.","Nekocchi");
		 insertV(0,(String)null);
		 insertD("Well Mr. Forenz great work. You’ve sufficiently proved your client Gilligan Tam could not have committed the crime.","Judge Judge");
		 insertD("I shall hand down my verdict.","Judge Judge");
		 insertData("NOT GUILTY");
		 //Add Not guilty maybe?
		 insertD("Court is now adjourned.","Judge Judge");
		 insertV(5,"Gilligan Tam");
		 insertData("--Defendant’s Lobby C May 22nd, 3:57---");
		 insertD("We did it!!! Sugoi!!! Hooray!!!","Nekocchi");
		 insertD("Yes yes, I did it. You were standing next to me.","Ouran Forenz");
		 insertD("It’s called emotional support Ouran-kun... You baka...","Nekocchi");
		 insertD("Thanks pal... You’re a lifesaver.","Gilligan Tam");
		 insertD("Don’t mention it. Just doing my job. Defending those who are wrongly accused.","Ouran Forenz");
		 insertD("Really though. Who knew my height would save me in the end.","Gilligan Tam");
		 insertD("Well it’s simple forensic analysis. I knew you couldn't have done it as soon as I got the updated autopsy.","Ouran Forenz");
		 insertD("You were thinking that far ahead?","Gilligan Tam");
		 insertD("Yes. forensic analysis can cover a wide range of topics, all help us get much closer to the truth.","Ouran Forenz");
		 insertD("I just love forensics, I use them for everything. Just spread the word, that forensics saved you.","Ouran Forenz");
		 insertD("Nah man, you saved me. Forensics helped, but you were the one who...","Gilligan Tam");
		 insertD("NO!!!","Ouran Forenz");
		 insertD("Forensics saved you. I am a vessel for forensics to use within the criminal justice system.","Ouran Forenz");
		 insertD("I am merely the medium through which forensic science utilizes to assist in solving crimes.","Ouran Forenz");
		 insertD("Alright man if you say so. They don’t call you Forenz for nothing.","Gilligan Tam");
		 insertD("Well yeah, that’s my family name. Why is that relevant?","Ouran Forenz");
		 insertD("I was just... Never mind...","Gilligan Tam");
		 insertD("Yeah he’s weird, you can ignore him and praise me.","Nekocchi");
		 insertD("Well sorry little monstrocity, I have to leave now.","Gilligan Tam");
		 insertD("Really Forenz, thank you for everything.","Gilligan Tam");
		 insertD("I hope to meet you again in the future.","Ouran Forenz");
		 insertD("Maybe I’ll open an account at Fat Stacks?","Ouran Forenz");
		 insertD("No don’t do that.","Gilligan Tam");
		 insertD("Corporate uses the bank as a front for money laundering and drug trades. Whole thing is a scam...","Gilligan Tam");
		 insertD("Wait really?","Ouran Forenz");
		 insertD("Why did you think there was so little security?","Gilligan Tam");
		 insertD("Hmm... I should notify the police.","Ouran Forenz");
		 insertD("You really should.","Gilligan Tam");
		 insertV(69,(String)null);
		 insertD("The police later launched a full scale investigation.","Ouran Forenz");
		 insertD("Billions of dollars worth of drugs were seized and a large criminal empire was taken down.","Ouran Forenz");
		 insertD("Gilligan Tam was put into witness protection and now lives a happy life across the country.","Ouran Forenz");
		 insertD("One moment can change someone’s life. This case could have ruined Gilligan’s.","Ouran Forenz");
		 insertD("It’s my job as an attorney to make sure the truth comes out and these innocent lives remain as they are, innocent.","Ouran Forenz");
		 insertD("I’m Ouran Forenz, expert attorney at law and forensic investigator.","Ouran Forenz");
		 insertD("I will continue to pursue the truth.","Ouran Forenz");
		 insertD("That's my job.","Ouran Forenz");
		 
		}
		super.update(); // updates super
		 
	}

	@Override
	void setUP() throws IOException {
		// TODO Auto-generated method stub
		
	}
	}

