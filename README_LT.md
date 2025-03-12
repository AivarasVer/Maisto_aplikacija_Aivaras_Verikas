
    # Maisto Užsakymo Sistema

    Ši aplikacija leidžia administruoti maitinimo įstaigas, valgiaraščius ir priimti maisto užsakymus.

    ## Diegimo instrukcijos

    ### 1. Sistemos reikalavimai
    - **Operacinė sistema:** Linux (rekomenduojama) arba Windows 10
    - **IDE:** IntelliJ IDEA, Eclipse, arba NetBeans
    - **Lokalus serveris:** Apache Tomcat
    - **Duomenų bazė:** MySQL arba MariaDB
    - **Git versijų kontrolės sistema**

    ### 2. Projekto paleidimas

    #### 2.1. Duomenų bazės sukūrimas
    1. Įdiekite MySQL arba MariaDB.
    2. Atidarykite MySQL terminalą ir vykdykite SQL komandą:
       ```sql
       SOURCE maisto_uzsakymo_sistema.sql;
       ```
    3. Patikrinkite, ar duomenų bazė sėkmingai sukurta naudojant komandą:
       ```sql
       SHOW DATABASES;
       ```

    #### 2.2. Backend paleidimas
    1. Atidarykite `backend` katalogą savo IDE.
    2. Įsitikinkite, kad `application.properties` faile yra teisingi duomenų bazės prisijungimo nustatymai.
    3. Paleiskite Spring Boot programą naudodami komandą:
       ```sh
       mvn spring-boot:run
       ```

    #### 2.3. Frontend paleidimas
    1. Atidarykite `frontend` katalogą.
    2. Atidarykite `index.html` naršyklėje arba naudokite vietinį serverį:
       ```sh
       npx serve
       ```

    ## Vartotojų vaidmenys
    - **Administratorius** gali pridėti maitinimo įstaigas, redaguoti valgiaraščius ir valdyti užsakymus.
    - **Klientas** gali ieškoti maitinimo įstaigų, peržiūrėti valgiaraščius ir užsisakyti maistą.

    ## Projekto struktūra
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

    