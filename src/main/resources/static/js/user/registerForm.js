// 관리자,일반사용자 구분하는 체크박스 함수
function check(box) {
	if (box.checked == true) {
		document.getElementById('verify').value = "관리자";
		console.log(document.getElementById('verify').value);
	} else {
		document.getElementById('verify').value = "일반사용자";
		console.log(document.getElementById('verify').value);
	}
}


// 아이디체크 
let idCheck = false;

// 회원 가입
document.querySelector("#register_btn").addEventListener("click", function() {

	let xhr = new XMLHttpRequest();
	let formData = new FormData();
	formData.append('userId', document.getElementById('userId').value);
	formData.append('userName', document.getElementById('userName').value);
	formData.append('userPassword', document.getElementById('userPassword').value);

	if(document.getElementById('verify').value == '관리자'){
		formData.append('verify','관리자');		
	}else{
		formData.append('verify','일반사용자');		
	}

	// 아이디 중복체크
	if (idCheck) {
		xhr.open('POST', '/rest/user');
		xhr.send(formData); // 폼 데이터 객체 전송
	} else {
		alert("아이디가 중복됐습니다.");
	}



	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				alert("회원가입 성공");
				location.href = '/';
			}
			else if (xhr.responseText == "no") {
				alert("회원가입 실패");
				location.href = '/register';
			}
		} else {
			alert("오류발생");
			location.href = '/register';
		}
	};



});

/*	다른 방식
	let data = {
		userId: document.getElementById("userId").value,
		userPassword: document.getElementById("userPassword").value,
		userName: document.getElementById("userName").value
	};

	let xhr = new XMLHttpRequest();



	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				alert("회원가입 성공");
				location.href = '/';
			}
			else if (xhr.responseText == "no") {
				alert("회원가입 실패");
				location.href = '/register';
			}
		} else {
			alert("오류발생");
			location.href = '/register';
		}
	};
	
		if (idCheck) {
		xhr.open('POST', '/rest/user');
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.send(JSON.stringify(data));
	} else {
		alert("아이디가 중복됐습니다.");
	}
	
	*/





// 아이디 중복 체크
document.querySelector("#userId").addEventListener("keyup", function() {

	let userId = document.getElementById("userId").value

	let id_ok = document.getElementById('id_ok');
	let id_no = document.getElementById('id_no');

	let xhr = new XMLHttpRequest();


	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "success") {
				id_ok.style.display = 'block';
				id_no.style.display = 'none';
				idCheck = true;
			}
			else if (xhr.responseText == "fail") {
				id_ok.style.cssText = 'display: none';
				id_no.style.cssText = 'display: block';
				idCheck = false;
			}
		} else {
			alert("오류 발생");
			location.href = '/register';
		}
	};


	xhr.open('POST', '/rest/idChk');
	xhr.send(userId);


});



//회원가입시 엔터키 이벤트
function enterkey() {
	if (window.event.keyCode == 13) {
		document.getElementById('register_btn').click();
	}
}




