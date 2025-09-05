package capitulo4.forloop;

public class For {
    public static void main(String args[]){

        for(int i=10; i>1; i--){
            System.out.println("The value of i is: "+i);
        }
        int arr[]={2,11,45,9};
        for(int i=0; i<arr.length; i++){
            System.out.println("For: " + arr[i]);
        }
        for (int num : arr) {
            System.out.println("forEach: " + num);
        }
    }

}
