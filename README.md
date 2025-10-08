## Java swing tutorial 

To use this repo 
1. clone the repository
2. Install the mysql and Java 


```bash
brew install openjdk@17
echo 'export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
java -version
javac -version
```


3. Install Mysql

```bash
brew services start mysql
mysql -u root -p
```
4. Create a db and the table

```mysql
CREATE DATABASE swingdb;
USE swingdb;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);
```

5. Compile the Java Files 

```bash
javac -cp .:mysql-connector-java-8.0.30.jar DBConfig.java SignUpForm.java LoginForm.java
java -cp .:mysql-connector-java-8.0.30.jar SignUpForm
```


6. Run the sign-Up Form

java -cp .:mysql-connector-java-8.0.30.jar SignUpForm

7. Run the Login Form

java -cp .:mysql-connector-java-8.0.30.jar LoginForm



Happy Coding !!!