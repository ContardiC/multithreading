## Thread Creation - MultiExecutor

In questo esercizio implementeremo un  MultiExecutor .
Il client di questa classe creerà un elenco di attività eseguibili e fornirà tale elenco al costruttore di MultiExecutor.
Quando il client esegue  executeAll(), il MultiExecutor,  eseguirà tutte le attività specificate.
Per sfruttare appieno la nostra CPU multicore, vorremmo che il MultiExecutor eseguisse tutte le attività in parallelo passando ciascuna attività a un thread diverso.