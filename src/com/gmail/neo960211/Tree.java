package com.gmail.neo960211;

public class Tree {
	
	private int inputDataCounter;
	private Node nodesArray[];
	
	public Tree(int inputDataCounter) {
		super();
		this.inputDataCounter = inputDataCounter;
	}
	
	public Tree() {
		super();
	}
	
	public int getInputDataCounter() {
		return inputDataCounter;
	}



	public void setInputDataCounter(int inputDataCounter) {
		this.inputDataCounter = inputDataCounter;
	}



	public Node[] getNodesArray() {
		return nodesArray;
	}



	public void setNodesArray(Node[] nodesArray) {
		this.nodesArray = nodesArray;
	}
	
	public int treeSize(int inputDataCounter) {
		int temp = inputDataCounter;
		for (int i = inputDataCounter - 1; i > 0; i--) {
			inputDataCounter += i;
		}
		inputDataCounter -= temp;
		return inputDataCounter;
	}
	
	public Node[] nodeCreator(Node n[]) {
		for (int i = 0; i < n.length; i++) {
			n[i] = new Node();
			n[i].setKey(i+1);
		}
		return nodesArray;
	}
	
	public Node[] nodeConductor(Node n[], int inputDataCounter) {
		inputDataCounter--;
		int tempCounter = inputDataCounter;
		for (int i = 0; i < n.length; i++) {
			for (int j = i; j < n.length; j++) {
				if (i == n.length - 1) {
					n[i].setStepRight(null);
					n[i].setStepLeft(null);
					break;
				}
				if (inputDataCounter == tempCounter) {
					n[i].setStepRight(n[j+1]);
					n[i].setStepLeft(n[j+inputDataCounter]);
					tempCounter--;
					break;
				} else if (inputDataCounter != tempCounter && tempCounter != 1) {
					n[i].setStepRight(n[j+1]);
					n[i].setStepLeft(n[j+inputDataCounter-1]);
					tempCounter--;
					break;
				} else {
					n[i].setStepRight(null);
					n[i].setStepLeft(n[j+inputDataCounter-1]);
					tempCounter--;
					break;
				}
			}
			if (tempCounter == 0) {
				inputDataCounter--;
				tempCounter = inputDataCounter;
			}
		}
		return n;
	}
	
	public Node[] pullStartData(Node n[], int inputDataCounter) {
		
		inputDataCounter--;
		for (int i = 0; i < n.length; i++) {
			if (i == 0) {
				int arr[] = new int[2];
				arr[0] = (int) ((Math.random() * (2 - 0)) + 0);
				arr[1] = (int) ((Math.random() * (2 - 0)) + 0);
				n[i].setData(arr);
			} else if (i < inputDataCounter) {
				int arr[] = new int[2];
				arr[0] = 0;
				arr[1] = (int) ((Math.random() * (2 - 0)) + 0);
				n[i].setData(arr);
			}
		}
		return n;
	}
	
	public Node[] pullData(Node[] n) {
		int and = 0;
		int or = 0;
		int temp[] = new int[2];
		Node tempNode;
		for (int i = 0; i < n.length; i++) {
			for (int j = i; j < n.length; j++) {
				temp = n[i].getData();
				and = temp[0] & temp[1];
				or = temp[0] | temp[1];
				//LEFT
				
				tempNode = n[i].getStepLeft();
				temp = tempNode.getData();
				temp[0] = and;
				n[tempNode.getKey()-1].setData(temp);
				//RIGHT
				tempNode = n[i].getStepRight();
				temp = tempNode.getData();
				temp[0] = or;
				n[tempNode.getKey()-1].setData(temp);
			}
		}
		return n;
	}

	public void start() {
		nodesArray = new Node[treeSize(inputDataCounter)];
		nodeCreator(nodesArray);
		nodeConductor(nodesArray, inputDataCounter);
		pullStartData(nodesArray, inputDataCounter);
		pullData(nodesArray);
	}
}
