<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여행지 글쓰기</h1>
	
	<fieldset>
		<form action="" method="post">
    국내/외<br>
    <input type="radio" name="t_foreign" value="국내">국내
    <input type="radio" name="t_foreign" value="해외">해외<br>

    나라<br>
    <input type="text" name="t_name" readonly="readonly" value="대한민국"><br>

    <div id="cityInput">
        도시<br>
        <input type="text" name="k_city" placeholder="도시을 입력해주세요."><br>
    </div>

    제목<br>
    <input type="text" name="title" placeholder="제목을 입력해주세요."><br>

    내용<br>
    <textarea rows="10" name="t_content" placeholder="나라명 입력해주세요."></textarea><br>

    평점<br>
    <input type="text" name="t_score" placeholder="평점을 입력해주세요."><br>

    위험도<br>
    <input type="text" name="t_danger" placeholder="위험도을 입력해주세요."><br>

    <hr>

    <input type="submit" value="등록">
    <input type="button" value="목록" onclick="location.href='board2';">
</form>


		
	</fieldset>
	
	<script>
    // 라디오 버튼 변경 이벤트 처리
    var radioButtons = document.querySelectorAll('input[type=radio][name="t_foreign"]');
    var cityInput = document.getElementById('cityInput');
    var tNameInput = document.querySelector('input[name="t_name"]');
    
    for (var i = 0; i < radioButtons.length; i++) {
        radioButtons[i].addEventListener('change', function() {
            if (this.value === '해외') {
                // 라디오 버튼에서 '해외'를 선택했을 때
                cityInput.innerHTML = '도시<br><input type="text" name="t_city" placeholder="도시을 입력해주세요."><br>';
                tNameInput.removeAttribute('readonly');
                tNameInput.value = ''; // 값을 비움
            } else {
                // 라디오 버튼에서 '국내'를 선택했을 때
                cityInput.innerHTML = '도시<br><input type="text" name="k_city" placeholder="도시을 입력해주세요."><br>';
                tNameInput.setAttribute('readonly', 'readonly');
                tNameInput.value = '대한민국'; // 기본값으로 설정
            }
        });
    }
</script>
	
</body>
</html>