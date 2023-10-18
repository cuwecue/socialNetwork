<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/three.css">
  <script src="js/jquery-3.6.0.js"></script>
  <script src="js/three.js"></script>
  <title>blog_content</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* 设置整体页面高度 */
    html, body {
      height: 100%;
      background-image: url(imgs/bg.jpg);
      background-position: center center;
      background-size: cover;
      background-repeat: no-repeat;
    }

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

    /* 导航栏中的图标 */
    .nav img {
      width: 40px;
      height: 40px;
      margin-left: 30px;
      margin-right: 10px;
      border-radius: 50%;
    }

    /* 导航栏中的占位器 */
    .nav .spacer {
      width: 80%;
    }

    /* 导航栏中的按钮 */
    .nav a {
      color: #fff;
      text-decoration: none;
      padding: 0 10px;
    }

    /* 用户头像 */
    .card img {
      width: 140px;
      height: 140px;
      border-radius: 50%;
    }

    /* 用户名 */
    .card h3 {
      text-align: center;
      padding: 10px;
      margin-top: -130px;
    }

    /* 用户gitee连接 */
    .card a {
      display: block;
      text-align: center;
      color: #999;
      text-decoration: none;
      padding: 10px;
    }

    /* 展示文章数目的面板 */
    .card .counter {
      padding: 5px;
      display: flex;
      justify-content: space-around;
    }


    /* 博客正文 */
    #content_container {
      margin-top: 20px;
      background-color: rgba(255, 255, 255, 0.45);
      border-radius: 10px;
      padding: 30px;
    }

    /* 评论区域 */
    #comment_container, #reply_container, #replytorep_container {
      margin-top: 20px;
      background-color: rgba(255, 255, 255, 0.45);
      border-radius: 1px;
      padding: 30px;
    }

    /*body {font-family: Arial, Helvetica, sans-serif;}*/

    /* 模态（背景）*/
    .modal {
      display: none; /* 默认隐藏 */
      position: fixed; /* 留在原地 */
      z-index: 1; /* Sit on top */
      left: 0;
      top: 0;
      width: 100%; /* 全屏宽度 */
      height: 100%; /* 全高 */
      overflow: auto; /* 如果需要启用滚动 */
      background-color: rgb(0,0,0); /* 后备颜色 */
      background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
      -webkit-animation-name: fadeIn; /* 在背景中淡入淡出 */
      -webkit-animation-duration: 0.4s;
      animation-name: fadeIn;
      animation-duration: 0.4s
    }

    /* 模态内容 */
    .modal-content {
      position: fixed;
      bottom: 0;
      background-color: #fefefe;
      width: 100%;
      -webkit-animation-name: slideIn;
      -webkit-animation-duration: 0.4s;
      animation-name: slideIn;
      animation-duration: 0.4s
    }

    /* 关闭按钮 */
    #close_1 {
      color: white;
      float: right;
      font-size: 28px;
      font-weight: bold;
    }

    #close_1:hover,
    #close_1:focus {
      color: #000;
      text-decoration: none;
      cursor: pointer;
    }

    /* 关闭按钮 */
    #close_2 {
      color: white;
      float: right;
      font-size: 28px;
      font-weight: bold;
    }

    #close_2:hover,
    #close_2:focus {
      color: #000;
      text-decoration: none;
      cursor: pointer;
    }

    .modal-header {
      padding: 2px 16px;
      background-color: rgb(119, 150, 180);
      color: white;
    }

    .modal-body {padding: 2px 16px;}

    .modal-footer {
      padding: 2px 16px;
      background-color: #7796b4;
      color: white;
    }

    /* 添加动画 */
    @-webkit-keyframes slideIn {
      from {bottom: -300px; opacity: 0}
      to {bottom: 0; opacity: 1}
    }

    @keyframes slideIn {
      from {bottom: -300px; opacity: 0}
      to {bottom: 0; opacity: 1}
    }

    @-webkit-keyframes fadeIn {
      from {opacity: 0}
      to {opacity: 1}
    }

    @keyframes fadeIn {
      from {opacity: 0}
      to {opacity: 1}
    }
  </style>
</head>
<body>

<!-- 导航栏 -->
<div class="nav">
  <img src="imgs/huahua.jpg" alt="">
  <span class="title">${param.username}的博客</span>
  <!-- 用来占据中间位置 -->
  <span class="spacer"></span>
  <a href="pim.jsp?">个人中心</a>
  <a href="friends.jsp">好友</a>
  <a href="blog_list.jsp">主页</a>
  <a href="blog_edit.html">写博客</a>
  <a href="blog_check.html">博客查询</a>
  <a href="login.html">注销</a>
</div>

<!-- 博客正文 -->
<div class="blog-content" id="content_container">
</div>
<div class="blog-content" id="comment_container">
</div>
<div class="blog-content" id="reply_container">
</div>
<div class="blog-content" id="replytorep_container">
</div>

