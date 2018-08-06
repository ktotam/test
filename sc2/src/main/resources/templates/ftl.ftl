<#ftl encoding='UTF-8'>
<html>
<head>
    <title>EnTropy TD dps calculator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="js/js.js"></script>
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
                            <option>0.36</option>
                            <option>0.37</option>
                            <option>0.4</option>
                            <option>0.66</option>
                            <option>0.7</option>
                            <option>0.78</option>
                            <option>0.83</option>
                            <option>0.85</option>
                            <option>0.86</option>
                            <option>0.9</option>
                            <option>1.15</option>
                            <option>1.22</option>
                            <option>1.47</option>
                            <option>1.58</option>
                            <option>1.62</option>
                            <option>1.9</option>
                            <option>2.02</option>
                            <option>2.13</option>
                            <option>2.18</option>
                            <option>2.45</option>
                            <option>2.7</option>
                            <option>3.3</option>
                            <option>4.2</option>
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
                        <label for="asUpgrades">AS</label>
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
                            <label for="bonusAs">AS BONUS</label>
                            <select class="form-control" id="bonusAs" name="bonusAs">
                                <option>4%</option>
                                <option>5%</option>
                                <option>6%</option>
                            </select>
                        </div>
                        <div class="form-group" style="max-width: 70px">
                            <label for="bonusAs">AS<br>COST</label>
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

                        <a onclick="calc()" class="btn btn-success btn-lg">CALCULATE</a>

                </form>
            </div>
            <div class="panel-body">
                <textarea spellcheck="false" style="resize: none;min-height: 75px" class="form-control" id="area">${text}</textarea>
                <br>
                <div class="form-inline">
                    <a onclick="set()" class="btn btn-primary">SET</a>
                </div>
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
                        <h4><label id="aa">&nbsp;</label></h4>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>