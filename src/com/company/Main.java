package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

		Random random = new Random();

//        int[] arr = new int[100];
		int[] arr = {3,1000,7,3,2,199,33333,5,6,22222,2,1};
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(1000);
//        }


        int max = 0;
        try {
			max = MaxThread.getMax(arr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Max num: " + max);
    }


}

