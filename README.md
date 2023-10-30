# Java_Kiosk
# 기능 설명
## 시작 메뉴
### 0. 히든 메뉴
- 지금까지 판매된 모든 상품의 이름과 가격 출력
- 지금까지 매장에 판매된 금액(매출) 출력
### 메뉴 선택
- 출력된 메뉴목록 중 숫자로 메뉴 선택(현재 시간에 주문 가능 상태(항상,아침,아침제외)에 따라 상품이 출력여부가 결정)
->상품 목록 출력->숫자로 상품 선택(옵션여부에 따라 옵션 선택 출력)
->cart에 추가

### 주문 현황
최근 완료된 주문 3개(완료된 주문이 없으면 없다고 출력)
대기 중인 주문 전체 출력한다(대기중 주문이 없으면 없다고 출력)
### 주문하기
- cart에 담기긴 상품 목록(이름 개수 가격 설명), 가격의 합 출력
- 주문할지 말지 결정
- 주문하면 대기번호 부여 후 대기주문 목록에 추가! 판매목록에 상품 추가 
### 취소하기
- cart를 비운다
### 관리 메뉴
- 관리 메뉴로 이동
- 
## 관리 메뉴
## 0.시작 메뉴
### 1.대기 주문 목록
- 대기 중인 주문 전체 출력
- 완료 처리여부 확인
- 완료할 대기번호 입력 받고 완료 처리(완료 주문 리스트에 추가)
### 2.완료 주문 목록
- 완료 주문 목록 전체 출력
### 3.상품 생성
- 메뉴 이름 받기
- 해당 이름으로 된 메뉴 존재하면 생성 하지 않고, 존재하지 않으면 새로 생성한다(설명 입력/ 주문가능상태 설정)
- 상품 이름 받기
- 해당 메뉴에 해당 상품이 존재하면 다시 입력받고, 존재하지 않으면 설명, 가격을 추가로 입력 받고 상품을 생성한다.
- 옵션을 추가할지 확인해 추가 한다면 상품에 option을 true로 설정하고 옵션 이름과 가격을 입력받아(원하는 만큼) 상품의 옵션에 추가한다
- 옵션 추가 안하면 관리 메뉴로 이동한다..
### 4.상품 제거 
- UUID를 입력 받는다
- 형식이 맞지 않으면 다시 입력받고
- 존재하지 않으면 다시 입력받는다.
- 0번 누르면 관리메뉴
- menuMap에 존재하면 해당 메뉴 menuMap, menulist에서 삭제, cart에 해당 메뉴 존재한다면 삭제
- mduuidMap에 존재하면 해당 상품 mduuidMap에서 삭제, 상품이 속한 menu의 mdlist에서도 삭제, cart에 해당 상품(옵션까지) 삭제

## 순서도
### 관리 메뉴 추가 전
![키오스크 순서도 drawio](https://github.com/leeminju/Java_Kiosk/assets/19209147/6e27fbf3-2d54-41fb-ba2d-65bc92bf924e)

### 관리 메뉴 추가 후
![키오스크 순서도 drawio (관리메뉴 추가)](https://github.com/leeminju/Java_Kiosk/assets/19209147/9d709cc1-8ace-47e5-8bbc-f15bf8ff56cd)


