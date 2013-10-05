<%@ page language="java" import="java.util.*,java.net.URL" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Flyaway数据分析</title>

		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript">
		$(function () {
	        $('#container').highcharts({
	            chart: {
	                zoomType: 'xy'
	            },
	            title: {
	                text: '子行业大盘走势'
	            },
	            subtitle: {
	                text: 'Flyaway data'
	            },
	            xAxis: [{
	                categories: ${dates}
	            }],
	            yAxis: [{ // Primary yAxis
	                labels: {
	                    format: '{value}',
	                    style: {
	                        color: '#89A54E'
	                    }
	                },
	                title: {
	                    text: '分配量（单位:笔数）',
	                    style: {
	                        color: '#89A54E'
	                    }
	                }
	            }, { // Secondary yAxis
	                title: {
	                    text: '销售量（单位:笔数）',
	                    style: {
	                        color: '#4572A7'
	                    }
	                },
	                labels: {
	                    format: '{value}',
	                    style: {
	                        color: '#4572A7'
	                    }
	                },
	                opposite: true
	            }],
	            tooltip: {
	                shared: true
	            },
	            legend: {
	                layout: 'vertical',
	                align: 'left',
	                x: 120,
	                verticalAlign: 'top',
	                y: 100,
	                floating: true,
	                backgroundColor: '#FFFFFF'
	            },
	            series: [{
	                name: '销售量',
	                color: '#4572A7',
	                type: 'column',
	                yAxis: 1,
	                data: ${sales},
	                tooltip: {
	                    valueSuffix: ' 笔数'
	                }
	    
	            }, {
	                name: '分配量',
	                color: '#89A54E',
	                type: 'spline',
	                data: ${assigns},
	                tooltip: {
	                    valueSuffix: ' 笔数'
	                }
	            }]
	        });
	    });
    

		</script>
	</head>
	<body>
<script src="../../resources/js/highcharts.js"></script>
<script src="../../resources/js/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	</body>
</html>
