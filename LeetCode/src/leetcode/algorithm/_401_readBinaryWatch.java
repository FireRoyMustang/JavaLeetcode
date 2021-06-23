package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/6/21 18:22
 *@Version V1.0
 **/
public class _401_readBinaryWatch {
    public static void main(String[] args) {
        _401_readBinaryWatch r = new _401_readBinaryWatch();
//        System.out.println(r.readBinaryWatch(1));
        System.out.println(r.readBinaryWatch(2).size());
//        System.out.println(r.readBinaryWatch(9));
    }
//    二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
//    每个 LED 代表一个 0 或 1，最低位在右侧。
//    例如，下面的二进制手表读取 "3:25" 。
//    给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。
//    你可以 按任意顺序 返回答案。小时不会以零开头：
//    例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。分钟必须由两位数组成，可能会以零开头：
//    例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。

    private static final int OPTIONS = 10;
    private static final byte[] HOURS = {1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    private static final byte[] MINUTES = {0, 0, 0, 0, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> result = new ArrayList<>();
        if (turnedOn >= OPTIONS - 1) {
            return result;
        }
        dfs(turnedOn, 0, result, new Clock());
        return result;
    }

    public void dfs(int turnedOn, int index, List<String> result, Clock time) {
        if (turnedOn == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(time.hours);
            sb.append(":");
            if (time.minutes >= 10) {
                sb.append(time.minutes);
            } else {
                sb.append(0).append(time.minutes);
            }
            result.add(sb.toString());
            return;
        }
        if (index >= OPTIONS) {
            return;
        }
        turnedOn--;
        for (int i = index; i < OPTIONS - turnedOn; i++) {// 还有turnedOn个灯亮着
            int minute = time.minutes + MINUTES[i];
            if (minute >= 60) {
                break;
            }
            int hour = time.hours + HOURS[i];
            if (hour >= 12) {
                continue;
            }
            Clock temp = new Clock(hour, minute);
            dfs(turnedOn, i + 1, result, temp);
        }
    }

    class Clock {
        int hours;
        int minutes;

        public Clock() {
        }

        public Clock(int hours, int minutes) {
            this.hours = hours;
            this.minutes = minutes;
        }
    }
}
