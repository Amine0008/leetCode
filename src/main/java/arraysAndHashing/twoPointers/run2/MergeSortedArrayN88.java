package arraysAndHashing.twoPointers.run2;

public class MergeSortedArrayN88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] holder = new int[m];
        for(int i = 0; i < m; i++){
            holder[i] = nums1[i];
        }
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while(p1 < m || p2 < n){
            if(p1 == m) {
                for(int i = p2 ;i < n; i++){
                    nums1[index] = nums2[i];
                    index++;
                }
                break;
            }
            if(p2 == n){
                for(int i = p1; i < m; i++){
                    nums1[index] = holder[i];
                    index++;
                }
                break;
            }
            if(holder[p1] < nums2[p2]){
                nums1[index] = holder[p1];
                p1++;
            }
            else{
                nums1[index] = nums2[p2];
                p2++;
            }
            index++;
        }

    }
}
