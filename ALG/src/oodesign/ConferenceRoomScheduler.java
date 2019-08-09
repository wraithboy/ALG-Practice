package oodesign;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

class Reservation {

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    private long startTime;
    private long endTime;

    public Reservation(long startTime,long endTime)
    {
        this.startTime=startTime;
        this.endTime=endTime;
    }
}

class MeetingRoom
{
    private final int ID;

    public TreeSet<Reservation> reseravations;

    public MeetingRoom(int id)
    {
        this.ID=id;
        reseravations=new TreeSet<>();
        reseravations=new TreeSet<>(new Comparator<Reservation>() {
            @Override
            public int compare(Reservation o1, Reservation o2) {
                if(o1.getStartTime()>o2.getStartTime())
                    return 1;
                if(o1.getStartTime()<o2.getStartTime())
                    return -1;
                return 0;
            }
        });
    }

    public int bookRoom(long startTime,long endTime)
    {

        Reservation newResv=new Reservation(startTime,endTime);

        Reservation ceil=reseravations.ceiling(newResv);

                System.out.println("ceil:"+(ceil==null?"null":ceil.getStartTime()));


        Reservation floor=reseravations.floor(newResv);

                System.out.println("floor:"+(floor==null?"null":floor.getStartTime()));


        if(ceil!=null && ceil.getStartTime()<newResv.getEndTime() || floor!=null && floor.getEndTime()>newResv.getStartTime())
        {
            return -1;
        }

        reseravations.add(newResv);

        return this.ID;
    }

}

public class ConferenceRoomScheduler {

    private final long FIVE_MINUTES=60*5;
    private final long SEVEN_DAY=60*60*24*7;
    private final int numOfRooms;
    private List<MeetingRoom> rooms;

    public ConferenceRoomScheduler()
    {
        numOfRooms=8;

        rooms=new ArrayList<>();

        //initialization meeting rooms and added to room list
        for(int i=1;i<=numOfRooms;i++)
        {
            rooms.add(new MeetingRoom(i));
        }
    }

    public int reserveRoom(long startTime,long endTime)
    {
        if(!validateInput(startTime,endTime))
        {
            return -2;
        }

        for(MeetingRoom r : rooms)
        {
            int roomID=r.bookRoom(startTime,endTime);
            if(roomID>0)
                return roomID;
        }

        return -1;
    }

    private boolean validateInput(long startTime,long endTime)
    {
        long diff= endTime-startTime;

        if(diff<FIVE_MINUTES)
        {
            System.out.println("!");
            return false;
        }

        if(diff>SEVEN_DAY)
        {
            System.out.println("!!");

            return false;
        }

        if(startTime%FIVE_MINUTES!=0 || endTime%FIVE_MINUTES!=0)
        {
            System.out.println("!!!");
            return false;
        }

        return true;
    }

    public static void main(String args[])
    {

        ConferenceRoomScheduler scheduler = new ConferenceRoomScheduler();

        //System.out.println(scheduler.numOfRooms);

        System.out.println(scheduler.reserveRoom(1554599100,1554599700));
        System.out.println(scheduler.reserveRoom(1554600000,1554600600));
        System.out.println(scheduler.reserveRoom(1554599700,1554600300));
        System.out.println(scheduler.reserveRoom(1554599700,1554600300));System.out.println(scheduler.reserveRoom(1554599700,1554600300));
        System.out.println(scheduler.reserveRoom(1554599700,1554600300));
        System.out.println(scheduler.reserveRoom(1554599700,1554600300));
        System.out.println(scheduler.reserveRoom(1554599700,1554600300));
        System.out.println(scheduler.reserveRoom(1554599700,1554600300));
        System.out.println(scheduler.reserveRoom(1554599700,1554600300));
        System.out.println(scheduler.reserveRoom(1554600300,1554600600));

        //System.out.println(scheduler.reserveRoom(1554599100,1554599700));


//        MeetingRoom r = new MeetingRoom(1);

//        Reservation r1=new Reservation(2,5);
//        Reservation r2=new Reservation(1,2);
//        Reservation r4=new Reservation(6,10);
//
//
//        Reservation r3=new Reservation(7,9);
//
//        r.reseravations.add(r1);
//        r.reseravations.add(r4);
//        //r.reseravations.add(r3);
//
//        Reservation ceil=r.reseravations.ceiling(r2);
//        Reservation floor=r.reseravations.floor(r2);
//
//
//        System.out.println("ceil:"+(ceil==null?"null":ceil.getStartTime()));
//
//        System.out.println("floor:"+(floor==null?"null":floor.getStartTime()));
//
//        if(ceil!=null && ceil.getStartTime()<r2.getEndTime() || floor!=null && floor.getEndTime()<r2.getStartTime())
//        {
//            System.out.println("can't insert");
//            return;
//        }
//
//        System.out.println("successfully inserted!");
//        r.reseravations.add(r4);
    }

}
