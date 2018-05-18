package com.icomp.core;

import com.icomp.common.constant.IConstant;
import com.icomp.common.exception.ApplicationException;
import com.icomp.common.exception.BusinessException;
import com.icomp.entity.base.Customer;
import com.icomp.entity.base.Languagetable;
import com.icomp.entity.base.Vgrantlist;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限过滤器
 * 
 * @author yzq
 * 
 */
public class Interceptor implements Filter {

	public void destroy() {

	}

	List<String> urlList = new ArrayList<String>();
	List<String> menuList = new ArrayList<String>();

	/**
	 * 用户权限判断
	 * 
	 * @param servletRequest
	 * @param servletResponse
	 * @param filterChain
	 * 
	 * @throws IOException
	 *             , ServletException
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		String base = request.getContextPath();
		String opcode = request.getRequestURI().substring(base.length());
		String path = "";
		boolean isOn = true;
		try {
			if (!isOn) {
				// 如果无需权限验证 ,直接进行跳转
				filterChain.doFilter(request, response);
			} else {

				// 取得用户名
					Customer entity = (Customer) session.getAttribute("Customer");
				// 如果请求以.action结尾则进行权限判断
				if (opcode.endsWith(".action")) {

					// 如果请求URL在不需验证列表中存在则直接跳转
					if (urlList.contains(opcode)) {
						if ("/login.action".equals(opcode)
								|| "/checkInput.action".equals(opcode)) {
							if (session.getAttribute("Languagetable") == null) {
								response
										.setContentType("text/html;charset=utf-8");
								PrintWriter out = response.getWriter();
								String script = "<script type=\"text/javascript\">top.location.href = '/icomp' + '/"
										+ path + "'</script>";
								out.print(script);
							} else {
								// 页面跳转
								filterChain.doFilter(request, response);
							}
						} else {
							// 页面跳转
							filterChain.doFilter(request, response);
						}
					} else {
						// 如果session存在,则对该请求进行权限判断
						if (session.getAttribute("Languagetable") == null
								|| entity == null) {
							response.setContentType("text/html;charset=utf-8");
							PrintWriter out = response.getWriter();
							String script = "<script type=\"text/javascript\">top.location.href = '/icomp/login.action'</script>";
							out.print(script);
						} else {
							// 权限判断
							List<Vgrantlist> list = (List<Vgrantlist>) session
									.getAttribute("CustomerGrant");
							path = "initialization.action";
							for (Vgrantlist vgrantlist : list) {

								if (opcode.indexOf(vgrantlist
										.getCapabilityUrl()) >= 0) {
									path = "";
								}

							}
							if (!"".equals(path)) {
								throw new BusinessException(IConstant.EMSG0003,
										((Languagetable) session
												.getAttribute("Languagetable"))
												.getLanguageCode(),
										((Languagetable) session
												.getAttribute("Languagetable"))
												.getLanguageValue());

							} else {
								filterChain.doFilter(request, response);
							}
						}
					}
				} else {
					filterChain.doFilter(request, response);
				}
			}
		} catch (BusinessException ex) {
			ApplicationException.setApplicationException(response, opcode,
					IConstant.RESULT_CODE_3, ex, this.getClass().getName(),
					"doFilter", ((Customer) session.getAttribute("Customer"))
							.getCustomerID());
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

		urlList.add("/checkInput.action");
		urlList.add("/initialization.action");
		urlList.add("/login.action");
		urlList.add("/logout.action");
		urlList.add("/init.action");
		urlList.add("/index.action");
		urlList.add("/getLanguage.action");
		urlList.add("/editLanguage.action");
		urlList.add("/ChangePassword.action");
	}

}
