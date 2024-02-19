package com.example.examplemod.lodestone_effects;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import team.lodestar.lodestone.helpers.ColorHelper;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;

import java.awt.*;
import java.util.Random;


@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExampleEffect {
    public static void spawnExampleEffect(Level level, Vec3 pos){
        Color startingColor = new Color(100, 0, 100);
        Color endingColor = new Color(0, 100, 200);
        WorldParticleBuilder.create(LodestoneParticleRegistry.STAR_PARTICLE)
                .setScaleData(GenericParticleData.create(0.5f, 0.1f).build())
                .setTransparencyData(GenericParticleData.create(1f, 0.9f, 0.25f).build())
                .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
                .setSpinData(SpinParticleData.create(0.2f, 0.4f).setSpinOffset((level.getGameTime() * 0.2f) % 6.28f).setEasing(Easing.QUARTIC_IN).build())
                .setLifetime(100)
                .addMotion(ExampleMod.randomFloat(-0.1f, 0.1f), ExampleMod.randomFloat(-0.1f, 0.1f), ExampleMod.randomFloat(-0.1f, 0.1f))
                .enableNoClip()
                .spawn(level, pos.x, pos.y, pos.z);
    }
    public static void spawnAnotherEffect(Entity entity, Level level){
        Color primaryColor = Color.blue;
        Color secondaryColor = Color.cyan;
        int adjustedLifespan = (int) (20 *0.6f);
        double posX = entity.getX();
        double posY = entity.getY();
        double posZ = entity.getZ();
        Random random;
        for (int i = 0; i <= 3; i++) {
            WorldParticleBuilder.create(LodestoneParticleRegistry.WISP_PARTICLE)
                    .setTransparencyData(GenericParticleData.create(0.05f, 0.1f, 0).build())
                    .setSpinData(SpinParticleData.create(0.025f, (0.2f * 0.05f), 0).setEasing(Easing.QUINTIC_OUT, Easing.SINE_IN).build())
                    .setScaleData(GenericParticleData.create(0.025f, 0.1f * 0.075f, 0.35f).setEasing(Easing.QUINTIC_OUT, Easing.SINE_IN).build())
                    .setColorData(ColorParticleData.create(primaryColor, secondaryColor).build())
                    .setLifetime(100)
                    .enableNoClip()
                    .setRandomOffset(0.2f, 0.2f)
                    .setRandomMotion(0.02f)
                    .repeat(level, posX, posY, posZ, (int) 4);
        }
        WorldParticleBuilder.create(LodestoneParticleRegistry.WISP_PARTICLE)
                .setTransparencyData(GenericParticleData.create(0.02f, 0.05f, 0).build())
                .setSpinData(SpinParticleData.create(0.1f, 0.4f, 0).setEasing(Easing.QUINTIC_OUT, Easing.SINE_IN).build())
                .setScaleData(GenericParticleData.create(0.15f, 0.4f, 0.35f).setEasing(Easing.QUINTIC_OUT, Easing.SINE_IN).build())
                .setColorData(ColorParticleData.create(primaryColor, secondaryColor).build())
                .setLifetime(100)
                .enableNoClip()
                .setRandomOffset(0.05f, 0.05f)
                .setRandomMotion(0.05f)
                .repeat(level, posX, posY, posZ, (int) (6));
        WorldParticleBuilder.create(LodestoneParticleRegistry.SMOKE_PARTICLE)
                .setTransparencyData(GenericParticleData.create(0, 0.05f, 0).build())
                .setSpinData(SpinParticleData.create(0.1f, 0.25f, 0).setEasing(Easing.QUINTIC_OUT, Easing.SINE_IN).build())
                .setScaleData(GenericParticleData.create(0.15f, 0.45f, 0.35f).setEasing(Easing.QUINTIC_OUT, Easing.SINE_IN).build())
                .setColorData(ColorParticleData.create(primaryColor.darker(), ColorHelper.darker(secondaryColor, 3)).build())
                .setLifetime(100)
                .enableNoClip()
                .setRandomOffset(0.15f, 0.15f)
                .setRandomMotion(0.015f, 0.015f)
                .repeat(level, posX, posY, posZ, (int) (10));
    }
}
