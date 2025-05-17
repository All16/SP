package com.example.ciuleSP.difexample;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class RequestResponseLoggingFilter implements jakarta.servlet.Filter {


    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class); // Create a logger instance for this class
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

       logger.info("Logging Request {} : {}", req.getMethod(), req.getRequestURI()); // Log the incoming request details

         chain.doFilter(request, response);// Proceed with the filter chain

        logger.info("Logging Response: {}", res.getContentType());// Log the outgoing response details
    }

    // Additional methods can be added if necessary
}
