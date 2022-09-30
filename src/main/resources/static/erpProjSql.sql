-- db
create database erpprojectdb;


-- 사원정보2 // 제일먼저해야함
CREATE TABLE `erpprojectdb`.`emp_table` (
  `emp_id` VARCHAR(100) NOT NULL,
  `pw` VARCHAR(100) NOT NULL,
  `emp_name` VARCHAR(100) NOT NULL,
  `tel` VARCHAR(50) NOT NULL,
  `idp_num` VARCHAR(20) NOT NULL,
  `birth` VARCHAR(8) NOT NULL,
  `hire_date` DATE NOT NULL,
  `res_date` DATE NOT NULL,
  `salary` INT NOT NULL,
  `wage` INT NOT NULL,
  `res_yn` VARCHAR(4) NOT NULL,
  `vct_yn` VARCHAR(4) NOT NULL,
  `filename` VARCHAR(300) NOT NULL,
  `filepath` VARCHAR(300) NOT NULL,
  `filesize` INT NOT NULL,
  `dep_no` VARCHAR(50) NOT NULL,
  `tot_lev` INT NOT NULL,
  `use_lev` INT NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `bankname` VARCHAR(100) NOT NULL,
  `account` VARCHAR(100) NOT NULL,
  `hq_code` VARCHAR(200) NOT NULL,
  `job_code` VARCHAR(100) NOT NULL,
  `bank_code` VARCHAR(100) NOT NULL,
  `auth_code` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`emp_id`));

-- 승진내역관리 , 노랑표
CREATE TABLE `erpprojectdb`.`prohistory_table` (
  `pro_num` INT NOT NULL,
  `emp_id` VARCHAR(100) NOT NULL,
  `job_code` INT NOT NULL,
  `pro_date` DATE NOT NULL,
  PRIMARY KEY (`pro_num`),
  INDEX `emp_id_idx` (`emp_id` ASC) VISIBLE,
    FOREIGN KEY (`emp_id`)
    REFERENCES `erpprojectdb`.`emp_table` (`emp_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

--  권한테이블
CREATE TABLE `erpprojectdb`.`auth_table` (
  `auth_code` VARCHAR(100) NOT NULL,
  `auth_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`auth_code`));

-- 메뉴테이블
CREATE TABLE `erpprojectdb`.`menu_table` (
  `hr` VARCHAR(100) NOT NULL,
  `ac` VARCHAR(100) NOT NULL,
  `nt` VARCHAR(100) NOT NULL,
  `mp` VARCHAR(100) NOT NULL,
  `ec` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`hr`));



-- 휴가신청

CREATE TABLE `erpprojectdb`.`lev_table` (
  `lev_num` INT NOT NULL,
  `emp_id` VARCHAR(100) NOT NULL,
  `appr` VARCHAR(50) NOT NULL,
  `appr_yn` VARCHAR(4) NOT NULL,
  `appl_date` DATE NOT NULL,
  `lev_type` VARCHAR(50) NOT NULL,
  `lev_res` VARCHAR(200) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `lev_count` INT NOT NULL,
  `rej_res` VARCHAR(2000) NULL,
  PRIMARY KEY (`lev_num`),
  INDEX `emp_id_idx` (`emp_id` ASC) VISIBLE,
    FOREIGN KEY (`emp_id`)
    REFERENCES `erpprojectdb`.`emp_table` (`emp_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- 급여지급이력
CREATE TABLE `erpprojectdb`.`payrollhistory` (
  `emp_id` VARCHAR(100) NOT NULL,
  `serial_no` VARCHAR(200) NOT NULL,
  `tax` INT NOT NULL,
  `Meal_exp` INT NOT NULL,
  `trn_exp` INT NOT NULL,
  `wel_exp` INT NOT NULL,
  `act_wage` INT NOT NULL,
  `paymdate` DATE NOT NULL,
  `salary` INT NOT NULL,
  `wage` INT NOT NULL,
  PRIMARY KEY (`emp_id`),
  FOREIGN KEY (`emp_id`) REFERENCES `emp_table` (`emp_id`));


-- 본부코드
CREATE TABLE `erpprojectdb`.`hdqrt_code` (
  `hq_code` VARCHAR(200) NOT NULL,
  `hq_name` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`hq_code`),
  UNIQUE INDEX `hq_code_UNIQUE` (`hq_code` ASC) VISIBLE);

-- 직급코드
CREATE TABLE `erpprojectdb`.`pstn_code` (
  `job_code` VARCHAR(100) NOT NULL,
  `job_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`job_code`),
  UNIQUE INDEX `job_code_UNIQUE` (`job_code` ASC) VISIBLE);

