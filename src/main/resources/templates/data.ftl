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
        <#if userInfo??>
            <table frame="box" rules="all" style="border-collapse:collapse">
                <#list userInfo?keys as key>
                    ${userInfo[1].playOrder}
                </#list>
            </table>
        </#if>
    </div>
    <div>
    <#if surplus??>
        <table frame="box" rules="all" style="border-collapse:collapse">
            <tr>
                <th>
                    <span>牌</span>
                </th>
                <#list surplus?keys as key>
                    <th>
                        <span><#if key=='0'>10<#elseif key=='X'>小王<#elseif key=='D'>大王<#else>${key}</#if></span>
                    </th>
                </#list>
            </tr>
            <tr>
                <td>张数</td>
                <#list surplus?keys as key>
                    <td>${surplus[key]}</td>
                </#list>
            </tr>
        </#if>
    </div>
</body>
</hrml>