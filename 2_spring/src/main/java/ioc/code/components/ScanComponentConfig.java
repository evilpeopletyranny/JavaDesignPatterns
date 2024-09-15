package ioc.code.components;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ioc.code.components")
public class ScanComponentConfig {
}