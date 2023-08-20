package br.com.caquiscript.ast;

import br.com.caquiscript.datastructures.CaquiVariable;

public class CommandLeitura extends AbstractCommand{
	
	private String id;
	private CaquiVariable var;
	
	public CommandLeitura(String id, CaquiVariable var) {
		this.id = id;
		this.var = var;
	}
	
	@Override
	public String generateJavaCode() {
		if (var.getType()==CaquiVariable.INT) {
			return id + " = _key.nextInt();";
		}
		else if (var.getType()==CaquiVariable.DOUBLE) {
			return id + " = _key.nextDouble();";
		}
		return id + " = _key.nextLine();";
	}

	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}
}
