package br.com.caquiscript.datastructures;

public class CaquiVariable extends CaquiSymbol{
	
	public static final int INT = 0;
	public static final int DOUBLE = 1;
	public static final int STRING = 2;
	
	private int type;
	private String value;
	
	public CaquiVariable(String name, int type, String value) {
		super(name);
		this.setType(type);
		this.setValue(value);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString() {
		return "CaquiVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}
	
	public String generateJavaCode() {
		String str;
		if(type == INT) {
			str = "Integer ";
		}
		else if (type == DOUBLE) {
			str = "Double ";
		}
		else {
			str = "String ";
		}
		
		return str + " " + super.name +";";
	}
	
}
