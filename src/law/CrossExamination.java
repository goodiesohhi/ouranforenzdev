package law;

import java.io.IOException;
import java.util.ArrayList;

class CrossExamination {
	ArrayList<Statements> statements = new ArrayList<Statements>();
	boolean procced;
	boolean started=false;
	boolean[] flags= new boolean[30];
	ArrayList<Conditions> conditions = new ArrayList<Conditions>();
	boolean complete=false;
static 	boolean sentinel;
	static boolean statementSentinel;
	
	
	int currentStatement;
	CrossExamination() {
		
		currentStatement=0;
		procced=false;
		
	}
	
	void add(String i, String speaker, String[] p, String[] s, int x,String o,String anim, int f) {
		Character c =  Main.currentCase.getCharacter(speaker);
		statements.add(new Statements(i, c, p, s, x,o,anim,f));
	
	}
	boolean metConditions () {
	
		
		for (Conditions c: conditions ) {
		
			if(!c.passed) return false;
		}
		
		
		return true;
		
	}
	void update() throws IOException {
		
		if (!started) {
			started=true;
			
			for (Statements s: this.statements) {
			if (s.behaviour!=0 )Main.currentCase.currentExamine.conditions.add(new Conditions(s.behaviour, s.objectName)); 
			}
		}
	
//System.out.println(statements.toString());
//System.out.println(statements.get(currentStatement).c);

		if (!Main.currentCase.presented) {
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

	public void passCondition(int i) {
		for (Conditions c: conditions ) {
			if (!c.passed && c.type==i) {
				c.passed=true;
				break;
			}
		}
		
	}
	
	
}

class Conditions {
	
	int type;
	int data;
	int slot;
	String presentable;
	boolean passed;

	public Conditions(int behaviour, String presentThis) {
		type =behaviour;
		presentable=presentThis;
		passed=false;
	}
}