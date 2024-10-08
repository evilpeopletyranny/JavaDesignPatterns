package pattern2_structural.struct3_bridge.code.example2_devices;

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
