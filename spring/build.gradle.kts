plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("ch.qos.logback:logback-classic:1.5.3")

    //Версии пакетов Spring должны совпадать, поэтому версию лучше вынести в отдельную переменную
    val springVersion = "6.1.5"

    //зависимости для работы со Spring в рамках ЛР
    implementation("org.springframework:spring-core:${springVersion}")
    implementation("org.springframework:spring-beans:${springVersion}")
    implementation("org.springframework:spring-context-support:${springVersion}")
    implementation("org.springframework:spring-aop:${springVersion}")

    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")


    implementation("org.aspectj:aspectjrt:1.9.22")
    implementation("org.aspectj:aspectjweaver:1.9.22")
}

tasks.test {
    useJUnitPlatform()
}