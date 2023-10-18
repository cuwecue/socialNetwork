<%--
  Created by IntelliJ IDEA.
  User: 13873190666
  Date: 2023/5/8
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>blog_edit</title>
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="css/blog_list.css">
</head>
<body>
<!-- 导航栏 -->
<div class="nav">
  <img src="imgs/花花.jpg" alt="">
  <span class="title">${name}的博客系统</span>
  <!-- 用来占据中间位置 -->
  <span class="spacer"></span>
  <a href="pim.jsp">个人中心</a>
  <a href="friends.jsp">好友</a>
  <a href="blog_list.jsp">主页</a>
  <a href="blog_edit.html">写博客</a>
  <a href="blog_statistics.html">博客统计</a>
  <a href="login.html">注销</a>
</div>

<!-- 版心 -->
<div class="container">
  <!-- 左侧个人信息 -->
  <div class="container-left"></div>
  <!-- 右侧内容详情 -->
  <div class="container-right"></div>
</div>

<!-- 左侧个人信息 -->
<div class="container-left">
  <div class="card">
    <img src="imgs/花花.jpg" class="avtar" alt="">
    <a></a>
    <a></a>
    <h3>${username}</h3>
  </div>
</div>

<!-- 右侧内容详情 -->
<div class="container-right" id="blog_container">

</div>

<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/getParameter.js"></script>
<script type="text/javascript">
  //代码自动执行
  $(function(){
    var blogs;
    var blog ="";
    var id=1;
    var username = "${username}"
    /* 异步请求数据  */
    $.ajax({
      type : "get",
      dataType : "json",
      url : "blogShowServlet",
      data : {"username" : username},
      error : function(){
        alert("请求失败");
      },
      success : function(blogs) {
        for(var i=0;i<blogs.length;i++){
            id=i+1
            blog += "<div class='blog'>"
            blog += "<div class='title'>"+blogs[i].username+"的第"+id+"篇博客</div>"
            blog += "<div class='date'>"+blogs[i].time+"</div>"
            blog += "<div class='desc'>"+blogs[i].title+"</div>"
            // blog += "<a href='blog_content.jsp?blogId="+blogs[i].bid+"' class='detail'>"+"查看全文 &gt;&gt;</a>"
            blog += "<a href='blog_content.jsp?"+"id="+id+"&bid="+blogs[i].bid+"&username="+username+"' class='detail'>查看全文 &gt;&gt;</a>"
            blog += "</div>"
        }
        $("#blog_container").html(blog)
      }
    });
  })
</script>

</body>
</html>

