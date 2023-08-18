newWrite	: 'write' AP 
			  (
			  	ID 
				  	{ 
						if(verificaIdBool(_input.LT(-1).getText()))
						{	
							_writeID = _input.LT(-1).getText();
							CommandEscrita cmd = new CommandEscrita(_writeID);
						  	System.out.println("writeln -> _writeID = " + _writeID);
							stack.peek().add(cmd);
						}
					}
			  	| NUMBER
			  	{
			  		_writeID = _input.LT(-1).getText();
					CommandEscrita cmd = new CommandEscrita(_writeID);
				  	System.out.println("writeln -> _writeID = " + _writeID);
					stack.peek().add(cmd);
			  	}
			  	| expr
				{
					System.out.println("write -> exprString = " + _exprString);
					CommandEscrita cmd = new CommandEscrita(_exprString);
					stack.peek().add(cmd);
				}
			  	| outputArgs
			  ) FP SC
			;