package sample;

public abstract class Tower {
    private int range;
    private int heath;
    private int cost;

    public Tower() {
    }

    public Tower(int range, int heath, int cost) {
        this.range = range;
        this.heath = heath;
        this.cost = cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
