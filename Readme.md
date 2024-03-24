Projet BMO.

1. Générateur de code

Le chemin du générateur est : BMO/scr/main/...../com/java/generateurdecode.py
Le fichier que le génénateur de classe va lire est :    ./generateur/classes.dotuml
Les classes générées seront dans :                      ./model2/nouvelleclasse.java

Le générateur va lire le fichier source, et dès qu'une classe sera lue, un fichier class.java
portant le nom de la classe sera créée. Tout le contenu de la classe sera copié dans le nouveau fichier.

Remarque :
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
- 