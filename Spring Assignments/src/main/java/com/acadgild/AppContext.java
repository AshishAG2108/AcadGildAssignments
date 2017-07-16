package com.acadgild;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContext implements ApplicationContextAware {

	static final long serialVersionUID = 02L;

	ApplicationContext applicationContext = null;

	/*public void doSomething() {
		if (applicationContext != null
				&& applicationContext.containsBean("helloBean")) {
			HelloWorld helloBean = (HelloWorld) applicationContext
					.getBean("helloBean");
			// Do something with this AccessBean
		}

	}
*/
	public void setApplicationContext(
			final ApplicationContext applicationContext) throws BeansException {
		System.out.println("setting context");
		this.applicationContext = applicationContext;

	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
