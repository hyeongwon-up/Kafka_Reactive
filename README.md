# Kafka

### --create
### 새로운 토픽을 만들 때 사용하는 옵션
### --bootstrap-server
### 연결할 Kafka 서버( host:port )
### 이 옵션이 추가되면, 직접 Zookeeper에 연결하지 않아도 됩니다.
### --replication-factor
### Partition 복제 수
### 이 옵션을 사용하지 않으면, 기본 값을 사용합니다.
### 기본 값은 server.properties 파일에서 default.replication.factor 항목으로 설정 가능합니다. ( 설정되어 있지 않을 경우, 추가 작성 )
### --partitions
### Topic이 생성되거나 변경될 때의 Partition 수
### 이 옵션을 사용하지 않으면, 기본 값을 사용합니다.
### 기본 값은 server.properties 파일에서 num.partitions 항목으로 설정 가능합니다.
### --topic
### create, alter, describe, delete 옵션에 사용할 Topic 명
### Topic 이름은 큰따옴표(")로 묶고, 정규식 사용이 가능하므로 \로 escape 합니다.
