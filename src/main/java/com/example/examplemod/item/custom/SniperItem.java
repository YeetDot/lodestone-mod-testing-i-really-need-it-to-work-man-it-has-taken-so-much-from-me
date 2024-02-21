package com.example.examplemod.item.custom;

import com.example.examplemod.item.ModItems;
import com.example.examplemod.lodestone_effects.ModEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class SniperItem extends Item {
    public SniperItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ModEffects.spawnSecondEffect(pLevel, pPlayer.position());
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public boolean onEntitySwing(ItemStack pStack, LivingEntity entity) {
        if (entity instanceof Player player) {
            ItemStack stack = getProjectile(player);
            if (player.getAbilities().instabuild){
                shoot(player);
            } else if (!stack.isEmpty()) {
                shoot(player);
                stack.setCount(stack.getCount()-1);
            }
        }
        return super.onEntitySwing(pStack, entity);
    }

    public ItemStack getProjectile(Player player) {
        ItemStack itemStack = ItemStack.EMPTY;
        if (player.getOffhandItem().getItem() == ModItems.BULLET.get()) {
            itemStack = player.getOffhandItem();
        } else {
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                if (player.getSlot(i).get().is(ModItems.BULLET.get())) {
                    itemStack = player.getSlot(i).get();
                    break;
                }
            }
        }
        return itemStack;
    }

    private void shoot(Player owner){
        AbstractArrow bullet = new Arrow(owner.level(), owner);
        bullet.shootFromRotation(owner, owner.getXRot(), owner.getYRot(), (float) owner.getLookAngle().z, 200, 0);
        owner.level().addFreshEntity(bullet);
    }
}
