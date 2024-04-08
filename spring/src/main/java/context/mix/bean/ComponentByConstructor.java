package context.mix.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Компонент, инициализация которого происходит через
 * конструктор.
 */
@Component
@PropertySource("component.property")   //файл в resources, в котором прописаны данные для инициализации
public class ComponentByConstructor {
    String host;
    String port;
    String creationsType;
    Integer connections;

    /**
     * Конструктор с параметрами.
     * Параметры беруться из resources/component.property
     */
    public ComponentByConstructor(@Value("${componentByConstructor.host}") String host,
                                  @Value("${componentByConstructor.port}") String port,
                                  @Value("${componentByConstructor.creationsType}") String creationsType,
                                  @Value("${componentByConstructor.connections}") Integer connections) {
        this.host = host;
        this.port = port;
        this.creationsType = creationsType;
        this.connections = connections;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getCreationsType() {
        return creationsType;
    }

    public void setCreationsType(String creationsType) {
        this.creationsType = creationsType;
    }

    public Integer getConnections() {
        return connections;
    }

    public void setConnections(Integer connections) {
        this.connections = connections;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", creationsType='" + creationsType + '\'' +
                ", connections=" + connections +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentByConstructor that = (ComponentByConstructor) o;
        return Objects.equals(host, that.host)
                && Objects.equals(port, that.port)
                && Objects.equals(creationsType, that.creationsType)
                && Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, creationsType, connections);
    }
}
