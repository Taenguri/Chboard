//로그인
document.querySelector("#login_btn").addEventListener("click", function() {


	let xhr = new XMLHttpRequest();
	let formData = new FormData();
	formData.append('userId', document.getElementById('userId').value);
	formData.append('userPassword', document.getElementById('userPassword').value);


	xhr.open('POST', '/rest/login');
	xhr.send(formData);



	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "loginOk") {
				alert("로그인 성공");
				location.href = '/';
			} else if (xhr.responseText == "falsePw") {
				alert("비밀번호를 잘못 입력하셨습니다.");
				location.href = '/login';
			} else if (xhr.responseText == "noId") {
				alert("입력하신 아이디는 존재하지 않습니다.");
				location.href = '/login';
			}

		} else {
			alert("오류발생");
			location.href = '/login';
		}
	};


});


// 로그인 엔터키 이벤트
function enterkey() {
	if (window.event.keyCode == 13) {
		document.getElementById('login_btn').click();
	}
}

