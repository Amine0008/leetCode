package binarySearch;

public class MedianoFTwoSortedArrays {

	//nevermind
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int minOfTwoArrays;
    	int maxOfTwoArrays;
    	if(nums1.length == 0) {
    		minOfTwoArrays = nums2[0];
		    maxOfTwoArrays = nums2[nums2.length-1];
    	}
    	else if(nums2.length == 0) {
    		minOfTwoArrays = nums1[0];
		    maxOfTwoArrays = nums1[nums1.length-1];
    	}
    	else {
    		minOfTwoArrays = Math.min(nums1[0],nums2[0]);
        	maxOfTwoArrays =  Math.max(nums1[nums1.length-1], nums2[nums2.length-1]);
        	
    	}
    	
    	
    	int mergedArrayLength = nums1.length + nums2.length;
    	double minMedian;
    	double maxMedian;
    	if(mergedArrayLength%2 == 0) {
    		minMedian = minOfTwoArrays + (mergedArrayLength / 2) -1;
    		maxMedian = maxOfTwoArrays  -( (mergedArrayLength / 2) -1);
    	}
    	else {
    		minMedian = minOfTwoArrays + (mergedArrayLength / 2);
    		maxMedian = maxOfTwoArrays - (mergedArrayLength / 2);
    	}
    	
    	double mid = 0;
    	double l = minMedian;
    	double r = maxMedian;
    	boolean exist;
    	int counterOfElemntsSupToMidean;
    	while(l <= r) {
    		exist = false;
    		counterOfElemntsSupToMidean = 0;
    		mid = (l+r)/2;
    		if(mergedArrayLength % 2 == 0) {
    			for(int i = 0; i<nums1.length; i++) {
    				if(nums1[i]>mid)
    					counterOfElemntsSupToMidean++;
    				if(counterOfElemntsSupToMidean > mergedArrayLength/2)
    					break;
    			}
				if(counterOfElemntsSupToMidean > mergedArrayLength/2){
					l = mid+1;
					continue;
				}
				for(int i = 0; i<nums2.length; i++) {
					if(nums2[i]>mid)
						counterOfElemntsSupToMidean++;
	   				if(counterOfElemntsSupToMidean > mergedArrayLength/2)
    					break;
				}
   				if(counterOfElemntsSupToMidean > mergedArrayLength/2){
					l = mid+1;
					continue;
				}
   				if(counterOfElemntsSupToMidean == mergedArrayLength/2)
   					return mid;
   				else
   					r = mid-1;
				
    		}else {
    			mid =(int)mid;
    			for(int i = 0; i<nums1.length; i++) {
    				if(nums1[i]>mid)
    					counterOfElemntsSupToMidean++;
    				else if(nums1[i] == mid)
    					exist = true;
    				if(counterOfElemntsSupToMidean > mergedArrayLength/2)
    					break;
    			}
    			if(counterOfElemntsSupToMidean > mergedArrayLength/2) {
    				l = mid+1;
    				continue;
    			}
    			for(int i = 0; i<nums2.length; i++) {
    				if(nums2[i]>mid)
    					counterOfElemntsSupToMidean++;
    				if(nums2[i] == mid)
    					exist = true;
      				if(counterOfElemntsSupToMidean > mergedArrayLength/2)
    					break;
    			}
  				if(counterOfElemntsSupToMidean > mergedArrayLength/2){
  					l =  mid+1;
  					continue;
  				}
  				if(counterOfElemntsSupToMidean == mergedArrayLength/2 && exist)
  					return mid;
  				else
  					r = mid-1;
    			
    				
    		}
    		
    	}
    	return mid;
    		
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

}
