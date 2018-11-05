package edu.austral.starship.base.model;


public abstract class Gun {
    private long lastFire=System.currentTimeMillis()-2000;
    private long millisUntilNext;

    public Gun( long millisUntilNext) {
        this.millisUntilNext = millisUntilNext;
    }

    public Bullet fire(PlayerSpaceship playerSpaceship){
        this.lastFire=System.currentTimeMillis();
        return fireConcrete(playerSpaceship);
    }
    public abstract Bullet fireConcrete(PlayerSpaceship playerSpaceship);

    public long getLastFire() {
        return lastFire;
    }

    public void setLastFire(long lastFire) {
        this.lastFire = lastFire;
    }

    public long getMillisUntilNext() {
        return millisUntilNext;
    }

    public void setMillisUntilNext(long millisUntilNext) {
        this.millisUntilNext = millisUntilNext;
    }
}
