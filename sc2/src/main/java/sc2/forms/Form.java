package sc2.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Form {
    public String baseDmg;
    public String auraDmg;
    public String dmgUpgrades;
    public String asUpgrades;
    public String bonusAs;
    public String asCost;
    public String dmgCost;
    public String minerals;
    public String allDmgUpgrades;

    public Double getMinerals() { return Double.parseDouble(minerals); }

    public Double getAsCost() {
        return Double.parseDouble(asCost);
    }

    public Double getDmgCost() {
        return Double.parseDouble(dmgCost);
    }

    public Double getBaseDmg() {
        return Double.parseDouble(baseDmg);
    }

    public Double getAuraDmg() {
        return Double.parseDouble(auraDmg)/100;
    }

    public Double getDmgUpgrades() {
        return Double.parseDouble(dmgUpgrades);
    }

    public Double getAsUpgrades() {
        return Double.parseDouble(asUpgrades);
    }

    public Double getBonusAs() { return Double.parseDouble(bonusAs)/100; }

    public Double getAllDmgUpgrades() { return Double.parseDouble(allDmgUpgrades); }


}
