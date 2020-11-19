package fr.zom.elementary.capability.elemental;

import net.minecraft.entity.player.ServerPlayerEntity;

public interface IElementalCapa {

    int getFire();

    void setFire(int amount);

    int getWater();

    void setWater(int amount);

    int getEarth();

    void setEarth(int amount);

    int getBolt();

    void setBolt(int amount);

    int getShadow();

    void setShadow(int amount);

    int getAir();

    void setAir(int amount);

    int addFire(int amount);

    int addWater(int amount);

    int addEarth(int amount);

    int addBolt(int amount);

    int addShadow(int amount);

    int addAir(int amount);

    default void setCapa(IElementalCapa newCapa) {
        setAir(newCapa.getAir());
        setShadow(newCapa.getShadow());
        setBolt(newCapa.getBolt());
        setEarth(newCapa.getEarth());
        setWater(newCapa.getWater());
        setFire(newCapa.getFire());
    }

    void sync(ServerPlayerEntity serverPlayerEntity);

}
