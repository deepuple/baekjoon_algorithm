import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];
        int[] count = new int[8001];

        int sum = 0, min = -4001, max = 4001, countMax = 0, diff = 0;

        for (int i = 0; i < n; ++i) {
            inputs[i] = Integer.parseInt(br.readLine());

            if (inputs[i] < 0) {
                count[inputs[i] + 8001]++;
                if (countMax == 0)
                    countMax = count[inputs[i] + 8001];
                else {
                    if (countMax < count[inputs[i] + 8001])
                        countMax = count[inputs[i] + 8001];
                }
            } else {
                count[inputs[i]]++;
                if (countMax == 0)
                    countMax = count[inputs[i]];
                else {
                    if (countMax < count[inputs[i]])
                        countMax = count[inputs[i]];
                }
            }

            sum += inputs[i];

            if (min == -4001)
                min = inputs[i];
            else {
                if (min > inputs[i])
                    min = inputs[i];
            }

            if (max == 4001)
                max = inputs[i];
            else {
                if (max < inputs[i])
                    max = inputs[i];
            }

            if (min == max)
                diff = 0;
            else {
                if (min < 0)
                    diff = Math.abs(min) + max;
                else
                    diff = Math.abs(max - min);
            }

        }

        Arrays.sort(inputs);

        boolean isSecond = false;
        int countIdx = 0, mostIdx = 0;
        for (int j = 0; j < n; ) {
            if (inputs[j] < 0)
                countIdx = inputs[j] + 8001;
            else
                countIdx = inputs[j];

            if (isSecond && count[countIdx] == countMax) {
                mostIdx = countIdx;
                break;
            } else {
                if (count[countIdx] == countMax) {
                    isSecond = true;
                    mostIdx = countIdx;
                }
                j += count[countIdx];
            }
        }
        if (mostIdx > 4000)
            mostIdx -= 8001;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString((int) Math.round((double) sum / n)) + "\n");
        bw.write(Integer.toString(inputs[n / 2]) + "\n");
        bw.write(Integer.toString(mostIdx) + "\n");
        bw.write(Integer.toString(diff) + "\n");

        bw.flush();
    }
}


