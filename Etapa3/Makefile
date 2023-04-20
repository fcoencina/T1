JFLAGS = -g
JC = javac
JVM = java
FILE = config.txt
MAIN = Stage3

*.class: *.java
	$(JC) $(JFLAGS) *.java

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

clean:
	$(RM) *.class