class Bookmaker 
    { 
    public ajoutEvenement(Evenement : AResultat) 
    } 

class Systeme 
    { 
    private FermetureEvenement(evenement : Evenement); 
    } 

class Evenement 
    { 
    private Sport : String 
    
    public ajoutAPari(Pari : APari) 
    } 

abstract class AResultat 
    { 
    private Gagnant : String 
    } 

class Parieur 
    { 
    private NombreDeJetons : Entier 
    
    public parier(pari : APari, montant : Montant) 
    } 

abstract class ATicket 
    { 
    private Montant : Entier 
    } 

abstract class ATicketAvance 
    { 
    } 

class TicketSimple 
    { 
    private PariGagnant : String 
    } 

abstract class APari 
    { 
    abstract private estGagnant(ticket : ATicket, evenement : Evenement) 
    } 

class PariSimple 
    { 
    private estGagnant(ticket : TicketSimple, evenement : Evenement) 
    } 

abstract class APariAvance 
    { 
    abstract private estGagnant(ticket : ATicket, evenement : Evenement) 
    } 

class ResultatFootball 
    { 
    private scoreA1 : int 
    private scoreB1 : int 
    private scoreA2 : int 
    private scoreB2 : int 
    private equipeA : String 
    private equipeB : String 
    }; 

class ResultatBaseball 
    { 
    private scoreA : int 
    private scoreB : int 
    }; 

class ResultatTennis 
    { 
    private scoreA1 : int 
    private scoreB1 : int 
    private scoreA2 : int 
    private scoreB2 : int 
    private scoreA3 : int 
    private scoreB3 : int 
    private scoreA4 : int 
    private scoreB4 : int 
    private scoreA5 : int 
    private scoreB5 : int 
    private joueurA : String 
    private joueurB : String 
    }; 

class PariFootballMitemps1 
    { 
    private estGagnant(ticket : Ticket, evenement : Evenement); 
    }; 

