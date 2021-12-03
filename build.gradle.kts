plugins {
    kotlin("jvm") version "1.5.10"
}

group = "com.renato"
version = "1.0-SNAPSHOT"
val junitJupiterVersion="5.8.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}