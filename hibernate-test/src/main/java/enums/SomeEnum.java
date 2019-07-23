package enums;

public enum SomeEnum {
	
	ONE("one", 1),
	TWO("two", 2);
	
	private SomeEnum(String inWords, int inNum){
		this.inNum = inNum;
		this.inWords = inWords;
	}
	
	private String inWords;
	private int inNum;
	
	public String getInWords() {
		return inWords;
	}
	public void setInWords(String inWords) {
		this.inWords = inWords;
	}
	public int getInNum() {
		return inNum;
	}
	public void setInNum(int inNum) {
		this.inNum = inNum;
	}

}
