package sc2.services;

import org.springframework.stereotype.Component;
import sc2.forms.Form;


@Component
public class Service {
    public String calculate(Form form) {
        Double d = rek(form, form.getMinerals(), dps(form, 0, 0), asCost(form), dmgCost(form), form.getAsUpgrades(), form.getDmgUpgrades(), false);
        Double ss = rek2(form, form.getMinerals(), dps(form, 0, 0), asCost(form), dmgCost(form), form.getAsUpgrades(), form.getDmgUpgrades(), d, 0.0, 0.0);
        b = false;
        return "as+" + ss.intValue() / 1000 + "*dmg-" + ss.intValue() % 100 +
                "^dps@" + dps(form, 0, 0) +
                "$new~" + d + "%";
    }

    private Double dps(Form form, double as, double dmg) {
        return form.getBaseDmg() * (dmg + 1 + form.getDmgUpgrades() + form.getAllDmgUpgrades()) * (1 + form.getAuraDmg()) / (1 / (0.5 * (Math.pow(form.getBonusAs() + 1, form.getAsUpgrades() + as))));
    }

    private Double newDps(Form form, double as, double dmg) {
        return form.getBaseDmg() * (dmg + 1 + form.getAllDmgUpgrades()) * (1 + form.getAuraDmg()) / (1 / (0.5 * (Math.pow(form.getBonusAs() + 1, as))));

    }

    private Double asCost(Form form) {
        return form.getAsUpgrades() + form.getAsCost();
    }

    private Double dmgCost(Form form) {
        return form.getDmgUpgrades() + form.getDmgCost();
    }

    private Double rek(Form form, Double minerals, Double dps, Double asCost, Double dmgCost, Double asUpgrades, Double dmgUpgrades, boolean b) {
        if (minerals <= 0) {
            return dps;
        }

        if (minerals - asCost >= 0 && minerals - dmgCost >= 0 && asUpgrades < (2.4 + form.getBonusAs()) / form.getBonusAs() && !b) {
            return Math.max(rek(form, minerals - asCost, newDps(form, asUpgrades + 1, dmgUpgrades), asCost + 1, dmgCost, asUpgrades + 1, dmgUpgrades, false),
                    rek(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, true));
        } else {
            if (minerals - asCost >= 0 && asUpgrades < (2.4 + form.getBonusAs()) / form.getBonusAs() && !b) {
                return rek(form, minerals - asCost, newDps(form, asUpgrades + 1, dmgUpgrades), asCost + 1, dmgCost, asUpgrades + 1, dmgUpgrades, false);
            } else {
                if (minerals - dmgCost >= 0) {
                    return rek(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, true);
                } else return dps;
            }
        }
    }

    private boolean b = false;
    private Double rek2(Form form, Double minerals, Double dps, Double asCost, Double dmgCost, Double asUpgrades, Double dmgUpgrades, Double max, Double a, Double d) {
        if (dps.equals(max) && !b) {
            b = true;
            return a * 1000 + d;
        }
        if (minerals <= 0.0) {
           return 0.0;
        }
        
        if(!b) {
            return rek2(form, minerals - asCost, newDps(form, asUpgrades + 1, dmgUpgrades), asCost + 1, dmgCost, asUpgrades + 1, dmgUpgrades, max, ++a, d) +
                    rek2(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, max, --a, ++d);
        }
        return 0.0;


        }

    public String checkIncome(int current, int price) {
       int sum = 0;
       int k = current;
       while (sum <= price) {
           sum = sum + current * 3;
           current++;
           System.out.println(sum + " " + current);
       }
       return "PAY OFFS IN " + String.valueOf(current - k) + " TURNS";
    }
}
   
