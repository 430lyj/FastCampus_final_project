# Board project
스프링부트를 이용하여 웹 프로젝트를 생성하고 BOARD 테이블에 대한 CRUD 기능의 게시판 프로그램을 개발합니다.</br>
데이터베이스 연동은 반드시 Spring Data JPA를 이용하여 처리해야 합니다. </br>
로그인, 회원 가입 등 회원과 관련된 기능은 구현하지 않고 게시판 프로그렘의 CRUD 기능만 구현합니다.

## 실행방법
1. Gradle을 빌드하고 SpringBoot BoardApplication 을 실행한다.
2. 크롬이나 사파리 브라우저에서 url (localhost:8080)으로 접속하면 게시판 화면이 나온다.

## 이용기술
- Spring Boot
- JSP
- Spring Data JPA

## 점검 기준
|기준|점검 상세|수행 여부|
|:--:|:--|:--:|
|비즈니스 컴포넌스 설계와 구현|application.properties 파일에 웹 애플리케이션 관련 설정을 적절히 설정했다.||
||엔티티 클래스를 작성하고 JPA 어노테이션을 잘 설정했다.||
||CRUD 기능의 Repository 인터페이스를 작성했다.||
||비즈니스 클래스를 잘 구현했다.||
|데이터베이스 연동 구현|application.properties 파일에 JPA 연동 관련 설정을 적절히 설정했다.||
||엔티티 클래스를 기반으로 게시판 테이블과 시퀀스가 적절히 생성됐다.||
||JPA를 이용해서 기본적인 CRUD 기능이 동작하도록 잘 구현했다.||
