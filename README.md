# 🏫 Gestion des Infrastructures Scolaires

Ce projet est une application permettant de gérer les infrastructures scolaires, y compris les salles, les équipements et leur affectation.  
L'application est développée en **Java** avec une base de données **MySQL**.

---

## ✨ Fonctionnalités

- 🏢 **Ajouter une salle** : Ajouter une nouvelle salle avec son nom, son type et sa capacité.
- 🖥️ **Ajouter un équipement** : Ajouter un nouvel équipement avec son nom, son type et son état.
- 🔗 **Affecter un équipement à une salle** : Associer un équipement à une salle spécifique.
- 🔎 **Filtrer les équipements par salle** : Lister les équipements affectés à une salle donnée.

---

## 🗄️ Structure de la Base de Données

La base de données MySQL est composée des tables suivantes :  

- **`salle`** : Stocke les informations des salles.
- **`équipement`** : Contient les détails des équipements.
- **`affectation_equipement`** : Gère l'affectation des équipements aux salles.

# Gestion des Infrastructures Scolaires

Ce projet est une application permettant de gérer les infrastructures scolaires, y compris les salles, les équipements et leur affectation.  
L'application est développée en **Java** avec une base de données **MySQL**.

---

##  Fonctionnalités

-  **Ajouter une salle** : Ajouter une nouvelle salle avec son nom, son type et sa capacité.
- **Ajouter un équipement** : Ajouter un nouvel équipement avec son nom, son type et son état.
- **Affecter un équipement à une salle** : Associer un équipement à une salle spécifique.
-  **Filtrer les équipements par salle** : Lister les équipements affectés à une salle donnée.

---

##  Structure de la Base de Données

La base de données MySQL est composée des tables suivantes :  

- **`salle`** : Stocke les informations des salles.
- **`équipement`** : Contient les détails des équipements.
- **`affectation_equipement`** : Gère l'affectation des équipements aux salles.

### 📌 Table `salle`
```sql
CREATE TABLE `salle` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(100) NOT NULL,
    `type` VARCHAR(50) DEFAULT NULL,
    `capacite` INT(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

### 📌 Table `équipement`
```sql
CREATE TABLE `équipement` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(100) NOT NULL,
    `type` VARCHAR(50) DEFAULT NULL,
    `etat` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
### 📌 Table `affectation_equipement`
```sql
CREATE TABLE `affectation_equipement` (
    
    `salle` INT(11) NOT NULL,
    `equipement` INT(11) NOT NULL,
    `dateaffectation` DATE NOT NULL,
    FOREIGN KEY (`salle`) REFERENCES `salle`(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`equipement`) REFERENCES `équipement`(`id`) ON DELETE CASCADE
);

