-- 以下のSQLをコピペして実行してください。
-- ※INSERT文の内容は指示に従い書き換えてください。

CREATE TABLE Employee(
    EmpId CHAR(5) NOT NULL,
    Password VARCHAR(64) NOT NULL,
    Name VARCHAR(50) NOT NULL,
    Mail VARCHAR(255),
    ProgramingLanguage TEXT,
    Comment TEXT,
    CreateDate VARCHAR(19) NOT NULL,
    UpdateDate VARCHAR(19) NOT NULL,
    DeleteFlg CHAR(1) NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY(EmpId)
);

-- 登録データサンプル
-- FIXME: Step-1: 2カラム目のパスワード以外を、ご自身の内容に変更した上で実行してください。
INSERT INTO Employee VALUES(
    'ご自身の社員番号',
    '88d8580a7ea163777a19f779d77e4339d68c1c24f39f3fd90a4b1e64ff7620b8',
    'ご自身の名前',
    'ご自身のblueのメールアドレス',
    'ご自身の得意言語や学習言語',
    '何か一言（意気込みとか）',
    TO_CHAR(CURRENT_TIMESTAMP, 'yyyy/MM/dd HH24:mm:ss'),
    TO_CHAR(CURRENT_TIMESTAMP, 'yyyy/MM/dd HH24:mm:ss'),
    '0'
);

/* 確認用SQL */
SELECT * FROM Employee;