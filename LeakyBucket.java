import java.util.LinkedList;

public class LeakyBucket {
    private int bucketCapacity;
    private int leakRate;
    private LinkedList<Integer> bucket;

    public LeakyBucket(int bucketCapacity, int leakRate) {
        this.bucketCapacity = bucketCapacity;
        this.leakRate = leakRate;
        this.bucket = new LinkedList<>();
    }

    public boolean process(int incomingTraffic) {
        int bucketOccupancy = bucket.size();

        if (bucketOccupancy + incomingTraffic > bucketCapacity) {
            return false;
        }

        bucket.add(incomingTraffic);
        return true;
    }

    public void leak() {
        int leakedAmount = Math.min(bucket.size(), leakRate);
        for (int i = 0; i < leakedAmount; i++) {
            bucket.remove();
        }
    }
}
