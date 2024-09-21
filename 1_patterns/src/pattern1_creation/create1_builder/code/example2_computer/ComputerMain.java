package pattern1_creation.create1_builder.code.example2_computer;

public class ComputerMain {
    public static void main(String[] args) {
        // Создание компьютера с использованием Fluent Interface
        Computer gamingPC = new Computer.Builder("AMD Ryzen 9", "32GB")
                .storage("2TB NVMe SSD")
                .GPU("NVIDIA RTX 3090")
                .OS("Windows 11")
                .build();

        System.out.println(gamingPC);

        // Создание простого компьютера
        Computer basicPC = new Computer.Builder("Intel i3", "4GB")
                .storage("256GB SSD")
                .build();

        System.out.println(basicPC);
    }
}
