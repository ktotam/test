function calc(q) {
    document.getElementById("error" + q).style.display = 'none';
    document.getElementById("clc1").setAttribute("onclick", "");
    document.getElementById("clc2").setAttribute("onclick", "");
    document.getElementById("clc3").setAttribute("onclick", "");
    document.getElementById("gif" + q).style.display = '';
    var baseDmg = document.getElementById("baseDmg" + q);
    var auraDmg = document.getElementById("auraDmg" + q);
    if (auraDmg.value < 0 || auraDmg.value === "")
        auraDmg.value = "0";
    var asUpgrades = document.getElementById("asUpgrades" + q);
    if (asUpgrades.value < 0 || asUpgrades.value === "")
        asUpgrades.value = "0";
    var dmgUpgrades = document.getElementById("dmgUpgrades" + q);
    if (dmgUpgrades.value < 0 || dmgUpgrades.value === "")
        dmgUpgrades.value = "0";
    var bonusAs = document.getElementById("bonusAs" + q);
    var asCost = document.getElementById("asCost" + q);
    var dmgCost = document.getElementById("dmgCost" + q);
    var minerals = document.getElementById("minerals" + q);
    if (minerals.value < 0 || minerals.value === "")
        minerals.value = "0";
    var allDmgUpgrades = document.getElementById("allDmgUpgrades" + q);
    if (allDmgUpgrades.value < 0 || allDmgUpgrades.value === "")
        allDmgUpgrades.value = "0";
    var armor = document.getElementById("armor" + q);
    if (armor.value === "")
        armor.value = "0";
    
    var as = document.getElementById("as" + q);
    var dmg = document.getElementById("dmg" + q);
    var dps = document.getElementById("dps" + q);
    var newDps = document.getElementById("newDps" + q);

    var aoe = document.getElementById("aoe" + q);
    var newAoe = document.getElementById("newAoe" + q);


    req = new XMLHttpRequest();
    req.open('POST', '/calc+'+baseDmg.value+'+'+auraDmg.value+'+'+asUpgrades.value+'+'+dmgUpgrades.value+'+'+bonusAs.value.charAt(0)+asCost.value+dmgCost.value+'+'+minerals.value+'+'+allDmgUpgrades.value+'+'+armor.value, true);
    req.onload = (res) => {
        if (req.response.charAt(0) === "a") {
        as.innerText = "+" + req.response.substring(req.response.indexOf("+") + 1, req.response.indexOf("*"));
        dmg.innerText = "+" + req.response.substring(req.response.indexOf("-") + 1, req.response.indexOf("^"));
        dps.innerText = req.response.substring(req.response.indexOf("@") + 1, req.response.indexOf("$"));
        newDps.innerText = req.response.substring(req.response.indexOf("~") + 1, req.response.indexOf("%"));
        aoe.innerText = req.response.substring(req.response.indexOf("%") + 1, req.response.length);
        newAoe.innerText = req.response.substring(req.response.indexOf("%") + 1, req.response.length);
        document.getElementById("set" + q).setAttribute("onclick", "set(" + q + ")");

            //       aoe2.innerText = req.response;
        }
        else document.getElementById("error" + q).style.display = '';
        document.getElementById("gif" + q).style.display = 'none';
        var sum = 0;
        for (var i = parseInt(asUpgrades.value) + parseInt(asCost.value); i < parseInt(asUpgrades.value) + parseInt(asCost.value) + parseInt(as.innerText); i++) {
            sum = sum + i;
        }
        for (var j = parseInt(dmgUpgrades.value) + parseInt(dmgCost.value); j < parseInt(dmgUpgrades.value) + parseInt(dmgCost.value) + parseInt(dmg.innerText); j++) {
            sum = sum + j;
        }
        var s = ((parseFloat(newDps.innerText) - parseFloat(dps.innerText)) / sum).toString();
        if (s === "NaN" || s === "Infinity"){
            document.getElementById("dpm" + q).innerText = "0";
        }
        else document.getElementById("dpm" + q).innerText = s;
        document.getElementById("clc1").setAttribute("onclick", "calc(1)");
        document.getElementById("clc2").setAttribute("onclick", "calc(2)");
        document.getElementById("clc3").setAttribute("onclick", "calc(3)");
    }

    req.send();



}
function income() {
    var current = document.getElementById("current");
    var price = document.getElementById("price");
    var aa = document.getElementById("aa");
    if (!isNaN(current.value) && ! isNaN(price.value) && current.value !== "" && price.value !== "") {
        req = new XMLHttpRequest();
        req.open('POST', '/income+'+current.value+'+'+price.value, true);
        req.onload = (res) => {
            aa.innerText = req.response;
        }
        req.send();
    }


}
function set(q) {
    var asUpgrades = document.getElementById("asUpgrades" + q);
    var dmgUpgrades = document.getElementById("dmgUpgrades" + q);
    var as = document.getElementById("as" + q);
    var dmg = document.getElementById("dmg" + q);
    asUpgrades.value = parseInt(asUpgrades.value) + parseInt(as.innerText);
    dmgUpgrades.value = parseInt(dmgUpgrades.value) + parseInt(dmg.innerText);
}

function addCalculator() {
    var k = 2;
    var b = false;
    while (!b) {
        if (document.getElementById("calculator" + k).style.display === 'none') {
            document.getElementById("calculator" + k).style.display = '';
            b = true;
        }
        k++;
        if (k === 4)
            b = true;
    }
}

function removeCalculator(q) {
    document.getElementById("calculator" + q).style.display = 'none';
}

function incomeCalculator() {
    if (document.getElementById("incomeCalculator").style.display === 'none') {
        document.getElementById("incomeCalculator").style.display = "";
    }
    else
        document.getElementById("incomeCalculator").style.display = "none";
}