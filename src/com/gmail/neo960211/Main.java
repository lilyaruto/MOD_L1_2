package com.gmail.neo960211;

import java.util.Arrays;

import com.gmail.neo960211.m1.TreeStepOne;
import com.gmail.neo960211.m2.TreeStepOneM2;

public class Main {
	
	public static void main(String[] args) {
		
		/*TreeStepOne m1_tree = new TreeStepOne(6);
		m1_tree.start();
		
		TreeStepTwo m1_tree2 = new TreeStepTwo(m1_tree.returnResult(), m1_tree.returnResult().length);
		System.out.println("Result after first block:\n" + Arrays.toString(m1_tree2.getLaunchData()));
		m1_tree2.start();
		System.out.println("Result after second block:\n" + Arrays.toString(m1_tree2.returnSecondResult()));
		System.out.println("Result after final block:\n" + Arrays.toString(m1_tree2.returnFinalResult()));*/
		
		TreeStepOneM2 m2_tree = new TreeStepOneM2(6);
		m2_tree.start();
		
		TreeStepTwo m2_tree2 = new TreeStepTwo(m2_tree.returnResult(), m2_tree.returnResult().length);
		System.out.println("Result after first block:\n" + Arrays.toString(m2_tree2.getLaunchData()));
		m2_tree2.start();
		System.out.println("Result after second block:\n" + Arrays.toString(m2_tree2.returnSecondResult()));
		System.out.println("Result after final block:\n" + Arrays.toString(m2_tree2.returnFinalResult()));
	}
}