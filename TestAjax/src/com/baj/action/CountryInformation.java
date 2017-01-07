package com.baj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CountryInformation extends HttpServlet {

private static final long serialVersionUID = 1L;

public CountryInformation() {
super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

String countryCode = request.getParameter("countryCode");
System.out.println(countryCode);
System.out.println("sssss");
PrintWriter out = response.getWriter();

//response.setContentType("text/html");
//request.setCharacterEncoding("utf8");
//response.setCharacterEncoding("utf-8");
response.setContentType("application/json"); 
response.setHeader("Cache-control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
/*
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "POST");
response.setHeader("Access-Control-Allow-Headers", "Content-Type");
response.setHeader("Access-Control-Max-Age", "86400");*/

Gson gson = new Gson(); 
JsonObject myObj = new JsonObject();

//JsonObject jsonObj = (JsonObject) Json.parse(request.getParameter("para"));

List<Country1> countryInfo;
try {
	countryInfo = getInfo(countryCode);
	JsonElement countryObj = gson.toJsonTree(countryInfo);
	if(countryInfo == null){
	myObj.addProperty("success", false);
	}
	else {
	myObj.addProperty("success", true);
	}
	myObj.add("countryInfo", countryObj);
	out.println(myObj.toString());
	System.out.println(myObj.toString());
	out.close();

} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}

//Get Country Information
private List<Country1> getInfo(String countryCode) throws ClassNotFoundException {
	List<Country1> countryList = new ArrayList<Country1>();
	try {
		//Class.forName("java.sql.DriverManager");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "admin");//jdbc:oracle:thin:@<host>:<port>:<SID> 
		System.out.println(con);
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from FSCITY");
		System.out.println(rs.getFetchSize());
		while(rs.next()){
		
			Country1 country1 = new Country1();
			
			country1.setC_NAME(rs.getString("C_NAME"));
			
			country1.setC_CODE(rs.getInt("R_CODE"));
			
			country1.setSERIAL_NO(rs.getInt("SERIAL_NO"));
			
			countryList.add(country1);
			
			
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return countryList;
	
}
	
	
public static void main(String[] args) throws ClassNotFoundException {
	CountryInformation c = new CountryInformation();
	System.out.println(c.getInfo("").get(0).getC_NAME());
	
}
} 

