JFLAGS = -g
JC = javac
JVM = java
FILE = config.txt
MAIN = Stage2

*.class: *.java
	$(JC) $(JFLAGS) *.java

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

clean:
	$(RM) *.class
