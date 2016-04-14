package com.sinosoft.lis.taskservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTask extends TimerTask {

//	public static void main(String[] args) {
//        Timer  timer=new Timer();  
//        MyTask myTask=new MyTask();  
//        timer.schedule(myTask, 1000, 2000);  
//               // Thread.sleep(5000);  
//        //timer.cancel();  
//
//	}

	@Override
	public void run() {
        SimpleDateFormat simpleDateFormat=null;  
        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");  
        System.out.println("当前的系统时间为："+simpleDateFormat.format(new Date())); 
		
	}

}
