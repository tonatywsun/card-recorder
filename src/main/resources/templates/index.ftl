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
    <div>第一个出牌的人:<input type="text" name="setFirstPlayText" id="setFirstPlayText"/>
    </div>
    <div align="10px">
        <button type="button" id="resetButton" onclick="reset('${url}')" >重置</button>
        <button type="button" id="submitButton" onclick="submit()">确定</button>
    </div>
</body>
<script type="text/javascript">

    function submit(){
        var firstPlay = $("#setFirstPlayText").val();
        alert(firstPlay);
    }

    function reset(url) {
        $("#setFirstPlayText").val('');
        var data = {"channelId": "guanDan"};
        $.ajax({
            url: url,
            type: "POST",
            data: JSON.stringify(data),
            dataType: "json",
            scriptCharset: 'UTF-8',
            processData: false,
            contentType: "application/json",
            sync: false,
            success: function (data) {
            },
            error: function (e) {
                alert(e);
            }
        });
    }
</script>
</html>