package ioc.code.beanfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScanBeanConfig {
    @Bean
    public ComponentA componentA() {
        return new ComponentA("Component bean");
    }
}
