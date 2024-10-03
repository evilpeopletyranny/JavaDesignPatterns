package pattern2_structural.struct3_bridge.code.example2_devices;

/**
 * Более навороченный пульт.
 * Добавили в иерархию пультов новый тип, не трогая устройства.
 */
public abstract class AdvancedRemote extends Remote {

    public AdvancedRemote(Device device) {
        super(device);
    }

    void mute() {
        device.setVolume(0);
    }
}
