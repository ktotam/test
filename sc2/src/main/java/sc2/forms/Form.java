package sc2.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Form {
    private String baseDmg;
    private String auraDmg;
    private String dmgUpgrades;
    private String asUpgrades;
    private String bonusAs;
    private String asCost;
    private String dmgCost;
    private String minerals;
    private String allDmgUpgrades;
    private String armor;

    public Form(String baseDmg, String auraDmg, String dmgUpgrades, String asUpgrades, String bonusAs, String asCost, String dmgCost, String minerals, String allDmgUpgrades, String armor) {
        this.baseDmg = baseDmg;
        this.auraDmg = checkNull(auraDmg, false);
        this.dmgUpgrades = checkNull(dmgUpgrades, false);
        this.asUpgrades = checkNull(asUpgrades, false);
        this.bonusAs = bonusAs;
        this.asCost = asCost;
        this.dmgCost = dmgCost;
        this.minerals = checkNull(minerals, false);
        this.allDmgUpgrades = checkNull(allDmgUpgrades, false);
        this.armor = checkNull(armor, true);
    }

    private String checkNull(String s, boolean armor) {
        if (s.equals("") || Double.parseDouble(s) < 0 && !armor) {
            return "0";
        }
        return s;
    }

    public Double getArmor() { return Double.parseDouble(armor); }

    public Integer getMinerals() { return Integer.parseInt(minerals); }

    public Integer getAsCost() { return Integer.parseInt(asCost); }

    public Integer getDmgCost() { return Integer.parseInt(dmgCost); }

    public Double getAuraDmg() { return Double.parseDouble(auraDmg)/100.0; }

    public Integer getDmgUpgrades() { return Integer.parseInt(dmgUpgrades); }

    public Integer getAsUpgrades() { return Integer.parseInt(asUpgrades); }

    public Double getBonusAs() { return Integer.parseInt(bonusAs)/100.0; }

    public Integer getAllDmgUpgrades() { return Integer.parseInt(allDmgUpgrades); }

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

    public Double getMultiplier() {
        switch(baseDmg) {
            case "Big Multi shot": return 6.0;
            case "Chain reaction": return 7.0;
            case "Torus": return 6.5;
            case "Damage field": return 6.0;
            case "Bounce": return 3.0;
            case "Big splash": return 4.0;
            case "Infection": return 4.0;
            case "Line splash": return 3.0;
            case "Flame": return 6.0;
            case "Multi shot": return 3.0;
            case "Splash": return 3.0;
            case "Two sided": return 2.0;
            case "Sniper": return 2.0;
            case "Bombardment": return 3.0;
        }
        return 1.0;
    }

}
