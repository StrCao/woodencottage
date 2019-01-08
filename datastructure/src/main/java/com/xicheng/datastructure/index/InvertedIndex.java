package com.xicheng.datastructure.index;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * @author xichengxml
 * @date 2019/1/8 20:15
 * 举例，源文件：
 * T0："it is what it is"
 * T1："what is it"
 * T2："it is a banana"
 * 最终索引文件：格式--"关键词": {(文件, 索引位置)}
 * "a":      {(2, 2)}
 * "banana": {(2, 3)}
 * "is":     {(0, 1), (0, 4), (1, 1), (2, 1)}
 * "it":     {(0, 0), (0, 3), (1, 2), (2, 0)}
 * "what":   {(0, 2), (1, 0)}
 */
public class InvertedIndex {

    public static void main(String[] args) {
        Map<String, List<Map<String, Integer>>> indexMap = new HashMap<>();
        for (int i = 1; i < 4; i++) {
            String filePath = "D:\\user\\github\\woodencottage\\datastructure\\src\\main\\resources\\index\\" + i + ".txt";
            indexMap = createIndex(filePath);
        }

        if (MapUtils.isNotEmpty(indexMap)) {
            Iterator<Map.Entry<String, List<Map<String, Integer>>>> iterator = indexMap.entrySet().iterator();
            while (iterator.hasNext()) {
                System.out.println("keyword:" + iterator.next().getKey() + "--index:" + iterator.next().getValue());
            }
        }
    }

    private static Map<String, List<Map<String, Integer>>> createIndex(String filePath) {
        File file = new File(filePath);
        Map<String, List<Map<String, Integer>>> indexMap = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            String[] words = null;
            while (line != null) {
                words = line.split(" ");
            }
            if (ArrayUtils.isNotEmpty(words)) {
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    Map<String, Integer> fileIndex = new HashMap<>();
                    fileIndex.put(filePath, i);
                    if (indexMap.containsKey(word)) {
                        indexMap.get(word).add(fileIndex);
                    }else {
                        List<Map<String, Integer>> fileIndexList = new ArrayList<>();
                        fileIndexList.add(fileIndex);
                        indexMap.put(word, fileIndexList);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return indexMap;
    }
}
