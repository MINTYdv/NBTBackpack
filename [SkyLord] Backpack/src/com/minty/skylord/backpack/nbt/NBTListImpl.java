/*    */ package com.minty.skylord.backpack.nbt;
/*    */ 
/*    */ import net.minecraft.server.v1_12_R1.NBTBase;
/*    */ import net.minecraft.server.v1_12_R1.NBTTagList;
/*    */ 
/*    */ public class NBTListImpl extends NBTList {
/*    */   protected NBTTagList nbtTagList;
/*    */   
/*    */   public NBTListImpl() {
/* 15 */     this(new NBTTagList());
/*    */   }
/*    */   
/*    */   protected NBTListImpl(NBTTagList nbtTagList) {
/* 19 */     this.nbtTagList = nbtTagList;
/*    */   }
/*    */   
/*    */   public void add(NBTCompound compound) {
/* 24 */     this.nbtTagList.add((NBTBase)((NBTCompoundImpl)compound).nbtTagCompound);
/*    */   }
/*    */   
/*    */   public NBTCompound get(int index) {
/* 29 */     return new NBTCompoundImpl(this.nbtTagList.get(index));
/*    */   }
/*    */   
/*    */   public int size() {
/* 34 */     return this.nbtTagList.size();
/*    */   }
/*    */ }