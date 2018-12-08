package law;
class CrossExamination {
	Statements[] statements = new Statements[20];
	boolean procced;
	int sCount;
	boolean[] flags= new boolean[30];
	Conditions[] conditions = new Conditions[30];
	boolean complete=false;
	
	
	
	int currentStatement;
	CrossExamination() {
		sCount=0;
		currentStatement=0;
		procced=false;
		
	}
	
	void add(String i, String speaker, String[] p, String[] s, int x,int y) {
		statements[sCount]= new Statements(i, speaker, p, s, x, y,sCount);
		sCount++;
	}
	boolean metConditions () {
		System.out.println("marker");
		
		int conditionsLength=0;
		for (int i=0; i<conditions.length;i++) {
			if (conditions[i]!=null) conditionsLength++;
		}
		System.out.println("length: " + conditionsLength);
		for (int i=0; i<conditionsLength;i++) {
			System.out.println("not met");
			if(!flags[conditions[i].slot]) return false;
		}
		
		System.out.println("met");
		return false;
		
	}
	void update() {
	

		if(!procced) { 
			if (!Main.currentCase.pressed)statements[currentStatement].proc();
			
			else Main.pressDialogue.insert( Main.currentCase.currentExamine.statements[Main.currentCase.currentExamine.currentStatement].presses[ Main.currentCase.currentExamine.statements[Main.currentCase.currentExamine.currentStatement].c], Main.currentCase.currentExamine.statements[Main.currentCase.currentExamine.currentStatement].speakers[ Main.currentCase.currentExamine.statements[Main.currentCase.currentExamine.currentStatement].c]);
			
		procced=true;
		}
		
		if (Main.currentCase.pressed) {
			System.out.println( Main.currentCase.currentExamine.statements[Main.currentCase.currentExamine.currentStatement].c);
			if(!Main.currentCase.inDialogue) {
				
					
				procced=false;
				if( Main.currentCase.currentExamine.statements[Main.currentCase.currentExamine.currentStatement].c< Main.currentCase.currentExamine.statements[Main.currentCase.currentExamine.currentStatement].presses.length-1) {
		     	 Main.currentCase.currentExamine.statements[Main.currentCase.currentExamine.currentStatement].c++;
		     	System.out.println("hello");
				} else {
					
					 Main.currentCase.pressed=false;
						System.out.println("byebye");
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
			if(currentStatement<sCount-1) {
				
				 currentStatement++;
			} else {
				
				currentStatement=0;
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