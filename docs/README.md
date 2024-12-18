## 입력

- 월(숫자)과 시작 요일(일, 월, 화, 수, 목, 금, 토) 정보를 입력받는다.
    - 월이 숫자가 아니면 예외처리
    - 월이 1~12가 아니면 예외처리
    - 요일이 (일, 월, 화, 수, 목, 금, 토)가 아니면 예외처리
- 평일 비상 근무 순서를 입력받는다.
    - 구분자는 쉼표(,)
    - 근무자 중복시 예외처리
    - 닉네임이 5자 초과시 예외처리
- 휴일(토요일, 일요일, 법정공휴일) 비상 근무 순서를 입력받는다.
    - 구분자는 쉼표(,)
    - 근무자 중복시 예외처리
    - 닉네임이 5자 초과시 예외처리

ex)

```
비상 근무를 배정할 월과 시작 요일을 입력하세요> 5,월
평일 비상 근무 순번대로 사원 닉네임을 입력하세요> 준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리
휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> 수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니
```

## 로직

- 입력한 월에 맞게 일, 요일들 생성
    - 휴일 고려
- 평일이면 평일 근무 사원 리스트에서 휴일이면 휴일 근무 사원 리스트에서 사원 빼오기
- 이때 이전 근무자와 현재 근무자가 같다면 현재 근무자의 다음 근무자를 현재 근무자로 세우고 그 자리에 원래 근무자 넣기

## 출력

- 비상 근무표 출력
    - 휴일에는 뒤에 “(휴일)” 붙여서 출력

ex)

```
5월 1일 월 준팍
5월 2일 화 도밥
5월 3일 수 고니
5월 4일 목 수아
5월 5일 금(휴일) 루루
5월 6일 토 수아
5월 7일 일 글로
5월 8일 월 루루
5월 9일 화 글로
5월 10일 수 솔로스타
5월 11일 목 우코
5월 12일 금 슬링키
5월 13일 토 솔로스타
5월 14일 일 우코
5월 15일 월 참새
5월 16일 화 도리
5월 17일 수 준팍
5월 18일 목 도밥
5월 19일 금 고니
5월 20일 토 슬링키
5월 21일 일 참새
5월 22일 월 수아
5월 23일 화 루루
5월 24일 수 글로
5월 25일 목 솔로스타
5월 26일 금 우코
5월 27일 토 도리
5월 28일 일 준팍
5월 29일 월 슬링키
5월 30일 화 참새
5월 31일 수 도리
```