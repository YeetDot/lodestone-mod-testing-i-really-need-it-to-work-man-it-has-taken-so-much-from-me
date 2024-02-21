package com.example.examplemod.entity;

import com.example.examplemod.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Bullet extends AbstractArrow {

    public Bullet(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return new ItemStack(ModItems.BULLET.get());
    }

    @Override
    public boolean isNoPhysics() {
        return true;
    }
}
