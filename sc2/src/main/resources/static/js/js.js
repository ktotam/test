function calc() {
    document.getElementById("clc").setAttribute("onclick", "");
    document.getElementById("gif").style.display = '';
    var area = document.getElementById("area");
    var baseDmg = document.getElementById("baseDmg");
    var auraDmg = document.getElementById("auraDmg");
    var asUpgrades = document.getElementById("asUpgrades");
    var dmgUpgrades = document.getElementById("dmgUpgrades");
    var bonusAs = document.getElementById("bonusAs");
    var asCost = document.getElementById("asCost");
    var dmgCost = document.getElementById("dmgCost");
    var minerals = document.getElementById("minerals");
    var allDmgUpgrades = document.getElementById("allDmgUpgrades");
    var as = document.getElementById("as");
    var dmg = document.getElementById("dmg");
    var dps = document.getElementById("dps");
    var newDps = document.getElementById("newDps");
    var aoe1 = document.getElementById("aoe1");
    var aoe2 = document.getElementById("aoe2");


    req = new XMLHttpRequest();
    req.open('POST', '/calc+'+baseDmg.value+'+'+auraDmg.value+'+'+asUpgrades.value+'+'+dmgUpgrades.value+'+'+bonusAs.value.charAt(0)+asCost.value+dmgCost.value+'+'+minerals.value+'+'+allDmgUpgrades.value, true);
    req.onload = (res) => {
        as.innerText = "+" + req.response.substring(req.response.indexOf("+") + 1, req.response.indexOf("*"));
        dmg.innerText = "+" + req.response.substring(req.response.indexOf("-") + 1, req.response.indexOf("^"));
        dps.innerText = req.response.substring(req.response.indexOf("@") + 1, req.response.indexOf("$"));
        newDps.innerText = req.response.substring(req.response.indexOf("~") + 1, req.response.indexOf("%"));
        aoe1.innerText = req.response.substring(req.response.indexOf("%") + 1, req.response.length);
        aoe2.innerText = req.response.substring(req.response.indexOf("%") + 1, req.response.length);
 //       aoe2.innerText = req.response;

        document.getElementById("gif").style.display = 'none';
    }

    req.send();
    var asd = setTimeout(function(){ document.getElementById("clc").setAttribute("onclick", "calc()");}, 1000);


}
function income() {
    var current = document.getElementById("current");
    var price = document.getElementById("price");
    var aa = document.getElementById("aa");

    req = new XMLHttpRequest();
    req.open('POST', '/income+'+current.value+'+'+price.value, true);
    req.onload = (res) => {
        aa.innerText = req.response;
    }
    req.send();
}
function set() {
    var asUpgrades = document.getElementById("asUpgrades");
    var dmgUpgrades = document.getElementById("dmgUpgrades");
    var as = document.getElementById("as");
    var dmg = document.getElementById("dmg");
    asUpgrades.value = parseInt(asUpgrades.value) + parseInt(as.innerText);
    dmgUpgrades.value = parseInt(dmgUpgrades.value) + parseInt(dmg.innerText);
}