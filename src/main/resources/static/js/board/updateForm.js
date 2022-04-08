

CKEDITOR.replace('content', { filebrowserUploadUrl: '/mine/imageUpload.do' });

//글수정
document.querySelector("#update_btn").addEventListener("click", function() {



	let content = CKEDITOR.instances.content.getData();


	let xhr = new XMLHttpRequest();
	let formData = new FormData();
	formData.append('boardNo', document.getElementById('boardNo').value);
	formData.append('title', document.getElementById('title').value);
	formData.append('writer', document.getElementById('writer').value);
	formData.append('content', content);

	xhr.open('PUT', '/rest/board/' + formData.get('boardNo'));
	xhr.send(formData);




	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				alert("수정 완료");
				location.href = '/board/' + formData.get('boardNo');
			}
			else if (xhr.responseText == "no") {
				alert("수정 실패");
				location.href = '/board	/' + formData.get('boardNo');
			}
		} else {
			alert("오류 발생");
			location.href = '/board/' + formData.get('boardNo');
		}
	};
});
