package Assignment4;

public class FlightRoute {
    private String origin;
    private String destination;
    private int distance;
    private int cost;

    public FlightRoute(String origin, String destination, int distance, int cost) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.cost = cost;
        
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }
    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return origin + " -> " + destination + " (" + distance + " miles, Cost: $" + cost + ")";
    }
}
