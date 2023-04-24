<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    #map02 > #map {
        width: 400px;
        height: 400px;
        border: 2px solid lightseagreen;
    }
</style>
<script>
    let map02 ={
        map:null,
        init:function (){
            this.display();
            $('#s_btn').click(function (){
                map02.go(37.5657571, 126.9748032);
            });
            $('#p_btn').click(function (){
                map02.go(34.3846216,126.5534925);
            });
            $('#n_btn').click(function (){
                map02.go(33.3846216,126.5534925);
            });
        },
        display:function (){
                var mapContainer = document.querySelector('#map02 > #map');// 지도를 표시할 div
                var mapOption = {
                    center: new kakao.maps.LatLng(37.5449833,127.0562681), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };
                map = new kakao.maps.Map(mapContainer, mapOption);
                var mapTypeControl = new kakao.maps.MapTypeControl();

                // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
                // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
                map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

                // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
                var zoomControl = new kakao.maps.ZoomControl();
                map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
                var markerPosition  = new kakao.maps.LatLng(37.5449833,127.0562681);
                // 마커를 생성합니다
                var marker = new kakao.maps.Marker({
                    position: markerPosition
                });
                // 마커가 지도 위에 표시되도록 설정합니다
                marker.setMap(map);
        },
        go:function(lat,lan){
            var moveLatLon = new kakao.maps.LatLng(lat,lan);
            map.panTo(moveLatLon);
            var markerPosition  = new kakao.maps.LatLng(lat,lan);
            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);
        }
    };
    $(function (){
        map02.init();
    })
</script>
<!-- css -->
<!-- html -->
<div class="col-sm-8 text-left">

    <div class="container" id = "map02">
        <h3 >map02</h3>

            <button id="s_btn" type="button" class="btn btn-info">Seoul</button>
            <button id="p_btn" type="button" class="btn btn-info">somewhere</button>
            <button id="n_btn" type="button" class="btn btn-info">jeju</button>
        <div id="map">
        </div>

</div>
</div>