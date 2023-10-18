<%--
  Created by IntelliJ IDEA.
  User: 13873190666
  Date: 2023/5/10
  Time: 21:42
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
  <link rel="stylesheet" href="css/reply.css">
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
    <form action="replytoRepServlet" id="blog" method="post">
      <table>
        <tr>
          <textarea id="main_body" name="content" placeholder="在这里写下回复"></textarea>
        </tr>
        <tr>
          <td>
            <input name="rid" value="${param.rid}" hidden>
            <button id="submit" type="submit">回复</button>
          </td>

        </tr>
      </table>

    </form>

  </div>
  <div>

  </div>
  <div></div>
</div>

</body>
</html>
