package com.rds.code.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @author lys
 * @className
 * @description
 * @date 2015/4/17
 */
public class StringUtils {
	public static String dateToTen(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

    public static String dateToChineseTen(String datestr) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(datestr);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf1.format(date);
    }

	public static String dateToEight(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	public static String dateToSecond(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String getInitials(String str) {
		String reg = "[\\u4e00-\\u9fa5]+";
		String content = "";
		if (!str.matches(reg)) {
			content = str;
		} else {
			for (int i = 0; i < str.length(); i++) {
				char a = str.charAt(i);
				String[] aa = PinyinHelper.toHanyuPinyinStringArray(a);
				content += aa[0].charAt(0);
			}
		}
		return content;
	}

	static int[] weight = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 }; // 十七位数字本体码权重
	static char[] validate = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' }; // mod11,对应校验码字符值

	public static  char getValidateCode(String id17) {
		int sum = 0;
		int mode = 0;
		for (int i = 0; i < id17.length(); i++) {
			sum = sum + Integer.parseInt(String.valueOf(id17.charAt(i)))
					* weight[i];
		}
		mode = sum % 11;
		return validate[mode];
	}

    public static String complete0(String number,int digit){
        try {
            String decimal = number.split("\\.")[1];
            for (int i = 0; i < digit - decimal.length(); i++) {
                number = number + "0";
            }
        }catch (ArrayIndexOutOfBoundsException e){
            number = number + ".0000";
        }
        return number;
    }

                /**
         * create date:2010-5-22下午03:32:31
         * 描述：将源字符串中的阿拉伯数字格式化为汉字
         * @param sign 源字符串中的字符
         * @return
         */
                public static char formatDigit(char sign){
            if(sign == '0')
            sign = '〇';
            if(sign == '1')
            sign = '一';
            if(sign == '2')
            sign = '二';
            if(sign == '3')
            sign = '三';
            if(sign == '4')
            sign = '四';
            if(sign == '5')
            sign = '五';
            if(sign == '6')
            sign = '六';
            if(sign == '7')
            sign = '七';
            if(sign == '8')
            sign = '八';
            if(sign == '9')
            sign = '九';
            return sign;
            }

                /**
         * create date:2010-5-22下午03:31:51
         * 描述： 获得月份字符串的长度
         * @param str  待转换的源字符串
         * @param pos1 第一个'-'的位置
         * @param pos2 第二个'-'的位置
         * @return
         */
                public static int getMidLen(String str,int pos1,int pos2){
            return str.substring(pos1+1, pos2).length();
            }
        /**
         * create date:2010-5-22下午03:32:17
         * 描述：获得日期字符串的长度
         * @param str  待转换的源字符串
         * @param pos2 第二个'-'的位置
         * @return
         */
                public static int getLastLen(String str,int pos2){
            return str.substring(pos2+1).length();
            }


        /**
         * create date:2010-5-22下午03:32:46
         * 描述：格式化日期
         * @param str 源字符串中的字符
         * @return
         */
                public static String dateToChinese(String str){
            StringBuffer sb = new StringBuffer();
            int pos1 = str.indexOf("-");
            int pos2 = str.lastIndexOf("-");
            for(int i = 0; i < 4; i++){
                sb.append(formatDigit(str.charAt(i)));
                }
            sb.append('年');
            if(getMidLen(str,pos1,pos2) == 1){
                sb.append(formatDigit(str.charAt(5))+"月");
                if(str.charAt(7) != '0'){
                    if(getLastLen(str, pos2) == 1){
                        sb.append(formatDigit(str.charAt(7))+"日");
                        }
                    if(getLastLen(str, pos2) == 2){
                        if(str.charAt(7) != '1' && str.charAt(8) != '0'){
                            sb.append(formatDigit(str.charAt(7))+"十"+formatDigit(str.charAt(8))+"日");
                            }
                        else if(str.charAt(7) != '1' && str.charAt(8) == '0'){
                            sb.append(formatDigit(str.charAt(7))+"十日");
                            }
                        else if(str.charAt(7) == '1' && str.charAt(8) != '0'){
                            sb.append("十"+formatDigit(str.charAt(8))+"日");
                            }
                        else{
                            sb.append("十日");
                            }
                        }
                    }
                else{
                    sb.append(formatDigit(str.charAt(8))+"日");
                    }
                }
            if(getMidLen(str,pos1,pos2) == 2){
                if(str.charAt(5) != '0' && str.charAt(6) != '0'){
                    sb.append("十"+formatDigit(str.charAt(6))+"月");
                    if(getLastLen(str, pos2) == 1){
                        sb.append(formatDigit(str.charAt(8))+"日");
                        }
                    if(getLastLen(str, pos2) == 2){
                        if(str.charAt(8) != '0'){
                            if(str.charAt(8) != '1' && str.charAt(9) != '0'){
                                sb.append(formatDigit(str.charAt(8))+"十"+formatDigit(str.charAt(9))+"日");
                                }
                            else if(str.charAt(8) != '1' && str.charAt(9) == '0'){
                                sb.append(formatDigit(str.charAt(8))+"十日");
                                }
                            else if(str.charAt(8) == '1' && str.charAt(9) != '0'){
                                sb.append("十"+formatDigit(str.charAt(9))+"日");
                                }
                            else{
                                sb.append("十日");
                                }
                            }
                        else{
                            sb.append(formatDigit(str.charAt(9))+"日");
                            }
                        }
                    }
                else if(str.charAt(5) != '0' && str.charAt(6) == '0'){
                    sb.append("十月");
                    if(getLastLen(str, pos2) == 1){
                        sb.append(formatDigit(str.charAt(8))+"日");
                        }
                    if(getLastLen(str, pos2) == 2){
                        if(str.charAt(8) != '0'){
                            if(str.charAt(8) != '1' && str.charAt(9) != '0'){
                                sb.append(formatDigit(str.charAt(8))+"十"+formatDigit(str.charAt(9))+"日");
                                }
                            else if(str.charAt(8) != '1' && str.charAt(9) == '0'){
                                sb.append(formatDigit(str.charAt(8))+"十日");
                                }
                            else if(str.charAt(8) == '1' && str.charAt(9) != '0'){
                                sb.append("十"+formatDigit(str.charAt(9))+"日");
                                }
                            else{
                                sb.append("十日");
                                }
                            }
                        else{
                            sb.append(formatDigit(str.charAt(9))+"日");
                            }
                        }
                    }
                else{
                    sb.append(formatDigit(str.charAt(6))+"月");
                    if(getLastLen(str, pos2) == 1){
                        sb.append(formatDigit(str.charAt(8))+"日");
                        }
                    if(getLastLen(str, pos2) == 2){
                        if(str.charAt(8) != '0'){
                            if(str.charAt(8) != '1' && str.charAt(9) != '0'){
                                sb.append(formatDigit(str.charAt(8))+"十"+formatDigit(str.charAt(9))+"日");
                                }
                            else if(str.charAt(8) != '1' && str.charAt(9) == '0'){
                                sb.append(formatDigit(str.charAt(8))+"十日");
                                }
                            else if(str.charAt(8) == '1' && str.charAt(9) != '0'){
                                sb.append("十"+formatDigit(str.charAt(9))+"日");
                                }
                            else{
                                sb.append("十日");
                                }
                            }
                        else{
                            sb.append(formatDigit(str.charAt(9))+"日");
                            }
                        }
                    }
                }
            return sb.toString();
            }
}
