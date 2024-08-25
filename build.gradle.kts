import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25" apply false
	id("org.springframework.boot") version "3.3.3" apply false
	id("io.spring.dependency-management") version "1.1.6" apply false

}

allprojects {
	group = "com.bibbi"
	version = "0.0.1-SNAPSHOT"

	tasks.withType<JavaCompile> {
		sourceCompatibility = "17"
		targetCompatibility = "17"
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-kapt")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	configurations {
		compileOnly {
			extendsFrom(configurations.getByName("annotationProcessor"))
		}
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-validation")
		implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
		implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
		implementation("org.springframework.boot:spring-boot-starter-actuator")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-security")
		implementation("com.github.f4b6a3:ulid-creator:5.2.2")
		implementation("io.jsonwebtoken:jjwt-api:0.11.5")
		runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
		runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
		compileOnly("org.projectlombok:lombok")
		annotationProcessor("jakarta.annotation:jakarta.annotation-api")
		annotationProcessor("jakarta.persistence:jakarta.persistence-api")
		annotationProcessor("org.projectlombok:lombok")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.springframework.security:spring-security-test")
		testImplementation("org.awaitility:awaitility:4.2.0")
	}
}
