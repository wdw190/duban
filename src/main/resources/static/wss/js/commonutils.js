function getNewDateByAddDays(originalDate, days) {

	if (originalDate != '') {

		var olddate = new Date(originalDate);
		var newdate = new Date(olddate);

		newdate.setDate(newdate.getDate() + days);

		// 获取年份
		var year = newdate.getFullYear();
		// 获取月份
		var month = newdate.getMonth() + 1;
		// 获取日子
		var day = newdate.getDate();
		// 拼接日期
		var thisDateNew = year + "-" + (month < 10 ? "0" + month : month) + "-"
				+ (day < 10 ? "0" + day : day);
		// 打印日期
		return thisDateNew;
	}else{
		return '';
	}

}