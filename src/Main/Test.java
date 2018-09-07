package Main;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

//-----------//
//データを挿入するときの挿入できるかをテストする
//入力データに誤りがあった場合は、form.jspに返す。
//返す際に入力されている情報も返す。
//-----------//

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DataDAO dataDAO;

	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        dataDAO = new DataDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			insertData(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


	private void insertData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		//このflagがtrueになる場合は絶対にエラー！
    	Boolean flag = false;

    	//社員番号
    	int empid = 0;
    	String strEmpid = null;

    	request.setAttribute("error_empid", "");
    	strEmpid = request.getParameter("empid");
    	//文字列としてempidを取得して、それが空白の場合
    	if(strEmpid.equals("")) {
    		flag = true;
    		request.setAttribute("error_empid", "入力してください");
    	}else {
	    	strEmpid = new String(strEmpid.getBytes("8859_1"), "UTF-8");
	    	try {
	    		empid = Integer.parseInt(strEmpid);
	    		request.setAttribute("empid", empid);
	    		if(empid < 0) {
	    			flag = true;
	    			request.setAttribute("error_empid", "0以上で入力してください。");
	    		}
	    	}catch(Exception e) {
	    		//数字で入力されている無いので、整数型に変換できなかった時
	    		flag = true;
	    		request.setAttribute("empid", strEmpid);
	    		request.setAttribute("error_empid", "数字で入力してください");
	    	}
	    	finally {
	    	}
	    	if(empid > 99999999 ) {
		    	flag = true;
		    	request.setAttribute("error_empid", "8文字以内で入力してください");
		    }
	    	if(String.valueOf( empid ).length() <= 0 ) {
		    	flag = true;
		    	request.setAttribute("error_empid", "マイナス表示で入力しないでください");
		    }
    	}

    	overlap(empid);



    	//氏名取得
        String name = request.getParameter("name");
        request.setAttribute("error_name", "");
        //空白の場合（入力必須）
        if(name.equals("")) {
        	flag = true;
        	request.setAttribute("name", name);
        	request.setAttribute("error_name", "入力してください");
        }else {
	        name = new String(name.getBytes("8859_1"), "UTF-8");
	        request.setAttribute("name", name);
	        if(name.length() > 32) {
	        	flag = true;
		    	request.setAttribute("error_name", "32文字以内で入力してください");
	        }
        }


        //メールアドレスを取得
        //正規表現で
        request.setAttribute("error_email","");
        String mailFormat = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";
        String email = request.getParameter("email");
        email = new String(email.getBytes("8859_1"), "UTF-8");
        request.setAttribute("email", email);


        String conf_email = request.getParameter("conf_email");
        conf_email = new String(conf_email.getBytes("8859_1"), "UTF-8");
        request.setAttribute("conf_email", conf_email);

        //257文字以上場合
        if(String.valueOf( email ).length() > 256 ) {
	    	flag = true;
	    	request.setAttribute("error_email", "256文字以内で入力してください");
	    }


        //一致確認する
        if(email.equals(conf_email)) {
        	if(!email.equals("")) {
        		//ここで正規表現と一致するか
            	if (!email.matches(mailFormat)) {
                	flag = true;
        	    	request.setAttribute("error_email", "正しいメールアドレスを入力してください");
                }
            }else {
            	email = "";
            }
        }else {
        	flag = true;
        	request.setAttribute("error_email", "確認内容と一致しません");
        }


        //性別取得
        int gender = Integer.parseInt(request.getParameter("gender"));
        String strGender = request.getParameter("gender");
        request.setAttribute("gender", strGender);
        request.setAttribute("error_gender", "正しく選択してください");

        //部署取得
        String dept = request.getParameter("dept");
        dept = new String(dept.getBytes("8859_1"), "UTF-8");
        request.setAttribute("dept", dept);

        //日付を取得//
        //文字列として取得する
        String strTosi = null;
        String strTuki = null;
        String strHiniti = null;
        //一つだけ入力された場合エラー処理用
        boolean flagTosi = false;
        boolean flagTuki = false;
        boolean flagHiniti = false;

        strTosi = request.getParameter("tosi");
        strTosi = new String(strTosi.getBytes("8859_1"), "UTF-8");
        //空白じゃない場合
        if(!(strTosi.equals(""))) flagTosi = true;
        request.setAttribute("tosi", strTosi);
        //int tosi  = Integer.parseInt(strTosi);

        strTuki = request.getParameter("tuki");
        strTuki = new String(strTuki.getBytes("8859_1"), "UTF-8");
      //空白じゃない場合
        if(!(strTuki.equals(""))) flagTuki = true;
        request.setAttribute("tuki", strTuki);
        //int tuki  = Integer.parseInt(strTuki);

        strHiniti = request.getParameter("hiniti");
        strHiniti = new String(strHiniti.getBytes("8859_1"), "UTF-8");
      //空白じゃない場合
        if(!(strHiniti.equals(""))) flagHiniti = true;
        request.setAttribute("hiniti", strHiniti);
        //int hiniti  = Integer.parseInt(strHiniti);

        String empdate = strTosi + "-" + strTuki + "-" + strHiniti;
        Date date = null;
        java.sql.Date d2 = null;


        //どれか一つでもtrue(入力されていたら)
        if(flagTosi || flagTuki || flagHiniti) {
        	//これをdate型に変換
        	try {
        		date = Date.valueOf(empdate);
        		d2 = new java.sql.Date(date.getTime());
        	//失敗した場合
        	}catch(Exception e) {
        		flag = true;
        		request.setAttribute("error_empdate", "正しく入力してください");
        	}
        }



        //上でflagがtrueになった場合エラーなのでform.jspに戻す
        if(flag) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form.jsp");
            dispatcher.forward(request, response);
        }else{
        	try {
	        	Data newData = new Data(empid, name, email, gender, dept, d2);
	        	boolean test = dataDAO.overlap(empid);
	        	System.out.println(test);

	        	if(test) {
	        		dataDAO.insertData(newData);
		        	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/comp.jsp");
		            dispatcher.forward(request, response);
	        	}else {
	        		request.setAttribute("error_empid", "重複しています");
			    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form.jsp");
		            dispatcher.forward(request, response);
	        	}
        	}catch(SQLException e){
		    	request.setAttribute("error_empid", "何かしらのエラーが発生しました。");
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form.jsp");
	            dispatcher.forward(request, response);
        	}finally{
        	}
        }

    }

	private boolean overlap(int empid) {

		return true;

	}

}
