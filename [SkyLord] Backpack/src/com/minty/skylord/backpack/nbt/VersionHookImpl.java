/*    */ package com.minty.skylord.backpack.nbt;
/*    */ 
/*    */ import java.lang.reflect.Field;

import org.bukkit.Bukkit;
/*    */ import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftInventoryView;
/*    */ import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
/*    */ import org.bukkit.inventory.InventoryView;
/*    */ import org.bukkit.inventory.ItemStack;

/*    */ import net.minecraft.server.v1_12_R1.ContainerAnvil;
/*    */ import net.minecraft.server.v1_12_R1.NBTTagCompound;
/*    */ 
/*    */ public class VersionHookImpl {
/*    */   private static Field ANVIL_RENAME_FIELD;
/*    */   
/*    */   public NBTCompound newNBTCompound() {
/* 27 */     return (NBTCompound)new NBTCompoundImpl();
/*    */   }
/*    */   
/*    */   public ItemNBTCompound newItemNBTCompound(NBTCompound nbtCompound)
			{
/* 37 */     return ItemNBTCompoundImpl.create((NBTCompoundImpl) nbtCompound);
/*    */   }
/*    */   
/*    */   public NBTCompound serializeItemNBTCompound(ItemStack itemStack) {
/* 42 */     NBTTagCompound nbtTagCompound = new NBTTagCompound();
/* 43 */     CraftItemStack.asNMSCopy(itemStack).save(nbtTagCompound);
/* 44 */     return (NBTCompound)new NBTCompoundImpl(nbtTagCompound);
/*    */   }
/*    */   
/*    */   public NBTCompound getNBTCompound(ItemStack itemStack) {
/* 49 */     return new ItemNBTCompoundImpl(itemStack);
/*    */   }
/*    */   
/*    */   
/*    */   public NBTList newNBTList() {
/* 59 */     return (NBTList)new NBTListImpl();
/*    */   }
/*    */   
/*    */   public String getAnvilViewRename(InventoryView inventoryView) {
/* 64 */     ContainerAnvil containerAnvil = (ContainerAnvil)((CraftInventoryView)inventoryView).getHandle();
/*    */     try {
/* 67 */       return (String)ANVIL_RENAME_FIELD.get(containerAnvil);
/* 68 */     } catch (IllegalAccessException e) {
/* 69 */       return "";
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setAnvilViewRename(InventoryView inventoryView, String rename) {
/* 75 */     ContainerAnvil containerAnvil = (ContainerAnvil)((CraftInventoryView)inventoryView).getHandle();
/* 76 */     containerAnvil.a(rename);
/*    */   }
/*    */   
/*    */   static {
/*    */     try {
/* 82 */       ANVIL_RENAME_FIELD = ContainerAnvil.class.getDeclaredField("l");
/* 83 */       ANVIL_RENAME_FIELD.setAccessible(true);
/* 84 */     } catch (NoSuchFieldException ex) {
/* 85 */       ex.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }