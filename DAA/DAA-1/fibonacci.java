   public static int fibo(int n)
    {
        if(n <= 1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    public static void main(String[] args){
       int n = 5;
        for(int i=0;i<n;i++){
            System.out.print(fibo(i) + " ");
        }
    }

// non -recursive
    public static void main(String[] args){
        int n = 10;
        int first = 0, second = 1;

        for(int i=2; i<n;i++){
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
    }