-- 부서코드

CREATE TABLE `erpprojectdb`.`dep_code` (
  `dep_no` VARCHAR(50) NOT NULL,
  `dep_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`dep_no`));


-- <지출 결의 정보>
CREATE TABLE `erpprojectdb`.`expreport` (
  `exp_num` INT NOT NULL AUTO_INCREMENT,
  `emp_id` VARCHAR(100) NOT NULL,
  `appl_date` DATE NOT NULL,
  `use_date` DATE NOT NULL,
  `maj_code` VARCHAR(20) NOT NULL,
  `det_code` VARCHAR(20) NOT NULL,
  `expense` INT NOT NULL,
  `appr_yn` VARCHAR(4) NOT NULL,
  `appr_date` VARCHAR(8) NOT NULL,
  `appr` VARCHAR(20) NOT NULL,
  `remk` VARCHAR(2000) NULL,
  `rej_res` VARCHAR(2000) NULL,
  `att_file` VARCHAR(300) NOT NULL,
  `att_filepath` VARCHAR(300) NOT NULL,
  `att_filesize` INT NOT NULL,
  PRIMARY KEY (`exp_num`),
  UNIQUE INDEX `exp_num_UNIQUE` (`exp_num` ASC) VISIBLE,
  UNIQUE INDEX `emp_id_UNIQUE` (`emp_id` ASC) VISIBLE,
    FOREIGN KEY (`emp_id`)
    REFERENCES `erpprojectdb`.`emp_table` (`emp_id`));





-- <공지사항>
CREATE TABLE `erpprojectdb`.`notice` (
  `ntc_num` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `emp_id` VARCHAR(100) NOT NULL,
  `date` DATE NOT NULL,
  `contents` VARCHAR(50) NOT NULL,
  `del_yn` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`ntc_num`),
  UNIQUE INDEX `emp_id_UNIQUE` (`emp_id` ASC) VISIBLE,
    FOREIGN KEY (`emp_id`)
    REFERENCES `erpprojectdb`.`emp_table` (`emp_id`));





-- <계정정보>
CREATE TABLE `erpprojectdb`.`acctinfo` (
  `maj_code` VARCHAR(20) NOT NULL,
  `det_code` VARCHAR(20) NOT NULL,
  `det_name` VARCHAR(100) NOT NULL,
  `det_cont` VARCHAR(2000) NOT NULL,
  `imp_cls` VARCHAR(1) NOT NULL,
  `use_yn` VARCHAR(1) NOT NULL,
 UNIQUE INDEX `maj_code_UNIQUE` (`maj_code` ASC) VISIBLE,
 UNIQUE INDEX `det_code_UNIQUE` (`det_code` ASC) VISIBLE,
  PRIMARY KEY (`maj_code`, `det_code`));



--  계정정보 선행되어야함 <계정금액정보> 
CREATE TABLE `erpprojectdb`.`acctamt` (
  `stat_num` INT NOT NULL AUTO_INCREMENT,
  `maj_code` VARCHAR(20) NOT NULL,
  `det_code` VARCHAR(20) NOT NULL,
  `date` DATE NOT NULL,
  `ord_num` VARCHAR(20) NOT NULL,
  `expense` INT NOT NULL,
  `remk` VARCHAR(2000) NULL,
  `man_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`stat_num`),
	FOREIGN KEY (`maj_code`)
    REFERENCES `erpprojectdb`.`acctinfo` (`maj_code`),
	FOREIGN KEY (`det_code`)
    REFERENCES `erpprojectdb`.`acctinfo` (`det_code`));


