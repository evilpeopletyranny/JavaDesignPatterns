package context.mix.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("bySetters")                 //при необходимости мы можем сами задать id компонента
@PropertySource("component.property")   //файл в resources, в котором прописаны данные для инициализации
public class ComponentBySetters {
    String host;
    String port;
    String creationsType;
    Integer connections;

    public ComponentBySetters() {
    }

    public String getHost() {
        return host;
    }

    @Value("${componentBySetters.host}")
    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    @Value("${componentBySetters.port}")
    public void setPort(String port) {
        this.port = port;
    }

    public String getCreationsType() {
        return creationsType;
    }

    @Value("${componentBySetters.creationsType}")
    public void setCreationsType(String creationsType) {
        this.creationsType = creationsType;
    }

    public Integer getConnections() {
        return connections;
    }

    @Value("${componentBySetters.connections}")
    public void setConnections(Integer connections) {
        this.connections = connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentBySetters that = (ComponentBySetters) o;
        return Objects.equals(host, that.host)
                && Objects.equals(port, that.port)
                && Objects.equals(creationsType, that.creationsType)
                && Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, creationsType, connections);
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
}
