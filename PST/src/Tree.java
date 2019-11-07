import java.util.ArrayList;

public class Tree<T> {
	Node<T> root=new Node<T>();
	int newL=3;
	int totalInputTokens=0;

	public Tree()
	{

	}
	
	
	public void train(ArrayList<T> newInput, double newPmin) {
		for (int i=0; i<newL; i++) {
			for (int j=0; j<newInput.size()-i; j++) {
				ArrayList<T> curSequence= new ArrayList<T> (newInput.subList(j, j+i+1));
				Node<T> theNewNode= new Node <T>(curSequence);
				root.addNode(theNewNode);
			}
		}
		totalInputTokens += newInput.size();
		root.pMinElimination(totalInputTokens, newPmin);
		root.print(3);
	}
	
	
}
