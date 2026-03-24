package capgemeini_training;

public class Assignment_23Jan_Uml {
    public static void main(String[] args) {
       Passport p = new Passport("8298", "23-01-26");
       Person person=new Person("John Doe", 30, p);
       System.out.println("Person Name: "+person.getName()+"Person Age: "+person.getAge());
       System.out.println("Passport No: "+person.getPassport().getPassportNo()+"Passport Issue Date: "+person.getPassport().getissueDate());
       
    }
     //Person-Passport
     static class Passport{
        String passportNo;
        String issueDate;
        public Passport(String passportNo,String issueDate){
            this.passportNo=passportNo;
            this.issueDate=issueDate;
        }
        public String getPassportNo(){
            return passportNo;
        }
        public String getissueDate(){
            return issueDate;
        }
     }
     static class Person{
        String name;
        int age;
        Passport passport;
        public Person(String name,int age,Passport passport){
            this.name=name;
            this.age=age;
            this.passport=passport;
        }
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public Passport getPassport(){
            return passport;
        }
     }
}
