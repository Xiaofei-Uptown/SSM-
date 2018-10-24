<%--
  Created by IntelliJ IDEA.
  User: 96384
  Date: 2018/7/21
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Echartss</title>
</head>

<body>

<div id="main" style="width: 600px;height:400px;"></div>
<div class="col-md-4 col-md-offset-4">
    <button type="button" class="btn btn-primary" id = "backHome">返回首页</button>
</div>


<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../../static/Echarts/echarts.common.min.js"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));

    myChart.setOption({
        title : {
            text: '部门人数',
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data: []
        },
        toolbox: {
            show: true,
            feature: {
                mark: { show: true },
                dataView: { show: true, readOnly: false },
                magicType: {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        series: [{
            name: '部门人员分布',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: []
        }]
    });
    var names = []
    var brower = []
    $.ajax({
        url : "${APP_PATH}/look",
        success:function (result) {
            //遍历json数据
            $.each(result.extend.look, function (index, item) {
                names.push(item.dept_name);    //挨个取出类别并填入类别数组
                brower.push({
                    name: item.dept_name,
                    value: item.count
                });
            });
            console.log(result.extend.look);
            myChart.setOption({        //加载数据图表
                legend: {
                    data: names
                },
                series: [{
                    data: brower
                }]
            });
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
