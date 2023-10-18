<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8">
  <title>Insert title here</title>
  <link rel="stylesheet" type="text/css"href="<%=path%>/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="<%=path%>/css/zyupload-1.0.0.css" />
  <script type="text/javascript" src="<%=path%>/js/jquery-3.1.1.min.js"></script>
  <script type="text/javascript" src="<%=path%>/js/zyupload-1.0.0.js"></script>
</head>
<body>
<div id="demo" class="demo"></div>
</body>
<script type="text/javascript">
  var path='<%=path%>';
  $(function(){
    // 初始化插件
    $("#demo").zyUpload({
      width            :   "100%",                 // 宽度
      height           :   "400px",                 // 宽度
      itemWidth        :   "150px",                 // 文件项的宽度
      itemHeight       :   "210px",                 // 文件项的高度
      url              :  path+"/test/uploadPhoto",  // 上传文件的路径
      fileType         :   ["jpg","png","PNG","JPG"],// 上传文件的类型
      multiple         :   true,                    // 是否可以多个文件上传
      dragDrop         :   true,                    // 是否可以拖动上传文件
      del              :   true,                    // 是否可以删除文件
      finishDel        :   false,  				  // 是否在上传文件完成后删除预览
      /* 外部获得的回调接口 */
      onSelect: function(files, allFiles){                    // 选择文件的回调方法
        console.info("当前选择了以下文件：");
        console.info(files);
        console.info("之前没上传的文件：");
        console.info(allFiles);
      },
      onDelete: function(file, surplusFiles){                     // 删除一个文件的回调方法
        console.info("当前删除了此文件：");
        console.info(file);
        console.info("当前剩余的文件：");
        console.info(surplusFiles);
      },
      onSuccess: function(file,response){                    // 文件上传成功的回调方法
        console.info("此文件上传成功：");
        console.info(file);
      },
      onFailure: function(file){                    // 文件上传失败的回调方法
        console.info("此文件上传失败：");
        console.info(file);
      },
      onComplete: function(responseInfo){           // 上传完成的回调方法
        console.info("文件上传完成");
        console.info(responseInfo);
        myConfirm('提示', '所有照片上传成功！是否将已上传的照片更新到数据库?', insertPhoto, function(){});
      }
    });
  });
  function insertPhoto(){
    $.ajax({
      type : 'post',
      contentType : 'application/json',
      url : path + '/test/insertPhoto',
      processData : false,
      dataType : 'json',
      data : JSON.stringify({}),
      success : function(data) {
        if (data.requestResult.success) {
          myAlert("提示", data.requestResult.successMsg);
        } else {
          myAlert("提示", data.requestResult.errorMsg);
        }
      },
      error : function() {
        myAlert("警告", "请求失败");
      }
    });
  }
</script>
</html>

