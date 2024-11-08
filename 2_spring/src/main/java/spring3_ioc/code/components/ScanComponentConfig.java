package spring3_ioc.code.components;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "spring3_ioc.code.components")
public class ScanComponentConfig {
}