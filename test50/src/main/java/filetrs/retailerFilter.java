package filetrs;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/retailer/*")
public class retailerFilter extends HttpFilter implements Filter {
  
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("retailer filter"); 
		HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;
	        HttpSession session = request.getSession(false);
	        
	        if (session == null || (String)session.getAttribute("userName") == null||session.getAttribute("role")!="Retailer_Role") {
	        	try {
	        		System.out.println(session.getAttribute("userName")+" wrong 1"); 
	        		response.sendRedirect(request.getContextPath()+"/login.jsp");
	        	} catch ( IOException e) {
	        		e.printStackTrace();
	        	}
	        } else {
	        	 
	            chain.doFilter(req, res);
	        }
		
	}

	

}
