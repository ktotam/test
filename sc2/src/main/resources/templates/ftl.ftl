<#ftl encoding='UTF-8'>
<html>
<head>
    <title>EnTropy TD dps calculator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="js/js.js"></script>
    <script>(function(name,path,ctx){var latest,prev=name!=='Keen'&&window.Keen?window.Keen:false;ctx[name]=ctx[name]||{ready:function(fn){var h=document.getElementsByTagName('head')[0],s=document.createElement('script'),w=window,loaded;s.onload=s.onerror=s.onreadystatechange=function(){if((s.readyState&&!(/^c|loade/.test(s.readyState)))||loaded){return}s.onload=s.onreadystatechange=null;loaded=1;latest=w.Keen;if(prev){w.Keen=prev}else{try{delete w.Keen}catch(e){w.Keen=void 0}}ctx[name]=latest;ctx[name].ready(fn)};s.async=1;s.src=path;h.parentNode.insertBefore(s,h)}}
    })('KeenAsync','https://d26b395fwzu5fz.cloudfront.net/keen-tracking-1.4.2.min.js',this);

    KeenAsync.ready(function(){
    var client = new KeenAsync({
    projectId: '5b6d85ebc9e77c0001ea7386',
    writeKey: 'E6FEC13EEAAF0FCFA8CC3E5BE1D644077CE3F3AA84CB6A6C19E090D64E494115767028752FDBEDB6F474083C9E7F62D941D195AB78F29C3AA739752A59A6F8D7984256D5D8C938024F8404E3280DDE0C529A3C85781A8C7A8400A7741FD8388E'
    });

    client.initAutoTracking();
    });
    </script>
</head>


<style type="text/css">
    body {
        background-color: #E9F2F9;
    }
</style>

<body>
          <br>
<div class="col-md-2 pull-left" id="incomeCalculator" style="display:none">
    <div class="panel panel-default">
        <div class="panel-heading">
            <form id="form">
                <div class="form-group">
                    <h5 class="text-center"><label>INCOME CALCULATOR</label></h5>
                    <label for="current">CURRENT WAVE</label>
                    <input type="text" class="form-control" id="current" name="current" autocomplete="off" maxlength="4">
                </div>
                <div class="form-group">
                    <label for="price">UPGRADE PRICE</label>
                    <input type="text" class="form-control" id="price" name="price" autocomplete="off" maxlength="9">
                </div>

                <a onclick="income()" class="btn btn-success " >CALCULATE</a>
                <hr>
                <h4><label id="aa">&nbsp;</label></h4>
            </form>
        </div>
    </div>
