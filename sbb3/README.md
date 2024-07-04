## 점프 투 스프링부트3 책의 소스코드

* 위키독스 : https://wikidocs.net/book/7601


"점프 투 스프링부트"는 "Spring Boot Board(SBB)"라는 이름의 게시판 서비스를 만들어가는 과정을 설명한 스프링부트 입문서이다. 자바 설치부터 시작하여 서비스 운영까지 웹 프로그래밍의 처음부터 끝까지 모든 것을 알 수 있도록 구성하였다.

이 책을 따라하다 보면 다음과 같은 웹 사이트가 만들어진다. (최종 결과물)

* [http://sbb.pybo.kr](http://sbb.pybo.kr)


책을 따라하다 생기는 질문은 위키독스의 댓글 또는 필자가 운영하는 디스코드를 활용하도록 하자.

* 질문과 답변 서비스 "디스코드" - [https://discord.gg/ZwqRRYRYkR](https://discord.gg/ZwqRRYRYkR)

sbb3 - https://github.com/pahkey/sbb3

C:\Program Files (x86)\H2\bin\h2b.bat 실행
http://10.129.67.36:8082/login.jsp?jsessionid=3071cf43d72dd1488b37ef2f660982af

H2 database server 선택 

Database "C:/Users/jonpark/test" not found, either pre-create it or allow remote database creation (not recommended in secure environments) [90149-224] 90149/90149 (도움말)

=> embedded 를 선택하면 C:/Users/jonpark/test 생성됨.
이후 server 를 선택하면 됨

https://yjkim-dev.tistory.com/3
    압축을 풀고 bin 디렉토리 아래의 h2.bat 또는 h2.sh 을 실행하면 H2 데이터베이스가 서버 모드로 실행된다.
    h2.bat => window 환경
    h2.sh => linux 환경
    실행을 하면 위의 그림과 같이 프로그램이 화면에 나타납니다.
    연결 버튼을 누르면
    실제 로컬의 ~/경로에 가보면 test.mv.db 이름의 파일이 생성되면 정상 작동 완료.
    왼쪽위에 빨간색 아이콘 클릭후
    Embedded 모드 URL인 jdbc:h2:~/test 가 아닌
    Server 모드 URL로 설정해야 정상적으로 접속가능
    jdbc:h2:tcp://localhost/~/test 로 재접속한다.
    후에
    application.yml에서

# h2 on spring
https://velog.io/@jinny-l/H2-DB%EC%9D%98-3%EA%B0%80%EC%A7%80-%EB%AA%A8%EB%93%9C%EC%99%80-%EC%82%AC%EC%9A%A9%EB%B2%95-Server-Mode-Embedded-Mode-In-Memory-Mode
https://kukim.tistory.com/105
