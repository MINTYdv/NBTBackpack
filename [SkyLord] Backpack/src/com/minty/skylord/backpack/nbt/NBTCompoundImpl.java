/*     */ package com.minty.skylord.backpack.nbt;
/*     */ 
/*     */ import net.minecraft.server.v1_12_R1.NBTBase;
/*     */ import net.minecraft.server.v1_12_R1.NBTTagCompound;
/*     */ import net.minecraft.server.v1_12_R1.NBTTagList;
/*     */ 
/*     */ public class NBTCompoundImpl extends NBTCompound {
/*     */   protected NBTTagCompound nbtTagCompound;
/*     */   
/*     */   public NBTCompoundImpl() {
/*  16 */     this(new NBTTagCompound());
/*     */   }
/*     */   
/*     */   public NBTCompoundImpl(NBTTagCompound nbtTagCompound) {
/*  20 */     this.nbtTagCompound = nbtTagCompound;
/*  22 */     if (this.nbtTagCompound == null)
/*  23 */       this.nbtTagCompound = new NBTTagCompound(); 
/*     */   }
/*     */   
/*     */   public String toString() {
/*  31 */     return this.nbtTagCompound.toString();
/*     */   }
/*     */   
/*     */   public void setList(String key, NBTList list) {
/*  36 */     NBTTagList nbtTagList = new NBTTagList();
/*  38 */     for (int i = 0; i < list.size(); i++)
/*  39 */       nbtTagList.add((NBTBase)((NBTCompoundImpl)list.get(i)).nbtTagCompound); 
/*  42 */     this.nbtTagCompound.set(key, (NBTBase)nbtTagList);
/*     */   }
/*     */   
/*     */   public void setCompound(String key, NBTCompound compound) {
/*  47 */     this.nbtTagCompound.set(key, (NBTBase)((NBTCompoundImpl)compound).nbtTagCompound);
/*     */   }
/*     */   
/*     */   public void setByte(String key, byte value) {
/*  52 */     this.nbtTagCompound.setByte(key, value);
/*     */   }
/*     */   
/*     */   public void setShort(String key, short value) {
/*  57 */     this.nbtTagCompound.setShort(key, value);
/*     */   }
/*     */   
/*     */   public void setInt(String key, int value) {
/*  62 */     this.nbtTagCompound.setInt(key, value);
/*     */   }
/*     */   
/*     */   public void setLong(String key, long value) {
/*  67 */     this.nbtTagCompound.setLong(key, value);
/*     */   }
/*     */   
/*     */   public void setFloat(String key, float value) {
/*  72 */     this.nbtTagCompound.setFloat(key, value);
/*     */   }
/*     */   
/*     */   public void setDouble(String key, double value) {
/*  77 */     this.nbtTagCompound.setDouble(key, value);
/*     */   }
/*     */   
/*     */   public void setString(String key, String value) {
/*  82 */     this.nbtTagCompound.setString(key, value);
/*     */   }
/*     */   
/*     */   public void setByteArray(String key, byte[] value) {
/*  87 */     this.nbtTagCompound.setByteArray(key, value);
/*     */   }
/*     */   
/*     */   public void setIntArray(String key, int[] value) {
/*  92 */     this.nbtTagCompound.setIntArray(key, value);
/*     */   }
/*     */   
/*     */   public void remove(String key) {
/*  97 */     this.nbtTagCompound.remove(key);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 102 */     return this.nbtTagCompound.isEmpty();
/*     */   }
/*     */   
/*     */   public NBTList getList(String key) {
/* 112 */     return new NBTListImpl(this.nbtTagCompound.getList(key, 10));
/*     */   }
/*     */   
/*     */   public NBTCompound getCompound(String key) {
/* 117 */     return new NBTCompoundImpl(this.nbtTagCompound.getCompound(key));
/*     */   }
/*     */   
/*     */   public byte getByte(String key) {
/* 122 */     return this.nbtTagCompound.getByte(key);
/*     */   }
/*     */   
/*     */   public short getShort(String key) {
/* 127 */     return this.nbtTagCompound.getShort(key);
/*     */   }
/*     */   
/*     */   public int getInt(String key) {
/* 132 */     return this.nbtTagCompound.getInt(key);
/*     */   }
/*     */   
/*     */   public long getLong(String key) {
/* 137 */     return this.nbtTagCompound.getLong(key);
/*     */   }
/*     */   
/*     */   public float getFloat(String key) {
/* 142 */     return this.nbtTagCompound.getFloat(key);
/*     */   }
/*     */   
/*     */   public double getDouble(String key) {
/* 147 */     return this.nbtTagCompound.getDouble(key);
/*     */   }
/*     */   
/*     */   public String getString(String key) {
/* 152 */     return this.nbtTagCompound.getString(key);
/*     */   }
/*     */   
/*     */   public byte[] getByteArray(String key) {
/* 157 */     return this.nbtTagCompound.getByteArray(key);
/*     */   }
/*     */   
/*     */   public int[] getIntArray(String key) {
/* 162 */     return this.nbtTagCompound.getIntArray(key);
/*     */   }

public NBTTagCompound getNbtTagCompound() {
	return nbtTagCompound;
}
/*     */ }