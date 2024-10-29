## 간단한 은행 앱 만들기 ##
- 계좌생성
- 입금
- 출금
- 송금
- 계좌조회

JAVA 연결하여 DB의 고객정보 잔액 게좌조회등을 구현했습니다.
- TABLE 은 ACCOUNTS 와 USERS 로 관리하며
- USERS 테이블에는 고객 ID, NAME, PASSWORD 저장된다
- ACCOUNT 테이블에는 ACCOUNT_NUMBER 계좌번호 와 BALANCE 가격이 저장된다

DB 아이디와 비밀번호는 config.properties gitignore 을 활용하여 비공개로 올렸습니다. 
