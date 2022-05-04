import java.util.Scanner;

abstract class credentials{
    int cust_id;
    int staff_id;
    int doctor_id;
    StringBuffer cuspass;
    StringBuffer staffpass;
    StringBuffer docpass;
    static boolean doctor=false;
    static boolean patient=false;
    static boolean staff=false;
    credentials(){
        System.out.println("app Module");
    }
    credentials(int cusid,StringBuffer cus,int stafid,StringBuffer staf,int docid,StringBuffer doc){
        this.cust_id=cusid;
        this.cuspass=cus;
        this.staff_id=stafid;
        this.staffpass=staf;
        this.doctor_id=docid;
        this.docpass=doc;
    }
    abstract void AllCredentials();
    abstract void RestrictedCred();
    abstract void patientCred();
    abstract void verify(int id,StringBuffer pass, app obj);
}

class process extends credentials{
    process(int cusid,StringBuffer cus,int stafid,StringBuffer staf,int docid,StringBuffer doc){
        super(101,cus,1001,staf,5001,doc);
    }
    final void AllCredentials(){
        System.out.println("***********customer**************");
        System.out.println("customer id>>"+this.cust_id);
        System.out.println("customer pass>>"+this.cuspass);
        System.out.println("\n************Staff**************");
        System.out.println("Staff id>>"+this.staff_id);
        System.out.println("Staff pass>>"+this.staffpass);
        System.out.println("\n************Doctor*************");
        System.out.println("Doctor id>>"+this.doctor_id);
        System.out.println("Doctor pass>>"+this.docpass);
    }
    final void RestrictedCred(){
        System.out.println("***********customer**************");
        System.out.println("customer id>>"+this.cust_id);
        System.out.println("customer pass>>"+this.cuspass);
        System.out.println("\n************Staff**************");
        System.out.println("Staff id>>"+this.staff_id);
        System.out.println("Staff pass>>"+this.staffpass);
    }
    final void patientCred(){
        System.out.println("***********customer**************");
        System.out.println("customer id>>"+this.cust_id);
        System.out.println("customer pass>>"+this.cuspass);
    }
    final void verify(int id,StringBuffer pass, app obj){
        boolean doc = obj.validatedoc(id,pass);
        boolean pat = obj.validatepat(id, pass);
        boolean staff = obj.validatestaff(id, pass);
        if(doc==true){
            app.doctor=true;
            app.staff=false;
            app.patient=false;
        }
        else if(pat==true){
            app.doctor=false;
            app.staff=false;
            app.patient=true;
        }
        else if(staff==true){
            app.doctor=false;
            app.staff=true;
            app.patient=false;
        }
    }
}

class patient extends process{
    patient(int cusid,StringBuffer cus,int stafid,StringBuffer staf,int docid,StringBuffer doc){
        super(101,cus,1001,staf,5001,doc);
    }
    public boolean validatepat(int id, StringBuffer pass){
        if(this.cust_id==id && this.cuspass.toString().equals(pass.toString()))
            return true;
        else
            return false;
    }
    public void updatepat(){
        Scanner input = new Scanner(System.in);
        System.out.println("Current Credentials");
        System.out.println("patient id>>"+this.cust_id);
        System.out.println("patient pass>>"+this.cuspass);
        System.out.println("Enter new id>>");
        this.cust_id = input.nextInt();
        System.out.println("Enter new password>>");
        String pass = input.next();
        this.cuspass.setLength(0);
        this.cuspass.append(pass);
        System.out.println("updated credentials");
        System.out.println("patient id>>"+this.cust_id);
        System.out.println("patient pass>>"+this.cuspass);
    }
}

class staff extends patient{
    staff(int cusid,StringBuffer cus,int stafid,StringBuffer staf,int docid,StringBuffer doc){
        super(101,cus,1001,staf,5001,doc);
    }
    public boolean validatestaff(int id, StringBuffer pass){
        if(this.staff_id==id && this.staffpass.toString().equals(pass.toString()))
            return true;
        else
            return false;
    }
    public void updatepat(){
        super.updatepat();
    }
    public void updatestaff(){
        Scanner input = new Scanner(System.in);
        System.out.println("Current Credentials");
        System.out.println("Staff id>>"+this.staff_id);
        System.out.println("Staff pass>>"+this.staffpass);
        System.out.println("Enter new id>>");
        this.staff_id = input.nextInt();
        System.out.println("Enter new password>>");
        String pass = input.next();
        this.staffpass.setLength(0);
        this.staffpass.append(pass);
        System.out.println("updated credentials");
        System.out.println("Staff id id>>"+this.staff_id);
        System.out.println("Staff pass>>"+this.staffpass);
    }
}

