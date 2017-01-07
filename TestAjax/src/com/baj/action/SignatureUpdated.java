package com.baj.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignatureUpdated
 */
public class SignatureUpdated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignatureUpdated() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet service called");
		response.setContentType("text/html;charset=UTF-8");
		String contractSignDate = request.getParameter("dateSelected");
		//String checkBoxTicked = request.getParameter("signCheck");
	//	System.out.println("value of checkbox in servelt  ::"+checkBoxTicked);
		System.out.println(contractSignDate);
		//boolean check = isChecked(checkBoxTicked);
		
		
		PrintWriter out = response.getWriter();
		if(contractSignDate!=null && contractSignDate!=""){
			updateContractSignature();//  call here loan services signature web service
			out.print("updated");
		}
		else
		{
			System.out.println("Customer didnot signed contract application"); // show alert message and disable create button
			out.print("notUpdated");
		}

		
	}
	boolean isChecked(String checkBox){
		boolean check1 = false;
		if(checkBox.equalsIgnoreCase("YES")){
			check1 = true;
		}else{
			check1 = false;
		}
		return check1;
	}
	
	void updateContractSignature(){
		
		System.out.println("Signature Updated in Contract application");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet get called");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet post called");
			}

}
