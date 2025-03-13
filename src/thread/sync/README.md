
# Scenario: 
Immagina di avere un **contatore condiviso** che viene incrementato da più thread. Senza una corretta sincronizzazione possono verificarsi problemi di race condition, causando risultati errati.

## Race Condition
Una race condition (o condizione di competizione) si verifica quando il comportamento di un programma dipende dall'ordine o dalla tempistica di esecuzione di thread o processi concorrenti che accedono e manipolano una risorsa condivisa.
In pratica, accade quando due o più thread accedono simultaneamente a una risorsa (ad esempio, una variabile) senza un'adeguata sincronizzazione, e l'output o lo stato finale del programma varia a seconda di quale thread agisce per primo.
Questo può portare a comportamenti imprevedibili, bug difficili da diagnosticare o risultati errati.

*Problema :*
Problema: Il metodo increment() non è protetto, dunque due thread possono tentare di incrementare contemporaneamente il valore di count, portando a risultati finali sotto il valore atteso (2000).