
CKEDITOR.replace('content',{filebrowserUploadUrl:'/mine/imageUpload.do'});

// 글작성
document.querySelector("#write_btn").addEventListener("click", function() {

	let content = CKEDITOR.instances.content.getData();
	
	let xhr = new XMLHttpRequest();
	let formData = new FormData();
	formData.append('title', document.getElementById('title').value);
	formData.append('writer', document.getElementById('writer').value);
	formData.append('content', content);
	


	xhr.open('POST', '/rest/board');
	xhr.send(formData);		
	
	
		
	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				alert("글쓰기 성공");
				location.href = '/list';
			}
			 else if(xhr.responseText == "no"){
					alert("글쓰기 실패");
					location.href = '/boardWrite';
				}
		} else {
			alert("오류 발생");
			location.href = '/boardWrite';
		}
	};
	
	
	
});


