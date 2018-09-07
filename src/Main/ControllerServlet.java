package Main;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DataDAO dataDAO;

    public void init() {
    	//ドライバーの場所を取得
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        //DBに接続のためのユーザ名を取得
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        //DBに接続のためのパスワード取得
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        dataDAO = new DataDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//POSTを全てGETに送る
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//送られてきたアクションを取得
        String action = request.getServletPath();

        RequestDispatcher dispatcher;
        try {
            switch (action) {

            case "/Display":
            	listData(request, response);
                break;

            case "/Form":
                showNewForm(request, response);
                break;

            case "/Comp":
                show(request, response);
                break;

            case "/EmpidUp":
                empidUp(request, response);
                break;

            case "/EmpidDown":
                empidDown(request, response);
                break;

            case "/nameUp":
                nameUp(request, response);
                break;

            case "/nameDown":
                nameDown(request, response);
                break;

            case "/emailUp":
                emailUp(request, response);
                break;

            case "/emailDown":
                emailDown(request, response);
                break;

            case "/genderUp":
                genderUp(request, response);
                break;

            case "/genderDown":
                genderDown(request, response);
                break;


            case "/deptUp":
                deptUp(request, response);
                break;

            case "/deptDown":
                deptDown(request, response);
                break;


            default:
                dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
                dispatcher.forward(request, response);

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //全てのデータを取得して表示させる
    private void listData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.listAllData();
        request.setAttribute("listData", listData);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    //入力フォームを表示させる
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form.jsp");
        dispatcher.forward(request, response);
    }

    //入力フォームの入力後の完了ページ表示
    private void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/comp.jsp");
        dispatcher.forward(request, response);
    }

    //------------------------------------------------------------------------------//
    //以下全部表示ページのソート用
    //------------------------------------------------------------------------------//
    private void empidUp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.empidUp();
        request.setAttribute("listData", listData);
        request.setAttribute("empidSort", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    private void empidDown(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.empidDown();
        request.setAttribute("listData", listData);
        request.setAttribute("empidSort", false);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    private void nameUp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.nameUp();
        request.setAttribute("listData", listData);
        request.setAttribute("nameSort", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    private void nameDown(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.nameDown();
        request.setAttribute("listData", listData);
        request.setAttribute("nameSort", false);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    private void emailUp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.emailUp();
        request.setAttribute("listData", listData);
        request.setAttribute("emailSort", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    private void emailDown(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.emailDown();
        request.setAttribute("listData", listData);
        request.setAttribute("emailSort", false);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    private void genderUp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.genderUp();
        request.setAttribute("listData", listData);
        request.setAttribute("genderSort", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    private void genderDown(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.genderDown();
        request.setAttribute("listData", listData);
        request.setAttribute("genderSort", false);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    private void deptUp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.deptUp();
        request.setAttribute("listData", listData);
        request.setAttribute("deptSort", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }

    private void deptDown(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Data> listData = dataDAO.deptDown();
        request.setAttribute("listData", listData);
        request.setAttribute("deptSort", false);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/listData.jsp");
        dispatcher.forward(request, response);
    }


}