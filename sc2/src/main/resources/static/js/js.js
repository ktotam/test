function calc() {
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

    req = new XMLHttpRequest();
    req.open('POST', '/calc+'+baseDmg.value+'+'+auraDmg.value+'+'+asUpgrades.value+'+'+dmgUpgrades.value+'+'+bonusAs.value.charAt(0)+asCost.value+dmgCost.value+'+'+minerals.value+'+'+allDmgUpgrades.value, true);
    req.onload = (res) => {
        area.value = req.response;
    }
    req.send();
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
    var text = document.getElementById("area");
    var asCost = document.getElementById("asCost");
    var dmgCost = document.getElementById("dmgCost");
    var s = text.value[15] + text.value[16];
    var s2 = text.value[17] + text.value[18] + text.value[19];
    asUpgrades.value = parseInt(asUpgrades.value) + parseInt(s);
    dmgUpgrades.value = parseInt(dmgUpgrades.value) + parseInt(s2);
}