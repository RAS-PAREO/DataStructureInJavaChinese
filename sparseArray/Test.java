
package dataStructrue.DataStructureInJavaChinese.sparseArray;

public class Test {
    public static void main(String[] args) throws NotSparseArrayException{
        //创建二维数组ints
        int[][] ints = {{1, 0, 1, 0, 0, 0},
                        {0, 5, 2, 0, 0, 0},
                        {0, 0, 0, 7, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}};
        //创建SparseArray对象，用来调用方法，参数为二维数组ints
        SparseArray sa = new SparseArray(ints);

        //通过sa对象调用arrPrint方法遍历打印数组ints
        sa.arrPrint(ints);

        System.out.println("===========");
        //新建数组m接收toSparseArr方法转换出的稀疏数组
        int[][] m = sa.toSparseArr();
        //通过sa对象调用arrPrint方法遍历打印稀疏数组m
        sa.arrPrint(m);

        System.out.println("===========");
        //新建数组s，接收backToArray方法还原的稀疏数组
        int[][] s = sa.backToArray(m);
        //通过sa对象调用arrPrint方法遍历打印原数组s，s的遍历结果应与ints的遍历结果相同
        sa.arrPrint(s);

        System.out.println("===========");
        sa.backToArray(ints);

    }
}
