# Diabetes-Tracker-SpringBoot

Ce projet est conçu pour aider les patients à surveiller leurs niveaux de glycémie, à suivre leurs repas, à enregistrer leurs activités physiques et à visualiser efficacement les tendances des données.

## Fonctionnalités

- **Gestion de la Glycémie :** Les utilisateurs peuvent enregistrer leurs niveaux de glycémie à différents moments de la journée et suivre l'évolution de ces lectures au fil du temps.

- **Gestion des Repas :** Saisie des détails des repas, y compris les glucides consommés, pour mieux comprendre l'impact nutritionnel sur la glycémie.

- **Suivi des Activités Physiques :** Enregistrement des sessions d'exercice et suivi de l'impact de l'activité physique sur la glycémie.

- **Recommandations :** Fourniture de recommandations personnalisées basées sur les tendances de la glycémie et les habitudes alimentaires.

- **Rapports Personnalisés :** Génération de rapports détaillés sur les lectures de glycémie, les habitudes alimentaires et les activités physiques à partager avec les professionnels de la santé.

- **Visualisation des Données avec Chart.js :** Représentation visuelle des tendances de la glycémie au fil du temps, avec possibilité de filtrer par semaine et par mois.

## Technologies Utilisées

- **Framework :** Spring Boot
- **Persistance :** Spring Data JPA (Hibernate)
- **Base de Données :** MySQL
- **Frontend :** HTML, CSS, JavaScript (Thymeleaf)
- **Serveur :** Apache Tomcat (embarqué)
- **Outils de Développement :** Eclipse, IntelliJ IDEA
- **Gestion de Version :** Git
- **Supplémentaire :** Lombok pour réduire le code boilerplate

## Installation et Déploiement

### Prérequis

- Java Development Kit (JDK) 8 ou supérieur
- Maven
- Base de données MySQL

### Étapes pour Exécuter

1. Clonez le repository 
2. Configurez la base de données MySQL
3. Compilez et exécutez l'application avec Maven
4. Accédez à l'application à http://localhost:8080 dans votre navigateur web

   
 ### Structure du Projet
. src/main/java : Contient les classes Java backend. 
. src/main/resources : Fichiers de configuration, templates Thymeleaf, fichiers statiques (CSS, JS).
. src/test : Tests unitaires et d'intégration.

