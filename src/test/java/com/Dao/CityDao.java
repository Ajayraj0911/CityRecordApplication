package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Bean.CityBean;

@Repository
public class CityDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public int addCity() {

		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.print("Enter City- ");  
		String city= sc.nextLine();  
		System.out.print("Enter Morning Temperature- ");  
		int morntemp= sc.nextInt();  
		System.out.print("Enter Evening Temperature- ");  
		int eventemp= sc.nextInt();  
		System.out.print("Enter Night Temperature- ");  
		int nighttemp= sc.nextInt();  
		int avgtemp = (morntemp+eventemp+nighttemp)/3;
		return jdbcTemplate.update("insert into record(city,morntemp,eventemp,nighttemp,avgtemp)values('" + city + "','" + morntemp + "','"+ eventemp +"','"+nighttemp+"','"+avgtemp+"')");
					
			
	}
	
	public int deleteCity() {
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.print("Enter City you want to delete- ");  
		String city= sc.nextLine();  
		return jdbcTemplate.update("delete from record where city='"+city+"'");
	}
	
	public int updateCity() {
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter City you want to update temperature- ");  
		String city= sc.nextLine();  
		System.out.print("Enter Morning Temperature- ");  
		int morntemp= sc.nextInt();  
		System.out.print("Enter Evening Temperature- ");  
		int eventemp= sc.nextInt();  
		System.out.print("Enter Night Temperature- ");  
		int nighttemp= sc.nextInt(); 
		int avgtemp = (morntemp+eventemp+nighttemp)/3;
		return jdbcTemplate.update("update record set morntemp='" + morntemp + "',eventemp='"+ eventemp +"',nighttemp='"+nighttemp+"',avgtemp='"+avgtemp+"' where city='"+city+"'");
		
	}
	
	private final static class Citymapper implements RowMapper<CityBean>{

		@Override
		public CityBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			CityBean cityBean = new CityBean();
			cityBean.setCity(rs.getString("city"));
			cityBean.setMorntemp(rs.getInt("morntemp"));
			cityBean.setEventemp(rs.getInt("eventemp"));
			cityBean.setNighttemp(rs.getInt("nighttemp"));
			cityBean.setAvgtemp(rs.getInt("avgtemp"));
			return cityBean;
			
			
		}				
	}
	public CityBean getCityBeanByName() {

		Scanner sc= new Scanner(System.in);
		System.out.print("Enter City name which you want temperature- ");  
		String city= sc.nextLine();  
		
		return jdbcTemplate.queryForObject("select * from record where city ='" + city + "'", new Citymapper());
	}
	public CityBean getAvgTempByName() {

		Scanner sc= new Scanner(System.in);
		System.out.print("Enter City name which you want Average temperature- ");  
		String city= sc.nextLine();  
		
		return jdbcTemplate.queryForObject("select * from record where city ='" + city + "'", new Citymapper());
	}
	
	
}
