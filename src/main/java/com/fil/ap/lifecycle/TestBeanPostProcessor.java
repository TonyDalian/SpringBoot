package com.fil.ap.lifecycle;

import org.springframework.beans.BeansException;  
import org.springframework.beans.factory.config.BeanPostProcessor;  
import org.springframework.stereotype.Component;  
  
@Component  
public class TestBeanPostProcessor implements BeanPostProcessor {  
  
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {  
    	
        if (bean instanceof MyMode) {  
        	
            System.out.println("BeanPostProcessor postProcessBeforeInitialization called");  
        }  
        
        return bean;  
    }  
  
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {  
        
    	if (bean instanceof MyMode) {  
    		
            System.out.println("BeanPostProcessor postProcessAfterInitialization called");  
        }  
    	
        return bean;  
    }  
}  