package com.example.examplemod.lodestone_effects;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;

import java.awt.*;


@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEffects {
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
                .repeat(level, pos.x, pos.y, pos.z, 100);
    }
    public static void spawnSecondEffect(Level level, Vec3 pos){
        Color centerColor = new Color(255, 255, 200);
        Color outerColor = Color.GRAY;
        for (int i = 0; i < 100; i++) {
            WorldParticleBuilder.create(ModParticles.WEIRD_PARTICLE)
                    .setScaleData(GenericParticleData.create(1, 10).build())
                    .setColorData(ColorParticleData.create(centerColor, centerColor).build())
                    .setTransparencyData(GenericParticleData.create(0.5f, 0.75f, 0).build())
                    .setLifetime(200)
                    .enableNoClip()
                    .addMotion(ExampleMod.randomFloat(-.1f, .1f), ExampleMod.randomFloat(-.1f, .1f), ExampleMod.randomFloat(-.1f, .1f))
                    .spawn(level, pos.x, pos.y, pos.z);
            WorldParticleBuilder.create(LodestoneParticleRegistry.SMOKE_PARTICLE)
                    .setScaleData(GenericParticleData.create(1, 5).build())
                    .setColorData(ColorParticleData.create(centerColor, outerColor).build())
                    .setTransparencyData(GenericParticleData.create(0, 0.1f, 0.2f).build())
                    .setLifetime(300)
                    .enableNoClip()
                    .addMotion(ExampleMod.randomFloat(-.1f, .1f), ExampleMod.randomFloat(-.3f, .3f), ExampleMod.randomFloat(-.1f, .1f))
                    .spawn(level, pos.x, pos.y, pos.z);
        }
    }
}
