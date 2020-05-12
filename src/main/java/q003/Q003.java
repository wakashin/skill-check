package q003;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
[出力イメージ]
（省略）
highest=1
I=3
if=2
ignorance=1
（省略）

 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {
	    private static final String SEPARATOR = "(\\s+?|\\.|,|;)";

	    public static void main(String[] args) {

	        // 集計
	        Map<String, Integer> map = new TreeMap<String, Integer>();
            //ファイル読み込み
	        InputStream file = openDataFile();
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
	            String line = String.valueOf(file);
	            while ((line = br.readLine()) != null) {
	                //単語で分割
	            	String[] words = line.split(SEPARATOR);
	                for (String word : words) {
	                    if (!word.isEmpty()) {
	                    	//"I"以外は小文字に変換
	                    	if(word.length() > 1) {
	                    	    word = word.toLowerCase();
	                    	}
	                    	//Mapに追加
	                        if (map.containsKey(word)) {
	                            int count = map.get(word) + 1;
	                            map.put(word, count);
	                        } else {
	                            map.put(word, 1);
	                        }
	                    }
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("ファイルが見つかりませんでした。");
	        } catch (IOException e) {
	            System.out.println("読み取りに失敗しました。");
	        }

	        // 出現数で降順に並べ替え、つづりの長さ最大値取得
	        List<String> list = new ArrayList<String>();
	        int maxLengthOfSpelling = 0;
	        for (String key : map.keySet()) {
	            list.add(key);

	            if (maxLengthOfSpelling < key.length()) {
	                maxLengthOfSpelling = key.length();
	            }
	        }
	        //ソート
	        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

	        // 出力
	        String format = "%-" + maxLengthOfSpelling + "s: %3d";
	        for (String word : list) {
	            int count = map.get(word);
	                System.out.printf(format, word, count);
	                System.out.println();
	        }
	    }

    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q003.class.getResourceAsStream("data.txt");
    }
}
// 完成までの時間: 5時間 0分