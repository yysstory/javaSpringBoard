package java03.test01;

public class Board {

//제품이름 수량 제조사
	String pname;
	int qty;
	int mkno;
	int pno;
	
	public Board(){
		
	}
	
	public Board(String pname,int qty,int mkno,int pno) {
	
		this.pname=pname;
		this.qty=qty;
		this.mkno=mkno;
		this.pno=pno;
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


	public int getMkno() {
		return mkno;
	}


	public void setMkno(int mkno) {
		this.mkno = mkno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	
	

	
}
