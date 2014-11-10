package java03.test01.commnad;

import java.util.HashMap;
import java.util.Scanner;

import java03.test01.Board;
import java03.test01.BoardDao;
import java03.test01.annotation.Command;
import java03.test01.annotation.Component;


@Component
public class BoardCommand {

	BoardDao boardDao;
	Scanner scanner;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	@Command("list")
	public void doList(){
		System.out.println("list 메소드 호출");		
		
	}

	
	@Command("add")
	public void doADD(HashMap<String, Object> params){
		Board board= new Board();
		
		
		System.out.println("제품명 : ");
		board.setPname(scanner.nextLine());
		System.out.println("수량 : ");
		board.setQty(Integer.parseInt(scanner.nextLine()));
		System.out.println("제조사 : ");
		board.setMkno(Integer.parseInt(scanner.nextLine()));
		
		try {
			boardDao.save(board);

			System.out.println("저장완료");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	@Command("update")
	public void doUpdate(){
		System.out.println("update 메소드 호출");		
		
	}

	
	@Command("delete")
	public void doDelete(){
		System.out.println("delete 메소드 호출");		
		
	}

	
	
	
	
	
}
