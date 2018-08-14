<%@page import="com.kl.bmi.pojo.Record"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Record> records = (List<Record>) request.getSession().getAttribute("records");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>BMI</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bmi.css" />
</head>
	<body>      
		<div class="box">
			<div class="bmi_count">
				<table class="table_count">
					<form action="" method="post" id="form">
					<tr>
						<th>BMI计算</th>
					</tr>
					
					<tr>
						<td class="title">身高：</td>
						<td>
						    <div class="input_box">
							    <input type="number" name="height" class="input height" id="height"/>
							    <p class="input_unit">厘米</p>
						    </div>
						</td>
					</tr>
					
					<tr>
						<td class="title">体重：</td>
						<td>
						    <div class="input_box">
							    <input type="number" name="weight" class="input weight" id="weight"/>
							    <p class="input_unit">千克</p>
						    </div>
						</td>
					</tr>
					
					<tr>
						<td class="title">性别：</td>
						    <td>
						    <div class="input_sex">
							    <input type="radio" name="sex" id="sex" value="0" checked="checked"/>男
							    <input type="radio" name="sex" id="sex" value="1" class="nv"/>女
						    </div>
						    </td>
					</tr>

					<tr>
						<td colspan="2">
							<input type="button" class="submit" id="submit" value="计算BMI" />
						</td>
					</tr>
				</table>
					<table class="table_norm">
						<tr>
							<td>分类</td>
							<td>BMI范围</td>
						</tr>
						<tr>
							<td>偏瘦</td>
							<td><=18.4</td>
						</tr>
						<tr>
							<td>正常</td>
							<td>18.5~23.9</td>
						</tr>
						<tr>
							<td>过重</td>
							<td>24.0~27.9</td>
						</tr>
						<tr>
							<td>肥胖</td>
							<td>>=28.0</td>
						</tr>
						</form>
					</table>
			</div>	
		<div class="bmi_result">
			<img src="${pageContext.request.contextPath}/img/3_02.jpg" class="photo" id="photo" />
			<p class="result" id="result">BMI 正常</p>
			<p class="dream" id="dream">理想值</p>
		</div>
			<div class="bmi_history">
			<table class="table_history">
				<tr class="history_title">
					<td>ID</td>
					<td>日期</td>
					<td>身高</td>
					<td>体重</td>
					<td>性别</td>
					<td>BMI</td>
					<td>理想体重</td>
					<td>操作</td>
				</tr>
				<%
				if(records!=null){
					for(Record record:records){
				 %>
				<tr class="history_result">
					<td><%=record.getId() %></td>
					<td><%=record.getTime() %></td>
					<td><%=record.getHeight() %></td>
					<td><%=record.getWeight() %></td>
					<td><%=record.getSex() %></td>
					<td><%=record.getBmi() %></td>
					<td><%=record.getDream_value() %></td>
					<td><input type="button" class="button" name="button"
						id="button" value="删除" /></td>
				</tr>
				<%
				     }
				} 
				%>
			</table>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	window.onload = function(){	
		if("${index}" == ""){
		window.location.href = "${pageContext.request.contextPath}/servlet/FindAllServlet";	
	    }
	}
	
	$(".button").click(function(){
		var rId = $(this).parents("tr").find("td").eq(0).html();
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/servlet/DeleteByIdServlet?rId="+rId,
			dataType:'json',
			async:true,
			success:function(data){
				alert(data.msg);
				window.location.reload();
			}
		});
	})
	
	  var photo = document.getElementById("photo");
      var result = document.getElementById("result");
      var dream = document.getElementById("dream");
      
      function fun(sex,bmi,dream_value,photo,result,dream){
      	if(sex == "0"){
      		if (bmi<=18.4) {
      			alert("亲，太瘦了哦！多吃点！！！");
      			result.innerHTML=bmi + "偏瘦";
      			dream.innerHTML= "理想体重" + dream_value;
      			photo.src = "${pageContext.request.contextPath}/img/3_01.jpg";	
      		}
            if (bmi>18.5 && bmi<=23.9) {
      			alert("身材不错哦！继续保持！");
      			result.innerHTML=bmi + "正常";
      			dream.innerHTML= "理想体重" + dream_value;
      			photo.src = "${pageContext.request.contextPath}/img/3_02.jpg";	
      		}
      		if (bmi>24.0 && bmi<=27.9) {
      			alert("亲，有点胖咯！");
      			result.innerHTML=bmi + "过重";
      			dream.innerHTML= "理想体重" + dream_value;
      			photo.src = "${pageContext.request.contextPath}/img/3_03.jpg";	
      		}
      		if (bmi>=28.0) {
      			alert("请注意减肥哦！");
      			result.innerHTML=bmi + "肥胖";
      			dream.innerHTML= "理想体重" + dream_value;
      			photo.src = "${pageContext.request.contextPath}/img/3_04.jpg";	
      		}
      	}else{
      		if (bmi<=18.4) {
      			alert("亲，太瘦了哦！多吃点！！！");
      			result.innerHTML=bmi + "偏瘦";
      			dream.innerHTML= "理想体重" + dream_value;
      			photo.src = "${pageContext.request.contextPath}/img/3_01_01.jpg";	
      		}
            if (bmi>18.5 && bmi<=23.9) {
      			alert("身材不错哦！继续保持！");
      			result.innerHTML=bmi + "正常";
      			dream.innerHTML= "理想体重" + dream_value;
      			photo.src = "${pageContext.request.contextPath}/img/3_01_03.jpg";	
      		}
      		if (bmi>24.0 && bmi<=27.9) {
      			alert("亲，有点胖咯！");
      			result.innerHTML=bmi + "过重";
      			dream.innerHTML= "理想体重" + dream_value;
      			photo.src = "${pageContext.request.contextPath}/img/3_01_04.jpg";	
      		}
      		if (bmi>=28.0) {
      			alert("请注意减肥哦！");
      			result.innerHTML=bmi + "肥胖";
      			dream.innerHTML= "理想体重" + dream_value;
      			photo.src = "${pageContext.request.contextPath}/img/3_01_05.jpg";	
      		}
      	} 
      	
      }
      
	$("#submit").click(function(){
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/servlet/CalcServlet",
		data:$("#form").serialize(),
		dataType:'json',
		async:true,
		success:function(data){
				alert(data.sex);
				alert(data.bmi);
				alert(data.dream_value);
				var sex = data.sex;
				var bmi = data.bmi;
				var dream_value = data.dream_value;
				fun(sex,bmi,dream_value,photo,result,dream);
			}
		});
	})
	
	
	
	</script>
</html>






