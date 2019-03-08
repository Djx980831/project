<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统 by www.eyingda.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="addemp.do" method="get" enctype="multipart/form-data" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >员工基本信息录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="Submit" value="保存" class="button" />　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
				<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>员工信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="15%">员工唯一编号:</td>
					    <td width="35%"><input name='empNo' type="password" class="text" style="width:154px" />
				        <span class="red">*</span></td>
					    <td width="16%" align="right" nowrap="nowrap">密码:</td>
					    <td width="34%"><input type="text" name='passWord' style="width:154px" ></td>
					  </tr>
					    
					    
					  <tr>
					    <td nowrap="nowrap" align="right">真实姓名:</td>
					    <td><input type="text" name='empName' style="width:154px" /></td>
					    <td align="right">性别:</td>
					    <td><select name="sex" >
                            <option selected="selected" value='男'>==请选择==</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select></td>
					  </tr>
					  
					  
					  <tr>
					    <td align="right">出生日期:</td>
					    <td><input type="text" name='birth' style="width:154px" /></td>
					    <td align="right">身份证号码:</td>
					    <td><input type="text" name='idCard' style="width:154px" /></td>
					  </tr>
					  <tr>
					    <td align="right">电子邮箱:</td>
					    <td><input type="text" name='email' style="width:154px" /></td>
					    <td align="right">电话号码:</td>
					    <td><input type="text" name='tel' style="width:154px"/></td>
					  </tr>
					  <tr>
					    <td align="right">居住地址:</td>
					    <td><input name="address" type="text" size="30" />                        </td>
					    <td align="right" name="d">职位:</td>
					    <td><select name="empTypeName" >
                          <option  selected="selected" value="程序员">==请选择==</option>
                          <option value="程序员">程序员</option>
                          <option value="项目经理">项目经理</option>
                          <option value="经理">经理</option>
                        </select></td>
					  </tr>
					  <tr>
					    <td align="right" name="ds">员工类型:</td>
					    <td><select name="empType" >
                            <option  selected="selected" value="实习">==请选择==</option>
                            <option value="实习">实习</option>
                            <option value="试用">试用</option>
                            <option value="正式员工">正式员工</option>
                        </select></td>
					    <td align="right">银行名称:</td>
					    <td><input type="text" name='bankName' style="width:154px" /></td>
					  </tr>
					  <tr>
					    <td align="right">银行账户:</td>
					    <td><input type="text" name='bankNo' style="width:154px"/></td>
					    <td align="right">基本工资:</td>
					    <td><input type="text" name='sal' style="width:154px"/></td>
					  </tr>
					  <tr>
					    <td align="right">奖金:</td>
					    <td><input type="text" name='comm' style="width:154px"/></td>
					    <td align="right">其它补助金:</td>
					    <td><input type="text" name='subsidy' style="width:154px"/></td>
					  </tr>
					  <tr>
					    <td align="right">入职时间:</td>
					    <td><input type="text" name='hireDate' style="width:154px"/></td>
					    <td align="right">&nbsp;</td>
					    <td>&nbsp;</td>
					  </tr>
					 
					  <tr>
					    <td align="right">描述:</td>
					    <td colspan="3"><textarea name="descript" cols="100" rows="8"></textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		</TABLE>
	
	 </td>
  </tr>
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="保存" class="button"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>
