# spring5-for-beginner

나무소리 채널(https://www.youtube.com/channel/UCtaUzBujIBjtrkqACmkM44g/)

Spring 5 for Beginner 강좌 관련 교재 및 관련 소스 자료입니다.

---

## Travel Club Project

여행 클럽과 클럽 멤버의 관리(클럽 개설과 변경 등)를 위한 app

- 크게 4단계의 과정을 통해 개발
- 웹 환경에서 서비스 할 수 있도록 구현
- UI는 REST-Client(insomnia)를 이용

<br/>

### ❖ entities

<img src='./UML/entity_diagram.jpeg' alt='entities' width='50%'/> <br/>

### ❖ service, store, interface

<img src='./UML/travelclub_simple_diagram.jpeg' alt='simpleDiagram' width='50%'/> <br/>

- mapStore : persistanceLayer, 데이터들을 저장하고 불러오는 class  
  <img src='./UML/store_diagram.jpeg' alt='stores' width='70%'/> <br/>
- serviceLogic : 실제적인 기능과 관련된 처리들을 하는 class  
  <img src='./UML/service_diagram.jpeg' alt='services' width='70%'/> <br/>

- clubStore, membershipStore, memberStore : **interface**
