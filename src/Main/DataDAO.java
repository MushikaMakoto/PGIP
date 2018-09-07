package Main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public DataDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		//コントローラサーブレットから送られてきたデータを取得
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	//DBに接続開始
	protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

	//DB接続終了用
	protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

	//データ挿入用
	public boolean insertData(Data data) throws SQLException {
        String sql = "INSERT INTO test VALUES (?, ?, ?, ?, ?, ?)";
        connect();


        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, data.getEmpid());
        statement.setString(2, data.getName());
        statement.setString(3, data.getEmail());
        statement.setInt(4, data.getGender());
        statement.setString(5, data.getDept());
        statement.setDate(6, data.getDate());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }



	//DBからデータを取得して、それを一覧表示
	public List<Data> listAllData() throws SQLException {
        List<Data> listData = new ArrayList<>();

        String sql = "SELECT * FROM test";
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");

            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);

        }

        resultSet.close();
        statement.close();

        disconnect();

        return listData;
    }


	public List<Data> empidUp() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY empid ASC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}

	//---------------------以下ソート用--------------------//

	public List<Data> empidDown() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY empid DESC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}

	public List<Data> nameUp() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY name ASC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}

	public List<Data> nameDown() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY name DESC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}

	public List<Data> emailUp() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY email ASC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}

	public List<Data> emailDown() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY email DESC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}

	public List<Data> genderUp() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY gender ASC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}

	public List<Data> genderDown() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY gender DESC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}

	public List<Data> deptUp() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY dept ASC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}

	public List<Data> deptDown() throws SQLException {
        List<Data> listData = new ArrayList<>();
        String sql = "SELECT * FROM test ORDER BY dept DESC";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
        	int empid = resultSet.getInt("empid");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int gender = resultSet.getInt("gender");
            String dept = resultSet.getString("dept");
            Date empdate = resultSet.getDate("empdate");
            Data data = new Data(empid, name, email, gender, dept, empdate);
            listData.add(data);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listData;
	}



	public boolean overlap(int empid) throws SQLException {
		int test = empid;
		String s = Integer.toString(test);
		String sql = String.format("SELECT * FROM test WHERE empid = %s", s);

		connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
        	int empid1 = resultSet.getInt("empid");
        	if(empid1 == empid) {
        		return false;
        	}
        }
        return true;
	}
}

