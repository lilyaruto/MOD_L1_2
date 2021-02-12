package com.gmail.neo960211.m2;

import java.util.Arrays;

import com.gmail.neo960211.Node;

public class TreeStepOneM2 {

	private int inputDataCounter;
	private Node nodesArray[];
	
	public TreeStepOneM2(int inputDataCounter) {
		super();
		this.inputDataCounter = inputDataCounter;
	}

	public TreeStepOneM2() {
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
	
	public Node[] nodeCreator(Node n[]) {
		for (int i = 0; i < n.length; i++) {
			n[i] = new Node();
			n[i].setKey(i+1);
		}
		return nodesArray;
	}
	
	public Node[] nodeConductor(Node n[]) {
		n[0].setStepLeft(n[3]);
		n[0].setStepRight(n[4]);
		
		n[1].setStepLeft(n[3]);
		n[1].setStepRight(n[5]);
		
		n[2].setStepLeft(n[4]);
		n[2].setStepRight(n[5]);
		
		n[3].setStepLeft(n[6]);
		n[3].setStepRight(n[7]);
		
		n[4].setStepLeft(n[6]);
		n[4].setStepRight(n[8]);
		
		n[5].setStepLeft(n[7]);
		n[5].setStepRight(n[8]);
		
		n[6].setStepLeft(null);
		n[6].setStepRight(n[9]);
		
		n[7].setStepLeft(n[9]);
		n[7].setStepRight(n[10]);
		
		n[8].setStepLeft(n[10]);
		n[8].setStepRight(null);
		
		n[9].setStepLeft(null);
		n[9].setStepRight(n[11]);
		
		n[10].setStepLeft(n[11]);
		n[10].setStepRight(null);
		
		n[11].setStepLeft(null);
		n[11].setStepRight(null);
		
		return n;
	}
	
	public Node[] pullStartData(Node[] n) {
		for (int i = 0; i < 3; i++) {
			int arr[] = new int[2];
			arr[0] = (int) ((Math.random() * (2 - 0)) + 0);
			arr[1] = (int) ((Math.random() * (2 - 0)) + 0);
			n[i].setData(arr);
		}
		
		/*int arr[] = new int[2];
		arr = n[0].getData();
		arr[0] = 1;
		arr[1] = 1;
		n[0].setData(arr);
		
		arr = n[1].getData();
		arr[0] = 1;
		arr[1] = 0;
		n[1].setData(arr);
		
		arr = n[2].getData();
		arr[0] = 0;
		arr[1] = 0;
		n[2].setData(arr);*/
		
		return n;
	}
	
	public int[] pullData(Node[] n) {
		int arr[] = {2, 2, 2, 2, 2, 2};
		boolean check = true;
		int and = 0;
		int or = 0;
		int temp[] = new int[2];
		Node tempNode;
		for (int i = 0; i < n.length; i++) {
			for (int j = i; j < n.length; j++) {
				if (i <= 8) {
					temp = n[i].getData();
					and = temp[0] & temp[1];
					or = temp[0] | temp[1];
					if (i == 0 || i % 3 == 0) {
						if (n[i].getStepLeft() == null) {
							if (check == true) {
								for (int j2 = 0; j2 < arr.length; j2++) {
									if (arr[j2] == 2) {
										arr[j2] = or;
										check = false;
										break;
									}
								}
							} else {
								for (int j2 = arr.length - 1; j2 >= 0; j2--) {
									if (arr[j2] == 2) {
										arr[j2] = or;
										check = true;
										break;
									}
								}
							}
						} else {
							tempNode = n[i].getStepLeft();
							temp = tempNode.getData();
							temp[0] = or;
							n[tempNode.getKey()-1].setData(temp);
						}
						
						tempNode = n[i].getStepRight();
						temp = tempNode.getData();
						temp[0] = and;
						n[tempNode.getKey()-1].setData(temp);
						break;
					} else if (i-1 == 0 || (i-1) % 3 == 0) {
						tempNode = n[i].getStepLeft();
						temp = tempNode.getData();
						temp[1] = or;
						n[tempNode.getKey()-1].setData(temp);
						
						tempNode = n[i].getStepRight();
						temp = tempNode.getData();
						temp[0] = and;
						n[tempNode.getKey()-1].setData(temp);
						break;
					} else {
						tempNode = n[i].getStepLeft();
						temp = tempNode.getData();
						temp[1] = or;
						n[tempNode.getKey()-1].setData(temp);
						
						if (n[i].getStepRight() == null) {
							if (check == true) {
								for (int j2 = 0; j2 < arr.length; j2++) {
									if (arr[j2] == 2) {
										arr[j2] = and;
										check = false;
										break;
									}
								}
							} else {
								for (int j2 = arr.length - 1; j2 >= 0; j2--) {
									if (arr[j2] == 2) {
										arr[j2] = and;
										check = true;
										break;
									}
								}
							}
						} else {
							tempNode = n[i].getStepRight();
							temp = tempNode.getData();
							temp[1] = and;
							n[tempNode.getKey()-1].setData(temp);
						}
					}
					break;
				} else {
					temp = n[i].getData();
					and = temp[0] & temp[1];
					or = temp[0] | temp[1];
					if (n[i].getStepLeft() == null && n[i].getStepRight() != null) {
						
						tempNode = n[i].getStepRight();
						temp = tempNode.getData();
						temp[0] = and;
						n[tempNode.getKey()-1].setData(temp);
						
						if (check == true) {
							for (int j2 = 0; j2 < arr.length; j2++) {
								if (arr[j2] == 2) {
									arr[j2] = or;
									check = false;
									break;
								}
							}
						} else {
							for (int j2 = arr.length - 1; j2 >= 0; j2--) {
								if (arr[j2] == 2) {
									arr[j2] = or;
									check = true;
									break;
								}
							}
						}
						break;
					} else if (n[i].getStepRight() == null && n[i].getStepLeft() != null) {
						
						tempNode = n[i].getStepLeft();
						temp = tempNode.getData();
						temp[1] = or;
						n[tempNode.getKey()-1].setData(temp);
						
						if (check == true) {
							for (int j2 = 0; j2 < arr.length; j2++) {
								if (arr[j2] == 2) {
									arr[j2] = and;
									check = false;
									break;
								}
							}
						} else {
							for (int j2 = arr.length - 1; j2 >= 0; j2--) {
								if (arr[j2] == 2) {
									arr[j2] = and;
									check = true;
									break;
								}
							}
						}
						break;
					} else {
						arr[2] = or;
						arr[3] = and;
					}
				}
			}
		}
		return arr;
	}
	
	public void start() {
		if (inputDataCounter == 6) {
			nodesArray = new Node[inputDataCounter*2];
			nodeCreator(nodesArray);
			nodeConductor(nodesArray);
			pullStartData(nodesArray);
			pullData(nodesArray);
		}
	}
	
	public int[] returnResult() {
		int arr[] = pullData(nodesArray);
		return arr;
	}
}
