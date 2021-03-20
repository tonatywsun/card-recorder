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
        <div>右边出牌:<input type="text" name="playCards2"/></div>
        <div>对家出牌:<input type="text" name="playCards3"/></div>
        <div>左家出牌:<input type="text" name="playCards4"/></div>
        <input type="submit">
    </form>
    <br/>
    <div>
        <#if user1Info??>
            <table frame="box" rules="all" style="border-collapse:collapse">
                <tr>
                    <td>${user1Info.seat}</td>
                    <#if user1Info.playList??>
                        <#list user1Info.playList as playList>
                            <td>${playList}</td>
                        </#list>
                        <td>${user1Info.unPlayCard}</td>
                        <td>${user1Info.remainder}</td>
                    </#if>
                </tr>
                <tr>
                    <td>${user2Info.seat}</td>
                    <#list user2Info.playList as playList>
                        <td>${playList}</td>
                    </#list>
                    <td>${user2Info.unPlayCard}</td>
                    <td>${user2Info.remainder}</td>
                </tr>
                <tr>
                    <td>${user3Info.seat}</td>
                    <#list user3Info.playList as playList>
                        <td>${playList}</td>
                    </#list>
                    <td>${user3Info.unPlayCard}</td>
                    <td>${user3Info.remainder}</td>
                </tr>
                <tr>
                    <td>${user4Info.seat}</td>
                    <#list user4Info.playList as playList>
                        <td>${playList}</td>
                    </#list>
                    <td>${user4Info.unPlayCard}</td>
                    <td>${user4Info.remainder}</td>
                </tr>
            </table>
        </#if>
    </div>

    <#if surplus??>
        <div>
            <div>剩余的牌数:</div>
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
            </table>
        </div>
    </#if>

</body>
</hrml>