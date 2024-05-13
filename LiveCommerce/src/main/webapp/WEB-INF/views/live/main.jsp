<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>라이브 커머스</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        nav ul li {
            display: inline;
            margin-right: 20px;
        }
        nav ul li a {
            color: #fff;
            text-decoration: none;
        }
        main {
            padding: 20px;
        }
        .hero {
            background-color: #f4f4f4;
            padding: 50px;
            text-align: center;
        }
        .hero h2 {
            font-size: 36px;
            margin-bottom: 20px;
        }
        .hero p {
            font-size: 18px;
            margin-bottom: 20px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #333;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #555;
        }
        footer {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <header>
        <h1>라이브 커머스</h1>
        <nav>
            <ul>
                <%-- 사용자 로그인 상태에 따라 다른 메뉴 표시 --%>
                <% if (request.isUserInRole("ROLE_USER")) { %>
                    <li><a href="/live/profile">내 프로필</a></li>
                    <li><a href="/cart">장바구니</a></li>
                    <form action="/customLogout" method="post">
                        <button type="submit">로그아웃</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
                <% } else if (request.isUserInRole("ROLE_ADMIN")) { %>
                    <li><a href="/admin/dashboard">관리자 대시보드</a></li>
                    <form action="/user/logout" method="post">
                        <button type="submit">로그아웃</button>
                    </form>
                <% } else { %>
                    <li><a href="/customLogin">로그인</a></li>
                    <li><a href="/user/register">회원가입</a></li>
                <% } %>
            </ul>
        </nav>
    </header>
    
    <main>
        <!-- YouTube 임베드 플레이어를 포함할 div 요소 -->
        <div id="player"></div>

        <!-- YouTube API 로드 스크립트 -->
        <script>
            // YouTube 비디오 ID 설정
            var videoId = "C4DuYovuPhM";

            // YouTube 임베드 API를 비동기적으로 로드
            var tag = document.createElement('script');
            tag.src = 'https://www.youtube.com/iframe_api';
            var firstScriptTag = document.getElementsByTagName('script')[0];
            firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

            // YouTube 플레이어 생성 함수
            var player;
            function onYouTubeIframeAPIReady() {
                player = new YT.Player('player', {
                    height: '360',
                    width: '640',
                    videoId: videoId,
                    events: {
                        'onReady': onPlayerReady
                    }
                });
            }

         // 플레이어가 준비되었을 때 실행되는 함수
            function onPlayerReady(event) {
                event.target.playVideo(); // 플레이어 자동 재생

                // 라이브 영상 클릭 이벤트 핸들링
                var liveVideo = document.getElementById('player'); // YouTube 비디오 플레이어 요소 가져오기
                liveVideo.addEventListener('click', function() {
                    window.location.href = '/live/main'; // 원하는 리다이렉션 URL로 이동
                });
            }
        </script>

        <section class="hero">
            <h2>Welcome to Live Commerce!</h2>
            <p>Discover amazing products and shop with ease.</p>
            <a href="/products" class="btn">Shop Now</a>
        </section>
    </main>
    
    <footer>
        <p>&copy; 2024 Live Commerce. All rights reserved.</p>
    </footer>
</body>
</html>