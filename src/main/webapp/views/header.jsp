<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--JSTL : 통화 날짜를 표현하게 해주는 문법--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


    <script>
        $(document).ready(function() {
            // AJAX를 통해 서버로 데이터 요청
            $.ajax({
                url: "/cart-items", // 데이터 요청을 처리하는 URL
                type: "get",
                dataType: "html",
                success: function(response) {
                    $("#cartItems").html(response); // 응답 받은 HTML을 해당 영역에 삽입
                },
                error: function(xhr, status, error) {
                    console.log("Error:", error);
                }
            });
        });

        function enterkey() {
            if (window.event.keyCode == 13) {

                // 엔터키가 눌렸을 때 실행하는 반응
                $("#search-form").submit();
            }
        }
    </script>

<!-- Start Top Header Bar -->
<section class="top-header">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-xs-12 col-sm-4">
                <div class="contact-number">
                    <i class="tf-ion-ios-telephone"></i>
                    <span>02-0201-0707</span>
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-4">
                <!-- Site Logo -->
                <div class="logo text-center">
                    <a href="/">
                        <!-- replace logo here -->
                        <svg width="135px" height="29px" viewBox="0 0 155 29" version="1.1" xmlns="http://www.w3.org/2000/svg"
                             xmlns:xlink="http://www.w3.org/1999/xlink">
                            <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" font-size="40"
                               font-family="AustinBold, Austin" font-weight="bold">
                                <g id="Group" transform="translate(-108.000000, -297.000000)" fill="#000000">
                                    <text id="AVIATO">
                                        <tspan x="108.94" y="325">AESPA</tspan>
                                    </text>
                                </g>
                            </g>
                        </svg>
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-4">
                <!-- Cart -->
                <ul class="top-menu text-right list-inline">
                    <li class="dropdown cart-nav dropdown-slide">
                        <!-- 카트 선택 시 로그인한 고객이라면, 본인의 카트 정보조회 dropdown -->
                        <%--                        <c:if test="${loginuser != null }">--%>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
                                class="tf-ion-android-cart"></i> Cart</a>
                        <div class="dropdown-menu cart-dropdown">
                            <div id="cartItems">
                            <c:forEach var="cartItem" items="${allcartlist}">
                                <!-- 각 카트 아이템을 드롭다운 메뉴에 표시하는 코드 -->
                                <div class="media">
                                    <a class="pull-left" href="#!">
                                        <img class="media-object" src="/img/${cartItem.product_imgname}" alt="image" />
                                    </a>
                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="#!">${cartItem.product_name}</a></h4>
                                        <div class="cart-price">
                                            <span>${cartItem.cart_quantity}</span>
                                            <span>${cartItem.product_price}</span>
                                        </div>
                                        <h5><strong>${cartItem.product_price}</strong></h5>
                                        <p>Product ID: ${cartItem.product_id}</p>
                                    </div>
                                </div>
                                <a href="#!" class="remove"><i class="tf-ion-close"></i></a>
                            </c:forEach>
                            <!-- 나머지 드롭다운 메뉴 요소들 -->
                            <div class="cart-summary">
                                <span>Total</span>
                                <span class="total-price">$1799.00</span>
                            </div>
                            <ul class="text-center cart-buttons">
                                <li><a href="/cart?user_id=${loginuser.user_id}" class="btn btn-small">자세히 보기</a></li>
                                <li><a href="#order" class="btn btn-small btn-solid-border">주문하기</a></li>
                            </ul>
                        </div>

                        </div>
                    </li><!-- / Cart -->
                    <!-- Mypage -->
                    <c:choose>
                        <c:when test="${loginuser == null}">
                            <li class="dropdown dropdown-slide">
                                <!-- 미로그인 고객 : 로그인하기 화면 보여주기 | 로그인 고객 : 내정보 수정 & 로그아웃 화면 보여주기 -->
                                <a href="/login" class="" data-toggle="" data-hover="dropdown" data-delay="350"
                                   role="button" aria-haspopup="true" aria-expanded="false"><span class="tf-ion-android-person"></span> Login</a><!-- Main Controller -->
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="dropdown dropdown-slide">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350"
                                   role="button" aria-haspopup="true" aria-expanded="false"><span class="tf-ion-android-person"></span> ${loginuser.user_id} <span
                                        class="tf-ion-ios-arrow-down"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/profile"> 내정보 수정</a></li>
                                    <li><a href="/logout"> Logout</a></li><!-- Main Controller -->
                                </ul>
                            </li>
                        </c:otherwise>
                    </c:choose><!-- / Mypage -->

                    <!-- Search -->
                    <li class="dropdown search dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
                                class="tf-ion-ios-search-strong"></i> Search</a>
                        <ul class="dropdown-menu search-dropdown">
                            <li>
                                <form id="search-form" action="/search">
                                    <input onkeyup="enterkey();" type="search" class="form-control" name="product_name" placeholder="검색하세요...">
                                </form>
                            </li>
                        </ul>
                    </li><!-- / Search -->


                </ul><!-- / .nav .navbar-nav .navbar-right -->
            </div>
        </div>
    </div>
</section><!-- End Top Header Bar -->

