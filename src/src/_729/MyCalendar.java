package _729;

import java.util.ArrayList;

class Bookings {
    public int start;
    public int end;

    Bookings(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MyCalendar {
    private final ArrayList<Bookings> bookings;

    public MyCalendar() {
        this.bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        Bookings newBooking = new Bookings(start, end);
        int insertIdx = this.searchBookings(newBooking, 0, this.bookings.size());
        if (insertIdx != -1) {
            this.bookings.add(insertIdx, newBooking);
            return true;
        }
        return false;
    }

    //    Binary search on bookings.
//    Returns the index where booking can be inserted
//    Returns -1 if booking is overlapping
    private int searchBookings(Bookings newBooking, int startIdx, int endIdx) {
        int mid = (startIdx + endIdx) >> 1;
        if (mid < 0 || mid >= this.bookings.size()) {
            return mid;
        }
        Bookings currBooking = this.bookings.get(mid);

//        overlap check
        if (
                (newBooking.start >= currBooking.start && newBooking.start < currBooking.end) ||
                        (newBooking.end > currBooking.start && newBooking.end <= currBooking.end) ||
                        (newBooking.start < currBooking.start && newBooking.end > currBooking.end)
        ) {
            return -1;
        }

//        Insertion point found
        if (startIdx == endIdx) {
            if (newBooking.start > currBooking.end) {
                return mid + 1;
            } else {
                return mid;
            }
        }

        if (newBooking.start >= currBooking.end) {
//            go right
            return this.searchBookings(newBooking, mid + 1, endIdx);
        } else {
//        Go left
            return this.searchBookings(newBooking, startIdx, mid);
        }
    }

}
