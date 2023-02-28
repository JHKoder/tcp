package io.github.tcp.network;

import java.util.Arrays;
import java.util.Objects;

public class Host {
    private final int classA;
    private final int classB;
    private final int classC;
    private final int classD;

    public Host(int classA, int classB, int classC, int classD) {
        this.classA = classA;
        this.classB = classB;
        this.classC = classC;
        this.classD = classD;
        valid();
    }

    public static Host from(String ip) {
        int[] arr = Arrays.stream(ip.split("\\.")).mapToInt(Integer::parseInt).toArray();

        return new Host(arr[0], arr[1], arr[2], arr[3]);
    }

    public String toString() {
        return classA + "." + classB + "." + classC + "." + classD;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Host){
            return Objects.equals(this.toString(), obj.toString());
        }
        return false;
    }

    private void valid() {
        validateRange(classA);
        validateRange(classB);
        validateRange(classC);
        validateRange(classD);
    }

    private void validateRange(int address) {
        if (address > 255 || address < 0) {
            throw new IllegalArgumentException("ip index 범위를 벗어 났습니다.");
        }
    }
}
