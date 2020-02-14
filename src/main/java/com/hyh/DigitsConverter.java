package com.hyh;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 数字转换器
 * @author hongyuhao
 * @date 2020-02-14
 */
public class DigitsConverter {

    private char[] letters = new char[26];
    private Map<Integer, char[]> letterMap = new HashMap<>(10);

    /**
     * 初始字符-A
     */
    private static final char INIT_CHAR = 'A';

    /**
     * 数组初始化
     */
    DigitsConverter() {
        for (int i = 0; i < 26; i++) {
            letters[i] = (char)(INIT_CHAR + i);
        }
        char tmpChar = INIT_CHAR - 1;
        for (int i = 2; i < 10; i++) {
            if (i == 7 || i == 9) {
                letterMap.put(i, new char[]{(char)(tmpChar + 1), (char)(tmpChar + 2), (char)(tmpChar + 3), (char)(tmpChar + 4)});
                tmpChar += 4;
            } else {
                letterMap.put(i, new char[]{(char)(tmpChar + 1), (char)(tmpChar + 2), (char)(tmpChar + 3)});
                tmpChar += 3;
            }
        }
    }


    /**
     *
     * @param firstNum
     * @param secondNum
     * @return
     */
    public List<String> combine(Integer firstNum, Integer secondNum) {
        List<String> letterList = new ArrayList<>();
        if (firstNum < 0 || firstNum > 9) {
            letterList.add("first number must between [0,9]");
            return letterList;
        }
        if (secondNum < 0 || secondNum > 9) {
            letterList.add("second number must between [0,9]");
            return letterList;
        }
        char[] firstLetterArray = null != firstNum && null != letterMap.get(firstNum) ? letterMap.get(firstNum) : new char[]{' ', ' ', ' '};
        char[] secondLetterArray = null != secondNum && null != letterMap.get(secondNum) ? letterMap.get(secondNum) : new char[]{' ', ' ', ' '};


        for (char firstLetter : firstLetterArray) {
            for (char secondLetter : secondLetterArray) {
                letterList.add("" + firstLetter + secondLetter);
            }
        }

        return letterList;
    }
}
