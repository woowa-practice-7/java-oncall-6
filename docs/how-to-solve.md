### 미션 해결 전략

#### 1. 본인이 이해하고 구현한 내용에 기반해 '다른 근무자와 순서를 바꿔야 하는 경우'를 자신만의 예시를 들어 설명하세요. (필수)

- 다른 근무자와 순서를 바꿔야하는 경우는 요구사항에 따라 특정 근무자가 2일 연속 비상근무를 서게 될 때입니다. 평일과 휴일의 근무 명단을 따로 관리하고 각 명단에는 근무자가 1번씩만 들어가기에 (평일, 평일),
  혹은 (주말,주말)을 2일 연속으로 비상근무 서게 될 일은 없지만 문제는 (평일, 주말) 혹은 (주말, 평일)의 경우에 발생합니다. 명단을 따로 관리하기에 나타날 수 있는 예외 상황으로 다음과 같은 예시를 들 수
  있습니다.
- 평일 비상 근무자 명단: [진우, 태호, 우성, 재준, 진희]
- 휴일 비상 근무자 명단: [진우, 우성, 진희, 태호, 재준]
- 12월 1일이 일요일인 상황을 가정하겠습니다
- 일요일에는 휴일 1번 근무자인 진우가 근무를 서게 됩니다.
- 월요일에도 평일 1번 근무자인 진우가 근무를 서야합니다
- 바로 이 경우에 2일 연속 근무가 발생합니다. 때문에 평일 근무자 명단에서 진우와 그 다음 근무자의 위치를 바꿉니다.
- 바꾼 후 평일 비상 근무자 명단: [태호, 진우, 우성, 재준, 진희]
- 이렇게 되면 월요일에는 태호가 근무하고 진우는 하루 뒤인 화요일에 근무가 가능합니다.

#### 2. 요구사항에서 제시한 앞의 날짜부터 순서를 변경하는 방법 외에 다른 방법이 있다면 어떤 방식이 있는지, 이 방법은 기존에 제시된 방식과 비교해 어떤 차이가 있는지 설명하세요. (선택)

- 실제로 회사에서 해당 프로그램을 통해 비상 근무자 명단을 작성한다고 가정해보겠습니다. 현재 프로그램 요구사항대로 2일 연속 근무하는 일은 생기지 않는 상태입니다. 하지만 저는 격일 비상근무 또한 근무자에게 부담이
  되는 일이라고 생각합니다. 조금 더 복잡한 로직을 구현한다면 한번 근무를 했을 때 해당 근무자에게 특정한 양수를 부여하고 근무표에서 한사람이 돌 때마다 해당 양수가 1씩 빠지게 할 것 같습니다. 해당 양수가 0이
  되었을 때만 근무 편성이 되도록 할 것입니다. 경우에 따라 근무자를 한바퀴 모두 돌아도 모든 근무자의 숫자가 양수인 경우도 생길 수 있을 것입니다. 이를 체크하여 한바퀴를 모두 돌았을 경우에는 숫자가 가장 적은
  근무자를 앞으로 오게하는 로직이 필요할 것 같습니다. 이러한 방식이라면 조금 더 근무자에게 비상 근무에 대한 부담을 줄여줄 수 있을 것이라 생각합니다.