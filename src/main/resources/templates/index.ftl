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
    <form name="setFirstPlayForm" action="/play/setFirstPlay">
        <input type="text" name="channelId" hidden value="guanDan"/>
        <div>第一个出牌的人:<input type="text" name="seatCode"/>
        <input type="submit">
    </form>
</body>
</html>