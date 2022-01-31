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

1."登録"を押す
<br/><br/>
<img width="900" alt="Screen Shot 2022-01-31 at 16 20 18" src="https://user-images.githubusercontent.com/98641436/151755958-268e11ae-4676-48f9-9788-1dbc950538a5.png">

2.情報を打ち込む
<br/><br/>
<img width="900" alt="Screen Shot 2022-01-31 at 16 39 05" src="https://user-images.githubusercontent.com/98641436/151756603-be4b7c6a-8a83-42c6-b1e9-35d1f3f99ae2.png">

3."ログイン"を押す
<br/><br/>
<img width="900" alt="Screen Shot 2022-01-31 at 16 20 18" src="https://user-images.githubusercontent.com/98641436/151755958-268e11ae-4676-48f9-9788-1dbc950538a5.png">

4.設定したログインIDとログインパスワードを入力する
<br/><br/>
<img width="900" alt="Screen Shot 2022-01-31 at 16 39 26" src="https://user-images.githubusercontent.com/98641436/151757083-982cdde8-9c13-41e6-b0ff-efcf43066f76.png">

5."預け入れ"を押す
<br/><br/>
<img width="900" alt="Screen Shot 2022-01-31 at 16 39 34" src="https://user-images.githubusercontent.com/98641436/151757252-dfa679dd-5e97-420c-bc51-c64e0b690f54.png">

6.預け入れしたい金額を入力する
<br/><br/>
<img width="900" alt="Screen Shot 2022-01-31 at 16 39 52" src="https://user-images.githubusercontent.com/98641436/151757355-c4a6f2e3-4f27-4e5e-b4b1-55e9cbe0b4d2.png">

7."ログアウト"を押す
<br/><br/>
<img width="900" alt="Screen Shot 2022-01-31 at 16 39 55" src="https://user-images.githubusercontent.com/98641436/151757448-b046b63b-31e0-4df2-8eca-e6970c7171de.png">

8.終了
<br/><br/>
<img width="900" alt="Screen Shot 2022-01-31 at 16 39 59" src="https://user-images.githubusercontent.com/98641436/151757573-928f9106-e881-4bb5-9995-55566277fe31.png">
<br/>
