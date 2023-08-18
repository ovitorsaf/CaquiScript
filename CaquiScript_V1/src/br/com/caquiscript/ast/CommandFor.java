package br.com.caquiscript.ast;

import java.util.ArrayList;

public class CommandFor extends AbstractCommand{

	private String initialVar;
	private String condition;
	private String increment;
	private ArrayList<AbstractCommand> commands;
	
	public CommandFor(String initialVar, String condition, String increment, ArrayList<AbstractCommand> commands) {
		this.initialVar = initialVar;
		this.condition = condition;
		this.increment = increment;
		this.commands = commands;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		
		str.append("for (" + initialVar + "; " + condition + "; " + increment + "){\n");
		
		for (AbstractCommand cmd: commands) {
			str.append(cmd.generateJavaCode());
		}
		str.append("\n}");
		
		return str.toString();
	}

	@Override
	public String toString() {
		return "CommandFor [initialVar=" + initialVar + ", condition=" + condition + ", increment=" + increment
				+ ", commands=" + commands + "]";
	}

}
