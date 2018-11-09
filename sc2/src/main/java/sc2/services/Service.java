package sc2.services;

import org.springframework.stereotype.Component;
import sc2.forms.Form;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.concurrent.*;


@Component
public class Service {

    public String calculate(Form form) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            Future<String> future1 = service.submit(new rek(form, form.getMinerals(), dps(form), asCost(form), dmgCost(form), form.getAsUpgrades(), form.getDmgUpgrades(), false));
            Double s1 = Double.parseDouble(future1.get());
            Future<String> future2 = service.submit(new rek2(form, form.getMinerals(), dps(form), asCost(form), dmgCost(form), form.getAsUpgrades(), form.getDmgUpgrades(), s1, 0, 0, false, false));
            Double s2 = Double.parseDouble(future2.get());
            if (form.getMultiplier().equals(1.0))
            return "as+" + s2.intValue() / 100000 + "*dmg-" + s2.intValue() % 10000 +
                    "^dps@" + dps(form) +
                    "$new~" + s1 + "%";
            if (form.getMultiplier().equals(6.5))
                return "as+" + s2.intValue() / 100000 + "*dmg-" + s2.intValue() % 10000 +
                        "^dps@" + dps(form) * form.getMultiplier() +
                        "$new~" + s1 * form.getMultiplier() + "%" + "\n(if on average hits 7 targets)";
            return "as+" + s2.intValue() / 100000 + "*dmg-" + s2.intValue() % 10000 +
                    "^dps@" + dps(form) * form.getMultiplier() +
                    "$new~" + s1 * form.getMultiplier() + "%" + "\n(if on average hits " + Math.round(form.getMultiplier()) + " targets)";
        } catch (InterruptedException | ExecutionException e) {
            return "error";
        }
    }

    private Double dps(Form form) {
        Double damage = 1 + form.getDmgUpgrades() - form.getArmor();
        if (damage < 1)
            damage = 1.0;
        if (!form.getBaseDmg().equals(1.47))
            return form.getBaseDmg() * damage * (1 + form.getAuraDmg()) / (1 / (0.5 * (Math.pow(form.getBonusAs() + 1, form.getAsUpgrades())))) +
                    form.getBaseDmg() * form.getAllDmgUpgrades() / (1 / (0.5 * (Math.pow(form.getBonusAs() + 1, form.getAsUpgrades()))));
        return form.getBaseDmg() * damage * (1 + form.getAuraDmg()) / (1 / (0.25 * (Math.pow(form.getBonusAs() + 1, form.getAsUpgrades())))) +
                form.getBaseDmg() * form.getAllDmgUpgrades() / (1 / (0.25 * (Math.pow(form.getBonusAs() + 1, form.getAsUpgrades()))));
    }

    private Double newDps(Form form, double as, double dmg) {
        Double damage = dmg + 1 - form.getArmor();
        if (damage < 1)
            damage = 1.0;
        if (!form.getBaseDmg().equals(1.47))
            return form.getBaseDmg() * damage * (1 + form.getAuraDmg()) / (1 / (0.5 * (Math.pow(form.getBonusAs() + 1, as)))) +
                    form.getBaseDmg() * form.getAllDmgUpgrades() / (1 / (0.5 * (Math.pow(form.getBonusAs() + 1, as))));
        return form.getBaseDmg() * damage * (1 + form.getAuraDmg()) / (1 / (0.25 * (Math.pow(form.getBonusAs() + 1, as)))) +
                form.getBaseDmg() * form.getAllDmgUpgrades() / (1 / (0.25 * (Math.pow(form.getBonusAs() + 1, as))));

    }

    private Integer asCost(Form form) {
        return form.getAsUpgrades() + form.getAsCost();
    }

    private Integer dmgCost(Form form) {
        return form.getDmgUpgrades() + form.getDmgCost();
    }

    private class rek implements Callable<String> {
        private Form form;
        private Integer minerals;
        private Double dps;
        private Integer asCost;
        private Integer dmgCost;
        private Integer asUpgrades;
        private Integer dmgUpgrades;
        private boolean b;

        private rek(Form form, Integer minerals, Double dps, Integer asCost, Integer dmgCost, Integer asUpgrades, Integer dmgUpgrades, boolean b) {
            this.form = form;
            this.minerals = minerals;
            this.dps = dps;
            this.asCost = asCost;
            this.dmgCost = dmgCost;
            this.asUpgrades = asUpgrades;
            this.dmgUpgrades = dmgUpgrades;
            this.b = b;
        }

        @Override
        public String call(){
            return getMax(form, minerals, dps, asCost, dmgCost, asUpgrades, dmgUpgrades, b).toString();
        }
        private Double getMax(Form form, Integer minerals, Double dps, Integer asCost, Integer dmgCost, Integer asUpgrades, Integer dmgUpgrades, boolean b) {
            if (minerals <= 0) {
                return dps;
            }
            if (minerals - asCost >= 0 && minerals - dmgCost >= 0 && asUpgrades < (240 + form.getBonusAs() * 100) / form.getBonusAs() / 100 && !b) {
                return Math.max(getMax(form, minerals - asCost, newDps(form, asUpgrades + 1, dmgUpgrades), asCost + 1, dmgCost, asUpgrades + 1, dmgUpgrades, false),
                        getMax(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, true));
            } else {
                if (minerals - asCost >= 0 && asUpgrades < (240 + form.getBonusAs() * 100) / form.getBonusAs() / 100 && !b) {
                    return getMax(form, minerals - asCost, newDps(form, asUpgrades + 1, dmgUpgrades), asCost + 1, dmgCost, asUpgrades + 1, dmgUpgrades, false);
                } else {
                    if (minerals - dmgCost >= 0) {
                        return getMax(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, true);
                    } else return dps;
                }
            }
        }
    }

    private class rek2 implements Callable<String> {
        private Form form;
        private Integer minerals;
        private Double dps;
        private Integer asCost;
        private Integer dmgCost;
        private Integer asUpgrades;
        private Integer dmgUpgrades;
        private Double max;
        private Integer a;
        private Integer d;
        private boolean found;
        private boolean b;

        private rek2(Form form, Integer minerals, Double dps, Integer asCost, Integer dmgCost, Integer asUpgrades, Integer dmgUpgrades, Double max, Integer a, Integer d, boolean found, boolean b) {
            this.form = form;
            this.minerals = minerals;
            this.dps = dps;
            this.asCost = asCost;
            this.dmgCost = dmgCost;
            this.asUpgrades = asUpgrades;
            this.dmgUpgrades = dmgUpgrades;
            this.max = max;
            this.a = a;
            this.d = d;
            this.found = found;
            this.b = b;

        }

        @Override
        public String call() {
            return findMax(form, minerals, dps, asCost, dmgCost, asUpgrades, dmgUpgrades, max, a, d, false).toString();
        }

        private Integer findMax(Form form, Integer minerals, Double dps, Integer asCost, Integer dmgCost, Integer asUpgrades, Integer dmgUpgrades, Double max, Integer a, Integer d, boolean b) {
            if (dps.equals(max)) {
                found = true;
                return a * 100000 + d;
            }
            if (minerals <= 0.0) {
                return 0;
            }

            if (!found) {
                if (!b) {
                    return findMax(form, minerals - asCost, newDps(form, asUpgrades + 1, dmgUpgrades), asCost + 1, dmgCost, asUpgrades + 1, dmgUpgrades, max, ++a, d, false) +
                            findMax(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, max, --a, ++d, true);
                }
                else
                    return findMax(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, max, a, ++d, true);
            }
            return 0;
        }
    }

    public String checkIncome(int current, int price) {
       int sum = 0;
       int k = current;
       while (sum <= price) {
           sum = sum + current * 3;
           current++;
       }
       return "PAY OFFS IN " + String.valueOf(current - k) + " TURNS";
    }
}
   
