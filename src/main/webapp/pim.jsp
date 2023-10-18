
<%--
  Created by IntelliJ IDEA.
  User: 13873190666
  Date: 2023/5/7
  Time: 17:54
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
    <link rel="stylesheet" href="css/blog_edit.css">
    <link rel="stylesheet" href="css/pim.css">
    <script src="./cityAndPro.js"></script>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
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

<div class="form-div">
    <form action="infoSaveServlet" id="save-form" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input type="text" disabled="disabled" value="${username}">
                </td>

                <td>教育级别</td>
                <td class="inputs">
                    <input name="edu_level" type="text" id="edu_level" value="${edu_level}">
                </td>

            </tr>

            <tr>
                <td>姓名</td>
                <td class="inputs">
                    <input name="name" id="name" type="text" value="${name}">
                </td>

                <td>起止年月</td>
                <td>
                    <input name="edu_start" type="date" id="edu_start" placeholder="${edu_start}" value="${edu_start}">
                    --
                    <input name="edu_end" type="date" id="edu_end" placeholder="${edu_end}" value="${edu_end}">
                </td>
            </tr>

            <tr>
                <td>生日</td>
                <td>
                    <input name="birthday" type="date" id="birthday" placeholder="${birthday}" value="${birthday}">
                </td>

                <td>学校名称</td>
                <td class="inputs">
                    <input name="school" type="text" id="school" value="${school}">
                </td>
            </tr>

            <tr>
                <td>性别</td>
                <td>
                    <label>${gender}</label>
                    <input type="radio" id="gender" name="gender" value="男" checked> 男
                    <input type="radio" name="gender" value="女"> 女
                </td>

                <td>学位</td>
                <td>
                    <select name="degree" id="degree">
                        <option>学士</option>
                        <option>硕士</option>
                        <option>博士</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>电话</td>
                <td class="inputs">
                    <input type="text" name="telephone" id="telephone" value="${telephone}">
                </td>

                <td>当今工作单位</td>
                <td class="inputs">
                    <input name="workplace" type="text" id="workplace" value="${workplace}">
                </td>
            </tr>

            <tr>
                <td>Email</td>
                <td class="inputs">
                    <input type="text" name="email" id="email" value="${email}">
                </td>

                <td>起止年月</td>
                <td>
                    <input name="work_start" type="date" id="work_start" placeholder="${work_start}" value="${work_start}">
                    --
                    <input name="work_end" type="date" id="work_end" placeholder="${work_end}" value="${work_end}">
                </td>
            </tr>

            <tr>
                <td>地区</td>
                <td onload="getProvince()">
                    <select name="input_province" id="input_province">
                        <option value="${province}">${province}</option>
                    </select>
                    <select name="input_city" id="input_city">
                        <option value="${city}">${city}</option>
                    </select>
                </td>

                <td>职位</td>
                <td class="inputs">
                    <input name="job" type="text" id="job" value="${job}">
                </td>
            </tr>


        </table>

        <div class="buttons">
            <input value="保 存" type="submit" id="save_btn">
        </div>
        <br class="clear">
    </form>

</div>

<!--<script src="/js/jquery-3.6.0.js">-->
<!--    window.onload(function fun(){-->
<!--        $.post("infoSaveServlet",-->
<!--            function (username) {-->
<!--                -->
<!--            }-->
<!--        );-->
<!--    });-->
<!--</script>-->

<script>
    $(function() {
        var html = "";
        var province_idx;
        $("#input_city").append(html);

        $.each(cityMessage, function(idx, item) {
            if(item.parid == '1'){
                html += "<option value='" + item.regname + "' exid='" + item.regid + "'>" + item.regname + "</option>";
            }

        });
        $("#input_province").append(html);
        $("#input_province").change(function(e) {
            var province =$(this).val();
            var cityList = [];
            if(province == "") return;
            $("#input_city option").remove();
            var html = "<option value=''>--请选择--</option>";

//					获取已选择的省份的数组下标
            $.each(cityMessage, function(idx, item) {
                if(province == item.regname && item.parid == '1') {
                    province_idx=idx
                }
            })

//					获取已选择的省份的城市列表
            $.each(cityMessage, function(idx, item) {
                if(cityMessage[idx].parid == cityMessage[province_idx].regid) {
                    cityList.push(cityMessage[idx])
                }
            })

//					添加城市信息给标签
            if(cityList instanceof Array && cityList.length>0){
                $.each(cityList, function(idx, item) {
                    console.log(item)
                    html += "<option value='" + item.regname + "' exid='" + item.regid + "'>" + item.regname + "</option>";

                });
            }else{
                html += "<option value='" + cityMessage[province_idx].regname + "' exid='" + cityMessage[province_idx].regid + "'>" + cityMessage[province_idx].regname + "</option>";

            }
            $("#input_city").append(html);
        });
    });

    // $("#reg-form").submit(function () {
    //     $.post("registUserServlet", $("reg-form").serialize(), function (data) {
    //         if(data.flag) {
    //             location.href = "login.html"
    //         } else {
    //             $("#errMsg").html(data.errMsg);
    //         }
    //     });
    // });
</script>

</body>
</html>
