import java.util.Arrays;

public class HeapSort {
    public static void heapSort(Integer[] values) {
    	int maxIndex = values.length - 1;
    	heapify(values, maxIndex);
    	while(maxIndex > 0) {
    		swap(values, 0, maxIndex);
    		maxIndex--;
        	trickleDown(values, 0, maxIndex);
    	}
    }
    
    private static void heapify(Integer[] values, int maxIndex) {
    	for(int i = maxIndex; i >= 0; i --) {
    		int parent = i-1/2;
    		if(values[i] < values[parent]) {
    			swap(values, i, parent);
    		}
    		trickleDown(values, i, maxIndex);
    	}
    }
    
    private static void trickleDown(Integer[] values, int index, int maxIndex) {
    	int leftChild = 0;
    	int rightChild = 0;
    	int smallerChild = 0;
    	
    	if(index*2 + 1 <= maxIndex) {
    		leftChild = index*2 + 1;
        	
    	}
    	if(index*2 + 2 <= maxIndex) {
    		rightChild = index*2 + 2;
    	}
    	
    	
    	//Check which child is the smaller one
    	if(rightChild != 0 && leftChild != 0) {
    		if(values[rightChild] < values[leftChild]) {
    			smallerChild = rightChild;
    		}
    		else {
    			smallerChild = leftChild;
    		}
    	}
    	
    	else {
    		if(leftChild != 0) {
    			smallerChild = leftChild;
    		}
    		else if (rightChild != 0) {
    			smallerChild = rightChild;
    		}
    	}
    	
    	//Switch smaller child with parent
    	if(smallerChild != 0 && values[smallerChild] < values[index]) {
    		swap(values, smallerChild, index);
    		trickleDown(values, smallerChild, maxIndex);
    	}
   	}
   
    
    private static void swap(Integer[] values, int index1, int index2) {
    	int temp = values[index1];
    	values[index1] = values[index2];
    	values[index2] = temp;
    }

    public static void main(String[] args) {
        int size = 20;
        Integer[] list = new Integer[size];

        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        
        System.out.println("Unsorted List: " + Arrays.toString(list));
        heapSort(list);
        System.out.println("  Sorted List:" + Arrays.toString(list));
    }
}
