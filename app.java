
import java.util.*;
import java.text.DecimalFormat;;

class login{

}

class patient{
    String pid, disease, sex;
    static String pname;
    int age;
    void new_patient()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("id:-");
        pid = input.nextLine();

        System.out.print("name:-");
        pname = input.nextLine();

        System.out.print("sex:-");
        sex = input.nextLine();

        System.out.print("age:-");
        age = input.nextInt();

        System.out.print("Treatement:-");
        disease = input.nextLine();

        System.out.print("Status:-");
        disease = input.nextLine();

    }
    void patient_info()
    {
    }
    public static String getPatientDetails(){
        return(pname);
    }
}

class doctor{
    String did, dname, specilist, appoint, doc_qual;
    int droom;
    String date;
    String time;
    public void getSchedule(){
        System.out.println("date:"+date+"time"+time);
    } 
    public void addSchedule(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter date");
        date=input.nextLine();
        System.out.println("Enter time");
        time=input.nextLine();
        System.out.println("date:"+date+"time"+time);
    }
    public void deleteSchedule(){
        System.out.println("schedule deleted");
    }
    public void confirmAppointment(){
    }
    void new_doctor()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("id:-");
        did = input.nextLine();

        System.out.print("name:-");
        dname = input.nextLine();

        System.out.print("specilization:-");
        specilist = input.nextLine();

        System.out.print("work time:-");
        appoint = input.nextLine();

        System.out.print("qualification:-");
        doc_qual = input.nextLine();

        System.out.print("room no.:-");
        droom = input.nextInt();

    }
    void doctor_info()
    {
        System.out.println(did + "\t" + dname + "  \t" + specilist + "     \t" + appoint + "    \t" + doc_qual + "       \t" + droom);

    }
}

class staff
{
    String sid, sname, desg, sex;
    int salary;
    void new_staff()
    {
        Scanner input1 = new Scanner(System.in);

        System.out.print("id:-");
        sid = input1.nextLine();

        System.out.print("name:-");
        sname = input1.nextLine();

        System.out.print("desigination:-");
        desg = input1.nextLine();

        System.out.print("sex:-");
        sex = input1.nextLine();

        System.out.print("salary:-");
        salary = input1.nextInt();
    }
    void staff_info()
    {
        System.out.println(sid + "\t" + sname + "\t" + sex + "\t" + salary);
    }
}


class inventory{
    String in_name, in_comp, in_type, exp_date;
    int in_cost, count;
    void new_medi()
    {

        Scanner input = new Scanner(System.in);

        System.out.print("name:-");
        in_name = input.nextLine();

        System.out.print("comp:-");
        in_comp = input.nextLine();

        System.out.print("exp_date:-");
        exp_date = input.nextLine();

        System.out.print("cost:-");
        in_cost = input.nextInt();

        System.out.print("no of unit:-");
        count = input.nextInt();

    }
    void find_in()
    {
        System.out.println(in_name + "  \t" + in_comp + "    \t" + exp_date + "     \t" + in_cost);
    }
}

class TreatementDetails{
    String Treatement;
    int Treatement_cost;
    void new_feci()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("fecility:-");
        Treatement = input.nextLine();

        System.out.print("cost:-");
        Treatement_cost = input.nextInt();

    }

    void feci_list()
    {
        System.out.println(Treatement + "\t\t" + Treatement_cost);

    }
}



// class appointment{
    
// }


// class Accounts{

// }

// class reports{

// }

