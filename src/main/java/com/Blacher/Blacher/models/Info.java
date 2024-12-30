package com.Blacher.Blacher.models;

public class Info {

    // Enumérations des différentes catégories
    public enum Classe {
        CHEF,
        EMPLOYE,
        STAGIAIRE
    }

    public enum Service {
        RH,
        FINANCE,
        IT,
        LOGISTIQUE
    }

    public enum EtatCivil {
        CELIBATAIRE,
        MARIE,
        DIVORCE,
        VEUF
    }

    public enum TypeDeContrat {
        CDI,
        CDD,
        STAGE,
        INTERIMAIRE
    }

    public enum ModeDePaiement {
        VIREMENT,
        CHEQUE,
        ESPECE
    }

    public enum NomDeChef {
        JAMIL_KAMEL,
        EZELAITI_FAOUZI,
        SAMI_YOUNES,
        AKARI_MAJDI,
        BEN_MANSOUR_IMED,
        MAZROUI_HAJER,
        ACHOUR_MAHLA,
        AKROUT_AICHA,
        GRUICHI_SAMIA,
        BEN_SALEM_FATEN,
        HAJI_HANIA,
        HALLALI_HOUDA,
        HARMASSI_SALHA
    }

    public enum Genre {
        FEMME,
        HOMME
    }

    // Attributs de la classe Info
    private Classe classe;
    private Service service;
    private EtatCivil etatCivil;
    private TypeDeContrat typeDeContrat;
    private ModeDePaiement modeDePaiement;
    private NomDeChef nomDeChef;
    private Genre genre;

    // Constructeur de la classe Info
    public Info() {}

    // Getter et Setter avec gestion des erreurs pour les énumérations

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        try {
            this.classe = Classe.valueOf(classe.toUpperCase()); // Conversion insensible à la casse
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valeur de classe invalide : " + classe);
        }
    }

    public Service getService() {
        return service;
    }

    public void setService(String service) {
        try {
            this.service = Service.valueOf(service.toUpperCase()); // Conversion insensible à la casse
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valeur de service invalide : " + service);
        }
    }

    public EtatCivil getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        try {
            this.etatCivil = EtatCivil.valueOf(etatCivil.toUpperCase()); // Conversion insensible à la casse
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valeur d'état civil invalide : " + etatCivil);
        }
    }

    public TypeDeContrat getTypeDeContrat() {
        return typeDeContrat;
    }

    public void setTypeDeContrat(String typeDeContrat) {
        try {
            this.typeDeContrat = TypeDeContrat.valueOf(typeDeContrat.toUpperCase()); // Conversion insensible à la casse
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valeur de type de contrat invalide : " + typeDeContrat);
        }
    }

    public ModeDePaiement getModeDePaiement() {
        return modeDePaiement;
    }

    public void setModeDePaiement(String modeDePaiement) {
        try {
            this.modeDePaiement = ModeDePaiement.valueOf(modeDePaiement.toUpperCase()); // Conversion insensible à la casse
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valeur de mode de paiement invalide : " + modeDePaiement);
        }
    }

    public NomDeChef getNomDeChef() {
        return nomDeChef;
    }

    public void setNomDeChef(String nomDeChef) {
        try {
            this.nomDeChef = NomDeChef.valueOf(nomDeChef.toUpperCase()); // Conversion insensible à la casse
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valeur de nom de chef invalide : " + nomDeChef);
        }
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        try {
            this.genre = Genre.valueOf(genre.toUpperCase()); // Conversion insensible à la casse
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valeur de genre invalide : " + genre);
        }
    }

    @Override
    public String toString() {
        return "Info{" +
                "classe=" + classe +
                ", service=" + service +
                ", etatCivil=" + etatCivil +
                ", typeDeContrat=" + typeDeContrat +
                ", modeDePaiement=" + modeDePaiement +
                ", nomDeChef=" + nomDeChef +
                ", genre=" + genre +
                '}';
    }
}
