package pattern2_structural.struct3_bridge.code.example2_devices;

/**
 * Уточненная абстракция - радио
 */
public class Radio implements Device {
    private boolean status;
    private Integer channel;
    private Integer volume;

    @Override
    public boolean isEnable() {
        return this.status;
    }

    @Override
    public void enable() {
        this.status = true;
    }

    @Override
    public void disable() {
        this.status = false;
    }

    @Override
    public Integer getVolume() {
        return this.volume;
    }

    @Override
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public Integer getChannel() {
        return this.channel;
    }

    @Override
    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}
