# 제한 사항

- 테스트는 `docker` 커맨드를 이용해서 컨테이너 환경에서 진행할 것. (IDE를 통한 내장 톰캣 등 사용 불가)

## 문제1.

해당 백엔드 어플리케이션은 사용자가 컨테이너를 실행할 때, environment 환경변수를 넘김으로써, 디버그 레벨을 조절할 수 있습니다.

```bash
# 개발 환경으로 실행하여 debug 레벨까지 로그 출력
docker run -e environment=dev shareliving

# 운영 환경으로 실행하여 INFO 레벨까지 로그 출력
docker run -e environment=prod shareliving
```

코드를 수정하다 보니 어느 순간부터 개발 환경으로 실행해도 운영 환경으로 실행되는 버그가 생겼습니다.
이를 해결하여 dev 환경에선 DEBUG 로그를 출력. prod 환경에선 INFO 로그를 출력하도록 설정하시오.

## 문제2.

/users/sign-up API는 name: String과 age: Int를 매개 변수로 받습니다.
/users?name={name} API는 name을 통해서 회원 검색을 할 수 있습니다.
현재 회원 가입 이후에 해당 이름으로 회원을 검색해도 결과를 반환하지 않습니다.
컨테이너를 debug 모드로 실행한 후에 `docker logs`로 로그를 확인하여 문제를 해결하세요.
