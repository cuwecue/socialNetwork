<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>blog_list</title>
  <link rel="stylesheet" href="css/blog_list.css">
  <link rel="stylesheet" href="css/three.css">
  <script src="js/jquery-3.6.0.js"></script>
  <script src="js/three.js"></script>
  <style>
    /* 上方导航栏 */
    .nav {
      width: 100%;
      height: 50px;
      background-color: rgba(51, 51, 51, 0.4);
      color: #fff;

      display: flex;
      justify-content: left;
      align-items: center;
    }

    #header a {
      color: #fff;
      text-decoration: none;
      padding: 0 10px;
    }

    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      background: url("imgs/bg.jpg");
    }

    #header {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 50px;
      background-color: #333;
      color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 0 20px;
    }

    #header img{
      width: 40px;
      height: 40px;
      margin-left: 30px;
      margin-right: 10px;
      border-radius: 50%;
    }

    #header .spacer {
      width: 80%;
    }

    #toolbar {
      display: flex;
      align-items: center;
    }

    #toolbar button {
      margin-left: 10px;
      padding: 5px 10px;
      border: none;
      border-radius: 5px;
      background-color: #fff;
      color: #333;
      cursor: pointer;
    }

    #scroll-area {
      margin-top: 50px;
      height: calc(100vh - 50px);
      background-image: url("/imgs/bg.jpg");
      background-size: cover;
      background-position: center center;
      overflow-y: auto;
      padding: 20px;
      box-sizing: border-box;
      color: #333;
      font-size: 16px;
      line-height: 1.5;
    }

    #scroll-area h2 {
      margin-top: 0;
      font-size: 36px;
    }

    #scroll-area p {
      margin-bottom: 20px;
      background-color: rgba(255,255,255,0.45);
    }

    .blog a{
      font-size: 2px;
    }

    .blog img {
      width: 200px;
      height: 150px;
    }
  </style>
</head>
<body>
<div id="header">
  <img src="imgs/huahua.jpg" alt="">
  <span class="title">${username}的博客系统</span>
  <span class="spacer"></span>
  <a href="pim.jsp">个人中心</a>
  <a href="friends.jsp">好友</a>
  <a href="blog_list.jsp">主页</a>
  <a href="blog_edit.html">写博客</a>
  <a href="blog_check.html">博客查询</a>
  <a href="login.html">注销</a>
</div>

<div id="scroll-area">
  <p>博客内容17</p>
  <p>博客内容18</p>
  <p>博客内容19</p>
  <p>博客内容20</p>
</div>

<script src="js/jquery-1.11.0.min.js"></script>
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
          blog += "<p class='blog'>"
          blog += "<div class='title'>"+blogs[i].username+"的第"+id+"篇博客</div>"
          blog += "<div class='date' style='color: orange;font-size: 10px'>"+blogs[i].time+"</div>"
          blog += "<div class='desc'>"+blogs[i].title+"</div>"
          // blog += "<a href='blog_content.jsp?blogId="+blogs[i].bid+"' class='detail'>"+"查看全文 &gt;&gt;</a>"
          blog += "<div class='content'>" + blogs[i].main_body.substring(0, 50) + "...";
          blog += "<a href='blog_content.jsp?"+"id="+id+"&bid="+blogs[i].bid+"&username="+username+"' class='detail' style='font-size: 10px'>查看全文 &gt;&gt;</a></div>"
          blog += "<div class='picture'><img src='"+blogs[i].picture+"' alt='image' width='300px'></div>";
          blog += "</p>"
          /*blog +="<div class='user-forum-thumbs'>"
          blog += "<button id='umbsbtn' onclick='addgreat'>"
          blog +="<img src='imgs/heart.png' id='umbsimg'>"
          blog += "<span id='umbs1'>点赞</span>"
          blog +=  "<img src='imgs/newheart.png' id='umbsimg2' style='display: none;'>"
          blog +="<span id='umbs2' style='display: none;'>取消</span>"
          blog += "</button>"

          blog +="<button id='collect‘ onclick=‘addgreat’>"
          blog += " <img src='imgs/collect.png' id='thumbs1'>"
          blog += "  <span id='colltext'>收藏</span>"
          blog += " <img src='imgs/newcollect.png' id='thumbs2' style='display: none;'>"
          blog += " <span id='colltext2' style='display: none;' >取消</span>"
          blog += "</button>"
          blog += "</div>"*/

        }
        $("#scroll-area").html(blog)
      }
    });
  })
</script>
</body>
</html>

