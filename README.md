# Todo API Server
Implementation of a clone of Todo API Server from the [book(코드로 배우는 React with 스프링 부트 API 서버)](https://www.yes24.com/Product/Goods/123363647) and the [Github(구멍가게 코딩단)](https://zk202308a.github.io/reactbookcodes/).

This project uses the [Udacity Nanoderee Style](https://udacity.github.io/git-styleguide/) as a git commit message rule.

## Technical Stack

- Language
  - JAVA 17
- Framework
  - Spring boot 3.2.4
- Database
  - MariaDB
- ORM
  - JPA
  - querydsl
- Test
  - JUnit
 
## Run Application with docker

1. Git clone repository

```
git clone https://github.com/juintination/todo-api-server.git

cd todo-api-server
```

2. Build docker image

```
docker build -t todo-image .
```

3. Run with docker enviornment

```
docker compose up -d
```

4. Remove docker environment

```
docker compose down
```

## About this Study

기존의 `코드로 배우는 스프링 부트 웹 프로젝트` 책으로 공부했을 때와 달리 `thymeleaf`를 사용하지 않고 화면 구성이 하나도 없는 상태로 작성되었습니다.

Postman을 이용해서 작성된 코드의 결과를 확인하는 방식으로 구현하였으며 실제로 연동되는 리액트 애플리케이션은 따로 작성하지 않을 예정입니다.
