import java.util.Scanner;
public class Convert {
     public static void main(String[] args) {
        //Declaration and Initiation
        Scanner in=new Scanner(System.in);
        System.out.println("Please choose a system:(D , B , O or H)");
        String arrChoice[]={"D","B","O","H"};
        String choice;
        int decimal=0,Eoctal;String binary,hexadecimal;
        
        //User Choice
            while(true){
                 choice=in.nextLine();
                if(choice.equals("D")||choice.equals("B")||
                    choice.equals("O")||choice.equals("H")){
                break;
                }else{System.out.println(choice+" Is Not Valid!");}
            }
            print();
            
    //if Decimal
        if(choice.equals("D")){
            System.out.println("--You Chose Decimal System--");
            System.out.print("Enter The Decimal Number: ");
            decimal=in.nextInt();            
        }
        
        //if Binary
        if(choice.equals("B")){
            System.out.println("--You Chose Binary System--");
            System.out.println("Enter The Binary Number: ");
            binary=in.nextLine();
            decimal=BinaryToDecimal(binary);
        }
        
        //if Octal
        if(choice.equals("O")){
            System.out.println("--You Chose Octal System--");
            System.out.println("Enter The Octal Number: ");
            Eoctal=in.nextInt();
            decimal=OctalToDecimal(Eoctal);
        }
        
        //if HexaDecimal
        if(choice.equals("H")){
            System.out.println("--You Chose Hexadecimal System--");
            System.out.println("Enter The Hexadecimal Number: ");
            hexadecimal=in.nextLine();
            decimal=HexaToDecimal(hexadecimal);
        }
        DecimalToSystems(decimal);//Print Systems
    }
    /*---------------------------
    Decimal To Any System Methods
    -----------------------------*/
    
    public static String Binary(int Decimal){
        int remainder=0;
        String binary="";
        if(Decimal==0){return "0";}
        while(Decimal>0){
        remainder=Decimal%2;
        binary=remainder+binary;
        Decimal/=2;
        }
    return binary;}
    public static String Hexa(int Decimal){
    String HexaDecimal="";
    if(Decimal==0){HexaDecimal="0";}
        int remainder;
    while(Decimal>0){
        remainder=Decimal%16;
        if(remainder<10){
        HexaDecimal=remainder+HexaDecimal;
        }
        else{
        HexaDecimal=(char)('A'+remainder-10)+HexaDecimal;
        }
        Decimal/=16;
    }
    return HexaDecimal;}
    
    public static String Octal(int Decimal){
    String octal="";
    int remainder;
    if(Decimal==0){octal="0";}
    while(Decimal>0){
    remainder=Decimal%8;
    octal=remainder+octal;
    Decimal/=8;
    }
    return octal;}
    
    /*---------------------------
    Any System To Decimal Methods
    -----------------------------*/
    
    
    public static int BinaryToDecimal(String Binary){
    int decimal=0;
    int power=0;
    for(int i=Binary.length()-1;i>=0;i--){
        if(Binary.charAt(i)=='1'){
            decimal+=Math.pow(2,power);
        }
        power++;
    }
    return decimal;}
    
    
    public static int OctalToDecimal(int Octal){
    int Length=(""+Octal).length();
    int D,decimal=0,power=0;
    for(int i=Length-1;i>=0;i--){
    D=Octal%10;
    decimal+=D*Math.pow(8,power);
    power++;
    Octal/=10;
    }
    return decimal;
    }
    
    
    public static int HexaToDecimal(String Hexa){
    int decimal=0,power=0;
    char NS[]={'0','1','2','3','4','5','6','7',
            '8','9','A','B','C','D','E','F'};
    char Cnumber;
    
    for(int i=Hexa.length()-1;i>=0;i--){
            Cnumber=Hexa.charAt(i);
            for(int j=0;j<NS.length;j++){
                if(Cnumber==NS[j]){
                    decimal+=j*Math.pow(16,power);
                    power++;
                }
            }
        }
    return decimal;}
    
    /*-----------
    Print Methods
    -------------*/
    
    public static void DecimalToSystems(int decimal){
    String binary=Binary(decimal);
            String octal=Octal(decimal); String hexadecimal=Hexa(decimal);
            print();
            printSystems(decimal,binary,hexadecimal,octal);
            print();
    }
    
    
public static void printSystems(int decimal,String binary,String hexa,String octal){
    System.out.println("Decimal\t\tOctal\t\tHexadecimal\tBinary");
    System.out.println(decimal+"\t\t"+octal+"\t\t"+hexa+"\t\t"+binary);
} 

public static void print(){System.out.println("------------"
        + "------------------------------------------------");}
    
    }
