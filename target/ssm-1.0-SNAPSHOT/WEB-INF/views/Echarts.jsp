<%--
  Created by IntelliJ IDEA.
  User: 96384
  Date: 2018/7/19
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
</head>

<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<div class="col-md-4 col-md-offset-4">
    <button type="button" class="btn btn-primary" id = "backHome">返回首页</button>
</div>

<!-- 引入 echarts.js -->
<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../../static/Echarts/echarts.common.min.js"></script>
<script src="../../static/Echarts/echarts.common.min.js"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    myChart.setOption({
        title:{
            text:'部门分布'
        },
        tooltip : {
            show : true
        },
        legend : {
            data : ['人数']
        },
        xAxis : [ {
            type : 'category',
            data : []
        } ],
        yAxis : [ {
            type : 'value'
        } ],
        series : []
    });
    $.ajax({
        url : "${APP_PATH}/look",
        success : function(result) {
            //将从后台接收的json字符串转换成json对象
            var jsonobj = eval(result)
            var data = jsonobj.extend.look;
            var datalist= [];
            for(var i=0;i<data.length;i++){
                datalist.push(data[i].count)
            }
            var list = []
            for(var i=0;i<data.length;i++){
                list.push(data[i].dept_name)
            }
            myChart.setOption({
                xAxis:{
                    type: 'category',
                    data: list
                },
                series:[
                    {
                        data:datalist,
                        type:'bar'
                    }
                ]
            });
        },
        erroer:function (error) {
            console.log(error)
        }
    });
    $("#backHome").click(function () {
       $.ajax({
           url:"${APP_PATH}",
           success:function () {
               window.location.href="index";
           }

       })
    })
</script>

</body>
</html>