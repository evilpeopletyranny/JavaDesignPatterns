package structural.bridge.code.devices;

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
