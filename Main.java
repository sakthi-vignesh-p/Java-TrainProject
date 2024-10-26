import java.util.*;

public class Main {

    static void line()
    {
        System.out.println(".....................................");
    }
    public static void main(String[] args) {
     Scanner scan =new Scanner(System.in);

       ArrayList<passengers>confirmedTickets=new ArrayList<>();
       ArrayList<passengers>racTickets=new ArrayList<>() ;
       ArrayList<passengers>waitingTickets=new ArrayList<>();
       Map<Integer,passengers>map=new HashMap<>();

      bookings booking=new bookings();
      booking.setTrain();

     boolean loop=true;
     int option;
     while (loop)
     {    line();
         System.out.println(" 1--> For Booking"+"\n"+
             " 2--> For Cancel"+"\n"+
             " 3--> For View Passengers"+"\n"+
             " 4--> For View  Available Tickets"
                 );
         option=scan.nextInt();
         switch (option)
         {
             //Booking Functions
             case 1:
                 line();
                 booking.displayTrainDetails();
                 line();

                if(booking.lowerBirths<1 && booking.middleBirths < 1 && booking.upperBirths<1
                && booking.racTickets<1 && booking.waitingList<1)
                {
                    System.out.println("No Tickets Available Now");
                    break;
                }

                System.out.println("Enter Name");
                String Name=scan.next();
                System.out.println("Enter Age");
                int Age=scan.nextInt();
                System.out.println("Enter Birth Preference(L,M,U)");
                char birthPreference=scan.next().charAt(0);

                if(birthPreference!='L' && birthPreference!='M' && birthPreference!='U')
                {  line();
                    System.out.println("Invaid Option"+"\n"+
                            "(L)-->Lower Births"+"\n"+
                            "(M)-->Middle Births"+"\n"+
                            "(U)-->Upper Births");
                    break;
                }

                passengers passenger=new passengers();

                if(birthPreference=='L' && booking.lowerBirths>0)
                {
                    passenger.setbooking(Name,Age,birthPreference);
                    confirmedTickets.add(passenger);
                    map.put(passenger.passengerId,passenger);
                    System.out.println("Lower Birth Given");
                    booking.lowerBirths-=1;
                }
                else if (birthPreference=='M' && booking.middleBirths>0)
                {
                    passenger.setbooking(Name,Age,birthPreference);
                    confirmedTickets.add(passenger);
                    map.put(passenger.passengerId,passenger);
                    System.out.println("Middle Birth Given");
                    booking.middleBirths-=1;
                }
                else if (birthPreference=='U' && booking.upperBirths>0)
                {
                    passenger.setbooking(Name,Age,birthPreference);
                    map.put(passenger.passengerId,passenger);
                    confirmedTickets.add(passenger);
                    System.out.println("Upper Birth Given");
                    booking.upperBirths-=1;
                }

                else if(booking.getAvailableBirth()!="N")
                {
                    String birth= booking.getAvailableBirth();
                    passenger.setbooking(Name,Age,birth.charAt(0));
                    confirmedTickets.add(passenger);
                    map.put(passenger.passengerId,passenger);
                    System.out.println(birth+"Birth Given");
                    booking.updateBirthCount(birth.charAt(0));
                }
                else
                {
                    if(booking.racTickets>0)
                    {
                        passenger.setbooking(Name,Age,'R');
                        racTickets.add(passenger);
                        map.put(passenger.passengerId,passenger);
                        System.out.println("RAC Birth Given");
                        booking.racTickets-=1;
                    }
                    else
                    {
                        passenger.setbooking(Name,Age,'W');
                        waitingTickets.add(passenger);
                        map.put(passenger.passengerId,passenger);
                        System.out.println("Waiting List Given");
                        booking.waitingList-=1;
                    }
                }
                //Booking functions over
                 break;

             case 2://Cancel Tickets
                 if(confirmedTickets.size()<1 && racTickets.size()<1 && waitingTickets.size()<1)
                 {
                     line();
                     System.out.println("No Passengers");
                     break;
                 }
                    System.out.println("Enter Passenger Id");
                   int passId=scan.nextInt();

                  passengers currentPassenger=map.get(passId);
                  if(currentPassenger==null)
                  {
                      System.out.println("No Passengers Found");
                      break;
                  }

                  map.remove(passId);
                  char birth= currentPassenger.birthPreference;
                 
                 break;

             case 3:
                 //Print Passenger details
               if(confirmedTickets.size()<1 && racTickets.size()<1 && waitingTickets.size()<1)
               {
                   line();
                   System.out.println("No Passengers");
                   break;
               }

                 System.out.println("....................Passengers...................");
                 for (passengers c:confirmedTickets)
                 {
                     c.displayPassengerDetails();
                     line();
                 }
                 for(passengers c:racTickets)
                 {
                     c.displayPassengerDetails();
                     line();
                 }
                 for(passengers c:waitingTickets)
                 {
                     c.displayPassengerDetails();
                     line();
                 }

                      break;

             case 4://Print Available Tickets
                 System.out.println("....................Available Tickets...............");
                 booking.displayTrainDetails();
                 line();
                 break;

                 default:
                 System.out.println("Invalid Option");
         }//switch
     }//loop

    }
}