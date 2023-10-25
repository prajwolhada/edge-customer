package com.f1soft.bankxp.edge.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EntityScan(basePackages = {"com.f1soft.bankxp.*", "com.flsoft.bankxp.edge.entities.*"})
@SpringBootApplication(scanBasePackages = {"com.f1soft.bankxp.*", "com.flsoft.bankxp.edge.entities.*"})
public class EdgeCustomerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EdgeCustomerApplication.class, args);
    }

}
