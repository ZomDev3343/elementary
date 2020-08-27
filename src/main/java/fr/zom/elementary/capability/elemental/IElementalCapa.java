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

    void setFire(int amount);

    void setWater(int amount);

    void setEarth(int amount);

    void setBolt(int amount);

    void setShadow(int amount);

    void setAir(int amount);

    void sync(ServerPlayerEntity serverPlayerEntity);

}
