package br.com.caquiscript.ast;

public class CommandDeclVar extends AbstractCommand{

	private String type;
	private String name;
	
	
	public CommandDeclVar(String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		
		/*
		if(type == 0) {
			
			typeToString = "int";
			return typeToString + " " + name + ";\n";
			
		} else if(type == 1) {
			
			typeToString = "double";
			return typeToString + " " + name + ";\n";
			
		}
		else {
			typeToString = "String";
			return typeToString + " " + name + ";\n";
		}
		*/
		
		return type + " " + name + ";\n";

	}

	@Override
	public String toString() {
		return "CommandDeclVar [type=" + type + ", name=" + name + "]";
	}
	
}
