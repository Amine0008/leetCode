package arraysAndHashing.twoPointers.run2;

public class FruitIntoBasketsN904 {

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{6,2,1,1,3,6,6}));
    }
    public static int  totalFruit(int[] fruits) {
        int firstType = fruits[0];
        int secondType = -1;
        int left = 0;
        int right = 1;
        int newL = 0;
        int result = 0;
        while (right < fruits.length) {
            if(secondType == -1) {
                if(fruits[right] == firstType){
                    newL = right;
                    result = Math.max(right-left+1,result);
                    right++;
                }
                else{
                    secondType = fruits[right];
                    result = Math.max(right-left+1,result);
                    right++;
                }
            }
            else if(fruits[right] == firstType){
                newL = right;
                result = Math.max(right-left+1,result);
                right++;
            }
            else if(fruits[right] == secondType) {
                result = Math.max(right-left+1,result);
                right++;
            }
            else {
                int newLeft = right - 1;
                while(fruits[newLeft] == fruits[right - 1] )
                    newLeft--;
                newLeft++;
                left = newLeft;
                firstType = fruits[left];
                secondType = fruits[right];
                //left = newL+1;
                //newL = left;
                result = Math.max(right-left+1,result);
                right++;
            }

        }
        return result;


    }

}
