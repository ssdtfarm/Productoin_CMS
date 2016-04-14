package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * IE Filter. Helps proper rendering on Internet Explorer 9.
 */
public class IEFilter implements Filter {

	private final static Log LOG = LogFactory.getLog(IEFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		// noop
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		((HttpServletResponse) response).setHeader("X-UA-Compatible", "IE=EmulateIE8");

		String accept = ((HttpServletRequest) request).getHeader("Accept");
		if ("text/css".equals(accept)) {
			chain.doFilter(new IEHttpServletRequestWrapper(
					(HttpServletRequest) request), response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		// noop
	}

	private class IEHttpServletRequestWrapper extends
			HttpServletRequestWrapper {
		public IEHttpServletRequestWrapper(HttpServletRequest request) {
			super(request);
		}
		@Override
		public String getHeader(String name) {
			String header = super.getHeader(name);
			if ("text/css".equalsIgnoreCase(header)) {
				header = "text/css, */*";
			}
			return header;
		}
	}
}