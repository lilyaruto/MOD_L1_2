package com.gmail.neo960211;

import java.util.Arrays;

public class GateNode extends Node {
	
	private int gateNumber;

	public GateNode(int key, int[] data, Node stepLeft, Node stepRight, boolean checkCorner, int gateNumber) {
		super(key, data, stepLeft, stepRight, checkCorner);
		this.gateNumber = gateNumber;
	}

	public GateNode(int key, int[] data, Node stepLeft, Node stepRight, boolean checkCorner) {
		super(key, data, stepLeft, stepRight, checkCorner);
	}

	public int getGateNumber() {
		return gateNumber;
	}

	public void setGateNumber(int gateNumber) {
		this.gateNumber = gateNumber;
	}

	@Override
	public String toString() {
		return "GateNode [gateNumber=" + gateNumber + ", key=" + getKey() + ", data="
				+ Arrays.toString(getData()) + "]\n";
	}
}
