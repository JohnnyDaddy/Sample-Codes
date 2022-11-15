## Usage

- dslms --log-type INFO --package io.dtonic

## TODO

### 아래와 같이 config 경로를 전달 받아 해당 파일로 부터 server 구성 정보를 불러들여 통신할 수 있도록 한다.

```
${protocol}://${host}:${port}
```

- dslms --f "C:\Program Files\dslms-central.yml" --log-type INFO --package io.dtonic



# Description

- ess_aims의 application.yml file을 샘플로 넣음.
- 외부 라이브러리 설치를  피하기 위하여 직접 String으로 file을 읽어 parsing함
