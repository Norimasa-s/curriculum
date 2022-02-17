package service;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.EmployeeBean;
 
/**
 * ・社員情報検索サービス
 */
 
public class EmployeeService {
//主にここのクラスはデータベースのやりとりをしている。id 、passwordを参照してDBとのやりとりをする
//login_timeで処理された時間を出力する処理もある

  // 問① 接続情報を記述してください
 /** ドライバーのクラス名 */
 private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
 /** ・JDMC接続先情報 */
 private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/Employee";
 /** ・ユーザー名 */
 private static final String USER = "postgres";
 /** ・パスワード */
 private static final String PASS = "postgres";
 /** ・タイムフォーマット */
 private static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
 
  // 問② 入力された値で、UPDATEする文
 /** ・SQL UPDATE文 */
 private static final String SQL_UPDATE ="UPDATE employee_table SET login_time = ? WHERE Employee_table.id = ?";
 
  // 問③ 入力されたIDとPassWordをキーにして、検索するSELECT文
 /** ・SQL SELECT文 */
 private static final String SQL_SELECT = "SELECT * FROM employee_table WHERE id = ? AND Employee_table.password = ?";
 
 EmployeeBean employeeDate = null;
 
  // 送信されたIDとPassWordを元に社員情報を検索するためのメソッド
 public EmployeeBean search(String id, String password) {
 

//connectionはデータベースにアクセスできるようにする物
Connection connection = null;
//statementは問い合わせして実行する
 Statement statement = null;
//resultSetはSQLの実行結果を格納する
 ResultSet resultSet = null;
 //preparedStatementはSQL文を生成する
 PreparedStatement preparedStatement = null;

 
 try {
  // データベースに接続
 Class.forName(POSTGRES_DRIVER);
// ↑ドライバの設定
 connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
// ↑URLの設定
 statement = connection.createStatement();
 
  // 処理が流れた時間をフォーマットに合わせて生成
 Calendar cal = Calendar.getInstance();
// カレンダークラス使う
 SimpleDateFormat sdFormat = new SimpleDateFormat(TIME_FORMAT);
// SimpleDateFormatをインスタンス
 
  // PreparedStatementで使用するため、String型に変換
 String login_time = sdFormat.format(cal.getTime());
 
 /*
 * 任意のユーザーのログインタイムを更新できるように、プリペアドステートメントを記述。
 */
 
  // preparedStatementに実行したいSQLを格納
 preparedStatement = connection.prepareStatement(SQL_UPDATE);
  // 問④ preparedStatementを使って、一番目のindexに今の時間をセットしてください。2番目のindexにIDをセットしてください。
 preparedStatement.setString(1,login_time);
 preparedStatement.setString(2,id);
 //PreparedStatementはメソッドにSQL文の引数を指定して生成するもの
 //”？”をもつSQL文を実行するやつ
 
  // 問⑤ UPDATEを実行する文を記述
 preparedStatement.executeUpdate();
 /*
 * UPDATEが成功したものを即座に表示
 * 任意のユーザーを検索できるように、プリペアドステートメントを記述。
 */
 preparedStatement = connection.prepareStatement(SQL_SELECT);
  //問⑥ 一番目のindexにIDをセットしてください。2番目のindexにPASSWORDをセット。
 preparedStatement.setString(1,id);
 preparedStatement.setString(2,password);
 
 
  // SQLを実行。実行した結果をresultSetに格納。
 //executeQueryでSQLをデータベースで実行。
 resultSet = preparedStatement.executeQuery();
 
 
 //resultSetでインターフェイスの実行結果を格納する
 while (resultSet.next()) {
  // 問⑦ tmpName,tmpComment,tmpLoginTimeに適当な値を入れてください。
 String tmpName = resultSet.getString("name");
 String tmpComment = resultSet.getString("comment");
 String tmpLoginTime = resultSet.getString("login_time");
 //↓tmpは一時的にデータを格納する
  // 問⑧ EmployeeBeanに取得したデータを入れてください。
 employeeDate = new EmployeeBean();
 employeeDate.setName(tmpName);
 employeeDate.setComment(tmpComment);
 employeeDate.setLogin_Time(tmpLoginTime);
 }

 
  // forName()で例外発生
 } catch (ClassNotFoundException e) {
 e.printStackTrace();
 
  // getConnection()、createStatement()、executeQuery()で例外発生
 } catch (SQLException e) {
 e.printStackTrace();
 
 } finally {
 try {
 
 if (resultSet != null) {
 resultSet.close();
 }
 if (statement != null) {
 statement.close();
 }
 if (connection != null) {
 connection.close();
 }
 
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
 return employeeDate;
// EmployeeControllerクラスのsearchメソッドへ
 }
}