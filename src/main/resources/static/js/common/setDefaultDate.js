function defaultPeriodSet(location) {

    var instantDate = new Date();

    var year = instantDate.getFullYear();
    var month = instantDate.getMonth() + 1;
    var sDate = instantDate.getDate()- 7;
    var eDate = instantDate.getDate();

    if(month == 0){
        year -= 1
        month = (month + 11) % 12
        sDate = new Date(year, month, 0).getDate() //해당 달 마지막 날짜로 세팅
    }

    var formatSDate = year+"-"+(("00"+month.toString()).slice(-2))+"-"+(("00"+sDate.toString()).slice(-2));
    var formatEDate = year+"-"+(("00"+month.toString()).slice(-2))+"-"+(("00"+eDate.toString()).slice(-2));


    console.log("기본빵 " + formatSDate + "부터 " + formatEDate + "까지 기간 조회");

    gateway(formatSDate, formatEDate, location);
}


function gateway(sDate, eDate, location) {

    switch(location) {
        case 'acc' :
            findAccAll(sDate, eDate);
            break;

        case 'employee' :

            break;
    }

}