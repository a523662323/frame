<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <link rel="stylesheet" type="text/css" href="../css/aui.css" />
</head>
<body>
<div class="aui-content aui-margin-b-15">
    <ul class="aui-list aui-form-list">
        <li class="aui-list-header">带有输入框</li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    Text
                </div>
                <div class="aui-list-item-input">
                    <input type="text" placeholder="Name">
                </div>
            </div>
        </li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    Password
                </div>
                <div class="aui-list-item-input">
                    <input type="password" placeholder="Password" id="password">
                </div>
            </div>
        </li>
    </ul>
</div>
<form action="/submit" method="post">
    <input type="text" name="name"/>
    <input type="password" name="password"/>
    <input type="submit" value="submit"/>
</form>
</body>
<script type="text/javascript" src="../script/api.js"></script>
<script type="text/javascript">
//    apiready = function(){
//        api.parseTapmode();
//        var header = $api.byId('aui-header');
//        $api.fixStatusBar(header);
//        var headerPos = $api.offset(header);
//        var body_h = $api.offset($api.dom('body')).h;
//        api.openFrame({
//            name: 'list_swipe_frm',
//            url: 'list_swipe_frm.html',
//            bounces: true,
//            rect: {
//                x: 0,
//                y: headerPos.h,
//                w: 'auto',
//                h: 'auto'
//            }
//        })
//
//
//    };
//    function closeWin(){
//        api.closeWin({
//        });
//    }
</script>
</html>