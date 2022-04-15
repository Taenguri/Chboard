/*const jsonList = [];
const numList = [];*/


/*document.addEventListener("DOMContentLoaded", function(){
	document.addEventListener("click", function(evt){
		if(evt.target.classList[0] === "updateBtn") {
			replyUpdateView(evt.target.value);
		} else if(evt.target.classList[0] === "deleteBtn") {
			replyDelete(evt.target.value);
		}
	})
});*/




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
				document.getElementById('replyCon').value = '';
			}
			else if (xhr.responseText == "no") {
				alert("댓글쓰기 실패");
				location.href = '/board/' + document.getElementById('boardNo').value;
			}
		} else {
			alert("오류 발생");
			location.href = '/board/' + document.getElementById('boardNo').value;
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
			console.log(JsonResult)
			for (let i in JsonResult) {

				JsonResult[i].replyContent = JsonResult[i].replyContent.replace(/\n|\r|\s*/g, "");
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
				output += '<button onclick="replyUpdateView(' + JsonResult[i].replyNo + ',\'' + JsonResult[i].replyWriter + '\', \'' + JsonResult[i].replyContent + '\',\'' + repDate + '\' )">수정</button>';
				output += '<button onclick="replyDelete(' + JsonResult[i].replyNo + ')">삭제</button>';
				output += "</div>";

				output += "</div>";
				output += "</div>";
				console.log(JsonResult)
			}

			document.getElementById('listReply').innerHTML = output;


		} else {
			alert("오류 발생");
			location.href = '/board/' + document.getElementById('boardNo').value;
		}
	};

}




//댓글 수정폼
function replyUpdateView(replyNo, replyWriter, replyContent, repDate) {

	console.log('댓글번호 : ' + replyNo);
	console.log(' 작성자 : ' + replyWriter);
	console.log(' 날짜 : ' + repDate);
	console.log(' 내용 : ' + replyContent);


	let output = "";
	output += "<input type='hidden' id='replySelectId' value=" + replyNo + ">";
	output += "<div class='replyContent'>";
	output += "<div class='replyArea'>";
	output += "<div class='replyContentArea'>";
	output += "<div class='replyMain'><span id='repWriter'>" + replyWriter + "</span>";
	output += "<span id='repDate'>" + repDate + "</span>";
	output += "</div>";
	output += "<textarea rows='3' id='changedReplyContent' onkeyup='updateKey();'>" + replyContent;
	output += "</textarea>";
	output += "</div>";
	output += "<div class='replyBtnArea'>";
	output += '<button id = "updateOk" onclick="replyUpdateOk(' + replyNo + ',\'' + replyWriter + '\',\'' + repDate + '\' )">완료</button>';
	output += '<button onclick="Updatecancle()">취소</button>';

	output += "</div>";

	output += "</div>";
	output += "</div>";
	document.getElementById("replyUpdateForm").style.display = "block";
	document.getElementById("listReply").style.display = "none";
	document.getElementById('replyUpdateForm').innerHTML = output;
}


// 댓글 수정
function replyUpdateOk(replyNo, replyWriter, repDate) {


	let xhr = new XMLHttpRequest();
	let formData = new FormData();
	formData.append('replyNo', replyNo);
	formData.append('replyWriter', replyWriter);
	formData.append('replyContent', document.getElementById('changedReplyContent').value);
	formData.append('repDate', repDate);



	xhr.open('PUT', '/rest/reply/' + replyNo);
	xhr.send(formData);



	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				document.getElementById("listReply").style.display = "block";
				document.getElementById("replyUpdateForm").style.display = "none";
				listReply();
			}
			else if (xhr.responseText == "no") {
				alert("수정 실패");
				location.href = '/board/' + document.getElementById('boardNo').value;
			}
		} else {
			alert("오류 발생");
			location.href = '/board/' + document.getElementById('boardNo').value;
		}
	};

}

//댓글 삭제
function replyDelete(replyNo) {

	let xhr = new XMLHttpRequest();

	xhr.open('DELETE', '/rest/reply/' + replyNo);
	xhr.send(replyNo);

	xhr.onload = function() {
		if (xhr.status === 200 || xhr.status === 201) {
			if (xhr.responseText == "ok") {
				alert("삭제 성공");
				listReply();
			}
			else if (xhr.responseText == "no") {
				alert("삭제 실패");
				location.href = '/board/' + document.getElementById('boardNo').value;
			}
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
//댓글 수정 엔터키 이벤트
function updateKey() {
	if (window.event.keyCode == 13) {
		document.getElementById('updateOk').click();
	}
}

//댓글 수정 취소
function Updatecancle() {
	document.getElementById("listReply").style.display = "block";
	document.getElementById("replyUpdateForm").style.display = "none";

}


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
