/*    */ package com.minty.skylord.backpack.nbt;
/*    */ 
/*    */ public abstract class NBTCompound {
/*    */   public abstract void setList(String paramString, NBTList paramNBTList);
/*    */   
/*    */   public abstract void setCompound(String paramString, NBTCompound paramNBTCompound);
/*    */   
/*    */   public abstract void setByte(String paramString, byte paramByte);
/*    */   
/*    */   public abstract void setShort(String paramString, short paramShort);
/*    */   
/*    */   public abstract void setInt(String paramString, int paramInt);
/*    */   
/*    */   public abstract void setLong(String paramString, long paramLong);
/*    */   
/*    */   public abstract void setFloat(String paramString, float paramFloat);
/*    */   
/*    */   public abstract void setDouble(String paramString, double paramDouble);
/*    */   
/*    */   public abstract void setString(String paramString1, String paramString2);
/*    */   
/*    */   public abstract void setByteArray(String paramString, byte[] paramArrayOfbyte);
/*    */   
/*    */   public abstract void setIntArray(String paramString, int[] paramArrayOfint);
/*    */   
/*    */   public void setBoolean(String key, boolean value) {
/* 34 */     setByte(key, (byte)(value ? 1 : 0));
/*    */   }
/*    */   
/*    */   public abstract void remove(String paramString);
/*    */   
/*    */   public abstract boolean isEmpty();
/*    */   
/*    */   public abstract NBTList getList(String paramString);
/*    */   
/*    */   public abstract NBTCompound getCompound(String paramString);
/*    */   
/*    */   public abstract byte getByte(String paramString);
/*    */   
/*    */   public abstract short getShort(String paramString);
/*    */   
/*    */   public abstract int getInt(String paramString);
/*    */   
/*    */   public abstract long getLong(String paramString);
/*    */   
/*    */   public abstract float getFloat(String paramString);
/*    */   
/*    */   public abstract double getDouble(String paramString);
/*    */   
/*    */   public abstract String getString(String paramString);
/*    */   
/*    */   public abstract byte[] getByteArray(String paramString);
/*    */   
/*    */   public abstract int[] getIntArray(String paramString);
/*    */   
/*    */   public boolean getBoolean(String key) {
/* 66 */     return (getByte(key) == 1);
/*    */   }
/*    */ }