package com.mydemo.mvn_project;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.chainsaw.Main;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// 加载日志配置文件
		PropertyConfigurator.configure("log4j.properties");
		// 初始化日志生成器
		Logger log = Logger.getLogger(Main.class.getName());
		log.setLevel(Level.DEBUG);

		log.debug(" this my maven demo's log  ...");
		System.out.println("Hello World!");
	}
}
