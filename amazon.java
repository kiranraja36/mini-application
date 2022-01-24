import java.util.*;

class test {
    private static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Admin.products.add(Admin.list);
        Admin.products.add(Admin.list1);
        Admin.products.add(Admin.list2);
        Admin.products.add(Admin.list3);
        int n=0;
        do{
        System.out.println("1. Admin");
        System.out.println("2. Merchant");
        System.out.println("3. User");
        System.out.println("4. Exit");
        Admin a1 = new Admin();
        Merchant m1 = new Merchant();
        User u1 = new User();
        n = sc.nextInt();
        switch (n) {
            case 1:
                a1.output();
                break;
            case 2:
                m1.output();
                break;
            case 3:
                u1.output();
                break;
            case 4:
                System.exit(0);
                break;
        
            default:
                System.out.println("Invalid");
                break;
            }
        }while(n!=4);
    }
    static void clear(){
        System.out.print("\033[H\033[2J");
    }
}

class Admin{
    static String name;
    static int n=0;
    private static Scanner sc;
    static ArrayList<String> mername =new  ArrayList<String>(Arrays.asList("m","n"));
    static ArrayList<String> merpass =new  ArrayList<String>(Arrays.asList("1","2"));
    static ArrayList<String> approval =new  ArrayList<String>();
    static ArrayList<String> approvalpass =new  ArrayList<String>();
    static ArrayList<String> decline =new  ArrayList<String>();
    static ArrayList<String> username =new  ArrayList<String>(Arrays.asList("u","u1"));
    static ArrayList<String> userpass =new  ArrayList<String>(Arrays.asList("1","2"));
    static String colour[]={"Red","Blue","Green","Yellow"};
    static ArrayList<ArrayList<String>> products = new ArrayList<>();
    static ArrayList<ArrayList<String>> cart = new ArrayList<>();
    static ArrayList<String> list=new ArrayList<>(Arrays.asList("m","Puma","Shoe","10","700"));
    static ArrayList<String> list1=new ArrayList<>(Arrays.asList("n","Adidas","Shoe","5","500"));
    static ArrayList<String> list2=new ArrayList<>(Arrays.asList("m","Samsung","Phone","5","20000"));
    static ArrayList<String> list3=new ArrayList<>(Arrays.asList("n","Nokia","Phone","1","25000"));
    void output(){
        Amazon.clear();
        sc = new Scanner(System.in);
        System.out.println("Enter name and pass");
        String s = sc.next();
        int pass = sc.nextInt();
        if(s.equals("a") && pass==1){
            do{
                Amazon.clear();
                System.out.println("1. Add Merchant");
                System.out.println("2. Approve");
                System.out.println("3. Back");
                n = sc.nextInt();
                switch (n) {
                    case 1:
                        addmerchant();
                    break;
                    case 2:
                        approve();
                    break;
                }
            }while(n!=3);
        }else{
            System.out.println("Invalid");
        }
    }

    static void addmerchant(){
        Amazon.clear();
        System.out.println("Enter Merchant name");
        sc.nextLine();
        name = sc.nextLine();
        approval.add(name);
        System.out.println("Enter new Password");
        String pass = sc.next();
        approvalpass.add(pass);
        Merchant.count++;
    }

    static void approve(){
        Amazon.clear();
        for(int i=Merchant.count-1;i<approval.size() && i>=0;i--){
            System.out.println(approval.get(i));
            System.out.println("Do you want to approve?");
            sc.nextLine();
            String cmt = sc.next();
            if(cmt.equals("yes")){
                mername.add(approval.get(i));
                merpass.add(approvalpass.get(i));
                approval.remove(i);
                approvalpass.remove(i);
                Merchant.count--;
            }else{
                decline.add(approval.get(i));
            }
        }
    }
}

