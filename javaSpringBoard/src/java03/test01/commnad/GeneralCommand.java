package java03.test01.commnad;

import java.util.HashMap;
import java.util.Scanner;

import java03.test01.BoardDao;
import java03.test01.annotation.Command;
import java03.test01.annotation.Component;

@Component
public class GeneralCommand {

	BoardDao boardDao;
	Scanner scanner;
	
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}


	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}


	@Command("help")
	public void doHelp(HashMap<String, Object> params) {
		System.out.println("help");
		System.out.println("write");
		System.out.println("list");
		System.out.println("read index");
		System.out.println("update index");
		System.out.println("exit");

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println();
	 * 
	 * }
	 */
}
