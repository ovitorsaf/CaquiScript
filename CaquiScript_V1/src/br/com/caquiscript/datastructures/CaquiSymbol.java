package br.com.caquiscript.datastructures;

public abstract class CaquiSymbol {
	
	protected String name;

	public abstract String generateJavaCode();
	
	public CaquiSymbol(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return "CaquiSymbol [name=" + name + "]";
	}
	
}
