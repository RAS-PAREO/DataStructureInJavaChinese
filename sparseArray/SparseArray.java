/**
 * SparseArray类用于整数稀疏数组与整数二维数组的转换
 * <p>
 * 构造方法：
 * 1、SparseArray() => 创建SparseArray对象
 * 2、SparseArray(int[][] ints) => 创建带有一个二维数组的SparseArray对象
 * <p>
 * 成员方法：
 * 1、toSparseArr() => 将ints数组转换为稀疏数组，返回稀疏数组spareArr
 * 思路：a.循环嵌套，遍历读取ints[i][j]数组的行列数ij。
 * b.将得到的有效数值存入effective[][]，用sum记录有效数值的总数,用ii[]jj[]分别记录有效数值的行和列
 * 因for的作用域，需要a接受i行数，b接受j列数。
 * c.根据a，b，sum创建输出数组sparseArr[sum + 1][3]。
 * d.给sparseArr[0]行赋值，[0][0]为ints行数i，[0][1]为ints列数j，[0][2]为有效数值数sum。
 * e.for循环将二维数组ints的信息录入稀疏数组sparseArr；
 * 将ii集合中的有效值行数录入sparseArr[n][0]；
 * 将jj集合中的有效值列数录入sparseArr[n][1]。
 * 将effective集合中的有效值录入sparseArr[n][2]；
 * f.返回稀疏数组sparseArr。
 * <p>
 * 2、backToArray(int[][] sparseArr) => 将sparseArr转换成原二维数组nInts，返回nInts
 * 思路：a.创建sparseArr[0][0] * sparseArr[0][1]的二维数组nInts.
 * b.循环，将sparseArr[n][2]赋值给nInts[ sparseArr[n][0] ][ sparseArr[n][1] ] (n > 1).
 * c.返回原二维数组nInt。
 * <p>
 * 3、arrPrint(int[][] ints) => 用于打印遍历二维数组
 * 思路：循环嵌套打印
 * <p>
 * <p>
 * Test类用来测试本类方法
 **/

package dataStructrue.DataStructureInJavaChinese.sparseArray;

import java.util.ArrayList;

public class SparseArray {
    private int[][] ints;

    // 构造方法：
    // 1、SparseArray() -> 创建SparseArray对象
    public SparseArray() {
    }

    // 2、SparseArray(int[][] ints) -> 创建带有一个二维数组的SparseArray对象
    public SparseArray(int[][] ints) {
        this.ints = ints;
    }


    public int[][] getInts() {
        return ints;
    }

    public void setInts(int[][] ints) {
        this.ints = ints;
    }


    // 成员方法：
    // 1、toSparseArr() -> 将ints数组转换为稀疏数组，返回稀疏数组spareArr
    public int[][] toSparseArr() {

        //新建三个集合，用来接收原数组信息
        //effective集合接收有效值
        var effective = new ArrayList<Integer>();
        //ii集合接收每个有效值对应的行序号i
        var ii = new ArrayList<Integer>();
        //jj集合接收每个有效值对应的列序号j
        var jj = new ArrayList<Integer>();

        //a,b用以接收原数组的总行数(i + 1)和总列数(j + 1)
        int a = 0;
        int b = 0;

        // a.循环嵌套，遍历读取ints[i][j]数组的行列数i,j。
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (ints[i][j] != 0) {

                    // b.将得到的有效数值存入effective[][]，用sum记录有效数值的总数,用ii[]jj[]分别记录有效数值的行和列
                    effective.add(sum, ints[i][j]);
                    ii.add(sum, i);
                    jj.add(sum, j);

                    sum++;
                }

                // 因for的作用域，需要a接受(i + 1)行数，b接受(j + 1)列数。
                a = i + 1;
                b = j + 1;
            }
        }

        // c.根据a，b，sum创建输出数组out[sum + 1][3]。
        var sparseArr = new int[sum + 1][3];

        // d.给sparseArr[0]行赋值，[0][0]为ints行数i，[0][1]为ints列数j，[0][2]为有效数值数sum。
        sparseArr[0][0] = a;
        sparseArr[0][1] = b;
        sparseArr[0][2] = sum;
        int num = 0;

        // e.for循环将二维数组ints的信息录入稀疏数组sparseArr；
        for (int n = 1; n < sparseArr.length; n++) {

            //将ii数组中的有效值行数录入sparseArr[n][0]；
            sparseArr[n][0] = ii.get(num);
            //将jj数组中的有效值列数录入sparseArr[n][1]。
            sparseArr[n][1] = jj.get(num);
            //将effective数组中的有效值录入sparseArr[n][2]；
            sparseArr[n][2] = effective.get(num);
            num++;
        }

        // f.返回稀疏数组sparseArr。
        return sparseArr;
    }
    // 2、backToArray(int[][] sparseArr) -> 将sparseArr转换成原二维数组nInts，返回nInts
    public int[][] backToArray(int[][] sparseArr) {

        // a.创建sparseArr[0][0] * sparseArr[0][1]的二维数组nInts.
        int[][] nInts = new int[sparseArr[0][0]][sparseArr[0][1]];

        int jj = 0;
        int maxJ = 0;

        try {
            //NotSparseArray异常：这个二维数组有一行的元素数length>3，则这不是一个稀疏数组，抛出异常
            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < sparseArr[i].length; j++) {
                    jj = j + 1;
                }
                if(maxJ < jj) maxJ = jj;
            }
            if (maxJ >= 5) {
                throw new NotSparseArrayException();
            }
        } catch (NotSparseArrayException e) {
            System.out.println(e);
        } finally {
            // b.循环，将sparseArr[n][2]赋值给nInts[ sparseArr[n][0] ][ sparseArr[n][1] ] (n > 1).
            for (int i = 1; i < sparseArr.length; i++) {
                nInts[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }

            // c.返回原二维数组nInt。
            return nInts;
        }

    }

    // 3、arrPrint(int[][] ints) => 用于打印遍历二维数组
    public void arrPrint(int[][] ints) {
        //循环嵌套打印数组
        //第一个循环遍历每行，i为行数
        for (int i = 0; i < ints.length; i++) {

            //打印“[”作为每行数组的开头
            System.out.print("[");

            //第二个循环遍历i行中的每个元素，j最大值是列数和每行的元素数减一(ints[i].length - 1)
            for (int j = 0; j < ints[i].length; j++) {
                //每行除最后一个ints[i][ints[i].length - 1]以外，每个元素前有一个“ ”，后接一个“,”
                if (j < (ints[i].length - 1)) {
                    System.out.print(" " + ints[i][j] + ",");
                } else {
                    //每行最后一个元素ints[i][ints[i].length - 1]前有一个“ ”，后接一个“ ”
                    System.out.print(" " + ints[i][j] + " ");
                }
            }

            //打印“]”作为每行数组的结尾
            System.out.println("]");
        }
    }
}
