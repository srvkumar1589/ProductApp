package com.rakuten.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rakuten.training.spring.ui.ProductConsoleUI;

public class ProductApp {
	public static void main(String[] args) {
	//ApplicationContext springContainer=new ClassPathXmlApplicationContext("applicationContext.xml");
   // ProductConsoleUI ui=springContainer.getBean("uiObj",ProductConsoleUI.class);
		ApplicationContext springContainer=new AnnotationConfigApplicationContext(ProductAppConfiguration.class);
	ProductConsoleUI ui=springContainer.getBean(ProductConsoleUI.class);
    ui.ProductWithUI();
  }
}
/*<bean id="daoObj" class="com.rakuten.training.spring.dal.ProductDAOInMemImpl">
</bean>
<bean id="serviceObj" class="com.rakuten.training.spring.service.ProductServiceImpl" autowire="byType">
</bean>
<bean id="uiObj" class="com.rakuten.training.spring.ui.ProductConsoleUI" autowire="byType">
</bean>
*/