</div>
<div class="container" id="main">
    <div class="row">

        <div class="col-md-4 col-sm-10 col-xs-10" id="calculator1">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <form id="form1">
                        <div class="form-group">
                            <h4><a onclick="addCalculator()" class="btn btn-small btn-info pull-right" id="add">ADD</a><a onclick="incomeCalculator()" class="btn btn-info pull-left">INCOME</a><label class="text-center">&nbsp;DPS CALCULATOR</label></h4>
                            <label for="baseDmg1">TOWER</label>
                            <select class="form-control" id="baseDmg1" name="baseDmg1">
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
                            <label for="auraDmg1">AREA %DMG</label>
                            <input type="text" class="form-control" id="auraDmg1" name="auraDmg1" autocomplete="off" maxlength="3" placeholder="0">
                        </div>
                        <div class="form-group">
                            <label for="allDmgUpgrades1">ALL TOWERS DMG UPGRADES</label>
                            <input type="text" class="form-control" id="allDmgUpgrades1" name="allDmgUpgrades1" autocomplete="off" maxlength="3" placeholder="0">
                        </div>
                        <div class="form-group">
                            <label for="armor1">WAVE ARMOR</label>
                            <input type="text" class="form-control" id="armor1" name="armor1" autocomplete="off" maxlength="5" placeholder="0">
                        </div>

                        <div class="form-group" >
                            <label for="minerals1">MINERALS</label>
                            <input type="text" class="form-control" id="minerals1" name="minerals1" autocomplete="off" maxlength="6" placeholder="0">
                        </div>
                        <div class="form-inline">
                            <div class="form-group" >
                                <label for="dmgUpgrades1">DAMAGE</label>
                                <br>
                                <input type="text" class="form-control" id="dmgUpgrades1" name="dmgUpgrades1" autocomplete="off" maxlength="4" style="max-width: 130px" placeholder="0">
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label for="asUpgrades1">SPEED</label>
                                <br>
                                <input type="text" class="form-control" id="asUpgrades1" name="asUpgrades1" autocomplete="off" maxlength="2" style="max-width: 130px" placeholder="0">

                                &nbsp;

                                <div class="form-group pull-right">
                                    <a onclick="" class="btn btn-primary" id="set1">UP</a>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="form-inline">
                            <div class="form-group" style="max-width: 70px">
                                <label for="bonusAs1">SPEED BONUS</label>
                                <select class="form-control" id="bonusAs1" name="bonusAs1">
                                    <option>4%</option>
                                    <option>5%</option>
                                    <option>6%</option>
                                </select>
                            </div>
                            <div class="form-group" style="max-width: 70px">
                                <label for="asCost1">SPEED COST</label>
                                <select class="form-control" id="asCost1" name="asCost1">
                                    <option>+1</option>
                                    <option>+2</option>
                                    <option>+3</option>
                                    <option>+4</option>
                                    <option>+5</option>
                                    <option>+6</option>
                                    <option>+7</option>
                                    <option>+8</option>
                                    <option>+9</option>
                                </select>
                            </div>

                            <div class="form-group" style="max-width: 70px">
                                <label for="dmgCost1">DMG COST</label>
                                <select class="form-control" id="dmgCost1" name="dmgCost1">
                                    <option>+1</option>
                                    <option>+2</option>
                                    <option>+3</option>
                                    <option>+4</option>
                                    <option>+5</option>
                                    <option>+6</option>
                                    <option>+7</option>
                                    <option>+8</option>
                                    <option>+9</option>
                                </select>
                            </div>
                            <a onclick="calc(1)" class="btn btn-success pull-right" id="clc1">CALCULATE</a> <img src="gifs/35.gif" style="display: none" id="gif1" class="pull-right">
                        </div>
                        
                        <label style="color: red; display: none" id="error1" class="pull-right">ERROR</label>



                    </form>
                    <table class="table">
                        <tr><td colspan="1"><h5>UP SPEED</h5></td><td>&nbsp;</td>                                               <td><b id="as1">&nbsp;</b></td></tr>
                        <tr><td colspan="1"><h5>UP DAMAGE</h5></td><td>&nbsp;</td>                                               <td><b id="dmg1">&nbsp;</b></td></tr>
                        <tr><td colspan="2" ><h5>CURRENT DPS<text class="text-muted" id="aoe1">&nbsp;</text></h5></td>   <td><b id="dps1">&nbsp;</b></td></tr>
                        <tr><td colspan="2" ><h5>NEW DPS<text class="text-muted" id="newAoe1">&nbsp;</text></h5></td>       <td><b id="newDps1">&nbsp;</b></td></tr>
                        <tr><td colspan="1"><h5>DPS INCREASE PER MINERAL </h5></td><td>&nbsp;</td>                               <td><b id="dpm1">&nbsp;</b></td></tr>
                    </table>
                </div>
            </div>
        </div>

        <div class="col-md-4" id="calculator2" style="display: none">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <form id="form2">
                        <div class="form-group">
                            <h4><a onclick="removeCalculator(2)" class="btn btn-warning pull-right" id="remove2">REMOVE</a><label class="text-center">DPS CALCULATOR</label></h4>
                            <label for="baseDmg2">TOWER</label>
                            <select class="form-control" id="baseDmg2" name="baseDmg2">
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
                            <label for="auraDmg2">AREA %DMG</label>
                            <input type="text" class="form-control" id="auraDmg2" name="auraDmg2" autocomplete="off" maxlength="3" placeholder="0">
                        </div>
                        <div class="form-group">
                            <label for="allDmgUpgrades2">ALL TOWERS DMG UPGRADES</label>
                            <input type="text" class="form-control" id="allDmgUpgrades2" name="allDmgUpgrades2" autocomplete="off" maxlength="3" placeholder="0">
                        </div>
                        <div class="form-group">
                            <label for="armor2">WAVE ARMOR</label>
                            <input type="text" class="form-control" id="armor2" name="armor2" autocomplete="off" maxlength="5" placeholder="0">
                        </div>

                        <div class="form-group" >
                            <label for="minerals2">MINERALS</label>
                            <input type="text" class="form-control" id="minerals2" name="minerals2" autocomplete="off" maxlength="6" placeholder="0">
                        </div>
                        <div class="form-inline">
                            <div class="form-group" >
                                <label for="dmgUpgrades2">DAMAGE</label>
                                <br>
                                <input type="text" class="form-control" id="dmgUpgrades2" name="dmgUpgrades2" autocomplete="off" maxlength="4" style="max-width: 130px" placeholder="0">
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label for="asUpgrades2">SPEED</label>
                                <br>
                                <input type="text" class="form-control" id="asUpgrades2" name="asUpgrades2" autocomplete="off" maxlength="2" style="max-width: 130px" placeholder="0">

                                &nbsp;

                                <div class="form-group pull-right">
                                    <a onclick="" class="btn btn-primary" id="set2">UP</a>
                                </div>
                            </div>
                        </div>


                <br>
                <div class="form-inline">
                    <div class="form-group" style="max-width: 70px">
                        <label for="bonusAs2">SPEED BONUS</label>
                        <select class="form-control" id="bonusAs2" name="bonusAs2">
                            <option>4%</option>
                            <option>5%</option>
                            <option>6%</option>
                        </select>
                    </div>
                    
                    <div class="form-group" style="max-width: 70px">
                        <label for="asCost2">SPEED COST</label>
                        <select class="form-control" id="asCost2" name="asCost2">
                            <option>+1</option>
                            <option>+2</option>
                            <option>+3</option>
                            <option>+4</option>
                            <option>+5</option>
                            <option>+6</option>
                            <option>+7</option>
                            <option>+8</option>
                            <option>+9</option>
                        </select>
                    </div>

                    <div class="form-group" style="max-width: 70px">
                        <label for="dmgCost2">DMG COST</label>
                        <select class="form-control" id="dmgCost2" name="dmgCost2">
                            <option>+1</option>
                            <option>+2</option>
                            <option>+3</option>
                            <option>+4</option>
                            <option>+5</option>
                            <option>+6</option>
                            <option>+7</option>
                            <option>+8</option>
                            <option>+9</option>
                        </select>
                    </div>
                    <a onclick="calc(2)" class="btn btn-success pull-right" id="clc2">CALCULATE</a> <img src="gifs/35.gif" style="display: none;" class="pull-right" id="gif2">

                </div>

                        <label style="color: red; display: none" id="error2" class="pull-right">ERROR</label>
                </form>
                <table class="table">
                    <tr><td colspan="1"><h5>UP SPEED</h5></td><td>&nbsp;</td>                                               <td><b id="as2">&nbsp;</b></td></tr>
                    <tr><td colspan="1"><h5>UP DAMAGE</h5></td><td>&nbsp;</td>                                               <td><b id="dmg2">&nbsp;</b></td></tr>
                    <tr><td colspan="2" ><h5>CURRENT DPS<text class="text-muted" id="aoe2">&nbsp;</text></h5></td>   <td><b id="dps2">&nbsp;</b></td></tr>
                    <tr><td colspan="2" ><h5>NEW DPS<text class="text-muted" id="newAoe2">&nbsp;</text></h5></td>       <td><b id="newDps2">&nbsp;</b></td></tr>
                    <tr><td colspan="1"><h5>DPS INCREASE PER MINERAL </h5></td><td>&nbsp;</td>                               <td><b id="dpm2">&nbsp;</b></td></tr>
                </table>
            </div>
        </div>
        </div>


        <div class="col-md-4" id="calculator3" style="display: none">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <form id="form3">
                        <div class="form-group">
                            <h4><a onclick="removeCalculator(3)" class="btn btn-warning pull-right" id="remove3">REMOVE</a><label class="text-center">DPS CALCULATOR</label></h4>
                            <label for="baseDmg3">TOWER</label>
                            <select class="form-control" id="baseDmg3" name="baseDmg3">
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
                            <label for="auraDmg3">AREA %DMG</label>
                            <input type="text" class="form-control" id="auraDmg3" name="auraDmg3" autocomplete="off" maxlength="3" placeholder="0">
                        </div>
                        <div class="form-group">
                            <label for="allDmgUpgrades3">ALL TOWERS DMG UPGRADES</label>
                            <input type="text" class="form-control" id="allDmgUpgrades3" name="allDmgUpgrades3" autocomplete="off" maxlength="3" placeholder="0">
                        </div>
                        <div class="form-group">
                            <label for="armor3">WAVE ARMOR</label>
                            <input type="text" class="form-control" id="armor3" name="armor3" autocomplete="off" maxlength="5" placeholder="0">
                        </div>

                        <div class="form-group" >
                            <label for="minerals3">MINERALS</label>
                            <input type="text" class="form-control" id="minerals3" name="minerals3" autocomplete="off" maxlength="6" placeholder="0">
                        </div>
                        <div class="form-inline">
                            <div class="form-group" >
                                <label for="dmgUpgrades3">DAMAGE</label>
                                <br>
                                <input type="text" class="form-control" id="dmgUpgrades3" name="dmgUpgrades3" autocomplete="off" maxlength="4" style="max-width: 130px" placeholder="0">
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label for="asUpgrades3">SPEED</label>
                                <br>
                                <input type="text" class="form-control" id="asUpgrades3" name="asUpgrades3" autocomplete="off" maxlength="2" style="max-width: 130px" placeholder="0">

                                &nbsp;

                                <div class="form-group pull-right">
                                    <a onclick="" class="btn btn-primary" id="set3">UP</a>
                                </div>
                            </div>
                        </div>

                        <br>
                        <div class="form-inline">
                            <div class="form-group" style="max-width: 70px">
                                <label for="bonusAs3">SPEED BONUS</label>
                                <select class="form-control" id="bonusAs3" name="bonusAs3">
                                    <option>4%</option>
                                    <option>5%</option>
                                    <option>6%</option>
                                </select>
                            </div>

                            <div class="form-group" style="max-width: 70px">
                                <label for="asCost3">SPEED COST</label>
                                <select class="form-control" id="asCost3" name="asCost3">
                                    <option>+1</option>
                                    <option>+2</option>
                                    <option>+3</option>
                                    <option>+4</option>
                                    <option>+5</option>
                                    <option>+6</option>
                                    <option>+7</option>
                                    <option>+8</option>
                                    <option>+9</option>
                                </select>
                            </div>

                            <div class="form-group" style="max-width: 70px">
                                <label for="dmgCost3">DMG COST</label>
                                <select class="form-control" id="dmgCost3" name="dmgCost3">
                                    <option>+1</option>
                                    <option>+2</option>
                                    <option>+3</option>
                                    <option>+4</option>
                                    <option>+5</option>
                                    <option>+6</option>
                                    <option>+7</option>
                                    <option>+8</option>
                                    <option>+9</option>
                                </select>
                            </div>
                            <a onclick="calc(3)" class="btn btn-success pull-right" id="clc3">CALCULATE</a> <img src="gifs/35.gif" style="display: none" id="gif3" class=" pull-right">

                        </div>
                        

                        <label style="color: red; display: none" id="error3" class="pull-right">ERROR</label>


                    </form>
                    <table class="table">
                        <tr><td colspan="1"><h5>UP SPEED</h5></td><td>&nbsp;</td>                                               <td><b id="as3">&nbsp;</b></td></tr>
                        <tr><td colspan="1"><h5>UP DAMAGE</h5></td><td>&nbsp;</td>                                               <td><b id="dmg3">&nbsp;</b></td></tr>
                        <tr><td colspan="2" ><h5>CURRENT DPS<text class="text-muted" id="aoe3">&nbsp;</text></h5></td>   <td><b id="dps3">&nbsp;</b></td></tr>
                        <tr><td colspan="2" ><h5>NEW DPS<text class="text-muted" id="newAoe3">&nbsp;</text></h5></td>       <td><b id="newDps3">&nbsp;</b></td></tr>
                        <tr><td colspan="1"><h5>DPS INCREASE PER MINERAL </h5></td><td>&nbsp;</td>                               <td><b id="dpm3">&nbsp;</b></td></tr>
                    </table>
                </div>
            </div>
        </div>



    </div>
    </div>
          <h4><span class="label label-default pull-left">ktotam#2538</span></h4>

</body>
</html>