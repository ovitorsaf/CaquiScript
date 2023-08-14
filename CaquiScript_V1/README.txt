CaquiScript_V1:

- O arquivo CaquiScript.g4:
	Contém todas as regras da nossa linguagem, ele deve estar de acordo com o que o professor pediu;
	Criado inicialmente com as regras que foram escritas durante o vídeo da aula 7

- O arquivo input.caq:
	É o arquivo em linguagem CaquiScript que será lido como entrada.


Passo a passo para criar do zero:

- Criar projeto "CaquiScript_V1"

- Criar os packages:
	br.com.caquiscript.main
	br.com.caquiscript.parser
	
- No package main criar a MainClass

- Baixar o ANTLR na pasta raiz do projeto Java abrindo o terminal e escrevendo o código abaixo:
curl -O https://www.antlr.org/download/antlr-4.7.1-complete.jar

- Após executar dar um refresh e ver o antlr na pasta do projeto.

- Configurar o Build Path para add o ANTLR:
	clicar com o botão direito na pasta raiz do projeto
	Clicar em build path -> configure Build Path
	CLicar em Libraries
	Clicar em Classpath -> Add JARs...
	Selecionar o antlr que baixamos -> Ok
	Clicar em Apply and Close

	Ele irá adicionar o ANTLR como uma biblioteca referenciada;


- Rodar o código no terminal para o antlr criar as classes:

java -jar .\antlr-4.7.1-complete.jar .\CaquiScript.g4 -package br.com.caquiscript.parser -o .\src\br\com\caquiscript\parser


- Criar o arquivo de input inicial (input.caq) na pasta raiz do projeto

- Cada vez que mudar o arquivo CaquiScript.g4 é necessário rodar o código no terminal
para atualizar as classes
