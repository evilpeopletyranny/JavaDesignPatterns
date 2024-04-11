package lifeCycle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Конфигурационный класс в котором указан пакет для сканирования
@Configuration
@ComponentScan(basePackages = "lifeCycle")
public class AnnotationScanConfig {
}
