# SIR
TP2

TP3
  - Correction du problème de version du JAVA :
    * http://qussay.com/2013/09/13/solving-dynamic-web-module-3-0-requires-java-1-6-or-newer-in-maven-projects/

TP4 NoSQL : mongodb + redis
  - QUESTION 1 : Les limites des bases de données orienté document sont :
    -> un manque de fléxibilité lors de l'utilisation des requêtes
    -> fichier pouvant être un ensemble de jointure et donc peut vite devenir "gros" car les jointures ne sont pas possible entre les tables
    -> d'après le cours, les propriétés garantissant la cohérence des données en est impactée à cause du choix du respect de deux des trois propriétés (Cohérence, Disponibilité, Résistance)
  - QUESTION 2 : (http://www.barreverte.fr/une-courte-introduction-a-redis/)
    -> Les types de données stockés dans Redis sont des listes liées (linked list), des valeurs (numérique et littéraux), des ensembles (triés ou non) et des tables de hachage
    -> Les types de requêtes qui peuvent être faites sont : 
      -> valeurs : SET, GET, INCR, DECR, GETSET
      -> listes : RPUSH, LPUSH, LRANGE, LINDEX, LLEN
      -> table de hashage : HSET, HGET, HLEN, HGETALL, HINCRBy, HKEY, HVALS, HDEL
      -> collections (ensembles): SADD, SCARD, SINTER, SUNION, SDIFF, SINTERSTORE
      -> collections triés (ensembles triés) : ZADD, ZCARD, ZINTER, ZUNION, ZDIFF, ZRANGE, ZRANGEBYSCORE, ZRANK
  
TP6 AngularJs
  - Problème d'installation de yeoman : 
    * commande "..\yo angular" : Cannot find module 'is-relative'
    * commande "..\grunt test --force" ET "..\grunt serve --force" : Cannot find module 'load-grunt-tasks'
    
TP7
  - documentation utilisée :
    * http://www.academiepro.com/uploads/livres/gwt_app_web.pdf
  - problèmes rencontrés :
    * NullPointerException lors de l'appel d'un RootPanel.get("nomContainer")
    * Impossible d'utiliser le GWT designer (raison : il n'y pas de module GWT dans le projet https://github.com/barais/smartgwt5maven)
    
