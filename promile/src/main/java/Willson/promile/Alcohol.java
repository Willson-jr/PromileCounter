package Willson.promile;

public enum Alcohol {
    BEER(0.05),
    VODKA(0.4),
    WINE(0.112),
    HOOCH(0.56);

    private Double strength;

    Alcohol( double strength){
        this.strength = strength;
    }

    public Double getStrength() {
        return strength;
    }

    public void setStrength(Double strength) {
        this.strength = strength;
    }
}