-- 권한 부서 직급 본부 네개 샘플데이터

INSERT INTO `erpprojectdb`.`auth_table` (`auth_code`, `auth_name`) VALUES ('SJAU_0001', '직원');
INSERT INTO `erpprojectdb`.`auth_table` (`auth_code`, `auth_name`) VALUES ('SJAU_0002', '임원');
INSERT INTO `erpprojectdb`.`auth_table` (`auth_code`, `auth_name`) VALUES ('SJAU_0003', '인사담당자');
INSERT INTO `erpprojectdb`.`auth_table` (`auth_code`, `auth_name`) VALUES ('SJAU_0004', '회계담당자');
INSERT INTO `erpprojectdb`.`auth_table` (`auth_code`, `auth_name`) VALUES ('SJAU_0005', '시스템관리자');



INSERT INTO `erpprojectdb`.`hdqrt_code` (`hq_code`, `hq_name`) VALUES ('SJHQ_0001', 'HR본부');
INSERT INTO `erpprojectdb`.`hdqrt_code` (`hq_code`, `hq_name`) VALUES ('SJHQ_0002', 'ICT개발본부');
INSERT INTO `erpprojectdb`.`hdqrt_code` (`hq_code`, `hq_name`) VALUES ('SJHQ_0003', '솔루션사업본부');


INSERT INTO `erpprojectdb`.`pstn_code` (`job_code`, `job_name`) VALUES ('SJPS_0001', '사원');
INSERT INTO `erpprojectdb`.`pstn_code` (`job_code`, `job_name`) VALUES ('SJPS_0002', '대리');
INSERT INTO `erpprojectdb`.`pstn_code` (`job_code`, `job_name`) VALUES ('SJPS_0003', '과장');
INSERT INTO `erpprojectdb`.`pstn_code` (`job_code`, `job_name`) VALUES ('SJPS_0004', '팀장');
INSERT INTO `erpprojectdb`.`pstn_code` (`job_code`, `job_name`) VALUES ('SJPS_0005', '부장');
INSERT INTO `erpprojectdb`.`pstn_code` (`job_code`, `job_name`) VALUES ('SJPS_0006', '상무');
INSERT INTO `erpprojectdb`.`pstn_code` (`job_code`, `job_name`) VALUES ('SJPS_0007', '전무');
INSERT INTO `erpprojectdb`.`pstn_code` (`job_code`, `job_name`) VALUES ('SJPS_0008', '부대표');
INSERT INTO `erpprojectdb`.`pstn_code` (`job_code`, `job_name`) VALUES ('SJPS_0009', '대표');


INSERT INTO `erpprojectdb`.`dep_code` (`dep_no`, `dep_name`) VALUES ('SJDP_0001', '경영관리부');
INSERT INTO `erpprojectdb`.`dep_code` (`dep_no`, `dep_name`) VALUES ('SJDP_0002', '솔루션개발부');
INSERT INTO `erpprojectdb`.`dep_code` (`dep_no`, `dep_name`) VALUES ('SJDP_0003', 'SI개발부');
INSERT INTO `erpprojectdb`.`dep_code` (`dep_no`, `dep_name`) VALUES ('SJDP_0004', '영업부');
INSERT INTO `erpprojectdb`.`dep_code` (`dep_no`, `dep_name`) VALUES ('SJDP_0005', '전략기획부');
INSERT INTO `erpprojectdb`.`dep_code` (`dep_no`, `dep_name`) VALUES ('SJDP_0006', '인사관리부');

