
CKEDITOR.replace('content', { filebrowserUploadUrl: '/mine/imageUpload.do' });

//글 삭제
document.querySelector("#delete_btn").addEventListener("click", function() {


	let boardNo = document.getElementById("boardNo").value


	let xhr = new XMLHttpRequest();



	xhr.open('DELETE', '/rest/board/' + boardNo);
	xhr.send(boardNo);



	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				alert("삭제 성공");
				location.href = '/list';
			}
			else if (xhr.responseText == "no") {
				alert("삭제 실패");
				location.href = '/board/' + boardNo;
			}
		} else {
			alert("오류 발생");
			location.href = '/board/' + boardNo;
		}
	};



});





