public class bookings {

    int totalBirths=0;
    int upperBirths = 0;
    int lowerBirths = 0;
    int middleBirths = 0;
    int racTickets = 0;
    int waitingList = 0;

 //Constructer for set details of train
    void setTrain() {

       this.totalBirths=63;
       this.lowerBirths=21;
       this.middleBirths=21;
       this.upperBirths=21;
       this.racTickets=18;
       this.waitingList=10;
    }
//display train details
void displayTrainDetails()
{
     System.out.println(
     " Lower Births :"+this.lowerBirths+"\n"+
     " Middle Births :"+this.middleBirths+"\n"+
     " Upper Births :"+this.upperBirths+"\n" +
     " Rac Tickets :"+this.racTickets+"\n"+
     " Waiting List :"+this.waitingList);
}

String getAvailableBirth()
    {
        if(this.lowerBirths>0)
        {
            return "Lower";
        }
        else if
        (this.middleBirths>0)
        {
            return "Middle";
        }
        else if (this.upperBirths>0)
        {
            return "Upper";
        }
        else
        {
            return "N";
        }
    }

void updateBirthCount(char birth) {
    switch (birth) {
        case 'L':
            this.lowerBirths += 1;
            break;
        case 'M':
            this.middleBirths -= 1;
            break;
        case 'U':
            this.upperBirths -= 1;
            break;
    }
}

}//train class