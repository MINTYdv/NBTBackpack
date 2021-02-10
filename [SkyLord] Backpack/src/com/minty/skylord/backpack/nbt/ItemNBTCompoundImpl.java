/*    */ package com.minty.skylord.backpack.nbt;
/*    */ import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;

/*    */ import net.minecraft.server.v1_12_R1.ItemStack;
/*    */ 
/*    */ public class ItemNBTCompoundImpl extends NBTCompoundImpl implements ItemNBTCompound {
/*    */   protected ItemStack itemStack;
/*    */   
/*    */   public ItemNBTCompoundImpl(org.bukkit.inventory.ItemStack itemStack) {
/* 16 */     this(CraftItemStack.asNMSCopy(itemStack));
/*    */   }
/*    */   
/*    */   public ItemNBTCompoundImpl(ItemStack itemStack) {
/* 20 */     super(itemStack.getTag());
/* 22 */     this.itemStack = itemStack;
/*    */   }
/*    */   
/*    */   public org.bukkit.inventory.ItemStack applyChanges() {
/* 28 */     this.itemStack.setTag(this.nbtTagCompound);
/* 29 */     return CraftItemStack.asBukkitCopy(this.itemStack);
/*    */   }
/*    */   
/*    */   public static ItemNBTCompoundImpl create(NBTCompoundImpl nbtCompound) {
/* 33 */     ItemStack itemStack = CraftItemStack.asNMSCopy(ItemSerializer.deserialize(nbtCompound.getNbtTagCompound().getString("data")));
			 ItemNBTCompoundImpl result = new ItemNBTCompoundImpl(itemStack);
/* 35 */     return result;
/*    */   }
/*    */ }