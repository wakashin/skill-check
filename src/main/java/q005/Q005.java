package q005;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q005 データクラスと様々な集計
 *
 * 以下のファイルを読み込んで、WorkDataクラスのインスタンスを作成してください。
 * resources/q005/data.txt
 * (先頭行はタイトルなので読み取りをスキップする)
 *
 * 読み込んだデータを以下で集計して出力してください。
 * (1) 役職別の合計作業時間
 * (2) Pコード別の合計作業時間
 * (3) 社員番号別の合計作業時間
 * 上記項目内での出力順は問いません。
 *
 * 作業時間は "xx時間xx分" の形式にしてください。
 * また、WorkDataクラスは自由に修正してください。
 *
[出力イメージ]
部長: xx時間xx分
課長: xx時間xx分
一般: xx時間xx分
Z-7-31100: xx時間xx分
I-7-31100: xx時間xx分
T-7-30002: xx時間xx分
（省略）
194033: xx時間xx分
195052: xx時間xx分
195066: xx時間xx分
（省略）
 */
public class Q005 {
	public static void main(String args[]) {

		List<WorkData> dataList = new ArrayList<>();

		// ファイルを指定
		InputStream file = Q005.class.getResourceAsStream("data.txt");
		// データの読み込み
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file))){
			String line = String.valueOf(file);
			String[] item = null;
			boolean firstLine = true;
			//1行ごとかつ、要素ごとに分解
			while ((line = br.readLine()) != null) {
				if (firstLine) {
					firstLine = false;
				} else {
					item = line.split(",");
					dataList.add(new WorkData(item[0],item[1],item[2],item[3],Integer.parseInt(item[4])));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
		} catch (IOException e) {
			System.out.println("読み取りに失敗しました。");
		}

		//合計時間を計算して出力
        positionSum(dataList);
        pCodeSum(dataList);
        numberSum(dataList);
	}

    private static void positionSum(List<WorkData> dataList) {
        Map<String, Integer> sum = new HashMap<>();
        for(WorkData data : dataList) {
        	//sumに既に入っている役職の場合
            if (sum.containsKey(data.getPosition())) {
            	//時間を加算して再格納
                int num = sum.get(data.getPosition()) + data.getWorkTime();
                sum.put(data.getPosition(), num);
            } else {
                sum.put(data.getPosition(), data.getWorkTime());
            }
        }
        int hour = 0;
        int minute = 0;
        for (Map.Entry<String, Integer> entry : sum.entrySet()) {
            hour = entry.getValue() / 60;
            minute = entry.getValue() % 60;
            System.out.println(entry.getKey() + ": " + hour + "時間" + minute + "分");
        }
    }

    private static void pCodeSum(List<WorkData> dataList) {
        Map<String, Integer> sum = new HashMap<>();
        for(WorkData data : dataList) {
            if (sum.containsKey(data.getPCode())) {
                int num = sum.get(data.getPCode()) + data.getWorkTime();
                sum.put(data.getPCode(), num);
            } else {
                sum.put(data.getPCode(), data.getWorkTime());
            }
        }
        int hour = 0;
        int minute = 0;
        for (Map.Entry<String, Integer> entry : sum.entrySet()) {
            hour = entry.getValue() / 60;
            minute = entry.getValue() % 60;
            System.out.println(entry.getKey() + ": " + hour + "時間" + minute + "分");
        }
    }

    private static void numberSum(List<WorkData> dataList) {
        Map<String, Integer> sum = new HashMap<>();
        for(WorkData data : dataList) {
            if (sum.containsKey(data.getNumber())) {
                int num = sum.get(data.getNumber()) + data.getWorkTime();
                sum.put(data.getNumber(), num);
            } else {
                sum.put(data.getNumber(), data.getWorkTime());
            }
        }
        int hour = 0;
        int minute = 0;
        for (Map.Entry<String, Integer> entry : sum.entrySet()) {
            hour = entry.getValue() / 60;
            minute = entry.getValue() % 60;
            System.out.println(entry.getKey() + ": " + hour + "時間" + minute + "分");
        }
    }
}
// 完成までの時間: 6時間 0分