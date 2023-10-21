<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청하기</title>
	<!-- <script type="text/javascript">
        function apply() {
            var intro_title = document.forms[0].elements["intro_title"].value;
            var intro_content = document.forms[0].elements["intro_content"].value;
            var b_bno = "${param.b_bno}";

            $.ajax({
                type: "POST",
                url: "apply0?b_bno=" + b_bno,
                data: {
                    intro_title: intro_title,
                    intro_content: intro_content
                },
                success: function () {
                	alert('ㅇㅇㅇㅇ');
//                 	console.log("신청이 완료되었습니다.");
                    alert("신청이 완료되었습니다.");
//                     window.close();
                },
                error: function () {
                    alert("오류가 발생했습니다.");
                }
            });
        }
    </script> -->
</head>
<body>
	<h1>신청하기</h1>
	ddd ${sessionScope.id.id} <br>
	ddd ${param.b_bno}
	<form action="" method="post">
		제목: <input type="text" name="intro_title"><br>
		내용:<br> <textarea rows="10" cols="30" name="intro_content"></textarea><hr>
		<input type="hidden" name="v" value="0">
		<input type="submit" value="신청하기" onclick="apply();">
		
		<script type="text/javascript">
			function apply() {
// 				window.close();
// 				setTimeout(function () {
// 			        window.close();
// 			    }, 2000); 
				alert("신청이 완료되었습니다.");
// 				window.close();
			}
		</script>
		
	</form>
	
	
	
</body>

</html>