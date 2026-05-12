package models;

public enum Statut {
    CREE,
    EN_COURS,
    VALIDER,
    REFUSER;

    public static Statut getREFUSER() {
        return REFUSER;
    }

    public static Statut getVALIDER() {
        return VALIDER;
    }

    public static Statut getCREE() {
        return CREE;
    }

    public static Statut getEN_COURS() {
        return EN_COURS;
    }
}

