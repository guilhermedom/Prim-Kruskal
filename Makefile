JC = javac

DIR_E = estruturas
DIR_B = bin

ARG_JC = -d
ARG_J = -cp
ARG_RM = -f
ARG_MK = -p


Main.class: Grafo.class
	$(JC) $(ARG_JC) $(DIR_B) Main.java
	java $(ARG_J) $(DIR_B) Main

Grafo.class: ComparatorDouble.class FilaPrioridade.class UnionFind.class mkdir
	$(JC) $(ARG_JC) $(DIR_B) $(DIR_E)/Grafo.java

FilaPrioridade.class: ComparatorDouble.class mkdir
	$(JC) $(ARG_JC) $(DIR_B) $(DIR_E)/FilaPrioridade.java
	
UnionFind.class: mkdir
	$(JC) $(ARG_JC) $(DIR_B) $(DIR_E)/UnionFind.java
	
ComparatorDouble.class: mkdir
	$(JC) $(ARG_JC) $(DIR_B) $(DIR_E)/ComparatorDouble.java
	
mkdir:
	mkdir $(ARG_MK) $(DIR_B)
   
clean:
	rm $(ARG_RM) $(DIR_B)/*.class
	rm $(ARG_RM) $(DIR_B)/$(DIR_E)/*.class


 
