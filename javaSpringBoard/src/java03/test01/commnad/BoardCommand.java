package java03.test01.commnad;

import java.util.Scanner;
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
	public void doADD(){
		System.out.println("add 메소드 호출");		
		
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
