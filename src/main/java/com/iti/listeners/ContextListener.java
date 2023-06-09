package com.iti.listeners;

import com.iti.persistence.JPAFactoryManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("***** Context Initialized *****");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JPAFactoryManager.closeEntityManagerFactory();
    }
}
