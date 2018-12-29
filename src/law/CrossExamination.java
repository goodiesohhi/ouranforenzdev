package law;

import java.io.IOException;
import java.util.ArrayList;

class CrossExamination {
	ArrayList<Statements> statements = new ArrayList<Statements>();
	boolean procced;
	
	boolean[] flags= new boolean[30];
	Conditions[] conditions = new Conditions[30];
	boolean complete=false;
static 	boolean sentinel;
	static boolean statementSentinel;
	
	
	int currentStatement;
	CrossExamination() {
		
		currentStatement=0;
		procced=false;
		
	}
	
	void add(String i, String speaker, String[] p, String[] s, int x,int y,String anim, int f) {
		Character c =  Main.currentCase.getCharacter(speaker);
		statements.add(new Statements(i, c, p, s, x, y,0,anim,f));
	
	}
	boolean metConditions () {
	
		
		int conditionsLength=0;
		for (int i=0; i<conditions.length;i++) {
			if (conditions[i]!=null) conditionsLength++;
		}
		
		for (int i=0; i<conditionsLength;i++) {
			
			if(!flags[conditions[i].slot]) return false;
		}
		
		
		return false;
		
	}
	void update() throws IOException {
	
System.out.println(statements.toString());
System.out.println(statements.get(currentStatement).c);
		if(!procced) { 
			if (!Main.currentCase.pressed) statements.get(currentStatement).proc();
			
			else Main.pressDialogue.insert(statements.get(currentStatement).presses[ statements.get(currentStatement).c],statements.get(currentStatement).speakers[ statements.get(currentStatement).c]);
			
		procced=true;
		}
		
		if (Main.currentCase.pressed) {
			
			if(!Main.currentCase.inDialogue&&procced) {
				
					
				procced=false;
				
				if (!sentinel) {
					sentinel=true;
				if(statements.get(currentStatement).c< statements.get(currentStatement).presses.length-1) {
					statements.get(currentStatement).c++;
		     
				} else {
					if(currentStatement<statements.size()-1) {
						
						 currentStatement++;
					} else {
						
						currentStatement=0;
					}
					 Main.currentCase.pressed=false;
					
				}
				
			}
				}
		} else {
		if(!Main.currentCase.inDialogue) {
			if(metConditions()) {
				
				complete=true;
				Main.currentCase.currentExamine=null;
				Main.currentCase.inExamine=false;
			} else {
				
			procced=false;
			
			if (!statementSentinel) {
				statementSentinel=true;
			if(currentStatement<statements.size()-1) {
				
				 currentStatement++;
			} else {
				
				currentStatement=0;
			}
			}
			}
		}
		}
		
	}
	
	
}

class Conditions {
	
	int type;
	int data;
	int slot;
	Conditions(int s, int t, int d) {
		type =t;
		data=d;
		slot=s;
	}
}