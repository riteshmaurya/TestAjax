package com.baj.action;

import java.io.IOException;
import java.io.PrintWriter;
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

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String countryCode = request.getParameter("countryCode");
System.out.println(countryCode);
System.out.println("sssss");
PrintWriter out = response.getWriter();
response.setContentType("text/html");
response.setHeader("Cache-control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "POST");
response.setHeader("Access-Control-Allow-Headers", "Content-Type");
response.setHeader("Access-Control-Max-Age", "86400");

Gson gson = new Gson(); 
JsonObject myObj = new JsonObject();

List<Country> countryInfo = getInfo(countryCode);
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

}

//Get Country Information
private List<Country> getInfo(String countryCode) {
	List<Country> countryList = new ArrayList<Country>();
	
	/*Country country = new Country();
	country.setCode("01");
	country.setName("INDIA");
	country.setRegion("CENTRAL");
	country.setContinent("ASIA");
	country.setGnp(100000.00);
	country.setLifeExpectancy(85.6);
	countryList.add(country);
	*/
	Country country2 = new Country();
	country2.setCode("01");
	country2.setName("INDIAaaa");
	country2.setRegion("CENTRALaaaa");
	country2.setContinent("ASIAaaaa");
	country2.setGnp(100000.00);
	country2.setLifeExpectancy(85.6);
	countryList.add(country2);
	
	Country country3 = new Country();
	country3.setCode("01");
	country3.setName("INDIAbbbb");
	country3.setRegion("CENTRALbbbb");
	country3.setContinent("ASIAbbbb");
	country3.setGnp(100000.00);
	country3.setLifeExpectancy(85.6);
	countryList.add(country3);
	
	Country country4 = new Country();
	country4.setCode("01");
	country4.setName("INDIAcccc");
	country4.setRegion("CENTRALcccc");
	country4.setContinent("ASIAccccc");
	country4.setGnp(100000.00);
	country4.setLifeExpectancy(85.6);
	countryList.add(country4);
	/*if(country.getCode().equals(countryCode)){
		return country;
	}
		else {
			return country;
		}*/
	return countryList;
	}
	
	
	
	
	

/*Country country = new Country();
Connection conn = null; 
PreparedStatement stmt = null; 
String sql = null;

try { 
Context ctx = (Context) new InitialContext().lookup("java:comp/env");
conn = ((DataSource) ctx.lookup("jdbc/mysql")).getConnection(); 

sql = "Select * from COUNTRY where code = ?"; 
stmt = conn.prepareStatement(sql);
stmt.setString(1, countryCode.trim());
ResultSet rs = stmt.executeQuery(); 

while(rs.next()){ 
country.setCode(rs.getString("code").trim());
country.setName(rs.getString("name").trim());
country.setContinent(rs.getString("continent").trim());
country.setRegion(rs.getString("region").trim());
country.setLifeExpectancy(rs.getString("lifeExpectancy") == null ? new Double(0) : Double.parseDouble(rs.getString("lifeExpectancy").trim()));
country.setGnp(rs.getString("gnp") == null ? new Double(0) : Double.parseDouble(rs.getString("gnp").trim()));
} 

rs.close(); 
stmt.close(); 
stmt = null; 


conn.close(); 
conn = null; 

} 
catch(Exception e){System.out.println(e);} 

finally { 

if (stmt != null) { 
try { 
stmt.close(); 
} catch (SQLException sqlex) { 
// ignore -- as we can't do anything about it here 
} 

stmt = null; 
} 

if (conn != null) { 
try { 
conn.close(); 
} catch (SQLException sqlex) { 
// ignore -- as we can't do anything about it here 
} 

conn = null; 
} 
} 

return country;
*/
} 

