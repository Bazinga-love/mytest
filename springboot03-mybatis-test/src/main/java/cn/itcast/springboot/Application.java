package cn.itcast.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	//代表为SpringBoot应用的运行注解
public class Application {

	public static void main(String[] args) {
		/**
		 * 运行SpringBoot应用
		 */
		//SpringApplication.run(Application.class, args);
		
		/**
		 * 创建SpringApplication应用对象,屏蔽标识
		 */
		SpringApplication springApplication = new SpringApplication(Application.class);
		/**
		 * 设置横幅模式(设置关闭)
		 */
		springApplication.setBannerMode(Banner.Mode.OFF);
		/** 运行  */
		springApplication.run(args);
	}
}
