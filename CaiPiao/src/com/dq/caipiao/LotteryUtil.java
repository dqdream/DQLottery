package com.dq.caipiao;

import java.util.Random;

public class LotteryUtil {
	
	public static LotteryBean getRandomLottery(LotteryBean bean){
		Random random=new Random();
		bean.setRed1(formatInt(random.nextInt(33)+1));
		bean.setRed2(formatInt(random.nextInt(33)+1));
		bean.setRed3(formatInt(random.nextInt(33)+1));
		bean.setRed4(formatInt(random.nextInt(33)+1));
		bean.setRed5(formatInt(random.nextInt(33)+1));
		bean.setRed6(formatInt(random.nextInt(33)+1));
		bean.setBlue1(formatInt(random.nextInt(16)+1));
		return bean;
	}
	
	private static String formatInt(int a){
		if (a<10) {
			return "0"+a;
		}
		return a+"";
	}
}
