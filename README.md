# Event Driven Programming Practica

This project does not use a database; it relies solely on mock data. The goal is to achieve loose coupling between components


## Domain Scenario
- Product
- Coupon
- Customer
- Order
- Delivery
- Payment
- Kitchen

### 📖Condition
1. A **Product** is an item with defined attributes such as price, stock, and options.
2. A **Coupon** can only be applied to specific **Products** and specifies the usage period and conditions.
3. A **Customer** has an account that contains personal and payment information.
4. A **Kitchen** holds specific **Products** and is responsible for the preparation and delivery of those **Products**.
5. A **Customer** can purchase a **Product**.
    - 5-1. When ordering via **Mobile**, the customer enters information such as the delivery address and payment method.
    - 5-2. When ordering via **Kiosk**, the customer enters payment information.
6. Create an order form that matches the appropriate format.
7. Proceed with payment.
    - Payment can be made through mobile payment, card payment, cash payment, etc.
8. Order details transmission:
    - 8-a. When ordering via **Mobile**, the order details are transmitted to both the **Kitchen** and **Delivery** domains.
    - 8-b. When ordering via **Kiosk**, the order details are transmitted only to the **Kitchen** domain.


1. **Product**는 가격, 재고, 옵션 등이 정의된 상품이다.
2. **Coupon**은 특정 **Product**에만 적용될 수 있으며, 사용 가능한 기간과 조건이 명시된다.
3. **Customer**는 개인 정보, 결제 정보 등을 포함한 계정을 가진다.
4. **Kitchen**은 특정 **Product**를 보유하고 있으며, 해당 **Product**의 준비 및 배송을 담당한다.
5. **Customer**는 **Product**를 구매할 수 있다.
    - 5-1. **Mobile**을 통해 주문 시, 사용자는 배송 주소, 결제 방법 등의 정보를 입력한다.
    - 5-2. **Kiosk**를 통해 주문 시, 사용자는 결제 정보를 입력한다.
6. **각 형식에 맞는 주문서를 제작한다.**
7. **결제를 진행한다.**
    - 결제는 모바일 결제, 카드 결제, 현금 결제 등의 방법으로 진행된다.
8. **주문 명세 정보 전송:**
    - 8-a. **Mobile**로 주문 시, **Kitchen**과 **Delivery** 도메인으로 주문 명세 정보를 전송한다.
    - 8-b. **Kiosk**로 주문 시, **Kitchen** 도메인으로만 주문 명세 정보를 전송한다.

