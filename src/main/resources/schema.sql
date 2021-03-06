DROP TABLE IF EXISTS HEROS;
DROP TABLE IF EXISTS SYNC;
DROP TABLE IF EXISTS COLABORATORS;
DROP TABLE IF EXISTS CHARACTERS;
DROP TABLE IF EXISTS HEROS_COLABORATORS;
DROP TABLE IF EXISTS HEROS_CHARACTERS;

CREATE TABLE HEROS (
  id INT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  resource_name VARCHAR(250) NOT NULL
);

CREATE TABLE SYNC (
  id INT AUTO_INCREMENT PRIMARY KEY,
  last_sync DATETIME NOT NULL
);

CREATE TABLE COLABORATORS (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  role VARCHAR(50) NOT NULL
);

CREATE TABLE CHARACTERS (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE HEROS_COLABORATORS (
  id_hero INT NOT NULL,
  id_colaborator INT NOT NULL,
  PRIMARY KEY (
    id_hero, id_colaborator 
 )
);

CREATE TABLE HEROS_CHARACTERS (
  id_hero INT NOT NULL,
  id_character INT NOT NULL,
  title VARCHAR(250) NOT NULL,
  PRIMARY KEY (
    id_hero,id_character, title 
 )
);

