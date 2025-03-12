# 🍽️ Maisto Užsakymo Sistema

Ši aplikacija leidžia administruoti maitinimo įstaigas, valgiaraščius ir priimti maisto užsakymus.

---

## 📌 Pagrindinės funkcijos
✅ Maitinimo įstaigų valdymas  
✅ Valgiaraščių redagavimas  
✅ Užsakymų priėmimas ir administravimas  
✅ Vartotojų vaidmenys: administratorius ir klientas  
✅ Modernus frontend su HTML, CSS ir JavaScript  
✅ Backend su Spring Boot ir MySQL  

---

## ⚙️ Diegimo instrukcijos

### 1️⃣ Sistemos reikalavimai
- **🖥️ Operacinė sistema:** Linux (rekomenduojama) arba Windows 10
- **🛠️ IDE:** IntelliJ IDEA, Eclipse, arba NetBeans
- **🌐 Lokalūs serveriai:** Apache Tomcat (backend), `npx serve` (frontend)
- **💾 Duomenų bazė:** MySQL arba MariaDB
- **📂 Versijų kontrolė:** Git

---

### 2️⃣ Projekto paleidimas

#### 📌 2.1. Duomenų bazės sukūrimas
1. Įdiekite MySQL arba MariaDB.
2. Atidarykite MySQL terminalą ir vykdykite SQL komandą:
   ```sql
   SOURCE maisto_uzsakymo_sistema.sql;
   ```
3. Patikrinkite, ar duomenų bazė sukurta sėkmingai:
   ```sql
   SHOW DATABASES;
   ```

#### 🚀 2.2. Backend paleidimas
1. Atidarykite `backend` katalogą savo IDE.
2. Įsitikinkite, kad `application.properties` faile yra teisingi duomenų bazės prisijungimo nustatymai.
3. Paleiskite Spring Boot programą su komanda:
   ```sh
   mvn spring-boot:run
   ```

#### 🌍 2.3. Frontend paleidimas
1. Atidarykite `frontend` katalogą.
2. Atidarykite `index.html` naršyklėje arba naudokite vietinį serverį:
   ```sh
   npx serve
   ```

---

## 👤 Vartotojų vaidmenys

| Vaidmuo | Funkcijos |
|---------|----------|
| **Administratorius** | Pridėti/redaguoti maitinimo įstaigas, valdyti valgiaraščius, peržiūrėti ir tvarkyti užsakymus. |
| **Klientas** | Peržiūrėti maitinimo įstaigas, valgiaraščius ir pateikti užsakymus. |

---

## 📂 Projekto struktūra
```
Maisto_Uzsakymo_Aplikacija/
├── backend/
│   ├── src/main/java/com/example/
│   │   ├── controllers/
│   │   ├── models/
│   │   ├── repositories/
│   │   ├── services/
│   ├── resources/application.properties
│   ├── pom.xml
├── frontend/
│   ├── index.html
│   ├── login.html
│   ├── AdminDashboard.html
│   ├── UserDashboard.html
│   ├── style.css
│   ├── script.js
└── README.md
```



