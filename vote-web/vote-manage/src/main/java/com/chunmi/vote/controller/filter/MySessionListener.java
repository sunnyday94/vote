package com.chunmi.vote.controller.filter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class MySessionListener implements HttpSessionListener {
	
	private static Integer activeSession = 0;
	
	//session被创建时候执行
	@SuppressWarnings("unchecked")
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		log.info("session被创建,sessionId为{}",session.getId());
		session.setMaxInactiveInterval(300); //设置session过期时间为五分钟
		ServletContext sc = session.getServletContext();
		Set<String> sessionIds = (Set<String>) sc.getAttribute("sessionIds");
		if(sessionIds == null) {
			sessionIds = new HashSet<String>();
			sc.setAttribute("sessionIds", sessionIds);
		}
		sessionIds.add(session.getId());
	}

	//session被销毁时候执行
	@SuppressWarnings("unchecked")
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		log.info("session被销毁!sessionid is{}",session.getId());
		ServletContext sc = session.getServletContext();
		Set<String> sessionIds = (Set<String>) sc.getAttribute("sessionIds");
		if(sessionIds!=null && sessionIds.size()>0) {
			sessionIds.remove(session.getId());
			activeSession = sessionIds.size();
		}
	}

	public static Integer getActiveSession() {
		return activeSession;
	}

	public static void setActiveSession(Integer activeSession) {
		MySessionListener.activeSession = activeSession;
	}

}
