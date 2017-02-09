package com.dq.caipiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LotteryUtil {
	
	public static LotteryBean getRandomLottery(LotteryBean bean) {
		Random random = new Random();
		List<Integer> redAlls = new ArrayList<Integer>();
		List<Integer> blueAlls = new ArrayList<Integer>();
		for (int i = 1; i < 33; i++) {
			redAlls.add(i);
		}
		for (int i = 1; i < 16; i++) {
			blueAlls.add(i);
		}
		Integer a1 = redAlls.get(random.nextInt(redAlls.size()));
		redAlls.remove(a1);
		Integer a2 = redAlls.get(random.nextInt(redAlls.size()));
		redAlls.remove(a2);
		Integer a3 = redAlls.get(random.nextInt(redAlls.size()));
		redAlls.remove(a3);
		Integer a4 = redAlls.get(random.nextInt(redAlls.size()));
		redAlls.remove(a4);
		Integer a5 = redAlls.get(random.nextInt(redAlls.size()));
		redAlls.remove(a5);
		Integer a6 = redAlls.get(random.nextInt(redAlls.size()));
		redAlls.remove(a6);

		int array[] = { a1, a2, a3, a4, a5, a6 };
		selectSort(array);
		bean.setRed1(formatInt(array[0]));
		bean.setRed2(formatInt(array[1]));
		bean.setRed3(formatInt(array[2]));
		bean.setRed4(formatInt(array[3]));
		bean.setRed5(formatInt(array[4]));
		bean.setRed6(formatInt(array[5]));
		Integer b1 = blueAlls.get(random.nextInt(blueAlls.size()));
		blueAlls.remove(b1);
		bean.setBlue1(formatInt(b1));
		return bean;
	}
	
	private static String formatInt(int a){
		if (a<10) {
			return "0"+a;
		}
		return a+"";
	}
	
	private static void selectSort(int[] array) {
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
}
