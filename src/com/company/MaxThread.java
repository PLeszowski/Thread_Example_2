package com.company;

/**
 * Created by RENT on 2017-06-21.
 */
public class MaxThread extends Thread {
	private int lo, hi;
	private int[] arr;
	private int ans = 0;

	public MaxThread(int[] arr, int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
		this.arr = arr;
	}

	@Override
	public void run() {

		for (int i = lo; i < hi; i++) {
			if(arr[i] > ans) {
				ans = arr[i];
			}
		}
		System.out.println("Max = " + ans);
	}

	/**
	 * Sum the elements of an array.
	 *
	 * @param arr array to getMax
	 * @return getMax of the array's elements
	 * @throws InterruptedException shouldn't happen
	 */
	public static int getMax(int[] arr) throws InterruptedException {
		int len = arr.length;
		int max = 0;

		// Create and start 4 threads.
		MaxThread[] ts = new MaxThread[4];
		for (int i = 0; i < 4; i++) {
			ts[i] = new MaxThread(arr, (i * len) / 4, ((i + 1) * len / 4));
			ts[i].start(); // starts run() for each thread (run() is like main for the thread)
		}

		// Wait for the threads to finish and getMax their results.
		for (int i = 0; i < 4; i++) {
			ts[i].join();
			if(ts[i].ans > max) {
				max = ts[i].ans;
			}

		}
		return max;
	}
}