class Merchant{
    private static Scanner sc;
    static int count=0;
    void output(){
        int n=0;
        sc = new Scanner(System.in);
        do{
            Amazon.clear();
            System.out.println("1. New Merchant");
            System.out.println("2. Exsisting Merchant");
            System.out.println("3. Back");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    newmerch();
                    break;
                case 2:
                    exemerch();
                    break;
            
                default:
                    System.out.println("Invalid Option");
                    break;
            }

        }while(n!=3);
    }
    static void newmerch(){
        sc.nextLine();
        Amazon.clear();
        System.out.println("Enter Name");
        String name = sc.nextLine();
        System.out.println("Enter Password");
        String pass = sc.nextLine();
        Admin.approval.add(name);
        Admin.approvalpass.add(pass);
        System.out.println("Please wait for admin approval");
        count++;

    }
    static void exemerch(){
        sc.nextLine();
        Amazon.clear();
        System.out.println("Enter Name");
        String name = sc.nextLine();
        System.out.println("Enter Password");
        String pass = sc.nextLine();
        for(int i=0;i<Admin.mername.size();i++){
            if(Admin.mername.get(i).equals(name) && Admin.merpass.get(i).equals(pass)){
                index(Admin.mername.get(i));
            }else{
                System.out.println("Username and password is invalid");
            }
        }
    }
    static void index(String u){
        int n;
        do{
        Amazon.clear();
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Offer update");
        System.out.println("4. Product review");
        System.out.println("5. Back");
        n = sc.nextInt();
        switch(n){
            case 1:
                addproduct(u);
                break;
            case 2:
                removeproduct(u);
                break;
            case 4:
                productreview(u);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        }while(n!=5);
    }

    static void addproduct(String s){
        Amazon.clear();
        sc.nextLine();
        ArrayList<String> pro_details = new ArrayList<String>();
        pro_details.add(s);
        System.out.println("Enter Brand Name");
        String bname = sc.nextLine();
        pro_details.add(bname);
        System.out.println("Enter Product Name");
        String pname = sc.nextLine();
        pro_details.add(pname);
        System.out.println("Enter Quantity");
        String quantity = sc.nextLine();
        pro_details.add(quantity);
        System.out.println("Enter Price");
        String price = sc.nextLine();
        pro_details.add(price);
        Admin.products.add(pro_details);
        System.out.println(Admin.products);
    }

    static void productreview(String s){
        System.out.println(Admin.products);
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n","S.no","User","Brand","Product","Quantity","Price");
        for(int i=0;i<Admin.products.size();i++){
            System.out.printf("%-10s",i+1);
            for(int j=0;j<5;j++){
                System.out.printf("%-10s",Admin.products.get(i).get(j));
            }
            System.out.print("\n");
        }
        System.out.println("Please enter to continue");
        try {
            System.in.read();
            index(s);
        } catch (Exception e) {
        }
    }

    static void removeproduct(String n){
        sc.nextLine();
        System.out.println("Enter Brand name");
        String bname = sc.nextLine();
        System.out.println("Enter product name");
        String pname = sc.nextLine();
        for(int i=0;i<Admin.products.size();i++){
            if(Admin.products.get(i).get(0).equals(n)){
                //System.out.println(Admin.products.get(i).get(1).contains(bname));
                if(Admin.products.get(i).get(1).equals(bname) && Admin.products.get(i).get(2).equals(pname)){
                    System.out.println("Enter the Quantity");
                    int val = sc.nextInt();
                    sc.nextLine();
                    int res = Integer.parseInt(Admin.products.get(i).get(3))-val;
                    // System.out.println(res);
                    Admin.products.get(i).set(3,String.valueOf(res));
                    break;
                }
            }
        }
        try {
            System.in.read();
            index(n);
        } catch (Exception e) {
        }
    }

}

class User{
    private static Scanner sc;
    static int shirtsum,pantsum;
    void output(){
        sc = new Scanner(System.in);
        int n;
        do{
            Amazon.clear();
            System.out.println("1. New User");
            System.out.println("2. Exsisting User");
            System.out.println("3. Back");
            n = sc.nextInt();
            switch(n){
                case 1:
                    newuser();
                    break;
                case 2:
                    exeuser();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }while(n!=3);
    }

    static void newuser(){
        sc.nextLine();
        Amazon.clear();
        System.out.println("Enter User name");
        String username = sc.nextLine();
        System.out.println("Enter User password");
        String userpass = sc.nextLine();
        Admin.username.add(username);
        Admin.userpass.add(userpass);
        System.out.println("New User Added Successfully");
    }

    static void exeuser(){
        sc.nextLine();
        Amazon.clear();
        System.out.println("Enter User name");
        String username = sc.nextLine();
        System.out.println("Enter User password");
        String userpass = sc.nextLine();
        for(int i=0;i<Admin.username.size();i++){
            if(username.equals(Admin.username.get(i)) && userpass.equals(Admin.userpass.get(i))){
                userlogin(Admin.username.get(i));
            }
        }
    }

    static void userlogin(String u){
        int n;
        System.out.print("\033[H\033[2J");
        do{
        Amazon.clear();
        System.out.println("1. Buy Product");
        System.out.println("2. Cart");
        System.out.println("3. Back");
        n = sc.nextInt();
        switch(n){
            case 1:
                buyproduct(u);
                break;
            case 2:
                cart(u);
                break;
            default:
                System.out.println("Invalid input");
                break;
            }
        }while(n!=3);
    }

    static void buyproduct(String u){
        int n;
        do{
        System.out.println("1. Shoe");
        System.out.println("2. Phone");
        System.out.println("Back");
        n = sc.nextInt();
        switch(n){
            case 1:
                show("Shoe",u);
                break;
            case 2:
                show("Phone",u);
                break;
        }
        }while(n!=3);
    }

    static void show(String s,String u){
        int n;
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<ArrayList<String>> cart1 = new ArrayList<>();
        for(int i=0;i<Admin.products.size();i++){
            if(Admin.products.get(i).get(2).equals(s) && Integer.parseInt(Admin.products.get(i).get(3))>0){
                System.out.println(Admin.products.get(i).get(1)+" "+Admin.products.get(i).get(4));
                temp.add(Admin.products.get(i));
                temp.add(u);
                //cart1.add(temp);
                System.out.println(temp);
                System.out.println(cart1);
            }
            temp.clear();
        }                
        //System.out.println(cart);
        n = sc.nextInt();
        Admin.cart.add(cart1.get(n-1));
        System.out.println("Product Added in cart");
        //System.out.println(Admin.cart);
    }

    static void cart(String u){
        //System.out.println("Model : "+Admin.cart.get(n-1).get(0)+"  Price : "+Admin.products.get(Admin.cartindex).get(3));
        for(int i=0;i<Admin.cart.size();i++){
            //System.out.println(Admin.cart);
            System.out.println("Model : "+Admin.cart.get(i).get(1)+" Price : "+Admin.cart.get(i).get(4));
        }
        System.out.println("Do you want to proceed");
        String r = sc.next();
        if(r.equals("y")){

        }
        try{
            System.in.read();
            userlogin(u);
        }catch(Exception e){

        }
    }
}
