import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = true

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation(project(":member"))
    implementation(project(":family"))
    implementation(project(":post"))
    implementation(project(":mission"))

    runtimeOnly("mysql:mysql-connector-java:8.0.33")
    runtimeOnly("com.h2database:h2")
}
