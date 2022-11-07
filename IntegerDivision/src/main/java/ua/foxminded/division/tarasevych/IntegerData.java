package ua.foxminded.division.tarasevych;

import java.util.ArrayList;
import java.util.List;

public class IntegerData {
    private int dividend;
    private int divider;
    private int result;
    private List<String> buildList = new ArrayList<>();

    public List<String> getBuildList() {
        return buildList;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivider() {
        return divider;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
