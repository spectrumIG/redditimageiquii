# Prova tecnica
Il progetto è la realizzazione della prova tecnica e cerca  di attenersi alle specifiche tecniche richieste. 
Purtroppo per mancanza di tempo ed energie il progetto  verte primariamente sulla parti principali.

La UI e in parte anche a la UX sono puramente degli scheletri di base per dare l'idea dei componenti ma non sono assolutamente da considerarsi
qualcosa di completo o valido a livello generale.


# Architettura 
L'architettura che ho tentato di utilizzare è l'architettura consigliata da Google (MVVM + Single-Source-Of-Truth) con aggiunta di UseCase per
 attenersi (o almeno avvicinarsi) ad un'idea di Clean Architecture. 
 Ho stato omesso per mancanza di tempo l'implementazione di un DB locale con Room dal quale andare effettivamente a pescare i dati. 
 Ho tentato di implementare data model diversi per layer diversi per lasciare i layer stessi disaccoppiati fra
 loro e favorire un possibile testing. Si è ovviamente utilizzata la Dependency Injection
 mediante Hilt.
 
 Una menzione particolare va al testing. Purtroppo negli anni ho avuto difficoltà nel portare questa pratica all'interno dei luoghi di lavoro che
 ho frequentato. Di conseguenza anche la mia pratica con essi non è delle migliori. Vi prego di tenere presente che ne sono consapevole ed è la
 prima nella lista di lacune personali da colmare al più presto. Ho cercato comunque per quanto ho potuto di mostrare il minimo indispensabile
 (suppongo) delle skill necessarie per metterla in opera in maniera normale. Ho quindi implementato qualche unit test e uno UI testo con espresso.
 
 Per quanto riguarda la paginazione, per un discorso di praticità non ho integrato Paging 3( o 2) all'interno del progetto perchè mi avrebbe
 rallentato in fase di sviluppo dal momento che  non ho mai usato il 3 ma solo il 2 e su un DB Room che non mi sembrava il caso di implementare in
 questo progetto (vedi nota sopra). Di conseguenza, vista anche la semplicità delle API, ho trovato un piccolo Helper online in un gist che ho
  linkato nei commenti alla classe e che mi ha permesso di realizzare la paginazione in maniera semplice.
  
 In generale si sono favorite quando necessario, librerie che fossero se non native kotlin quanto meno abbastanza semplici da integrare.
 
 Ultima nota riguardante il template di progetto. Ho utilizzato un template di progetto creato da Nicola Corti (https://github.com/cortinico/kotlin
 -android-template) che contiene al suo interno diversi plugin che sono superflui per questo progetto. Semplicemente era una questione di comodità.
 
 

 

