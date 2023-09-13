secure_house: secure_house.java
	cp run.sh secure_house
	chmod +x secure_house
	javac -g secure_house.java

clean:
	$(RM) secure_house