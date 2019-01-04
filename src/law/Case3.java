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
        if (!oneProc)
        {
            oneProc = true;
            inCourt = false;
            insertD("Convention Centre", "");
            insertD("August 7", "");
            insertD("2:57 PM", "");
            insertD("Ouran-san! My kawaii Fairilees must see battle!", "Nekocchi");
            insertD("(Nekocchi dragged me to a tournament for some weird card game. I probably shouldn’t be here...)", "Ouran");
            insertD("There he is! My final opponent is the famous Keto Saiba!", "Nekocchi");
            insertD("Greetings. You’re using Fairilees, I see? My famous Dragons will destroy you!", "Keto");
            insertD("Silly baka! Dragons cannot hurt fairies, Keto-san!", "Nekocchi");
            insertD("Who cares about the immunity rules? No individual card can stand up to this!", "Keto");
            insertD("Awww...", "Nekocchi");
            insertD("(Nekkochi lost. I feel kind of bad for her.)", "Ouran");
            insertD("That was a good fight, Keto-chan! Your dragons were sugoi cool!", "Nekocchi");
            insertD("Of course they are!", "Keto");
            
        }
        super.update();
    }
    
    
}
