import java.util.*;

public class Main {

    static int[][] map;
    static int[] camArr;
    static int[] comb;
    static int cols, rows;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        rows = sc.nextInt();
        cols = sc.nextInt();
        map = new int[rows][cols];

        int cnt = 0;

        for(int i = 0 ; i< rows ; i++) {
            for (int j = 0; j < cols; j++) {
                int in = sc.nextInt();
                if(in>0 && in<6)
                    cnt++;
                map[i][j] = in;
            }
        }

        camArr = new int[cnt];
        int camIdx = 0;
        for(int i = 0 ; i< rows ; i++) {
            for (int j = 0; j < cols; j++) {
                int in = map[i][j];
                if(in>0 && in<6) {
                    camArr[camIdx] = in;
                    camIdx++;
                }
            }
        }

        comb = new int[cnt];

        System.out.println(makeComb(cnt-1));
    }

    static int makeComb(int depth){
        int ret = cols*rows;
        if(depth<0)
            return count(map, comb);

        if(camArr[depth]==1) {
            for (int i = 0; i < 4; ++i) {
                comb[depth] = i;
                ret = Math.min(ret, makeComb(depth-1));
            }
        }else if(camArr[depth]==2) {
            for (int i = 0; i < 2; ++i) {
                comb[depth] = i;
                ret = Math.min(ret, makeComb(depth-1));
            }
        }else if(camArr[depth]==3) {
            for (int i = 0; i < 4; ++i) {
                comb[depth] = i;
                ret =  Math.min(ret, makeComb(depth-1));
            }
        }else if(camArr[depth]==4) {
            for (int i = 0; i < 4; ++i) {
                comb[depth] = i;
                ret =  Math.min(ret, makeComb(depth-1));
            }
        }else if(camArr[depth]==5){
            comb[depth] = 0;
            ret = Math.min(ret, makeComb(depth - 1));
        }
        return ret;
    }

    static int count(int[][] map, int[] comb){
        int[][] temp = new int[rows][cols];

        //copy
        for(int i = 0 ; i< rows ; i++) {
            for (int j = 0; j < cols; j++) {
                temp[i][j] = map[i][j];
            }
        }

        int nIdx = 0;
        for(int i = 0 ; i< rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if(temp[i][j]==1){
                    if(comb[nIdx]==0) {
                        int cursor = j;
                        while (temp[i][cursor++]!=6 && cursor < cols){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                    }else if(comb[nIdx]==1) {
                        int cursor = j;
                        while (temp[i][cursor--]!=6 && cursor >= 0 ){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                    }else if(comb[nIdx]==2) {
                        int cursor = i;
                        while (temp[cursor++][j]!=6 && cursor < rows){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                    }else if(comb[nIdx]==3) {
                        int cursor = i;
                        while (temp[cursor--][j]!=6 && cursor >= 0 ){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                    }
                    nIdx++;
                }else if(temp[i][j]==2){
                    if(comb[nIdx]==0) {
                        int cursor = j;
                        while (temp[i][cursor++]!=6 && cursor < cols){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                        cursor = j;
                        while (temp[i][cursor--]!=6 && cursor >= 0 ){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                    }else if(comb[nIdx]==1) {
                        int cursor = i;
                        while (temp[cursor++][j]!=6 && cursor < rows){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                        cursor = i;
                        while (temp[cursor--][j]!=6 && cursor >= 0 ){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                    }
                    nIdx++;
                }else if(temp[i][j]==3){
                    if(comb[nIdx]==0) { //ㄴ
                        int cursor = j;
                        while (temp[i][cursor++]!=6 && cursor < cols){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                        cursor = i;
                        while (temp[cursor++][j]!=6 && cursor < rows){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                    }else if(comb[nIdx]==1) { //ㄱ
                        int cursor = j;
                        while (temp[i][cursor--]!=6 && cursor >= 0 ){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                        cursor = i;
                        while (temp[cursor++][j]!=6 && cursor < rows){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                    }else if(comb[nIdx]==2) { //|-
                        int cursor = j;
                        while (temp[i][cursor++]!=6 && cursor < cols){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                        cursor = i;
                        while (temp[cursor--][j]!=6 && cursor >= 0 ){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                    }else if(comb[nIdx]==3) { //_|
                        int cursor = j;
                        while (temp[i][cursor--] != 6 && cursor >= 0) {
                            if (temp[i][cursor] == 0)
                                temp[i][cursor] = 9;
                        }
                        cursor = i;
                        while (temp[cursor--][j] != 6 && cursor >= 0) {
                            if (temp[cursor][j] == 0)
                                temp[cursor][j] = 9;
                        }
                    }
                    nIdx++;
                }else if(temp[i][j]==4){
                    if(comb[nIdx]==0) { // ㅜ
                        int cursor = j;
                        while (temp[i][cursor++]!=6 && cursor < cols){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                        cursor = i;
                        while (temp[cursor++][j]!=6 && cursor < rows){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                        cursor = j;
                        while (temp[i][cursor--]!=6 && cursor >= 0 ){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                    }else if(comb[nIdx]==1) { //ㅓ
                        int cursor = j;
                        while (temp[i][cursor--]!=6 && cursor >= 0 ){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                        cursor = i;
                        while (temp[cursor++][j]!=6 && cursor < rows){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                        cursor = i;
                        while (temp[cursor--][j]!=6 && cursor >= 0 ){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                    }else if(comb[nIdx]==2) {//ㅗ
                        int cursor = i;
                        while (temp[cursor++][j]!=6 && cursor < rows){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                        cursor = j;
                        while (temp[i][cursor--]!=6 && cursor >= 0 ){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                        cursor = j;
                        while (temp[i][cursor++]!=6 && cursor < cols){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                    }else if(comb[nIdx]==3) {//ㅏ
                        int cursor = i;
                        while (temp[cursor--][j]!=6 && cursor >= 0 ){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                        cursor = j;
                        while (temp[i][cursor++]!=6 && cursor < cols){
                            if(temp[i][cursor]==0)
                                temp[i][cursor]=9;
                        }
                        cursor = i;
                        while (temp[cursor++][j]!=6 && cursor < rows){
                            if(temp[cursor][j]==0)
                                temp[cursor][j]=9;
                        }
                    }
                    nIdx++;
                }else if(temp[i][j]==5){
                    int cursor = i;
                    while (temp[cursor--][j] != 6 && cursor >= 0) {
                        if (temp[cursor][j] == 0)
                            temp[cursor][j] = 9;
                    }
                    cursor = i;
                    while (temp[cursor++][j] != 6 && cursor < rows) {
                        if (temp[cursor][j] == 0)
                            temp[cursor][j] = 9;
                    }
                    cursor = j;
                    while (temp[i][cursor++] != 6 && cursor < cols) {
                        if (temp[i][cursor] == 0)
                            temp[i][cursor] = 9;
                    }
                    cursor = j;
                    while (temp[i][cursor--]!=6 && cursor >= 0 ){
                        if(temp[i][cursor]==0)
                            temp[i][cursor]=9;
                    }
                    nIdx++;
                }
            }
        }

        int cnt = 0;
        for(int i = 0 ; i< rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

