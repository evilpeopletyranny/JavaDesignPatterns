package structural.bridge.code.devices;

/**
 * "Асбтрактный класс" реализации девайса.
 * "Реализация"
 */
public interface Device {
    boolean isEnable();

    void enable();

    void disable();

    Integer getVolume();

    void setVolume(Integer volume);

    Integer getChannel();

    void setChannel(Integer channel);
}
