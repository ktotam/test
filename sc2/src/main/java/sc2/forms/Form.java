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
    public String description;

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

    public String getDescription() {
        switch(baseDmg) {
            case "Big Multi shot": return "(if always hits 6 targets)";
            case "Chain reaction": return "(if always hits 7 targets)";
            case "Torus": return "(if always hits 5 targets)";
            case "Damage field": return "(if always hits 6 targets)";
            case "Bounce": return "(if always hits 3 targets)";
            case "Big splash": return "(if always hits 4 targets)";
            case "Infection": return "(if always hits 4 targets)";
            case "Line splash": return "(if always hits 3 targets)";
            case "Flame": return "(if always hits 6 targets)";
            case "Multi shot": return "(if always hits 3 targets)";
            case "Splash": return "(if always hits 3 targets)";
            case "Two sided": return "(if always hits 2 targets)";
            case "Sniper": return "(if always hits 2 targets)";
            case "Bombardment": return "(if always hits 3 targets)";
        }
        return "";
    }

}
