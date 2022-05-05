$(document).ready(function(){

	Pageboard(1);
	
	
		
		
		
	
	$(function(){
		var login=$.cookie('logined');
		if(login){
			var suc=login+` 님 환영합니다<input type='button' value='로그아웃' id='logoutBtn' class='btn btn-primary'>`;
			if(login ==="관리자"){
				suc+=` <input type='button' value='회원관리' id='manageBtn' class='btn btn-primary' onclick="window.open('html/memberList.html', '_blank', 'toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=750');">`;
			}
			$("#loginDiv").html(suc);
		}
	});

	
	$("#memberInsertBtn").click(function(){
		const name=$("#name").val();
		const id=$("#id").val();
		const pw=$("#pw").val();
		
		//alert(name+" "+id+" "+pw);
		
		$.post("../memberInsert",{id,pw,name},function(data){
			console.log(data);
			if(data=="") {
				alert("회원가입 성공");
				window.close();
			}
			else alert(data);
		});
		
	});
	
	$("#loginBtn").click(function(){
		const id=$("#id").val();
		const pw=$("#pw").val();
		
		let suc;
		$.post("login",{id,pw},function(data){
			if(data!=""){
				
				suc=data+` 님 환영합니다<input type='button' value='로그아웃' id='logoutBtn' class='btn btn-primary'>`;
				if(data ==="관리자"){
					suc+=` <input type='button' value='회원관리' id='manageBtn' class='btn btn-primary' onclick="window.open('html/memberList.html', '_blank', 'toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=750');">`;
				}
				$.cookie("logined",data);
				$("#loginDiv").html(suc);
			}else{
				alert("아이디 비밀번호를 다시 확인하세요!");
				location.reload();
			}
		});
	});
	
	$(document).on("click", "#logoutBtn", function(event) { //로그아웃 처리
		
		$.post("logout",{},function(data){
				$.removeCookie("logined");	    
				location.reload();		
		}); 
	});
	
	

			
			
	
});

function Pageboard(pageNum){
		$.post("board",{pageNum,pageSize:5},function(data){
			
			let board=`<center><table class="table table-hover"><tr><th>index</th><th>제목</th><th>내용</th></tr>`;
			data.list.forEach(function(item,index){
				board+=`<tr><td>${++index}</td><td>${item.title}</td><td>${item.content}</td></tr>`;
			});
			
			board+=`</table><br>`;
			if(data.hasPreviousPage) board+=`<a href="#Mainboard" onclick="Pageboard(${data.prePage})"> << </a>`;
	        board+=`${data.pageNum}`;
	        if(data.hasNextPage) board+=`<a href="#Mainboard"  onclick="Pageboard(${data.nextPage})"> >> </a>`;
	        board+=`</center>`;
			$("#boardDiv").html(board);
		});
	}
