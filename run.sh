find * -name "*.java" > files
javac @files
rm -rf files
#find * -name "*.class"
java fr/ecole/avaj/Simulator $@
