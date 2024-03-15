package Model.Joueur;

public enum OptionDeJeu {

    POUR_SES_POINTS, POUR_SON_POUVOIR, POUR_LA_VIE_FUTURE;

    @Override
    public String toString() {
        return switch (this) {
            case POUR_SES_POINTS -> "POUR_SES_POINTS";
            case POUR_SON_POUVOIR -> "POUR_SON_POUVOIR";
            case POUR_LA_VIE_FUTURE -> "POUR_LA_VIE_FUTURE";
            default -> "DEFAULT";
        };
    }
}
