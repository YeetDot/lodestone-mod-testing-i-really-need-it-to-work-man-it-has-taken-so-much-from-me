package com.example.examplemod.block.custom;

import com.example.examplemod.lodestone_effects.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TestBlock extends Block {
    public TestBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        super.stepOn(pLevel, pPos, pState, pEntity);
        ModEffects.spawnSecondEffect(pLevel, pPos.getCenter());
    }
}
