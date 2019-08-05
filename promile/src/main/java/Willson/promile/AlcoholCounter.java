package Willson.promile;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AlcoholCounter {
    private static final float etchingFactorMen = 0.7f;
    private static final float etchingFactorWoman = 0.6f;
    private static final int burningAlcoholForMenAnHour = 11;
    private static final int burningAlcoholForWomanAnHour = 9;

    public float calculatePerMil(double quantity, double weight, boolean sex, Alcohol alcohol){
        float proMil = 0;
        if (sex){
            proMil = (float) ((float) quantity  * alcohol.getStrength()/etchingFactorMen / weight );
        } else {
            proMil = (float) ((float) quantity * alcohol.getStrength()/ etchingFactorWoman / weight );
        }
        return proMil;
    }
    public float calculatePermilWithHours(double quantity, double weight, boolean sex,double hours,Alcohol alcohol){
        float proMil = 0;
        if (sex){
            proMil = (float) ((float) ((quantity *  alcohol.getStrength() ) - burningAlcoholForMenAnHour*hours)/ (etchingFactorMen * weight) );
        } else {
            proMil = (float) ((float) ((quantity  * alcohol.getStrength()) - burningAlcoholForWomanAnHour*hours)/ (etchingFactorWoman * weight));
        }
        return proMil;
    }

    public float calculateToZero(double quantity, double weight, boolean sex,double hours,Alcohol alcohol){
        float hoursTo = 0;
        if(sex){
            hoursTo = (float)(quantity*alcohol.getStrength()/ burningAlcoholForMenAnHour);
        } else {
            hoursTo = (float)( quantity*alcohol.getStrength()/ burningAlcoholForWomanAnHour);
        }
        return  hoursTo;
    }


}