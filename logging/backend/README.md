# logback sample application

## maven dependency

- logstash-logback-encoder: elastic logstash를 통해 log 수집
- janino: logback xml에 조건문 사용을 위한 dependency

## profiles

- dev: console에만 로그를 기록
- staging: console, file로 로그를 기록하며 file의 경우 info, error level을 나누어 기록
- prod: file, logstash로 로그 기록

## properties(logback-\*.properties)

- logging.level: 프로파일별 로그 레벨
- logging.file.path: 로그 파일이 저장되는 경로(windows os라고 경로에 \ 쓰지 말 것, 쓸거면 \\\로 쓰시오)
- logging.file.name.error: error 로그 파일명
- logging.file.name.info: info 로그 파일명
- logging.logstash.url: logstash url

## springdoc 경로(dev profile 기준)

http://localhost:8081/doc

- API
  - log level 변경
    - usage
    ```
    curl -X POST "http://localhost:8083/changeLogLevel" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"level\":\"DEBUG\", \"pkg\":\"com.example.demo\"}"
    ```

## Aplication 설명

- 구동 후 10초 간격으로 trace, debug, info, warn, error 로그를 기록하는 스케쥴러가 수행됨.

## todo

- logback xml에서 properties로 빼야 하는 목록 추출
- logstash 현재보다 더 좋은 format 조사
- logstash 퍼포먼스 조사: dslms의 경우 여러개 사이트(LG, Lotte)를 아울러서 수집이 가능할 수준인지.
- elastic에서 알림 설정방법 조사
- kibana에서 어던 형식으로 데이터가 수집되어야 추후 관리가 편할지 고찰
- logback xml resources 경로가 아닌 외부로 빼는 방법 조사
