package com.gmail.neo960211;

import java.util.Arrays;

public class Node {
	
	private int key;
	private int[] data = new int[2];
	private Node stepLeft;
	private Node stepRight;

	public Node(int key, int[] data, Node stepLeft, Node stepRight) {
		super();
		this.key = key;
		this.data = data;
		this.stepLeft = stepLeft;
		this.stepRight = stepRight;
	}

	public Node() {
		super();
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public Node getStepLeft() {
		return stepLeft;
	}

	public void setStepLeft(Node stepLeft) {
		this.stepLeft = stepLeft;
	}

	public Node getStepRight() {
		return stepRight;
	}

	public void setStepRight(Node stepRight) {
		this.stepRight = stepRight;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", data=" + Arrays.toString(data) + "]\n";
	}
}
