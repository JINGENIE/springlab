<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>

</style>
<script>
    let chart03= {
        init:function (){
            this.getdata1();
            this.getdata2();
            this.getdata3();
        },
        getdata1:function (){
            $.ajax({
                url:'/chart0301',
                success:function (result){
                    chart03.display1(result);
                }
            });
        },
        getdata2:function (){
            $.ajax({
                url:'/chart0302',
                success:function (result){
                    chart03.display2(result);
                }
            });
        },
        getdata3:function (){
            $.ajax({
                url:'/chart0303',
                success:function (result){
                    chart03.display3(result);
                }
            });
        },
        display1:function (result){
            Highcharts.chart('c1', {
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 45
                    }
                },
                title: {
                    text: 'Beijing 2022 gold medals by country',
                    align: 'left'
                },
                subtitle: {
                    text: '3D donut in Highcharts',
                    align: 'left'
                },
                plotOptions: {
                    pie: {
                        innerSize: 100,
                        depth: 45
                    }
                },
                series: [{
                    name: 'Medals',
                    data: result
                }]
            });

        },
        display2:function (result){
            Highcharts.chart('c2', {
                chart: {
                    type: 'pyramid3d',
                    options3d: {
                        enabled: true,
                        alpha: 10,
                        depth: 50,
                        viewDistance: 50
                    }
                },
                title: {
                    text: 'Highcharts Pyramid3D Chart'
                },
                plotOptions: {
                    series: {
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b> ({point.y:,.0f})',
                            allowOverlap: true,
                            x: 10,
                            y: -5
                        },
                        width: '60%',
                        height: '80%',
                        center: ['50%', '45%']
                    }
                },
                series: [{
                    name: 'Unique users',
                    data: result
                }]
            });
        },
        display3:function (result){
            Highcharts.chart('c3', {

                chart: {
                    type: 'gauge',
                    plotBackgroundColor: null,
                    plotBackgroundImage: null,
                    plotBorderWidth: 0,
                    plotShadow: false,
                    height: '80%'
                },

                title: {
                    text: 'Speedometer'
                },

                pane: {
                    startAngle: -90,
                    endAngle: 89.9,
                    background: null,
                    center: ['50%', '75%'],
                    size: '110%'
                },

                // the value axis
                yAxis: {
                    min: 0,
                    max: 200,
                    tickPixelInterval: 72,
                    tickPosition: 'inside',
                    tickColor: Highcharts.defaultOptions.chart.backgroundColor || '#FFFFFF',
                    tickLength: 20,
                    tickWidth: 2,
                    minorTickInterval: null,
                    labels: {
                        distance: 20,
                        style: {
                            fontSize: '14px'
                        }
                    },
                    plotBands: [{
                        from: 0,
                        to: 120,
                        color: '#55BF3B', // green
                        thickness: 20
                    }, {
                        from: 120,
                        to: 160,
                        color: '#DDDF0D', // yellow
                        thickness: 20
                    }, {
                        from: 160,
                        to: 200,
                        color: '#DF5353', // red
                        thickness: 20
                    }]
                },

                series: [{
                    name: 'Speed',
                    data: result,
                    tooltip: {
                        valueSuffix: ' km/h'
                    },
                    dataLabels: {
                        format: '{y} km/h',
                        borderWidth: 0,
                        color: (
                            Highcharts.defaultOptions.title &&
                            Highcharts.defaultOptions.title.style &&
                            Highcharts.defaultOptions.title.style.color
                        ) || '#333333',
                        style: {
                            fontSize: '16px'
                        }
                    },
                    dial: {
                        radius: '80%',
                        backgroundColor: 'gray',
                        baseWidth: 12,
                        baseLength: '0%',
                        rearLength: '0%'
                    },
                    pivot: {
                        backgroundColor: 'gray',
                        radius: 6
                    }

                }]

            });

// Add some life
            setInterval(() => {
                const chart = Highcharts.charts[0];
                if (chart && !chart.renderer.forExport) {
                    const point = chart.series[0].points[0],
                        inc = Math.round((Math.random() - 0.5) * 20);

                    let newVal = point.y + inc;
                    if (newVal < 0 || newVal > 200) {
                        newVal = point.y - inc;
                    }

                    point.update(newVal);
                }

            }, 3000);
        }
    };
    $(function (){
        chart03.init();
    })
</script>
<!-- css -->
<!-- html -->
<div class="col-sm-8 text-left">
    <div class="container">
        <h3 >chart03</h3>
        <div class="row">
            <div class="col-sm-4" id="c1">

            </div>
            <div class="col-sm-4" id="c2">

            </div>
            <div class="col-sm-4" id="c3">

            </div>
        </div>

</div>
</div>