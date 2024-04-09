package di.annotation.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages  = "di.annotation.bean")
public class JavaScanConfig {
}
