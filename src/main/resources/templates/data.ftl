<!DOCTYPE html>
<html lang="en">
<style type="text/css">
    button {
        width: 50px;
        height: 30px;
    }
</style>
<head>
    <meta charset="utf-8"/>
    <script src='https://code.jquery.com/jquery-3.6.0.min.js'  type='text/javascript'></script>
    <title>手动记牌器</title>
</head>
<body>
    <div><a href="/play/indexPage">首页</a></div>
    <form name="playForm" action="/play/play">
        <input type="text" name="channelId" hidden value="guanDan"/>
        <div>自己出牌:<input type="text" name="playCards1"/></div>
        <div>下家出牌:<input type="text" name="playCards2"/></div>
        <div>对家出牌:<input type="text" name="playCards3"/></div>
        <div>上家出牌:<input type="text" name="playCards4"/></div>
        <input type="submit">
    </form>
    <div>
        <#if userInfo??>${userInfo}</#if>
    </div>
    <div>
    <#if surplus??>
            <#list surplus?keys as key>
                ${key}---${surplus[key]}
            </#list>
        </#if>
    </div>
</body>
</hrml>