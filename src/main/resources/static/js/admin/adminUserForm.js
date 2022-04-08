

// 아이디 중복 체크
let idCheck = false;
// 아이디 공백체크
let idNullCheck = false;
// 비밀번호 공백체크
let pwNullCheck = false;
// 이름 공백체크
let nameNullCheck = false;



//회원정보수정
document.querySelector("#adminUserUpdate_btn").addEventListener("click", function() {


	/* 아이디 공백체크 */
	if (document.getElementById('userId').value == "") {
		id_null_ck.style.display = 'block';
		idNullCheck = false;
	} else {
		id_null_ck.style.display = 'none';
		idNullCheck = true;
	}

	/* 비밀번호 공백체크 */
	if (document.getElementById('userPassword').value == "") {
		pw_null_ck.style.display = 'block';
		pwNullCheck = false;
	} else {
		pw_null_ck.style.display = 'none';
		pwNullCheck = true;
	}

	/* 이름 공백체크 */
	if (document.getElementById('userName').value == "") {
		name_null_ck.style.display = 'block';
		nameNullCheck = false;
	} else {
		name_null_ck.style.display = 'none';
		nameNullCheck = true;
	}





	let xhr = new XMLHttpRequest();
	let formData = new FormData();
	formData.append('userNo', document.getElementById("userNo").value);
	formData.append('userId', document.getElementById('userId').value);
	formData.append('userName', document.getElementById('userName').value);
	formData.append('userPassword', document.getElementById('userPassword').value);
	formData.append('verify', document.getElementById("verify").value);


	if (idCheck && idNullCheck && pwNullCheck && nameNullCheck) {
		xhr.open('PUT', '/rest/admin/user/' + formData.get('userNo'));
		xhr.send(formData);
	} else {
		alert("입력값들을 확인해주세요.");
	}



	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				alert("수정 완료");
				location.href = '/admin/user/' + formData.get('userNo');
			}
			else if (xhr.responseText == "no") {
				alert("수정 실패");
				location.href = '/admin/user/' + formData.get('userNo');
			}
		} else {
			alert("오류 발생");
			location.href = '/admin/user/' + formData.get('userNo');
		}
	};



});


// 아이디 중복 체크
document.querySelector("#userId").addEventListener("keyup", function(event) {

	let userId = document.getElementById("userId").value

	let id_ok = document.getElementById('id_ok');
	let id_no = document.getElementById('id_no');

	let xhr = new XMLHttpRequest();


	xhr.open('POST', '/rest/idChk');
	xhr.send(userId);


	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "success") {
				id_ok.style.display = 'block';
				id_no.style.display = 'none';
				id_null_ck.style.display = 'none';
				idCheck = true;
			}
			else if (xhr.responseText == "fail") {
				id_ok.style.cssText = 'display: none';
				id_no.style.cssText = 'display: block';
				id_null_ck.style.display = 'none';
				idCheck = false;
			}
		} else {
			if(event.keyCode==8){				// 백스페이스 오류 방지
			}else{
			alert("오류 발생");
			location.href = '/userList';
			}
		}
	};



});


//회원정보삭제
document.querySelector("#adminUserdelete_btn").addEventListener("click", function() {


	let userNo = document.getElementById("userNo").value

	let xhr = new XMLHttpRequest();


	xhr.open('DELETE', '/rest/admin/user/' + userNo);
	xhr.send(userNo);

	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				alert("삭제 완료");
				location.href = '/userList';
			}
			else if (xhr.responseText == "no") {
				alert("삭제 실패");
				location.href = '/admin/user/' + userNo;
			}
		} else {
			alert("오류 발생");
			location.href = '/admin/user/' + userNo;
		}
	};


});

// 회원수정용 엔터키 이벤트
function enterkey() {
	if (window.event.keyCode == 13) {
		document.getElementById('adminUserUpdate_btn').click();
	}
}


