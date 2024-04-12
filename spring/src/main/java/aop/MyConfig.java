package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Конфигурационный класс
 * Сканирование пакета aop
 * <p>
 * @EnableAspectJAutoProxy позволяет использовать Аспект-прокси.
 * proxyTargetClass = true обозначает что аспекты можно создвать через интерфейсы.
 * Без указания данного параметра при работе с бинами, которые реализуют интерфейсы произойдет
 * сложно и не понятная ошибка...
 */
@Configuration
@ComponentScan("aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyConfig {
}
