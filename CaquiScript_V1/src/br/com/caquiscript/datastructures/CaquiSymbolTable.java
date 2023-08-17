package br.com.caquiscript.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class CaquiSymbolTable {

	private HashMap<String, CaquiSymbol> map;
	
	public CaquiSymbolTable() {
		map = new HashMap<String, CaquiSymbol>();
		
	}
	
	public void add(CaquiSymbol symbol) {
		map.put(symbol.getName(), symbol);
	}
	
	public boolean exists(String symbolName) {
		return map.get(symbolName) != null;
	}
	
	public CaquiSymbol get(String symbolName) {
		return map.get(symbolName);
	}
	
	public ArrayList<CaquiSymbol> getAll(){
		ArrayList<CaquiSymbol> lista = new ArrayList<CaquiSymbol>();
		for (CaquiSymbol symbol: map.values()) {
			lista.add(symbol);
		}
		return lista;
	}
	
}
