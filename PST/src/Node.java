import java.util.ArrayList;

public class Node<T> {
	ArrayList<Node<T>> children= new ArrayList <Node<T>>();
	ArrayList<T> tokenSequence= new ArrayList<T>();
	int count=1;
	float findProb=0;

	Node(){

	}

	Node(ArrayList<T> input){
		tokenSequence=input;
	}

	public ArrayList<T> getToken() {
		return tokenSequence;
	}

	public ArrayList<Node<T>> getChildren() {
		return children;
	}

	public boolean addNode(Node<T> node) {
		boolean found=false;
		ArrayList<T> nodeToken= node.getToken();
		if (tokenSequence.equals(nodeToken)) {
			found=true;
			count++;
		}
		else if (ifSuffix(nodeToken)||(tokenSequence.size()==0)) {
			int i=0;
			while(!found && i<children.size()) {
				found=children.get(i).addNode(node);
				i++;
			}

			if(!found) 
			{
				children.add(node);
				found=true;
			}
			
		}
		return found;
	}

	
	public void print() {
		System.out.println(tokenSequence);
		for(int j=0; j<children.size(); j++) {
			children.get(j).print(1);
		}
	}

	public void print(int numSpacesBefore) {
		for (int i=0; i<numSpacesBefore; i++) {
			System.out.print(" ");
		}

		System.out.print("->");
		System.out.println(tokenSequence);
		for(int j=0; j<children.size(); j++) {
			children.get(j).print(numSpacesBefore+1);
		}
	}

	public int findSuffix(ArrayList<T> token){
		int spot=0;
		ArrayList<T> newSuffix= new ArrayList<T> (token.subList(1, token.size()));
		for (int i=0; i<children.size(); i++) {
			if (children.get(i).getToken().equals(newSuffix)) {
				spot=i;
			}
		}
		return spot;
	}


	public boolean ifSuffix(ArrayList<T> token) {
		ArrayList<T> newSuffix= new ArrayList<T> (token.subList(token.size()-tokenSequence.size(), token.size()));
		return newSuffix.equals(tokenSequence);
	}

	public boolean pMinElimination(int totalTokens, double pMin) {
		float numOccur=totalTokens-(tokenSequence.size()-1);
		findProb=(float) count/numOccur;
		System.out.println("Token = " + tokenSequence + " findprob = " + findProb);
		boolean shouldRemove=false;
		if(findProb<pMin && tokenSequence.size()!=0) {
			shouldRemove=true;
		}
		else {
			for(int d=0; d<children.size();d++) {
				boolean eliminate=children.get(d).pMinElimination(totalTokens, 0.1);
				if (eliminate==true) {
					System.out.println("Removing: " + children.get(d).tokenSequence);
					children.remove(children.get(d));
					d --;
				}
			}
		}
		return shouldRemove;
	}
}
