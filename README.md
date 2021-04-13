# Olympix MapReduce

## Présentation

* Ce projet présente l'implémentation d'un job MapReduce permettant d'analyser le contenu du dataset `olympix_data.csv`.

## Prérequis

* Installer Apache Hadoop sur votre machine
* Installer Java JDK version 1.8

## Utilisation

* Télécharger le fichier de données disponible sur ce lien [https://github.com/BigDataESEN/datasets/blob/main/olympix_data.csv](https://github.com/BigDataESEN/datasets/blob/main/olympix_data.csv)

* Envoyer le fichier `olympix_data.csv` à votre cluster hdfs.
  ```
  hdfs dfs -mkdir app
  hdfs dfs -put olympix_data.csv app/olympix_data.csv
  ```

* Placer le fichier `olympix-1.jar` (qui se trouve dans le dossier __target__) dans votre répertoire de travail, puis lancer la commande suivante :

  ```
  hadoop jar olympix-1.jar Olympix app/olympix_data.csv repertoire_destination
  ```

  par exemple :

  ```
  hadoop jar olympix-1.jar Olympix app/olympix_data.csv output
  ```

  Par défaut, ce job calcule pour chaque discipline (sport) le nombre total de médailles.

  ![screenshot](https://www.nassimbahri.ovh/docs/bigdata/documentations/olympix/c1.png)
  
  Vous pouvez aussi spécifier deux paramètres supplémentaires : la clé et la valeur à afficher. Par exemple, pour afficher le nombre de médailles d'or gagnés par chaque pays, il suffit de taper la commande suivante :

  ```
  hadoop jar olympix-1.jar Olympix app/olympix_data.csv output index_cle index_valeur
  ```

  par exemple :

  ```
  hadoop jar olympix-1.jar Olympix app/olympix_data.csv output 2 7
  ```
    ![screenshot](https://www.nassimbahri.ovh/docs/bigdata/documentations/olympix/c2.png)

  Les colonnes sont décrites comme suit : 

  | Numéro de la colonne      | Description |
  | :---        |    :----   |
  | 0 | Nom de l'athlète |
  | 1 | Age de l'athlète |
  | 2 | Nom du pays |
  | 3 | Année de participation |
  | 4 | Date de la cérémonie de clôture  |
  | 5 | Nom de la discipline (sport) |
  | 6 | Nombre de médailles d'or |
  | 7 | Nombre de médailles en argent |
  | 8 | Nombre de médailles en bronze |
  | 9 | Nombre total de médailles |
