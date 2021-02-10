package com.minty.skylord.backpack.nbt;

public abstract class NBTList {
  public abstract void add(NBTCompound paramNBTCompound);
  
  public abstract NBTCompound get(int paramInt);
  
  public abstract int size();
}