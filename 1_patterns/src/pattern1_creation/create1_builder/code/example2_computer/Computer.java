package pattern1_creation.create1_builder.code.example2_computer;

public class Computer {
    // Обязательные параметры
    private String CPU;
    private String RAM;

    // Опциональные параметры
    private String storage;
    private String GPU;
    private String OS;

    /**
     * Приватный конструктор, который принимает в себя билдер.
     *
     * @param builder
     */
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.OS = builder.OS;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", GPU='" + GPU + '\'' +
                ", OS='" + OS + '\'' +
                '}';
    }

    /**
     * Вложенный статичсекий класс Билдер.
     */
    public static class Builder {
        // Обязательные параметры
        private String CPU;
        private String RAM;

        // Опциональные параметры
        private String storage;
        private String GPU;
        private String OS;

        /**
         * В конструкторе указываются обязательные поля.
         *
         * @param CPU
         * @param RAM
         */
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        /**
         * Метод оптицианальной установки поля storage
         *
         * @param storage значение для поля storage
         */
        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        /**
         * Метод оптицианальной установки поля GPU
         *
         * @param GPU значение для поля GPU
         */
        public Builder GPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        /**
         * Метод оптицианальной установки поля OS
         *
         * @param OS значение для поля OS
         */
        public Builder OS(String OS) {
            this.OS = OS;
            return this;
        }

        /**
         * Метод построения объекта на основе билдера.
         *
         * @return созданный класс Computer
         */
        public Computer build() {
            return new Computer(this);
        }
    }
}

