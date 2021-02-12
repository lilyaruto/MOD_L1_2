package com.gmail.neo960211;

public class TreeStepTwo {
	
	private int launchData[];
	private int inputDataCounter;
	private GateNode nodesArray[];
	private Node finalNodes[];
	
	public TreeStepTwo(int[] launchData, int inputDataCounter) {
		super();
		this.launchData = launchData;
		this.inputDataCounter = inputDataCounter;
	}

	public int[] getLaunchData() {
		return launchData;
	}

	public void setLaunchData(int[] launchData) {
		this.launchData = launchData;
	}

	public int getInputDataCounter() {
		return inputDataCounter;
	}

	public void setInputDataCounter(int inputDataCounter) {
		this.inputDataCounter = inputDataCounter;
	}

	public GateNode[] getNodesArray() {
		return nodesArray;
	}

	public void setNodesArray(GateNode[] nodesArray) {
		this.nodesArray = nodesArray;
	}

	public Node[] getFinalNodes() {
		return finalNodes;
	}

	public void setFinalNodes(Node[] finalNodes) {
		this.finalNodes = finalNodes;
	}



	public GateNode[] nodeCreator(GateNode n[]) {
		for (int i = 0; i < n.length; i++) {
			n[i] = new GateNode(0, null, null, null, false);
			n[i].setKey(i+1);
		}
		return n;
	}
	
	public Node[] finalNodeCreator(Node[] n) {
		for (int i = 0; i < n.length; i++) {
			n[i] = new Node();
			n[i].setKey(i+1);
		}
		return nodesArray;
	}
	
	public GateNode[] nodeConductor(GateNode[] n) {
		n[0].setGateNumber(1);
		n[1].setGateNumber(2);
		n[2].setGateNumber(12);
		n[3].setGateNumber(3);
		n[4].setGateNumber(13);
		n[5].setGateNumber(23);
		return n;
	}
	
	public GateNode[] pullData(GateNode[] n, int arr[]) {
		for (int i = 0; i < n.length; i++) {
			for (int j = i+1; j < n.length; j++) {
				if (i != n.length - 1) {
					int tempArr[] = new int[2];
					tempArr[0] = arr[i];
					tempArr[1] = arr[j];
					n[i].setData(tempArr);
					break;
				} else {
					break;
				}
			}
			if (i == n.length - 1) {
				int tempArr[] = new int[2];
				tempArr[0] = arr[i];
				tempArr[1] = 0;
				n[i].setData(tempArr);
			}
		}
		return n;
	}
	
	public int[] secondResult(GateNode[] n) {
		int arr[] = new int[n.length];
		for (int i = 0; i < n.length; i++) {
			int tempArr[] = new int[2];
			tempArr = n[i].getData();
			arr[i] = tempArr[0] ^ tempArr[1];
		}
		return arr;
	}
	
	public int[] returnSecondResult() {
		int arr[] = secondResult(nodesArray);
		return arr;
	}
	
	public int[] pullFinalData(GateNode[] gn, Node[] n, int arr[]) {
		int connector[] = new int[3];
		for (int i = 0; i < connector.length; i++) {
			int tempArr[] = {2, 2, 2, 2, 2, 2};
			int group[] = new int[3];
			for (int j = 0; j < gn.length; j++) {
				if (gn[j].getGateNumber() > 3) {
					int first = gn[j].getGateNumber() / 10;
					int second = gn[j].getGateNumber() % 10;
					if (first == n[i].getKey()) {
						tempArr[j] = arr[j];
					} else if (second == n[i].getKey()) {
						tempArr[j] = arr[j];
					} else {}
				} else {
					if (gn[j].getGateNumber() == n[i].getKey()) {
						tempArr[j] = arr[j];
					}
				}
			}
			int temp = 0;
			for (int j = 0; j < group.length; j++) {
				temp++;
				for (int k = temp; k < tempArr.length; k++) {
					if (tempArr[k] != 2) {
						group[j] = tempArr[k];
						temp = k;
						break;
					}
				}
			}
			connector[i] = group[0] | group[1] | group[2];
		}
		return connector;
	}
	
	public int[] returnFinalResult() {
		int arr[] = pullFinalData(nodesArray, finalNodes, returnSecondResult());
		return arr;
	}
	
	public void start() {
		if (inputDataCounter == 6) {
			nodesArray = new GateNode[inputDataCounter];
			finalNodes = new Node[3];
			nodeCreator(nodesArray);
			finalNodeCreator(finalNodes);
			nodeConductor(nodesArray);
			pullData(nodesArray, launchData);
			pullFinalData(nodesArray, finalNodes, returnSecondResult());
		}
	}
}
