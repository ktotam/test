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
            Future<String> future1 = service.submit(new rek(form, form.getMinerals(), dps(form, 0, 0), asCost(form), dmgCost(form), form.getAsUpgrades(), form.getDmgUpgrades(), false));
            Double s1 = Double.parseDouble(future1.get());
            Future<String> future2 = service.submit(new rek2(form, form.getMinerals(), dps(form, 0, 0), asCost(form), dmgCost(form), form.getAsUpgrades(), form.getDmgUpgrades(), s1, 0.0, 0.0, false));
            Double s2 = Double.parseDouble(future2.get());
            if (form.getMultiplier().equals(1.0))
            return "as+" + s2.intValue() / 1000 + "*dmg-" + s2.intValue() % 100 +
                    "^dps@" + dps(form, 0, 0) +
                    "$new~" + s1 + "%";
            if (form.getMultiplier().equals(6.5))
                return "as+" + s2.intValue() / 1000 + "*dmg-" + s2.intValue() % 100 +
                        "^dps@" + dps(form, 0, 0) * form.getMultiplier() +
                        "$new~" + s1 * form.getMultiplier() + "%" + "(if always hits 7 targets)";
            return "as+" + s2.intValue() / 1000 + "*dmg-" + s2.intValue() % 100 +
                    "^dps@" + dps(form, 0, 0) * form.getMultiplier() +
                    "$new~" + s1 * form.getMultiplier() + "%" + "(if always hits " + Math.round(form.getMultiplier()) + " targets)";
        } catch (InterruptedException | ExecutionException e) {
            return "error";
        }
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

    class rek implements Callable<String> {
        Form form;
        Double minerals;
        Double dps;
        Double asCost;
        Double dmgCost;
        Double asUpgrades;
        Double dmgUpgrades;
        boolean b;

        private rek(Form form, Double minerals, Double dps, Double asCost, Double dmgCost, Double asUpgrades, Double dmgUpgrades, boolean b) {
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
        private Double getMax(Form form, Double minerals, Double dps, Double asCost, Double dmgCost, Double asUpgrades, Double dmgUpgrades, boolean b) {
            if (minerals <= 0) {
                return dps;
            }
            if (minerals - asCost >= 0 && minerals - dmgCost >= 0 && asUpgrades < (2.4 + form.getBonusAs()) / form.getBonusAs() && !b) {
                return Math.max(getMax(form, minerals - asCost, newDps(form, asUpgrades + 1, dmgUpgrades), asCost + 1, dmgCost, asUpgrades + 1, dmgUpgrades, false),
                        getMax(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, true));
            } else {
                if (minerals - asCost >= 0 && asUpgrades < (2.4 + form.getBonusAs()) / form.getBonusAs() && !b) {
                    return getMax(form, minerals - asCost, newDps(form, asUpgrades + 1, dmgUpgrades), asCost + 1, dmgCost, asUpgrades + 1, dmgUpgrades, false);
                } else {
                    if (minerals - dmgCost >= 0) {
                        return getMax(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, true);
                    } else return dps;
                }
            }
        }
    }

    class rek2 implements Callable<String> {
        Form form;
        Double minerals;
        Double dps;
        Double asCost;
        Double dmgCost;
        Double asUpgrades;
        Double dmgUpgrades;
        Double max;
        Double a;
        Double d;
        boolean found;

        private rek2(Form form, Double minerals, Double dps, Double asCost, Double dmgCost, Double asUpgrades, Double dmgUpgrades, Double max, Double a, Double d, boolean found) {
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
        }

        @Override
        public String call() {
            return findMax(form, minerals, dps, asCost, dmgCost, asUpgrades, dmgUpgrades, max, a, d).toString();
        }

        private Double findMax(Form form, Double minerals, Double dps, Double asCost, Double dmgCost, Double asUpgrades, Double dmgUpgrades, Double max, Double a, Double d) {
            if (dps.equals(max)) {
                found = true;
                return a * 1000 + d;
            }
            if (minerals <= 0.0) {
                return 0.0;
            }

            if (!found) {
                return findMax(form, minerals - asCost, newDps(form, asUpgrades + 1, dmgUpgrades), asCost + 1, dmgCost, asUpgrades + 1, dmgUpgrades, max, ++a, d) +
                        findMax(form, minerals - dmgCost, newDps(form, asUpgrades, dmgUpgrades + 1), asCost, dmgCost + 1, asUpgrades, dmgUpgrades + 1, max, --a, ++d);
            }
            return 0.0;
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
   
