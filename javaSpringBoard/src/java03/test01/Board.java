package java03.test01;

public class Board {

//제품이름 수량 제조사
	String pname;
	int qty;
	int mkname;
	
	public Board(){
		
	}
	
	public Board(String pname,int qty,int mkname) {
	
		this.pname=pname;
		this.qty=qty;
		this.mkname=mkname;
		
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getMkname() {
		return mkname;
	}


	public void setMkname(int mkname) {
		this.mkname = mkname;
	}

	
	

	
}
