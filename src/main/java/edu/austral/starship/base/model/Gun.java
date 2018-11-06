package edu.austral.starship.base.model;


public abstract class Gun {
    private long lastFire=System.currentTimeMillis()-2000;
    private long millisUntilNext;
    private int ammo;
    private String name;

    public Gun( long millisUntilNext) {
        this.millisUntilNext = millisUntilNext;
    }

    public Bullet fire(PlayerSpaceship playerSpaceship){
        this.lastFire=System.currentTimeMillis();
        ammo--;
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

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public boolean hasAmmo() {
        return ammo!=0;
    }

    public abstract void setMaxAmmo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
