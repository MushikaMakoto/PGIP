<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>PGパートの課題</title>
    <style type="text/css">
	<!--
	.hisu{
		color:red;
	}
	-->
</style>
</head>
<body>
    <center>
        <h2>
            <a href="./" style="padding-left:800px;">トップページへ戻る</a>
        </h2>
    </center>
    <div align="center">
    <p>必要事項を入力の上、送信ボタンを押してください</p>
        <form name="test" action="Test" method="post">
	        <table border="1" cellpadding="5">

	            <tr>
	                <th>社員ID<span class="hisu">[必須]</span> </th>
	                <td>
	                    <input type="text" name="empid" size="45" maxlength="8"
	                            value="<c:out value='${empid}' />"
	                        />
	                	<br /><c:out value='${error_empid}' />
	                </td>
	            </tr>
	            <tr>
	                <th>氏名<span class="hisu">[必須]</span	> </th>
	                <td>
	                    <input type="text" name="name" size="45" maxlength="32"
	                            value="<c:out value='${name}' />"
	                    />
	                    <br /><c:out value='${error_name}' />
	                </td>
	            </tr>
	            <tr>
	                <th>メールアドレス</th>
	                <td>
	                    <input type="text" name="email" size="64" maxlength="128"
	                            value="<c:out value='${email}' />"
	                    /><br />
	                    <input type="text" name="conf_email" size="64" maxlength="128"
	                            value="<c:out value='${conf_email}' />"
	                    />(確認用)<br />
	                    <c:out value='${error_email}' />
	                </td>
	            </tr>
	            <tr>
	                <th>性別</th>
	                <td>
	                <select name = "gender">
	                <c:choose>

                    <c:when test="${gender.equals('1')}">
                    <option value=0>未選択</option>
                    <option value=1 selected>男性</option>
                    <option value=2>女性</option>
                    </c:when>

                    <c:when test="${gender.equals('2')}">
                    <option value=0>未選択</option>
                    <option value=1>男性</option>
                    <option value=2 selected>女性</option>
                    </c:when>

                    <c:otherwise>
                    <option value=0>未選択</option>
                    <option value=1>男性</option>
                    <option value=2>女性</option>
                    </c:otherwise>

                    </c:choose>
                    </select>
                    </td>
		           </td>
	            </tr>
	            <tr>
	                <th>部署</th>
	                <td>
	                    <select name = "dept">

	                    <c:choose>

	                    <c:when test="${dept.equals('開発部')}">
	                    <option value="未選択">未選択</option>
	                    <option value="開発部" selected>開発部</option>
		                <option value="サポート部">サポート部</option>
		                <option value="営業部">営業部</option>
		                <option value="マーケティング部">マーケティング部</option>
		                <option value="人事部">人事部</option>
	                    </c:when>

	                    <c:when test="${dept.equals('サポート部')}">
	                    <option value="未選択">未選択</option>
	                    <option value="開発部">開発部</option>
		                <option value="サポート部" selected>サポート部</option>
		                <option value="営業部">営業部</option>
		                <option value="マーケティング部">マーケティング部</option>
		                <option value="人事部">人事部</option>
	                    </c:when>

	                    <c:when test="${dept.equals('営業部')}">
	                    <option value="未選択">未選択</option>
	                    <option value="開発部">開発部</option>
		                <option value="サポート部">サポート部</option>
		                <option value="営業部" selected>営業部</option>
		                <option value="マーケティング部">マーケティング部</option>
		                <option value="人事部">人事部</option>
	                    </c:when>

	                    <c:when test="${dept.equals('マーケティング部')}">
	                    <option value="未選択">未選択</option>
	                    <option value="開発部">開発部</option>
		                <option value="サポート部">サポート部</option>
		                <option value="営業部">営業部</option>
		                <option value="マーケティング部" selected>マーケティング部</option>
		                <option value="人事部">人事部</option>
	                    </c:when>

	                    <c:when test="${dept.equals('人事部')}">
	                    <option value="未選択">未選択</option>
	                    <option value="開発部">開発部</option>
		                <option value="サポート部">サポート部</option>
		                <option value="営業部">営業部</option>
		                <option value="マーケティング部">マーケティング部</option>
		                <option value="人事部" selected>人事部</option>
	                    </c:when>

	                    <c:otherwise>
	                    <option value="未選択">未選択</option>
	                    <option value="開発部">開発部</option>
		                <option value="サポート部">サポート部</option>
		                <option value="営業部">営業部</option>
		                <option value="マーケティング部">マーケティング部</option>
		                <option value="人事部">人事部</option>
                    	</c:otherwise>

	                    </c:choose>
                		</select>
	                </td>
	            </tr>
	            <tr>
	                <th>入社年月日</th>
	                <td>
	                    <input type="text" name="tosi" size="2" maxlength = "4" value="<c:out value='${tosi}' />">年
	                    <input type="text" name="tuki" size="1" maxlength = "2" value="<c:out value='${tuki}' />">月
	                    <input type="text" name="hiniti" size="1" maxlength = "2" value="<c:out value='${hiniti}' />">日
	                    <br />
	                    <c:out value='${error_empdate}' />
	                </td>
	            </tr>
	            <tr>
	                <td colspan="2" align="center">
	                    <input type="submit" value="送信" />
	                    <input type="reset" value="リセット"/>
	                </td>
	            </tr>
	        </table>
        </form>
    </div>
</body>
</html>