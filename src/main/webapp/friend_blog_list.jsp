<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>friend-blog_list</title>
    <link rel="stylesheet" href="css/blog_list.css">
    <style>
        /* 上方导航栏 */
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
        }
        /* 表示一篇博客 */
        .blog {
            width: 100%;
            padding: 10px 20px;
        }

        /* 博客的标题 */
        .blog .title {
            color: orangered;
            font-size: 20px;
            font-weight: 700;
            padding: 10px 0;
        }

        /* 博客的摘要 */
        .blog .desc {
            color: #000;
            text-indent: 2em;
            margin-top: 10px;
        }

        .blog .date {
            color: orange;
            margin-top: 10px;
        }

        /* 查看详情 按钮 */
        .blog .detail {
            display: block;
            width: 60px;
            height: 20px;
            line-height: 40px;
            color: black;
            text-align: center;
            text-decoration: none;
            margin: 10px auto 0 auto;
            border: 2px solid black;

            /* 给颜色加上过渡效果 */
            transition: all 0.3s;
        }

        /* 查看详情按钮的鼠标 hover 效果 */
        .blog .detail:hover {
            background-color: #000;
            color: #fff;
        }
        .blog .picture{
            width:200px;
            height:150px;
        }
        #delete_btn{
            margin-top: 20px;
            height: 40px;
            width: 100px;
            color: white;
            background-color: orange;
            border: none;
            outline: none;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div id="header">
    <img src="imgs/huahua.jpg" alt="">
    <span class="title">${param.username}的博客</span>
    <span class="spacer"></span>
    <a href="pim.jsp">个人中心</a>
    <a href="friends.jsp">好友</a>
    <a href="blog_list.jsp">主页</a>
    <a href="blog_edit.html">写博客</a>
    <a href="blog_check.html">博客查询</a>
    <a href="login.html">注销</a>
</div>
<!--添加删除按钮-->
<br>
<br>
<br>
<br>
<div>
    <button id="delete_btn">删除该好友</button>
</div>

<div id="scroll-area">
</div>


<script src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/getParameter.js"></script>

<script type="text/javascript">
    //代码自动执行
    $(function(){
        var blogs;
        var blog ="";
        var id=1;
        var username = "${param.username}"
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
                }
                $("#scroll-area").html(blog)
            }
        });
    })
</script>
<!--删除事件-->
<script>
    $(function () {
        var friendname = "${param.username}"
        $("#delete_btn").click(function () {
            //alert("??")
            $.ajax({
                type:"post",
                data:{friendname:friendname},
                url:"FriendsDeleteServlet",
                success:function(){
                    location.href="friends.jsp"
                },
                error:function(){
                    console.log("删除失败")
                }
            })
        });
    });
</script>
</body>
</html>

