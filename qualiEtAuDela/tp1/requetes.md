# TP1

## Travail effectué :

### Question 1

Lancer **MongoDb Compass** et se connecter

### Question 2

Créer une base de données *BdGestionNotes* soit dans la console **MONGOSH** soit avec l'outil graphique

### Question 3

une fois la base **BdGestionsNotes**:

- créer un collection **matieres** puis faire dans mongosh : 

```mongodb
db.matieres.insertOne({_id : "Mathématiques", idsEtudiantsInscrits: ["cartieraxel", "barthezenzo", "manoukianlea"]})
```

```mongodb
db.matieres.insertOne({_id : "Programmation Java", idsEtudiantsInscrits : ["cartieraxel ", "barthezenzo", "manoukianlea","petruzzitony", "dutroncmaxime", "montalbanmaeva"]})
```

```mongodb
db.matieres.insertOne({_id : "Conception Objet", idsEtudiantsInscrits: ["cartieraxel", "barthezenzo", "manoukianlea","petruzzitony", "dutroncmaxime", "montalbanmaeva"]})
```

```mongodb
db.matieres.insertOne({_id : "Anglais", idsEtudiantsInscrits : ["petruzzitony", "dutroncmaxime", "montalbanmaeva"]})
```

- créer un collection **enseignants** puis faire dans mongosh :

```mongodb
db.enseignants.insertOne({_id : "dupondpaul ", motDePasse : "123", Nom : "DUPOND", Prenom : "Paul", idsMmatieresEnseignees : ["Mathématiques"]})
```

```mongodb
db.enseignants.insertOne({_id : "machinremy", motDePasse : "456", nom : "MACHIN", prenom : "Rémy", idsMmatieresEnseignees: ["Programmation Java", "Conception Objet"]})
```

```mongodb
db.enseignants.insertOne({_id : "johnsonboris ", motDePasse : "789", nom : "JOHNSON", prenom : "Boris", idsMmatieresEnseignees : ["Anglais"]})
```

- créer un collection **etudiants** puis faire dans mongosh :

```mongodb
db.etudiants.insertOne({_id : "cartieraxel", motDePasse : "1", nom : "CARTIER", prenom : "Axel"})
```

```mongodb
db.etudiants.insertOne({_id : "barthezenzo", motDePasse : "2", nom : "BARTHEZ", prenom : "Enzo"})
```

```mongodb
db.etudiants.insertOne({_id : "manoukianlea", motDePasse : "3", nom : "MANOUKIAN", prenom : "Léa"})
```

```mongodb
db.etudiants.insertOne({_id : "petruzzitony", motDePasse : "4", nom : "PETRUZZI", prenom : "Tony"})
```

```mongodb
db.etudiants.insertOne({_id : "dutroncmaxime", motDePasse : "5", nom : "DUTRONC", prenom : "Maxime"})
```

```mongodb
db.etudiants.insertOne({_id : "montalbanmaeva", motDePasse : "6", nom : "MONTALBAN", prenom : "Maéva"})
```

### Question 4

- Requete qui recherche tous les enseignants

```mongodb
db.enseignants.find()
```

- Requete qui recherche tous les etudiants

```mongodb
db.etudiants.find()
```

- Requete qui recherche toute les matieres

```mongodb
db.matieres.find()
```

-  Requête qui recherche les matières enseignées par un enseignant, par exemple par "MACHIN Rémy".

```mongodb
db.enseignants.find({nom : "MACHIN", prenom : "Rémy"})
```

- Requête qui recherche les étudiants inscrits à une matière, par exemple à "Programmation Java".

```mongodb
db.matieres.find({_id : "Programmation Java"})
```

### Question 5

- Requête qui enregistre la note 15 en "Mathématiques".

```mongodb
db.matieres.updateOne({_id : "Mathématiques"}, {$set : {note : 15}})
```

- Requête qui enregistre la note 12 en "Programmation Java".

```mongodb
db.matieres.updateOne({_id : "Programmation Java"}, {$set : {note : 12}})
```

- Requête qui remplace la note en "Mathématiques" par 17.

```mongodb
db.matieres.updateOne({_id : "Mathématiques"}, {$set : {note : 17}})
```

- Requête qui supprime la note en "Mathématiques".

```mongodb
db.matieres.updateOne({_id : "Mathématiques"}, {$unset : {note : 1}})
```