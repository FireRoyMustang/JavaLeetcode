package leetcode;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2020/9/18 15:09
 *@Version V1.0
 **/
public class SingleNumber {
    public static void main(String[] args) {
        int i = 0;
        i <<= 1;
        System.out.println(i);
        System.out.println(2&1);
    }

    public int singleNumber(int[] nums) {//本算法同样适用于数组nums中存在负数的情况
        if (nums.length == 0) return -1;//输入数组长度不符合要求，返回-1;
        int[] bitSum = new int[32];//java int类型有32位，其中首位为符号位
        int res = 0;
        for (int num : nums) {
            int bitMask = 1;//需要在这里初始化，不能和res一起初始化
            for (int i = 31; i >= 0; i--) {//bitSum[0]为符号位
                //这里同样可以通过num的无符号右移>>>来实现，否则带符号右移(>>)左侧会补符号位，对于负数会出错。
                //但是不推荐这样做，最好不要修改原数组nums的数据
                if ((num & bitMask) != 0) bitSum[i]++;//这里判断条件也可以写为(num&bitMask)==bitMask,而不是==1
                bitMask = bitMask << 1;//左移没有无符号、带符号的区别，都是在右侧补0
            }
        }
        for (int i = 0; i < 32; i++) {//这种做法使得本算法同样适用于负数的情况
            res = res << 1;
            res += bitSum[i] % 3;//这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;

//        int ones = 0, twos = 0;
//        for(int num : nums){
//            ones = ones ^ num & ~twos;
//            twos = twos ^ num & ~ones;
//        }
//        return ones;
//
//        作者：jyd
//        链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }


}
