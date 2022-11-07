# [Team Project] Web ERP(회계인사관리) 구축 프로젝트 <br/>

<h3>개요 📌</h3>
1. 팀을 이루어 스프링부트 프레임워크와 MyBatis를 이용하여 메뉴별로 개발하고 취합 후, 데이터가 유동적으로 맞물릴 수 있는 시스템 개발<br>
2. 기획 및 개발, 테스트까지 한달이라는 시간 내 효율적인 협업 방법을 모색하며 짧은 기간 내 최대한의 퍼포먼스를 내는 것이 목표<br>
3. 프로젝트를 진행함에 있어 미적 요소가 요구되는 서비스웹(ex. 쇼핑몰, 채용 사이트)을 지양하고 쿼리문과 비동기 관련 개발을 지향<br>

<h3>개발 기간 ⌚️</h3>
2022-10-04 ~ 2022-11-04 (총 1개월)<br/>

<h3>개발 내용 🛠</h3>
1. 프로젝트 착수 후, '1주일 동안 기획 / RDBMS 구성 / Front 커스터마이징'을 동시 진행하여 협업 및 커뮤니케이션을 극대화<br>
2. Springboot Framework, Spring Security + JWT를 위해 JPA, 그 외 기능은 MyBatis를 이용하여 11개 매퍼 구성<br>
3. 관계형 DB 구성 및 지출결의서 서로 다른 2개 테이블의 통합 리스트 구현을 위해 JOIN 또는 View의 UNION 등의 쿼리 사용<br>
4. 시각적으로 중요한 View단은 부트스트랩 테마를 이용하여 공수를 최대한 줄이고 서비스 구현 및 JavaScript 로직 개발에 집중<br>

<h3>T.F ❣️ 총 5명</h3> 
최성후(팀장) : https://github.com/Sh931125<br>
성효영(팀원) : https://github.com/Sh931125<br>
박예진(팀원) : https://github.com/October7th<br>
송한울(팀원) : https://github.com/great-null<br>

<h3>담당 개발</h3>
1. 공통 : 기간 조회 공통 스크립트 개발 및 기획(IA 정의 & 화면 기획 & 정책 정의) - 기여도 100%<br>
2. 메인 : 대시보드 구현 및 휴가자 캘린더 구현 - 기여도 100%<br>
3. 회계 전표 : fetch.then 을 통해 Restful 리스트 조회 구현, 기간 조회와 서브 리스트 조회 구현 - 기여도 100%<br>
4. 로그인 : Spring Security config 수정 개발 및 권한별 메뉴 접근 설정 - 기여도 40%<br>
5. 전자결재 : 결재수신함 통합 리스트 구현(View Union ALL 쿼리) - 기여도 10%<br>

<h3>주요 화면</h3>
[1] Main Dashboard<br>
<img width="1170" alt="스크린샷 2022-11-06 오후 5 47 48" src="https://user-images.githubusercontent.com/102308415/200162016-da469d67-8cfc-403a-a964-d4fae3b0163f.png"><br>

[2] 회계 전표<br>
<img width="1233" alt="스크린샷 2022-11-06 오후 5 49 36" src="https://user-images.githubusercontent.com/102308415/200162053-0a77b556-be50-403e-8634-f00d7f27de6c.png"><br>


<h3>주요 로직</h3>
[1] 비동기 처리<br>
<img width="1231" alt="스크린샷 2022-11-06 오후 5 54 03" src="https://user-images.githubusercontent.com/102308415/200162261-d6492f88-dc06-48ef-ad40-4225af172aee.png"><br>

[1-1] RestController<br>
<img width="997" alt="스크린샷 2022-11-06 오후 5 54 37" src="https://user-images.githubusercontent.com/102308415/200162266-1249fa1f-46e9-4ee4-a69c-88cb1da5b355.png"><br>

[2] 공통 함수(기간 조회)<br>
<img width="922" alt="스크린샷 2022-11-06 오후 5 57 23" src="https://user-images.githubusercontent.com/102308415/200162348-25189ff8-86a5-45bf-86bd-209d56b0ab82.png"><br>

[3] Spring Security 권한 처리<br>
<img width="1221" alt="스크린샷 2022-11-06 오후 6 00 21" src="https://user-images.githubusercontent.com/102308415/200162454-41d69e30-5c01-40ec-a34b-c23df7a38bcd.png"><br>





