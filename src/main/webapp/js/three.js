// 收藏
$(document).ready(function() {
    $("#collect").click(function() {
        $("#thumbs1").toggle();
        $("#colltext").toggle();
        $("#thumbs2").toggle();
        $("#colltext2").toggle();

    });
});
// 点赞
$(document).ready(function() {
    $("#umbsbtn").click(function() {
        $("#umbsimg").toggle();
        $("#umbs1").toggle();
        $("#umbsimg2").toggle();
        $("#umbs2").toggle();
        $(".user-forum-thumbs-users").toggle();
        $.ajax({
            type:"post",
            url:"Add_GreatServlet",
            success:function (){
              alert('successful');
            },
            error:function(){
                console.log("error")
            }
        })
    });
});
// 评论
$(document).ready(function() {
    $("#openspeek").click(function() {
        $("#dialogs").toggle();
    });
});
// 评论弹窗关闭
function diacloses() {
    document.getElementById("dialogs").style.display = "none";
};
// 发表评论
function addDiv() {
    // 添加节点嵌套
    var node = document.createElement('div');
    var txt1 = document.createElement("p");
    var txt2 = document.createElement("span");
    var txt3 = document.createElement("span");
    var txt4 = document.getElementById('dialogtext').value;
    var btn1 = document.createElement('button');
    var btntxt = document.createElement('span');
    if (txt4 == '' || txt4 == ' ') {
        alert('请输入评论内容！');
    } else {
        node.className = 'user-remarks-content';
        btn1.id = 'btndel';
        // 插入内容
        txt2.innerHTML = "李诗诗：";
        txt3.innerHTML = txt4;
        btntxt.innerHTML = "删除";
        btn1.innerHTML = "<img src=" + 'imgs/ask.png' + ">";
        // 继续嵌套
        txt1.appendChild(txt2);
        txt2.appendChild(txt3);
        node.appendChild(txt1);
        btn1.appendChild(btntxt);
        node.appendChild(btn1);
        // 添加评论
        document.getElementById("addcontent").appendChild(node);
        // 输入null内容后跳出弹窗
        document.getElementById("dialogs").style.display = "none";
        // 跳出弹窗后清空文本内容
        $('#dialogtext').val('');

    };
    // 删除评论
    // 只能删一次
    $("#btndel").on("click", function() {
        $(this).parent().remove();
    });
}