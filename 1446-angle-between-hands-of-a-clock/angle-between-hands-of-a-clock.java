class Solution {
    public double angleClock(int hour, int minutes) {
        double hour_deg=(hour%12)*30+(double)(minutes)/2;
        double min_deg=minutes*6;
        return Math.min(Math.abs((360-hour_deg)+min_deg),Math.min(Math.abs(hour_deg-min_deg),Math.abs(hour_deg+(360-min_deg))));
    }
}