<%--
  Created by IntelliJ IDEA.
  User: yyds
  Date: 2023/6/27
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>私信</title>
</head>
<body>
<div id="chatRoom">与${param.toname}的聊天</div>
<br><br><br>
<form>
    <input type="text" id="messageInput" placeholder="Type a message……">
    <button type="connection">connect</button>
    <button type="submit">submit</button>
</form>

<script src="/js/jquery-1.11.0.min.js"></script>
<script>
    let fromuser="${param.fromname}";
    let touser="${param.toname}"
    let webSocket={
        ws:null,
        openSocket(){
            ws=new WebSocket("ws://localhost:8080/demo/"+fromuser);

            ws.onopen=()=>{
                console.log("连接已经打开")
            };

            ws.onmessage=msg=>{
                console.log("接收消息"+msg.data);
                $("#chatRoom").append('<div>${msg.data}</div>');
            };

            ws.onclose=()=>{
                console.log("连接关闭");
                this.openSocket();  //宠信打开连接
            };
        },
        send(content,toUserId){
            let msg={
                content,
                toUserId
            };
            ws.send(JSON.stringify(msg));
       }
   };

    $('#connection').on("click",()=>{
        webSocket.openSocket();
    });

    $('#submit').on("click",()=>{
        webSocket.send($("#messageInput").val(),touser)
    });

</script>
</body>
</html>
