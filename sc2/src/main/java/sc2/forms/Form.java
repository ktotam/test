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
    public String multiplier;

    public Double getMinerals() { return Double.parseDouble(minerals); }

    public Double getAsCost() {
        return Double.parseDouble(asCost);
    }

    public Double getDmgCost() {
        return Double.parseDouble(dmgCost);
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

    public Double getBaseDmg() {
        switch(baseDmg) {
            case "Big Multi shot": return 0.36;
            case "Chain reaction": return 0.37;
            case "Torus": return 0.4;
            case "Damage field": return 0.66;
            case "Bounce": return 0.7;
            case "Big splash": return 0.78;
            case "Infection": return 0.83;
            case "Line splash": return 0.85;
            case "Flame": return 0.86;
            case "Multi shot": return 0.9;
            case "Splash": return 1.15;
            case "Two sided": return 1.22;
            case "Sniper": return 1.47;
            case "Rage": return 1.58;
            case "Long Minimum range": return 1.62;
            case "High damage": return 1.9;
            case "Charge": return 2.02;
            case "Melee": return 2.13;
            case "Angle": return 2.18;
            case "Minimum range": return 2.18;
            case "Trigger": return 2.45;
            case "Bombardment": return 2.7;
            case "Discharge": return 3.3;
            case "Anti Air": return 4.2;
        }
        return 1.0;
    }

    public Integer getMultiplier() {
        switch(baseDmg) {
            case "Big Multi shot": return 6;
            case "Chain reaction": return 7;
            case "Torus": return 5;
            case "Damage field": return 6;
            case "Bounce": return 3;
            case "Big splash": return 4;
            case "Infection": return 4;
            case "Line splash": return 3;
            case "Flame": return 6;
            case "Multi shot": return 3;
            case "Splash": return 3;
            case "Two sided": return 2;
            case "Sniper": return 2;
            case "Bombardment": return 3;
        }
        return 1;
    }

}
