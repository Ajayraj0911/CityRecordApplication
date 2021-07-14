package com.Controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Bean.CityBean;
import com.Config.DBConfig;
import com.Dao.CityDao;

public class CityController {


	@Autowired
	static CityDao cityDao;
	
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);	
		cityDao = (CityDao) ctx.getBean("cityDao");
		
		while(true) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Welcome to City Temperature Recorder");
		System.out.println("1-----add City & temperature");
		System.out.println("2-----delete City");
		System.out.println("3-----update city temperature");
		System.out.println("4-----get city temperature from city name");
		System.out.println("5-----get average day temprature by city name");
		System.out.println("6-----exit");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		
		
		switch(choice) {
			
		
				case 1:
						System.out.println("You have selected add city and temperature");
						int res = cityDao.addCity();
						
						if(res>0) {
							
							System.out.println("Record inserted...");
						}
						else {
							System.out.println("Record not inserted...");
						}
						break;
				
				case 2:
						System.out.println("You have selected delete city");
						System.out.println(cityDao.deleteCity()+"City deleted");
						break;
				
				case 3:
						System.out.println("You have selected update city temperature");
						System.out.println(cityDao.updateCity()+"City Temperature updated");
						
						break;
						
				case 4:
						System.out.println("You have selected get city temperature from city name");
						CityBean cityBean = cityDao.getCityBeanByName();
						System.out.println("Morning Temperature:- "+cityBean.getMorntemp());
						System.out.println("Evening Temperature:- "+cityBean.getEventemp());
						System.out.println("Night Temperature:- "+cityBean.getNighttemp());
						break;
						
				case 5:
						System.out.println("You have selected get average day temprature by city name");
						CityBean cityBean1 = cityDao.getAvgTempByName();
						System.out.println("Average Temperature:- "+cityBean1.getAvgtemp());
						break;
					
				case 6:
						System.out.println("Thank you for visiting us");
						System.exit(0);
						
						
		
			}
		}
		
	}
}
