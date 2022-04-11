
// 댓글 작성
document.querySelector("#replyWriteBtn").addEventListener("click", function() {
	
	console.log(document.getElementById('boardNo').value);
	console.log(document.getElementById('replyCon').value);
	console.log(document.getElementById('replyWriter').value);
	
	
	let xhr = new XMLHttpRequest();
	let formData = new FormData();
	formData.append('boardNo', document.getElementById('boardNo').value);
	formData.append('replyContent', document.getElementById('replyCon').value);
	formData.append('replyWriter', document.getElementById('replyWriter').value);
	


	xhr.open('POST', '/rest/replyWrite');
	xhr.send(formData);		
	
	
		
	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				alert("댓글쓰기 성공");
				location.href = '/list';
			}
			 else if(xhr.responseText == "no"){
					alert("댓글쓰기 실패");
					location.href = '/boardWrite';
				}
		} else {
			alert("오류 발생");
			location.href = '/boardWrite';
		}
	};
	
	
	
});


