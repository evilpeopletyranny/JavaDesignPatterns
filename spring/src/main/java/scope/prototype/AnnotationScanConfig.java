package scope.prototype;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PrototypeService.class)
public class AnnotationScanConfig {
}
