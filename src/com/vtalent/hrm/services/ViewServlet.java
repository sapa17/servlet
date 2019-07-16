package com.vtalent.hrm.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtalent.hrm.beans.Employee;
import com.vtalent.hrm.dao.DBOperations;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ID = request.getParameter("employeeID");
		int empID = Integer.parseInt(ID);

		Employee emp = new Employee();

		DBOperations db = new DBOperations();
           Employee view = db.SearchByID(empID);
		if (view != null ) {
				out.println("<html><body>");
				out.println("<table>");
				out.println("<tr style='background-color:red'><td>Employee ID:  "  + view.getEmployeeID());
				out.println("<tr style='background-color:red'><td>Employee Name: " + view.getEmployeeName());
				out.println("<tr style='background-color:red'><td>Employee Salary:  " + view.getEmployeeSalary());
				out.println("<tr style='background-color:red'><td>Employee Mobile : " + view.getEmpolyeeMobile());
				out.println("<tr style='background-color:red'><td>Employee Address :" + view.getEmployeeAddress());
				out.println("</table>");
				out.println("</body></html>");
			
		}else {
			out.println("Insert the Employee Data first" + '\n');
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
