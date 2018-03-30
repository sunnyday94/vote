package com.chunmi.vote.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chunmi.vote.po.VoteUsers;
import com.chunmi.vote.utils.Constant;


@WebFilter(filterName="LoginCheckFilter",urlPatterns="/*")
public class LoginCheckFilter implements Filter{


	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String servletPath = req.getServletPath();
		if(!servletPath.endsWith(".css") && !servletPath.endsWith(".js") && !servletPath.endsWith(".jpg") &&
				!servletPath.endsWith("checkLogin") && !servletPath.endsWith("login") && !servletPath.endsWith("register")
				&& !servletPath.endsWith("checkRegister")) {
			VoteUsers voteUser = (VoteUsers) req.getSession().getAttribute(Constant.LOGIN_MANAGER);
			if(voteUser == null) {
				res.sendRedirect(req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/admin/login");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
