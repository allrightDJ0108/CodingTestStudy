package src.Functions;

import java.io.*;
import java.util.Scanner;

public class ClockAngle {
    // 시침과 분침 사이의 각도

    public static void main(String[] args) throws IOException {
        int hour = 3;
        int minute = 32;
        Double ret = clockAngle(hour, minute);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("시침과 분침 사이 각도는 " + ret + " 입니다.");
    }

    // 중력 작용 함수
    static Double clockAngle(int hour, int minute) {
        double h = (int)(30 * hour + 0.5 * minute);
        double m = 6 * minute;

        double ans = Math.abs(m - h);
        if (ans > 180) ans = 360 - ans;

        return ans;
    }
}
