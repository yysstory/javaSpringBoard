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

	public void load(Board board) throws Exception {
		rs = stmt.executeQuery("SELECT * FROM PRODUCTS");
	      System.out.println("서버에 질의 완료. ResultSet 준비 완료.");
	}

	public void update(Board board) throws Exception {
		stmt.executeUpdate("UPDATE PRODUCTS SET" + " PNAME='넥서스10', QTY=999"
				+ " WHERE PNO=10");
		System.out.println("데이터 변경 완료.");

	}

	public void delete(int index) {
		try {
			stmt.executeUpdate("DELETE FROM PRODUCTS " + "WHERE PNO IN(9,10)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("데이터 삭제 완료.");
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