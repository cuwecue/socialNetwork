<%--
  Created by IntelliJ IDEA.
  User: 13873190666
  Date: 2023/5/9
  Time: 18:16
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
  <link rel="stylesheet" href="css/add_friends.css">
</head>
<body>
<!-- 导航栏 -->
<div class="nav">
  <img src="imgs/huahua.jpg" alt="">
  <span class="title">我的博客系统</span>
  <!-- 用来占据中间位置 -->
  <span class="spacer"></span>
  <a href="pim.jsp">个人中心</a>
  <a href="friends.jsp">好友</a>
  <a href="blog_list.jsp">主页</a>
  <a href="blog_edit.html">写博客</a>
  <a href="blog_check.html">博客查询</a>
  <a href="login.html">注销</a>
</div>

<!-- 编辑框容器 -->
<div class="blog-edit-container">
  <!-- 标题编辑区 -->
  <div>
    <form action="addFriendsServlet" id="blog" method="post">
      <table>
        <tr>
          <input type="text" name="user_2" placeholder="请输入用户名" id="title">
          <button id="submit" type="submit">添加</button>
        </tr>
        <tr>
          <ul id="friends">

          </ul>
        </tr>
      </table>

    </form>

  </div>
  <div>

  </div>
  <div></div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/getParameter.js"></script>
<script type="text/javascript">
  $(function (){
    var friends;
    var friend = "";
    $.ajax({
      type : "get",
      datatype : "json",
      url : "friendsShowServlet",
      error : function (){
        alert("请求失败");
      },
      success : function (friends) {
        for(var i=0;i<friends.length;i++){
          friend += "<li><a class='list' href='friend_blog_list.jsp?username="+friends[i]+"'>"+friends[i]+"</a></li>"
        }
        $("#friends").html(friend);
      }
    })
  })
/*
  $('.delete-btn').click(function() {
    friendname=friends[i];
    deleteRecord(friendname); // 发送 Ajax 请求，删除数据库中相应的记录
  });
  function deleteRecord(friendname) {
    var data = {friendname: friendname}; // 将唯一标识信息封装为一个对象，用于发送 Ajax 请求
    $.ajax({
      type: "POST",
      url: "FriendsDeleteServlet", // 后端服务器的删除接口地址
      data: data,
      success: function () {
        location.html = "friends.jsp";
      },
      error: function () {
        // 删除失败时，处理错误情况
        console.log("删除失败！")
      }
    });
  }
*/
</script>

</body>
</html>

