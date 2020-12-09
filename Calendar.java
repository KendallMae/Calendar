import java.util.Scanner;

public class Calendar {

    public static int getMonth(Scanner getStuff){
        int month = 0;

        while(month < 1 || month > 12){
            System.out.println("Month: ");
            month = getStuff.nextInt();
        }
        return month;
    }

    public static int getYear(Scanner getStuff){
        int year = 0;

        while(year < 1753){
            System.out.println("Year: ");
            year = getStuff.nextInt();
        }

        return year;
    }

    public static int computeOffset(int month, int year){
        int totalDaysInYears = 0;
        int totalDaysInMonth = 0;
        
        for (int k = 1753; k < year; k++){
            totalDaysInYears += numDaysInYear(k);
        }
        for (int k = 1; k < month; k++){
            totalDaysInMonth += numDaysInMonth(k, year);
        }
        int numDaysBefore = totalDaysInYears + totalDaysInMonth;
        int offset = numDaysBefore % 7;

        return offset;
    }

    public static void display(int month, int year, int offset){
        int numDays = numDaysInMonth(month, year);
        displayHeader(month, year);
        displayTable(offset, numDays);
    }

    public static void displayTable(int offset, int numDays){
        System.out.println("Su Mo Tu We Th Fr Sa");
        String format = "";
        for(int k = 0; k <= offset && k != 6; k++){
            format += "   ";
        }
        format += "";
        for(int day = 1; day <= numDays; day++){
            if(day < 10){
                format += " ";
            }
            format += (day + ""); 
            format += " ";
            if(offset % 7 == 5){
                System.out.println(format);
                format = "";
            }
            offset++;
        }
        if(offset % 7 != 6)
            System.out.println("\n");

    }

    public static void displayHeader(int month, int year){
        String strMonth = "";
        if (month == 1){
            strMonth = "January";
        }
        if (month == 2){
            strMonth = "February";
        }
        if (month == 3){
            strMonth = "March";
        }
        if (month == 4){
            strMonth = "April";
        }
        if (month == 5){
            strMonth = "May";
        }
        if (month == 6){
            strMonth = "June";
        }
        if (month == 7){
            strMonth = "July";
        }
        if (month == 8){
            strMonth = "August";
        }
        if (month == 9){
            strMonth = "September";
        }
        if (month == 10){
            strMonth = "October";
        }
        if (month == 11){
            strMonth = "November";
        }
        if (month == 12){
            strMonth = "December";
        }

        System.out.println("\n" + strMonth + " " + year);
    }

    public static int numDaysInYear(int year){
        if(isLeapYear(year)){
            return 366;
        }
        else{
            return 365;
        }
    }

    public static int numDaysInMonth(int month, int year){
        int numDays = 0;
        if(month == 1){
            numDays = 31;
        }
        if(month == 2){
            if(isLeapYear(year)){
                numDays = 29;
            }
            else{
                numDays = 28;
            }
        }
        if(month == 3){
            numDays = 31;
        }
        if(month == 4){
            numDays = 30;
        }
        if(month == 5){
            numDays = 31;
        }
        if(month == 6){
            numDays = 30;
        }
        if(month == 7){
            numDays = 31;
        }
        if(month == 8){
            numDays = 31;
        }
        if(month == 9){
            numDays = 30;
        }
        if(month == 10){
            numDays = 31;
        }
        if(month == 11){
            numDays = 30;
        }
        if(month == 12){
            numDays = 31;
        }
        return numDays;
    }

    public static boolean isLeapYear(int year){
        if(year % 400 == 0){
            return true;
        }
        if(year % 100 == 0){
            return false;
        }
        if(year % 4 == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner getStuff = new Scanner(System.in);
        int month = getMonth(getStuff);
        int year = getYear(getStuff);
        int offset = computeOffset(month, year);
        display(month, year, offset);
    }
}
