package q002;
import java.util.Map;
import java.util.TreeMap;

/**
 * Q002 並べ替える
 *
 * dataListに "ID,名字" の形式で20個のデータがあります。
 * これをID順に並べて表示するプログラムを記述してください。
 *
 * dataListの定義を変更してはいけません。
 *
 *
[出力結果イメージ]
1,伊藤
2,井上
（省略）
9,清水
10,鈴木
11,高橋
（省略）
20,渡辺
 */
public class Q002 {
    public static void main(String[] args) {
    	//TreeMapは自動でソート
        Map<Integer, String> map = new TreeMap<Integer, String>();
        //カンマの前をkeyに、カンマの後ろをvalueに代入
        for(int i = 0; i < dataList.length; i++) {
          int index = dataList[i].indexOf(",");
          int num = Integer.parseInt(dataList[i].substring(0,index));
          String name = dataList[i].substring(index+1);
          map.put(num, name);
        }
        //keyとvalueを出力
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
        	System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }
    /**
     * データ一覧
     */
    private static final String[] dataList = {
            "8,佐藤",
            "10,鈴木",
            "11,高橋",
            "12,田中",
            "20,渡辺",
            "1,伊藤",
            "18,山本",
            "13,中村",
            "5,小林",
            "3,加藤",
            "19,吉田",
            "17,山田",
            "7,佐々木",
            "16,山口",
            "6,斉藤",
            "15,松本",
            "2,井上",
            "4,木村",
            "14,林",
            "9,清水"
    };
}
// 完成までの時間: 3時間 0分