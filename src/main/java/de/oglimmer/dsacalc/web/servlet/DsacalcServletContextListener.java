package de.oglimmer.dsacalc.web.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import de.oglimmer.dsacalc.services.DsacalcVersion;

@WebListener
public class DsacalcServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		DsacalcVersion.INSTANCE.init(sce);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
