<#ftl encoding='UTF-8'>
<html>
<head>
    <title>EnTropy TD dps calculator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="js/js.js"></script>
    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script>
        (adsbygoogle = window.adsbygoogle || []).push({
            google_ad_client: "ca-pub-9706403203807820",
            enable_page_level_ads: true
        });
    </script>
</head>

<style type="text/css">
    body {
        background-color: #E9F2F9;
    }
</style>

<body><br><br>
<div class="container" id="main">
    <div class="row">
    <div class="col-md-6 col-md-offset-1">
        <div class="panel panel-default">
            <div class="panel-heading">
                <form id="form1">
                    <div class="form-group">
                        <h4><p class="text-center"><label>DPS CALCULATOR</label></p></h4>
                        <label for="baseDmg">TOWER</label>
                        <select class="form-control" id="baseDmg" name="baseDmg">
                            <option>Angle</option>
                            <option>Anti Air</option>
                            <option>Big Multi shot</option>
                            <option>Big splash</option>
                            <option>Bombardment</option>
                            <option>Bounce</option>
                            <option>Chain reaction</option>
                            <option>Charge</option>
                            <option>Damage field</option>
                            <option>Discharge</option>
                            <option>Flame</option>
                            <option>High damage</option>
                            <option>Infection</option>
                            <option>Line splash</option>
                            <option>Long Minimum range</option>
                            <option>Melee</option>
                            <option>Minimum range</option>
                            <option>Multi shot</option>
                            <option>Rage</option>
                            <option>Sniper</option>
                            <option>Splash</option>
                            <option>Torus</option>
                            <option>Trigger</option>
                            <option>Two sided</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="auraDmg">AREA %DMG</label>
                        <input type="text" class="form-control" id="auraDmg" name="auraDmg" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label for="allDmgUpgrades">ALL TOWERS DMG UPGRADES</label>
                        <input type="text" class="form-control" id="allDmgUpgrades" name="allDmgUpgrades" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label for="asUpgrades">SPEED</label>
                        <input type="text" class="form-control" id="asUpgrades" name="asUpgrades" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label for="dmgUpgrades">DMG</label>
                        <input type="text" class="form-control" id="dmgUpgrades" name="dmgUpgrades" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label for="dmgUpgrades">MINERALS</label>
                        <input type="text" class="form-control" id="minerals" name="minerals" autocomplete="off">
                    </div>
                    <div class="form-inline">
                        <div class="form-group" style="max-width: 70px">
                            <label for="bonusAs">SPEED BONUS</label>
                            <select class="form-control" id="bonusAs" name="bonusAs">
                                <option>4%</option>
                                <option>5%</option>
                                <option>6%</option>
                            </select>
                        </div>
                        <div class="form-group" style="max-width: 70px">
                            <label for="bonusAs">SPEED COST</label>
                            <select class="form-control" id="asCost" name="asCost">
                                <option>+1</option>
                                <option>+2</option>
                                <option>+3</option>
                                <option>+4</option>
                                <option>+5</option>
                                <option>+6</option>
                            </select>
                        </div>
                        <div class="form-group" style="max-width: 70px">
                            <label for="bonusAs">DMG COST</label>
                            <select class="form-control" id="dmgCost" name="dmgCost">
                                <option>+1</option>
                                <option>+2</option>
                                <option>+3</option>
                                <option>+4</option>
                                <option>+5</option>
                                <option>+6</option>
                            </select>
                        </div>
                    </div>
                    <br>
                    <div class="form-inline">
                        <a onclick="calc()" class="btn btn-success btn-lg">CALCULATE</a> <img src="gifs/35.gif" style="display: none">
                    </div>
                    <br>



                </form>
                <p><label>UP SPEED</label>                                                     <label id="as" >&nbsp;</label></p>
                <p><label>UP DAMAGE</label>                                                    <label id="dmg">&nbsp;</label></p>
                <p><label>CURRENT DPS</label><span class="text-muted" id="aoe1">&nbsp;</span>  <label id="dps">&nbsp;</label></p>
                <p><label>NEW DPS</label><span class="text-muted" id="aoe2">&nbsp;</span>      <label id="newDps">&nbsp;</label></p>
                <a onclick="set()" class="btn btn-primary">UP</a>
            </div>
        </div>
    </div>
        <div class="col-md-4 col-md-offset-0">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <form id="form">
                        <div class="form-group">
                            <h4><p class="text-center"><label>INCOME CALCULATOR</label></p></h4>
                            <label for="current">CURRENT WAVE</label>
                            <input type="text" class="form-control" id="current" name="current" autocomplete="off">
                        </div>
                        <div class="form-group">
                            <label for="price">UPGRADE PRICE</label>
                            <input type="text" class="form-control" id="price" name="price" autocomplete="off">
                        </div>

                        <a onclick="income()" class="btn btn-success ">CALCULATE</a>
                        <hr>
                        <h4><label id="aa">&nbsp;</label></h4>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>