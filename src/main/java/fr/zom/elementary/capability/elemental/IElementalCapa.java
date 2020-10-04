package fr.zom.elementary.capability.elemental;

import net.minecraft.entity.player.ServerPlayerEntity;

public interface IElementalCapa
{

    int getFire();

    int getWater();

    int getEarth();

    int getBolt();

    int getShadow();

    int getAir();

    int addFire(int amount);
    int addWater(int amount);
    int addEarth(int amount);
    int addBolt(int amount);
    int addShadow(int amount);
    int addAir(int amount);

    void setFire(int amount);
    void setWater(int amount);
    void setEarth(int amount);
    void setBolt(int amount);
    void setShadow(int amount);
    void setAir(int amount);

    default void setCapa(IElementalCapa newCapa)
    {
        setAir(newCapa.getAir());
        setShadow(newCapa.getShadow());
        setBolt(newCapa.getBolt());
        setEarth(newCapa.getEarth());
        setWater(newCapa.getWater());
        setFire(newCapa.getFire());
    }

    void sync(ServerPlayerEntity serverPlayerEntity);

}
