package com.youxue.util;

import java.io.IOException;

/**
 * 该类支持只用命令行启动appium
 * @author Administrator
 *
 */
public class AppiumServer {

	
	public AppiumServer(){
		KillTask("node.exe");
		KillTask("adb.exe");
		System.out.println("init appium server...");
	}
	
	public void KillTask(String taskName){
		String command="taskkill /F /im "+taskName;
		System.out.println("kill " + taskName + " task ...");
		runCommand(command);
	}
	
	public void runCommand(String command){
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void runServer(String host_ip,int port,String udid){
		System.out.println("run " + udid + " Appium Server in port " + port + "...");
        //多设备server端需要手动指定每台设备的udid,安卓无线连接下就是设备的ip:port..
        String Command = "appium -a "+host_ip+" -p " + port + " --session-override ";
		System.out.println(Command);
        runCommand(Command);
	}
	
	
	
}
