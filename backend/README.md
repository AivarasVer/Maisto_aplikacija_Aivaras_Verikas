
# Knygų rezervacijos sistema

Ši sistema leidžia vartotojams registruotis, prisijungti ir rezervuoti knygas. 
Administratoriai gali pridėti ir redaguoti knygas bei kategorijas.

## Paleidimo instrukcijos

### Backend:
1. Užtikrinkite, kad turite įdiegtą `MySQL` ir sukurkite duomenų bazę:
   ```sql
   CREATE DATABASE book_reservation_db;
   ```
2. Pakeiskite `application.properties` duomenų bazės nustatymus pagal savo sistemą.
3. Paleiskite `Spring Boot` aplikaciją:
   ```sh
   mvn spring-boot:run
   ```

### Frontend:
1. Atidarykite `frontend/index.html` naršyklėje.

## API dokumentacija:
API prieinama per `Swagger` adresu: `http://localhost:8080/swagger-ui.html`
