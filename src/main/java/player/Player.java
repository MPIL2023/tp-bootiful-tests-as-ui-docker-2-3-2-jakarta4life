package player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Player {

    private String id;

    private String nom;

    private String prenom;

    private String poste;

    private int fg3pts;

    @Autowired
    public Player(String id,String nom, String prenom, String poste, int fg3pts){
        this.id=id;
        this.nom=nom;
        this.prenom =prenom;
        this.poste=poste;
        this.fg3pts=fg3pts;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getFg3pts() {
        return fg3pts;
    }

    public void setFg3pts(int fg3pts) {
        this.fg3pts = fg3pts;
    }

    @Override
    public String toString(){
        return this.nom + " - " + this.prenom + " - " + this.poste + " - " + this.fg3pts;
    }


}
