# Pokemon Moves Thai Backend

## 📝 คำอธิบาย
โปรเจคนี้เป็น Backend API ที่พัฒนาด้วย Spring Boot สำหรับระบบจัดการข้อมูล Pokemon Moves

## 🚀 เทคโนโลยีที่ใช้
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Maven
- Docker

## 📋 ข้อกำหนดเบื้องต้น
- JDK 17 หรือสูงกว่า
- Maven 3.6.x หรือสูงกว่า
- Docker และ Docker Compose (สำหรับการรันใน container)
- PostgreSQL (สำหรับการพัฒนาบน localhost)

## 🛠️ การติดตั้งและรันโปรเจค

### การรันแบบ Local Development
1. Clone โปรเจค
```bash
git clone [URL ของโปรเจค]
```

2. ตั้งค่าฐานข้อมูล PostgreSQL
- สร้างฐานข้อมูลชื่อ `pokemon_move_db`
- ตั้งค่า username และ password ตามที่กำหนดใน `application.properties`

3. รันโปรเจคด้วย Maven
```bash
mvn spring-boot:run
```

### การรันด้วย Docker
1. สร้าง Docker image
```bash
docker build -t pokemon-move-backend .
```

2. รัน container
```bash
docker-compose up -d
```

## 📚 API Documentation
API Documentation สามารถเข้าถึงได้ที่:
- ดึงข้อมูลท่า Pokemon ทั้งหมด: `http://localhost:8080/api/pokemonmoves?page=หน้าที่อยากได้&size=จำนวนท่าpokemonที่จะดึงออกมา`
- ค้นหาท่า Pokemon : `http://localhost:8080/api/pokemonmoves/search?name=ชื่อpokemon`
- ใช้หาชื่อท่าใกล้เคียง จาก keyword : `http://localhost:8080/api/pokemonmoves/autocomplete?keyword=ใส่keyword`

## 🏗️ โครงสร้างโปรเจค
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── pokemonmove/
│   │           ├── controller/
│   │           ├── service/
│   │           ├── repository/
│   │           ├── model/
│   │           └── config/
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── pokemonmove/
```

## 🧪 การทดสอบ
รันการทดสอบทั้งหมดด้วยคำสั่ง:
```bash
mvn test
```

## 📦 การ Deploy
1. สร้าง JAR file
```bash
mvn clean package
```

2. รัน JAR file
```bash
java -jar target/pokemon-move-backend-0.0.1-SNAPSHOT.jar
```

## 🤝 การมีส่วนร่วม
1. Fork โปรเจค
2. สร้าง Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit การเปลี่ยนแปลง (`git commit -m 'Add some AmazingFeature'`)
4. Push ไปยัง Branch (`git push origin feature/AmazingFeature`)
5. เปิด Pull Request

## 📄 License
โปรเจคนี้อยู่ภายใต้ลิขสิทธิ์ MIT - ดูรายละเอียดเพิ่มเติมในไฟล์ [LICENSE](LICENSE)

## 📞 ติดต่อ
- Email: [yok555@outlook.com]
