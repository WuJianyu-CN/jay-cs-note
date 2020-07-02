# 1.  前言

## 1.1 刷题方式

用中学里的系统学习方法来刷面试题，有教材，有课后习题，等做完之后再做综合题。刷题过程中要经常做笔记记录自己的学习过程。



1. 先将《剑指 offer》按照章节将例题做完；

2. 然后再到 LeetCode 网站上找对应的标签做十几天道题目。一个标签起码要做十题，对这个章节掌握吸收后再进行下一个章节；

3. 最后，面试前开始刷 LeetCode 上的热题（考前冲刺）。



掌握题目的标准是什么？

* 对一道题目，虽然已经忘记依然有思路，代码可以手打出来，这才叫做掌握。每道题目都要追求把题目吃透，不断地重复，理解解题思路。

刷了一段时间后怎么检测自身的掌握程度？

* 可以参加 LeetCode 的周赛和双周赛，如果能做出前三道，就没有太大问题了，可以去参加面试。



**教材例题（剑指 offer） + 课后习题 （LeetCode》+ 考前冲刺（LeetCode 热题）**



# 2. 剑指 Offer



使用 哈希表

``` Java
class Solution {
    public int findRepeatNumber(int[] nums) {

        if(nums == null){
            return -1;
        }

        Set<Integer> set = new HashSet<>();
        for(var num : nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
```



对原数组进行修改

``` Java
class Solution {
    public int findRepeatNumber(int[] nums) {

        if(nums == null){
            return -1;
        }

        int j;
        int temp;
        for(int i=0;i<nums.length;i++){
            j=nums[i];
            if(i==j){
                continue;
            }else if(j == nums[j]){
                return j;
            }else{
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp; 
            }
        }
        return -1;
    }
}
```

