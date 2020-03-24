package dataStructrue.DataStructureInJavaChinese.sparseArray;

public class NotSparseArrayException extends Exception {
    public NotSparseArrayException() {
        super("NotSparseArrayException{ This array may be not sparse. 这个数组可能不是稀疏数组。}");
    }

    public NotSparseArrayException(String message) {
        super(message);
    }
}
