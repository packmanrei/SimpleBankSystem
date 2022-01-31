# SimpleBankSystem
これは簡易的銀行システムです。<br/>
アカウントの登録、ログイン、問い合わせ、引き落としなどその他にも様々なアクションが行えます<br/>
実行する際に、コードを下に乗せているので先にデータベースを作ってから実行してください。
## 使用言語
- Java Spring MVC
- mySQL
- HTML
## 環境
- mac
- Eclipse 2021-12
- Java 1.8(JDK 8)
## データベース設定コード
contacts
```mySQL
CREATE TABLE banksystem.contacts(
    email CHAR(50) NOT NULL,
    message CHAR(255),
    CONSTRAINT PRIMARY KEY (email)
);

```

users_info
```mySQL
CREATE TABLE banksystem.users_info(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name CHAR(30) NOT NULL,
	phone CHAR(11) NOT NULL,
	email CHAR(30),
	loginId CHAR(50) NOT NULL,
	loginPass CHAR(50) NOT NULL,
	amount INT
);

```

## 一連の実行例



