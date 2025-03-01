# 빌드 단계
FROM gradle:7.6-jdk17 AS builder

# 작업 디렉터리 설정
WORKDIR /app

# 프로젝트 파일 복사
COPY . .

# 의존성 설치 및 빌드 (예시로 gradle 사용, Maven을 사용할 경우 mvn으로 변경)
RUN gradle build --no-daemon


# 런타임 단계
FROM openjdk:17-jdk-alpine

# 작업 디렉터리 설정
WORKDIR /

# 런타임 환경 변수 설정 (디폴트로 dev 환경 설정)
ARG JAVA_OPTS
ARG environment=dev
ENV JAVA_OPTS=$JAVA_OPTS
ENV environment=${environment}

# 빌드 단계에서 생성한 JAR 파일을 복사 (빌드 단계에서 `build/libs/shareLiving-*.jar` 경로로 생성된 파일)
COPY --from=builder /app/build/libs/shareLiving-*.jar shareliving.jar

# 포트 노출 (애플리케이션 포트)
EXPOSE 80

# ENTRYPOINT로 Spring Boot 애플리케이션 실행
ENTRYPOINT ["sh", "-c", "java -Dspring.profiles.active=prod ${JAVA_OPTS} -jar /shareliving.jar"]
