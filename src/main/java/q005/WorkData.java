package q005;

/**
 * 作業時間管理クラス
 * 自由に修正してかまいません
 */
public class WorkData {
    /** 社員番号 */
    private String number;

    /** 部署 */
    private String department;

    /** 役職 */
    private String position;

    /** Pコード */
    private String pCode;

    /** 作業時間(分) */
    private int workTime;

    public WorkData(String number, String department, String position, String pCode, int workTime) {
        setNumber(number);
        setDepartment(department);
        setPosition(position);
        setPCode(pCode);
        setWorkTime(workTime);
    }

    private void setNumber(String number) {
        this.number = number;

    }

    private void setDepartment(String department) {
        this.department = department;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    private void setPCode(String pCode) {
        this.pCode = pCode;
    }

    private void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public String getNumber(){
        return number;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getPCode() {
        return pCode;
    }

    public int getWorkTime() {
        return workTime;
    }
}