class doctor extends staff{
    doctor(int cusid,StringBuffer cus,int stafid,StringBuffer staf,int docid,StringBuffer doc){
        super(101,cus,1001,staf,5001,doc);
    }
    public boolean validatedoc(int id, StringBuffer pass){
        if(this.doctor_id==id && this.docpass.toString().equals(pass.toString()))
            return true;
        else
            return false;
    }
    public void updatestaff(){
        super.updatestaff();
    }
    public void updatedoc(){
        Scanner input = new Scanner(System.in);
        System.out.println("Current Credentials");
        System.out.println("Doctor id>>"+this.doctor_id);
        System.out.println("Doctor pass>>"+this.docpass);
        System.out.println("Enter new id>>");
        this.doctor_id = input.nextInt();
        System.out.println("Enter new password>>");
        String pass = input.next();
        this.docpass.setLength(0);
        this.docpass.append(pass);
        System.out.println("updated credentials");
        System.out.println("Doctor id>>"+this.doctor_id);
        System.out.println("Doctor pass>>"+this.docpass);
    }
}

class app extends doctor{
    app(StringBuffer cus,StringBuffer staf,StringBuffer doc){
        super(101,cus,1001,staf,5001,doc);
    }
    public static void main(String args[]){
        Boolean doc=false, pat=false, staf=false; 
        Boolean doct=false, staff=false; 
        Scanner input=new Scanner(System.in);
        StringBuffer pass1=new StringBuffer("Cust@hos123");
        StringBuffer pass2=new StringBuffer("Staff@hos123");
        StringBuffer pass3=new StringBuffer("Doc@hos123");
        app obj= new app(pass1,pass2,pass3);
        while(true){
            System.out.println("1.login\n2.logout\n3.update credentials\n4.print credentials\nEnter your choice:");
        int ch = input.nextInt();
        switch (ch) {
            case 1:
                System.out.println("enter your pass>>"); 
                String pasw=input.next();
                StringBuffer paswd = new StringBuffer();
                paswd.append(pasw);
                System.out.println("enter your id>>");
                int id2=input.nextInt();
                obj.verify(id2,paswd,obj);
                break;
            case 2:
                app.doctor=false;
                app.staff=false;
                app.patient=false;
                break;
            case 3:
                if(app.doctor==false && app.staff==false && app.patient==false){
                    System.out.println("enter your pass>>"); 
                    String passw=input.next();
                    System.out.println("enter your id>>");
                    int ids=input.nextInt();
                    StringBuffer pswd = new StringBuffer();
                    pswd.append(passw);
                    doct = obj.validatedoc(ids,pswd);
                    staff = obj.validatestaff(ids,pswd);
                }
                if(doct==true||app.doctor==true){
                    System.out.println("1.edit staff credentials\n2.edit patient credentials\n3.update doctor credentials");
                    int ch1= input.nextInt();
                    switch (ch1) {
                        case 1:
                            obj.updatestaff();
                            break;
                        case 2:
                            obj.updatepat();
                            break;
                        case 3:
                            obj.updatedoc();
                            break;
                        default:
                            System.out.println("invalid option");
                            break;
                    }
                }
                else if(staff==true||app.staff==true){
                    System.out.println("1.edit staff credentials\n2.update patient credentials");
                    int ch1= input.nextInt();
                    switch (ch1) {
                        case 1:
                            obj.updatestaff();
                            break;
                        case 2:
                            obj.updatepat();
                            break;
                        default:
                            System.out.println("invalid option");
                            break;
                    }
                }
                else{
                    System.out.println("you dont have access to update");
                }
                break;
            case 4:
                if(app.doctor==false && app.staff==false && app.patient==false){
                System.out.println("enter your pass>>"); 
                String pass=input.next();
                System.out.println("enter your id>>");
                int id=input.nextInt();
                StringBuffer psw = new StringBuffer();
                psw.append(pass);
                doc = obj.validatedoc(id,psw);
                pat = obj.validatepat(id,psw);
                staf = obj.validatestaff(id,psw);
                }
                if(doc==true||app.doctor==true){
                    obj.AllCredentials();
                }
                else if(staf==true||app.staff==true){
                    obj.RestrictedCred();
                }
                else if(pat==true||app.patient==true){
                    obj.patientCred();
                }
                else{
                    System.out.println("you dont have access, please contact the admin");
                }
                break;
            default:
                System.out.println("invalid choice");
                break;
            }
        }
    }
}


