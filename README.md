# Gestion des Infrastructures Scolaires

Ce projet est une application de gestion des infrastructures scolaires. Il permet de gérer les salles, les équipements et leur affectation. L'application est développée en Java avec une base de données MySQL.

---

## Fonctionnalités

- **Ajouter une salle** : Permet d'ajouter une nouvelle salle avec son nom, son type et sa capacité.
- **Ajouter un équipement** : Permet d'ajouter un nouvel équipement avec son nom, son type et son état.
- **Affecter un équipement à une salle** : Permet d'affecter un équipement à une salle.
- **Filtrer les équipements par salle** : Permet de lister les équipements affectés à une salle spécifique.

---

## Structure de la Base de Données

La base de données MySQL est composée des tables suivantes :

- **Salle** : Contient les informations sur les salles.
- **Équipement** : Contient les informations sur les équipements.
- **AffectationÉquipement** : Contient les informations sur l'affectation des équipements aux salles.

---

# Gestion des équipements et des salles

Ce projet gère une base de données pour les équipements et les salles dans un environnement de gestion. La base de données est conçue pour stocker des informations sur les équipements et les salles, y compris leur état, leur type, et leur capacité.

## Structure de la base de données

### Table `équipement`

La table `équipement` contient les informations suivantes :

- `id` (INT) : Identifiant unique de l'équipement.
- `nom` (VARCHAR) : Nom de l'équipement.
- `type` (VARCHAR) : Type de l'équipement (par exemple, Informatique, Audio Visuel).
- `etat` (VARCHAR) : État de l'équipement (par exemple, Fonctionnel, En panne).

### Table `salle`

La table `salle` contient les informations suivantes :

- `id` (INT) : Identifiant unique de la salle.
- `nom` (VARCHAR) : Nom de la salle.
- `type` (VARCHAR) : Type de la salle (par exemple, Amphi, Salle de réunion).
- `capacite` (INT) : Capacité de la salle en nombre de personnes.



