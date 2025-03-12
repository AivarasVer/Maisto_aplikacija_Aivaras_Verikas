
    -- SQL failas: maisto_uzsakymo_sistema.sql
    -- Sukuria reikalingas duomenų bazės lenteles

    CREATE DATABASE maisto_uzsakymo_sistema;
    USE maisto_uzsakymo_sistema;

    -- Vartotojų lentelė
    CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) UNIQUE NOT NULL,
        password VARCHAR(255) NOT NULL,
        role ENUM('ADMIN', 'KLIENTAS') NOT NULL
    );

    -- Maitinimo įstaigų lentelė
    CREATE TABLE maitinimo_istaigos (
        id INT AUTO_INCREMENT PRIMARY KEY,
        pavadinimas VARCHAR(100) NOT NULL,
        kodas VARCHAR(20) UNIQUE NOT NULL,
        adresas VARCHAR(255) NOT NULL
    );

    -- Valgiaraščių lentelė
    CREATE TABLE valgiarasciai (
        id INT AUTO_INCREMENT PRIMARY KEY,
        pavadinimas VARCHAR(100) NOT NULL,
        maitinimo_istaiga_id INT,
        FOREIGN KEY (maitinimo_istaiga_id) REFERENCES maitinimo_istaigos(id) ON DELETE CASCADE
    );

    -- Patiekalų lentelė
    CREATE TABLE patiekalai (
        id INT AUTO_INCREMENT PRIMARY KEY,
        pavadinimas VARCHAR(100) NOT NULL,
        aprasymas TEXT,
        valgiarastis_id INT,
        FOREIGN KEY (valgiarastis_id) REFERENCES valgiarasciai(id) ON DELETE CASCADE
    );

    -- Užsakymų lentelė
    CREATE TABLE uzsakymai (
        id INT AUTO_INCREMENT PRIMARY KEY,
        klientas_id INT,
        maitinimo_istaiga_id INT,
        uzsakymo_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (klientas_id) REFERENCES users(id) ON DELETE CASCADE,
        FOREIGN KEY (maitinimo_istaiga_id) REFERENCES maitinimo_istaigos(id) ON DELETE CASCADE
    );
    