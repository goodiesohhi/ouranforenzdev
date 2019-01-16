package law; // selects package

import java.io.IOException; // imports IOException
import java.util.ArrayList; // imports ArrayLists

class CrossExamination { // opens class
	ArrayList<Statements> statements = new ArrayList<Statements>(); // creates array for statements
	boolean procced; // checks if a cross-examination has been run
	boolean started=false; // checks if the cross-examination has started
	boolean[] flags= new boolean[30]; // creates array of flags for cross-examination
	ArrayList<Conditions> conditions = new ArrayList<Conditions>(); // holds array of conditions to continue the cross-examination
	boolean complete=false; // checks if the cross-examination has ended
static 	boolean sentinel; // checks if a cross-examination is running
	static boolean statementSentinel; // checks if a statement is running
	
	
	int currentStatement; // holds current statement number
	CrossExamination() { // opens constructor
		
		currentStatement=0; // sets the current statement to 0
		procced=false; // sets the cross-examination to not running
		
	}
	
	void add(String i, String speaker, String[] p, String[] s, int x,String o,String anim, int f) { //adds cross-examination
		Character c =  Main.currentCase.getCharacter(speaker); // sets character for cross-examination
		statements.add(new Statements(i, c, p, s, x,o,anim,f)); // adds statements
	}
	boolean metConditions () { // checks if conditions have been met to continue
	
		
		for (Conditions c: conditions ) { // runs through conditions
		
			if(!c.passed) return false; // if a condition has not been passed false is returned
		}
		
		
		return true; // otherwise true is returned
		
	}
	void update() throws IOException { // updates cross-examination
		
		if (!started) { // checks if it hasn't started
			started=true; // starts cross-examination
			for (Statements s: this.statements) { // runs through statements
			if (s.behaviour!=0 )Main.currentCase.currentExamine.conditions.add(new Conditions(s.behaviour, s.objectName)); //adds conditions if they have not been added
			}
		}
	
//System.out.println(statements.toString());
//System.out.println(statements.get(currentStatement).c);

		if (!Main.currentCase.presented) { // checks if nothing has been presented
		if(!procced) {  // checks that only this runs
			
			if (!Main.currentCase.pressed) statements.get(currentStatement).proc(); // if the case is not pressed the main statement  runs
			
			else Main.pressDialogue.insert(statements.get(currentStatement).presses[ statements.get(currentStatement).c],statements.get(currentStatement).speakers[ statements.get(currentStatement).c]); // otherwise the press runs
			
		procced=true; // sets variable to true
		}
		
		if (Main.currentCase.pressed) { // checks if a statement is pressed
			
			if(!Main.currentCase.inDialogue&&procced) { // checks if there is no dialogue currently happening
				
					
				procced=false; // sets value of variable to false
				
				if (!sentinel) { // only runs through once
					sentinel=true; // sets the sentinel to true
				if(statements.get(currentStatement).c< statements.get(currentStatement).presses.length-1) { // if the next statement exists
					statements.get(currentStatement).c++; // the next statement runs
		     
				} else { // if the next statement does not exist
					if(currentStatement<statements.size()-1) { // if the statement is less than the size of the array
						
						 currentStatement++; // the statement increases
					} else { // otherwise, statements reset
						
						currentStatement=0;
					}
					 Main.currentCase.pressed=false; // end of press
					
				}
				
			}
				}
		} else { // if there is no press
		if(!Main.currentCase.inDialogue) { // if there is no current dialogue
			if(metConditions()) {	 // if all conditions are met
				
				complete=true; // the examination ends
				Main.currentCase.currentExamine=null; // removes examination
				Main.currentCase.inExamine=false; //takes game out of examination
			} else { // if conditions are not met
				
			procced=false; // sets variable back to false
			
			if (!statementSentinel) { // ensures that this only runs once
				statementSentinel=true;
			if(currentStatement<statements.size()-1) { // if the statement is not the last one
				
				 currentStatement++; // the next statement runs
			} else { // otherwise the statement resets
				
				currentStatement=0;
			}
			}
			}
		}
		}
		}
	}

	public void passCondition(int i) { // passes condition
		for (Conditions c: conditions ) { // runs through all conditions
			if (!c.passed && c.type==i) { // checks if a condition is not passed
				c.passed=true; // sets the statement to pass
				break; // ends loop
			}
		}
		
	}
	
	
}

class Conditions { // opens class for conditions
	
	int type; // holds type of condition
	int data; // holds what data needs to be pressed
	int slot; // holds id
	String presentable; // checks what needs to be presented
	boolean passed; // checks if condition is passed

	public Conditions(int behaviour, String presentThis) { // constructs conditions
		type =behaviour; // sets type of condition
		presentable=presentThis; //sets what has to be presented
		passed=false; // ensures that condition is not passed
	}
}