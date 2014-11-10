package java03.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BoardDao {

/*	public static void main(String[] args) {
		BoardDao boardDao = new BoardDao();
		
	}*/
	
	
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt = null;
	ResultSet rs = null;
	Board board;

	public BoardDao() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC 드라이버 로딩됨");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb"
							+ "?useUnicode=true&characterEncoding=utf8",
					"study", "study");
			// System.out.println("DBMS에 연결됨");
			
			// System.out.println("Statement 객체 준비 완료.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void save(Board board) throws Exception {
		
		pstmt= con.prepareStatement("INSERT INTO PRODUCTS(PNAME,QTY,MKNO) VALUES(?,?,?)");
		pstmt.setString(1, board.pname);
		pstmt.setInt(2, board.qty);
		pstmt.setInt(3, board.mkno);
		pstmt.executeUpdate();
	}

	public void load() throws Exception {
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM PRODUCTS");
		while (rs.next()) {
	        System.out.print(rs.getInt("PNO") + ",");
	        System.out.print(rs.getString("PNAME") + ",");
	        System.out.print(rs.getInt("QTY") + ",");
	        System.out.println(rs.getInt("MKNO"));
		}
	}

	public void update(Board board) throws Exception {

		
		pstmt= con.prepareStatement("UPDATE PRODUCTS SET PNAME=?, QTY=?  WHERE PNO=?");

	}

	public void delete(int index) {
		try {
			
			pstmt = con.prepareStatement("DELETE FROM PRODUCTS WHERE PNO = ?");
			pstmt.setInt(1,index);
			pstmt.executeUpdate();
			System.out.println(index+"번 삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void DBend() {

		try {
			stmt.close();
		} catch (Exception ex) {
		}
		System.out.println("Statement 객체의 자원을 해제함.");

		try {
			con.close();
		} catch (Exception ex) {
		}
		System.out.println("DBMS와 연결 끊음");

	}
}