<!-- 模态框 -->
<div id="myModal" class="modal">

  <!-- 模态内容 -->
  <div class="modal-content">
    <div class="modal-header">
      <span id="close_1">&times;</span>
      <p id="modal_cid" hidden></p>
      <h2 id="modal_title"></h2>
    </div>
    <div class="modal-body">
      <input type='text' name='reply' placeholder='在这里写下回复' id='reply_content'>
    </div>
    <div class="modal-footer">
      <button id="submit_reply">提交</button>
    </div>
  </div>

</div>

<!-- 二级模态框 -->
<div id="anotherModal" class="modal">

  <!-- 模态内容 -->
  <div class="modal-content">
    <div class="modal-header">
      <span id="close_2">&times;</span>
      <p id="another_rid" hidden></p>
      <h2 id="another_title"></h2>
    </div>
    <div class="modal-body">
      <input type='text' name='reply' placeholder='在这里写下回复' id='another_content'>
    </div>
    <div class="modal-footer">
      <button id="another_reply">提交</button>
    </div>
  </div>

</div>

<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/jquery-3.6.0.js"></script>
<script src="js/three.js"></script>
<script type="text/javascript" src="js/getParameter.js"></script>
<script type="text/javascript">

  var global_comments = null;
  var global_replytocoms = null;
  var global_replytoreps = null;

  // 获取模态
  var modal = document.getElementById("myModal");

  // 获取关闭模态的 <span> 元素
  var span = document.getElementById("close_1");

  // 当用户点击按钮时，打开模态
  function modal_on(cid,commenter) {
    var modal_cid = document.getElementById("modal_cid");
    var modal_title = document.getElementById("modal_title");
    modal_cid.innerHTML = cid;
    modal_title.innerHTML = "回复"+commenter+":";
    modal.style.display = "block";
  }

  $(function(){
    $("#submit_reply").click(function (event){
      event.preventDefault(); // 防止默认操作
      var cid = document.getElementById('modal_cid');
      var content = document.getElementById('reply_content')
      $.ajax({
        type:"get",
        datatype:"json",
        url:"replytoComServlet",
        data:{"cid":cid.innerHTML,
          "content":content.value,
          "href":"blog_content.jsp?"+"bid="+"${param.bid}"+"&username="+"${param.username}"},
        error: function (){
          alert("请求失败");
        },
        success: function (){
          modal.style.display = "none";
          location.reload();
        },
      })
    })
  })

  // 当用户点击 <span> (x) 时，关闭模态
  span.onclick = function() {
    modal.style.display = "none";
  }

  // 当用户点击模态之外的任何地方时，关闭它
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
    if (event.target == another_modal) {
      another_modal.style.display = "none";
    }
  }

  // 获取模态
  var another_modal = document.getElementById("anotherModal");

  // 获取关闭模态的 <span> 元素
  var another_span = document.getElementById("close_2");

  // 当用户点击按钮时，打开模态
  function another_modal_on(rid,commenter) {
    var another_rid = document.getElementById("another_rid");
    var another_title = document.getElementById("another_title");
    another_rid.innerHTML = rid;
    another_title.innerHTML = "回复"+commenter+":";
    another_modal.style.display = "block";
  }

  $(function(){
    $("#another_reply").click(function (event){
      event.preventDefault(); // 防止默认操作
      var rid = document.getElementById('another_rid');
      var content = document.getElementById('another_content')
      $.ajax({
        type:"get",
        datatype:"json",
        url:"replytoRepServlet",
        data:{"rid":rid.innerHTML,
          "content":content.value,
          "href":"blog_content.jsp?"+"bid="+"${param.bid}"+"&username="+"${param.username}"},
        error: function (){
          alert("请求失败");
        },
        success: function (){
          another_modal.style.display = "none";
          location.reload();
        },
      })
    })
  })

  // 当用户点击 <span> (x) 时，关闭模态
  another_span.onclick = function() {
    another_modal.style.display = "none";
  }


  $(function (){
    var blog_show = "";
    var username = "${param.username}";
    var comment = "";
    var replytocom = "";
    var replytorep = "";
    var bid = "${param.bid}";
    $.ajax({
      type:"get",
      datatype:"json",
      url:"contentShowServlet",
      data : {"bid" : bid},
      error: function (){
        alert("请求失败");
      },
      success: function (blog){
        blog_show += "<h3>"+blog.title+"</h3>"
        blog_show += "<div class='date'>"+blog.time+"</div>"
        blog_show += "<form action='commentServlet' method='post'>"
        blog_show += "<input type='text' name='comment' placeholder='在这里写下评论' id='title'>"
        blog_show += "<input name='bid' value="+"${param.bid}"+" hidden>";
        blog_show += "<input name='href' value="+"'blog_content.jsp?"+"bid="+bid+"&username="+username+"' hidden>";
        blog_show += "<button id='submit' type='submit'>发布评论</button>"
        blog_show += "</form>"


        if(blog.part==1)
          blog_show +=  "<h4>"+"分区: "+"娱乐"+"<h4>"
        if(blog.part==2)
          blog_show += "<h4>"+"分区: "+"生活"+"<h4>"
        if(blog.part==3)
          blog_show += "<h4>"+"分区: "+"学习"+"<h4>"
        if(blog.part==4)
          blog_show += "<h4>"+"分区: "+"运动"+"<h4>"
        if(blog.part==5)
          blog_show += "<h4>"+"分区: "+"美食"+"<h4>"
        if(blog.part==6)
          blog_show += "<h4>"+"分区: "+"宠物"+"<h4>"
        if(blog.part==7)
          blog_show += "<h4>"+"分区: "+"游戏"+"<h4>"
        if(blog.part==8)
          blog_show += "<h4>"+"分区: " +"科技" +" <h4>"


        blog_show += "<h6>"+blog.main_body+"</h6>"
        blog_show +="<img src='"+blog.picture+"' width='200px' height='150px'>";
        blog_show += "<h6>"+blog.picture+"</h6>"


        if(blog.username=="${username}"){
          blog_show += "<form action='blogDeleteServlet' method='post'>"
          blog_show += "<input name='del_bid' value='${param.bid}' hidden>";
          blog_show += "<button id='delete' type='submit'>删除博客</button>"
          blog_show += "</form>"
        }
      /*blog +="<div class='user-forum-thumbs'>"
       blog += "<button id='umbsbtn' onclick='addgreat'>"
       blog +="<img src='imgs/heart.png' id='umbsimg'>"
       blog += "<span id='umbs1'>点赞</span>"
       blog +=  "<img src='imgs/newheart.png' id='umbsimg2' style='display: none;'>"
        blog +="<span id='umbs2' style='display: none;'>取消</span>"
         blog += "</button>"

       blog +="<button id='collect‘ onclick=‘addgreat’>"
        blog +=   " <img src='imgs/collect.png' id='thumbs1'>"
        blog +=    "  <span id='colltext'>收藏</span>"
         blog +=    " <img src='imgs/newcollect.png' id='thumbs2' style='display: none;'>"
         blog +=      " <span id='colltext2' style='display: none;' >取消</span>"
         blog += "</button>"

       blog += "</div>"*/

        $("#content_container").html(blog_show)
      }
    })


    $.ajax({
      type: "get",
      datatype: "json",
      url: "commentShowServlet",
      data: {"bid" : bid},
      error: function (){
        alert("请求失败")
      },
      success: function (comments){
        for(var i=0;i<comments.length;i++){
          comment += "<h5>"+comments[i].commenter+": " +comments[i].content +"  " + "<span style='font-size:8px;color:grey'>" + comments[i].time + "</span>" +
                  "<button class='reply_btn' onclick='modal_on("+comments[i].cid+",\""+comments[i].commenter+"\")'>回复</button>" + "</h5>"
        }
        $("#comment_container").html(comment)
      }
    })


    $.ajax({
      type: "get",
      datatype: "json",
      url: "replytoComShowServlet",
      data: {"bid" : bid},
      error: function (){
        alert("请求失败")
      },
      success: function (replytocoms){
        for(var i=0;i<replytocoms.length;i++){
          replytocom += "<h5>"+replytocoms[i].replier+"回复" + replytocoms[i].commenter + ": " + replytocoms[i].content+"  "+ "<span style='font-size:8px;color:grey'>" + replytocoms[i].rep_time + "</span>" +"<button class='reply_btn' onclick='another_modal_on("+replytocoms[i].rid+",\""+replytocoms[i].replier+"\")'>回复</button>"
        }
        $("#reply_container").html(replytocom)
      }
    })

    $.ajax({
      type: "get",
      datatype: "json",
      url: "replytoRepShowServlet",
      data: {"bid" : bid},
      error: function (){
        alert("请求失败")
      },
      success: function (replytoreps){
        for(var i=0;i<replytoreps.length;i++){
          replytorep += "<h5>"+replytoreps[i].replier+"回复"+replytoreps[i].tar_replier+ ": " +replytoreps[i].content+" "+ "<span style='font-size:8px;color:grey'>" + replytoreps[i].rep_time + "</span>" +"</h5>"
        }
        $("#replytorep_container").html(replytorep)
      }
    })

  })
</script>
<link rel="stylesheet" href="css/three.css">
<script src="js/jquery-3.6.0.js"></script>
<script src="js/three.js"></script>
<a class="user-forum-thumbs">

  <button id="umbsbtn" >
    <img  src="imgs/heart.png" id="umbsimg"  height="40px">
    <span id="umbs1">点赞</span>
    <img src="imgs/newheart.png" id="umbsimg2" style="display: none"; height="40px">
    <span id="umbs2" style="display: none;">取消</span>
  </button>
  <button id="collect" >
    <img src="imgs/collect.png" id="thumbs1" height="40px">
    <span id="colltext">收藏</span>
    <img src="imgs/newcollect.png" id="thumbs2" style="display: none;" height="40px">
    <span id="colltext2" style="display: none;" >取消</span>
  </button>

</a>
</body>
</html>

