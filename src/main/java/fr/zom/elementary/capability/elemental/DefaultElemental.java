package fr.zom.elementary.capability.elemental;

import net.minecraft.entity.player.ServerPlayerEntity;

public class DefaultElemental implements IElementalCapa
{

    private int fire;
    private int water;
    private int earth;
    private int bolt;
    private int shadow;
    private int air;

    public DefaultElemental(int fire, int water, int earth, int bolt, int shadow, int air)
    {
        this.fire = fire;
        this.water = water;
        this.earth = earth;
        this.bolt = bolt;
        this.shadow = shadow;
        this.air = air;
    }

    public DefaultElemental()
    {
        this(0, 0, 0, 0, 0, 0);
    }

    @Override
    public int getFire()
    {
        return this.fire;
    }

    @Override
    public int getWater()
    {
        return this.water;
    }

    @Override
    public int getEarth()
    {
        return this.earth;
    }

    @Override
    public int getBolt()
    {
        return this.bolt;
    }

    @Override
    public int getShadow()
    {
        return this.shadow;
    }

    @Override
    public int getAir()
    {
        return this.air;
    }

    @Override
    public void setFire(int amount)
    {
        this.fire = amount;
    }

    @Override
    public void setWater(int amount)
    {
        this.water = amount;
    }

    @Override
    public void setEarth(int amount)
    {
        this.earth = amount;
    }

    @Override
    public void setBolt(int amount)
    {
        this.bolt = amount;

    }

    @Override
    public void setShadow(int amount)
    {
        this.shadow = amount;

    }

    @Override
    public void setAir(int amount)
    {
        this.air = amount;

    }

    @Override
    public void sync(ServerPlayerEntity serverPlayerEntity)
    {
        // Envoi de paquets si besoin
    }
}
