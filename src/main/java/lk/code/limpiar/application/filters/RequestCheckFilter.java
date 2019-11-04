package lk.code.limpiar.application.filters;

import lk.code.limpiar.application.exception.types.FilterException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class RequestCheckFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		final String[] ignoredRoutes = new String[]{
				"/actuator/prometheus"
		};
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
	//	LOG.info(
	//			"Logging Request  {} : {}", req.getMethod(),
//				req.getRequestURI());
		chain.doFilter(request, response);
	//	LOG.info(
	//			"Logging Response :{}",
	//			res.getContentType());
		
		List<String> contentType = (List<String>) req.getHeaders(HttpHeaders.CONTENT_TYPE);
		String endpoint = ((HttpServletRequest) request).getPathInfo();
		
		// check ignored routes
		if (Arrays.asList(ignoredRoutes).contains(endpoint)) {
			chain.doFilter(request, response);
		}
		
		if (contentType == null) {
			new FilterException("No content type");
		}
		
		if (!contentType.get(0).equals("application/json")) {
			new FilterException("Only accepts JSON");
		}
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {}

	@Override
	public void destroy() {
	
	}
}
