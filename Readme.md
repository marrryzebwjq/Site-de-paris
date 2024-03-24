Auteurs : Louis-Quentin NOE et Marie POINT

Projet BMO.
0. Diagrammes

Ils sont dans :
                      BMO/scr/main/java/com/point/noe/bmo/generateur/

1. Générateur de code

Le chemin du générateur est : BMO/scr/main/java/...../bmo/generateurdecode.py
Le fichier que le génénateur de classe va lire est :    ./generateur/classes.dotuml
Les classes générées seront dans :                      ./model2/nouvelleclasse.java

Le générateur va lire le fichier source, et dès qu'une classe sera lue, un fichier class.java portant le nom de la classe sera créée. Tout le contenu de la classe sera copié dans le nouveau fichier.

Remarque :
> Lancez le une fois pour voir tous les fichiers apparaître.

> Le fichier source doit absolument s'appeler classes.dotuml et être dans le dossier generateur.
  (On peut quand même modifier le nom du fichier source au début du script si besoin.)

> Les associations/héritages ne sont pas pris en compte par le générateur.

> Le contenu des classes est copié sans modification. Si on a par exemple

class Exemple {
    public Score : int;
}

  ce qui sera généré sera :

public class Exemple {
    public Score : int; //et pas   public int Score;
}

2. Model (OpenXava)
- A partir du parseur, nous avons implémenté nous-mêmes les fonctions, et ajouté les @, ainsi que les héritages.
- Pour une raison inconnue, openxava plante dès que nous tentons de nous connecter. (Erreur 500)
- Nous avons en revanche implémenté toute la logique du bookmakeur et des parieurs. Le système est internement fonctionnel, à priori,
mais il ne l'est pas au niveau de l'interface (openxava).
- Tous les sports n'ont pas été pris en compte, mais nous avons pensé à un système modulable, qui en fonction d'un ensemble de résultats,
nous pouvons créer un type de pari, qui eux-mêmes sont modulables en fonction des besoins.