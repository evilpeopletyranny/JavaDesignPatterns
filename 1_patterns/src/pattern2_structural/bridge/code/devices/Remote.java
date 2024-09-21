package pattern2_structural.bridge.code.devices;

/**
 * Класс Remote (пульт) представляет собой Абстракцию — механизм управления девайсом, который
 * делегирует Реализацию интерфейсу Device.
 * "Абстракция"
 */
public class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    void togglePower() {
        if (device.isEnable()) device.disable();
        else device.enable();
    }

    void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    void channelUp() {
        device.setVolume(device.getChannel() + 1);
    }
}
