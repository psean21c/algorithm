
# Title: Contiguous Array

    LeetCode 525 (week20) 
    Library: Array & HashMap()

    Given a binary array, 
    Find the maximum length of a contiguous subarray with equal number of 0 and 1.

    
## Example 1:

        
    Input: [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

## Example 2:

    Input: [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

     Note: The length of the given binary array will not exceed 50,000.

## Solution -1

``

    public int findMaxLength(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum[i + 1] = sum[i] - 1;
            } else {
                sum[i + 1] = sum[i] + 1;
            }
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], new ArrayList<>());
            }
            map.get(sum[i]).add(i);
        }
        int answer = 0;
        for (List<Integer> list : map.values()) {
        	int size = list.size();
        	int diff = list.get(size - 1) - list.get(0);
            answer = Math.max(answer, diff);
        }
        return answer;
    }
```

```
## Test Case 1
        nums: 1 1 0 1 1 1 0 0 0 
        sum: 0 1 2 1 2 3 4 3 2 1 
        map: {0=[0], 1=[1, 3, 9], 2=[2, 4, 8], 3=[5, 7], 4=[6]}
        answer: 8

## Test Case 2
        nums: 0 1 1 0 1 1 1 0 
        sum: 0 -1 0 1 0 1 2 3 2 
        map: {0=[0, 2, 4], -1=[1], 1=[3, 5], 2=[6, 8], 3=[7]}
        answer: 4


![leet0](https://cloud.githubusercontent.com/assets/5623445/23183601/996254a2-f84a-11e6-8407-4b092e3c4cd6.PNG)


Closely looking at the diagram, there is a pattern when we have the same number of 0's and 1's.

![leet3](https://cloud.githubusercontent.com/assets/5623445/23184910/83d2630c-f84f-11e6-9d74-a33304a941c1.JPG)

![leet2](https://cloud.githubusercontent.com/assets/5623445/23184911/83d25d1c-f84f-11e6-9763-522c472cd601.JPG)


## Solution -2

``

        if(nums.length==0)return 0;
        int count=0;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count--;
            }
            else {
                count++;
            }
            if(!map.containsKey(count)){
                map.put(count,i);
            }
            else{
                int num=map.get(count);
                if(i-num>max)max=i-num;
            }
        }
        return max;
 ```

The same idea, only different layout for getting the value

```
## Test Case 3

        if(nums.length==0)return 0;
        int count=0;

        nums: 1 1 0 1 1 1 0 0 0 
        answer: 8

        count=1 >>{0=-1, 1=0} key=1,val=0
        count=2 >>{0=-1, 1=0, 2=1} key=2,val=1
        count=1 >>{0=-1, 1=0, 2=1} [2-0]=2
        count=2 >>{0=-1, 1=0, 2=1} [3-1]=2
        count=3 >>{0=-1, 1=0, 2=1, 3=4} key=3,val=4
        count=4 >>{0=-1, 1=0, 2=1, 3=4, 4=5} key=4,val=5
        count=3 >>{0=-1, 1=0, 2=1, 3=4, 4=5} [6-4]=2
        count=2 >>{0=-1, 1=0, 2=1, 3=4, 4=5} [7-1]=6
        count=1 >>{0=-1, 1=0, 2=1, 3=4, 4=5} [8-0]=8

