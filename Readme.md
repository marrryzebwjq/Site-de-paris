Auteurs : Louis-Quentin NOE et Marie POINT

Projet BMO.

1. Générateur



2. Model (OpenXava)
- A partir du parseur, nous avons implémenté nous-mêmes les fonctions, et ajouté les @, ainsi que les héritages.
- Pour une raison inconnue, openxava plante dès que nous tentons de nous connecter. (Erreur 500)
- Nous avons en revanche implémenté toute la logique du bookmakeur et des parieurs. Le système est internement fonctionnel, à priori,
mais il ne l'est pas au niveau de l'interface (openxava).
- Tous les sports n'ont pas été pris en compte, mais nous avons pensé à un système modulable, qui en fonction d'un ensemble de résultats,
nous pouvons créé un type de pari, qui eux-mêmes sont modulables en fonction des besoins.