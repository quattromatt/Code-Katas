package com.codekata.backtothecheckout;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bootstrap {

	private static AnnotationConfigApplicationContext m_context;

	public static void init() {

		// Create an annotation based context
		m_context = new AnnotationConfigApplicationContext(Config.class);
	}

	public static ApplicationContext getContext() {
		return m_context;
	}
}