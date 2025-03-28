# Gestion des Infrastructures Scolaires

Ce projet est une application permettant de gérer les infrastructures scolaires, y compris les salles, les équipements et leur affectation.  
L'application est développée en **Java** avec une base de données **MySQL**.

---

##  Fonctionnalités

-  **Ajouter une salle** : Ajouter une nouvelle salle avec son nom, son type et sa capacité.
- **Ajouter un équipement** : Ajouter un nouvel équipement avec son nom, son type et son état.
- **Affecter un équipement à une salle** : Associer un équipement à une salle spécifique.
-  **Filtrer les équipements par salle** : Lister les équipements affectés à une salle donnée.
  
##  Problématique

La gestion des infrastructures scolaires, telles que les salles et les équipements, est souvent complexe en raison du manque de centralisation et de suivi en temps réel, entraînant des conflits d'affectation et une utilisation inefficace des ressources.

---

##  Structure de la Base de Données

La base de données MySQL est composée des tables suivantes :  

- **`salle`** : Stocke les informations des salles.
- **`équipement`** : Contient les détails des équipements.
- **`affectation_equipement`** : Gère l'affectation des équipements aux salles.
##  Les diagrammes UML
##  Le diagrammes de cas d'utilisation

<img width="569" alt="image" src="https://github.com/user-attachments/assets/4275a214-ee5f-490f-9c91-a9cf0c13ef72" />

##  Le diagramme de classe 

![image](https://github.com/user-attachments/assets/f340d840-c829-467e-9254-7ca8316ecfd3)


## Architecture du project 
![image](https://github.com/user-attachments/assets/dd6e3a19-bad6-45d6-94be-5e9ec48e7da3)

##  Logo

![a-modern-and-minimalist-logo-representin_jv4DylowSY2IGO1pPgoo5Q_hO-zW58LQ3i99DQHsCAEoQ (1)](https://github.com/user-attachments/assets/21838f1f-e366-4603-bdb9-4022df1c3afb)


##  Vidéo sur les interfaces de l'application




https://github.com/user-attachments/assets/936c3341-dfd4-4a7f-b384-4c359859f92d



## Technologies
- **Langage** : Java

- **Framework d'interface graphique** : Java Swing

- **Base de données** : MySQL

- **Bibliothèque graphique** : JFreeChart

- **Outils de développement** :  IDE NetBeans
  
- **Outil de diagramme** : MagicDraw

- **Outil de gestion de base de données** : phpMyAdmin

- **Accès aux données** : JDBC
  
### Les tables SQL
```sql
CREATE TABLE `salle` (
    `id` INT(11) NOT NULL AUTO_INCREMENT ,
    `nom` VARCHAR(100) NOT NULL,
    `type` VARCHAR(50) DEFAULT NULL,
    `capacite` INT(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `équipement` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(100) NOT NULL,
    `type` VARCHAR(50) DEFAULT NULL,
    `etat` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE affectation_equipement (
salle INT,
equipement INT,
dateaffectation DATE NOT NULL,
 CONSTRAINT pk_affectation PRIMARY KEY (salle, equipement),
CONSTRAINT fk_salle FOREIGN KEY (salle) REFERENCES salle(id),
CONSTRAINT fk_equipement FOREIGN KEY (equipement) REFERENCES équipement(id)
 );

CREATE TABLE users (
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    securityQuestion VARCHAR(255),
    securityAnswer VARCHAR(255),
    email VARCHAR(255)
);

