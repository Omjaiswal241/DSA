class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int arr1[]=new int[n];
        int arr2[]=new int[n];
        arr1[0]=nums[0];
        arr2[0]=nums[1];
        int i=2,j=1,k=1;
        while(i<n)
        {
            if(arr1[j-1]>arr2[k-1])
            {
                arr1[j]=nums[i];
                j++;
            }
            else
            {
                arr2[k]=nums[i];
                k++;
            }
            i++;
        } 
        k=0;
        while(j<n)
        {
            arr1[j]=arr2[k];
            j++;
            k++;
        }
        return arr1;
    }
}