class billing{
    int b_id;
    String p_name;
    int p_id;
    String item_name;
    int cost; 
    static int staff_id_check;
    static String staff_name_check;
    int staff_id;
    String staff_name;
    static String hospitalName;
    static double dollar, pound, euro, yen,ringgit;


billing(int staff_id,String staff_name){
    staff_id_check=staff_id;
    staff_name_check=staff_name;
}
  

billing(int b_id,String p_name,int p_id,int cost){
    this.b_id=b_id;
    this.p_name=p_name;
    this.p_id=p_id;
    this.cost=cost;
}

public static void calculator(){
    char operator;
    Double number1, number2, result;

    // create an object of Scanner class
    Scanner input = new Scanner(System.in);

    // ask users to enter operator
    System.out.println("Choose an operator: +, -, *, or /");
    operator = input.next().charAt(0);

    // ask users to enter numbers
    System.out.println("Enter first number");
    number1 = input.nextDouble();

    System.out.println("Enter second number");
    number2 = input.nextDouble();

    switch (operator) {

      // performs addition between numbers
      case '+':
        result = number1 + number2;
        System.out.println(number1 + " + " + number2 + " = " + result);
        break;

      // performs subtraction between numbers
      case '-':
        result = number1 - number2;
        System.out.println(number1 + " - " + number2 + " = " + result);
        break;

      // performs multiplication between numbers
      case '*':
        result = number1 * number2;
        System.out.println(number1 + " * " + number2 + " = " + result);
        break;

      // performs division between numbers
      case '/':
        result = number1 / number2;
        System.out.println(number1 + " / " + number2 + " = " + result);
        break;

      default:
        System.out.println("Invalid operator!");
        break;
    }
}

public static void calculator(double amount){
    DecimalFormat f = new DecimalFormat("##.##");
    System.out.println("-----------------------------------------------------\n");
    dollar = amount / 70;
            System.out.println(amount + " Rupee = " + f.format(dollar) + " Dollar");
 
            pound = amount / 88;
            System.out.println(amount + " Rupee = " + f.format(pound) + " Pound");
 
            euro = amount / 80;
            System.out.println(amount + " Rupee = " + f.format(euro) + " Euro");
 
            yen = amount / 0.63;
            System.out.println(amount + " Rupee = " + f.format(yen) + " Yen");
 
            ringgit = amount / 16;
            System.out.println(amount + " Rupee = " + f.format(ringgit) + " ringgit");
            System.out.println("-----------------------------------------------------\n");
}

public void updateCost(){
    Scanner input = new Scanner(System.in);
    int b_cost;
    print();
    System.out.print("Enter the revised bill cost>>");
    b_cost = input.nextInt();
    this.cost =b_cost;
    System.out.println("after updation\n");
    print();
}

public void print(){
    System.out.print("*******************"+billing.hospitalName+"**********************\n");
    System.out.print("-----------------------------------------\n");
    System.out.print("Current bill details:\n");
    System.out.print("-----------------------------------------\n");
    System.out.print("bill id>>"+b_id+"\n");
    System.out.print("patient name>>"+p_name+"\n");
    System.out.print("patient id>>"+p_id+"\n");
    System.out.print("cost>>"+cost+"\n");
    System.out.print("-----------------------------------------\n");
}


public void print(int staff_id,String staff_name){
    this.staff_id=staff_id;
    this.staff_name=staff_name;
    if(this.staff_id!=staff_id_check){
        System.out.println("invalid staff_id\n");
    }
    else if(!this.staff_name.equals(staff_name_check)){
        System.out.println("invalid staff_name");
    }
    else{
        System.out.print("*******************"+billing.hospitalName+"**********************\n");
        System.out.print("-----------------------------------------\n");
        System.out.print("bill:\n");
        System.out.print("-----------------------------------------\n");
        System.out.print("bill generated by:\n");
        System.out.print("staff_id>>"+staff_id+"\n");
        System.out.print("staff_name>>"+staff_name+"\n\n");
        System.out.print("bill id>>"+b_id+"\n");
        System.out.print("patient name>>"+p_name+"\n");
        System.out.print("patient id>>"+p_id+"\n");
        System.out.print("cost>>"+cost+"\n");
        System.out.print("-----------------------------------------\n");
    }
}

billing(){

}
}



class app{
    public static void main(String args[]){
        double amount;
        while(true){
            int i;
            billing.hospitalName="life Hospital";
        Scanner input = new Scanner(System.in);
        //array of object
        billing[] obj = new billing[100];
        //anonymous object
        new billing(1,"smith");
        //array of objects 
        obj[0] = new billing(1,"smith",1,100);
        obj[1] = new billing(2,"vetel",2,200);
        System.out.println("************"+billing.hospitalName+"**************");
        System.out.println("************Billing**************");
        System.out.println("Select an option \n1.update cost of a bill\n2.update staff details\n3.get bill details \n4.generate bill\n5.get calculator\n6.get currency calculator\nenter yout choice");
        int ch = input.nextInt();
        
        switch (ch) {
            case 1:
                if(args[0].equals("1")){
                    int id;
                    System.out.print("Enter the bill id>>");
                    id = input.nextInt();
                    if(obj[id]!=null){
                        obj[id].updateCost();
                    }
                    else{
                        System.out.println("bill not found");
                    }
                    break; 
                }
                else if(args[0].equals("0")){
                    System.out.println("you dont have permission to update");
                } 
                else{
                    System.out.println("invalid config");
                } 
                break;
            case 2:
                int id2;
                System.out.print("Enter the bill id>>");
                id2 = input.nextInt();
                if(obj[id2]!=null){
                    obj[id2].print();
                }
                else{
                    System.out.println("bill not found");
                }
                break;
            case 3:
                int staff_id,b_id;
                String staff_name;
                System.out.print("Enter the staff id>>");
                staff_id = input.nextInt();
                System.out.print("Enter the staff_name>>");
                staff_name = input.next();
                System.out.print("Enter the bill id you want to generate>>");
                b_id= input.nextInt();
                if(obj[b_id]!=null){
                    obj[b_id].print(staff_id,staff_name);
                }
                else{
                    System.out.println("bill not found");
                }
                break;
            case 4:
                billing.calculator();
                break;
            case 5:
                System.out.println("Enter the amount in rupee>>");
                amount = input.nextFloat();
                billing.calculator(amount);
                break;
            default:
                System.out.println("please enter valid option");
                break;
            }
        
        }
    }
}