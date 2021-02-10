package com.gmail.neo960211;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		Tree tree = new Tree(6);
		tree.start();
		System.out.println(tree.getNodesArray().length);
		System.out.println(Arrays.toString(tree.getNodesArray()));
		//System.out.println(tree.getInputDataCounter());
		//System.out.println(Arrays.toString(tree.getNodesArray()));
	}
}
