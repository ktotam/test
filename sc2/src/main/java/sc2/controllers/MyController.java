package sc2.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sc2.forms.Form;
import sc2.services.Service;

import java.util.concurrent.*;

@Controller
public class MyController {

    @Autowired
    private Service service;

    @GetMapping("/")
    public String main(ModelMap model) {
        model.addAttribute("text", "");
        return "ftl";
    }

    @PostMapping("/calc+{baseDmg}+{auraDmg}+{asUpgrades}+{dmgUpgrades}+{bonusAs}+{asCost}+{dmgCost}+{minerals}+{allDmgUpgrades}")
    @ResponseBody
    public String update(@PathVariable("baseDmg") String baseDmg, @PathVariable("auraDmg") String auraDmg, @PathVariable("asUpgrades") String asUpgrades,
                         @PathVariable("dmgUpgrades") String dmgUpgrades, @PathVariable("bonusAs") String bonusAs, @PathVariable("asCost") String asCost,
                         @PathVariable("dmgCost") String dmgCost, @PathVariable("minerals") String minerals, @PathVariable("allDmgUpgrades") String allDmgUpgrades) {
        Form form = new Form(baseDmg, auraDmg, dmgUpgrades, asUpgrades, bonusAs, asCost, dmgCost, minerals, allDmgUpgrades, "");
        Callable task = () -> {
            TimeUnit.MILLISECONDS.sleep(3000);
            return service.calculate(form);
        };
        ExecutorService executor = Executors.newFixedThreadPool(100);
        String s = "error";
        try {
            s = executor.submit(task).get().toString();
        } catch (Exception e) {
            return "error";
        }
        return s;




    }

    @PostMapping("/income+{current}+{price}")
    @ResponseBody
    public String income(@PathVariable("current") int current, @PathVariable("price") int price) {
        return service.checkIncome(current, price);
    }
}
