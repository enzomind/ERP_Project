//기간 조회 공통 처리 함수
function defaultPeriodSet(location) {

    //날짜 객체 생성
    const instantDate = new Date();

    const year = instantDate.getFullYear();
    const month = instantDate.getMonth() + 1;
    let sDate = instantDate.getDate() - 7;
    let eDate = instantDate.getDate();

    //기간조회 시작일이 0이라면 당월 1일 ~ 당월 7일로 설정
    if (sDate <= 0) {
        sDate = 1
        eDate = 7
    }

    //YYYY-MM-DD 형식으로 포맷
    const formatSDate = year + "-" + (("00" + month.toString()).slice(-2)) + "-" + (("00" + sDate.toString()).slice(-2));
    const formatEDate = year + "-" + (("00" + month.toString()).slice(-2)) + "-" + (("00" + eDate.toString()).slice(-2));

    //기간 설정 후, location 값 변경없이 gateway 함수 호출
    gateway(formatSDate, formatEDate, location);
}

//유입 경로 별 호출 경로 설정하는 함수
function gateway(sDate, eDate, location) {

    switch (location) {
        case 'acc' :
            payInfo(sDate, eDate);
            break;

        case 'employee' :

            break;
    }

}