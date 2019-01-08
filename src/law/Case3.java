package law;

import java.io.IOException;

class Case3 extends StoryManager  {

    int currentArea = 0;
    
    Case3() throws IOException
    {
        super();
    }
    void update() throws IOException
    {

    	if (flags[25]==false&&!oneProc)
        {
            oneProc = true;
            inCourt = false;
            insertR("Ouran's Attorney's Badge","badge","It’s the badge I got when I first became an Attorney.", false,0);
            insertR("Ouran", "ouranProfile", "It's me!", true, 2);
            insertR("Nekocchi", "nekocchiProfile", "My assistant...", true, 3);
            insertR("Det. Pat. Bluthund", "bluthundProfile", "The detective. Can be a bit over-zealous.", true, 4);
            insertR("Adrasteia Rhamnousia", "adrasteiaProfile", "The prosecutor. Blind as a bat.", true, 5);
            /*insertD("Convention Centre", "");
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
            insertD("Of course they are!", "Keto");*/
            flags[25] = true;
            characters.add(new Character("Nekocchi", 280, 0));
            characters.add(new Character ("Det. Pat. Bluthund", 150, 0));
            characters.add(new Character("Keto Saiba", 200, 0));
      		 locales[0] = new DetentionThree();
       		 locales[1] = new ForenzOffice();
       		
       		 locales[0].linkPath(locales[1]);
          //flags[25]=true;
       		// this.toCourt();
       		 enterArea(1);
       		
       		 
       		flags[0]=true;
        }
        

    super.update();
    
    }
   
}
