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
		characters.add(new Character("Enrico Nocent",150,0));
		if (!oneProc) // checks if the case is already running
		{
		oneProc=true; // sets the case to be running
		inCourt=true; // places case in court
		
		startCExamine(0); // starts first cross-examination
		 
		 // lists statements for cross-examination
		 Main.cExamine[Main.examineSlot].add("The body was found in the morning.", "Det. Pat. Bluthund",  new String[] {"Who discovered the body?","Can't tell you that man.","What I can tell you is that it was discovered when some people showed up for work the next morning.", "So around 9 AM?", "Yeah, around 9."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("We know Al was alive at 5:30 PM.", "Det. Pat. Bluthund",  new String[] {"How exactly do you know that?","We have a record of him checking in at work.","So was his shift ending?","No it was starting. Al was a night guard.","Right I knew that...","(I should remember to check the profile section of the court record.)","(That way I can remember who is involved in the case.)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz","Ouran Forenz"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("We also know Gill's shift ended at around the same time.", "Det. Pat. Bluthund",  new String[] {"So my client's shift ended at 5:30?","That's right! The same time as Al.","HE MUST BE THE CULPRIT!!!","Detective Bluthund, were those the only two whose shift ended at 5:30?","Nah, there were others' But still'"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("It stands to reason Gill offed him at around 5:30", "Det. Pat. Bluthund",  new String[] {"What makes you think that?","Well he was there at the same time.","And? There were other workers.","But the dying message! It must be him!","(That message. It's pretty damning evidence')","(But there was something else wrong with that statement')"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz"} , 2, "Autopsy Report",null,0);
		 Main.cExamine[Main.examineSlot].add("That's my reasoning and I'm sticking with it.", "Det. Pat. Bluthund",  new String[] {"That's awful stubborn of you.","I'm never wrong! When I find a suspect, it's always them!","Always?","Well, maybe not always'","Detective, please just stick to the facts of the case'","You got it!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 
		 stopCExamine(); // ends first cross-examination

		 
		 startCExamine(1);
		 
		 Main.cExamine[Main.examineSlot].add("When the body was found, a message was found next to him", "Det. Pat. Bluthund", new String[] {"Tell me more about the discovery.","Well another witness we have discovered the body when he went into work the next day.","Who is this witness?","AHAHAHAHA. I’m not telling you that. I have no reason to.","(If I want to know more about this mystery witness I need them on the stand…)","(I need to get through this mutt first.)"}, new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz"}, 0, null, null, 0);
		 Main.cExamine[Main.examineSlot].add("It very clearly says GILL T, that’s your client man.", "Det. Pat. Bluthund",  new String[] {"So your saying the message implicates my client?","Sure does. Look at it!","How do you know it was the victim who wrote it.","Anyone with eyes can tell. You see..."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("There’s even blood on is finger showing he wrote it.", "Det. Pat. Bluthund",  new String[] {"So, the victim wrote the message?","Sure did. Look, his right finger has blood on it.","(Right hand..?)","He wrote the message with his right hand, can’t you see?","I’d like you to add that to your testimony please.","Really? Alrighty then."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 1, null,null,0);
		 Main.cExamine[Main.examineSlot].add("He must have written the message after he got hit.", "Det. Pat. Bluthund",  new String[] {"So after he was hit with the stick he wrote the message right before his death?","Yeah pal. This is often the case.","Not everyone dies instantly. Usually they are alive for seconds or minutes after the initial trauma.","Interesting.", "Nyan?"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Nekocchi"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Luckily he did, now we can catch the culprit.", "Det. Pat. Bluthund",  new String[] {"That's conjecture!","It’s a reasonable hypothesis based off of evidence and a professional’s expert opinion.","Nyan~~desu he has a point.","Well it’s my job to prove the evidence is unreliable.","And show that my client couldn’t have done it!!!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Nekocchi","Ouran Forenz","Ouran Forenz"} , 0, null,null,0);
		 
		 stopCExamine();
		 
         startCExamine(2);
		 
		 Main.cExamine[Main.examineSlot].add("When the body was found, a message was found next to him", "Det. Pat. Bluthund", new String[] {"Tell me more about the discovery.","Well another witness we have discovered the body when he went into work the next day.","Who is this witness?","AHAHAHAHA. I’m not telling you that. I have no reason to.","(If I want to know more about this mystery witness I need them on the stand…)","(I need to get through this mutt first.)"}, new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz"}, 0, null, null, 0);
		 Main.cExamine[Main.examineSlot].add("It very clearly says GILL T, that’s your client man.", "Det. Pat. Bluthund",  new String[] {"So your saying the message implicates my client?","Sure does. Look at it!","How do you know it was the victim who wrote it.","Anyone with eyes can tell. You see..."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("There’s even blood on is finger showing he wrote it.", "Det. Pat. Bluthund",  new String[] {"So, the victim wrote the message?","Sure did. Look, his right finger has blood on it.","(Right hand..?)","He wrote the message with his right hand, can’t you see?","I’d like you to add that to your testimony please.","Really? Alrighty then."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("He wrote the message using his right hand, can’t you see?", "Det. Pat. Bluthund",  new String[] {"Your claim is that the victim wrote his dying message using his right hand?","Yup!","Jeez you just asked this. Do you have anything new to ask?","Well I guess not…","Please don’t hound the witness Mr. Forenz.","You got it... (hound?)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Judge Judge"} , 2, "Photo of Al",null,0);
		 Main.cExamine[Main.examineSlot].add("He must have written the message after he got hit.", "Det. Pat. Bluthund",  new String[] {"So after he was hit with the stick he wrote the message right before his death?","Yeah pal. This is often the case.","Not everyone dies instantly. Usually they are alive for seconds or minutes after the initial trauma.","Interesting.", "Nyan?"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Nekocchi"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("Luckily he did, now we can catch the culprit.", "Det. Pat. Bluthund",  new String[] {"That's conjecture!","It’s a reasonable hypothesis based off of evidence and a professional’s expert opinion.","Nyan~~desu he has a point.","Well it’s my job to prove the evidence is unreliable.","And show that my client couldn’t have done it!!!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Nekocchi","Ouran Forenz","Ouran Forenz"} , 0, null,null,0);
		 
		 stopCExamine();
		 
		 startCExamine(3);
		 
		 Main.cExamine[Main.examineSlot].add("When the body was found, a message was found next to him", "Det. Pat. Bluthund", new String[] {"Tell me more about the discovery.","Well another witness we have discovered the body when he went into work the next day.","Who is this witness?","AHAHAHAHA. I’m not telling you that. I have no reason to.","(If I want to know more about this mystery witness I need them on the stand…)","(I need to get through this mutt first.)"}, new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Ouran Forenz"}, 0, null, null, 0);
		 Main.cExamine[Main.examineSlot].add("It very clearly says GILL T, that’s your client man.", "Det. Pat. Bluthund",  new String[] {"So your saying the message implicates my client?","Sure does. Look at it!","How do you know it was the victim who wrote it.","Anyone with eyes can tell. You see..."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz", "Det. Pat. Bluthund"} , 0, null , null,0);
		 Main.cExamine[Main.examineSlot].add("There’s even blood on is finger showing he wrote it.", "Det. Pat. Bluthund",  new String[] {"So, the victim wrote the message?","Sure did. Look, his right finger has blood on it.","(Right hand..?)","He wrote the message with his right hand, can’t you see?","I’d like you to add that to your testimony please.","Really? Alrighty then."} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund","Ouran Forenz","Det. Pat. Bluthund"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("He wrote the message using his right hand, can’t you see?", "Det. Pat. Bluthund",  new String[] {"Your claim is that the victim wrote his dying message using his right hand?","Yup!","Jeez you just asked this. Do you have anything new to ask?","Well I guess not…","Please don’t hound the witness Mr. Forenz.","You got it... (hound?)"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Judge Judge"} , 0, null,null,0);
		 Main.cExamine[Main.examineSlot].add("He must have written the message after he got hit.", "Det. Pat. Bluthund",  new String[] {"So after he was hit with the stick he wrote the message right before his death?","Yeah pal. This is often the case.","Not everyone dies instantly. Usually they are alive for seconds or minutes after the initial trauma.","Interesting.", "Nyan?"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Det. Pat. Bluthund","Ouran Forenz","Nekocchi"} , 2, "Autopsy Report",null,0);
		 Main.cExamine[Main.examineSlot].add("Luckily he did, now we can catch the culprit.", "Det. Pat. Bluthund",  new String[] {"That's conjecture!","It’s a reasonable hypothesis based off of evidence and a professional’s expert opinion.","Nyan~~desu he has a point.","Well it’s my job to prove the evidence is unreliable.","And show that my client couldn’t have done it!!!"} ,  new String[] {"Ouran Forenz","Det. Pat. Bluthund","Nekocchi","Ouran Forenz","Ouran Forenz"} , 0, null,null,0);
		 
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
		 insertV(0, null);
		 insertData("---Courtroom A  May 22nd, 2:34 PM.---");
		 insertD("Court is now in session for the trial of Gilligan Tam. Is the prosecution ready?","Judge Judge");
		 insertV(2,null);
		 insertR("Mel Practiss", "melProfile", "A nervous but decently proficient prosecutor... Maybe.",true,3);
		 insertD("The prosecution is' r-r-ready... maybe.", "Mel Practiss");
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
		 insertD("Ummm, that's a dog'", "Ouran Forenz");
		 insertV(2,null);
		 insertD("What are you talking about, this is Detective Patrick Bluthund?", "Mel Practiss");
		 insertV(1,null);
		 insertD("That's a dog in a trench coat are you blind?", "Ouran Forenz");
		 insertV(0,null);
		 insertD("I will not have you slander the witness this way Mr. Forenz.", "Judge Judge");
		 insertD("This is one of the best detectives in the homicide division.","Judge Judge");
		 insertV(1,null);
		 insertD("He even said he sniffs out criminals. That is an anthropomorphic dog.","Ouran Forenz");
		 insertV(4,null);
		 insertD("Ummm Ouran-san, I think you should stop now.","Nekocchi");
		 insertD("Your being a bigger baka than normal nyan-desu~~","Nekocchi");
		 insertV(1,null);
		 insertD("Ahhh' Ok whatever. As long as he does his job.","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Don't worry man, I get it a lot for some reason. I'm used to it.","Det. Pat. Bluthund");
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
		 insertD("Well sumimasen Ouran-kun I guess you are a professional or something'","Nekocchi");
		 insertD("I am.","Ouran Forenz");
		 insertV(1,null);
		 insertD("(I should check the court record frequently. All the information I could ever need is in there.)","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertR("Al Protecc","alProfile","Night guard at Fat Stacks Bank",true,6);
		 insertD("I got more for you. The victim was Al Protecc, a security guard at Fat Stacks Bank.","Det. Pat. Bluthund");
		 insertD("Here's a photo of him when he was alive.", "Det. Pat. Bluthund");
		 insertR("Photo of Al","photoalprotecc","Al holding a coffee cup in his left hand when he was alive.",false,7); //inserts photo of Al
		 insertData("You got the Photo of Al.");
		 insertD("He was murdered within Fat Stacks Bank in the back employee area.","Det. Pat Bluthund");
		 insertD("A witness found the body the next morning. His dying message implicates your client a lot.", "Det. Pat. Bluthund");
		 insertData("You got the Photo of the Body.");
		 showAni("Photo of Body","albodypic",0,false); //plays animation of picture of body
		 insertD("Clear as day, written right there is the name of your client.","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("I'm a little confused. My client's name is Gilligan Tam not 'Gill T'....","Ouran Forenz");
		 insertD("Oh...","Ouran Forenz");
		 insertV(3,"Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertR("Gilligan Tam", "gilliganProfile", "A teller at Fat Stacks Bank.",true,8);
		 insertD("THATS ME!!!","Gilligan Tam");
		 insertV(1,null);
		 insertD("Gilligan, you shouldn't be speaking. I'm your attorney, you need to leave it to me.","Ouran Forenz");
		 insertV(3,"Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertD("Well I just wanted to let you know that Gill is my nickname. I'm Gill T!","Gilligan Tam");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("THAT'S A CONFESSION!!!","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("(This isn't going well...)","Ouran Forenz");
		 insertR("Photo of Body","albodypic","Dying message by right hand that reads 'Gill T'.",false,9);
		 insertData("You got the Photo of the Body.");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("The murder weapon was a stick found at the scene. It was covered in Mr. Protecc's blood.","Det. Pat. Bluthund");
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
		 insertR("Big Stick","bigStick","Just a big stick. Murder weapon.",false,10);
		 insertData("You got the Big Stick.");
		 insertV(2,null);
		 insertD("Thank you Detective. Can you testify about some of your reasoning?","Mel Practiss");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Sure can!","Det. Pat. Bluthund");
		 runFirstExamine(0); // runs beginning of cross-examination
		 insertD("That's it...","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,null);
		 insertD("Detective, you said Al must have died from 5:30-6:00 correct?","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Yeah, so?", "Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("Well there’s where you’re wrong!", "Ouran Forenz");
		 insertD("According to this autopsy report the victim died sometime between 9:45-10:30 PM.","Ouran Forenz");
		 insertV(4,null);
		 insertD("Hontou?!?! Great job Ouran desu~~","Nekocchi");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("AHAHAHAHAHAHAHA","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("What's so funny?","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Well I was just testing you Mr. Forenz.","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("(Really? Just a test? Sure…)","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("You don’t think I know that?","Det. Pat. Bluthund");
		 insertD("He did check out of work though. We have a record of that. Here.","Det. Pat. Bluthund");
		 insertR("Work Record","workRecord","Gilligan ended work at 5:30 and Al started at 5:30.",false,11);
		 insertData("You got the Work Record.");
		 insertV(2,null);
		 insertD("Well this is news to me!?!","Mel Practiss");
		 insertD("Detective please don’t lie on the stand…","Mel Practiss");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("No problem. Besides we have evidence showing him entering the bank at 9:50 PM.","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("Hmmm...?","Ouran Forenz");
		 insertD("WHAT!!?!??!?","Ouran Forenz");
		 insertV(4,null);
		 insertD("Nani?! OwO","Nekocchi");
		 insertV(2,null);
		 insertD("Y-yes now I remember…","Mel Practiss");
		 insertD("Cameras within the bank monitor all routes to the employee area where the corpse was found.","Mel Practiss");
		 insertD("Security Cameras caught Gilligan entering the back of the bank at 9:50 PM.","Mel Practiss");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Yes. They also caught him leaving at 10:00 PM.","Det. Pat. Bluthund");
		 insertD("Al Protecc was shown on the cameras at 5:30 when he started his shift.","Det. Pat. Bluthund");
		 insertD("The cameras don’t show anyone else.","Det. Pat. Bluthund");
		 insertV(4,null);
		 insertD("Itai","Nekocchi");
		 insertV(1,null);
		 insertD("Oh no desu...","Ouran Forenz");
		 insertD("Wait... ignore that.","Ouran Forenz");
		 insertD("(Nekocchi's a bad influence on me...)","Ouran Forenz");
		 insertV(4,null);
		 insertD("Well this isn't good at all nyan.","Nekocchi");
		 insertR("Security Footage","securityFootage","Shows only Gilligan and Al entering the back of the bank.",false,12);
		 insertData("You got the Security Footage.");
		 insertV(2,null);
		 insertD("Well now Judge, between the dying message and this footage, I believe we are ready for a verdict…","Mel Practiss");
		 insertV(0,null);
		 insertD("Hmmm, I suppose you’re right…","Judge Judge");
		 insertV(1,null);
		 insertD("Wait, Detective. Why don’t you testify about the dying message.","Ouran Forenz");
		 insertD("I'd like to hear more about that.","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("No problem. Now listen and listen well.","Det. Pat. Bluthund");
		 runFirstExamine(1);
		 insertD("That's it...","Ouran Forenz");
		 runExamine(2);
		 insertD("That's it...","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,null);
		 insertD("Detective it seems you’ve made an error.","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Huh, in what way.","Det. Pat. Bluthund");
		 insertV(2,null);
		 insertD("I see. You claim the victim is left handed since he’s holding the mug in his left hand.","Mel Practiss");
		 insertV(1,null);
		 insertD("Yeah... (How did he know that’s what I was going to say?)","Ouran Forenz");
		 insertV(2,null);
		 insertD("I noticed that as well, so I looked into it beforehand.","Mel Practiss");
		 insertD("Testimony from family and friends state that he is ambidextrous.","Mel Practiss");
		 insertD("He can use both his left and right hands.","Mel Practiss");
		 insertV(1,null);
		 insertD("Now you're just making up words!","Ouran Forenz");
		 insertV(2,null);
		 insertD("What?","Mel Practiss");
		 insertV(1,null);
		 insertD("Am-bee-dex-ter-us? You think a made up word like that will fly?","Ouran Forenz");
		 insertD("This is a court of law, act serious.","Ouran Forenz");
		 insertD("Honestly, being able to use both hands. Ridiculous.","Ouran Forenz");
		 insertV(0,null);
		 insertD("Ummm, Mr. Forenz?","Judge Judge");
		 insertV(1,null);
		 insertD("Yes your honor?","Ouran Forenz");
		 insertV(0,null);
		 insertD("What on earth are you talking about? Do you really not know the word ambidextrous?","Judge Judge");
		 insertV(1,null);
		 insertD("Wait...","Ouran Forenz");
		 insertD("What?","Ouran Forenz");
		 insertV(4,null);
		 insertD("Even I know that you baka ~~nyan~~UwU","Nekocchi");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Yeah really man. That won’t work.","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("Ok fine, I concede that this word exists, and that the victim was...","Ouran Forenz");
		 insertD("Ambeedextrus.","Ouran Forenz");
		 insertV(4,null);
		 insertD("Close enough.","Nekocchi");
		 insertV(1,null);
		 insertD("(Crap! What do I do now? I’m out of leads...)","Ouran Forenz");
		 insertD("I have news! I bear this updated autopsy report and humbly present it to court.","Bailiff");
		 insertD("So that it’s wonder and magnificence may shine upon all within this room.","Bailiff");
		 insertD("Thank you?","Ouran Forenz");
		 insertR("Autopsy Report","autopsy","Cause of Death: Blunt Force Trauma, 9:45-10:30 PM. Died instantly.",false,5);
		 insertData("The Autopsy Report was updated.");
		 insertD("Maybe this contains some new information. I should read it over.","Ouran Forenz");
		 insertV(0,null);
		 insertD("Detective Bluthund please resume your testimony.","Judge Judge");
		 runExamine(3);
		 insertD("That's it...","Ouran Forenz");
		 insertO(0);
		 insertD("OBJECTION!!!","Ouran Forenz");
		 removeO();
		 insertV(1,null);
		 insertD("Tsk tsk Bluthund...","Ouran Forenz");
		 insertD("Your initial logic may have been sound, but I shall gloriously point out this contradiction.","Ouran Forenz");
		 insertD("GLORIOUS","Bailiff");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Geez, just get on with it.","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("It is your claim that after being hit, the victim wrote a dying message.","Ouran Forenz");
		 insertD("However according to this new autopsy, the victim died instantly!","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("WOOF!!!","Det. Pat. Bluthund");
		 insertD("I guess you're right!","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("So are you saying my client would implicate himself?","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("Smart criminals try to do things a criminal would never do.","Det. Pat. Bluthund");
		 insertD("I’ve had cases where the criminal is the one to call the cops.","Det. Pat. Bluthund");
		 insertD("It’s an attempt to divert suspicion.","Det. Pat. Bluthund");
		 insertV(1,null);
		 insertD("Come on Detective!","Ouran Forenz");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("But I will concede, this is a pretty big blow to the prosecution’s case...","Det. Pat. Bluthund");
		 insertV(3,"Det. Pat. Bluthund");
		 playAni("Det. Pat. Bluthund","bluthundWitness",0,false);
		 insertD("But I will concede, this is a pretty big blow to the prosecution’s case...","Det. Pat. Bluthund");
		 insertV(2,null);
		 insertD("Not so fast...","Mel Practiss");
		 insertD("I have...","Mel Practiss");
		 insertD("A f-few things...","Mel Practiss");
		 insertV(1,null);
		 insertD("Like what?","Ouran Forenz");
		 insertV(4,null);
		 insertD("I haven’t had a line in a while desu~~","Nekocchi");
		 insertV(2,null);
		 insertD("I have a witness to call.","Mel Practiss");
		 insertD("Security guard on the day shift, Enrico Nocent.","Mel Practiss");
		 insertV(0,null);
		 insertD("I see. We will take a short 15 minute recess then reconvene. Court is dismissed.","Judge Judge");
		 insertV(5,"Nekocchi");
		 playAni("Nekocchi","nekocchiWitness",0,false);
		 insertData("---Defendant’s Lobby C May 22nd, 3:01---");
		 insertD("Lobby C huh? I thought there were only two lobbies...","Ouran Forenz");
		 insertD("Me too desu. Guess not OwO.","Nekocchi");
		 insertV(5, "Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertD("Thanks Forenz!", "Gilligan Tam");
		 insertD("We aren’t out of the woods yet.","Ouran Forenz");
		 insertV(5,"Nekocchi");
		 playAni("Nekocchi","nekocchiWitness",0,false);
		 insertD("Woods! I’m afraid of trees!","Nekocchi");
		 insertData("Nekocchi flees.");
		 insertV(5,"Gilligan Tam");
		 playAni("Gilligan Tam","gilliganWitness",0,false);
		 insertD("I think we can do this. I believe in your innocence.","Ouran Forenz");
		 insertD("Thanks.","Gilligan Tam");
		 insertD("We never got a good chance to talk. What exactly happened when you went into the bank that night.","Ouran Forenz");
		 insertD("Well I had left some papers in the back. But I didn’t know where.","Gilligan Tam");
		 insertD("I saw Al alive when I went. He helped me find the papers.","Gilligan Tam");
		 insertD("I left right away once I found them.","Gilligan Tam");
		 insertD("So he was alive at the time.","Ouran Forenz");
		 insertD("Court is reconvening gloriously.","Bailiff");
		 insertD("Good, Nekocchi isn’t back yet.","Ouran Forenz");
		 insertV(5,"Nekocchi");
		 playAni("Nekocchi","nekocchiWitness",0,false);
		 insertD("Did you summon me Ouran-kun nyan desu OwU","Nekocchi");
		 insertD("(Why...)","Ouran Forenz");
		 insertV(0,null);
		 insertData("---Courtroom A May 22nd, 3:09---");
		 insertD("Court is now in session.","Judge Judge");
		 insertD("Prosecution, you had a witness to call I believe.","Judge Judge");
		 insertV(2,null);
		 insertD("The prosecution now calls Enrico Nocent to the stand.","Mel Practiss");
		 insertV(3,"Enrico Nocent");
		 playAni("Enrico Nocent","enricoWitness",0,false);
		 insertData("Enrico Nocent");
		 insertD("Hellllllllooooo.","Enrico Nocent");
		 insertD("Enrico Nocent is my name, but you can call me En.","Enrico Nocent");
		 insertV(1,null);
		 insertD("We will not.","Ouran Forenz");
		 insertV(4,null);
		 insertD("I will En-chan desu.","Nekocchi");
		 
		}
		super.update(); // updates super
		 
	}
	}

