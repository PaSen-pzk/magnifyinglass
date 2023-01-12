package com.posin.common.sort;

import com.posin.common.sort.constant.MatchConstants;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @ClassName : ListSort
 * @Description : 首字符排序
    * 默认顺序为 数字 -> 英文字母 -> 中文字符
 * @Author : ZeKun Pan
 * @Date: 2023-01-12 15:25
 */
public class AlphabeticalSort {

    /***
    * @Title: sortChiAndEng2StringArr
    * @Param: [stringList]
    * @description: 字符串集合排序： 中文在前[拼音首字母正排]，英文在后[首字母正排]
    * @author: Zekun Pan
    * @date: 2023/1/12 15:29
    * @return: java.util.List<java.lang.String>
    * @throws:
    */
    public static List<String> frontCN(List<String> stringList) {
        Collections.sort(stringList, Collator.getInstance(Locale.CHINA));
        List<String> chineseList = match(MatchConstants.CHINESE_REGEX, stringList);
        List<String> englishList = match(MatchConstants.ENGLISH_REGEX, stringList);
        chineseList.addAll(englishList);
        return chineseList;
    }

    public static List<String> match(String regex, List<String> stringList) {
        return stringList.stream().filter(item -> item.substring(0, 1).matches(regex)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String str=  "中国";
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(0,1).matches(MatchConstants.CHINESE_REGEX));
        String str1 = "english";
        System.out.println(str1.substring(0,1).matches(MatchConstants.ENGLISH_REGEX));
        String str2 = "1234";
        System.out.println(str2.substring(0,1).matches(MatchConstants.NUMBER_REGEX));
        List<String> stringList = new ArrayList<>();
        stringList.add("中国");
        stringList.add("english");
        stringList.add("我的");
        stringList.add("abstruct");
        stringList.add("1234");
        stringList.add("大鹅");
        stringList.add("zookeeper");
        Collections.sort(stringList, Collator.getInstance(Locale.CHINA));
        System.out.println(stringList);
    }
}
