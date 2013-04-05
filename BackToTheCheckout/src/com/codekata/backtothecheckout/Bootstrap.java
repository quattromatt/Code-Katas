package com.codekata.backtothecheckout;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Bootstrap {

	private static ApplicationContext m_context;

//	private static final String APPLICATION_CONTEXT_FILE = "spring/backtothecheckout/application-main-context.xml";
	private static final String APPLICATION_CONTEXT_FILE = "src/main/resources/spring/backtothecheckout/application-main-context.xml";

	private static final String[] SPRING_FILES = { APPLICATION_CONTEXT_FILE };
	public static void init() {

		// Base context
		GenericApplicationContext baseContext = new GenericApplicationContext();
		baseContext.refresh();

		int numResources = SPRING_FILES.length;
		String[] resources = new String[numResources];
		int resourceIndex = 0;

		for (int i = 0; i < SPRING_FILES.length; i++) {
			resources[resourceIndex] = SPRING_FILES[i];
			resourceIndex++;
		}

		boolean refresh = true;

		m_context = new ClassPathXmlApplicationContext(resources, refresh, baseContext);
	}

	public static ApplicationContext getContext() {
		return m_context;
	}
}