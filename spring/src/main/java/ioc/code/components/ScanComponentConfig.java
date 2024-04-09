package ioc.code.components;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ComponentB.class)
public class ScanComponentConfig {
}