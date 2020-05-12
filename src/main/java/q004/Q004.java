package q004;

/**
 * Q004 ソートアルゴリズム
 *
 * ListManagerクラスをnewして、小さい順に並び変えた上でcheckResult()を呼び出してください。
 *
 * 実装イメージ:
 * ListManager data = new ListManager();
 * // TODO 並び換え
 * data.checkResult();
 *
 * - ListManagerクラスを修正してはいけません
 * - ListManagerクラスの dataList を直接変更してはいけません
 * - ListManagerクラスの比較 compare と入れ替え exchange を使って実現してください
 */
public class Q004 {
	public static void main(String[] args) {
		ListManager data = new ListManager();

		for (int j = 0; j < data.size(); j++) {
		    for (int i = 0; i < data.size(); i++) {
		    	//比較結果を代入
	            int result = data.compare(i, i+1);
                //後ろの数字が大きい場合、順番を入れ替える
	            if(result == 1) {
	    	        data.exchange(i, i+1);
	            }
		    }
		}
		//結果を表示
		data.checkResult();
	}
}
// 完成までの時間: 1時間 20分