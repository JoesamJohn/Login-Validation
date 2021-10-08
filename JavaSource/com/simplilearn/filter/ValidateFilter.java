package com.simplilearn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ValidateFilter implements Filter {

    public ValidateFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		System.out.println("UserId: " +userId+ " & Password: " +password+ " inside the filter");

		if(userId.equals("joesam")&&password.equals("Jeremy@123")) {
			chain.doFilter(request, response);						
		}
		else {
			httpResponse.sendRedirect("error");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
