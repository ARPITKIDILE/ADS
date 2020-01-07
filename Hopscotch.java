import java.util.Scanner;
public class Hopscotch {   
    //main class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of storage");
        int TABLE_SIZE=sc.nextInt();
        int x=prime((TABLE_SIZE/2)-1,TABLE_SIZE);
        int y=prime(x+1,TABLE_SIZE);
        System.out.println("x="+x+"  y="+y);
        int MAX_DIST=2,choice,data,ndx=-1;
        int arr[]=new int[TABLE_SIZE],srr[]=new int[TABLE_SIZE];
        for(int i=0;i<TABLE_SIZE;i++){
            arr[i]=-99;
            srr[i]=0;
        }        
        System.out.println("HOPSCOTCH HASHING");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        do{
            System.out.println("Enter 1.Insertion 2.Deletion 3.Searching 4.Hash Table 5.Search Table 6.Exit");
            choice=sc.nextInt();
            switch(choice){       
            case 1: System.out.println("Enter value to be inserted");
                    data=sc.nextInt();
                    ndx=insertion(data,arr,MAX_DIST,x,y,srr,TABLE_SIZE);
                if(ndx>=0){
                    System.out.println("Insertion done at pos:"+ndx);
                }
                else{
                    System.out.println("Insertion failed");
                }
                break;
            case 2: System.out.println("Enter value to be deleted");
                    data=sc.nextInt();
                    ndx=deletion(data,arr,MAX_DIST,x,y,srr);
                if(ndx>=0){
                    System.out.println("Element deleted");
                }
                else{
                    System.out.println("Deletion failed");
                }
                break;
            case 3: System.out.println("Enter value to be searched");
                    data=sc.nextInt();
                    ndx=search(data,arr,MAX_DIST,x,y);
                if(ndx>=0){
                    System.out.println("Element found at position:"+ndx);
                }
                else{
                    System.out.println("Element not found");
                }
                break;
            case 4: table(arr,TABLE_SIZE);
                    break;
            case 5: searchtable(TABLE_SIZE,srr,arr);
                    break;
       }
      }while(choice!=6);
        
    }
    //method for insertion of elements from hash table
    private static int insertion(int data,int []arr,int MAX_DIST,int x,int y,int []srr,int TABLE_SIZE){
            int key= hashfun(data,x),i;
            for(i=0;i<=MAX_DIST;i++){
                
                if(arr[key+i]==-99){
                    arr[key+i]=data;
                    srr[key+i]=1+i;
                    table(arr,TABLE_SIZE);
                    return key+i;
                }
                
                System.out.println("HASH TABLE IS:");
                System.out.println("");
                System.out.println("LOCATION\tDATA");
                System.out.println("----------------------");
                for(int k=0;k<TABLE_SIZE;k++){
                    if(i<=MAX_DIST && k==key+i){
                    System.out.println(k+"\t\t"+arr[k]+","+data);
                    System.out.println("----------------------");
                    }
                    else{
                    System.out.println(k+"\t\t"+arr[k]);
                    System.out.println("----------------------");
                    }
                }
                
                
        }
        int key1=hashfun(data,y);
        for(i=0;i<=MAX_DIST;i++){
            
            if(arr[i+key1]==-99){
                arr[key1+i]=data;
                srr[key1+i]=MAX_DIST+1+i+1;
                table(arr,TABLE_SIZE);
                return key1+i;
            }
            
            System.out.println("HASH TABLE IS:");
            System.out.println("");
            System.out.println("LOCATION\tDATA");
            System.out.println("----------------------");
            for(int k=0;k<TABLE_SIZE;k++){
                    if(i<=MAX_DIST && k==key1+i){
                    System.out.println(k+"\t\t"+arr[k]+","+data);
                    System.out.println("----------------------");
                    }
                    else{
                    System.out.println(k+"\t\t"+arr[k]);
                    System.out.println("----------------------");
                    }
                }
            
            
        }
        return -1;
    }
    //method for deletion of elements from hash table
    private static int deletion(int data,int []arr,int MAX_DIST,int x,int y,int []srr){
        int key=hashfun(data,x),i;
        for(i=0;i<=MAX_DIST;i++){
            if(arr[key+i]==data){
                arr[key+i]=-99;
                return key+i;
            }
        }
        int key1=hashfun(data,y);
        for(i=0;i<=MAX_DIST;i++){
            if(arr[i+key1]==data){
                arr[key1+i]=-99;
                srr[key1+i]=0;
                return key1+i;
            }
        }
        return -1;
    }
    //method for searching of elements in the hash table
    private static int search(int data,int []arr,int MAX_DIST,int x,int y){
        int key=hashfun(data,x),i;
        for(i=0;i<=MAX_DIST;i++){
            if(arr[i+key]==data){
                return key+i;
            }
        }
        int key1=hashfun(data,y);
        for(i=0;i<=MAX_DIST;i++){
            if(arr[i+key1]==data){
                return key1+i;
            }
       
        }
        return -1;
    }
    //method for computation of hash function
    private static int hashfun(int data,int z){
        return data % z;
    }
    //method to find nearest prime number
    private static int prime(int n,int TABLE_SIZE)
    {   
        if(n<=1){ 
            return 2;
        }
        int prime=n; 
        boolean found=false; 
        while(!found){ 
            prime++; 
            if(isPrime(prime)){ 
                found=true; 
            }
        }
        if(prime>TABLE_SIZE){
            prime=TABLE_SIZE;
        }
        return prime; 
    }
    //method to check nearest prime number
    private static boolean isPrime(int n)  
    {  
        if(n<=1){
            return false;
        }  
        if(n<=3){
            return true;
        }  
        if(n%2==0||n%3==0){
            return false;
        }      
        for(int i=5;i*i<=n;i=i+6){  
            if(n%i==0||n%(i+2)==0){  
                return false;  
            }
        }
        return true;  
    }
    //method for display of hash table
    private static void table(int []arr,int TABLE_SIZE){
        System.out.println("HASH TABLE IS:");
        System.out.println("");
        System.out.println("LOCATION\tDATA");
        System.out.println("----------------------");
        for(int i=0;i<TABLE_SIZE;i++){
            System.out.println(i+"\t\t"+arr[i]);
            System.out.println("----------------------");
        }
    }
    //method to display search table
    private static void searchtable(int TABLE_SIZE,int []srr,int []arr){
        int sum=0;
        System.out.println("SEARCH TABLE IS:");
        System.out.println("");
        System.out.println("DATA\t SEARCH TIME");
        System.out.println("----------------------");
        for(int i=0;i<TABLE_SIZE;i++){
            if(srr[i]!=-99){
                sum+=srr[i];
            }
            System.out.println(arr[i]+"\t\t"+srr[i]);
            System.out.println("----------------------");
        }
        System.out.println("Average search time is="+(double)(sum/(1.0*(TABLE_SIZE))));
        
    }
}
