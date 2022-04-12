
// 댓글 리스트 호출
listReply();




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
				listReply();
			}
			else if (xhr.responseText == "no") {
				alert("댓글쓰기 실패");
				location.href = '/boardWrite';
			}
		} else {
			alert("오류 발생");
			location.href = '/boardWrite';
		}
	};


});


// 댓글 리스트 함수
function listReply() {


	let xhr = new XMLHttpRequest();

	xhr.open('GET', '/replyList/' + document.getElementById('boardNo').value);
	xhr.send();

	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			let result = xhr.responseText
			let JsonResult = JSON.parse(result);



			let output = "";
			for (let i in JsonResult) {

				let repDate = new Date(JsonResult[i].replyRegdate);
				repDate = repDate.toLocaleDateString("ko-US")
				output += "<input type='hidden' id='replySelectId' value=" + JsonResult[i].replyNo + ">";
				output += "<div class='replyContent'>";
				output += "<div class='replyArea'>";
				output += "<div class='replyContentArea'>";
				output += "<div class='replyMain'><span id='repWriter'>" + JsonResult[i].replyWriter + "</span>";
				output += "<span id='repDate'>" + repDate + "</span>";
				output += "</div>";
				output += "<div class='replySub'>" + JsonResult[i].replyContent;
				output += "</div>";
				output += "</div>";

				output += "<div class='replyBtnArea'>";
				output += "<button id='replyUpdate'>수정</button>";
				output += "<button id='replyDelete'>삭제</button>";
				output += "</div>";

				output += "</div>";
				output += "</div>";
			}

			document.getElementById('listReply').innerHTML = output;


		} else {
			alert("오류 발생");
			location.href = '/board/' + document.getElementById('boardNo').value;
		}
	};

}

//댓글등록 엔터키 이벤트
function enterkey() {
	if (window.event.keyCode == 13) {
		document.getElementById('replyWriteBtn').click();
		document.getElementById('replyCon').value = '';
	}
}




//댓글 삭제
document.querySelector("#replyDelete").addEventListener("click", function() {


	let replyNo = document.getElementById("replySelectId").value;
	console.log(replyNo);

	/*let xhr = new XMLHttpRequest();



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
	};*/



});
/*function listReply() {
	commonAjax("GET", "replyList", document.getElementById('boardNo').value);
}


function commonAjax(method, url, dataObject) {
	let xhr = new XMLHttpRequest();

	xhr.open(method, '/'+url+'/' + dataObject);
	xhr.send();

	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			let result = xhr.responseText
			return JSON.parse(result);
		} else {
			alert("오류 발생");
			location.href = '/list';
		}
	};

}*/
