package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.personnes.Personne;


@WebFilter("/gerant/*")
public class GerantFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;	
		Personne usercheck  = (Personne) req.getSession().getAttribute("user");
		
		if (usercheck != null) {
		if (usercheck.getRolePersonne() == 1 || usercheck.getRolePersonne() == 2 ) {
			System.out.println("Acc�s autoris�");
			chain.doFilter(request, response);
		} else {
			System.out.println("Acc�s refus�");
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("../Accueil");
	}
	} else {
		System.out.println("Acc�s refus�");
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.sendRedirect("../Accueil");
}
	}

}
