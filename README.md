# TCP/IP 연결 라이브러리

---
![test](https://img.shields.io/badge/TEST-passing-secuees?logo=Symantec)
![version](https://img.shields.io/badge/version-0.1.16-9cf)
![test](https://img.shields.io/badge/java-1.8-blueviolet?logo=OpenJDK)

# UML 

---

![](uml2.png)

## 내부 기능
- ![HTTP(GET)](https://img.shields.io/badge/HTTP(GET)-green)
  ![tcp](https://img.shields.io/badge/IP_PORT-orange)
  ![ip](https://img.shields.io/badge/IP-blue) 연결 여부 확인
- 비동기 작업으로 성능 개선



### 설정 방법 

---

```
repositories {
    mavenCentral()
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.oiNeh:tcp:0.1.16'
}
```
