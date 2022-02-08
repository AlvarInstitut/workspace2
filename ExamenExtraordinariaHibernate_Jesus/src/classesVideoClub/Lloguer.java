package classesVideoClub;
// Generated 14-jun-2016 18:16:47 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Lloguer generated by hbm2java
 */
public class Lloguer  implements java.io.Serializable {


     private int NLlog;
     private Client client;
     private PelLicula pelLicula;
     private Date dataP;
     private Integer durada;
     private Date dataT;

    public Lloguer() {
    }

	
    public Lloguer(int NLlog) {
        this.NLlog = NLlog;
    }
    public Lloguer(int NLlog, Client client, PelLicula pelLicula, Date dataP, Integer durada, Date dataT) {
       this.NLlog = NLlog;
       this.client = client;
       this.pelLicula = pelLicula;
       this.dataP = dataP;
       this.durada = durada;
       this.dataT = dataT;
    }
   
    public int getNLlog() {
        return this.NLlog;
    }
    
    public void setNLlog(int NLlog) {
        this.NLlog = NLlog;
    }
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    public PelLicula getPelLicula() {
        return this.pelLicula;
    }
    
    public void setPelLicula(PelLicula pelLicula) {
        this.pelLicula = pelLicula;
    }
    public Date getDataP() {
        return this.dataP;
    }
    
    public void setDataP(Date dataP) {
        this.dataP = dataP;
    }
    public Integer getDurada() {
        return this.durada;
    }
    
    public void setDurada(Integer durada) {
        this.durada = durada;
    }
    public Date getDataT() {
        return this.dataT;
    }
    
    public void setDataT(Date dataT) {
        this.dataT = dataT;
    }




}

