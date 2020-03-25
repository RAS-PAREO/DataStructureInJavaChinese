# DataStructureInJavaChinese
 These codes are code implementation for data structure in Java. I write them to improve my capacity. I'm new to program and will appreciate your guidance.  
 这些类是我写来实现数据结构的，使用的是Java语言，欢迎各位前来指点或提出修改建议，我会虚心学习，感谢各位的帮助。
 
 一、SparseArray类用于整数稀疏数组与整数二维数组的转换
  <p>
  * 构造方法：<p>
  * 1、SparseArray() => 创建SparseArray对象<p>
  * 2、SparseArray(int[][] ints) => 创建带有一个二维数组的SparseArray对象<p>
  <p>
  * 成员方法：<p>
  * 1、toSparseArr() => 将ints数组转换为稀疏数组，返回稀疏数组spareArr<p>
  * 思路：a.循环嵌套，遍历读取ints[i][j]数组的行列数ij。<p>
  b.将得到的有效数值存入effective[][]，用sum记录有效数值的总数,用ii[]jj[]分别记录有效数值的行和列<p>
  因for的作用域，需要a接受i行数，b接受j列数。<p>
  c.根据a，b，sum创建输出数组sparseArr[sum + 1][3]。<p>
  d.给sparseArr[0]行赋值，[0][0]为ints行数i，[0][1]为ints列数j，[0][2]为有效数值数sum。<p>
  e.for循环将二维数组ints的信息录入稀疏数组sparseArr；<p>
  将ii集合中的有效值行数录入sparseArr[n][0]；<p>
  将jj集合中的有效值列数录入sparseArr[n][1]。<p>
  将effective集合中的有效值录入sparseArr[n][2]；<p>
  f.返回稀疏数组sparseArr。<p>
  <p>
  * 2、backToArray(int[][] sparseArr) => 将sparseArr转换成原二维数组nInts，返回nInts<p>
  * 思路：a.创建sparseArr[0][0] * sparseArr[0][1]的二维数组nInts.<p>
  b.循环，将sparseArr[n][2]赋值给nInts[ sparseArr[n][0] ][ sparseArr[n][1] ] (n > 1).<p>
  c.返回原二维数组nInt。<p>
  <p>
  * 3、arrPrint(int[][] ints) => 用于打印遍历二维数组<p>
  * 思路：循环嵌套打印<p>
  <p>
  <p>
  * Test类用来测试本类方法<p>
