# [Team Project] Web ERP(회계인사관리) 구축 프로젝트 <br/>

<h3>개요 📌</h3>
1. 스프링부트 프레임워크와 MyBatis를 이용하여 유기적 관계 구조를 지닌 ERP 시스템 개발. <br>
2. 한달 내 기획 및 개발, 테스트 완료까지 효과적인 협업 방법을 찾고 문제점 도출 및 개선 경험 필요<br>
3. 총 인원 6명 각 TF는 메뉴 내 리스트 구현 시, 비동기 처리를 통해 RESTful한 개발을 목표로 함

<h3>개발 기간 ⌚️</h3>
2022-10-04 ~ 2022-11-04 (총 1개월)<br/>

<h3>개발 내용 🛠</h3>
1. 로그인 : Spring Security + JWT 구현 및 권한 제어<br>
2. 메인 : 대시 보드 및 휴가자 달력<br>
3. 인사 : 인사 등록 & 급여(승진) 관리<br>
4. 회계 : 급여 및 지출결의서 승인 건 전표 생성 및 뷰<br>
5. 전자결재 : 지출결의서 & 휴가신청서 상신/수신<br>
6. 마이페이지 :내 정보 변경 & 비밀번호 수정<br>

<h3>T.F ❣️ 총 5명</h3> 
최성후(팀장) : https://github.com/Sh931125<br>
성효영(팀원) : https://github.com/Hyongyi<br>
박예진(팀원) : https://github.com/October7th<br>
송한울(팀원) : https://github.com/great-null<br>

<h3>담당 개발</h3>
1. 공통 : 기간 조회 공통 스크립트 개발 및 기획서 작성- 기여도 100%<br>
2. 메인 : 대시보드 구현 및 휴가자 캘린더 구현 - 기여도 100%<br>
3. 회계 전표 : fetch API를 활용한 리스트 조회 구현, 서브 리스트 구현 - 기여도 100%<br>
4. 로그인 : Spring Security config 수정 개발 및 권한별 메뉴 접근 설정 - 기여도 40%<br>
5. 전자결재 : 결재수신함 통합 리스트 구현(View Union ALL 쿼리) - 기여도 10%<br>

<h3>주요 화면</h3>
[1] 로그인<br>

![로그인](https://user-images.githubusercontent.com/102308415/201522176-3e8359d2-4002-4074-84a0-b22a4e70be31.png)<br>

[2] Main Dashboard<br>
<img width="1170" alt="스크린샷 2022-11-06 오후 5 47 48" src="https://user-images.githubusercontent.com/102308415/200162016-da469d67-8cfc-403a-a964-d4fae3b0163f.png"><br>

[3] 인사관리(급여(승진)관리)<br>
![급여(승진) 관리](https://user-images.githubusercontent.com/102308415/201522206-bbeb391d-8071-4252-8611-27a4a31c190f.jpeg)<br>

[4] 회계 전표<br>
![회계전표_조회_221112](https://user-images.githubusercontent.com/102308415/201522075-69564dc7-53ba-4f48-8143-9120f944c369.png)<br>

[5] 전자결재(지출결의서)<br>
![결재수신함_지출결의서 상세](https://user-images.githubusercontent.com/102308415/201522221-e17aa226-f447-410d-a9eb-da0d7d2cf2f8.png)<br>

[6] 전자결재(휴가신청서)<br>
![휴가신청서](https://user-images.githubusercontent.com/102308415/201522243-6d7fa1fe-615a-4710-b0ef-2b7896a1230c.png)<br>

<h3>ERD</h3>
![v1 0_ERPERD_220812](https://user-images.githubusercontent.com/102308415/203071563-e62bb85d-c8a7-40b8-8316-30adee93c40d.png)<br>
<br>
- 본부, 부서, 직급을 테이블로 나누어 코드 관리를 할 수 있도록 하여 추후 추가/미사용 처리 가능하도록 확장성 고려<br>
- 회원 테이블의 emp_id를 기준으로 급여 이체, 전자결재 상신 데이터가 생성되도록 설계.<br>
- 회계전표는 지출결의서 상신 → 결재자의 결재 ‘승인’ 처리 시, 등록되며 전표 리스트 출력을 위해 INNER JOIN 사용<br>
- 결재 수신함은 ‘결재자’에게 작성된 지출결의서, 휴가신청서가 보여져야하므로 UNION ALL 할 수 있도록 View 테이블 생성<br>
