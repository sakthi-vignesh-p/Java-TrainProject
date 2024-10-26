public class passengers {

         static int id=0;
         int passengerId=0;
         String Name;
         int Age;
         char birthPreference;

 void setbooking(String name,int age,char birth)
 {
     id=id+1;
     this.passengerId=id;
     this.Name=name;
     this.Age=age;
     this.birthPreference=birth;
 }

 void updateBirthPreference(char birth)
    {
        this.birthPreference=birth;
    }

void displayPassengerDetails()
{
    System.out.println("Passenger Id :"+this.passengerId+"\n"+
            "Name :"+this.Name+"\n"+
            "Age :"+this.Age+"\n"+"Seat :"+
            this.birthPreference);
}

}

